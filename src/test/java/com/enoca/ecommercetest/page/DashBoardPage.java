package com.enoca.ecommercetest.page;

import com.enoca.ecommercetest.utility.BaseClass;
import com.enoca.ecommercetest.utility.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

/**
 * @author : tolunaybisar
 * @created : 5.03.2024,14:34
 * @Email :tolunay.bisar@gmail.com
 **/
public class DashBoardPage extends BaseClass {
    FunctionLibrary functionLibrary;
    Random random = new Random();
@FindAll(@FindBy(xpath = "//ul[@class=\"nav-menu\"]/li"))
    List<WebElement> tabsInDashBoard;
@FindBy(xpath = "//img[@title=\"Hesabım\"]")
    WebElement linkOfHesabim;
@FindBy(xpath = "//img[@title=\"Sepetim\"]")
WebElement linkSepetim;
@FindBy(id = "onetrust-accept-btn-handler")
WebElement buttonKabulEt;

    public DashBoardPage(WebDriver driver) {
        functionLibrary= new FunctionLibrary();
        PageFactory.initElements(driver,this);

    }

    public void closeCookie(){
        functionLibrary.waitForElementPresentClick(buttonKabulEt);
        buttonKabulEt.click();

    }
    public void openHesabim(){
        functionLibrary.waitForElementPresentClick(linkOfHesabim);
        linkOfHesabim.click();
    }
    public void openSepetim(){
        functionLibrary.waitForElementPresentClick(linkSepetim);
        linkSepetim.click();
    }

    public void clickTabOnDashBoard(){
        functionLibrary.waitForElementPresent(tabsInDashBoard.get(0));
        tabsInDashBoard.get(random.nextInt(3)).click();

    }
}
