package com.testng.project.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.testng.project.base.BaseClass;
import com.testng.project.Pages.LoginPage;

public class LoginTest extends BaseClass {
    private static LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.out.println("Setting up driver for LoginTest");
        initializeDriver(); // Each test gets a new driver
        System.out.println("Driver after initializeDriver: " + driver);
        loginPage = new LoginPage(driver);
        System.out.println("LoginPage constructed: " + loginPage);
    }

    @Test(groups = {"smoke", "functional"})
    public void testLoginClick() throws InterruptedException {
       // System.out.println("Starting testLoginClick with username: " + username + " and password: " + password);
        Thread.sleep(5000);
        loginPage.login.click();
        Thread.sleep(3000); // Wait for modal to appear
    }

    @Test(dependsOnMethods = "testLoginClick", groups = {"smoke", "functional", "regression"})
    public void testLogin() throws InterruptedException {
       loginPage.username.click();
        loginPage.username.sendKeys("qatest97");
        loginPage.password.click();
        loginPage.password.sendKeys("qatest97");
        Thread.sleep(1000); // Wait for modal to appear
        loginPage.loginbutton.click();
    }

    @Test(groups = {"navigation"})
    public void ProductPage() throws InterruptedException {
       // System.out.println("Testing product page for: " + productName);
        Thread.sleep(5000); 
        loginPage.ProductClick.click();
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        quitDriver(); // Clean up after test
    }
}
