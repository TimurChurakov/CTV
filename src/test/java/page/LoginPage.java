package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By MESSAGE_ERROR = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    @Step("Открытие браузера")
    public LoginPage open() {
        browser.get(BASE_URL);
        return this;
    }

    @Step("Ввод данных {user} и {password}")
    public LoginPage login(String user, String password) {
        browser.findElement(USERNAME_INPUT).sendKeys(user);
        browser.findElement(PASSWORD_INPUT).sendKeys(password);
        browser.findElement(LOGIN_BUTTON).click();
        return this;
    }

    @Step("Получаем текс из сообщения об ошибке")
    public String getMessageError() {
        return browser.findElement(MESSAGE_ERROR).getText();
    }
}
