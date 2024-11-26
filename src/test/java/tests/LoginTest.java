package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testPositiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productPage.spanDisplayed());
        assertEquals(productPage.getSpan(), "Products");
    }

    @Test
    public void testNegativeLoginUserName() {
        loginPage.open();
        loginPage.login("standard_use", "secret_sauce");
        assertEquals(loginPage.getData(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testNegativeLoginUserName2() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getData2(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void testNegativeLoginPassword() {
        loginPage.open();
        loginPage.login("locked_out_user", "123456");
        assertEquals(loginPage.getData3(), "Epic sadface: Username and password do not match any user in this service");
    }
}
