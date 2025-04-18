package com.prasad_v.pages.pageObjectModel.orangeHRM;

import com.prasad_v.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.prasad_v.utils.WaitHelpers.waitJVM;


public class LoginPageOrangeHRM_POM extends CommonToAllPage {

    WebDriver driver;
    public LoginPageOrangeHRM_POM(WebDriver driver)
    {
        this.driver = driver;
    }


    // page locators

    private By username = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By submit_btn = By.xpath("//button[normalize-space()='Login']");


    public void loginToHRCreds(String user, String pwd) {
        openOrangeHRMUrl();
        waitJVM(5000);
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(submit_btn);
        waitJVM(5000);


    }

}
