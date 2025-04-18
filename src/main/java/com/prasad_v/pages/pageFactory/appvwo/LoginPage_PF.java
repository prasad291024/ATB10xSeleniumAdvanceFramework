package com.prasad_v.pages.pageFactory.appvwo; // Declares the package for PageFactory-based page objects

// Importing necessary base class and utilities
import com.prasad_v.base.CommonToAllPage;
import com.prasad_v.utils.PropertiesReader;
import com.prasad_v.utils.WaitHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*; // PageFactory, FindBy, FindAll, etc.

import java.util.List; // For working with multiple elements if needed

// This class represents the Login Page using PageFactory. It extends a base class for common actions.
public class LoginPage_PF extends CommonToAllPage {

    WebDriver driver; // WebDriver instance for this page

    // Constructor to initialize PageFactory elements and assign driver
    public LoginPage_PF(WebDriver driver) {
        this.driver = driver;

        // PageFactory initializes all WebElement fields annotated with @FindBy
        PageFactory.initElements(driver, this);
    }

    // Locating the Username input field by its ID
    @FindBy(id = "login-username")
    private WebElement username;

    // Locating the Password input field by name attribute
    @FindBy(name = "password")
    private WebElement password;

    // Locating the Sign In button by its ID
    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    // Locating the error message displayed after failed login
    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;


    // 🔒 Commented-out examples below show alternatives and experiments
// e.g., locating multiple elements with @FindAll, alternate selectors

//    @FindBy(id = "js-login-btn")
//    private List<WebElement> list_element;

//    @FindBy(xpath = "js-login-btn")
//    private WebElement signButton;

//    @FindBy(css = "#js-notification-box-msg")
//    private WebElement error_message;

    //  Multiple Locator Types | OR condition (any criteria can match)
//    @FindAll(
//            {
//                    @FindBy(how = How.ID, using = "login-username"),
//                    @FindBy(name = "username")
//            }
//    )
//    private WebElement input_element;



    // WebElement username = driver.findElement(By.username("login-username");


    // 💥 Page Action: Try login with invalid credentials
    public String loginToVWOInvalidCreds() {
        // Read and enter invalid username from properties file
        enterInput(username, PropertiesReader.readKey("invalid_username"));

        // Read and enter invalid password from properties file
        enterInput(password, PropertiesReader.readKey("invalid_password"));

        // Click the login button
        clickElement(signButton);

        // Static wait (bad practice in real scenarios; prefer explicit waits)
        WaitHelpers.waitJVM(5000);

        // Return the error message shown after failed login
        return getText(error_message);
    }
}





/*
📌 Purpose / Intention of the Program:
This class represents the Login Page of the VWO application using PageFactory in Selenium. It is part of the Page Object Model (POM) architecture to encapsulate elements and actions for cleaner test code.

📌 Input:
Uses credentials (invalid username/password) from config.properties.

📌 Input Parameters:
WebDriver driver – passed from the test to interact with the browser.

📌 Conditions:
Username and password fields should be present and interactable.
The sign-in button must be clickable.
Error message should appear after invalid login attempt.

📌 Output / Expected Output:
Returns the error message displayed on the login page (after failed login).

📌 Actual Output:
Captures the error text from the UI if login credentials are invalid.
 */