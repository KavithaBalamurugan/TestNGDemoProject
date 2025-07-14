package com.testng.project.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage  {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // ✅ Correct
    }

    @FindBy(id = "login2")
    public WebElement login;

    @FindBy(id = "loginusername")
    public WebElement username;

    @FindBy(id = "loginpassword")
    public WebElement password;

    @FindBy(xpath ="//button[normalize-space()='Log in']")
    public WebElement loginbutton;

    @FindBy(xpath ="//a[normalize-space()='Samsung galaxy s6']")
    public WebElement ProductClick;

    @FindBy(id = "logout2")
    public WebElement logout;
}


