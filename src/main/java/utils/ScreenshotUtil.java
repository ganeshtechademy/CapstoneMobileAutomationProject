package utils;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
public class ScreenshotUtil {
        public static String captureScreenshot(WebDriver driver, String testName) {
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String destPath = "screenshots/" + testName + ".png";
                Files.copy(src.toPath(), Paths.get(destPath));
                return destPath;
            } catch (Exception e) {
                return null;
            }
        }
    }

