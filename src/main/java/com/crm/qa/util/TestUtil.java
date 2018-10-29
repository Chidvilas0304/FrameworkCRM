package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static int PAGE_LOAD_TIME_OUTS = 20;
	
	public static int IMPLICITLY_WAIT = 10;
	
	public void swithcToFrame() {
		
		driver.switchTo().frame("mainpanel");
		
	}

}
