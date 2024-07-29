package com.eBanking.testCases;

import org.testng.annotations.Test;

import com.eBanking.pageObjects.AddNewCustomer;
import com.eBanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass{  
	
	@Test
	public void addNewCustomer() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddNewCustomer cust=new AddNewCustomer(driver);
		cust.clickCustomer();
		cust.SetName("jyoti");
		cust.SetGender();
		cust.clickSubmit();
	}

}
