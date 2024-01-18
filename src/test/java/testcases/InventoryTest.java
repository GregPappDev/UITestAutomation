package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LogInPage;
import services.InventoryService;
import services.LogInService;
import utils.SetupRemoteWebDriver;

import java.net.MalformedURLException;

public class InventoryTest {

    public WebDriver driver;
    public InventoryPage inventoryPage;
    public InventoryService inventoryService;
    private WebDriverWait wait;
    @Parameters("browser")
    @BeforeTest

    public void setup(String browserType) throws MalformedURLException {
        if(this.driver != null) driver.close();

        driver = SetupRemoteWebDriver.driverSetup(browserType);

        inventoryPage = new InventoryPage(driver);
        wait = new WebDriverWait(driver, 5);
        inventoryService = new InventoryService(driver, wait, inventoryPage);
    }

    @Test
    public void AddOneItemToCartSuccessfully(){

    }


    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
