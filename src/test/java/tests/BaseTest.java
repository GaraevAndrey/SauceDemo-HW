package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;
import page.ProductPage;

public class BaseTest {
    WebDriver browser;
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void setUp() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        browser = new EdgeDriver(options);
        browser.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(browser);
        productPage = new ProductPage(browser);
    }

    @AfterMethod
    public void quit() {
        browser.quit();
    }
}
