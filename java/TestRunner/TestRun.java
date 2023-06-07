package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber->  TestNG, junit

@CucumberOptions(features = "src/test/java/AppFeatures/Dashboard.feature", glue = "StepDefinations", monochrome = true, plugin = {
		"pretty" })
public class TestRun extends AbstractTestNGCucumberTests {
	public void success() {
		System.out.println("test run successfully");
	}

}
