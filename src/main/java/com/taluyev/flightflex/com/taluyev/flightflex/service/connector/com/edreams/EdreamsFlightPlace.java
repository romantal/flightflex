package com.taluyev.flightflex.com.taluyev.flightflex.service.connector.com.edreams;

/**
 * Created by Roman_Taluiev on 10/18/2016.
 */
public class EdreamsFlightPlace {

    String title;
    String geoNodeId;
    //Natural key
    String iata;
    String city;
    String country;
    String countryCode;
    String name;
    String type;
    String matchType;
    String geoNodeType;
    String itemLevel;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGeoNodeId() {
        return geoNodeId;
    }

    public void setGeoNodeId(String geoNodeId) {
        this.geoNodeId = geoNodeId;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getGeoNodeType() {
        return geoNodeType;
    }

    public void setGeoNodeType(String geoNodeType) {
        this.geoNodeType = geoNodeType;
    }

    public String getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(String itemLevel) {
        this.itemLevel = itemLevel;
    }

}
