package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProductsTest extends BaseTest {
    @Epic("Модуль добавления товара в корзину")
    @Feature("TMS-55")
    @Story("TMS-55.55")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Garaev Andrey Vyacheslavovich, garaevandrey@mail.ru")
    @TmsLink("Input")
    @Description("Добавление товара в корзину")
    @Test(description = "Проверка наличия товара в корзине")
    public void addGoods() {
        loginPage.open();
        loginPage.login(user, password);
        productPage.isOpened();
        productPage.addToCart("Sauce Labs Backpack");
        productPage.addToCart("Sauce Labs Bike Light");
        productPage.addToCart("Sauce Labs Bolt T-Shirt");
        productPage.openCart();
        assertTrue(productPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertTrue(productPage.getProductsNames().contains("Sauce Labs Bike Light"));
        assertTrue(productPage.getProductsNames().contains("Sauce Labs Bolt T-Shirt"));
        productPage.clickRemove();
        assertEquals(productPage.cartIcon(), "2");
    }
}
