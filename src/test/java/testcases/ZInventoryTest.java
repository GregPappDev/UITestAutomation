package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.InventoryPage;
import services.CartService;
import services.InventoryService;

import java.net.MalformedURLException;
import java.net.URI;

public class ZInventoryTest {

    public WebDriver driver;
    public InventoryPage inventoryPage;
    public InventoryService inventoryService;
    public CartService cartService;
    private WebDriverWait wait;
    private String cartUrl = "https://www.saucedemo.com/cart.html";
    final private URI gridUrl = URI.create("http://localhost:4445");


    @Test
    public void AddOneItemToCartSuccessfully(){
/*        // Arrange

        // Act
        inventoryService.AddFirstItemToCart();

        //Assert
        driver.get(cartUrl);
        int numberOfItemsInCart = cartService.numberOfItemsInCart();
        Assert.assertEquals(1, numberOfItemsInCart);*/
    }



}
