package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(

		glue = { "stepdefs" }, // Your step definitions package.
		format = { "pretty", "json:target/Result.json", "html:target/site/cucumber-pretty",
				"html:test-output" }, features = { "src/test/java/Features" })

public class TestRunner extends AbstractTestNGCucumberTests {

}
