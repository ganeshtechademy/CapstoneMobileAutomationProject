package com.assignment.ui.qa.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.InitializeDriver;
import utils.ReusableComponents;
import utils.ScreenshotUtil;

import java.time.Duration;
import pageObjects.SauceLoginPageObjects;

public class SauceDemoTest extends InitializeDriver {
   // public static RemoteWebDriver driver = null;
   // WebDriverWait webDriverWait = null;
    SauceLoginPageObjects pageObjects = new SauceLoginPageObjects();
    ReusableComponents reusableComponents = new ReusableComponents();

//    @Test
//    public void book_roundTrip_TC() throws Exception {
//
//        the_user_login_to_SauceDemoApplication();
//    }
//
//
//    private void the_user_login_to_SauceDemoApplication() throws InterruptedException {
//        // 1. Verify Title
//        String expectedTitle = "Swag Labs";
//        String actualTitle = driver.getTitle();
//        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
//
//        // 2. Login
//        WebElement username = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
//        // WebElement username = driver.findElement(By.id("user-name"));
//        WebElement password = driver.findElement(By.id("password"));
//        WebElement loginBtn = driver.findElement(By.id("login-button"));
//
//        username.sendKeys("standard_user");
//        password.sendKeys("secret_sauce");
//        loginBtn.click();
//
//        // 3. Verify Successful Login
//        // Checking presence of Products page
//        waitTime(5);
//
//        WebElement productsTitle = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("title")));
//        String actualText = productsTitle.getText();
//
//        Assert.assertEquals(actualText, "Products", "Login failed or Products page not displayed!");
//
//    }

    @Test(priority = 1)
    public void verifyTitle() {
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 2)
    @Parameters({"invalidUsername", "invalidPassword"})
    public void invalidLoginTest(String username, String password) throws Exception{
        reusableComponents.enterValueByID(webDriverWait,pageObjects.username,username);
        reusableComponents.enterValueByID(webDriverWait,pageObjects.password,password);
        reusableComponents.clickOnElementByID(webDriverWait,pageObjects.loginButton);
        reusableComponents.waitForPageLoad(driver);

        String expectedErrorToVerify = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorObserved = reusableComponents.getTextByXpath(webDriverWait,pageObjects.errorMessage);

        System.out.println("actualErrorObserved -->" + actualErrorObserved);
        System.out.println("title -->" + driver.getTitle());

        ScreenshotUtil.captureScreenshot(driver, "invalidLogin");
        Assert.assertEquals(actualErrorObserved, expectedErrorToVerify);
    }

    @Test(priority = 3)
    @Parameters({"validUsername", "validPassword"})
    public void validLoginTest(String username, String password) throws Exception {
        String expectedTitle = "Swag Labs";

        reusableComponents.waitTime(1);
        reusableComponents.clearFieldText(webDriverWait,pageObjects.username);
        reusableComponents.clearFieldText(webDriverWait,pageObjects.password);
        reusableComponents.waitTime(1);
        reusableComponents.enterValueByID(webDriverWait,pageObjects.username,username);
        reusableComponents.enterValueByID(webDriverWait,pageObjects.password,password);
        reusableComponents.clickOnElementByID(webDriverWait,pageObjects.loginButton);
        reusableComponents.waitForPageLoad(driver);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(pageObjects.addToCartButton)));

        String actualTitle = driver.getTitle();
        ScreenshotUtil.captureScreenshot(driver, "validLogin");

        Assert.assertEquals(actualTitle, expectedTitle);
    }





}


