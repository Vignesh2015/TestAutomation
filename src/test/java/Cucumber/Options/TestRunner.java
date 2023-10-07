package Cucumber.Options;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
  plugin = "json:target/jsonReports/cucumber-report.json",
  glue = {"StepDefinitions"}
        //tags={"@GetPlaceAPI,@DeletePlaceAPI"}
        )

public class TestRunner {

    //tags={"@DeletePlaceAPI"}


    }

