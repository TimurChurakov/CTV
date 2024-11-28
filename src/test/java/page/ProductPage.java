package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver browser) {
        super(browser);
    }

    private final By TITLE = By.xpath("//span[text()='Products']");
    private final By TITLE2 = By.xpath("//span[text()='Products']");
    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private final By CART_COUNTER = By.cssSelector("span.shopping_cart_badge");
    private final By OPEN_CART = By.cssSelector(".shopping_cart_link");

    public String getSpan() {
        return browser.findElement(TITLE).getText();
    }

    public boolean titleDisplayed() {
        browser.findElement(TITLE2).isDisplayed();
        return true;
    }

    public void addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        browser.findElement(addToCart).click();
    }

    public void openCart() {
        browser.findElement(OPEN_CART).click();
    }
}
