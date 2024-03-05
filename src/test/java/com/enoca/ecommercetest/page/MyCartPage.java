package com.enoca.ecommercetest.page;

import com.enoca.ecommercetest.utility.BaseClass;
import com.enoca.ecommercetest.utility.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author : tolunaybisar
 * @created : 4.03.2024,23:28
 * @Email :tolunay.bisar@gmail.com
 **/
public class MyCartPage extends BaseClass {
    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    @FindAll(@FindBy(xpath = "//button[@onclick=\"deleteItemClick($(this))\"]"))
    List<WebElement> listOfDeleteButton;
    @FindBy(xpath = "//span[text()=\"Sepetim\"]")
    WebElement labelSepet;
    @FindBy(xpath = "//button[@onclick=\"acceptRemove()\"]")
    WebElement buttonSil;
    @FindBy(xpath = "//div[@class='cl-empty-cart-container']")
    WebElement labelSepetBos;
    @FindBy(xpath = "//button[@onclick=\"setLocation('/')\"]")
    WebElement buttonAlisverisBaslat;

    public MyCartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        functionLibrary= new FunctionLibrary();
        dashBoardPage = new DashBoardPage(driver);
    }
    public void clearSepetim(){
        dashBoardPage.openSepetim();
        functionLibrary.waitForElementPresent(labelSepet);
        if (listOfDeleteButton.size()>0){
            for (int i=0;i<listOfDeleteButton.size();i++){
                listOfDeleteButton.get(i).click();
                functionLibrary.waitForElementPresent(buttonSil);
                buttonSil.click();
            }
        }
    }
    public boolean verifySepetimEmpity(){
         functionLibrary.waitForElementPresent(labelSepetBos);
        return  labelSepetBos.getText().contains("Alışveriş sepetiniz boş!");

    }
    public void openShoppingPage(){
        functionLibrary.waitForElementPresent(buttonAlisverisBaslat);
        buttonAlisverisBaslat.click();

    }
}
