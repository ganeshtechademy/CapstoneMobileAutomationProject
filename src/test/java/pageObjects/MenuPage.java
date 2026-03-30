package pageObjects;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {

    public MenuPage(AndroidDriver driver) {
        super(driver);
    }

    private By menuBtn = By.xpath("//android.view.ViewGroup[@content-desc='test-Menu']");
    private By logoutBtn = By.xpath("//android.view.ViewGroup[@content-desc='test-LOGOUT']");

    public LoginPage logout() {
        click(menuBtn);
        click(logoutBtn);
        return new LoginPage(driver);
    }
}
