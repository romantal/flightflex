package com.taluyev.flightflex.crawler.crawler;

import org.junit.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Roman_Taluiev on 10/18/2016.
 */
public class PhantomJSTest {
    @Test
    public void testPhantomJS() throws Exception {

        String phantomPath = "D:/usr/local/phantomjs-2.1.1-windows/bin/phantomjs.exe";

        File file = new File(phantomPath);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, file.getAbsolutePath());

        desiredCapabilities.setCapability("takesScreenshot", false);
        String[] args = {"--ignore-ssl-errors=yes"};
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, args);
        desiredCapabilities.setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 5.1; rv:22.0) Gecko/20100101 Firefox/22.0");

        PhantomJSDriver phantomJSDriver = new PhantomJSDriver(desiredCapabilities);

        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, file.getAbsolutePath());
        //WebDriver webDriver = new PhantomJSDriver(desiredCapabilities);

        phantomJSDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String baseURL = "http://www.edreams.com";

        phantomJSDriver.get(baseURL + "/" + "travel/");

        //od-flightsManager-search-flight-button od-button-overlay search_flight_button

        phantomJSDriver.quit();

        //Getting all the links present in the page by a HTML tag.
        //java.util.List  links = driver.findElements(By.tagName("a"));


        //phantomJSDriver.

//Session.negotiatedCapabilities - {"browserName":"phantomjs","version":"2.1.1","driverName":"ghostdriver","driverVersion":"1.2.0","platform":"windows-10-32bit","javascriptEnabled":true,"takesScreenshot":false,"handlesAlerts":false,"databaseEnabled":false,"locationContextEnabled":false,"applicationCacheEnabled":false,"browserConnectionEnabled":false,"cssSelectorsEnabled":true,"webStorageEnabled":false,"rotatable":false,"acceptSslCerts":false,"nativeEvents":true,"proxy":{"proxyType":"direct"},"phantomjs.page.settings.userAgent":"Mozilla/5.0 (Windows NT 5.1; rv:22.0) Gecko/20100101 Firefox/22.0"}

    }

}