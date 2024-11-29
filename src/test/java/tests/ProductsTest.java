package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    @Test
    public void addGoods() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        productPage.addToCart("Sauce Labs Bike Light");
        productPage.addToCart("Sauce Labs Bolt T-Shirt");
        productPage.openCart();
        assertTrue(productPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertTrue(productPage.getProductsNames().contains("Sauce Labs Bike Light"));
        assertTrue(productPage.getProductsNames().contains("Sauce Labs Bolt T-Shirt"));
    }
}
