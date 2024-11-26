package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By DATA = By.cssSelector("[data-test='error']");
    private final By DATA2 = By.cssSelector("h3[data-test='error']");
    private final By DATA3 = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver browser) {
        //this.browser = browser;
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

    public String getData() {
        return browser.findElement(DATA).getText();
    }

    public String getData2() {
        return browser.findElement(DATA2).getText();
    }

    public String getData3() {
        return browser.findElement(DATA3).getText();
    }
}
