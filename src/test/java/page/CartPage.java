package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver browser) {
        super(browser);
    }

    private final By ITEM_NAME = By.cssSelector(".inventory_item_name");

    @Step("Проверка наличия товара в корзине")
    public ArrayList<String> getProductsName() {
        List<WebElement> allProductsNames = browser.findElements(ITEM_NAME);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }
        return names;
    }
}
