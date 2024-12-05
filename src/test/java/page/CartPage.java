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

    private final String REMOVE_CART_BUTTON_PATTERN = "//div[text()='%s']//ancestor::div[@class='cart_item']//button";
    private final By BACK_IN_PRODUCTS = By.xpath("//button[text()='Continue Shopping']");
    private final By ITEM_NAME = By.cssSelector(".inventory_item_name");
    private final By ITEM_CART = By.cssSelector(".cart-item");
    private final By BUTTON_CHECKOUT = By.xpath("//button[text()='Checkout']");
    private final By TITLE_CHECKOUT = By.xpath("//span[text()='Checkout: Your Information']");

    @Step("Проверка наличия товара в корзине")
    public ArrayList<String> getProductsName() {
        List<WebElement> allProductsNames = browser.findElements(ITEM_NAME);
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
        return browser.findElements(ITEM_NAME).size();
    }

    public void backInProducts() {
        browser.findElement(BACK_IN_PRODUCTS).click();
    }

    public CartPage pressButtonCheckout() {
        browser.findElement(BUTTON_CHECKOUT).click();
        return this;
    }

    public boolean titleCheckoutDisplayed() {
        browser.findElement(TITLE_CHECKOUT).isDisplayed();
        return true;
    }
}
