package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class BasePage {

    protected AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        WaitUtils.waitForClickable(driver, locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = WaitUtils.waitForVisible(driver, locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return WaitUtils.waitForVisible(driver, locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        return WaitUtils.waitForVisible(driver, locator).isDisplayed();
    }
}