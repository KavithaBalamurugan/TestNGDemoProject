package com.testng.project.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.testng.project.Pages.LoginPage;
import com.testng.project.base.BaseClass;

public class Dataproviders1 extends BaseClass {
    private static LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.out.println("Setting up driver for Dataproviders1");
        initializeDriver();
        System.out.println("Driver after initializeDriver: " + driver);
        loginPage = new LoginPage(driver);
        System.out.println("LoginPage constructed: " + loginPage);
    }

    @DataProvider(name = "credentials")
    public Object[][] getCredentials() {
        return new Object[][] {
            {"qatest97", "qatest97"},
            {"testuser1", "password123"},
            {"admin", "admin123"}
        };
    }

    @Test(dataProvider = "credentials")
    public void LoginVerifyData(String username, String password) throws InterruptedException {
        System.out.println("Testing login with username: '" + username + "' and password: '" + password + "'");
        
        // Refresh page to reset state
        driver.navigate().refresh();
        Thread.sleep(3000);
        
        loginPage.login.click();
        Thread.sleep(4000);
        
        loginPage.username.click();
        loginPage.username.sendKeys(username);
        
        loginPage.password.click();
        loginPage.password.sendKeys(password);
        
        Thread.sleep(2000);
        loginPage.loginbutton.click();
        
        System.out.println("Login test completed for: " + username);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        quitDriver();
    }
}
