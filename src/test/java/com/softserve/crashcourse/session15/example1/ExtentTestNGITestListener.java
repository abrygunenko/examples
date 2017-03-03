package com.softserve.crashcourse.session15.example1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.softserve.crashcourse.session15.example1.ScreenshotHelper.captureScreenShot;

public class ExtentTestNGITestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.createInstance("target/reports/TestListener.html");
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal();
    private Map<String, ExtentTest> parents = new HashMap<>();

    @Override
    public synchronized void onStart(ITestContext context) {

    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        String parentTestName = result.getTestClass().getName();

        if (parents.get(parentTestName) == null) {
            ExtentTest parent = extent.createTest(parentTestName);
            parents.put(parentTestName, parent);
        }

        parentTest.set(parents.get(parentTestName));
        ExtentTest childTest = parentTest.get().createNode(result.getMethod().getMethodName());
        test.set(childTest);
        test.get().assignCategory(result.getMethod().getGroups());
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        String screenshotPath = captureScreenShot();
        try {
            test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        test.get().fail(result.getThrowable());
    }
}
