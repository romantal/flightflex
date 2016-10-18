package com.taluyev.flightflex.crawler.crawler;

import com.taluyev.flightflex.com.taluyev.flightflex.service.connector.com.edreams.EdreamsDataProviderFactory;
import com.taluyev.flightflex.com.taluyev.flightflex.service.connector.com.edreams.EdreamsFlightPlace;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Roman_Taluiev on 10/18/2016.
 */
public class PhantomJSTest {

    private static String PHANTOM_PATH = "src/test/bin/phantomjs.exe";
    private static String suggestion = "London";

    @Test
    public void testPhantomJS() throws Exception {
        System.setProperty("phantomPath", PHANTOM_PATH);
        List<EdreamsFlightPlace> edreamsFlightPlaceList = EdreamsDataProviderFactory.getInstance().findFlightPlaceBySuggestion(suggestion);
        Assert.assertTrue(edreamsFlightPlaceList.size() > 0);
    }

}