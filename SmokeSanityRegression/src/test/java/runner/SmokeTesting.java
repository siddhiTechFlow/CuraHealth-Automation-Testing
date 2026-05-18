package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources",
    glue = "stepdefinition",
    tags = "@Smoke",
    plugin = {"pretty", "html:target/cucumbersmoke-report.html"}
)
public class SmokeTesting extends AbstractTestNGCucumberTests {
}