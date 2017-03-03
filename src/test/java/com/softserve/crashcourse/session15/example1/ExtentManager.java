package com.softserve.crashcourse.session15.example1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import static com.softserve.crashcourse.session15.example1.ScreenshotHelper.createDirectory;

public class ExtentManager {

    private static ExtentReports extent;
    private static final String OUTPUT_FOLDER = "target/reports/";
    private static final String FILE_NAME = "Extent.html";

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance(OUTPUT_FOLDER + FILE_NAME);
        }
        return extent;
    }

    public static ExtentReports createInstance(String fileName) {
        createDirectory(OUTPUT_FOLDER);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Extent Report");
        htmlReporter.config().setReportName("Test Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }
}