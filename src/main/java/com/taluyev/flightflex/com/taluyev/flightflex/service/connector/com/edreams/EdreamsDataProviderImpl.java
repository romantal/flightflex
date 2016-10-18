package com.taluyev.flightflex.com.taluyev.flightflex.service.connector.com.edreams;

import com.taluyev.flightflex.com.taluyev.flightflex.data.repository.AppSettingRepositoryFactory;
import com.taluyev.flightflex.com.taluyev.flightflex.exception.FlightFlexException;
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

        WebDriver webDriver = null;

        try {

        String phantomPath = AppSettingRepositoryFactory.getInstance().findByName("phantomPath").getValue();

        File file = new File(phantomPath);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, file.getAbsolutePath());

        desiredCapabilities.setCapability("takesScreenshot", false);
        String[] args = {"--ignore-ssl-errors=yes"};
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, args);
        desiredCapabilities.setCapability("phantomjs.page.settings.userAgent", USER_AGENT);

        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, file.getAbsolutePath());
        webDriver = new PhantomJSDriver(desiredCapabilities);

        webDriver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        webDriver.get(TRAVEL_URL);

        webDriver.findElement(By.cssSelector("input.od-airportselector-input.airportselector_input")).sendKeys(new String[]{suggestion});

        List<WebElement> suggestionsItemList = webDriver.findElements(By.cssSelector(".item.od-airportselector-suggestions-item"));

        List<EdreamsFlightPlace> result = new ArrayList<EdreamsFlightPlace>();

        for (WebElement element : suggestionsItemList) {
            EdreamsFlightPlace edreamsFlightPlace = new EdreamsFlightPlace();

            edreamsFlightPlace.setName(element.getAttribute("title"));
            edreamsFlightPlace.setGeoNodeId(element.getAttribute("data-geo-node-id"));
            edreamsFlightPlace.setIata(element.getAttribute("data-iata"));
            edreamsFlightPlace.setCity(element.getAttribute("data-city"));
            edreamsFlightPlace.setCountry(element.getAttribute("data-country"));
            edreamsFlightPlace.setCountryCode(element.getAttribute("data-country-code"));
            edreamsFlightPlace.setName(element.getAttribute("data-name"));
            edreamsFlightPlace.setType(element.getAttribute("data-type"));
            edreamsFlightPlace.setMatchType(element.getAttribute("data-match-type"));
            edreamsFlightPlace.setGeoNodeType(element.getAttribute("data-geo-node-type"));
            edreamsFlightPlace.setItemLevel(element.getAttribute("data-item-level"));
            edreamsFlightPlace.setTitle(element.getAttribute("title"));

            result.add(edreamsFlightPlace);
        }

        return result;

        } catch (Exception e) {
            throw new FlightFlexException("Can not find flight place by suggestion.", e);
        } finally {
            if (webDriver != null) {
                webDriver.quit();
            }
        }

    }
}
