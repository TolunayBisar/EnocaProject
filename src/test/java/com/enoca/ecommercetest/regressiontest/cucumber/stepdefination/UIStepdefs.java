package com.enoca.ecommercetest.regressiontest.cucumber.stepdefination;

import com.enoca.ecommercetest.page.*;
import com.enoca.ecommercetest.utility.BaseClass;
import com.enoca.ecommercetest.utility.FunctionLibrary;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author : tolunaybisar
 * @created : 7.03.2024,12:53
 * @Email :tolunay.bisar@gmail.com
 **/
public class UIStepdefs extends BaseClass {
    FunctionLibrary functionLibrary = new FunctionLibrary();
    CarkifelekPage carkifelekPage = new CarkifelekPage(driver);
    DashBoardPage dashBoardPage = new DashBoardPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyCartPage myCartPage = new MyCartPage(driver);
    AddToCartPage addToCartPage = new AddToCartPage(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);
    LogOutPage logOutPage = new LogOutPage(driver);

    @Given("User login and on dashboard page")
    public void userLoginAndOnDashboardPage() {
        dashBoardPage.closeCookie();
//        carkifelekPage.clickOnCarkifelek();
//        carkifelekPage.getDiscountCode();
        //carkifelekPage.closeCarkifelek();
        dashBoardPage.openHesabim();
        loginPage.logIn();
        loginPage.verifyLogin();

    }

    @When("User can go to the cart and clear it")
    public void userCanGoToTheCartAndClearIt() {
        myCartPage.clearSepetim();



    }

    @Then("Cart should be empty")
    public void cartShouldBeEmpty() {
        myCartPage.verifySepetimEmpity();
    }

    @When("User select random item and add to the cart")
    public void userSelectRandomItemAndAddToTheCart() {
        dashBoardPage.clickTabOnDashBoard();
        addToCartPage.addToCart();
    }

    @Then("there is item in cart")
    public void thereIsItemInCart() {
        addToCartPage.verifyAddToCart();
    }

    @When("User go to the cart")
    public void userGoToTheCart() {
        dashBoardPage.openSepetim();
    }

    @And("User check out with Fake Credit Card")
    public void userCheckOutWithFakeCreditCard() {
        checkOutPage.checkOut();
    }

    @Then("There should be warning massage about credit card no.")
    public void thereShouldBeWarningMassageAboutCreditCardNo() {
        checkOutPage.verifyCheckOut();
    }

    @When("User go to my cart")
    public void userGoToMyCart() {
        dashBoardPage.openSepetim();
    }

    @And("User add quantity in cart")
    public void userAddQuantityInCart() {
        myCartPage.addItemInCart();
    }

    @Then("Item quantity added successfully")
    public void itemQuantityAddedSuccessfully() {
        myCartPage.verifyItemAddedInCart();
    }

    @When("User logout")
    public void userLogout() {
        logOutPage.logOut();
    }

    @Then("User logout successfully")
    public void userLogoutSuccessfully() {
        logOutPage.verifyLogOut();
    }
}
