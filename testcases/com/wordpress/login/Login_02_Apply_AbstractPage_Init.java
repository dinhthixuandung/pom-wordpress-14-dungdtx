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

public class Login_02_Apply_AbstractPage_Init {
	AbstractPage abstractPage;
	
	WebDriver driver;
//	By emailTextboxBy = By.xpath("//input[@id='usernameOrEmail']");
//	By emailPasswordBy = By.xpath("//input[@id='password']");
//	By loginButtonBy = By.xpath("//div[@class='login__form-action']/button");
//	By emailErrorMessBy = By.xpath("//div[@class='form-input-validation is-error']/span");
//	By passErrorMessBy = By.xpath("//div[@class='form-input-validation is-error']/span");
		
	String emailTextbox = "//input[@id='usernameOrEmail']";
	String emailPassword = "//input[@id='password']";
	String loginButton = "/div[@class='login__form-action']/button";
	String emailErrorMess = "//div[@class='form-input-validation is-error']/span";
	String passErrorMess = "//div[@class='form-input-validation is-error']/span";
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  //driver.get("https://automationfc.wordpress.com/wp-admin");
	  abstractPage.openUrl(driver, "https://automationfc.wordpress.com/wp-admin");
  }
  
  @Test
  public void Validate_01_EmptyEmail() {
//	  driver.findElement(emailTextboxBy).sendKeys("");
	  abstractPage.senKeysToElement(driver, emailTextbox, "");
//	  driver.findElement(loginButtonBy).click();
	  abstractPage.clickToElement(driver, loginButton);
	  
	// errMess = driver.findElement(emailErrorMessBy).getText().trim();
	  
	  Assert.assertEquals(abstractPage.getElementText(driver, emailErrorMess), "Please enter a username or email address.");
  }
  
  @Test
  public void Validate_02_InvalidEmail() {
	  //123@123.123
	  //driver.findElement(emailTextboxBy).sendKeys("123@123.123");
	  abstractPage.senKeysToElement(driver, emailTextbox, "123@123.123");
	  //driver.findElement(loginButtonBy).click();
	  abstractPage.clickToElement(driver, loginButton);
	  	  
	  Assert.assertEquals(abstractPage.getElementText(driver, emailErrorMess), "Please log in using your WordPress.com username instead of your email address.");
  }
  
  @Test
  public void Validate_03_EmailNotExist() {
	  //automationdung@gmail.com
	  	  
	 // driver.findElement(emailTextboxBy).sendKeys("automation" + randomNumber() + "@gmail.com");
	  abstractPage.senKeysToElement(driver, emailTextbox,"automation" + randomNumber() + "@gmail.com");
	  //driver.findElement(loginButtonBy).click();
	  abstractPage.clickToElement(driver, loginButton);
	  	  
	  Assert.assertEquals(abstractPage.getElementText(driver, emailErrorMess), "User does not exist. Would you like to create a new account?");
	  
  }
  
  @Test
  public void Validate_04_EmptyPassword() {
//	  driver.findElement(emailTextboxBy).sendKeys("automationeditor");
	  abstractPage.senKeysToElement(driver, emailTextbox, "automationeditor");
//	  driver.findElement(loginButtonBy).click();
	  abstractPage.clickToElement(driver, loginButton);
	  
//	  driver.findElement(emailPasswordBy).sendKeys("");
	  abstractPage.senKeysToElement(driver, emailPassword, "");
//	  driver.findElement(loginButtonBy).click();
	  abstractPage.clickToElement(driver, loginButton);
	  	  
	  Assert.assertEquals(abstractPage.getElementText(driver, emailErrorMess), "Don't forget to enter your password.");
  }
  
  @Test
  public void Validate_05_PasswordLessThan6Chars() {
//	  driver.findElement(emailTextboxBy).sendKeys("automationeditor");
	  abstractPage.senKeysToElement(driver, emailTextbox, "automationeditor");
	  
//	  driver.findElement(loginButtonBy).click();
	  abstractPage.clickToElement(driver, loginButton);
	  
//	  driver.findElement(emailPasswordBy).sendKeys("123");
	  abstractPage.senKeysToElement(driver, emailPassword, "123");
//	  driver.findElement(loginButtonBy).click();
	  abstractPage.clickToElement(driver, loginButton);
	  
	  Assert.assertEquals(abstractPage.getElementText(driver, emailErrorMess), "Oops, that's not the right password. Please try again!");
  }
  
  
  @Test
  public void Validate_06_ValidPassword() {
	  //pass: automationfc
//	  driver.findElement(emailTextboxBy).sendKeys("automationeditor");
	  abstractPage.senKeysToElement(driver, emailTextbox, "automationeditor");
	  
//	  driver.findElement(loginButtonBy).click();
	  abstractPage.clickToElement(driver, loginButton);
//	  
//	  driver.findElement(emailPasswordBy).sendKeys("automationfc");
	  abstractPage.senKeysToElement(driver, emailPassword, "automationfc");
//	  driver.findElement(loginButtonBy).click();
	  abstractPage.clickToElement(driver, loginButton);
	  
//	  Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());
	  Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//h1[text()='Dashboard']"));
	  
//	  Assert.assertTrue(driver.findElement(By.xpath("//div[@id='dashboard-widgets']")).isDisplayed());
	  Assert.assertTrue(abstractPage.isElementDisplayed(driver, "//div[@id='dashboard-widgets']"));
  }

  public int randomNumber() {
	  Random rand = new Random();
	  return rand.nextInt(99999);
  }
 
///////////////////////////////////////
  
  @AfterClass
  public void afterClass() {
	  
  }

}
