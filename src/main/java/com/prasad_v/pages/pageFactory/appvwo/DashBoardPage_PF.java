package com.prasad_v.pages.pageFactory.appvwo; // Declares the package location of this class

import com.prasad_v.base.CommonToAllPage; // Imports your base class that has reusable utilities
import org.openqa.selenium.WebDriver; // Selenium WebDriver for browser control
import org.openqa.selenium.WebElement; // Represents a web element
import org.openqa.selenium.support.FindBy; // Used to locate elements via annotations
import org.openqa.selenium.support.PageFactory; // Used for PageFactory initialization

import static com.prasad_v.utils.WaitHelpers.visibilityOfElement; // Custom wait method to check visibility

// This class represents the Dashboard page of the VWO application using PageFactory.
public class DashBoardPage_PF extends CommonToAllPage {

    WebDriver driver; // WebDriver instance specific to this page

    // Constructor: Accepts the WebDriver instance and initializes the elements using PageFactory
    public DashBoardPage_PF(WebDriver driver) {
        this.driver = driver;

        // Initialize all @FindBy annotated WebElements in this class
        PageFactory.initElements(driver, this);
    }

    // This WebElement points to the user name label visible after login
    // The 'data-qa' attribute is used for locating the element in a reliable way
    @FindBy(css = "[data-qa='lufexuloga']")
    private WebElement userNameOnDashboard;

    // Page Action Method: Gets the logged-in user's name from the dashboard
    public String loggedInUserName() {
        // Custom wait to make sure the user name element is visible before interacting
        visibilityOfElement(userNameOnDashboard);

        // Fetch and return the text inside the element (i.e., the user name)
        return getText(userNameOnDashboard);
    }
}
















/*

🔹 Intention of the Program:
This class represents the Dashboard Page after logging in to the VWO application. It follows the PageFactory pattern, making element initialization easier and cleaner.

🔹 Input Parameters:
WebDriver driver – used to drive the browser and interact with web elements.

🔹 Conditions:
Web element (userNameOnDashboard) must be visible before interaction (wait applied).
The page must be loaded correctly after login.

🔹 Output / Expected Output:
Return the logged-in user's name displayed on the dashboard.

🔹 Actual Output:
The actual text retrieved from the dashboard's user name element.


 */