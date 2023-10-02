package StepDefinations;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/GoogleSearchFromConfigFile.feature", glue = {
		"StepDefinations" }, monochrome = true, plugin = { "pretty", "junit:target/JUnitReports/report.xml",
				"html:target/HtmlReports", "json:target/JSONReports/report.json" }
//,tags ="@smoketest" //if want to add tagged ones
)

public class RunnerClass {

}
