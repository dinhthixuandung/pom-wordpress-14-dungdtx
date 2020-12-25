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

	public boolean isOnlyOneRowDisplayed(String editName) {
		// TODO Auto-generated method stub
		return false;
	}


	
	
}
