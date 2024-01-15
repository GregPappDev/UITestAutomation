package services;

import pages.InventoryPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryService {

    private InventoryPage inventoryPage;

    public void AddFirstItemToCart(){
        if(inventoryPage.getAllAddToCartButtons().size() > 0){
            inventoryPage.getAllAddToCartButtons().get(0).click();
        }
        else {
            System.out.println("There are no 'Add to Cart' buttons on the page");
        }
    }

    public int AddAllItemsToCart(){
        List<WebElement> allAddToCartButtons = inventoryPage.getAllAddToCartButtons();
        int counter = 0;

        if(allAddToCartButtons.isEmpty()){
            System.out.println("There are no 'Add to Cart' buttons on the page");
            return counter;
        }

        for (WebElement button : allAddToCartButtons) {
            button.click();
            counter++;
        }
        return counter;
    }

}
