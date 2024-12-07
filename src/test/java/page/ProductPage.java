package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver browser) {
        super(browser);
    }

    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private final By title = By.xpath("//span[text()='Products']");
    private final By title2 = By.xpath("//span[text()='Products']");
    private final By openCart = By.cssSelector(".shopping_cart_link");

    public String getSpan() {
        return browser.findElement(title).getText();
    }

    @Step("Переход на страницу с продуктами интернет магазина")
    public boolean titleDisplayed() {
        browser.findElement(title2).isDisplayed();
        return true;
    }

    @Step("Добавление товара в корзину")
    public ProductPage addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        browser.findElement(addToCart).click();
        return this;
    }

    @Step("Переход на страницу корзины")
    public ProductPage openCart() {
        browser.findElement(openCart).click();
        return this;
    }

    @Step("Проверка, что текст каждой кнопки-Add to cart")
    public ProductPage addToCartButtonsNotClicked() {
        List<WebElement> addToCartButtons = browser.findElements(By.xpath("//*[text()='Add to cart']"));
        for (WebElement button : addToCartButtons) {
            assertEquals(button.getText(), "Add to cart", "Кнопка должна быть не нажата!");
        }
        return this;
    }
}
