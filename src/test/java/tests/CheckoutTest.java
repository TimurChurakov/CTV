package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test(description = "Форма заполняется валидными данными")
    public void testPositiveForm() {
        loginPage
                .open()
                .login(user, password);
        checkoutPage
                .openCheckoutPage()
                .form("Pit", "Piterson", "1234567");
        assertEquals(checkoutOverviewPage.getTitleOverview(), "Checkout: Overview");
    }

    @DataProvider()
    public Object[][] testNegativeCheckoutForm() {
        return new Object[][]{
                {"", "", "", "Error: First Name is required"},
                {"", "", "1234567", "Error: First Name is required"},
                {"Pit", "", "", "Error: Last Name is required"},
                {"Pit", "Piterson", "", "Error: Postal Code is required"}
        };
    }

    @Test(dataProvider = "testNegativeCheckoutForm")
    public void testNegativeForm(String firstname, String lastname, String zipcode, String massageError) {
        loginPage
                .open()
                .login(user, password);
        checkoutPage
                .openCheckoutPage()
                .form(firstname, lastname, zipcode);
        assertEquals(checkoutPage.getMessageErrorCheckoutPage(), massageError);
    }
}
