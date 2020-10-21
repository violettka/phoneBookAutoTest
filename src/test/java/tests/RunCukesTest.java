package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber-report.json", "pretty"},
        tags = "@test",
        glue = {"src/test/java/tests"},
        features = {"src/test/resources"}

)
public class RunCukesTest extends AbstractTestNGCucumberTests {
}

