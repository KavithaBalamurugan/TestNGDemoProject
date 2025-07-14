package com.testng.project.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.testng.project.Pages.LoginPage;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public WebDriver driver;
    public LoginPage loginPage;

   

    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/index.html");
        loginPage = new LoginPage(driver);
       
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
