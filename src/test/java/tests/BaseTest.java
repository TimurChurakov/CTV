package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.CartPage;
import page.LoginPage;
import page.ProductPage;

public class BaseTest {
    WebDriver browser;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browser = new ChromeDriver(options);
        loginPage = new LoginPage(browser);
        productPage = new ProductPage(browser);
        cartPage = new CartPage(browser);
    }

    @AfterMethod
    public void quit() {
        browser.quit();
    }
}
