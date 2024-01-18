package testcases;

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
import pages.InventoryPage;
import pages.LogInPage;
import services.CartService;
import services.InventoryService;
import services.LogInService;
import utils.SetupRemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class InventoryTest {

    public WebDriver driver;
    public InventoryPage inventoryPage;
    public InventoryService inventoryService;
    public CartService cartService;
    private WebDriverWait wait;
    private String cartUrl = "https://www.saucedemo.com/cart.html";
    final private URI gridUrl = URI.create("http://localhost:4445");
    @Parameters("browser")
    @BeforeTest

    public void setup(String browserType) throws MalformedURLException {
        if(this.driver != null) driver.close();

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

        inventoryPage = new InventoryPage(driver);
        wait = new WebDriverWait(driver, 5);
        inventoryService = new InventoryService(driver, wait, inventoryPage);
        cartService = new CartService(driver, wait);
    }

    @Test
    public void AddOneItemToCartSuccessfully(){
        // Arrange

        // Act
        inventoryService.AddFirstItemToCart();

        //Assert
        driver.get(cartUrl);
        int numberOfItemsInCart = cartService.numberOfItemsInCart();
        Assert.assertEquals(1, numberOfItemsInCart);
    }


    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
