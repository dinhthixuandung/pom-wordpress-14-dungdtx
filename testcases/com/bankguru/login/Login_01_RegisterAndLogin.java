package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Login_01_RegisterAndLogin {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String userID, password, loginPageUrl;
	
	
	@BeforeClass
	public void beforeClass() {
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Mo trang login
		driver.get("http://www.demo.guru99.com/v4/");
		
		//Khoi tao trang login
		loginPage = new LoginPageObject(driver);
		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@Test
	public void TC_01_Register() {
		// Su kien chuyen trang login -> register
		loginPage.clickToHereLink();

		// Khoi tao trang register
		registerPage = new RegisterPageObject(driver);

		registerPage.inputToEmailTextbox("dungdinh" + randomNumber() + "@gmail.com");

		registerPage.clickToSubmitButton();

		userID = registerPage.getUserIDText();

		password = registerPage.getPasswordText();
		
		registerPage.openLoginPage(loginPageUrl);
		
		//loginPage = new LoginPageObject(driver);
	}

	

	@Test
	public void TC_02_Login() {
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isWelcomMessageDisplayed());
	}

	private void inputToPasswordTextbox(String password2) {
		// TODO Auto-generated method stub
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private int randomNumber() {
		Random number= new Random();
		return number.nextInt(9999);
	}
}
