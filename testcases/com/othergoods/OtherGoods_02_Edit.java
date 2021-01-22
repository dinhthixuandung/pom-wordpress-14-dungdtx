package com.othergoods;

import org.testng.annotations.Test;
import org.w3c.dom.DocumentType;

import com.thoughtworks.selenium.webdriven.commands.Refresh;

import pageObjects.smartPetro.DashboardPageObject;
import pageObjects.smartPetro.DataTablePageObject;
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

public class OtherGoods_02_Edit {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	OtherGoodsPageObject otherGoodsPage;
	String userID = "smartpetrosg";
	String password = "123456";
	String expectedRole = "Quản trị cấp công ty";
	String expectedCompany = "Công Ty Smac Petro - Sài Gòn";
	String name, code;
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

		dashboardPage.clickToMenu("HỆ THỐNG");

		dashboardPage.clickToSubMenu("D.MỤC HÀNG HÓA");

		dashboardPage.clickToChildMenu("Hàng hóa khác");

		otherGoodsPage = new OtherGoodsPageObject(driver);

		otherGoodsPage.clickToEditButton();

		Assert.assertEquals(otherGoodsPage.getAlertMassege(), "Chọn dòng dữ liệu cần chỉnh sửa.");

		otherGoodsPage.clickToOkButton();

		System.out.println("TC_02_EditNotChooseRow: Sucessfull");

	}
	
	@Test
	public void TC_03_EditValidData() {

		otherGoodsPage = new OtherGoodsPageObject(driver);

		code = "code" + randomNumber();

		name = "Autotest" + randomNumber();

		otherGoodsPage.clickToAddButton();

		otherGoodsPage.clickToCodeTextbox();
		otherGoodsPage.inputCodeTextbox(code);

		otherGoodsPage.clickToNameTextbox();
		otherGoodsPage.inputNameTextbox(name);
		
		otherGoodsPage.selectItemFromSelectList("Thùng");

		otherGoodsPage.clickToSaveButton();
		otherGoodsPage.clickToAcceptButton();
		otherGoodsPage.clickToOkButton();
		
		dataTablePage = new DataTablePageObject(driver);

		dataTablePage.inputToColumnByName("Tên SP", name);

		dataTablePage.clickToDynamicRowByName(name);

		otherGoodsPage.clickToEditButton();
		
		otherGoodsPage.clickToNameTextbox();
		otherGoodsPage.inputNameTextbox("Updated");
		
		otherGoodsPage.selectItemFromSelectList("Lít");
		
		String[] distributions = {"Dong ban to","Động BÀ BÉ"};
		
		otherGoodsPage.selectItemsFromMultivSelectList(distributions);

		otherGoodsPage.clickToSaveButton();
		otherGoodsPage.clickToAcceptButton();
		otherGoodsPage.clickToOkButton();

		System.out.println("TC_03_AddValidData: Sucessfull");
	}

	@Test
	public void TC_04_EditNotInputRequireField() {

		dataTablePage = new DataTablePageObject(driver);

		dataTablePage.inputToColumnByName("Tên SP", "Updated");

		dataTablePage.clickToDynamicRowByName("Updated");

		otherGoodsPage.clickToEditButton();

		otherGoodsPage.clickToNameTextbox();
		otherGoodsPage.clearData();
		otherGoodsPage.clickToDescriptionArea();

		Assert.assertEquals(otherGoodsPage.getErrorMessage("Tên SP"), "Không được để trống");

		otherGoodsPage.clickToCloseButton();

		System.out.println("TC_04_EditNotInputRequireField: Sucessfull");
	}

	@Test
	public void TC_05_Edit_IndenticalData() {

		dataTablePage = new DataTablePageObject(driver);
		
		String indentical = dataTablePage.getNameFirstRow();

		dataTablePage.inputToColumnByName("Tên SP", "Updated");

		dataTablePage.clickToDynamicRowByName("Updated");

		otherGoodsPage.clickToEditButton();

		
		otherGoodsPage.inputNameTextbox(indentical);

		Assert.assertEquals(otherGoodsPage.getErrorMessage("Tên SP"), "Tên sản phẩm đã tồn tại");

		otherGoodsPage.clickToCloseButton();

		System.out.println("TC_05_Edit_IndenticalData: Sucessfull");
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
