package stepdefinition;
import Utility.PropertiesFileReader;
import base.BaseClass;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pageObject.SearchPageObject;


import java.util.Properties;

import static base.BaseClass.takeScreenShot;

public class StepDefination extends BaseClass {
    PropertiesFileReader obj=new PropertiesFileReader();
    SearchPageObject searchPageObject;
    private Scenario scenario;

    private final Logger logger = Logger.getLogger(StepDefination.class);

    @Before
    public void initializeScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            takeScreenShot(scenario);
        }

        try {
            driver.quit();
        }
        catch(Exception e) {
            System.out.println(String.valueOf(e));
        }
    }

    @Given("I open a browser and enter url")
    public void i_open_a_browser_and_enter_url() throws Exception {
        Properties properties=obj.getProperty();
        System.out.println(properties);
        openBrowser( properties.getProperty("browser.baseURL"));
    }

    @When("when I search for {string}")
    public void when_I_search_for(String name) {
        searchPageObject= new SearchPageObject(driver);
        searchPageObject.Seach(name);
    }

    @Then("I should get it and add to cat")
    public void i_should_get_it_and_add_to_cat() {
        searchPageObject= new SearchPageObject(driver);
        searchPageObject.clickProduct();
    }

}
