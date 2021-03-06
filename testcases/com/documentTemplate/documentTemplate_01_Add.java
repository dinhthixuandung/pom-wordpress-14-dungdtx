package com.documentTemplate;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.smartPetro.DashboardPageObject;
import pageObjects.smartPetro.DataTablePageObject;
import pageObjects.smartPetro.DocumentTemplateObject;
import pageObjects.smartPetro.LoginPageObject;
import pageObjects.smartPetro.OtherGoodsPageObject;

public class documentTemplate_01_Add {

	WebDriver driver;
	LoginPageObject loginPage;
	DataTablePageObject dataTablePage;
	DashboardPageObject dashboardPage;
	DocumentTemplateObject documentTemplatePage;
	String userID = "smartpetrosg";
	String password = "123456";
	String expectedRole = "Quản trị cấp công ty";
	String expectedCompany = "Công Ty Smac Petro - Sài Gòn";
	String name, code;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
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
	public void TC_02_Add_Document_Template() {
		dashboardPage.clickToMenu("HỆ THỐNG");

		dashboardPage.clickToSubMenu("D.MỤC CHỨNG TỪ");

		dashboardPage.clickToChildMenu("Mẫu chứng từ");
		
		documentTemplatePage = new DocumentTemplateObject(driver);
		
		documentTemplatePage.clickToAddButton();
		
		documentTemplatePage.inputIntoNameTextbox("Auto 123");
		documentTemplatePage.inputIntoDocumentNoTextbox("AUT/123");
		documentTemplatePage.inputIntoFromValueTextbox("0001");
		documentTemplatePage.inputIntoToValueTextbox("1000");
		
		Distribution[] rows = {new Distribution("CHXD Bà Bé","0001","0500"),
								new Distribution("CHXD Bà Bé","0501","0700"),
								new Distribution("CHXD số 1","0701","1000")};
		
		for(int i=1; i<=rows.length;i++) {
			documentTemplatePage.addNewRow();
			documentTemplatePage.selectItemDynamicDropdownlistAtRowNumber("Đơn vị",Integer.toString(i), rows[i-1].unit);
			documentTemplatePage.inputToDynamicTextboxAtRowNumber("Từ số",Integer.toString(i), rows[i-1].fromValue);
			documentTemplatePage.inputToDynamicTextboxAtRowNumber("Đến số",Integer.toString(i), rows[i-1].toValue);
		}
		
		documentTemplatePage.clickToSaveButton();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public class Distribution {
		public String unit;
		public String fromValue;
		public String toValue;

		public Distribution(String unit, String fromdValue, String toValue) {

			this.unit = unit;
			this.fromValue = fromdValue;
			this.toValue = toValue;
		}
	}

	public int randomNumber() {
		Random number = new Random();
		return number.nextInt(9999);
	}
}
