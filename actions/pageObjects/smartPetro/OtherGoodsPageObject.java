package pageObjects.smartPetro;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.smartPetro.DocumentTypePageUI;
import pageUI.smartPetro.OtherGoodsPageUI;
import pageUI.smartPetro.ToolbarAndMenuPageUI;

public class OtherGoodsPageObject extends AbstractPage{
	WebDriver driver;
	
	public OtherGoodsPageObject(WebDriver mapDriver) {
		
		driver = mapDriver;
	}
	
	public void clickToAddButton() {
		sleepInSeconds(3);
		waitForElementClickable(driver, ToolbarAndMenuPageUI.ADD_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.ADD_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToRefreshButton() {
		waitForElementClickable(driver, ToolbarAndMenuPageUI.REFRESH_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.REFRESH_BUTTON);
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
	
	public void inputPriceTextbox(String value) {
		waitForElementVisible(driver, OtherGoodsPageUI.PRICE_TEXTBOX);
		sendKeysToElement(driver, OtherGoodsPageUI.PRICE_TEXTBOX, value);
		sleepInSeconds(1);
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
		
	public String getErrorMessage(String fieldName) {
		sleepInSeconds(1);
		waitForElementVisible(driver, ToolbarAndMenuPageUI.ERR_MESSAGE, fieldName);
		return getElementText(driver, ToolbarAndMenuPageUI.ERR_MESSAGE, fieldName);
		
	}
	
//	public String getNameErrMessage() {
//		sleepInSeconds(1);
//		waitForElementVisible(driver, OtherGoodsPageUI.PRICE_ERR_MESSAGE);
//		return getElementText(driver, OtherGoodsPageUI.PRICE_ERR_MESSAGE);
//	}
//	
//	public String getPriceErrMessage() {
//		sleepInSeconds(1);
//		waitForElementVisible(driver, OtherGoodsPageUI.PRICE_ERR_MESSAGE);
//		return getElementText(driver, OtherGoodsPageUI.PRICE_ERR_MESSAGE);
//	}

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
		waitForElementClickable(driver, OtherGoodsPageUI.NAME_TEXTBOX);	
		clickToElement(driver, OtherGoodsPageUI.NAME_TEXTBOX);
		sleepInSeconds(1);
		
	}
	
	public void clickToPriceTextbox() {
		waitForElementClickable(driver, OtherGoodsPageUI.PRICE_TEXTBOX);	
		clickToElement(driver, OtherGoodsPageUI.PRICE_TEXTBOX);
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

	public void clickToDescriptionArea() {
		waitForElementClickable(driver, OtherGoodsPageUI.DESCRIPTION_AREA);
		clickToElement(driver, OtherGoodsPageUI.DESCRIPTION_AREA);
		sleepInSeconds(1);
	}

	public boolean enableSaveButton() {
		
		return isElementEnabled(driver, ToolbarAndMenuPageUI.SAVE_BUTTON);
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

	public void inputSearchData(String searchValue) {
		waitForElementVisible(driver, OtherGoodsPageUI.UNIT_DROPDOWNLIST);
		//clickToElement(driver, OtherGoodsPageUI.UNIT_DROPDOWNLIST);
		//sendKeysToElement(driver, OtherGoodsPageUI.UNIT_SEARCH_DROPDOWNLIST, code);
		searchItemInCustomDropdown(driver, OtherGoodsPageUI.UNIT_DROPDOWNLIST, OtherGoodsPageUI.UNIT_SEARCH_RESULT_DROPDOWNLIST, OtherGoodsPageUI.UNIT_SEARCH_DROPDOWNLIST, searchValue);
	}

	public String getDataFromUnitDropdownlist() {
	
		return getElementText(driver, OtherGoodsPageUI.UNIT_SEARCH_RESULT_DROPDOWNLIST);
	}

	

	

	

	

	

	

	

}
