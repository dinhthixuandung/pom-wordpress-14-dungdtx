package pageObjects.smartPetro;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.smartPetro.DocumentTypePageUI;
import pageUI.smartPetro.OtherGoodsPageUI;

public class OtherGoodsPageObject extends AbstractPage{
	WebDriver driver;
	
	public OtherGoodsPageObject(WebDriver mapDriver) {
		
		driver = mapDriver;
	}
	
	public void clickToAddButton() {
		waitForElementClickable(driver, OtherGoodsPageUI.ADD_BUTTON);
		clickToElement(driver, OtherGoodsPageUI.ADD_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToRefreshButton() {
		waitForElementClickable(driver, OtherGoodsPageUI.REFRESH_BUTTON);
		clickToElement(driver, OtherGoodsPageUI.REFRESH_BUTTON);
		sleepInSeconds(1);
	}


	public void inputNameTextbox(String name) {
		waitForElementVisible(driver, OtherGoodsPageUI.NAME_TEXTBOX);
		sendKeysToElement(driver, OtherGoodsPageUI.NAME_TEXTBOX, name);
		
	}
	
	public void inputDescriptionArea(String description) {
		waitForElementVisible(driver, OtherGoodsPageUI.DESCRIPTION_AREA);
		sendKeysToElement(driver, OtherGoodsPageUI.DESCRIPTION_AREA, description);
		
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, OtherGoodsPageUI.SAVE_BUTTON);
		clickToElement(driver, OtherGoodsPageUI.SAVE_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToAcceptButton() {
		waitForElementClickable(driver, OtherGoodsPageUI.ACCEPT_BUTTON);
		clickToElement(driver, OtherGoodsPageUI.ACCEPT_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToOkButton() {
		waitForElementClickable(driver, OtherGoodsPageUI.OK_BUTTON);
		clickToElement(driver, OtherGoodsPageUI.OK_BUTTON);
		sleepInSeconds(1);
	}
		
	public String getErrorMassege() {
		waitForElementVisible(driver, OtherGoodsPageUI.ERROR_MESSAGE_TEXT);
		return getElementText(driver, OtherGoodsPageUI.ERROR_MESSAGE_TEXT);
		
	}

	public void clickToCloseButton() {
		waitForElementClickable(driver, OtherGoodsPageUI.CLOSE_BUTTON);
		clickToElement(driver, OtherGoodsPageUI.CLOSE_BUTTON);
		sleepInSeconds(1);
	}

	public void clickToEditButton() {
		waitForElementClickable(driver, OtherGoodsPageUI.EDIT_BUTTON);
		clickToElement(driver, OtherGoodsPageUI.EDIT_BUTTON);
		sleepInSeconds(1);
	}


	public String getAlertMassege() {
		waitForElementVisible(driver, OtherGoodsPageUI.ALERT_TEXT);
		return getElementText(driver, OtherGoodsPageUI.ALERT_TEXT);
	}

	public void clickToNameTextbox() {
		waitForElementClickable(driver, OtherGoodsPageUI.NAME_TEXTBOX);	
		clickToElement(driver, OtherGoodsPageUI.NAME_TEXTBOX);
		sleepInSeconds(1);
		
	}

	public void clickToDeleteButton() {
		waitForElementClickable(driver, DocumentTypePageUI.DEL_BUTTON);
		clickToElement(driver, DocumentTypePageUI.DEL_BUTTON);
		sleepInSeconds(1);
	}

	public void clearData() {

		waitForElementVisible(driver, DocumentTypePageUI.NAME_TEXTBOX);
		clearElement(driver, DocumentTypePageUI.NAME_TEXTBOX);
		sleepInSeconds(1);
	}

	public void clickToDescriptionArea() {
		waitForElementVisible(driver, OtherGoodsPageUI.DESCRIPTION_AREA);
		clickToElement(driver, OtherGoodsPageUI.DESCRIPTION_AREA);
		sleepInSeconds(1);
	}

	public boolean enableSaveButton() {
		
		return isElementEnabled(driver, OtherGoodsPageUI.SAVE_BUTTON);
	}

}
