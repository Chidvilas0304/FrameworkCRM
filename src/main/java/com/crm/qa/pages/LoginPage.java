package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase	{
	
	HomePage homepage;
	
	//Page Factory - Object Repository
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//font[contains(text(),'Sign Up')]")
	WebElement signUPButton;
	
	@FindBy(xpath="//img[@class='img-responsive' and @alt='free crm logo']")
	WebElement crmLogo;
	

	// Initialize the Page Objects
	// To initialize the above declared object repositories - using constructor
	// Create the constructor of this class
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	// defining actions available on Login Page
	
	public String validateLoginPageTitle() {	
	  return driver.getTitle();	
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String urn, String pwd) throws InterruptedException {
		username.sendKeys(urn);
		password.sendKeys(pwd);
		Thread.sleep(6000);
		loginButton.click();
		
		return new HomePage();
	}

	
}
