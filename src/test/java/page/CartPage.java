package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver browser) {
        super(browser);
    }

    private final By BUTTON_ADD_TO_CART5 = By.xpath("(//*[text()='Add to cart'])[5]");
    private final By ITEM_NAME = By.cssSelector(".inventory_item_name");

    public ArrayList<String> getProductsName() {
        List<WebElement> allProductsNames = browser.findElements(ITEM_NAME);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }
        return names;
    }

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_ADD_TO_CART5));

    }
}
