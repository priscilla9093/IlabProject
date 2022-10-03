package com.ilabnautomation.PageObject;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IlabPageObjects {
WebDriver driver;
	
	public IlabPageObjects(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//div[@class='col-sm-2 curved-shape']/following-sibling::div/descendant::a[text()='CAREERS']")
	public WebElement  careerLnk;
	
	@FindBy(xpath="//div[@class='vc_btn3-container vc_btn3-left']/child::a[text()='South Africa']")
	public WebElement SouthAfricaLnk;

	@FindBy(xpath="//div[contains(@class,'wpjb-job-list wpjb-grid')]//div[1]//div[2]//span[1]//a[1]")
	public WebElement firstjoblink;
	
	
	@FindBy(xpath="//a[text()='Apply Online ']")
	public WebElement aplyBtn;
	@FindBy(xpath="//input[@id='applicant_name']")
	public WebElement input_name;
	@FindBy(xpath="//input[@id='email']")
	public WebElement input_email;
	@FindBy(xpath="//input[@id='phone']")
	public WebElement input_phone;
	@FindBy(xpath="//textarea[@id='message']")
	public WebElement input_msg;
	
	@FindBy(xpath="//input[@id='wpjb_submit']")
	public WebElement btn_submit;
	
	@FindBy(xpath="//ul[@class='wpjb-errors']/parent::div[@class='wpjb-field']/child::div/following-sibling::ul")
	public WebElement txt_validation;
	
	public void clickCareeLink() throws InterruptedException{
		careerLnk.click();
		Thread.sleep(2000);
		

	}

	public void clickSouthAfrica() throws InterruptedException{
		SouthAfricaLnk.click();
		Thread.sleep(2000);
	}
		
	
	
	public void clickFirstJob() throws InterruptedException{
		firstjoblink.click();
		Thread.sleep(2000);

	
	}
	public void ClickApplyOnline() throws InterruptedException{
		aplyBtn.click();
		Thread.sleep(2000);
		
	}
	
	public void ApplicantDetails(String name,String email,String msg) throws InterruptedException{
	input_name.sendKeys(name);
	Thread.sleep(2000);
	input_email.sendKeys(email);
	Thread.sleep(2000);
	input_phone.sendKeys(getCellNumber());
	Thread.sleep(2000);
	input_msg.sendKeys(msg);
		
		
	}


	public void clickAndValidateMsg() throws InterruptedException{
				
		btn_submit.click();
		Thread.sleep(3000);
		String actualString = driver.findElement(By.xpath("//ul[@class='wpjb-errors']/parent::div[@class='wpjb-field']/child::div/following-sibling::ul")).getText();
		assertTrue(actualString.contains("You need to upload at least one file."));
		
		
		
//		
//		String CorrectString = "//ul[@class='wpjb-errors']/parent::div[@class='wpjb-field']/child::div/following-sibling::ul";
//		CorrectString.get
//		Assert.assertEquals("You need to upload at least one file.", CorrectString);
//		
//		System.out.println(CorrectString);
//
//		
//		 WebElement element =driver.findElement(By.xpath("//ul[@class='wpjb-errors']/parent::div[@class='wpjb-field']/child::div/following-sibling::ul"));
//	    if (element.getText().equals("You need to upload at least one file."))
//	     System.out.println(element);
//	    else 
//	     System.out.println("Match Not found");
	}
	
	
	    
	    public static String getCellNumber(){
		    int serviceProviderCode = (int)(Math.random() * (99 - 60) + 60);
		    int threeDigitsNumber = (int)(Math.random() * (999 - 100) + 100);
		    int fouDegitsNumber = (int)(Math.random() * (9999 - 1000) + 1000);

		    String forMatedNumber = "0"+serviceProviderCode+" "+threeDigitsNumber+" "+fouDegitsNumber ;

		    return forMatedNumber;

				
		}
		
	    
}


