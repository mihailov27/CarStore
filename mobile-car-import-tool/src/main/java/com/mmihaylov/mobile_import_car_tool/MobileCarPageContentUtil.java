package com.mmihaylov.mobile_import_car_tool;

import com.mmihaylov.mobile_import_car_tool.model.MobileCarImage;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

public class MobileCarPageContentUtil {

    private static final Logger LOGGER = Logger.getLogger(MobileCarPageContentUtil.class.getName());

    private static SimpleDateFormat SDF = new SimpleDateFormat("MM/yyyy");

    private static final int MAX_IMAGES = 5;

    private MobileCarPageContentUtil() {

    }

    // Public Static Methods

    public static String getCarBrand(Document document) throws IOException {
        Element element = document.selectFirst("meta[property='og:title']");
        if (element == null || element.attr("name") == null) {
            throw new IOException("Car Brand element is not found.");
        }
        return element.attr("name");
    }

    public static String getCarModel(Document document) throws IOException {
        Element element = document.getElementById("rbt-ad-title");
        if (element == null) {
            throw new IOException("Car Model is not found.");
        }
        return element.text();
    }

    public static Long getPrice(Document document) throws IOException {
        Element element = document.selectFirst("div#rbt-pt-v span");
        if (element == null) {
            throw new IOException("Car Price is not found.");
        }

        try {
            Number number = NumberFormat.getCurrencyInstance(Locale.GERMANY).parse(element.text());
            return number.longValue();
        } catch(ParseException pe) {
            LOGGER.severe("Failed to parse the element: " + element.text());
            throw new IOException("Failed to parse the car price: " + element.text());
        }
    }

    public static String getColor(Document document) throws IOException {
        Element element = document.selectFirst("div#rbt-color-v");
        if (element == null || StringUtils.isBlank(element.text())) {
            throw new IOException("Car Color is not found.");
        }
        return element.text();
    }

    public static Date getFirstRegistration(Document document) throws IOException {
        Element element = document.selectFirst("div#rbt-firstRegistration-v");
        if (element == null || StringUtils.isBlank(element.text())) {
           throw new IOException("The First Registration is not found.");
        }
        return parseRegDate(element.text());
    }

    public static Long getMileage(Document document) throws IOException {
        Element element = document.selectFirst("div#rbt-mileage-v");
        if (element == null || StringUtils.isBlank(element.text())) {
            throw new IOException("Failed to the Mileage.");
        }
        String text = element.text();
        String cleanText = text.replaceAll("\\D+", "");
        return new Long(cleanText);
    }

    public  static  List<MobileCarImage> loadCarImages(Document document) throws IOException {
        Elements elements = document.select("div.image-gallery div.gallery-img-wrapper img");
        LOGGER.info("Count of loaded images: " + elements.size());
        List<Element> imageElements = new ArrayList<>(elements);
        if (imageElements.size() > MAX_IMAGES) {
            imageElements = imageElements.subList(0, MAX_IMAGES);
        }

        List<MobileCarImage> mobileCarImageList = new ArrayList<>();
        for (Element element : imageElements) {
            try {
                MobileCarImage mobileCarImage = loadImageFromElement(element);
                if (mobileCarImage != null && mobileCarImage.getImgBytes() != null) {
                    mobileCarImageList.add(mobileCarImage);
                }
            } catch (IOException ioe) {
                LOGGER.severe("Failed to get image from element: " + element.html());
            }
        }

        if (mobileCarImageList.isEmpty()) {
            throw new IOException("Failed to download any images.");
        }

        return mobileCarImageList;
    }

    // Private Static Methods

    private static synchronized Date parseRegDate(String dateAsStr) throws IOException {
        try {
            return SDF.parse(dateAsStr);
        } catch (ParseException pe) {
            LOGGER.severe("Failed to parse reg.date: " + dateAsStr + "\n" + pe);
            throw new IOException("Failed to parse reg.date: " + dateAsStr );
        }
    }

    private static MobileCarImage loadImageFromElement(Element element) throws IOException {
        String source = element.attr("src");
        if (StringUtils.isBlank(source)) {
            throw new IOException("The element has no src attribute." + element.html());
        }
        if (source.startsWith("//")) {
            source = source.replaceFirst("//", "");
        }
        byte[] imgBytes = readImgFromUrlAddress(source);
        return new MobileCarImage(imgBytes);
    }

    private static byte[] readImgFromUrlAddress(String urlText) throws IOException {
        URL url = new URL(urlText);
        return IOUtils.toByteArray(url);
    }

}