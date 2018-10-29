package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		Initialization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String str = homepage.verifyHomePageTitle();
		Assert.assertEquals(str, "CRMPRO", "HomePage Title is not matched");
	}

	@Test(priority = 2)
	public void verifyCorrectUserNameTest() {
		testutil.swithcToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void clickOnContactsLinkTest() {
		testutil.swithcToFrame();
		homepage.clickOnContactsLink();
	}

	@Test(priority = 4)
	public void clickOnNewContactLinkTest() throws InterruptedException {
		testutil.swithcToFrame();
		homepage.clickOnNewContactsLink();		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
