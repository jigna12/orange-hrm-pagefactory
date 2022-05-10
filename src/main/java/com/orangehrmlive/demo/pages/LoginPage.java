package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.awt.*;

public class LoginPage extends Utility {
    /*1.LoginPage - Store usename, password, Login Button and LOGIN Panel text Locators
and create appropriate methods for it.*/
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

     @FindBy(name = "txtUsername")
     WebElement Username;
    @FindBy(name = "txtPassword")
    WebElement Password;
    @FindBy(id = "btnLogin")
    WebElement LoginButton;
    @FindBy(id = "frmLogin")
    WebElement LOGINPaneltext;

    public void enterUserName(String username) {
        Reporter.log("enter User Name" + Username.toString());
        sendTextToElement(Username,username);
    }
    public void enterPassword(String password){
        sendTextToElement(Password,password);
    }
    public void clickOnLoginButton(){
        clickOnElement(LoginButton);
    }
    public String getverifyLoginPaneltext(){
        return getTextFromElement(LOGINPaneltext);
    }
}
