package seleniumaction;

import base.BaseClass;
import com.sun.javafx.binding.StringFormatter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAction {
    public WebDriver driver;
    WebDriverWait wait;

    public Actions act ;
    private static final Logger logger= LogManager.getLogger(SeleniumAction.class);

    public SeleniumAction(WebDriver driver) {
        this.driver = driver;

    }

    public boolean clickElement(WebElement element) {
        try {
            element.click();
            return true;
        }
        catch (Exception Var3){
            logger.error(String.format("element  %s did not become visible with 15s",element.toString()));
            return  false;
        }

    }
    public boolean SwitchToIframe(WebElement element) {
        try {

            wait = new WebDriverWait(driver, 30l);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception Var) {
            logger.error(String.format("element  %s did not become visible with 15s", element.toString()));
            return false;
        }
    }


        public boolean typeText(WebElement element,String text){
        try{
            element.sendKeys(text);
            //new CharSequence[]{text}
            return true;
        }
            catch(Exception var3) {

                logger.error(String.format("text not successfully typed into a field", element.toString()));
                return false;
            }
        }
        public boolean scrollDown(){
        act= new Actions(driver);
            act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
            System.out.println("Scroll down perfomed");
            return false;
        }
    public boolean scrollBy(String x, String y) {
        try {
            JavascriptExecutor js = (JavascriptExecutor)this.driver;
            js.executeScript("window.scrollBy(" + x + "," + y + ")", new Object[0]);
             return true;
        } catch (Exception var4) {
            var4.printStackTrace();
            return false;
        }
    }

    public boolean WaitFoElementToBeVisible(WebElement element) {
        try {
            wait = new WebDriverWait(driver, 30l);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception var3) {
            logger.error(String.format("element  %s did not become visible with 15s", element.toString()));
            return false;
        }
    }
    }


