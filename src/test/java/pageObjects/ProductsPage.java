package pageObjects;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    public ProductsPage(AndroidDriver driver) {
        super(driver);
    }

    private By title = By.xpath("//android.widget.TextView[@text='PRODUCTS']");
    private By addToCart = By.xpath("(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]");
    private By cartIcon = By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']");

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