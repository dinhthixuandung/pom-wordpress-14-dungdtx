package com.smartpetro.documenttype;

import org.testng.annotations.Test;
import org.w3c.dom.DocumentType;

import com.thoughtworks.selenium.webdriven.commands.Refresh;

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

public class DocumentType_03_Delete {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	DocumentTypePageObject documentTypePage;
	String userID = "sysadmin";
	String password = "sm@c.123";
	String name = "Auto test" + randomNumber();
	String indenticalName;
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
	public void TC_02_DeleteNotChooseRow() {

		dashboardPage.clickToMenu();

		dashboardPage.clickToSubMenu();

		dashboardPage.clickToChildMenu();
		
		documentTypePage = new DocumentTypePageObject(driver);
		
		documentTypePage.clickToDeleteButton();

		Assert.assertEquals(documentTypePage.getAlertMassege(), "Chọn dòng dữ liệu cần xóa.");

		documentTypePage.clickToOkButton();

		System.out.println("TC_02_DeleteNotChooseRow: Sucessfull");
		
	}
		
	@Test
	public void TC_03_AddValidData() {

		documentTypePage = new DocumentTypePageObject(driver);

		documentTypePage.clickToAddButton();
				
		documentTypePage.inputNameTextbox(name);
		documentTypePage.inputOtherNameTextbox(name);
		documentTypePage.inputDescriptionArea(name);
		
		documentTypePage.clickToSaveButton();
		documentTypePage.clickToAcceptButton();
		documentTypePage.clickToOkButton();
		documentTypePage.clickToRefreshButton();
		
		System.out.println("TC_03_AddValidData: Sucessfull");
	}
	
	@Test
	public void TC_04_DeleteData() {
		
		dataTablePage = new DataTablePageObject(driver);
		
		dataTablePage.inputToColumnByName("Tên loại chứng từ", name);
		
		dataTablePage.clickToDynamicRowByName(name);
		
		documentTypePage.clickToDeleteButton();
		
		documentTypePage.clickToAcceptButton();
		
		documentTypePage.clickToOkButton();
		
		System.out.println("TC_04_DeleteData: Sucessfull");
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
