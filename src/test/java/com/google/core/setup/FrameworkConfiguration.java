package com.google.core.setup;

import com.google.core.utils.DriverUtilities;
import com.google.core.utils.FileUtilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.util.Properties;


public class FrameworkConfiguration {
    private static String configFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
    private static Properties CONFIG = null;
    private static ThreadLocal<RemoteWebDriver> threadLocalDriver = new ThreadLocal<>();




    // Initialized method
    public static void initialize() throws IOException {
        FileUtilities  fileUtilities = new FileUtilities();
        DriverUtilities driverUtilities = new DriverUtilities();
        setCONFIG(fileUtilities.updatePropertyFile(CONFIG,configFilePath));
        setWebDriver((RemoteWebDriver) driverUtilities.createDriver(getBrowser()));
    }


    //Setters
    public static void setCONFIG(Properties CONFIG) {
        FrameworkConfiguration.CONFIG = CONFIG;
    }

    public static void setWebDriver(RemoteWebDriver driver){
        threadLocalDriver.set(driver);
    }

    //Getters
    public static Properties getCONFIG() {
        return CONFIG;
    }
    public static boolean isDebug() {
        return Boolean.parseBoolean(getCONFIG().getProperty("debug"));
    }

    public static String getBrowser() {
        return getCONFIG().getProperty("browser");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(getCONFIG().getProperty("headless"));
    }

    public static RemoteWebDriver getDriver(){
        return threadLocalDriver.get();
    }
}
