package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/feature/students.feature", 
    glue = "stepDefinitions", 
    plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/ExtentReport/checkpointReport.html", "html:target/cucumber-reports.html", "json:target/jsonReports.json"}, 
    monochrome = true ,
    
    tags="@smoketest"  
)
public class TestRunner {

}
