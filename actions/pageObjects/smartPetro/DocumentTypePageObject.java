package pageObjects.smartPetro;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;

import commons.AbstractPage;
import pageUI.smartPetro.DocumentTypePageUI;
import pageUI.smartPetro.ToolbarAndMenuPageUI;

public class DocumentTypePageObject extends AbstractPage{
	WebDriver driver;

	public DocumentTypePageObject(WebDriver mapDriver) {
		driver = mapDriver;
	}

	public void clickToAddButton() {
		waitForElementClickable(driver, ToolbarAndMenuPageUI.ADD_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.ADD_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToRefreshButton() {
		waitForElementClickable(driver, ToolbarAndMenuPageUI.REFRESH_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.REFRESH_BUTTON);
		sleepInSeconds(1);
	}


	public void inputNameTextbox(String name) {
		waitForElementVisible(driver, DocumentTypePageUI.NAME_TEXTBOX);
		sendKeysToElement(driver, DocumentTypePageUI.NAME_TEXTBOX, name);
		
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
		waitForElementClickable(driver, ToolbarAndMenuPageUI.SAVE_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.SAVE_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToAcceptButton() {
		waitForElementClickable(driver, ToolbarAndMenuPageUI.ACCEPT_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.ACCEPT_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToOkButton() {
		waitForElementClickable(driver, ToolbarAndMenuPageUI.OK_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.OK_BUTTON);
		sleepInSeconds(1);
	}
		
	public String getErrorMassege() {
		waitForElementVisible(driver, ToolbarAndMenuPageUI.ERR_MESSAGE);
		return getElementText(driver, ToolbarAndMenuPageUI.ERR_MESSAGE);
		
	}

	public void clickToCloseButton() {
		waitForElementClickable(driver, ToolbarAndMenuPageUI.CLOSE_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.CLOSE_BUTTON);
		sleepInSeconds(1);
	}

	public void clickToEditButton() {
		waitForElementClickable(driver, ToolbarAndMenuPageUI.EDIT_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.EDIT_BUTTON);
		sleepInSeconds(1);
	}


	public String getAlertMassege() {
		waitForElementVisible(driver, ToolbarAndMenuPageUI.ALERT_TEXT);
		return getElementText(driver, ToolbarAndMenuPageUI.ALERT_TEXT);
	}

	public void clickToNameTextbox() {
		waitForElementClickable(driver, DocumentTypePageUI.NAME_TEXTBOX);	
		clickToElement(driver, DocumentTypePageUI.NAME_TEXTBOX);
		sleepInSeconds(1);
		
	}

	public void clickToDeleteButton() {
		waitForElementClickable(driver, ToolbarAndMenuPageUI.DEL_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.DEL_BUTTON);
		sleepInSeconds(1);
	}

	public void clearData() {

		waitForElementVisible(driver, DocumentTypePageUI.NAME_TEXTBOX);
		clearElement(driver, DocumentTypePageUI.NAME_TEXTBOX);
		sleepInSeconds(1);
	}

	public void clickToOtherTextbox() {
		waitForElementVisible(driver, DocumentTypePageUI.OTHERNAME_TEXTBOX);
		clickToElement(driver, DocumentTypePageUI.OTHERNAME_TEXTBOX);
	}

	
	
}
