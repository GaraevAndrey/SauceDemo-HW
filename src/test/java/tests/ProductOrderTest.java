package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductOrderTest extends BaseTest {
    @Epic("Модуль заказа товара")
    @Feature("TMS-58")
    @Story("TMS-58.33")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Garaev Andrey Vyacheslavovich, garaevandrey@mail.ru")
    @TmsLink("Input")
    @Description("Заказ товара")
    @Test(description = "Заказ товара")
    public void addGoods() {
        loginPage.open();
        loginPage.login(user, password);
        productPage.isOpened();
        productPage.addToCart("Sauce Labs Backpack");
        productPage.openCart();
        productPage.openCheckout();
        productPage.writeFirstName();
        productPage.writeLastName();
        productPage.writeZip();
        productPage.clickContinue();
        productPage.clickFinish();
        assertEquals("Thank you for your order!", productPage.titleOrder());
    }
}
