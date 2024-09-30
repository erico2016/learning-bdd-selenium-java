package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/resources/features/cermati_signup.feature",
        glue = "stepDefinitions",
        plugin = {"pretty","html:target/htmlReport.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
