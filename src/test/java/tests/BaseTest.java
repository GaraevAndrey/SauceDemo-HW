package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import page.LoginPage;
import page.ProductPage;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;

    @Parameters({"browser"})
    @BeforeMethod
    @Description("Открытие")
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("start-maximized");
            driver = new EdgeDriver(options);
        }
        driver.get("https://www.saucedemo.com/");
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @AfterMethod
    @Description("Закрытие")
    public void quit() {
        driver.quit();
    }
}
