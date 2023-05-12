package com.nopcommerce.testsuite;

import com.nopcommerce.Pages.BuildComputer;
import com.nopcommerce.Pages.ComputerPage;
import com.nopcommerce.Pages.DesktopsPage;
import com.nopcommerce.Pages.HomePage;
import com.nopcommerce.customlisteners.CustomListeners;
import com.nopcommerce.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;


@Listeners(CustomListeners.class)
public class ComputerTest extends BaseTest {
    ComputerPage computerPage;
    HomePage homePage;
    DesktopsPage desktopsPage;
    BuildComputer buildComputer;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        computerPage = new ComputerPage();
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        buildComputer = new BuildComputer();
    }

    @Test(dataProvider = "productName", dataProviderClass = TestData.class)
    public void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram,
                                                                                    String hdd, String os, String software) throws InterruptedException {
        homePage.clickOnComputerTab();
        computerPage.clickOnDesktopsLink();
        desktopsPage.clickOnProductName();

        buildComputer.buildProcessor(processor);
        buildComputer.buildRam(ram);
        if (hdd.equalsIgnoreCase("320 GB")){
            buildComputer.clickOnHDD320GB();
        }else {
            buildComputer.clickOnHDD400GB();
        }

        if (os.equalsIgnoreCase("Vista Home [+$50.00]")){
            buildComputer.setOsVistaHome();
        }else {
            buildComputer.setOsVistaPremium();
        }
        buildComputer.buildOs(os);
        Thread.sleep(5000);
        buildComputer.setMsOffice();
        if(software.equalsIgnoreCase("Microsoft Office [+$50.00]")){
            buildComputer.setMsOffice();
        } else if (software.equalsIgnoreCase("Acrobat Reader [+$10.00]")) {
            buildComputer.setAcrobatReader();

        }else {
            buildComputer.setCommander();
        }
        buildComputer.buildAddToCArt();
    }
}
