package com.eBanking.pageObjects;

import org.openqa.selenium.SearchContext;
//import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer  {
	
	WebDriver ldriver;
	
	public  AddNewCustomer(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath = "(//a[normalize-space()='New Customer'])[1]")
	WebElement customer;
	
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@value='f']")
	WebElement gender;
	
	@FindBy(xpath = "//input[@id='dob']")
	WebElement dob;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pin;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement phn;
	
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement pwd;
	
	@FindBy(xpath = "//input[@name='sub']")
	WebElement submitbtn;
	
	public void clickCustomer() {
		customer.click();
	}
	
	public void SetName(String name) {
		Username.sendKeys(name);
	}
	
	public void SetGender() {
		gender.click();
	}
	
	
	public void clickSubmit() {
		submitbtn.click();
	}
	
	

}
