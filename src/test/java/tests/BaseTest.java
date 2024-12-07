package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import page.*;
import utils.PropertyReader;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver browser;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    String user;
    String password;

    @Parameters({"browserr"})
    @BeforeMethod
    @Description("Открытие")
    public void setUp(@Optional("chrome") String browserr, ITestContext context) {
        if (browserr.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            browser = new ChromeDriver(options);
        } else if (browserr.equalsIgnoreCase("edge")) {
            browser = new EdgeDriver();
        }

        browser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        context.setAttribute("browser", browser);
        loginPage = new LoginPage(browser);
        productPage = new ProductPage(browser);
        cartPage = new CartPage(browser);
        checkoutPage = new CheckoutPage(browser);
        checkoutOverviewPage = new CheckoutOverviewPage(browser);

        System.setProperty("BASE_URL", PropertyReader.getProperty("CTV.url"));
        user = PropertyReader.getProperty("CTV.user");
        password = PropertyReader.getProperty("CTV.password");
    }

    @AfterMethod
    @Description("Закрытие")
    public void quit() {
        browser.quit();
    }
}
