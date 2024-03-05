package com.enoca.ecommercetest.page;

import com.enoca.ecommercetest.utility.BaseClass;
import com.enoca.ecommercetest.utility.FunctionLibrary;
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
    @FindAll(@FindBy(xpath = "//div[@id=\"cl-product-grid\"]/div"))
    List<WebElement> listOfItem;
    @FindBy(xpath = "//select[@id='size-select']")
    WebElement dropDownBedensec;
    @FindAll(@FindBy(xpath = "//select[@id=\"size-select\"]/option"))
    List<WebElement> listBeden;
    @FindAll(@FindBy(xpath = "//span[text()=\"Stoğa Gelince Haber Ver\"]"))
    List<WebElement> listStogaGelinceHaberVer;
    @FindBy(xpath = "//button[@class=\"add-to-cart-button cl-big-button\"]")
    WebElement buttonSepetEkle;
    @FindBy(xpath = "//a[@class=\"cl-product-card-title\"]")
    WebElement itemInSepet;
    @FindBy(xpath = "//span[@class=\"cl-product-price\"]")
    WebElement priceInSepet;
    @FindBy(xpath = "//h1[@class=\"cl-product-title\"]")
    WebElement itemInSepetEkle;
    @FindBy(xpath = "//p[@class=\"cl-product-price\"]/span")
    WebElement priceInSepetEkle;




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
        //functionLibrary.waitForElementPresent(listOfItem.get(0));
        listOfItem.get(0).click();

        functionLibrary.waitForElementPresent(dropDownBedensec);
        //dropDownBedensec.click();
        actions.click(dropDownBedensec);
        Select select1= new Select(dropDownBedensec);
        do {
            select1.selectByIndex(random.nextInt(listBeden.size()));

        }while (listStogaGelinceHaberVer.get(0).isEnabled());
        functionLibrary.waitForElementPresent(buttonSepetEkle);
        buttonSepetEkle.click();

    }
    public boolean verifyAddToCart(){
        dashBoardPage.openSepetim();
        functionLibrary.waitForElementPresent(itemInSepet);
        String itemNameInSepet = itemInSepet.getText();
        String itemPriceInSepet = priceInSepet.getText();
        String itemNameInSepetEkle = itemInSepetEkle.getText();
        String itemPriceInSepetEkle = priceInSepetEkle.getText();
        return itemNameInSepet.equalsIgnoreCase(itemNameInSepetEkle)
                &&itemPriceInSepet.equalsIgnoreCase(itemPriceInSepetEkle);

    }
}
