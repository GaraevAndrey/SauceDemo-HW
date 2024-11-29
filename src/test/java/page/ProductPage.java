package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver browser) {
        super(browser);
    }

    private final By TITLE = By.xpath("//span[text()='Products']");
    private final By TITLE2 = By.xpath("//span[text()='Products']");
    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    public String getTITLE() {
        return browser.findElement(TITLE).getText();
    }

    public boolean isDisplayed() {
        browser.findElement(TITLE2).isDisplayed();
        return true;
    }

    public void addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        browser.findElement(addToCart).click();
    }
    public void addToCart(int index) {
        browser.findElements(By.xpath("//*[text()='Add to cart']")).get(index);
    }

    public void openCart() {
        browser.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
    }
    public ArrayList<String> getProductsNames() {
        List<WebElement> allProductsNames = browser.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }
        return names;
    }
}