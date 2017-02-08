package com.softserve.crashcourse.session8.example8;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features/Example.feature",
        glue = "com.softserve.crashcourse.session8.example8",
        format = {"pretty"})
public class ExampleFeatureRunner extends AbstractTestNGCucumberTests {
}
