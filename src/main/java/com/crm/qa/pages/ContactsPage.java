package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//input[@name = 'first_name']")
	WebElement contactFirstName;
	
	@FindBy(xpath="//input[@name = 'surname']")
    WebElement contactSurName;
	
	@FindBy(xpath="//select[@name = 'suffix']")
	WebElement selectSuffix;
	
	@FindBy(xpath="//input[@type= 'submit' and @value= 'Save' and @class='button']")
	WebElement saveButton;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserSurName(String MD, String username, String password) {
		Select select = new Select(selectSuffix);
		select.selectByVisibleText(MD);
		contactFirstName.sendKeys(username);
		contactSurName.sendKeys(password);
		saveButton.click();
	}
		

}
