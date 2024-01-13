package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LogInPage;
import org.apache.logging.log4j.Logger;

public class LogInService {

    final private WebDriver driver;
    final private LogInPage loginPage;
    final private WebDriverWait wait;
    final private Logger logger;

    public LogInService(WebDriver driver, LogInPage loginPage, WebDriverWait wait, Logger logger) {
        this.driver = driver;
        this.loginPage = loginPage;
        this.wait = wait;
        this.logger = logger;
    }

    public void loginToWebsite(String userName, String password){
        navigateToUrl();
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }

    private void navigateToUrl() {
        try
        {
            driver.get(loginPage.getUrl());
        }
        catch (Exception e){
           logger.info("An error occurred while accessing the URL");
           logger.error("Error message", e);
        }

    }
    private void enterUserName(String userName) {
        try
        {
            wait.until(ExpectedConditions.elementToBeSelected(loginPage.getUserNameInputField()));
            loginPage.getUserNameInputField().sendKeys(userName);
        }
        catch (Exception e)
        {
            logger.info("An error occurred while trying to locate 'username' field");
            logger.error("Error message", e);
        }
    }

    private void enterPassword(String password) {
        try
        {
            wait.until(ExpectedConditions.elementToBeSelected(loginPage.getPasswordInputField()));
            loginPage.getPasswordInputField().sendKeys(password);
        }
        catch (Exception e)
        {
            logger.info("An error occurred while trying to locate 'password' field");
            logger.error("Error message", e);
        }
    }

    private void clickLoginButton() {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginButton()));
            loginPage.getLoginButton().click();
        }
        catch (Exception e)
        {
            logger.info("An error occurred while trying to locate 'login' button");
            logger.error("Error message", e);
        }
    }
}
