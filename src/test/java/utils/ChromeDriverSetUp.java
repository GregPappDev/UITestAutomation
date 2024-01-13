package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverSetUp {
    public static WebDriver driver;

    public static WebDriver launchChromeDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
