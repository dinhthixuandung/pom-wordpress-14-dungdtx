package com.othergoods;

import org.testng.annotations.Test;
import org.w3c.dom.DocumentType;

import pageObjects.smartPetro.DashboardPageObject;
import pageObjects.smartPetro.DocumentTypePageObject;
import pageObjects.smartPetro.LoginPageObject;
import pageObjects.smartPetro.OtherGoodsPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class OtherGoods_01_Add {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	OtherGoodsPageObject otherGoodsPage;
	String userID = "smartpetrosg";
	String password = "123456";
	String expectedRole = "Quản trị cấp công ty";
	String expectedCompany = "Công Ty Smac Petro - Sài Gòn";
	String name = "Autotest" + randomNumber();
	String indenticalName;

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
		
		loginPage.selectRole(expectedRole);		
		loginPage.selectCompany(expectedCompany);
		loginPage.clickToAcceptButton();
		
		dashboardPage = new DashboardPageObject(driver);
		Assert.assertTrue(dashboardPage.isDisplayedHeader());
		
		System.out.println("TC_01_Login: Sucessfull");
	}
	
	@Test
	public void TC_02_NotInputIntoRequireFields() {
		
		dashboardPage.clickToMenu();

		dashboardPage.clickToSubMenu();

		dashboardPage.clickToChildMenu();

		otherGoodsPage = new OtherGoodsPageObject(driver);

		otherGoodsPage.clickToAddButton();
		
		otherGoodsPage.clickToNameTextbox();
		
		otherGoodsPage.clickToDescriptionArea();
		
		Assert.assertEquals(otherGoodsPage.getErrorMassege(),"Không được để trống");
		Assert.assertFalse(otherGoodsPage.enableSaveButton());
		
		otherGoodsPage.clickToCloseButton();
		
		System.out.println("TC_02_NotInputIntoRequireFields: Sucessfull");
	}
	
	@Test
	public void TC_02_InputGoodNo() {
		
	}
	
	@Test
	public void TC_03_IndenticalGoodNo() {
		
	}
	
	@Test
	public void TC_04_NotInputGoodNo() {
		
	}
	
	@Test
	public void TC_05_InputGoodNoIsSpecialcharacters() {
		
	}
	
	@Test
	public void TC_06_NotDistibuteStation() {
		
	}
	
	@Test
	public void TC_07_InputInvalidDataIntoUnit() {
		
	}
	
	@Test
	public void TC_08_InputNegativeNumberIntoUnit() {
		
	}
	
	@Test
	public void TC_09_IndenticalGoodName() {
		
	}
	
	

//	@Test
//	public void TC_02_AddEmptyData() {
//		dashboardPage.clickToMenu();
//
//		dashboardPage.clickToSubMenu();
//
//		dashboardPage.clickToChildMenu();
//
//		documentTypePage = new DocumentTypePageObject(driver);
//
//		documentTypePage.clickToAddButton();
//		
//		documentTypePage.inputNameTextbox("");
//		
//		documentTypePage.clickToOtherTextbox();
//		
//		Assert.assertEquals(documentTypePage.getErrorMassege(),"KhÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng");
//		
//		documentTypePage.clickToCloseButton();
//		
//		System.out.println("TC_02_AddEmptyData: Sucessfull");
//		
//	}
//	
//	@Test
//	public void TC_03_AddValidData() {
//		
//		documentTypePage.clickToAddButton();
//		
//		indenticalName = name;
//		documentTypePage.inputNameTextbox(name);
//		documentTypePage.inputOtherNameTextbox(name);
//		documentTypePage.inputDescriptionArea(name);
//		
//		documentTypePage.clickToSaveButton();
//		documentTypePage.clickToAcceptButton();
//		documentTypePage.clickToOkButton();
//
//		System.out.println("TC_03_AddValidData: Sucessfull");
//	}
//	
//	@Test
//	public void TC_04_AddIndenticalData() {
//
//		documentTypePage.clickToAddButton();
//		
//		documentTypePage.inputNameTextbox(indenticalName);
//		
//		Assert.assertEquals(documentTypePage.getErrorMassege(),"TÃªn loáº¡i chá»©ng tá»« Ä‘Ã£ tá»“n táº¡i");
//		
//		documentTypePage.clickToCloseButton();
//		
//		System.out.println("TC_04_AddIndenticalData: Sucessfull");
//	}

	
	
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
