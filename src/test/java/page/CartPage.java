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

    private static final String REMOVE_CART_BUTTON_PATTERN = "//div[text()='%s']//ancestor::div[@class='cart_item']//button";
    private final By backInProducts = By.xpath("//button[text()='Continue Shopping']");
    private final By itemName = By.cssSelector(".inventory_item_name");
    private final By buttonCheckout = By.xpath("//button[text()='Checkout']");
    private final By titleCheckout = By.xpath("//span[text()='Checkout: Your Information']");

    @Step("Проверка наличия товара в корзине")
    public ArrayList<String> getProductsName() {
        List<WebElement> allProductsNames = browser.findElements(itemName);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }
        return names;
    }

    @Step("Удаление определенного товара из корзины")
    public CartPage removeToCart(String product) {
        By removeToCart = By.xpath(String.format(REMOVE_CART_BUTTON_PATTERN, product));
        browser.findElement(removeToCart).click();
        return this;
    }

    public int getProductsCount() {
        return browser.findElements(itemName).size();
    }

    public void backInProducts() {
        browser.findElement(backInProducts).click();
    }

    public CartPage pressButtonCheckout() {
        browser.findElement(buttonCheckout).click();
        return this;
    }

    public boolean titleCheckoutDisplayed() {
        browser.findElement(titleCheckout).isDisplayed();
        return true;
    }
}
