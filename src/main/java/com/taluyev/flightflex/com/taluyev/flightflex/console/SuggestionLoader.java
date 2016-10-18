package com.taluyev.flightflex.com.taluyev.flightflex.console;

import com.taluyev.flightflex.com.taluyev.flightflex.service.connector.com.edreams.EdreamsDataProviderFactory;
import com.taluyev.flightflex.com.taluyev.flightflex.service.connector.com.edreams.EdreamsFlightPlace;

import java.util.List;

/**
 * Created by Roman_Taluiev on 10/18/2016.
 */
public class SuggestionLoader {

    private static String PHANTOM_PATH = "src/test/bin/phantomjs.exe";

    public static void main(String[] args) {

        System.setProperty("phantomPath", PHANTOM_PATH);

        List<EdreamsFlightPlace> edreamsFlightPlaceList = EdreamsDataProviderFactory.getInstance().findFlightPlaceBySuggestion(args[1]);

        for (EdreamsFlightPlace edreamsFlightPlace : edreamsFlightPlaceList) {
            System.out.println(String.format("%s,%s", edreamsFlightPlace.getIata(), edreamsFlightPlace.getTitle()));
        }
    }

}
