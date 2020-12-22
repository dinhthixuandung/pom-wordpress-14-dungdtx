package com.smartpetro.login;

import org.testng.annotations.Test;

import pageObjects.smartPetro.DashboardPageObject;
import pageObjects.smartPetro.LoginPageObject;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login_01_LoginManagement {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
//	String userID, password; 
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://10.88.104.20:32152/smacpetro");
		
		loginPage = new LoginPageObject(driver);
	}

	@Test
	public void TC_01_Login() {
		loginPage.inputToUserIDTextbox("sysadmin");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		
		dashboardPage = new DashboardPageObject(driver);
		Assert.assertTrue(dashboardPage.isDisplayedHeader());
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Login successfully");
		driver.quit();
	}

}
