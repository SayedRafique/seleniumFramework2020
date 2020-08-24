package com.google.core.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static com.google.core.setup.FrameworkConfiguration.getBrowser;

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
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }

        return driver;
    }

}
