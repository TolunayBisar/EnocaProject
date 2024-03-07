package com.enoca.ecommercetest.regressiontest.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author : tolunaybisar
 * @created : 7.03.2024,12:17
 * @Email :tolunay.bisar@gmail.com
 **/

    @RunWith(Cucumber.class)
    @CucumberOptions(







            features = "classpath:features/",









            plugin ={
                    "pretty",
                    "html:target/cucumber-html-report.html",
                    "json:target/cucumber-json-report.json",
                    "junit:target/cucumber-xml-report.xml "
            },


            tags = "")


    public class CucumberTestRunner  {

    }

