package driver;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;

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

//            UiAutomator2Options options = new UiAutomator2Options();
//            options.setDeviceName("emulator-5554");
//            options.setPlatformName("Android");
//            options.setAutomationName("UiAutomator2");

// CRITICAL for parallel execution
        //    options.setSystemPort(8201);   // unique per device
        //    options.setChromedriverPort(9515);
          //  options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(60));

//            options.setDeviceName("emulator-5556");
//            options.setSystemPort(8202); // different port
       //     options.setChromedriverPort(9516);

            return new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        }
    }

