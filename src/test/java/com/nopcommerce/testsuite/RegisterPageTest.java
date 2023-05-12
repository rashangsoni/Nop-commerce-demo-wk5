package com.nopcommerce.testsuite;

import com.nopcommerce.Pages.RegisterPage;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    RegisterPage registerPage=new RegisterPage();

    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        registerPage = new RegisterPage();

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        registerPage.clickOnRegisterLink();
        Assert.assertEquals(registerPage.verifyRegisterText(),"Register");
    }
    @Test(groups = {"sanity","smoke","regression"})
    public void verifyThatFirstNameLastNameEmailOasswordAndConfirmPasswordFieldsAreMandetory(){
        registerPage.clickOnRegisterLink();
        registerPage.clickOnRegisterButton();
        registerPage.verifyFirstNameError();
        registerPage.verifyLastNameError();
        registerPage.verifyEmailError();
        registerPage.verifyPasswordError();
        registerPage.verifyConfirmPasswordError();
    }
    @Test(groups = {"regression"})
    public void VerifyThatUserShouldCreateAccountSuccessfully() throws InterruptedException {
//        Click on Register Link
        registerPage.clickOnRegisterLink();
//        Select gender "Female"
        registerPage.selectGender();
//        Enter firstname
        registerPage.sendFirstName();
//        Enter lastname
        registerPage.sendLastName();
//        Select day
        registerPage.sendBirthDay();
//        Select month
        registerPage.sendBirthMonth();
//        Select year
        registerPage.sendBirthYear();
//        Enter email
        registerPage.sendEmail("prime"+getAlphaNumericString(4)+"@gmail.com");
//        Enter password
        registerPage.sendPassword();
//        Enter Confirm Password
        registerPage.sendConfirmPassword();
//        Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
//        Verify message "Your registration completed"
        registerPage.registerCompleteText();
        Thread.sleep(3000);

    }

}
