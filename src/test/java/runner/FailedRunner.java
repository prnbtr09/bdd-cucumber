package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed.txt",
        glue = {"stepDefs", "hooks"},
//        tags = "@testNG",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
public class FailedRunner extends AbstractTestNGCucumberTests {
}
