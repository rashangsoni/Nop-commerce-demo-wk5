package com.nopcommerce.Pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class DesktopsPage extends Utility {

    public DesktopsPage(){
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement desktopsText;

    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Build your own computer']")
    WebElement productName;

    public void verifyDesktopsText(){
        Reporter.log("Verify Desktops Text");
        String expectedMessage = "Desktops";
        String actualMessage = getTextFromElement(desktopsText);
        Assert.assertEquals(expectedMessage, actualMessage);
        CustomListeners.test.log(Status.PASS, "Verify Desktops Text");
    }
    public void clickOnProductName() {
        Reporter.log("Click on Product Name");
        clickOnElement(productName);
        CustomListeners.test.log(Status.PASS, "Click on Product Name");
    }

}

