package com.enoca.ecommercetest.page;

import com.enoca.ecommercetest.utility.BaseClass;
import com.enoca.ecommercetest.utility.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

/**
 * @author : tolunaybisar
 * @created : 4.03.2024,23:28
 * @Email :tolunay.bisar@gmail.com
 **/
public class AddToCartPage extends BaseClass {
    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    Random random = new Random();
    Actions actions ;

    @FindBy(xpath = "//select[@id=\"products-orderby\"]")
    WebElement dropDownSiralama;
    @FindAll(@FindBy(xpath = "//div[@id=\"cl-product-grid\"]//div//a[@class=\"cl-product-images\"]"))
    List<WebElement> listOfItem;
    @FindBy(xpath = "//select[@id='size-select']")
    WebElement dropDownBedensec;
    @FindAll(@FindBy(xpath = "//select[@id=\"size-select\"]/option[contains(@id,\"product\")]"))
    List<WebElement> listBeden;
    @FindAll(@FindBy(xpath = "//span[text()=\"Stoğa Gelince Haber Ver\"]"))
    List<WebElement> listStogaGelinceHaberVer;

    @FindBy(xpath = "//button[@class=\"add-to-cart-button cl-big-button\"]")
    WebElement buttonSepetEkle;

    @FindBy(xpath = "//div[@id=\"cl-fancy-added-to-cart\"]/div[@onclick=\"javascript:location.href='/cart'\"]")
    WebElement buttonSepetGit;
    @FindBy(xpath = "//a[@class=\"cl-product-card-title\"]")
    WebElement itemInSepet;
    @FindBy(xpath = "//span[@class=\"cl-product-price\"]")
    WebElement priceInSepet;
    @FindBy(xpath = "//h1[@class=\"cl-product-title\"]")
    WebElement itemInSepetEkle;
    @FindBy(xpath = "//p[@class=\"cl-product-price\"]/span")
    WebElement priceInSepetEkle;



    String itemNameInSepetEkle ;
    String itemPriceInSepetEkle ;



    public AddToCartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        functionLibrary= new FunctionLibrary();
        dashBoardPage = new DashBoardPage(driver);
        actions= new Actions(driver);
    }

    public void addToCart(){
        functionLibrary.waitForElementPresent(dropDownSiralama);
        dropDownSiralama.click();
        Select select= new Select(dropDownSiralama);
        select.selectByVisibleText("Fiyata Göre (Artan)");
        functionLibrary.sleep(5);
        functionLibrary.waitForElementPresent1(listOfItem.get(0));
        //actions.click(listOfItem.get(0));
        //listOfItem.get(0).click();
        functionLibrary.javaScripClick(listOfItem.get(0));

        functionLibrary.waitForElementPresent1(dropDownBedensec);
        //dropDownBedensec.click();
        actions.click(dropDownBedensec);
        Select select1= new Select(dropDownBedensec);
        int i;
        do {
            i= random.nextInt(listBeden.size());
            select1.selectByIndex(i);
            if (i>=listBeden.size()){
                i--;
            }else i++;

        }
        while (listBeden.get(i).getText().contains("Stoğa Gelince Haber Ver"));
         itemNameInSepetEkle = itemInSepetEkle.getText();
         itemPriceInSepetEkle = priceInSepetEkle.getText();
        functionLibrary.waitForElementPresent1(buttonSepetEkle);

        //buttonSepetEkle.click();
        //actions.click(buttonSepetEkle);
        functionLibrary.javaScripClick(buttonSepetEkle);
        functionLibrary.waitForElementPresent(buttonSepetGit);
        buttonSepetGit.click();

    }
    public boolean verifyAddToCart(){
        //dashBoardPage.openSepetim();
        functionLibrary.waitForElementPresent(itemInSepet);
        String itemNameInSepet = itemInSepet.getText();
        String itemPriceInSepet = priceInSepet.getText();

        return itemNameInSepet.equalsIgnoreCase(itemNameInSepetEkle)
                &&itemPriceInSepet.equalsIgnoreCase(itemPriceInSepetEkle);

    }
}
