package com.taluyev.flightflex.com.taluyev.flightflex.data.repository;

/**
 * Created by Roman_Taluiev on 10/18/2016.
 */
public class AppSettingRepositoryFactory {

    private static class AppSettingRepositorySingletonHolder {
        public static final AppSettingRepository HOLDER_INSTANCE = new AppSettingRepositoryImpl();
    }

    public static AppSettingRepository getInstance() {
        return AppSettingRepositorySingletonHolder.HOLDER_INSTANCE;
    }

}
