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

//	public void addNewRows(String columnUnit, Distribution[] rows) {
//		sleepInSeconds(3);
//		waitForElementClickable(driver, DocumentTemplatePageUI.ADD_ROW_BUTTON);
//
//		
//		inputDataIntoRows(driver, DocumentTemplatePageUI.ADD_ROW_BUTTON, columnUnit,DocumentTemplatePageUI.UNIT_DROPDOWNLIST_TABLE, 
//				DocumentTemplatePageUI.ALL_CHILDREN_UNIT_DROPDOWNLIST_TABLE, DocumentTemplatePageUI.FROM_VALUE_TABLE,
//				DocumentTemplatePageUI.TO_VALUE_TABLE, rows);
//		sleepInSeconds(1);
//	}
	
//	public void selectUnit(String expectedUnit) {
//		
//		waitForElementVisible(driver, pageUI.smartPetro.DocumentTemplatePageUI.UNIT_DROPDOWNLIST_TABLE);
//		selectItemInCustomDropdown(driver, pageUI.smartPetro.DocumentTemplatePageUI.UNIT_DROPDOWNLIST_TABLE, pageUI.smartPetro.DocumentTemplatePageUI.ALL_CHILDREN_UNIT_DROPDOWNLIST_TABLE, expectedUnit);
//		sleepInSeconds(1);
//	
//	}


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
		sendKeysToElement(driver, DocumentTemplatePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, rowNumber, Integer.toString(columnPosition));
	}


	public void selectItemDynamicDropdownlistAtRowNumber(String columnName, String rowNumber, String inputValue) {
		waitForElementVisible(driver, DocumentTemplatePageUI.DYNAMIC_COLUMN_POSITION_INDEX, columnName);
		int columnPosition = countElementNumber(driver, DocumentTemplatePageUI.DYNAMIC_COLUMN_POSITION_INDEX, columnName) + 1;
		selectItemInCustomDropdown(driver, DocumentTemplatePageUI.DYNAMIC_DROPDOWNLIST_BY_ROW_AND_COLUMN_INDEX, 
				DocumentTemplatePageUI.DYNAMIC_ALL_CHILDREN_DROPDOWNLIST_BY_ROW_AND_COLUMN_INDEX,rowNumber, Integer.toString(columnPosition));
	}
}
