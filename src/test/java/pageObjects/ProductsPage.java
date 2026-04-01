package pageObjects;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    public ProductsPage(AndroidDriver driver) {
        super(driver);
    }

    private By title = By.id("inventory_container");
    private By addToCart = By.xpath("(//button[@id='add-to-cart-sauce-labs-backpack'])[1]");
    private By cartIcon = By.xpath("//a[@class='shopping_cart_link']");

    public boolean isPageLoaded() {
        return isDisplayed(title);
    }

    public ProductsPage addItemToCart() {
        click(addToCart);
        return this;
    }

    public void openCart() {
        click(cartIcon);
    }
}