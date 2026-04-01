package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.ConfigReader;
import utils.ExtentManager;

import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;
    private final String webUrl = ConfigReader.getProperty("webUrl");
    public WebDriverWait webDriverWait = null;
    public ExtentReports extent =null;
    public ExtentTest test;

    @BeforeClass
    public void setup() throws Exception {
        driver = DriverManager.initDriver();

        driver.get(webUrl);

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        extent= ExtentManager.getInstance();


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}