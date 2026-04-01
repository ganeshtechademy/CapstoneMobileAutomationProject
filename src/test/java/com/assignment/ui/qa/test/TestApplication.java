package com.assignment.ui.qa.test;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.ProductsPage;
import utils.ScreenshotUtil;

import java.lang.reflect.Method;
import java.time.Duration;


public class TestApplication extends BaseTest {

    @BeforeMethod
    public void startTest(Method method) {
        test = extent.createTest(method.getName());
    }


    @Test
    public void testEndToEndFlow() {

        try {
            test.info("Launching app");
            // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            webDriverWait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='user-name']"))
            );
            test.info("Enter username and Password.");
            LoginPage loginPage = new LoginPage(driver);
            ProductsPage productsPage = loginPage
                    .login("standard_user", "secret_sauce");
            //test.pass("Login successful");
            String screenshot = ScreenshotUtil.captureScreenshot(driver, "loginTest");

            test.pass("Login successful " )
                    .addScreenCaptureFromPath(screenshot);
            //  Assert.assertTrue(productsPage.isPageLoaded());

//        productsPage.addItemToCart()
//                .openCart();
//
//        driver.navigate().back();

//        MenuPage menu = new MenuPage(driver);
//        loginPage = menu.logout();

//        Assert.assertNotNull(loginPage);
        }catch (Exception e) {
            String screenshot = ScreenshotUtil.captureScreenshot(driver, "loginTest");

            test.fail("Test failed: " + e.getMessage())
                    .addScreenCaptureFromPath(screenshot);

//            log.error("Test failed", e);
            Assert.fail();
        }

    }

    @AfterMethod
    public void endTest() {
        extent.flush();
    }
}