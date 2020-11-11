package com.wordpress.login;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login_01_ValidateLoginForm {
  WebDriver driver;
  By emailTextboxBy = By.xpath("//input[@id='usernameOrEmail']");
  By emailPasswordBy = By.xpath("//input[@id='password']");
  By loginButtonBy = By.xpath("//div[@class='login__form-action']/button");
  By emailErrorMessBy = By.xpath("//div[@class='form-input-validation is-error']/span");
  By passErrorMessBy = By.xpath("//div[@class='form-input-validation is-error']/span");
  String errMess ;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("https://automationfc.wordpress.com/wp-admin");
  }
  
  @Test
  public void Validate_01_EmptyEmail() {
	  driver.findElement(emailTextboxBy).sendKeys("");
	  driver.findElement(loginButtonBy).click();
	  
	  errMess = driver.findElement(emailErrorMessBy).getText().trim();
	  
	  Assert.assertEquals(errMess, "Please enter a username or email address.");
  }
  
  @Test
  public void Validate_02_InvalidEmail() {
	  //123@123.123
	  driver.findElement(emailTextboxBy).sendKeys("123@123.123");
	  driver.findElement(loginButtonBy).click();
	  
	  String errMess = driver.findElement(emailErrorMessBy).getText().trim();
	  
	  Assert.assertEquals(errMess, "Please log in using your WordPress.com username instead of your email address.");
  }
  
  @Test
  public void Validate_03_EmailNotExist() {
	  //automationdung@gmail.com
	  	  
	  driver.findElement(emailTextboxBy).sendKeys("automation" + randomNumber() + "@gmail.com");
	  driver.findElement(loginButtonBy).click();
	  
	  errMess = driver.findElement(emailErrorMessBy).getText().trim();
	  Assert.assertEquals(errMess, "User does not exist. Would you like to create a new account?");
	  
  }
  
  @Test
  public void Validate_04_EmptyPassword() {
	  driver.findElement(emailTextboxBy).sendKeys("automationeditor");
	  driver.findElement(loginButtonBy).click();
	  
	  driver.findElement(emailPasswordBy).sendKeys("");
	  driver.findElement(loginButtonBy).click();
	  
	  errMess = driver.findElement(emailErrorMessBy).getText().trim();
	  Assert.assertEquals(errMess, "Don't forget to enter your password.");
  }
  
  @Test
  public void Validate_05_PasswordLessThan6Chars() {
	  driver.findElement(emailTextboxBy).sendKeys("automationeditor");
	  driver.findElement(loginButtonBy).click();
	  
	  driver.findElement(emailPasswordBy).sendKeys("123");
	  driver.findElement(loginButtonBy).click();
	  
	  errMess = driver.findElement(emailErrorMessBy).getText().trim();
	  Assert.assertEquals(errMess, "Oops, that's not the right password. Please try again!");
  }
  
  
  @Test
  public void Validate_06_ValidPassword() {
	  //pass: automationfc
	  driver.findElement(emailTextboxBy).sendKeys("automationeditor");
	  driver.findElement(loginButtonBy).click();
	  
	  driver.findElement(emailPasswordBy).sendKeys("automationfc");
	  driver.findElement(loginButtonBy).click();
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@id='dashboard-widgets']")).isDisplayed());
  }

  public int randomNumber() {
	  Random rand = new Random();
	  return rand.nextInt(99999);
  }
 

  
  @AfterClass
  public void afterClass() {
	  
  }

}
