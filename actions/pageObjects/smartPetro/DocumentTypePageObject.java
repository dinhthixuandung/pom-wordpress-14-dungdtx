package pageObjects.smartPetro;

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
		waitForElementVisible(driver, DocumentTypePageUI.ADD_BUTTON);
		clickToElement(driver, DocumentTypePageUI.ADD_BUTTON);
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
		waitForElementVisible(driver, DocumentTypePageUI.SAVE_BUTTON);
		clickToElement(driver, DocumentTypePageUI.SAVE_BUTTON);
		
		waitForElementVisible(driver, DocumentTypePageUI.ACCEPT_BUTTON);
		clickToElement(driver, DocumentTypePageUI.ACCEPT_BUTTON);
		
		waitForElementVisible(driver, DocumentTypePageUI.OK_BUTTON);
		clickToElement(driver, DocumentTypePageUI.OK_BUTTON);
	}
	
	public void clickToOtherNameTextbox() {
		waitForElementVisible(driver, DocumentTypePageUI.OTHERNAME_TEXTBOX);
		clickToElement(driver, DocumentTypePageUI.OTHERNAME_TEXTBOX);
	}

	public String getErrorMassege() {
		waitForElementVisible(driver, DocumentTypePageUI.ERROR_MESSAGE_TEXT);
		return getElementText(driver, DocumentTypePageUI.ERROR_MESSAGE_TEXT);
	}

	public void clickToCloseButton() {
		waitForElementVisible(driver, DocumentTypePageUI.CLOSE_BUTTON);
		clickToElement(driver, DocumentTypePageUI.CLOSE_BUTTON);
	}
	
}
