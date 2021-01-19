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
		sleepInSeconds(3);
		waitForElementClickable(driver, OtherGoodsPageUI.ADD_BUTTON);
		clickToElement(driver, OtherGoodsPageUI.ADD_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToRefreshButton() {
		waitForElementClickable(driver, OtherGoodsPageUI.REFRESH_BUTTON);
		clickToElement(driver, OtherGoodsPageUI.REFRESH_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToCodeTextbox() {
		waitForElementClickable(driver, OtherGoodsPageUI.CODE_TEXTBOX);
		clickToElement(driver, OtherGoodsPageUI.CODE_TEXTBOX);
		
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
		sleepInSeconds(1);
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
		waitForElementClickable(driver, OtherGoodsPageUI.DESCRIPTION_AREA);
		clickToElement(driver, OtherGoodsPageUI.DESCRIPTION_AREA);
		sleepInSeconds(1);
	}

	public boolean enableSaveButton() {
		
		return isElementEnabled(driver, OtherGoodsPageUI.SAVE_BUTTON);
	}

	public void inputCodeTextbox(String code) {
		waitForElementVisible(driver, OtherGoodsPageUI.CODE_TEXTBOX);
		sendKeysToElement(driver, OtherGoodsPageUI.CODE_TEXTBOX, code);
		
	}

	public void selectItemFromSelectList(String value) {
		waitForElementVisible(driver, OtherGoodsPageUI.UNIT_DROPDOWNLIST, value);
		selectItemInCustomDropdown(driver, OtherGoodsPageUI.UNIT_DROPDOWNLIST, OtherGoodsPageUI.ALL_UNIT_DROPDOWNLIST, value);
		sleepInSeconds(1);
	}

	public void clickToSelectList() {
		waitForElementClickable(driver, OtherGoodsPageUI.UNIT_DROPDOWNLIST);
		clickToElement(driver, OtherGoodsPageUI.UNIT_DROPDOWNLIST);
		sleepInSeconds(1);
	}

	public void selectItemsFromMultivSelectList(String[] distributions) {
		waitForElementVisible(driver, OtherGoodsPageUI.DISTRIBUTE_MULTISELECTLIST);
		selectItemsInMultiDropdown(driver, OtherGoodsPageUI.DISTRIBUTE_MULTISELECTLIST, OtherGoodsPageUI.ALL_DISTRIBUTE_MULTISELECTLIST, distributions);
		sleepInSeconds(1);
	}

	public void inputSearchData(String code) {
		waitForElementVisible(driver, OtherGoodsPageUI.UNIT_DROPDOWNLIST);
//		clickToElement(driver, OtherGoodsPageUI.UNIT_DROPDOWNLIST);
//		sendKeysToElement(driver, OtherGoodsPageUI.UNIT_SEARCH_DROPDOWNLIST, code);
//		return
	}

	

	

}
