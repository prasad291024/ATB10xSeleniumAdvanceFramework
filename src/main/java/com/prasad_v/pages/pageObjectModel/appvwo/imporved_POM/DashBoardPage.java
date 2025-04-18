// Package declaration that indicates where this class resides
package com.prasad_v.pages.pageObjectModel.appvwo.imporved_POM;

// Importing base class that includes reusable methods like getText(), clickElement(), etc.
import com.prasad_v.base.CommonToAllPage;

// Importing custom wait helpers (used for visibility waits, etc.)
import com.prasad_v.utils.WaitHelpers;

// Selenium imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// This class represents the Dashboard Page in the POM design.
// It extends CommonToAllPage to inherit common reusable Selenium methods.
public class DashBoardPage extends CommonToAllPage {

    // Instance of WebDriver used to interact with the browser
    WebDriver driver;

    // Constructor to assign the WebDriver instance to this class
    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator to identify the username displayed on the Dashboard using CSS Selector.
    // data-qa attribute is often used for test automation targeting.
    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    // ✅ Page Action: This method waits for the username element to be visible,
    // then returns the text (username) from that element.
    public String loggedInUserName() {
        // Waits until the element identified by the locator is visible on the page.
        WaitHelpers.visibilityOfElement(userNameOnDashboard);

        // Retrieves and returns the visible text (i.e., the username) from the element.
        return getText(userNameOnDashboard);
    }
}

















/*

This class represents the Dashboard Page in the improved Page Object Model (POM) structure of the VWO application. It encapsulates the UI elements and actions related to the Dashboard page.

This class:
Extends a common base class (CommonToAllPage) to reuse common Selenium actions (like getText, clickElement, etc.).
Implements Dashboard-specific actions like fetching the logged-in username from the UI.

🧩 Purpose / Intention of the Program
To encapsulate dashboard-specific behavior and elements into one page class.
Enables cleaner, reusable test scripts that interact with the VWO Dashboard Page.
Uses By locator strategy, instead of @FindBy (i.e., not using PageFactory).


 */