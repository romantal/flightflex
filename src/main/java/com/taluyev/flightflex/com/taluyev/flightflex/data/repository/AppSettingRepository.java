package com.taluyev.flightflex.com.taluyev.flightflex.data.repository;

import com.taluyev.flightflex.com.taluyev.flightflex.data.domain.AppSetting;

/**
 * Created by Roman_Taluiev on 10/18/2016.
 */
public interface AppSettingRepository {

    AppSetting findByName(String name);

}
