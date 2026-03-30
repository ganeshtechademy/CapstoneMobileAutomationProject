package driver;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

    public class DriverManager {

        public static AndroidDriver initDriver() throws Exception {

            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "emulator-5554"); // or real device name
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("browser", "Chrome");
//            caps.setCapability("appPackage", "com.android.settings");
//            caps.setCapability("appActivity", ".Settings");
// APK file
           // caps.setCapability("app", "/path/to/app.apk");
// OR if app already installed
//            caps.setCapability("appPackage", "com.swaglabsmobileapp");
//            caps.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");


            return new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        }
    }

