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
        loginPage
                .open()
                .login(user, password);
        productPage
                .isOpened()
                .addToCart(2)
                .openCart()
                .openCheckout()
                .writeFirstName()
                .writeLastName()
                .writeZip()
                .clickContinue()
                .clickFinish();
        assertEquals("Thank you for your order!", productPage.titleOrder());
    }
}
