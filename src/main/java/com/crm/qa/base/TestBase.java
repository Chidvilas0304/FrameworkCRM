package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	// TestBase will be the Parent class
	// In TestBase class we will define Browser drivers,
	// maximize Window()
	// Pageload Timeout
	// ImplicitWait
	// Delete Cookies
	// get URL

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		// Step 1 - Create the constructor of the class and read the property file
		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream("C:\\Users\\chidvilas.vayalpati\\Downloads\\Selenium"
					+ "\\Updated Framework workspace\\FreeCRMTest\\src\\main"
					+ "\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public static void Initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\chidvilas.vayalpati\\Downloads\\Selenium\\" + "chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\chidvilas.vayalpati\\Downloads"
					+ "\\Selenium\\geckodriver-v0.22.0-win64\\geckodriver.exe");

			driver = new FirefoxDriver();

		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUTS , TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
