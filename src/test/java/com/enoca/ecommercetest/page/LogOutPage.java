package com.enoca.ecommercetest.page;

import com.enoca.ecommercetest.utility.BaseClass;
import com.enoca.ecommercetest.utility.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : tolunaybisar
 * @created : 6.03.2024,21:11
 * @Email :tolunay.bisar@gmail.com
 **/
public class LogOutPage extends BaseClass {
    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    @FindBy(xpath = "//span[text()=\"Çıkış Yap\"]")
    WebElement linkCikisYap;
    @FindBy(xpath = "//h2[text()=\"Üye Girişi\"]")
    WebElement labelUyeGirisi;

    public LogOutPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        functionLibrary= new FunctionLibrary();
        dashBoardPage = new DashBoardPage(driver);
    }

    public void logOut(){
        dashBoardPage.openHesabim();
        functionLibrary.waitForElementPresentClick(linkCikisYap);
        linkCikisYap.click();
    }

    public boolean verifyLogOut(){
   dashBoardPage.openHesabim();
   functionLibrary.waitForElementPresent(labelUyeGirisi);
   return labelUyeGirisi.isDisplayed();

    }
}
