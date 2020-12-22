package pageObjects.smartPetro;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.bankGuru.LoginPageUI;

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
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, pageUI.smartPetro.LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, pageUI.smartPetro.LoginPageUI.LOGIN_BUTTON);
	}

	
	

}
