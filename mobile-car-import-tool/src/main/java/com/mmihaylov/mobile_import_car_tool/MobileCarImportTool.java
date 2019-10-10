package com.mmihaylov.mobile_import_car_tool;

import com.mmihaylov.mobile_import_car_tool.model.MobileCarImage;
import com.mmihaylov.mobile_import_car_tool.model.MobileCarResult;
import com.mmihaylov.model.enums.Currency;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import static com.mmihaylov.mobile_import_car_tool.MobileCarPageContentUtil.*;

public class MobileCarImportTool {

    private static final Logger LOGGER = Logger.getLogger(MobileCarImportTool.class.getName());

    private static final MobileCarImportTool INSTANCE = new MobileCarImportTool();

    private Map<String, String> mobileDeCookiesMap;

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

            Connection.Response response = Jsoup.connect(carUrl)
                    .method(Connection.Method.GET)
                    .timeout(15000)
                    .cookies(getMobileDeCookies())
                    .execute();

            Document document = response.parse();

            MobileCarResult mobileCarResult = new MobileCarResult();
            mobileCarResult.setBrand(getCarBrand(document));
            mobileCarResult.setModel(getCarModel(document));
            mobileCarResult.setPrice(getPrice(document));
            mobileCarResult.setCurrency(Currency.EUR);
            mobileCarResult.setColor(getColor(document));
            mobileCarResult.setFirstRegistration(getFirstRegistration(document));
            mobileCarResult.setMileage(getMileage(document));
            // get images
            List<MobileCarImage> mobileCarImageList = MobileCarPageContentUtil.loadCarImages(document);
            mobileCarResult.setMobileCarImageList(mobileCarImageList);

