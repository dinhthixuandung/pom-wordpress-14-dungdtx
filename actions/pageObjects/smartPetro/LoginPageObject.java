package pageObjects.smartPetro;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver mapDriver) {
		
		driver = mapDriver;
	}

	public void inputToUserIDTextbox(String userID) {
		waitForElementVisible(driver, pageUI.smartPetro.LoginPageUI.USER_ID_TEXTBOX);
		sendKeysToElement(driver, pageUI.smartPetro.LoginPageUI.USER_ID_TEXTBOX, userID);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, pageUI.smartPetro.LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, pageUI.smartPetro.LoginPageUI.PASSWORD_TEXTBOX, password);
		sleepInSeconds(1);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, pageUI.smartPetro.LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, pageUI.smartPetro.LoginPageUI.LOGIN_BUTTON);
		sleepInSeconds(1);
	}

//	public void clickToRoleDropdownlist() {
//		waitForElementVisible(driver, pageUI.smartPetro.LoginPageUI.ROLE_DROPDOWNLIST);
//		clickToElement(driver, pageUI.smartPetro.LoginPageUI.ROLE_DROPDOWNLIST);
//		sleepInSeconds(1);
//	
//	}
	
	public void selectRole(String expectedRole) {
		
		waitForElementVisible(driver, pageUI.smartPetro.LoginPageUI.ROLE_DROPDOWNLIST);
		selectItemInCustomDropdown(driver, pageUI.smartPetro.LoginPageUI.ROLE_DROPDOWNLIST, pageUI.smartPetro.LoginPageUI.ALL_ROLE_DROPDOWNLIST, expectedRole);
		sleepInSeconds(1);
	
	}

	public void clickToAcceptButton() {
		waitForElementClickable(driver, pageUI.smartPetro.LoginPageUI.ACCEPT_BUTTON);
		clickToElement(driver, pageUI.smartPetro.LoginPageUI.ACCEPT_BUTTON);
		sleepInSeconds(1);
	}
	
//	public void clickToCompanyDropdownlist() {
//		waitForElementVisible(driver, pageUI.smartPetro.LoginPageUI.COMPANY_DROPDOWNLIST);
//		clickToElement(driver, pageUI.smartPetro.LoginPageUI.COMPANY_DROPDOWNLIST);
//		sleepInSeconds(1);
//	
//	}

	public void selectCompany(String expectedCompany) {
		
		waitForElementVisible(driver, pageUI.smartPetro.LoginPageUI.COMPANY_DROPDOWNLIST);
		selectItemInCustomDropdown(driver, pageUI.smartPetro.LoginPageUI.COMPANY_DROPDOWNLIST, pageUI.smartPetro.LoginPageUI.ALL_COMPANY_DROPDOWNLIST, expectedCompany);
		sleepInSeconds(1);
	}

	
	

}
