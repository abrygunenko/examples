package com.softserve.crashcourse.session8.example8.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features/session8/example8/Download.feature",
        glue = "com.softserve.crashcourse.session8.example8.glue",
        format = {"pretty"})
public class DownloadFeatureRunner extends AbstractTestNGCucumberTests {
}
