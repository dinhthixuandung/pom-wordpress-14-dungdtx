package com.smartpetro.documenttype;

import org.testng.annotations.Test;
import org.w3c.dom.DocumentType;

import pageObjects.smartPetro.DashboardPageObject;
import pageObjects.smartPetro.DataTablePageObject;
import pageObjects.smartPetro.DocumentTypePageObject;
import pageObjects.smartPetro.LoginPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DocumentType_02_Edit {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	DocumentTypePageObject documentTypePage;
	String userID = "sysadmin";
	String password = "sm@c.123";
	String name = "Auto test" + randomNumber();
	String editName;
	DataTablePageObject dataTablePage;

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
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		dashboardPage = new DashboardPageObject(driver);
		Assert.assertTrue(dashboardPage.isDisplayedHeader());
		System.out.println("TC_01_Login: Sucessfull");
	}

		
	@Test
	public void TC_02_AddValidData() {
		dashboardPage.clickToMenu();

		dashboardPage.clickToSubMenu();

		dashboardPage.clickToChildMenu();

		documentTypePage = new DocumentTypePageObject(driver);

		documentTypePage.clickToAddButton();
		
		editName = name;
		documentTypePage.inputNameTextbox(name);
		documentTypePage.inputOtherNameTextbox(name);
		documentTypePage.inputDescriptionArea(name);
		
		documentTypePage.clickToSaveButton();

	}
	
	@Test
	public void TC_03_EditWithValidData() {
		dataTablePage = new DataTablePageObject(driver);
		
		dataTablePage.inputToColumnByName("Tên loại chứng từ", editName);
		
		//dataTablePage.refresh(driver);

		//Assert.assertTrue(dataTablePage.isOnlyOneRowDisplayed(editName));
		
		System.out.println("TC_04_AddIndenticalData: Sucessfull");
	}

	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber()
	{
		Random number = new Random();
		return number.nextInt(9999);
	}
}
