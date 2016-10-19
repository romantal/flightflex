package com.taluyev.flightflex.com.taluyev.flightflex.service.connector.com.edreams;

import com.taluyev.flightflex.com.taluyev.flightflex.data.repository.AppSettingRepositoryFactory;
import com.taluyev.flightflex.com.taluyev.flightflex.exception.FlightFlexException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by Roman_Taluiev on 10/18/2016.
 */
public class EdreamsDataProviderImpl implements EdreamsDataProvider {

    private static String BASE_URL = "http://www.edreams.com";
    private static String TRAVEL_URL = BASE_URL + "/" + "travel/";

    @Override
    public List<EdreamsFlightPlace> findFlightPlaceBySuggestion(String suggestion) {

        WebDriver webDriver = null;

        try {

            String phantomPath = AppSettingRepositoryFactory.getInstance().findByName("phantomPath").getValue();

            webDriver = (new EdreamsWebDriverBuilder()).setPhantomJSPath(phantomPath).build();

            System.out.println(String.format("Follow the url: %s", TRAVEL_URL));
            webDriver.get(TRAVEL_URL);
            System.out.println(String.format("Got Web Page with title :%s", webDriver.getTitle()));

            Thread.sleep(5000);

            WebElement airportSelectorInput = webDriver.findElement(By.cssSelector("input.od-airportselector-input.airportselector_input"));

            airportSelectorInput.sendKeys(new String[]{suggestion});

            Thread.sleep(5000);

            System.out.println(String.format("Sent keys '%s' to the current page", webDriver.getTitle()));

            List<WebElement> suggestionsItemList = webDriver.findElements(By.cssSelector(".item.od-airportselector-suggestions-item"));

            System.out.println(String.format("Elements size: %d", suggestionsItemList.size()));

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
            System.err.print(e.getStackTrace());
            throw new FlightFlexException("Can not find flight place by suggestion.", e);
        } finally {
            if (webDriver != null) {
                webDriver.quit();
            }
        }

    }
}
