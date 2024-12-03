package page;

import io.qameta.allure.Step;
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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие браузера")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Вводим данные {user} и {password}")
    public void login(String user, String password) {
        fillUserInput(user);
        fillPasswordInput(password);
        clickSubmitBtn();
    }

    //@Step("Вводим логин")
    public void fillUserInput(String user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
    }

    //@Step("ВВодим пароль")
    public void fillPasswordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Кликаем на кнопку логин")
    public void clickSubmitBtn() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Получаем текст из сообщения об ошибке")
    public String getERROR() {
        return driver.findElement(ERROR).getText();
    }

    @Step("Получаем текст из сообщения об ошибке")
    public String getERROR2() {
        return driver.findElement(ERROR2).getText();
    }

    @Step("Получаем текст из сообщения об ошибке")
    public String getERROR3() {
        return driver.findElement(ERROR3).getText();
    }

    @Step("Получаем текст из сообщения об ошибке")
    public String getERROR4() {
        return driver.findElement(ERROR4).getText();
    }
}