package pageObjects.smartPetro;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;

import commons.AbstractPage;
import pageUI.smartPetro.DocumentTypePageUI;

public class DocumentTypePageObject extends AbstractPage{
	WebDriver driver;

	public DocumentTypePageObject(WebDriver mapDriver) {
		driver = mapDriver;
	}

	public void clickToAddButton() {
		waitForElementClickable(driver, DocumentTypePageUI.ADD_BUTTON);
		clickToElement(driver, DocumentTypePageUI.ADD_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToRefreshButton() {
		waitForElementClickable(driver, DocumentTypePageUI.REFRESH_BUTTON);
		clickToElement(driver, DocumentTypePageUI.REFRESH_BUTTON);
		sleepInSeconds(1);
	}


	public void inputNameTextbox(String name) {
		waitForElementVisible(driver, DocumentTypePageUI.DOCUMENTNAME_TEXTBOX);
		sendKeysToElement(driver, DocumentTypePageUI.DOCUMENTNAME_TEXTBOX, name);
		
	}
	
	public void inputOtherNameTextbox(String otherName) {
		waitForElementVisible(driver, DocumentTypePageUI.OTHERNAME_TEXTBOX);
		sendKeysToElement(driver, DocumentTypePageUI.OTHERNAME_TEXTBOX, otherName);
		
	}

	public void inputDescriptionArea(String description) {
		waitForElementVisible(driver, DocumentTypePageUI.DESCRIPTION_TEXTBOX);
		sendKeysToElement(driver, DocumentTypePageUI.DESCRIPTION_TEXTBOX, description);
		
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, DocumentTypePageUI.SAVE_BUTTON);
		clickToElement(driver, DocumentTypePageUI.SAVE_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToAcceptButton() {
		waitForElementClickable(driver, DocumentTypePageUI.ACCEPT_BUTTON);
		clickToElement(driver, DocumentTypePageUI.ACCEPT_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToOkButton() {
		waitForElementClickable(driver, DocumentTypePageUI.OK_BUTTON);
		clickToElement(driver, DocumentTypePageUI.OK_BUTTON);
		sleepInSeconds(1);
	}
		
	public String getErrorMassege() {
		waitForElementVisible(driver, DocumentTypePageUI.ERROR_MESSAGE_TEXT);
		return getElementText(driver, DocumentTypePageUI.ERROR_MESSAGE_TEXT);
		
	}

	public void clickToCloseButton() {
		waitForElementClickable(driver, DocumentTypePageUI.CLOSE_BUTTON);
		clickToElement(driver, DocumentTypePageUI.CLOSE_BUTTON);
		sleepInSeconds(1);
	}

	public void clickToEditButton() {
		waitForElementClickable(driver, DocumentTypePageUI.EDIT_BUTTON);
		clickToElement(driver, DocumentTypePageUI.EDIT_BUTTON);
		sleepInSeconds(1);
	}


	public String getAlertMassege() {
		waitForElementVisible(driver, DocumentTypePageUI.ALERT_TEXT);
		return getElementText(driver, DocumentTypePageUI.ALERT_TEXT);
	}

	public void clickToNameTextbox() {
		waitForElementClickable(driver, DocumentTypePageUI.DOCUMENTNAME_TEXTBOX);	
		clickToElement(driver, DocumentTypePageUI.DOCUMENTNAME_TEXTBOX);
		sleepInSeconds(1);
		
	}

	public void clickToDeleteButton() {
		waitForElementClickable(driver, DocumentTypePageUI.DEL_BUTTON);
		clickToElement(driver, DocumentTypePageUI.DEL_BUTTON);
		sleepInSeconds(1);
	}

	public void clearData() {

		waitForElementVisible(driver, DocumentTypePageUI.DOCUMENTNAME_TEXTBOX);
		clearElement(driver, DocumentTypePageUI.DOCUMENTNAME_TEXTBOX);
		sleepInSeconds(1);
	}

	public void clickToOtherTextbox() {
		waitForElementVisible(driver, DocumentTypePageUI.OTHERNAME_TEXTBOX);
		clickToElement(driver, DocumentTypePageUI.OTHERNAME_TEXTBOX);
	}

	
	
}
