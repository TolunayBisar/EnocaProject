package com.enoca.ecommercetest.page;

import com.enoca.ecommercetest.utility.BaseClass;
import com.enoca.ecommercetest.utility.FunctionLibrary;
import com.enoca.ecommercetest.utility.ScreenShotUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import static com.enoca.ecommercetest.utility.FunctionLibrary.readFromConfig;

/**
 * @author : tolunaybisar
 * @created : 6.03.2024,14:06
 * @Email :tolunay.bisar@gmail.com
 **/
public class CheckOutPage extends BaseClass {
    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    Random random = new Random();


    @FindBy(xpath = "//div[text()=\"KOPYALA\"]")
    WebElement buttonIndirimKod;
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
    WebElement buttonSiparisTamamla;
    @FindBy(xpath = "//p[text()=\"Ödeminizi tamamlamak için lütfen Üyelik Sözleşmesini onaylayın. Teşekkürler!\"]")
    WebElement uyariMsg;
    @FindBy(css = "path[d=\"M10,10 L22,22 M22,10 L10,22\"]")
    WebElement linkCloseIcon;

    @FindBy(xpath = "//div[@id=\"cl-readandaccept\"]//span[@class=\"cl-checkmark\"]")
    WebElement checkBoxOnayBilgi;

    String uyariMsj;


    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary();
        dashBoardPage = new DashBoardPage(driver);
    }

    public void checkOut() {
    functionLibrary.waitForElementPresent(inputPromosyonKod);
        inputPromosyonKod.sendKeys(functionLibrary.timeStamp());
        functionLibrary.waitForElementPresentClick(buttonUygula);
        buttonUygula.click();
        functionLibrary.waitForElementPresent(hataMsg);
        ScreenShotUtility.takeScreenshot("hataliMesaj");
        String hataliMsg = hataMsg.getText();
        System.out.println(hataliMsg);
        functionLibrary.waitForElementPresentClick(buttonSatinAl);
        //buttonSatinAl.click();
        functionLibrary.javaScripClick(buttonSatinAl);
        functionLibrary.waitForElementPresentClick(buttonYeniAdresEkle);
        buttonYeniAdresEkle.click();
        functionLibrary.waitForElementPresent(inputAdresKolayAdi);
        inputAdresKolayAdi.sendKeys("zeynep" + functionLibrary.timeStamp());
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
        inputAdres1.sendKeys(functionLibrary.randomText() + functionLibrary.randomText());
        functionLibrary.waitForElementPresent(inputAdres2);
        inputAdres2.sendKeys(functionLibrary.randomText() + functionLibrary.randomText());
        functionLibrary.waitForElementPresentClick(buttonKayıtOl);
        // buttonKayıtOl.click();
        functionLibrary.javaScripClick(buttonKayıtOl);

        functionLibrary.waitForElementPresentClick(buttonDevamEt);
        // buttonDevamEt.click();
        functionLibrary.javaScripClick(buttonDevamEt);
        functionLibrary.waitForElementPresent(inputHolderName);
        inputHolderName.sendKeys(functionLibrary.generateFakeName());
        functionLibrary.waitForElementPresent(inputCartNo);
        inputCartNo.sendKeys(functionLibrary.timeStamp()+functionLibrary.timeStamp());
        functionLibrary.waitForElementPresent(inputCodeCVV);
        inputCodeCVV.sendKeys(functionLibrary.timeStamp());
        functionLibrary.waitForElementPresent(checkBoxOnayBilgi);
        checkBoxOnayBilgi.click();
        functionLibrary.waitForElementPresentClick(buttonSiparisTamamla);
        //functionLibrary.javaScripClick(buttonSiparisTamamla);
        buttonSiparisTamamla.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        ScreenShotUtility.takeScreenshot("uyariMesaj");
        uyariMsj = alert.getText();
        System.out.println(uyariMsg);


    }

    public boolean verifyCheckOut() {
        return uyariMsj.equalsIgnoreCase("Ödeme bilgileri eksik ya da hatalı");
    }

    public void closeWarningAlert() {
        functionLibrary.waitForElementPresentClick(linkCloseIcon);
        linkCloseIcon.click();
    }
}