            return mobileCarResult;
        } catch (IOException ioe) {
            LOGGER.severe(ioe.getMessage());
            throw new MobileCarImportException("Failed to get data from url: " + carUrl, ioe);
        }
    }

    // Private Methods

    private boolean isMobileDeUrl(String url) throws MobileCarImportException {
        try {
            URL aURL = new URL(url);
            return StringUtils.isNoneBlank(aURL.getHost()) && aURL.getHost().endsWith("mobile.de");
        } catch (MalformedURLException exc) {
            LOGGER.severe("Failed to parse the URL: " + url);
            throw new MobileCarImportException("Failed to parse the URL: " + url, exc);
        }
    }

    private Map<String, String> getMobileDeCookies() {


//        cookiesMap.put("1P_JAR", "2019-10-8-6");
//        cookiesMap.put("APISID", "JnYEVQz2jFHCeZwo/AjvdY5dmFRWTB4_QI");
//        cookiesMap.put("CONSENT", "YES+BG.en+20150803-20-0");
//        cookiesMap.put("DV", "A10HE2m9tQZNUP5Ji-7m9IiXtpCg2hbWSxWyBWS9OAQAAJABYFJvLZNWFQEAAIBB6ml0JdwpWgAAAA");
//        cookiesMap.put("HSID", "AiDzRP4AOVXNPeal0");
//        cookiesMap.put("NID", "188=VVCIuMNMV87SaF7Cu5jQfvtq06lWDyVYDy5Kh5IKTOthuizDxqzNEmFkIqSNYFjaqmI1RhRF6ox47fl-aotBNHoP2kF1ok5_X5OvddsrM9CCFZiIYQj1VkcWq1gX5jczQ6V9TjrErMZBxzs4NIcknVtkYYtgiFzhpdoI_x9ny0zkTxc7pZhSNLzKSgGNTh5YI9u04tqvnJt5movOz9Gp4WggIf-vHrF2LlClnWDdiYsPI3cY98s8vQm4q7k-dAFX");
//        cookiesMap.put("SAPISID", "NkSXSokSKd366CN8/AWm_d43PDHxSLn23L");
//        cookiesMap.put("SEARCH_SAMESITE", "CgQI-40B");
//        cookiesMap.put("SID", "pAfaQ1RlZNKBka-kVlaFRJahOJIapKe67f5b1vySp8gOgkWyG7oyxpdQ4g8IBg6x-Per-Q.");
//        cookiesMap.put("SIDCC", "AN0-TYs3KsgTZymLujFkl7rb4EVJOy-O9tdNUzZVgGVJBBPw4coRox3hVg2GdGu61tv9cT7zBpk");
//        cookiesMap.put("SSID", "ACMnhopjTsOOjcSFw");
//        cookiesMap.put("_abck", "CF01E87811C47AC4414F4393350F6260~0~YAAQHxMQAsfqd4NtAQAA5kB1oAK3n1RsAgMqf4ehM5jns4M4M2hUJASGRq31eCR4dQE/sHx1nwp+LtwpZNY3Gv87JbYMccvhSC0OLzpAodA4DqIuXJq0ds/WobCzOISCvk6VTF4I0rI7phOG0YXlZf/SK00EYrROq1OTdJH56XzK/Dsd/OdNGLI0uloib4cr+RJIMti0PcJXZNPaFlKAdguVXt5f3L9saZ6FBVF36G9B3WVnD4/TfhVaP8apKA3JVGnrCajntkqY0TK4FP/1p+5Uh7BEUwjdX+rs0IuYtHwk~-1~-1~-1");
//        cookiesMap.put("ak_bmsc", "B210504EDC5DC1FB9D13D8FF4F24DD810210131F541A0000D0259C5DA2CB1F1A~plGcWn6M55lw0w0I6u7ahUCwEJq3issvC+t8sb4ydKhihF68/uXNh4b/6Fu2bFjxrwjNgn3eNpCeSvm2H5Oahu4XA5X1J/aHqQTozBtZ55k8dAEl+ijnaAqWhuoM481svccvfwmrBOpj1zZUHk1rabWPjVLkxRgOmaVzwofI62Rm1Ph7I/mhUBAMlG+jBuBYeoligO42uve05y7cNutpTy6crno9Aiai/+7/0r4i9JBr4=");
//        cookiesMap.put("bm_mi", "CDA92507E77985A69C4493FEAF6DDF2A~LKbRqMZBJP15KXebHHY6kU0akCuowzIn3WMc5E63Ax3OLa34NOuz9ywri2BuGvakyYT5nN+WCWJ3nPxZ5FFTto7IUOxVCRgKG5E9ml4Mi7s1TraCGaLiHyBVZFnubrohsoE5GsHHCMKHaaoH5aVVGLjG8G+pBYMLlT6td9k+OlJfq4cQ3TAL+FthBxyQ6eQKJoAjfj6skVzJl6A5yCJRl3unJ5cumRgngoQbHac64IXzO4TpnnA5yfmaFZmyMEryUqffg2tlARNwowjryfonEmr3MNWMi+4llYHEO454d9R6Mnfx3rEpyoJ3WckPYJDtW9WYPyUN2FOXXG8dxpuAIQ6DzTs2H4JpCDq/V++DNt0=");
//        cookiesMap.put("bm_sv", "6208758BA25A03B717F19BCAFB53CC9E~lTdGKZ4iQ4tXeD5zkdo2696tN7mxUs6TPYEgB0jSQjj4t3biE4asuBWqiBVCpT0iwN8bYypr8miAxo8zUQLD/aoC4PRqLCgii9SmCJ388osSbE60MUSxt6BvbZgwmh7NxDT2fXQqayfhDwTHASH72R+pT8M1IW8js+Vo1cf4DHY=");
//        cookiesMap.put("bm_sz", "FC557AB165A5EC228AD0FC96C0F99FE0~YAAQHxMQAj17ioNtAQAAQ7XzqQUmhuUa6CJiWuxfFt+7BSXypZB51GBx9jDqVt7MkBkX8goisMfEPbdzsCr1oq/LCGfkbP8druRSTaiS+bQdMVLj6S/xOrisgUK7cfv3cs4eGVaOAtIkbPWqT/7MmZg1PRkCnieG6vpEiZoLBwxte0eO3bWgo9POv9velh8=");
//        cookiesMap.put("mdeConsentData", "BOoGak3OoGak3B9ABBDECn-AAAAqx7_______9______9uz_Ov_v_f__33e8__9v_l_7_-___u_-3zd4u_1vf99yfm1-7etr3tp_87ues2_Xur__79__3z3_9phP78k89r7337Ew-v-3o8KA");
//        cookiesMap.put("mdeCustomConsentData", "25%2C27");
//        cookiesMap.put("mobile.LOCALE", "de");
//        cookiesMap.put("us", "9624264012");
//        cookiesMap.put("vi", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJjZWJmMmVjYS00OTMxLTRhOTktODQ0Zi0zNTEwMDZjYjlkMGIiLCJhdWQiOltdLCJpYXQiOjE1NzA1MTU1ODl9.dSiB92Tl5OFvWViwIskt5EPZWIbiskw_hKexp4FKfXQ");
//        cookiesMap.put("visited", "1");

        if (mobileDeCookiesMap == null) {
            mobileDeCookiesMap = new HashMap<>();
            Properties properties = getPropertiesCookiesFiles();
            for (Map.Entry entry: properties.entrySet()) {
                mobileDeCookiesMap.put( (String) entry.getKey(), (String) entry.getValue());
            }
        }

        return mobileDeCookiesMap;
    }

    private Properties getPropertiesCookiesFiles() {
        File file = new File(getClass().getClassLoader().getResource("mobile_de_cookies.properties").getFile());
        try(InputStream is = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(is);
            return properties;
        } catch (IOException ioe) {
            LOGGER.severe("Failed to load cookies file.\n" + ioe.getMessage());
            throw new IllegalStateException("Cookies file not loaded");
        }
    }
}
