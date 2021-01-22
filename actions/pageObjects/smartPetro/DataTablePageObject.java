package pageObjects.smartPetro;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.smartPetro.DataTablePageUI;

public class DataTablePageObject extends AbstractPage{
	WebDriver driver;
	
	public DataTablePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToColumnByName(String columnName, String value) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_HEADER_COLUMN_TEXT, columnName);
		sendKeysToElement(driver, DataTablePageUI.DYNAMIC_HEADER_COLUMN_TEXT, value, columnName);
		sendKeyBoardToElement(driver, DataTablePageUI.DYNAMIC_HEADER_COLUMN_TEXT, Keys.ENTER, columnName);
		
	}

	public boolean isOnlyOneRowDisplayed(String textValue) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_ROW_TEXT, textValue);
		return (countElementNumber(driver, DataTablePageUI.DYNAMIC_ROW_TEXT, textValue) == 1
				&& isElementDisplayed(driver, DataTablePageUI.DYNAMIC_ROW_TEXT, textValue));
	}
	
	public boolean isOnlyOneRowDisplayed(String colName, String textValue) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_ROW_TEXT, colName,textValue);
		return (countElementNumber(driver, DataTablePageUI.DYNAMIC_ROW_TEXT, colName,textValue) == 1
				&& isElementDisplayed(driver, DataTablePageUI.DYNAMIC_ROW_TEXT, colName,textValue));
	}

	public void clickToDynamicRowByName(String rowCode) {
		waitForElementClickable(driver, DataTablePageUI.DYNAMIC_ROW_TEXT, rowCode);
		clickToElement(driver, DataTablePageUI.DYNAMIC_ROW_TEXT, rowCode);
		sleepInSeconds(1);
	}
	
	public String getNameFirstRow() {
		waitForElementVisible(driver, DataTablePageUI.FIRST_ROW_TEXT);
		return getElementText(driver, DataTablePageUI.FIRST_ROW_TEXT);
	}

}
