package com.google.core.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static com.google.core.setup.FrameworkConfiguration.getBrowser;
import static com.google.core.setup.FrameworkConfiguration.getCONFIG;
import static com.google.core.utils.FileUtilities.createDirectory;

public class DriverUtilities {
    private WebDriver driver;
    private static final String driverLocation = System.getProperty("user.dir")+"/Drivers";

    //Constructor
    public DriverUtilities(){
    }

    public WebDriver createDriver(String browserName){
        browserName = (browserName != null) ? browserName :
                getBrowser();
        switch (browserName){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }

        return driver;
    }

    public static void getDriversForLocal(boolean isDebug){
        if (isDebug) {
            createDirectory(driverLocation);
            System.setProperty("wdm.cachePath",driverLocation);
            WebDriverManager.chromedriver().setup();
            WebDriverManager.firefoxdriver().setup();
            WebDriverManager.seleniumServerStandalone()
                    .driverVersion(getCONFIG().getProperty("selenium.version"))
                    .setup();

        }
    }

}
