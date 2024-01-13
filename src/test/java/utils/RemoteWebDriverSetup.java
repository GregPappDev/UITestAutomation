package utils;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverSetup {

    public static RemoteWebDriver driver;
    final private String remoteDriverUrl = "http://localhost:4445";

    public static RemoteWebDriver launchRemoteWebDriver(String browserType) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();


        driver = new RemoteWebDriver(new URL("http://localhost:4445"), capabilities);

        return driver;
    }
}
