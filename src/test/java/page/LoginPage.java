package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By MESSAGE_ERROR = By.cssSelector("[data-test='error']");
    private final By MESSAGE_ERROR2 = By.cssSelector("h3[data-test='error']");
    private final By MESSAGE_ERROR3 = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public void open() {
        browser.get(BASE_URL);
    }

    public void login(String user, String password) {
        browser.findElement(USERNAME_INPUT).sendKeys(user);
        browser.findElement(PASSWORD_INPUT).sendKeys(password);
        browser.findElement(LOGIN_BUTTON).click();
    }

    public String getMessageError() {
        return browser.findElement(MESSAGE_ERROR).getText();
    }

    public String getMessageError2() {
        return browser.findElement(MESSAGE_ERROR2).getText();
    }

    public String getMessageError3() {
        return browser.findElement(MESSAGE_ERROR3).getText();
    }
}
