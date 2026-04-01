package base;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;
    private final String webUrl = ConfigReader.getProperty("webUrl");
    public WebDriverWait webDriverWait = null;

    @BeforeClass
    public void setup() throws Exception {
        driver = DriverManager.initDriver();

        driver.get(webUrl);

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}