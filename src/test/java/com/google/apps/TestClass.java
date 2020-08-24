package com.google.apps;

import com.google.core.utils.DriverUtilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import static com.google.core.setup.FrameworkConfiguration.*;

public class TestClass {
    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethodSetup(String browser) throws IOException {
        if(browser == null){
            browser = getBrowser();
        }
        initialize();
        setWebDriver((RemoteWebDriver) new DriverUtilities().createDriver(browser));

    }

    @Test
    public void testExample() throws InterruptedException, IOException {
        System.out.println("This is test one");
        getDriver().get("https://google.com");
        Thread.sleep(5000);
        getDriver().quit();
    }

    @Test
    public void testExample2() throws InterruptedException, IOException {
        System.out.println("This is test two");
        initialize();
        getDriver().get("https://google.com");
        Thread.sleep(5000);
        getDriver().quit();
    }

    @Test
    public void testExample3() throws InterruptedException, IOException {
        System.out.println("This is test three");
        initialize();
        getDriver().get("https://google.com");
        Thread.sleep(5000);
        getDriver().quit();
    }

}
