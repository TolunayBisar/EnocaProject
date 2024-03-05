package com.enoca.ecommercetest.utility;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : tolunaybisar
 * @created : 4.03.2024,23:22
 * @Email :tolunay.bisar@gmail.com
**/public class BaseClass {
    public static WebDriver driver;

    public void setUpBrowser(String url) {
        ChromeOptions options = new ChromeOptions();
//        WebDriverManager.chromedriver().setup();

        if (SystemUtils.IS_OS_LINUX){
            options.addArguments("headless");
            options.addArguments("window-size=1200,1080");
            options.addArguments("disable-gpu");
        }
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver= new ChromeDriver(options);
        if (SystemUtils.IS_OS_MAC_OSX||SystemUtils.IS_OS_WINDOWS) {
            driver.manage().window().maximize();


        }

        driver.get(url);
        driver.manage().deleteAllCookies();
    }



    public static void closeBrowser() {

        try {
            driver.close();
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
