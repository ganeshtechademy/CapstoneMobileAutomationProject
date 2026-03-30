package com.assignment.ui.qa.test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.ProductsPage;


public class TestApplication extends BaseTest {

    @Test
    public void testEndToEndFlow() {

        LoginPage loginPage = new LoginPage(driver);

        ProductsPage productsPage = loginPage
                .login("standard_user", "secret_sauce");

        Assert.assertTrue(productsPage.isPageLoaded());

        productsPage.addItemToCart()
                .openCart();

        driver.navigate().back();

        MenuPage menu = new MenuPage(driver);
        loginPage = menu.logout();

        Assert.assertNotNull(loginPage);
    }
}