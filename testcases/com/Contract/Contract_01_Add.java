package com.Contract;

import org.testng.annotations.Test;

import pageObjects.smartPetro.ContractPageObject;
import pageObjects.smartPetro.DashboardPageObject;
import pageObjects.smartPetro.LoginPageObject;
import pageObjects.smartPetro.OtherGoodsPageObject;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.apache.james.mime4j.field.datetime.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Contract_01_Add {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	ContractPageObject contractPage;
	String userID = "smartpetrosg";
	String password = "123456";
	String expectedRole = "Quản trị cấp công ty";
	String expectedCompany = "Công Ty Smac Petro - Sài Gòn";

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
	public void ValidData() {
		dashboardPage.clickToMenu("BÁN HÀNG");
		dashboardPage.clickToChildMenu("Chính sách công nợ");

		contractPage = new ContractPageObject(driver);
		contractPage.clickToAddButton();
		contractPage.inputIntoPolicyCodeTextbox("Autotest");
		contractPage.selectPolicyDate(getToday());
		// contractPage.selectFromDate(getToday());
		contractPage.selectToDate(nextYear());
		String[] units = {"Trạm Smac01","Động BÀ BÉ"};
		contractPage.selectVehicleTreeview("Công Ty Smac Petro - Sài Gòn",units);
		String[] vehicles = { "72S1-0002", "72S1-0001" };
		//String[] vehicles = {};
		contractPage.selectVehicleTreeview("Boutique Công Nợ",vehicles);
		contractPage.inputIntoCreditLimitTextbox("50000000");
		contractPage.inputIntoDueCycleTextbox("1");
		contractPage.inputIntoDayPastDueTextbox("3");
		contractPage.inputIntoCreditLimitVehicleTextbox("5000000");
		contractPage.clickToSaveButton();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String getToday() {
		String today = (java.time.LocalDate.now()).toString();
		String dateStr[] = today.split("-");
		String expDate = dateStr[2] + "/" + dateStr[1] + "/" + dateStr[0];
		return expDate;
	}

	public String nextYear() {
		String today = (java.time.LocalDate.now()).toString();
		String dateStr[] = today.split("-");
		int year = Integer.parseInt(dateStr[0]) + 1;
		String expDate = dateStr[2] + "/" + dateStr[1] + "/" + year;
		return expDate;
	}
}
