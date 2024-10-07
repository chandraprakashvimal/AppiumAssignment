package runner;

import java.io.IOException;

import org.appium.utility.AppiumServer;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/featureFiles",
        glue = {"stepDefinitions"},
        plugin = { "pretty", "html:target/cucumber-reports/Cucumber.html" },
        monochrome = true,
        publish = true,
        dryRun = false
)

@Test
public class TestRunner extends AbstractTestNGCucumberTests {
    public static AppiumDriver driver;

    @BeforeSuite
    public void setUp() throws IOException {
        AppiumServer.startServer();
    }

    @AfterSuite
    public void tearDown() {
        AppiumServer.stopServer();
    }


}