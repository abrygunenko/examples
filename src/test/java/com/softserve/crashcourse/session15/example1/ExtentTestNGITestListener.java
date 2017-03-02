package com.softserve.crashcourse.session15.example1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static com.softserve.crashcourse.session15.example1.ScreenshotHelper.captureScreenShot;

public class ExtentTestNGITestListener implements ITestListener {

    private static String reportDirectoryPath = "target/extent/";
    private static String reportFileName = "extent.html";
    private static ExtentReports extent = ExtentManager.createInstance(reportDirectoryPath + reportFileName);
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal();

    @Override
    public synchronized void onStart(ITestContext context) {
        ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        ExtentTest child = parentTest.get().createNode(result.getMethod().getMethodName());
        test.set(child);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
//        test.get().fail("details", MediaBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.get().fail(result.getThrowable());

        String screenshotPath = captureScreenShot();

        try {
            test.get().addScreenCaptureFromPath(screenshotPath);
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

    }
}
