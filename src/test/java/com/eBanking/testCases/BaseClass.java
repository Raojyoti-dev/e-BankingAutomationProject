package com.eBanking.testCases;

import java.io.File;
//import java.io.File;
//import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.eBanking.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsernName();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) {
		
		logger=Logger.getLogger("e-BankingMiniProjectAutomation");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")){
				System.setProperty("webdriver.chrome.driver",readconfig.getchromePath());
				driver=new ChromeDriver(); 
		}
		else if(br.equals("edge")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getedgePath());
			driver=new EdgeDriver(); 
		}
		
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String testcasename) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+testcasename+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken");
	}
	
	
	
	

}
