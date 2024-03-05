package com.enoca.ecommercetest.page;

import com.enoca.ecommercetest.utility.BaseClass;
import com.enoca.ecommercetest.utility.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : tolunaybisar
 * @created : 4.03.2024,23:27
 * @Email :tolunay.bisar@gmail.com
 **/
public class CarkifelekPage extends BaseClass {
    FunctionLibrary functionLibrary;
    @FindBy(xpath = "//div[text()=\"ÇARKI ÇEVİR\"]")
    WebElement buttonCakirCevir;

    @FindBy(xpath = "//div[text()=\"KOPYALA\"]")
    WebElement buttonCKopyala;

    @FindBy(linkText = "TEBRİKLER!")
    WebElement successfulMsgTebrikler;

    @FindBy(css = ".ins-copy-to-clipboard editable")
    WebElement discountCode;

    @FindBy(xpath = "//div[text()=\"KOPYALANDI!\"]")
    WebElement buttonKopyalandi;
    @FindBy(xpath = "//div[@class=\"ins-element-content\"]/span")
    WebElement closeCakiFelek;

    @FindBy(xpath = "//div[@class='nav-header']//a[@class='nav-brand lee-brand active']//*[name()='svg']" +
            "//*[name()='path' and contains(@d,'M189.37,41')]")
    WebElement labelLee;

    public CarkifelekPage(WebDriver driver) {
        functionLibrary = new FunctionLibrary();
        PageFactory.initElements(driver,this);


    }

    public void clickOnCarkifelek(){
        functionLibrary.waitForElementPresent(buttonCakirCevir);
        buttonCakirCevir.click();

    }
    public boolean verifyCakirClicked(){
        return (successfulMsgTebrikler.isDisplayed()&& discountCode.isDisplayed());

    }
    public void getDiscountCode(){
        functionLibrary.waitForElementPresent(buttonCKopyala);
        buttonCKopyala.click();
    }
    public boolean verifyDiscountCodeSuccessfullyGotten(){
        functionLibrary.waitForElementPresent(buttonKopyalandi);
        return buttonKopyalandi.isDisplayed();

    }
    public void goToDashboard(){
        functionLibrary.waitForElementPresent(closeCakiFelek);
        closeCakiFelek.click();
    }
    public boolean verifyDashBoardPageOpened(){
        functionLibrary.waitForElementPresent(labelLee);
        return labelLee.isDisplayed();

    }

}
