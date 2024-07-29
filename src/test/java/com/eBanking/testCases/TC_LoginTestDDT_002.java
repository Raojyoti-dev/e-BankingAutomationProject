package com.eBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBanking.Utilities.ExcelUtils;
import com.eBanking.pageObjects.LoginPage;

public class TC_LoginTestDDT_002 extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("passwrod provided");
		lp.clickSubmit();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("login failed");
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\eBanking\\testData\\LoginDataDTT.xls";
		//String path="C:\\Users\\jraopx\\OneDrive - Intel Corporation\\Documents\\Automation\\Automation\\e-BankingMiniProjectAutomation\\src\\test\\java\\com\\eBanking\\testData";
		int rownum=ExcelUtils.getRowCount(path,"Sheet1");
		int colnum=ExcelUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String [rownum][colnum];
		
		for(int i=1;i<=rownum;i++) {
			
			for (int j=0;j<colnum;j++) {
				
				logindata[i-1][j]=ExcelUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return logindata;
	}

}
