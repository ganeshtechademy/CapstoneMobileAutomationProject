package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReusableComponents {

    public static String projectPath = System.getProperty("user.dir");


    public void waitForElementByID(final WebDriver driver, final String elementID) throws Exception {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementID)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementID)));
        } catch (Exception e) {

        }

    }

    public void clearFieldText(final WebDriverWait driver, final String elementID) throws Exception {

        WebElement element = driver.until(ExpectedConditions.presenceOfElementLocated(By.id(elementID)));
        element.clear();
    }
    public void enterValueByID(final WebDriverWait driver, final String elementID, final String valueToEnter) throws Exception {

        WebElement element = driver.until(ExpectedConditions.presenceOfElementLocated(By.id(elementID)));
        element.sendKeys(valueToEnter);
    }

    public String getTextByXpath(final WebDriverWait driver, final String elementID) throws Exception {

        WebElement element = driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementID)));
        return element.getText();
    }

    public void enterValueByXpath(final WebDriverWait driver, final String elementID, final String valueToEnter) throws Exception {

        WebElement element = driver.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementID)));
        element.sendKeys(valueToEnter);
    }

    public void clickOnElementByID(final WebDriverWait driver, final String elementID) throws Exception {

        WebElement element = driver.until(ExpectedConditions.elementToBeClickable(By.id(elementID)));
        element.click();
    }

    public void clickOnElementByXpath(final WebDriverWait driver, final String elementID) throws Exception {

        WebElement element = driver.until(ExpectedConditions.elementToBeClickable(By.xpath(elementID)));
        element.click();
    }

    // Helper functions

    public void waitTime(long durationinSec) throws InterruptedException {
        Thread.sleep(durationinSec);
    }

    public void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }
}
