package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LogInPage {

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    private String url = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement userNameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(), 'Epic sadface: Password is required')]")
    private WebElement loginErrorMessage;


}
