package base;

import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        driver = DriverManager.initDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}