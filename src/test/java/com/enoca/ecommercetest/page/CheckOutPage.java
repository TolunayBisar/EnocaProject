package com.enoca.ecommercetest.page;

import com.enoca.ecommercetest.utility.BaseClass;
import com.enoca.ecommercetest.utility.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

/**
 * @author : tolunaybisar
 * @created : 6.03.2024,14:06
 * @Email :tolunay.bisar@gmail.com
 **/
public class CheckOutPage extends BaseClass {
    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    Random random = new Random();
    @FindBy(xpath = "//span[@class=\"text\"]")
    WebElement checkBoxHediyePaket;
    @FindBy(id = "discountcouponcode")
    WebElement inputPromosyonKod;
    @FindBy(id = "applydiscountcouponcode")
    WebElement buttonUygula;
    @FindBy(xpath = "//span[text()=\"Girdiğiniz kupon kodu siparişinize uygulanamadı\"]")
    WebElement hataMsg;
    @FindBy(id = "checkout")
    WebElement buttonSatinAl;
    @FindBy(xpath = "//li[@id=\"opc-shipping\"]//div[text()=\"Yeni Adres Ekle\"]")
    WebElement buttonYeniAdresEkle;
    @FindBy(id = "ShippingNewAddress_CountryId")
    WebElement dropDownIl;
    @FindAll(@FindBy(xpath = "//select[@id=\"ShippingNewAddress_CountryId\"]/option[contains(@value,\"5e7f9\")]"))
    List<WebElement> listOfIl;
@FindBy(id = "ShippingNewAddress_StateProvinceId")
WebElement dropDownIlce;
@FindAll(@FindBy(xpath = "//select[@id=\"ShippingNewAddress_StateProvinceId\"]/option[contains(@value,\"5e7fa\")]"))
List<WebElement> listOfIlce;
@FindBy(id = "ShippingNewAddress_NeighborhoodId")
WebElement dropDownMahale;

    @FindAll(@FindBy(xpath = "//select[@id=\"ShippingNewAddress_NeighborhoodId\"]/option[contains(@value,\"5ff8\")]"))
    List<WebElement> listOfMahale;
    @FindBy(id = "ShippingNewAddress_Address1")
    WebElement inputAdres1;
@FindBy(id = "ShippingNewAddress_Address2")
WebElement inputAdres2;
@FindBy(xpath = "//div[@id=\"shipping-new-address-form\"]/" +
        "div[@class=\"enter-address\"]/div[@class=\"cl-address-edit-section\"]" +
        "/input[@value=\"Kaydet\"]")
WebElement buttonKayıtOl;
@FindBy(xpath = "//div[@class=\"fancybox-slide fancybox-slide--html fancybox-slide--current fancybox-slide--complete\"]//input[@placeholder=\"Adres Kolay Adı\"]")
WebElement inputAdresKolayAdi;
@FindBy(xpath = "//a[@class=\"checkout-nav-payment\"]")
WebElement linkOdeme;
@FindBy(xpath = "//li[@id=\"opc-shipping\"]//input[@value=\"Devam Et\"]")
WebElement buttonDevamEt;
@FindBy(id = "CardholderName")
        WebElement inputHolderName;
@FindBy(id = "CardNumber")
WebElement inputCartNo;
@FindBy(id = "CardCode")
WebElement inputCodeCVV;
@FindBy(id = "completeOrderButton")
WebElement buttonSiparişTamamla;
@FindBy(xpath = "//p[text()=\"Ödeminizi tamamlamak için lütfen Üyelik Sözleşmesini onaylayın. Teşekkürler!\"]")
WebElement uyariMsg;
    @FindBy(css = "path[d=\"M10,10 L22,22 M22,10 L10,22\"]")
    WebElement linkCloseIcon;


    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary();
        dashBoardPage = new DashBoardPage(driver);
    }

    public void checkOut(){
        functionLibrary.waitForElementPresentClick(checkBoxHediyePaket);
        checkBoxHediyePaket.click();
        functionLibrary.waitForElementPresent(inputPromosyonKod);
        inputPromosyonKod.sendKeys(functionLibrary.timeStamp());
        functionLibrary.waitForElementPresentClick(buttonUygula);
        buttonUygula.click();
        String hataliMsg= hataMsg.getText();
        System.out.println(hataliMsg);
        functionLibrary.waitForElementPresentClick(buttonSatinAl);
        //buttonSatinAl.click();
        functionLibrary.javaScripClick(buttonSatinAl);
        functionLibrary.waitForElementPresentClick(buttonYeniAdresEkle);
        buttonYeniAdresEkle.click();
        functionLibrary.waitForElementPresent(inputAdresKolayAdi);
        inputAdresKolayAdi.sendKeys("zeynep"+functionLibrary.timeStamp());
        functionLibrary.waitForElementPresent(dropDownIl);
        Select select = new Select(dropDownIl);
        select.selectByIndex(random.nextInt(listOfIl.size()));
        functionLibrary.waitForElementPresent(dropDownIlce);
        Select select1 = new Select(dropDownIlce);
        select1.selectByIndex(random.nextInt(listOfIlce.size()));
        functionLibrary.waitForElementPresent(dropDownMahale);
        Select select2 = new Select(dropDownMahale);
        select2.selectByIndex(random.nextInt(listOfMahale.size()));
        functionLibrary.waitForElementPresent(inputAdres1);
        inputAdres1.sendKeys(functionLibrary.randomText()+functionLibrary.randomText());
        functionLibrary.waitForElementPresent(inputAdres2);
        inputAdres2.sendKeys(functionLibrary.randomText()+functionLibrary.randomText());
        functionLibrary.waitForElementPresentClick(buttonKayıtOl);
       // buttonKayıtOl.click();
        functionLibrary.javaScripClick(buttonKayıtOl);

        functionLibrary.waitForElementPresentClick(buttonDevamEt);
       // buttonDevamEt.click();
        functionLibrary.javaScripClick(buttonDevamEt);
        functionLibrary.waitForElementPresent(inputHolderName);
        inputHolderName.sendKeys(functionLibrary.generateFakeName());
        functionLibrary.waitForElementPresent(inputCartNo);
        inputCartNo.sendKeys(functionLibrary.generateFakerCartNo());
        functionLibrary.waitForElementPresent(inputCodeCVV);
        inputCodeCVV.sendKeys(functionLibrary.timeStamp());
        functionLibrary.waitForElementPresentClick(buttonSiparişTamamla);
buttonSiparişTamamla.click();
functionLibrary.waitForElementPresent(uyariMsg);
String uyari = uyariMsg.getText();
        System.out.println(uyari);

    }
    public boolean verifyCheckOut(){
        return uyariMsg.getText().equalsIgnoreCase("Ödeminizi " +
                "tamamlamak için lütfen Üyelik Sözleşmesini onaylayın. Teşekkürler!");
    }

    public void closeWarningAlert(){
        functionLibrary.waitForElementPresentClick(linkCloseIcon);
        linkCloseIcon.click();
    }
}
