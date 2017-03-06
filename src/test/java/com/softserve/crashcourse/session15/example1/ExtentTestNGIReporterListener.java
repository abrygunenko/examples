package com.softserve.crashcourse.session15.example1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.*;

public class ExtentTestNGIReporterListener implements IReporter {

    private ExtentReports extent;
    private Map<String, ExtentTest> parents = new HashMap<>();

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        extent = ExtentManager.createInstance("target/reports/ReporterListener.html");
        extent.setReportUsesManualConfiguration(true);

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
                buildTestNodes(context.getPassedTests(), Status.PASS);
                buildTestNodes(context.getFailedButWithinSuccessPercentageTests(), Status.FAIL);
            }
        }

        for (String s : Reporter.getOutput()) {
            extent.setTestRunnerOutput(s);
        }

        extent.flush();
    }

    private void buildTestNodes(IResultMap tests, Status status) {
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                String parentTestName = result.getTestClass().getName();

                if (parents.get(parentTestName) == null) {
                    ExtentTest parentTest = extent.createTest(parentTestName);
                    parentTest.getModel().setStartTime(getTime(result.getStartMillis()));
//                    parentTest.getModel().setName(result.getTestName());
//                    parentTest.getModel().setEndTime(getTime(result.getEndMillis()));
                    parents.put(parentTestName, parentTest);
                }

                ExtentTest childTest;
                if (result.getTestName() != null) {
                    childTest = parents.get(parentTestName).createNode(result.getTestName());
                } else {
                    childTest = parents.get(parentTestName).createNode(result.getMethod().getMethodName());
                }
                childTest.assignCategory(result.getMethod().getGroups());
                childTest.getModel().setStartTime(getTime(result.getStartMillis()));
                childTest.getModel().setEndTime(getTime(result.getEndMillis()));

                if (result.getThrowable() != null) {
                    childTest.log(status, result.getThrowable());

                    //  Doesn't work because report is generated after tests
                    // String screenshotPath = captureScreenShot();
                    // try {
                    //     test.addScreenCaptureFromPath(screenshotPath);
                    // } catch (IOException e) {
                    //     e.printStackTrace();
                    // }
                } else {
                    childTest.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
