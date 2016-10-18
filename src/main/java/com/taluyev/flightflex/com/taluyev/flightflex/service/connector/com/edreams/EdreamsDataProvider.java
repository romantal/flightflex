package com.taluyev.flightflex.com.taluyev.flightflex.service.connector.com.edreams;

import java.util.List;

/**
 * Created by Roman_Taluiev on 10/18/2016.
 */
public interface EdreamsDataProvider {

    List<EdreamsFlightPlace> findFlightPlaceBySuggestion(String suggestion);

}
