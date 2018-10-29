package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		Initialization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.swithcToFrame();
		homepage.clickOnNewContactsLink();
	}
	
	@Test(priority=1)
	public void addContactTest() {
		contactspage.enterUserSurName("MD", "cherry", "Vayalpati");		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
