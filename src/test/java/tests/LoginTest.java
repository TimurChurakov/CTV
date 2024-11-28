package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testPositiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productPage.titleDisplayed());
        assertEquals(productPage.getSpan(), "Products");
    }

    @DataProvider()
    public Object[][] testNegative() {
        return new Object[][]{
                {"standard_use", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "testNegative")
    public void testNegativeLoginUserName(String user, String pass, String massageError) {
        loginPage.open();
        loginPage.login(user, pass);
        assertEquals(loginPage.getMessageError(), massageError);
    }
}
