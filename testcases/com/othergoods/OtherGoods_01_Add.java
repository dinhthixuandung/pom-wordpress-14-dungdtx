package com.othergoods;

import org.testng.annotations.Test;
import org.w3c.dom.DocumentType;

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

public class OtherGoods_01_Add {
	WebDriver driver;
	LoginPageObject loginPage;
	DataTablePageObject dataTablePage;
	DashboardPageObject dashboardPage;
	OtherGoodsPageObject otherGoodsPage;
	String userID = "smartpetrosg";
	String password = "123456";
	String expectedRole = "Quản trị cấp công ty";
	String expectedCompany = "Công Ty Smac Petro - Sài Gòn";
	// String name = "Autotest" + randomNumber();
	String name, code;

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
	public void TC_02_InputGoodsCode() {

		dashboardPage.clickToMenu("HỆ THỐNG");

		dashboardPage.clickToSubMenu("D.MỤC HÀNG HÓA");

		dashboardPage.clickToChildMenu("Hàng hóa khác");

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

		dataTablePage.inputToColumnByName("Mã SP", code);

		Assert.assertTrue(dataTablePage.isOnlyOneRowDisplayed("Mã SP", code));

		System.out.println("TC_02_InputGoodCode: Sucessfull");
	}
	
	@Test
	public void TC_03_NotInputGoodsCode() {
		otherGoodsPage = new OtherGoodsPageObject(driver);

		name = "Autotest" + randomNumber();

		otherGoodsPage.clickToAddButton();

		otherGoodsPage.clickToNameTextbox();
		otherGoodsPage.inputNameTextbox(name);
		
		otherGoodsPage.selectItemFromSelectList("Lít");
		
		String[] distributions = {"Dong ban to","Động BÀ BÉ","CHXD số 1"};
		
		otherGoodsPage.selectItemsFromMultivSelectList(distributions);

		otherGoodsPage.clickToSaveButton();
		otherGoodsPage.clickToAcceptButton();
		otherGoodsPage.clickToOkButton();
		
		dataTablePage = new DataTablePageObject(driver);

		dataTablePage.inputToColumnByName("Tên SP", name);

		Assert.assertTrue(dataTablePage.isOnlyOneRowDisplayed("Tên SP", name));

		System.out.println("TC_03_NotInputGoodCode: Sucessfull");	
	}

	@Test
	public void TC_04_InputIndenticalGoodsCode() {
		otherGoodsPage = new OtherGoodsPageObject(driver);
		
		otherGoodsPage.clickToAddButton();

		otherGoodsPage.clickToCodeTextbox();
		otherGoodsPage.inputCodeTextbox(code);

		Assert.assertEquals(otherGoodsPage.getErrorMassege(), "Mã sản phẩm đã tồn tại");

		otherGoodsPage.clickToCloseButton();
		
		System.out.println("TC_04_InputIndenticalGoodsCode: Sucessfull");
		
	}
	

	@Test
	public void TC_05_InputGoodCodeIsSpecialcharacters() {
		otherGoodsPage = new OtherGoodsPageObject(driver);

		otherGoodsPage.clickToAddButton();

		otherGoodsPage.clickToCodeTextbox();
		otherGoodsPage.inputCodeTextbox("~!@#$%^&*()_+");

		Assert.assertEquals(otherGoodsPage.getErrorMassege(), "Không cho phép giá trị đặc biệt !@#$%^&*+");

		otherGoodsPage.clickToCloseButton();

		System.out.println("TC_05_InputGoodCodeIsSpecialcharacters: Sucessfull");
	}


	@Test
	public void TC_06_InputInvalidDataIntoUnit() {
		otherGoodsPage = new OtherGoodsPageObject(driver);

		code = "code" + randomNumber();

		name = "Autotest" + randomNumber();

		otherGoodsPage.clickToAddButton();

		otherGoodsPage.clickToCodeTextbox();
		otherGoodsPage.inputCodeTextbox(code);

		otherGoodsPage.clickToNameTextbox();
		otherGoodsPage.inputNameTextbox(name);
		
		//otherGoodsPage.inputSearchData(code);
		
		Assert.assertEquals(otherGoodsPage.getErrorMassege(), "Không cho phép giá trị đặc biệt !@#$%^&*+");


		System.out.println("TC_02_InputGoodCode: Sucessfull");
	}

	@Test
	public void TC_08_InputNegativeNumberIntoUnit() {

	}

	@Test
	public void TC_09_IndenticalGoodName() {

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
