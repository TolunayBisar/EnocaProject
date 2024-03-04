package com.enoca.ecommercetest.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author : tolunaybisar
 * @created : 4.03.2024,23:29
 * @Email :tolunay.bisar@gmail.com
 **/
public class FunctionLibrary {
    public static String readFromConfig(String fileName, String key) {
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value = properties.getProperty(key);
        return value;
    }


}
