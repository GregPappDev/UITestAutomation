package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LogInPage;
import services.LogInService;


import java.net.MalformedURLException;
import java.net.URL;

public class LogInTest {

    public WebDriver driver;
    private LogInService logInService;
    private LogInPage logInPage;
    private WebDriverWait wait;

    @Parameters("browser")
    @BeforeTest

    public void setup(String browserType) throws MalformedURLException{
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

        driver = new RemoteWebDriver(new URL("http://localhost:4445"), capabilities);
        logInPage = new LogInPage(driver);
        wait = new WebDriverWait(driver, 5);
        logInService = new LogInService(driver, logInPage, wait);
    }


    @Test
    public void LoginToWebsite_Successful_WithValidCredentials() throws InterruptedException {

        logInService.loginToWebsite("standard_user", "secret_sauce");

        String title = driver.findElement(By.className("title")).getText();

        Assert.assertEquals(title, "Products");

    }


    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
