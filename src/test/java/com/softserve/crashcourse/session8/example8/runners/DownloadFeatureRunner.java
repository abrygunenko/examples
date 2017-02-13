package com.softserve.crashcourse.session8.example8.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/com/softserve/crashcourse/session8/example8/features/Download.feature",
        glue = "com.softserve.crashcourse.session8.example8.glue",
        format = {"pretty"})
public class DownloadFeatureRunner extends AbstractTestNGCucumberTests {
}
