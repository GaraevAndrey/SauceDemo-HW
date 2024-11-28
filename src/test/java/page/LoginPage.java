package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR = By.xpath("//h3[@data-test='error']");
    private final By ERROR2 = By.xpath("//h3[@data-test='error']");
    private final By ERROR3 = By.xpath("//h3[@data-test='error']");
    private final By ERROR4 = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public void open() {
        browser.get(BASE_URL);
    }

    public void login(String user, String password) {
        fillUserInput(user);
        fillPasswordInput(password);
        clickSubmitBtn();
    }

    public void fillUserInput(String user) {
        browser.findElement(USERNAME_INPUT).sendKeys(user);
    }

    public void fillPasswordInput(String password) {
        browser.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickSubmitBtn() {
        browser.findElement(LOGIN_BUTTON).click();
    }
    public String getERROR() {
        return browser.findElement(ERROR).getText();
    }

    public String getERROR2() {
        return browser.findElement(ERROR2).getText();
    }

    public String getERROR3() {
        return browser.findElement(ERROR3).getText();
    }
    public String getERROR4() {
        return browser.findElement(ERROR4).getText();
    }
}