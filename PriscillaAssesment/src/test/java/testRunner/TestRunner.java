package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/features"},
        tags = "@testing",
        glue= {"stepdefinition"},
        dryRun = false,
        plugin ={ //"pretty","json:target/cucumber-reports/AutoumationReport/priscillareports.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:target/cucumber-reports/reports.html"
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/AutomationReports/EDBCreditCards.html"
               },

        monochrome = true)
public class TestRunner {}
