package com.wordpress.login;

import org.testng.annotations.Test;

import commons.AbstractPage;

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
		
	String emailTextbox = "//input[@id='usernameOrEmail']";
	String emailPassword = "//input[@id='password']";
	String loginButton = "//div[@class='login__form-action']/button";
	String emailErrorMess = "//div[@class='form-input-validation is-error']/span";
	String passErrorMess = "//div[@class='form-input-validation is-error']/span";
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  openUrl(driver, "https://automationfc.wordpress.com/wp-admin");
  }
  
  @Test
  public void Validate_01_EmptyEmail() {
	  senKeysToElement(driver, emailTextbox, "");
	  clickToElement(driver, loginButton);
	  
	  Assert.assertEquals(getElementText(driver, emailErrorMess), "Please enter a username or email address.");
  }
  
  @Test
  public void Validate_02_InvalidEmail() {
	  //123@123.123
	  senKeysToElement(driver, emailTextbox, "123@123.123");
	  clickToElement(driver, loginButton);
	  	  
	  Assert.assertEquals(getElementText(driver, emailErrorMess), "Please log in using your WordPress.com username instead of your email address.");
  }
  
  @Test
  public void Validate_03_EmailNotExist() {
	  //automationdung@gmail.com
	  senKeysToElement(driver, emailTextbox,"automation" + randomNumber() + "@gmail.com");
	  clickToElement(driver, loginButton);
	  	  
	  Assert.assertEquals(getElementText(driver, emailErrorMess), "User does not exist. Would you like to create a new account?");  
  }
  
  @Test
  public void Validate_04_EmptyPassword() {
	  senKeysToElement(driver, emailTextbox, "automationeditor");
	  clickToElement(driver, loginButton);
	  senKeysToElement(driver, emailPassword, "");
	  clickToElement(driver, loginButton);
	  	  
	  Assert.assertEquals(getElementText(driver, emailErrorMess), "Don't forget to enter your password.");
  }
  
  @Test
  public void Validate_05_PasswordLessThan6Chars() {
	  senKeysToElement(driver, emailTextbox, "automationeditor");
	  clickToElement(driver, loginButton);	  
	  senKeysToElement(driver, emailPassword, "123");
	  clickToElement(driver, loginButton);
	  
	  Assert.assertEquals(getElementText(driver, emailErrorMess), "Oops, that's not the right password. Please try again!");
  }
  
  
  @Test
  public void Validate_06_ValidPassword() {
	  //pass: automationfc
	  senKeysToElement(driver, emailTextbox, "automationeditor");
	  clickToElement(driver, loginButton);
	  senKeysToElement(driver, emailPassword, "automationfc");
	  clickToElement(driver, loginButton);

	  Assert.assertTrue(isElementDisplayed(driver, "//h1[text()='Dashboard']"));
	  
	  Assert.assertTrue(isElementDisplayed(driver, "//div[@id='dashboard-widgets']"));
  }

  public int randomNumber() {
	  Random rand = new Random();
	  return rand.nextInt(99999);
  }
  
  @AfterClass
  public void afterClass() {
	  
  }

}
