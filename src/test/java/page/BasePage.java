package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public static final String BASE_URL = "https://www.saucedemo.com/";

    WebDriver browser;
    WebDriverWait wait;

    public BasePage(WebDriver browser) {
        this.browser = browser;
        wait = new WebDriverWait(browser, Duration.ofSeconds(4));
    }
}
