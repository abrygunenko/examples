package com.softserve.crashcourse.session15.example1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.softserve.crashcourse.session15.example1.ScreenshotHelper.captureScreenShot;


public class ExtentTestNGReportBuilder {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal();

    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.createInstance("target/reports/ReportBuilder.html");
    }

    @BeforeClass
    public synchronized void beforeClass() {
        ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
        ExtentTest child = parentTest.get().createNode(method.getName());
        test.set(child);
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getTestName() != null) {
            test.get().getModel().setName(result.getTestName());
        }
        test.get().assignCategory(result.getMethod().getGroups());
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.get().pass("Test passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.get().skip(result.getThrowable());
        } else {
            String screenshotPath = captureScreenShot();
            try {
                test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        extent.flush();
    }
}
