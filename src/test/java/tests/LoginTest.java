package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Epic("Модуль логина интернет магазина")
    @Feature("TM_56")
    @Story("TND_98")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Churakov Timur")
    @Description("Проверка входа в интернет магазин")

    @Test(description = "Авторизация под верными данными")
    public void testPositiveLogin() {
        loginPage
                .open()
                .login(user, password);
        assertTrue(productPage.titleDisplayed());
        assertEquals(productPage.getSpan(), "Products");
    }

    @DataProvider()
    public Object[][] testNegative() {

        return new Object[][]{
                {"standard_use", password, "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", password, "Epic sadface: Sorry, this user has been locked out."},
                {user, "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "testNegative")
    public void testNegativeLoginUserName(String user, String pass, String massageError) {
        loginPage
                .open()
                .login(user, pass);
        assertEquals(loginPage.getMessageError(), massageError);
    }
}
