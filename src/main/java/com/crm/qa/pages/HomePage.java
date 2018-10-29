package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: chidvilas V')]")
	WebElement userlabelCheck;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//legend[contains(text(),'Contact Information')]")
	WebElement newContactInformation;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean  verifyCorrectUserName() {
		return userlabelCheck.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactslink.click();
		return new ContactsPage();
	}
	
	public ContactsPage clickOnNewContactsLink() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newContactsLink.click();
		Thread.sleep(2000);
		newContactInformation.isDisplayed();
		return new ContactsPage();
	}
	
	
	public DealsPage clickOnDealsLink() {
		dealslink.click();
		return new DealsPage();
	}	
	
}
