package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		LoginPageTest.Initialization();
		loginpage = new LoginPage();

	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void crmLogoCheckTest() {
		boolean logo = loginpage.validateCRMLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void loginCredentialsTest() throws InterruptedException {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
