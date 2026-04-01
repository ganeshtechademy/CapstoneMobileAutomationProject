package com.assignment.ui.qa.test;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.ProductsPage;

import java.time.Duration;


public class TestApplication extends BaseTest {

    @Test
    public void testEndToEndFlow() {



           // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

          webDriverWait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='user-name']"))
            );

        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage = loginPage
                .login("standard_user", "secret_sauce");

      //  Assert.assertTrue(productsPage.isPageLoaded());

//        productsPage.addItemToCart()
//                .openCart();
//
//        driver.navigate().back();

//        MenuPage menu = new MenuPage(driver);
//        loginPage = menu.logout();

//        Assert.assertNotNull(loginPage);
    }
}