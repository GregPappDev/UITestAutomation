package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LogInPage;
import services.LogInService;
import utils.SetupRemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URI;


public class LogInTest {

    public WebDriver driver;
    private LogInService logInService;
    private LogInPage logInPage;
    private WebDriverWait wait;
    final private URI gridUrl = URI.create("http://localhost:4445");

    @Parameters("browser")
    @BeforeTest

    public void setup(String browserType) throws MalformedURLException{
        if(this.driver != null) driver.close();

        driver = SetupRemoteWebDriver.driverSetup(browserType);

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

    @Test
    public void LoginToWebsite_UnSuccessful_WithUserNameOnly() throws InterruptedException {

        logInService.loginToWebsite("username", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'sadface')]")));
        String errorMessage = logInPage.getLoginErrorMessage().getText();

        Assert.assertEquals(errorMessage, "Epic sadface: Password is required");
    }

    @Test
    public void LoginToWebsite_UnSuccessful_WithIncorrectCredentials() throws InterruptedException {

        logInService.loginToWebsite("wrongUsername", "wrongPassword");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'sadface')]")));
        String errorMessage = logInPage.getLoginErrorMessage().getText();

        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void LoginToWebsite_UnSuccessful_WithEmptyCredentials() throws InterruptedException {

        logInService.loginToWebsite("", "");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'sadface')]")));
        String errorMessage = logInPage.getLoginErrorMessage().getText();

        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
