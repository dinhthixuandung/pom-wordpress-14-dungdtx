package pageObjects.smartPetro;

import org.openqa.selenium.WebDriver;

import com.documentTemplate.documentTemplate_01_Add.Distribution;

import commons.AbstractPage;
import pageUI.smartPetro.ToolbarAndMenuPageUI;
import pageUI.smartPetro.DocumentTemplatePageUI;

public class DocumentTemplateObject extends AbstractPage{
	WebDriver driver;
	
	public class distribution{
		String unit;
		int fromValue;
		int toValue;
	}
	
	public DocumentTemplateObject(WebDriver mapDriver) {
		
		driver = mapDriver;
	}
	
	
	public void clickToAddButton() {
		sleepInSeconds(3);
		waitForElementClickable(driver, ToolbarAndMenuPageUI.ADD_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.ADD_BUTTON);
		sleepInSeconds(1);
	}




	public void inputIntoNameTextbox(String name) {
		waitForElementClickable(driver, DocumentTemplatePageUI.NAME_TEXTBOX);
		sendKeysToElement(driver, DocumentTemplatePageUI.NAME_TEXTBOX, name);
		sleepInSeconds(1);
	}


	public void inputIntoDocumentNoTextbox(String documentNo) {
		waitForElementClickable(driver, DocumentTemplatePageUI.DOCUMENT_NO_TEXTBOX);
		sendKeysToElement(driver, DocumentTemplatePageUI.DOCUMENT_NO_TEXTBOX, documentNo);
		sleepInSeconds(1);
	}
	
	public void inputIntoFromValueTextbox(String fromValue) {
		waitForElementClickable(driver, DocumentTemplatePageUI.FROM_VALUE_TEXTBOX);
		sendKeysToElement(driver, DocumentTemplatePageUI.FROM_VALUE_TEXTBOX, fromValue);
		sleepInSeconds(1);
	}
	
	public void inputIntoToValueTextbox(String toValue) {
		waitForElementClickable(driver, DocumentTemplatePageUI.TO_VALUE_TEXTBOX);
		sendKeysToElement(driver, DocumentTemplatePageUI.TO_VALUE_TEXTBOX, toValue);
		sleepInSeconds(1);
	}
	

	public void inputToDynamicTextboxAtRowNumber(String columnName, String rowNumber, String inputValue) {
		waitForElementVisible(driver, DocumentTemplatePageUI.DYNAMIC_COLUMN_POSITION_INDEX, columnName);
		int columnPosition = countElementNumber(driver, DocumentTemplatePageUI.DYNAMIC_COLUMN_POSITION_INDEX, columnName) + 1;
		sendKeysToElement(driver, DocumentTemplatePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, inputValue, rowNumber, Integer.toString(columnPosition));
	}


	public void selectItemDynamicDropdownlistAtRowNumber(String columnName, String rowNumber, String expectedValue) {
		waitForElementVisible(driver, DocumentTemplatePageUI.DYNAMIC_COLUMN_POSITION_INDEX, columnName);
		int columnPosition = countElementNumber(driver, DocumentTemplatePageUI.DYNAMIC_COLUMN_POSITION_INDEX, columnName) + 1;
		selectItemInCustomDropdown(driver, DocumentTemplatePageUI.DYNAMIC_DROPDOWNLIST_BY_ROW_AND_COLUMN_INDEX, 
				DocumentTemplatePageUI.DYNAMIC_ALL_CHILDREN_DROPDOWNLIST_BY_ROW_AND_COLUMN_INDEX, expectedValue, rowNumber, Integer.toString(columnPosition));
	}

	public void addNewRow() {
		waitForElementClickable(driver, DocumentTemplatePageUI.ADD_ROW_BUTTON);
		clickToElement(driver, DocumentTemplatePageUI.ADD_ROW_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToSaveButton() {
		waitForElementClickable(driver, ToolbarAndMenuPageUI.SAVE_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.SAVE_BUTTON);
		sleepInSeconds(1);
	}
}
