package com.enoca.ecommercetest.regressiontest;

import com.enoca.ecommercetest.page.*;
import com.enoca.ecommercetest.utility.BaseClass;
import com.enoca.ecommercetest.utility.FunctionLibrary;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 4.03.2024,23:59
 * @Email :tolunay.bisar@gmail.com
 **/
public class UITestRunner extends BaseClass {
    CarkifelekPage carkifelekPage;
    DashBoardPage dashBoardPage;
    LoginPage loginPage;
    MyCartPage myCartPage;
    AddToCartPage addToCartPage;


    @BeforeClass
    public void setUp() {
        setUpBrowser(FunctionLibrary.readFromConfig("config.properties",
                "url"));
        carkifelekPage = new CarkifelekPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        loginPage = new LoginPage(driver);
        myCartPage = new MyCartPage(driver);
        addToCartPage = new AddToCartPage(driver);
    }


    @Test(enabled = false)
    public void carkifelekAllertClicked() {
        carkifelekPage.clickOnCarkifelek();
        carkifelekPage.verifyCakirClicked();
        carkifelekPage.getDiscountCode();
        carkifelekPage.verifyDiscountCodeSuccessfullyGotten();
        carkifelekPage.goToDashboard();

    }

    @Test(priority = 1)
    public void verifyDashBoardOpened() {
        carkifelekPage.verifyDashBoardPageOpened();
    }

    @Test(priority = 2)
    public void logIn() {
        dashBoardPage.openLoginPage();
        loginPage.logIn();
        Assert.assertTrue(loginPage.verifyLogin());

    }
    @Test(priority = 3)
    public void checkMyCart(){
        dashBoardPage.openSepetim();
        myCartPage.clearSepetim();
        Assert.assertTrue(myCartPage.verifySepetimEmpity());
    }

    @Test(priority = 4)
    public void addToCart(){
        myCartPage.openShoppingPage();
        dashBoardPage.clickTabOnDashBoard();
        addToCartPage.addToCart();
        Assert.assertTrue(addToCartPage.verifyAddToCart());

    }


    @AfterClass
    public void tearDown() {
        closeBrowser();

    }
}

