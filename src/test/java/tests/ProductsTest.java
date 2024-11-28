package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    @Test
    public void addGoods() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        cartPage.isOpened();
        productPage.addToCart("Sauce Labs Onesie");
        //assertEquals(productPage.getCartCount(), "1");
        productPage.openCart();
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Onesie"));
    }
}

