package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LogInPage;


public class LogInService {

    final private WebDriver driver;
    final private LogInPage loginPage;
    final private WebDriverWait wait;


    public LogInService(WebDriver driver, LogInPage loginPage, WebDriverWait wait) {
        this.driver = driver;
        this.loginPage = loginPage;
        this.wait = wait;
    }

    public void loginToWebsite(String userName, String password) throws InterruptedException {
        navigateToUrl();
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();

    }

    private void navigateToUrl() {
        driver.get(loginPage.getUrl());

    }
    private void enterUserName(String userName) {
        loginPage.getUserNameInputField().sendKeys(userName);

    }

    private void enterPassword(String password) {
      loginPage.getPasswordInputField().sendKeys(password);

    }

    private void clickLoginButton() {
        loginPage.getLoginButton().click();

    }

}
