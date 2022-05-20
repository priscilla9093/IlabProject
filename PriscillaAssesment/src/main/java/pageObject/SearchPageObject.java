package pageObject;

import base.BaseClass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageObject extends BaseClass {
    public SearchPageObject(WebDriver driver){
        super();
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
@FindBy(name="search")
    private WebElement txtsearch;
    @FindBy(xpath="(//button[text()='Add to Cart'])[1]")
    private WebElement productnamebtn;

    public void Seach(String name){

        txtsearch.sendKeys(name);
    }


    public void clickProduct(){
        productnamebtn.click();
    }

    }





