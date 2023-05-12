package com.nopcommerce.testsuite;

import com.nopcommerce.Pages.HomePage;
import com.nopcommerce.Pages.LoginPage;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessFully()
    {
        homePage.clickOnLoginLink();
        loginPage.verifyWelcomeText();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyErrorMessageWithInvalidCredentials() {
        homePage.clickOnLoginLink();

        loginPage.userDetail("rashangs@yahoo.co.uk","prime123");
        loginPage.getErrorMessage();

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials()
    {
        homePage.clickOnLoginLink();
        loginPage.userDetail("rashangs@yahoo.co.uk","prime@123");
        loginPage.verifyLogOutLink();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLogOutSuccessFully()
    {
        homePage.clickOnLoginLink();
        loginPage.userDetail("rashangs@yahoo.co.uk","prime@123");
        homePage.clickOnLogOutLink();
        loginPage.verifyLoginLink();
    }
}
