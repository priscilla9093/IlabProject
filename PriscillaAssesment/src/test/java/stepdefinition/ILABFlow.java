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
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageObject.IlabPageObjects;
import pageObject.SearchPageObject;
import seleniumaction.SeleniumAction;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ILABFlow extends BaseClass {

    PropertiesFileReader obj=new PropertiesFileReader();
    SearchPageObject searchPageObject;
    SeleniumAction seleniumAction;
    public IlabPageObjects ilabPageObjects;
    private Scenario scenario;

    private final Logger logger = Logger.getLogger(ILABFlow.class);

    public ILABFlow() {
    }

    public ILABFlow(WebDriver driver) {
        super(driver);
    }

    @Before
    public void initializeScenario(Scenario scenario) throws Exception {
        this.scenario = scenario;
        Properties properties=obj.getProperty();
        System.out.println(properties);
        openBrowser( properties.getProperty("browser.baseURL"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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


    @Given("I want to apply from ILab side")
    public void iWantToApplyFromILabSide() throws InterruptedException {
        ilabPageObjects= new IlabPageObjects(driver);
       Assert.assertTrue("unable to click the careerLink",ilabPageObjects.clickCareeLink());
        logger.info("career link clicked");
    }

    @When("I click on careers")
    public void iClickOnCareers() {
    }

    @And("select south Africa link")
    public void selectSouthAfricaLink() throws InterruptedException {

        ilabPageObjects= new IlabPageObjects(driver);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
        System.out.println("Scroll down perfomed");
        Assert.assertTrue("unable to click the careerLink",ilabPageObjects.clickSouthAfrica());
        logger.info("south Africa has been cicked");
    }

    @And("select the the advertised Jobs")
    public void selectTheTheAdvertisedJobs() throws InterruptedException {
        ilabPageObjects= new IlabPageObjects(driver);
        Assert.assertTrue("unable to click on the job application",ilabPageObjects.clickFirstJob());
        //ilabPageObjects.clickFirstPost();
        logger.info("first job has been clicked");
    }

    @And("click on the apply online link")
    public void clickOnTheApplyOnlineLink() {

    }

    @And("I should be able to enter {string} {string} {string}")
    public void iShouldBeAbleToEnter(String name, String email, String cellNumb) throws InterruptedException {
        ilabPageObjects= new IlabPageObjects(driver);
        seleniumAction=new SeleniumAction(driver);

        Assert.assertTrue("unable to switch to frame",ilabPageObjects.swichToFrame());
        System.out.println("Switched");
        seleniumAction.scrollBy("0","1000");
        Thread.sleep(10);
        Assert.assertTrue("unable to type in the name",ilabPageObjects.CaptureName(name));
        Assert.assertTrue("unable to type in email address",ilabPageObjects.TypeEmail(email));
        Assert.assertTrue("unable to type in cell number",ilabPageObjects.TypeEmail(cellNumb));
    }

    @Then("i should be able to submit the application and quite the browser")
    public void iShouldBeAbleToSubmitTheApplicationAndQuiteTheBrowser() throws InterruptedException {
        ilabPageObjects= new IlabPageObjects(driver);
        seleniumAction=new SeleniumAction(driver);
        seleniumAction.scrollBy("0","1000");
       //Assert.assertTrue("unable to type in email address",ilabPageObjects.clickAndValidateMsg());
    }
}


