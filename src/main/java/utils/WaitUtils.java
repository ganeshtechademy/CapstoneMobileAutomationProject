package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {

    public static WebElement waitForVisible(AndroidDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(AndroidDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}