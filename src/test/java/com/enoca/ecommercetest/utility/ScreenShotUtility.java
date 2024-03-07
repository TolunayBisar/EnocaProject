package com.enoca.ecommercetest.utility;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.enoca.ecommercetest.utility.FunctionLibrary.readFromConfig;

/**
 * @author : tolunaybisar
 * @created : 4.03.2024,23:30
 * @Email :tolunay.bisar@gmail.com
 **/
public class ScreenShotUtility extends BaseClass {
    public static void takeScreenshot(String fileName) {
        DateTime dt1 = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm-ss-SSS");
        String timestamp = dt1.toString(formatter);
        fileName = fileName + "-" + timestamp;
        String imageFolder = readFromConfig("config.properties","imageFolder") ;
        File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(imageFile, new File(imageFolder + File.separator + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
