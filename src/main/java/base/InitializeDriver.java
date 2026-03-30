package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;

import java.time.Duration;

public class InitializeDriver {


    public static RemoteWebDriver driver;
    private final String webUrl = ConfigReader.getProperty("webUrl");//webUrl = https://www.saucedemo.com/
    public WebDriverWait webDriverWait = null;

    @BeforeSuite
    public void setupSuite() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //opens the link in the browser
        driver.get(webUrl);
        System.out.println("Application loaded successfully ....>>");
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterSuite
    public void AfterTest(){
        //Quit driver instance
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Quit Driver: ");
            } catch (Exception e) {
                System.out.println("Error while closing browser: " + e.getMessage());
            } finally {
                driver = null; // Important: manual nulling prevents double-quit attempts
            }
        }

    }
}
