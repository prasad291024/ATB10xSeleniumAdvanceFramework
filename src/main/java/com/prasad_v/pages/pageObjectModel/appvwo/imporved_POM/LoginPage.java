// Declares the package location of this class
package com.prasad_v.pages.pageObjectModel.appvwo.imporved_POM;

// Base class containing reusable Selenium actions like clickElement(), enterInput(), getText()
import com.prasad_v.base.CommonToAllPage;

// Custom wait helpers for element wait handling
import com.prasad_v.utils.WaitHelpers;

// Selenium classes for locators and browser control
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Static import for getting WebDriver instance (used for custom wait helpers)
import static com.prasad_v.driver.DriverManager.getDriver;

// This class models the Login Page functionality using POM (without PageFactory).
public class LoginPage extends CommonToAllPage {

    // WebDriver instance for interacting with the browser
    WebDriver driver;

    // Constructor to initialize the WebDriver when the page object is created
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // 🔍 Step 1 - Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // 🔁 Page Action - Login using invalid credentials and return the error message displayed
    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        // Navigates to the VWO login URL (likely from base class method)
        openVWOUrl();

        // Enter username and password from parameters
        enterInput(username, user);
        enterInput(password, pwd);

        // Click on the login button
        clickElement(signButton);

        // Wait until the error message becomes visible using a custom wait
        WaitHelpers.checkVisibility(getDriver(), error_message);

        // Return the text of the error message element
        return getText(error_message);
    }

    // 🔁 Page Action - Login using valid credentials (does not return anything)
    public void loginToVWOLoginValidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signButton);
        // Successful login can be verified in test using DashBoardPage
    }
}











/*
This class represents the Login Page of the VWO web application using the Page Object Model (POM) approach (without PageFactory).
It provides locators and actions needed to perform login operations (both valid and invalid) and handles login-related elements like username, password, sign-in button, and error messages.

🧩 Purpose / Intention of the Program
Encapsulates all elements and login actions for the VWO login page.
Follows POM principles to keep tests clean and maintainable.
Uses custom utility classes (CommonToAllPage, WaitHelpers, DriverManager) for cleaner Selenium code.


 */