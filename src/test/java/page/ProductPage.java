package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    private static final String ADD_TO_CART_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private final By titleProd = By.xpath("//span[text()='Products']");
    private final By titleProd2 = By.xpath("//span[text()='Products']");
    private final By addToCartBtn = By.xpath("//*[text()='Add to cart']");
    private final By cartIcon = By.xpath("//*[@class='shopping_cart_link']");
    private final By goodsInCart = By.cssSelector(".inventory_item_name");
    private final By removeClick = By.id("remove-sauce-labs-backpack");
    private final By cart = By.xpath("//span[@data-test='shopping-cart-badge']");
    private final By checkout = By.id("checkout");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipName = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By order = By.xpath("//h2[text()='Thank you for your order!']");
    private final By continueShopping = By.id("continue-shopping");

    public String getTitle() {
        return driver.findElement(titleProd).getText();
    }

    public boolean isDisplayed() {
        driver.findElement(titleProd2).isDisplayed();
        return true;
    }

    @Step("Добавление товара по названию")
    public ProductPage addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCart).click();
        return this;
    }

    @Step("Добавление товара по индексу")
    public ProductPage addToCart(int index) {
        driver.findElements(addToCartBtn).get(index).click();
        return this;
    }

    @Step("Открываем корзину")
    public ProductPage openCart() {
        driver.findElement(cartIcon).click();
        return this;
    }

    @Step("Кликаем на кнопку Remove")
    public ProductPage clickRemove() {
        driver.findElement(removeClick).click();
        return this;
    }

    @Step("Проверяем количество товаров в корзине")
    public String cartIcon() {
        return driver.findElement(cart).getText();
    }

    @Step("Переход в раздел оформления заказа")
    public ProductPage openCheckout() {
        driver.findElement(checkout).click();
        return this;
    }

    @Step("Вводим данные firstname")
    public ProductPage writeFirstName() {
        driver.findElement(firstName).sendKeys("Andrey");
        return this;
    }

    @Step("Вводим данные lastname")
    public ProductPage writeLastName() {
        driver.findElement(lastName).sendKeys("Гараев");
        return this;
    }

    @Step("Вводим данные postal code")
    public ProductPage writeZip() {
        driver.findElement(zipName).sendKeys("12345");
        return this;
    }

    @Step("Кликаем на continue")
    public ProductPage clickContinue() {
        driver.findElement(continueButton).click();
        return this;
    }

    @Step("Кликаем на finish")
    public ProductPage clickFinish() {
        driver.findElement(finishButton).click();
        return this;
    }

    @Step("Проверка вывода текста после заказа товара")
    public String titleOrder() {
        return driver.findElement(order).getText();
    }

    @Step("Кликаем на continue shopping")
    public ProductPage openContinueShopping() {
        driver.findElement(continueShopping).click();
        return this;
    }

    @Step("Провряем наличие добавленных товаров в корзине")
    public ArrayList<String> getProductsNames() {
        List<WebElement> allProductsNames = driver.findElements(goodsInCart);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }
        return names;
    }

    @Step("Ожидание появления кнопки add to cart")
    public ProductPage isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
        return this;
    }
}