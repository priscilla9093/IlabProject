package base;


//import org.apache.log4j.Logger;

//import io.cucumber.core.api.Scenario;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentReporter;
//import com.relevantcodes.extentreports.LogStatus;
//import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.java.Scenario;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import seleniumaction.SeleniumAction;
//import seleniumadaptor.SeleniumAdaptor;
import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Base64;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.google.common.io.Files.copy;


public class BaseClass {

    String broserName="Edge";
    public SeleniumAction seleniumAction;
    public  ExtentTest extentTest;
    //    public SeleniumAdaptor seleniumAdaptor;
    public static   WebDriver driver;
    //    public static  WebDriver drivers;
    String webDriverlocationpath=  System.getProperty("user.dir")+File.separator +"src"+ File.separator+"test"+File.separator+"webdriver";
    static String screenshotlocationpath=  System.getProperty("user.dir") + File.separator +"target" + File.separator+"screenshots";

    public static HashMap<String, String> storeValue = new HashMap<>();

    public   BaseClass(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        seleniumAction= new SeleniumAction(driver);
//        seleniumAdaptor= new SeleniumAdaptor(driver);

    }

    public BaseClass() {
    }

    public WebDriver openBrowser(String url) throws Exception {

        if(broserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",webDriverlocationpath+"\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(broserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.firefox.marionette", webDriverlocationpath+ "\\geckodriver.exe");
            driver =new FirefoxDriver();
        }
        else if(broserName.equalsIgnoreCase("Edge")){
            //set path to Edge.exe
            System.setProperty("webdriver.edge.driver",webDriverlocationpath+"\\msedgedriver.exe");
            //create Edge instance
            driver =new EdgeDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");}
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000l, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }
    public static String generateRandomString(int length) {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }
        return sb.toString();
    }
//    public static void takeScreenShot(Scenario scenario) {
//        try {
//            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String time = java.time.LocalTime.now().toString();
//            String [] timeStr = time.split(":");
//            String x = timeStr[0]+""+timeStr[1]+""+timeStr[2];
//            String screenshotName = x.substring(0,8);
////            File destinationPath = new File("\\PriscillaAssesment\\target" + screenshotName +"_"+ generateRandomString(5) + ".png");
////            File destinationPath = new File("C:\\Reg\\Screenshots/screenshot" + screenshotName +"_"+ generateRandomString(5) + ".png");
//            File destinationPath = new File(screenshotlocationpath + screenshotName +"_"+ generateRandomString(5) + ".png");
//            copy(sourcePath, destinationPath);
//            Reporter.addScreenCaptureFromPath(destinationPath.toString());
//
//            InputStream is = new FileInputStream(screenshotlocationpath + screenshotName +"_"+ generateRandomString(5) + ".png");
//      byte[] ssBytes = IOUtils.toByteArray(is);
//      String base64 = Base64.getEncoder().encodeToString(ssBytes);
//
////extentTest.log(LogStatus.FAIL, "TEST CASE FAILED "+ result.getName());
//
////            extentTest.log(LogStatus.PASS,extentTest.addScreenCapture("data:image/png:base64," + base64));
//        }
//        catch (Exception e) {
//            System.out.println("Unable to take screenshot");
//            System.out.println(e);
//
//        }
//    }

//    public void attachScreenshot(Scenario scenario){
//
//        if(scenario.isFailed()){
//
//            byte[] screenshotTaken=  ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshotTaken,"image/png", "error screen");
//        }
//    }

//    takeScreenShotNew(this.scenario);

    public static void takeScreenShotNew(Scenario scenario) {
        try {
            TakesScreenshot ts =(TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
        catch (Exception e) {
            System.out.println("Unable to take screenshot");
            System.out.println(e);

        }
    }

    public void putValue(String vname, String vvalue) {
        storeValue.put(vname, vvalue);
    }


    public String getValue(String vname) {
        return storeValue.get(vname);
    }

    public void validate(String expectedResult, String actualResult) {
        Assert.assertEquals(expectedResult, actualResult);
    }




}


