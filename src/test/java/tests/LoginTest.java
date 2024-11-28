package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void correctLoginCheck() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productPage.isDisplayed());
        assertEquals(productPage.getTITLE(), "Products");
    }
    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_userr", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user", " ", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"","","Epic sadface: Username is required"}
        };
    }

    @Test(dataProvider = "loginData")
    public void incorrectLoginCheck(String user, String pass, String errorMsg) {
        loginPage.open();
        loginPage.login(user, pass);
        assertEquals(loginPage.getERROR(), errorMsg);
    }
}