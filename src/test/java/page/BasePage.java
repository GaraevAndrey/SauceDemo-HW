package page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public static final String BASE_URL = "https://www.saucedemo.com/";

    WebDriver browser;

    public BasePage(WebDriver browser) {
        this.browser = browser;
    }
}