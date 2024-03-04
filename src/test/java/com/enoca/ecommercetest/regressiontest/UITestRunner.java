package com.enoca.ecommercetest.regressiontest;

import com.enoca.ecommercetest.utility.BaseClass;
import com.enoca.ecommercetest.utility.FunctionLibrary;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 4.03.2024,23:59
 * @Email :tolunay.bisar@gmail.com
 **/
public class UITestRunner extends BaseClass {

    @Test
    public void setUp(){
        setUpBrowser(FunctionLibrary.readFromConfig("config.properties","url"));
    }
}
