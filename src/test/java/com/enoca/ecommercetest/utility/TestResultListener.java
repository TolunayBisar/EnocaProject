package com.enoca.ecommercetest.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.enoca.ecommercetest.utility.ScreenShotUtility.takeScreenshot;

/**
 * @author : tolunaybisar
 * @created : 4.03.2024,23:30
 * @Email :tolunay.bisar@gmail.com
 **/
public class TestResultListener extends BaseClass implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        takeScreenshot(result.getMethod().getMethodName().trim() + " -Success");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(result.getMethod().getMethodName().trim() + "_Failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        result.getMethod();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

}


