package com.mmihaylov.mobile_import_car_tool;

import com.mmihaylov.mobile_import_car_tool.model.MobileCarResult;
import com.mmihaylov.model.enums.Currency;
import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Logger;

import static com.mmihaylov.mobile_import_car_tool.MobileCarPageContentUtil.*;

public class MobileCarImportTool {

    private static final Logger LOGGER = Logger.getLogger(MobileCarImportTool.class.getName());

    private static final MobileCarImportTool INSTANCE = new MobileCarImportTool();

    private MobileCarImportTool() {

    }

    // Public Static Methods

    public static MobileCarImportTool getInstance() {
        return INSTANCE;
    }

    // Public Methods

    public MobileCarResult importFromMobile(String carUrl) throws MobileCarImportException {
        LOGGER.info("Exporting a car from url: " + carUrl);
        // Validate the URL
        if (!UrlValidator.getInstance().isValid(carUrl)) {
            throw new MobileCarImportException("Invalid URL: " + carUrl);
        }
        if (!isMobileDeUrl(carUrl)) {
            throw new MobileCarImportException("The URL doesn't point to Mobile.de: " + carUrl);
        }

        // load the url with Jsoup, then select the information for the car.
        try {
            Document document = Jsoup.connect(carUrl).timeout(10000).get();
            // brand
            String brand = getCarBrand(document);
            // car model
            String carModel = getCarModel(document);
            // price
            Long price = getPrice(document);
            // currency (hardcoded EUR)
            Currency currency = Currency.EUR;
            // color
            String color = getColor(document);
            // registration
            Date registration = getFirstRegistration(document);
            // mileage
            Long mileage = getMileage(document);
            // get images


        } catch (IOException ioe) {
            LOGGER.severe(ioe.getMessage());
            throw new MobileCarImportException("Failed to get data from url: " + carUrl, ioe);
        }
        return null;
    }

    // Private Methods

    private boolean isMobileDeUrl(String url) throws MobileCarImportException {
        try {
            URL aURL = new URL(url);
            return "mobile.de".equalsIgnoreCase(aURL.getHost());
        } catch (MalformedURLException exc) {
            LOGGER.severe("Failed to parse the URL: " + url);
            throw new MobileCarImportException("Failed to parse the URL: " + url, exc);
        }
    }
}
