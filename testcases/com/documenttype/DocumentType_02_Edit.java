package com.documenttype;

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
	String expectedRole = "Quản trị cấp công ty";
	String expectedCompany = "Công Ty Smac Petro - Sài Gòn";
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
		
		loginPage.selectRole(expectedRole);		
		
		loginPage.selectCompany(expectedCompany);
		loginPage.clickToAcceptButton();
		
		dashboardPage = new DashboardPageObject(driver);
		Assert.assertTrue(dashboardPage.isDisplayedHeader());
		System.out.println("TC_01_Login: Sucessfull");
	}

	@Test
	public void TC_02_EditNotChooseRow() {

//		dashboardPage.clickToMenu();
//
//		dashboardPage.clickToSubMenu();
//
//		dashboardPage.clickToChildMenu();

		documentTypePage = new DocumentTypePageObject(driver);

		documentTypePage.clickToEditButton();

		Assert.assertEquals(documentTypePage.getAlertMassege(), "Ch�?n dòng dữ liệu cần chỉnh sửa.");

		documentTypePage.clickToOkButton();

		System.out.println("TC_02_EditNotChooseRow: Sucessfull");

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
	public void TC_04_EditNotInputRequireField() {

		dataTablePage = new DataTablePageObject(driver);

		dataTablePage.inputToColumnByName("Tên loại chứng từ", name);

		dataTablePage.clickToDynamicRowByName(name);

		documentTypePage.clickToEditButton();

		documentTypePage.clickToNameTextbox();
		documentTypePage.clearData();
		documentTypePage.clickToOtherTextbox();

		Assert.assertEquals(documentTypePage.getErrorMassege(), "Không được để trống");

		documentTypePage.clickToCloseButton();

		System.out.println("TC_04_EditNotInputRequireField: Sucessfull");
	}

	@Test
	public void TC_05_Edit_IndenticalData() {

		dataTablePage = new DataTablePageObject(driver);

		dataTablePage.inputToColumnByName("Tên loại chứng từ", name);

		dataTablePage.clickToDynamicRowByName(name);

		documentTypePage.clickToEditButton();

		documentTypePage.inputNameTextbox("Hoá đơn giá trị gia tăng");

		Assert.assertEquals(documentTypePage.getErrorMassege(), "Tên loại chứng từ đã tồn tại");

		documentTypePage.clickToCloseButton();

		System.out.println("TC_05_Edit_IndenticalData: Sucessfull");
	}

	@Test
	public void TC_06_EditWithValidData() {
		dataTablePage = new DataTablePageObject(driver);

		dataTablePage.inputToColumnByName("Tên loại chứng từ", name);

		dataTablePage.clickToDynamicRowByName(name);

		documentTypePage.clickToEditButton();

		documentTypePage.inputNameTextbox("edited" + randomNumber());
		documentTypePage.inputOtherNameTextbox("edited" + randomNumber());
		documentTypePage.inputDescriptionArea("edited" + randomNumber());

		documentTypePage.clickToSaveButton();
		documentTypePage.clickToAcceptButton();
		documentTypePage.clickToOkButton();

		System.out.println("TC_06_EditWithValidData: Sucessfull");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random number = new Random();
		return number.nextInt(9999);
	}
}
