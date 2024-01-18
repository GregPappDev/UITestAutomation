package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;

public class CartService {
    final private CartPage cartPage;
    final private WebDriverWait wait;
    public CartService(WebDriver driver, WebDriverWait wait) {
        this.cartPage = new CartPage(driver);
        this.wait = wait;
    }

    public int numberOfItemsInCart() {
        return cartPage.getListOfCartItems().size();
    }

}
