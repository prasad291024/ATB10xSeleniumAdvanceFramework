// Package declaration - placing this class inside 'base' package
package com.prasad_v.base;

// Importing custom utility class for reading property files
import com.prasad_v.utils.PropertiesReader;

// Selenium imports for interacting with web elements
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// Importing static method 'getDriver()' from DriverManager class
// This provides access to the WebDriver instance globally
import static com.prasad_v.driver.DriverManager.getDriver;

// This class contains common reusable functions shared across all page object classes
public class CommonToAllPage {

    // Constructor of the class. Runs when an object of this class is created.
    public CommonToAllPage() {
        // Developer's note: You can place setup-related logic here like:
        // - Opening a database connection
        // - Initializing files, logging setup, etc.
        // Currently, it's a placeholder with no logic
    }

    // Function to open the VWO (Visual Website Optimizer) application URL
    // URL is fetched from the properties file using the key 'url'
    public void openVWOUrl() {
        getDriver().get(PropertiesReader.readKey("url"));
    }

    // Function to open the OrangeHRM application URL
    // URL is fetched from the properties file using the key 'ohr_url'
    public void openOrangeHRMUrl() {
        getDriver().get(PropertiesReader.readKey("ohr_url"));
    }

    // ====================
    // Element Click Methods
    // ====================

    // Overloaded method #1: Accepts a By locator to find and click on the element
    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    // Overloaded method #2: Accepts an already located WebElement and clicks it
    public void clickElement(WebElement by) {
        by.click();
    }

    // ==========================
    // Input Text into Text Fields
    // ==========================

    // Overloaded method #1: Accepts a By locator and text input to enter in a field
    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    // Overloaded method #2: Accepts a WebElement and text input to enter in a field
    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }

    // =======================
    // Get Text from WebElement
    // =======================

    // Overloaded method #1: Accepts a By locator and returns the visible text of the element
    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    // Overloaded method #2: Accepts a WebElement and returns its visible text
    public String getText(WebElement by) {
        return by.getText();
    }

}






















/*
This program is a base class containing common reusable methods for all page classes in a Selenium Page Object Model (POM) structure.
It is designed to promote reusability, reduce code duplication, and simplify the code in individual page classes.

The purpose of this program is to:
Centralize all common actions used across different page objects like clicking, entering input, retrieving text, and opening specific URLs.
Provide a foundation for all page classes so that they can inherit and use these shared utilities.
Improve maintainability and scalability of the test automation framework.


The CommonToAllPage class contains the following methods:
openVWOUrl(): Opens the VWO website URL specified in the properties file.
openOrangeHRMUrl(): Opens the OrangeHRM website URL specified in the properties file.
clickElement(By by): Clicks on a web element identified by the given locator.
clickElement(WebElement by): Clicks on a web element directly provided.
enterInput(By by, String key): Enters the provided key into a web element identified by the given locator.
enterInput(WebElement by, String key): Enters the provided key into a web element directly provided.
getText(By by): Retrieves the text content of a web element identified by the given locator.
getText(WebElement by): Retrieves the text content of a web element directly provided.

The CommonToAllPage constructor is currently empty, but it can be used to perform any initialization tasks that are common across all page objects.


Conditions
The program assumes that the WebDriver is already initialized and the browser is running (getDriver() must return a valid instance).
The locators provided must match elements present in the DOM.
The PropertiesReader.readKey() must be correctly implemented to fetch property values from a configuration file.


Expected Output
URLs open correctly based on configuration.
Elements are clicked or populated with input correctly.
Text is retrieved correctly from the element.



 */