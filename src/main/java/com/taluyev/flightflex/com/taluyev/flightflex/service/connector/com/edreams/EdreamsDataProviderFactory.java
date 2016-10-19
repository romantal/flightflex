package com.taluyev.flightflex.com.taluyev.flightflex.service.connector.com.edreams;

/**
 * Created by Roman_Taluiev on 10/18/2016.
 */
public class EdreamsDataProviderFactory {

    private static class EdreamsDataProviderSingletonHolder {
        public static final EdreamsDataProvider HOLDER_INSTANCE = new EdreamsDataProviderImpl();
    }

    public static EdreamsDataProvider getInstance() {
        return EdreamsDataProviderSingletonHolder.HOLDER_INSTANCE;
    }

}
