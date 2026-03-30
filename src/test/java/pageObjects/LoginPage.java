package pageObjects;
import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    private By username = By.xpath("//android.widget.EditText[@content-desc='test-Username']");
    private By password = By.xpath("//android.widget.EditText[@content-desc='test-Password']");
    private By loginBtn = By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']");

    public ProductsPage login(String user, String pwd) {
        type(username, user);
        type(password, pwd);
        click(loginBtn);
        return new ProductsPage(driver);
    }
}