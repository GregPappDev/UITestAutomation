package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;

public class SetupRemoteWebDriver {
    final private static URI gridUrl = URI.create("http://localhost:4445");
    public WebDriver driver;
    @Parameters("browser")
    @BeforeTest
    public void driverSetup(String browserType) throws MalformedURLException {
        RemoteWebDriver driver;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(browserType.equalsIgnoreCase("chrome")){
            capabilities.setBrowserName(BrowserType.CHROME);
            System.out.println(("Test Case Execution Started On ==> " + browserType));
        } else if(browserType.equalsIgnoreCase("firefox")){
            capabilities.setBrowserName(BrowserType.FIREFOX);
            System.out.println(("Test Case Execution Started On ==> " + browserType));
        } else {
            capabilities.setBrowserName(BrowserType.EDGE);
            System.out.println(("Test Case Execution Started On ==> " + browserType));
        }

        driver = new RemoteWebDriver(gridUrl.toURL(), capabilities);

    }


}
