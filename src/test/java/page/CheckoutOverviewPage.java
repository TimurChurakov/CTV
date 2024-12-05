package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage(WebDriver browser) {
        super(browser);
    }

    private final By TITLE_CHECKOUT_OVERVIEW_PAGE = By.xpath("//span[text()='Checkout: Overview']");

    public String getTitleOverview() {
        return browser.findElement(TITLE_CHECKOUT_OVERVIEW_PAGE).getText();
    }
}
