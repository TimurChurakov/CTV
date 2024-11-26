package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver browser) {
        super(browser);
    }

    private final By SPAN = By.xpath("//span[text()='Products']");
    private final By SPAN2 = By.xpath("//span[text()='Products']");
    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private final By SPAN3 = By.cssSelector("span.shopping_cart_badge");

    public String getSpan() {
        return browser.findElement(SPAN).getText();
    }

    public boolean spanDisplayed() {
        browser.findElement(SPAN2).isDisplayed();
        return true;
    }

    public void addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        browser.findElement(addToCart).click();
    }

    public String getCartCount() {
        return browser.findElement(SPAN3).getText();
    }
}
