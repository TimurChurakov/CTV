package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver browser) {
        super(browser);
    }

    @Step("Открытие браузера")
    public CheckoutPage openCheckoutPage() {
        browser.get(BASE_URL + "checkout-step-one.html");
        return this;
    }

    private final By FIRST_NAME = By.cssSelector("input[placeholder='First Name']");
    private final By LAST_NAME = By.cssSelector("input[placeholder='Last Name']");
    private final By Zip_Postal_Code = By.cssSelector("input[placeholder='Zip/Postal Code']");
    private final By BUTTON_CONTINUE_CHECKOUT_PAGE = By.cssSelector("input[value='Continue']");
    private final By MESSAGE_ERROR_CHECKOUT_PAGE = By.cssSelector("h3[data-test='error']");

    @Step("Ввод данных {firstname}, {lastname} и {zipcode}")
    public CheckoutPage form(String firstname, String lastname, String zipcode) {
        browser.findElement(FIRST_NAME).sendKeys(firstname);
        browser.findElement(LAST_NAME).sendKeys(lastname);
        browser.findElement(Zip_Postal_Code).sendKeys(zipcode);
        browser.findElement(BUTTON_CONTINUE_CHECKOUT_PAGE).click();
        return this;
    }

    @Step("Получение текста из сообщения об ошибке")
    public String getMessageErrorCheckoutPage() {
        return browser.findElement(MESSAGE_ERROR_CHECKOUT_PAGE).getText();
    }
}
