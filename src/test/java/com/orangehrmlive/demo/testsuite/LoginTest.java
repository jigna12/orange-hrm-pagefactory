package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
    LoginPage loginPage;
    AdminPage adminPage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;
    HomePage homePage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity","regression"},priority = 0)
//1. verifyUserShouldLoginSuccessFully()
    public void verifyUserShouldLoginSuccessFully() {
        //Enter username
        loginPage.enterUserName("Admin");
        //Enter password
        loginPage.enterPassword("admin123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify "WelCome" Message
        homePage.getverifyWelcomeText();
    }
    @Test(groups = {"sanity","smoke","regression"},priority = 1)
//2. verifyThatTheLogoDisplayOnHomePage()
    public void verifyThatTheLogoDisplayOnHomePage() {
        //Login To The application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        //Verify Logo is Displayed
        String expectedMessage = homePage.getverifyOrangeHRMlogoText();
        Assert.assertEquals("", expectedMessage, "Message not found");
    }
    //3. verifyUserShouldLogOutSuccessFully()
    @Test(groups = {"regression"},priority = 3)
    public void verifyUserShouldLogOutSuccessFully() {
        //Login To The application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        //Click on User Profile logo
        homePage.clickOnOrangeHRMlogo();
        //Mouse hover on "Logout" and click
       // homePage.clickOnLogout();
        //Verify the text "Login Panel" is displayed
        loginPage.getverifyLoginPaneltext();
    }
}
