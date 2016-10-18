package com.taluyev.flightflex.com.taluyev.flightflex.service.connector.com.edreams;

import com.taluyev.flightflex.com.taluyev.flightflex.data.repository.AppSettingRepositoryFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Roman_Taluiev on 10/18/2016.
 */
public class EdreamsDataProviderImpl implements EdreamsDataProvider {

    private static String BASE_URL = "http://www.edreams.com";
    private static String TRAVEL_URL = BASE_URL + "/" + "travel/";
    private static String USER_AGENT = "Mozilla/5.0 (Windows NT 5.1; rv:22.0) Gecko/20100101 Firefox/22.0";
    private static long TIMEOUT = 30;

    @Override
    public List<EdreamsFlightPlace> findFlightPlaceBySuggestion(String suggestion) {

        String phantomPath = AppSettingRepositoryFactory.getInstance().findByName("phantomPath").getValue();

        File file = new File(phantomPath);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, file.getAbsolutePath());

        desiredCapabilities.setCapability("takesScreenshot", false);
        String[] args = {"--ignore-ssl-errors=yes"};
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, args);
        desiredCapabilities.setCapability("phantomjs.page.settings.userAgent", USER_AGENT);

        PhantomJSDriver phantomJSDriver = new PhantomJSDriver(desiredCapabilities);

        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, file.getAbsolutePath());
        WebDriver webDriver = new PhantomJSDriver(desiredCapabilities);

        webDriver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        phantomJSDriver.get(TRAVEL_URL);

        phantomJSDriver.findElement(By.cssSelector("input.od-airportselector-input.airportselector_input")).sendKeys(suggestion);


        List<WebElement> suggestionsItemList = phantomJSDriver.findElementsByCssSelector(".item.od-airportselector-suggestions-item");

        List<EdreamsFlightPlace> result = new ArrayList<EdreamsFlightPlace>();

        for (WebElement element : suggestionsItemList) {
            EdreamsFlightPlace edreamsFlightPlace = new EdreamsFlightPlace();

            edreamsFlightPlace.setName(element.getAttribute("title"));
            edreamsFlightPlace.setGeoNodeId(element.getAttribute("data-geo-node-id"));
            edreamsFlightPlace.setIata(element.getAttribute("data-iata"));
            edreamsFlightPlace.setCity(element.getAttribute("data-city"));

/*
            data-city="London"
            data-country="United Kingdom"
            data-country-code="GB"
            data-name="Gatwick" data-text="Gatwick"
            data-type="AIRPORT"
            data-match-type="CITY"
            data-geo-node-type="AIRPORT"
            data-item-level="subItem" "mainItem"
*/






            result.add(edreamsFlightPlace);
        }

        phantomJSDriver.findElementsByCssSelector(".item.od-airportselector-suggestions-item").get(10).getAttribute("data-iata");

        //od-flightsManager-search-flight-button od-button-overlay search_flight_button

        webDriver.quit();

        //Getting all the links present in the page by a HTML tag.
        //java.util.List  links = driver.findElements(By.tagName("a"));


        //phantomJSDriver.

//Session.negotiatedCapabilities - {"browserName":"phantomjs","version":"2.1.1","driverName":"ghostdriver","driverVersion":"1.2.0","platform":"windows-10-32bit","javascriptEnabled":true,"takesScreenshot":false,"handlesAlerts":false,"databaseEnabled":false,"locationContextEnabled":false,"applicationCacheEnabled":false,"browserConnectionEnabled":false,"cssSelectorsEnabled":true,"webStorageEnabled":false,"rotatable":false,"acceptSslCerts":false,"nativeEvents":true,"proxy":{"proxyType":"direct"},"phantomjs.page.settings.userAgent":"Mozilla/5.0 (Windows NT 5.1; rv:22.0) Gecko/20100101 Firefox/22.0"}

        return result;
    }
}
