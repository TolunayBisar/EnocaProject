package com.enoca.ecommercetest.page;

import com.enoca.ecommercetest.utility.BaseClass;
import com.enoca.ecommercetest.utility.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : tolunaybisar
 * @created : 5.03.2024,16:48
 * @Email :tolunay.bisar@gmail.com
 **/
public class LoginPage extends BaseClass {
    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    @FindBy(id = "Email")
    WebElement inputEmail;
    @FindBy(id = "Password")
    WebElement inputPassword;
    @FindBy(xpath = "//input[@value=\"GİRİŞ YAP\"]")
    WebElement buttonGirisYap;
    @FindBy(xpath = "//span[text()=\"Müşteri Bilgilerim\"]")
    WebElement linkMusteriBilgi;

    public LoginPage(WebDriver driver) {
        functionLibrary = new FunctionLibrary();
        dashBoardPage= new DashBoardPage(driver);
        PageFactory.initElements(driver,this);

    }

    public void logIn(){
        functionLibrary.waitForElementPresent(inputEmail);
        inputEmail.sendKeys(FunctionLibrary.readFromConfig("config.properties",
                "username"));
        functionLibrary.waitForElementPresent(inputPassword);
        inputPassword.sendKeys(FunctionLibrary.readFromConfig("config.properties",
                "password"));
        functionLibrary.waitForElementPresent(buttonGirisYap);
        buttonGirisYap.click();

    }
    public boolean verifyLogin(){
        functionLibrary.waitForElementPresent(dashBoardPage.linkOfHesabim);
        dashBoardPage.linkOfHesabim.click();
        functionLibrary.waitForElementPresent(linkMusteriBilgi);
        linkMusteriBilgi.click();
        functionLibrary.waitForElementPresent(inputEmail);
        String mailInLoginPage = inputEmail.getAttribute("value");
        return mailInLoginPage.equalsIgnoreCase(FunctionLibrary.readFromConfig(
                "config.properties","username"));

    }
}
