package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContinueShoppingTest extends BaseTest {
    @Epic("Возврат к катологу товаров")
    @Feature("TMS-435")
    @Story("TMS-435.509")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Garaev Andrey Vyacheslavovich, garaevandrey@mail.ru")
    @TmsLink("Input")
    @Description("Возврат к катологу товаров")
    @Test(description = "Возврат к катологу товаров")
    public void addGoods() {
        loginPage.open();
        loginPage.login(user, password);
        productPage.isOpened();
        productPage.addToCart("Sauce Labs Backpack");
        productPage.addToCart("Sauce Labs Bike Light");
        productPage.addToCart("Sauce Labs Bolt T-Shirt");
        productPage.openCart();
        productPage.openContinueShopping();
        assertEquals("Products", productPage.getTITLE());
    }
}
