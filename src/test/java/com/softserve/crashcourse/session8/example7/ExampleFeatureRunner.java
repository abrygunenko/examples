package com.softserve.crashcourse.session8.example7;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/com/softserve/crashcourse/session8/example7/features/Example.feature",
        glue = "com.softserve.crashcourse.session8.example7",
        format = {"pretty"})
public class ExampleFeatureRunner extends AbstractTestNGCucumberTests {
}
