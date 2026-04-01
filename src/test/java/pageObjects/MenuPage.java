package pageObjects;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {

    public MenuPage(AndroidDriver driver) {
        super(driver);
    }

    private By menuBtn = By.id("react-burger-menu-btn");
    private By logoutBtn = By.id("logout_sidebar_link");

    public LoginPage logout() {
        click(menuBtn);
        click(logoutBtn);
        return new LoginPage(driver);
    }
}
