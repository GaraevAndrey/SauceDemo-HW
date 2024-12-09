package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Epic("Модуль логина интернет-магазина")
    @Feature("TMS-56")
    @Story("TMS-56.67")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Garaev Andrey Vyacheslavovich, garaevandrey@mail.ru")
    @TmsLink("Input")
    @Description("Проверка входа в систему интернет-магазина")
    @Test(description = "Авторизация под верными данными")
    public void correctLoginCheck() {
        loginPage
                .open()
                .login(user, password);
        assertTrue(productPage.isDisplayed());
        assertEquals("Products", productPage.getTitle());
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_userr", password, "Epic sadface: Username and password do not match any user in this service"},
                {user, " ", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", password, "Epic sadface: Sorry, this user has been locked out."},
                {"", "", "Epic sadface: Username is required"}
        };
    }

    @Test(dataProvider = "loginData", description = "Авторизация под неверными данными")
    public void incorrectLoginCheck(String user, String pass, String errorMsg) {
        loginPage
                .open()
                .login(user, pass);
        assertEquals(loginPage.getERROR(), errorMsg);
    }
}