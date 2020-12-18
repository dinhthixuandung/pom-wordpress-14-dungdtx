package com.wordpress.login;

import org.testng.annotations.Test;

import commons.AbstractPage;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login_04_PageObject_Pattern extends AbstractPage{
	
	WebDriver driver;
	String loginPageUrl;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("https://automationfc.wordpress.com/wp-admin");
	  
	  loginPage = new LoginPageObject(driver);
	  loginPageUrl = loginPage.getLoginPageUrl();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  loginPage.openLoginPage(loginPageUrl);
  }
  
  @Test
  public void Validate_01_EmptyEmail() {
	  	  
	  loginPage.inputToEmailTextbox("");
	  
	  loginPage.clickToContinueOrLoginButton();
	  
	  Assert.assertEquals(loginPage.getEmailOrPasswordErrorMessage(),"Please enter a username or email address.");
	  
  }
  
  @Test
  public void Validate_02_InvalidEmail() {
	  //123@123.123
	  
	  loginPage.inputToEmailTextbox("123@123.123");
	  
	  loginPage.clickToContinueOrLoginButton();
	  
	  Assert.assertEquals(loginPage.getEmailOrPasswordErrorMessage(),"Please log in using your WordPress.com username instead of your email address.");
  }
  
  @Test
  public void Validate_03_EmailNotExist() {
	  //automationdung@gmail.com
	  
	  loginPage.inputToEmailTextbox("automation" + randomNumber() + "@gmail.com");
	  
	  loginPage.clickToContinueOrLoginButton();
	  
	  Assert.assertEquals(loginPage.getEmailOrPasswordErrorMessage(),"User does not exist. Would you like to create a new account?");
  
  }
  
  @Test
  public void Validate_04_EmptyPassword() {
	  
	  loginPage.inputToEmailTextbox("automationeditor");
	  loginPage.clickToContinueOrLoginButton();
	  
	  loginPage.inputToPasswordTextbox("");
	  loginPage.clickToContinueOrLoginButton();
	  
	  Assert.assertEquals(loginPage.getEmailOrPasswordErrorMessage(),"Don't forget to enter your password.");
  }
  
  @Test
  public void Validate_05_PasswordLessThan6Chars() {
	  
	  loginPage.inputToEmailTextbox("automationeditor");
	  loginPage.clickToContinueOrLoginButton();
	  
	  loginPage.inputToPasswordTextbox("123");
	  loginPage.clickToContinueOrLoginButton();
	  
	  Assert.assertEquals(loginPage.getEmailOrPasswordErrorMessage(),"Oops, that's not the right password. Please try again!");
	  
  } 
  
  @Test
  public void Validate_06_ValidPassword() {
	  //pass: automationfc
	  
	  loginPage.inputToEmailTextbox("automationeditor");
	  loginPage.clickToContinueOrLoginButton();
	  
	  loginPage.inputToPasswordTextbox("automationfc");
	  loginPage.clickToContinueOrLoginButton();
	  
	  dashboardPage = new DashboardPageObject(driver);
	  
	  Assert.assertTrue(dashboardPage.isHeaderTextDisplayed());
	  
  }

  public int randomNumber() {
	  Random rand = new Random();
	  return rand.nextInt(99999);
  }
  
  @AfterClass
  public void afterClass() {
	  
  }

}
