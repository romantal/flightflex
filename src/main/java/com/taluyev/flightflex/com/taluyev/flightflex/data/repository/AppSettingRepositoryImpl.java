package com.taluyev.flightflex.com.taluyev.flightflex.data.repository;

import com.taluyev.flightflex.com.taluyev.flightflex.data.domain.AppSetting;

/**
 * Created by Roman_Taluiev on 10/18/2016.
 */
public class AppSettingRepositoryImpl implements AppSettingRepository {
    @Override
    public AppSetting findByName(String name) {

        AppSetting appSetting = new AppSetting();

        appSetting.setName(name);
        appSetting.setValue(System.getProperty(name));

        return appSetting;
    }
}
