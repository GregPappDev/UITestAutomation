package utils;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.BrowserType;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverSetup {

    public static RemoteWebDriver driver;
    final private String remoteDriverUrl = "http://localhost:4445";

    public static RemoteWebDriver launchRemoteWebDriver(String browserType) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(browserType.equalsIgnoreCase("chrome")){
            capabilities.setBrowserName(BrowserType.CHROME);
        } else if(browserType.equalsIgnoreCase("firefox")){
            capabilities.setBrowserName(BrowserType.FIREFOX);
        } else {
            capabilities.setBrowserName(BrowserType.EDGE);
        }

        System.out.println(("Test Case Execution Started On ==> " + browserType));
        driver = new RemoteWebDriver(new URL("http://localhost:4445"), capabilities);

        return driver;
    }
}
