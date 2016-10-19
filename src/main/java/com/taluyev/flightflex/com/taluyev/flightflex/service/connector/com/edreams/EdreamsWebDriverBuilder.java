package com.taluyev.flightflex.com.taluyev.flightflex.service.connector.com.edreams;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Roman_Taluiev on 10/19/2016.
 */
public class EdreamsWebDriverBuilder {

    public static final String BROWSER_NAME = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36";
    private String phantomJSPath;
    private int phantomJSPort = 8990;
    private long implicitlyWaitSeconds = 20;


    public EdreamsWebDriverBuilder setPhantomJSPath(String phantomJSPath) {
        this.phantomJSPath = phantomJSPath;
        return this;
    }

    public EdreamsWebDriverBuilder setPhantomJSPort(int port) {
        phantomJSPort = port;
        return this;
    }

    public EdreamsWebDriverBuilder setImplicitlyWaitSeconds(long time) {
        implicitlyWaitSeconds = time;
        return this;
    }

    WebDriver build() {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        capabilities.setCapability(CapabilityType.BROWSER_NAME, BROWSER_NAME);
        capabilities.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
        capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, false);
        capabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_SQL_DATABASE, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_LOCATION_CONTEXT, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
        //capabilities.setCapability(CapabilityType.PROXY, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_WEB_STORAGE, true);
        capabilities.setCapability(CapabilityType.ROTATABLE, false);
        //Enable this capability to accept all SSL certs by defaults.
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
        capabilities.setCapability(CapabilityType.HAS_TOUCHSCREEN, false);

        //String UNEXPECTED_ALERT_BEHAVIOUR = "unexpectedAlertBehaviour";
        //String ELEMENT_SCROLL_BEHAVIOR = "elementScrollBehavior";
        //String LOGGING_PREFS = "loggingPrefs";
        //String ENABLE_PROFILING_CAPABILITY = "webdriver.logging.profiler.enabled";
        //String PAGE_LOADING_STRATEGY = "pageLoadingStrategy";

        PhantomJSDriverService.Builder builder = new PhantomJSDriverService.Builder();

        File file = new File(phantomJSPath);
        builder.usingPhantomJSExecutable(file);
        builder.usingPort(phantomJSPort);

        PhantomJSDriverService phantomJSDriverService = builder.build();

        PhantomJSDriver driver = new PhantomJSDriver(phantomJSDriverService, capabilities);

        driver.manage().timeouts().implicitlyWait(implicitlyWaitSeconds, TimeUnit.SECONDS);

        return driver;
    }

}
