package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test(description = "Удаление товара из корзины")
    public void testRemoveFromCart() {
        loginPage
                .open()
                .login(user, password);
        productPage
                .openCart();
        assertEquals(cartPage.getProductsCount(), 0, "В корзине есть товар");
        cartPage
                .backInProducts();
        productPage
                .addToCartButtonsNotClicked()
                .addToCart("Sauce Labs Onesie")
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .openCart();
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Onesie"));
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Fleece Jacket"));
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Bolt T-Shirt"));
        cartPage
                .removeToCart("Sauce Labs Onesie");
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Fleece Jacket"));
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Bolt T-Shirt"));
    }

    @Test(description = "Переход из пустой корзины на страницу оформления заказа")
    public void testCheckoutWithEmptyCart() {
        loginPage
                .open()
                .login(user, password);
        productPage
                .openCart();
        cartPage.getProductsCount();
        assertEquals(cartPage.getProductsCount(), 0, "В корзине есть товар");
        cartPage.pressButtonCheckout();
        assertTrue(cartPage.titleCheckoutDisplayed());
    }
}
