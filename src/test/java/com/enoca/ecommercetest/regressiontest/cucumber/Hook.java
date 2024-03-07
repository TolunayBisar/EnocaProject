package com.enoca.ecommercetest.regressiontest.cucumber;

import com.enoca.ecommercetest.utility.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.enoca.ecommercetest.utility.FunctionLibrary.readFromConfig;

/**
 * @author : tolunaybisar
 * @created : 7.03.2024,12:18
 * @Email :tolunay.bisar@gmail.com
 **/
public class Hook extends BaseClass {
    @Before
    public void setUp(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@UiTest")) {
            scenario.log("Begin with UI Automation Test");

            setUpBrowser(readFromConfig("config.properties", "url"));

        }}


        @After
        public void tearDown(Scenario scenario){
            if (scenario.getSourceTagNames().contains("@UiTest")) {
                scenario.log("End with UI Automation Test");
                closeBrowser();
            }

        }
    }