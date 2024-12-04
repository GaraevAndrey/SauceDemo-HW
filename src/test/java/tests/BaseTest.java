package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import page.LoginPage;
import page.ProductPage;
import utils.PropertyReader;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    String user;
    String password;

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
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        System.setProperty("BASE_URL", PropertyReader.getProperty("sauceDemo-HW.url"));
        user = PropertyReader.getProperty("sauceDemo-HW.user");
        password = PropertyReader.getProperty("sauceDemo-HW.password");
    }

    @AfterMethod
    @Description("Закрытие")
    public void close(ITestResult result) {
        driver.quit();
    }
}
