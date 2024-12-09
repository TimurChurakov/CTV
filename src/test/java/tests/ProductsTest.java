package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    @Epic("Модуль продукции интернет магазина")
    @Feature("TM_58")
    @Story("TND_99")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Churakov Timur")
    @Description("Проверка дбавления товара в корзину")
    @Test(description = "Добавление товара в корзину")
    public void addGoods() {
        loginPage
                .open()
                .login(user, password);
        productPage
                .addToCartButtonsNotClicked()
                .addToCart("Sauce Labs Onesie")
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .openCart();
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Onesie"));
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Fleece Jacket"));
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Bolt T-Shirt"));
    }
}
