package pageObjects;
import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    private By username = By.xpath("//android.widget.EditText[@resource-id='user-name']");
    private By password = By.xpath("//android.widget.EditText[@resource-id='password']");
    private By loginBtn = By.xpath("//android.widget.Button[@resource-id='login-button']");

    public ProductsPage login(String user, String pwd) {
        type(username, user);
        type(password, pwd);
        click(loginBtn);
        return new ProductsPage(driver);
    }
}