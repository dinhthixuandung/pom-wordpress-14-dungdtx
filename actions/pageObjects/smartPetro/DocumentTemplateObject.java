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

	public void addNewRows(Distribution[] rows) {
		sleepInSeconds(3);
		waitForElementClickable(driver, DocumentTemplatePageUI.ADD_ROW_BUTTON);
		addRowsIntoSubTable(driver, DocumentTemplatePageUI.ADD_ROW_BUTTON, rows);
		inputDataIntoRows();
		sleepInSeconds(1);
	}
	
	public void selectUnit(String expectedUnit) {
		
		waitForElementVisible(driver, pageUI.smartPetro.DocumentTemplatePageUI.COMPANY_DROPDOWNLIST);
		selectItemInCustomDropdown(driver, pageUI.smartPetro.DocumentTemplatePageUI.COMPANY_DROPDOWNLIST, pageUI.smartPetro.DocumentTemplatePageUI.ALL_CHILDREN_COMPANY_DROPDOWNLIST, expectedUnit);
		sleepInSeconds(1);
	
	}
}
