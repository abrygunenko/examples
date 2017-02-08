package com.softserve.crashcourse.session8.example9.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features/Download.feature",
        glue = "com.softserve.crashcourse.session8.example9.glue",
        format = {"pretty"})
public class DownloadFeatureRunner extends AbstractTestNGCucumberTests {
}
