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

    private final By TITLE = By.xpath("//span[text()='Products']");
    private final By TITLE2 = By.xpath("//span[text()='Products']");
    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private final By addToCartBtn = By.xpath("//*[text()='Add to cart']");
    private final By cartIcon = By.xpath("//*[@class='shopping_cart_link']");

    public String getTITLE() {
        return driver.findElement(TITLE).getText();
    }

    public boolean isDisplayed() {
        driver.findElement(TITLE2).isDisplayed();
        return true;
    }
    @Step("Добавление товара по назаванию")
    public void addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCart).click();
    }
    @Step("Добавление товара по индексу")
    public void addToCart(int index) {
        driver.findElements(addToCartBtn).get(index).click();
    }

    @Step("Открываем корзину")
    public void openCart() {
        driver.findElement(cartIcon).click();
    }
    @Step("Провряем наличие добавленных товаров в корзине")
    public ArrayList<String> getProductsNames() {
        List<WebElement> allProductsNames = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }
        return names;
    }
    @Step("Ожидание появление кнопки add to cart")
    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
    }
}