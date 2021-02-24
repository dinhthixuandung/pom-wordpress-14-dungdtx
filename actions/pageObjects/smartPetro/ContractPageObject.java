package pageObjects.smartPetro;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.smartPetro.ContractPageUI;
import pageUI.smartPetro.OtherGoodsPageUI;
import pageUI.smartPetro.ToolbarAndMenuPageUI;

public class ContractPageObject extends AbstractPage {
	WebDriver driver;

	public ContractPageObject(WebDriver mapDriver) {

		driver = mapDriver;
	}

	public void clickToAddButton() {
		sleepInSeconds(3);
		waitForElementClickable(driver, ToolbarAndMenuPageUI.ADD_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.ADD_BUTTON);
		sleepInSeconds(1);
	}
	
	public void clickToSaveButton() {
		sleepInSeconds(3);
		waitForElementClickable(driver, ToolbarAndMenuPageUI.SAVE_BUTTON);
		clickToElement(driver, ToolbarAndMenuPageUI.SAVE_BUTTON);
		sleepInSeconds(1);
	}

	public void selectPolicyDate(String expDate) {
		waitForElementClickable(driver, ContractPageUI.POLICYDATE_DATETIMEPICKER);
		clickToElement(driver, ContractPageUI.POLICYDATE_DATETIMEPICKER);
		sleepInSeconds(1);
		selectDateFromDatetimePicker(driver, ContractPageUI.POLICYDATE_DATETIMEPICKER,
				ContractPageUI.ALL_DATE_DATETIMEPICKER, ContractPageUI.MONTH_TEXT, ContractPageUI.YEAR_TEXT,
				ContractPageUI.PRE_HREF, ContractPageUI.NEXT_HREF, expDate);
		
	}

	public void inputIntoPolicyCodeTextbox(String value) {
		waitForElementVisible(driver, ContractPageUI.POLICY_CODE_TEXTBOX);
		sendKeysToElement(driver, ContractPageUI.POLICY_CODE_TEXTBOX, value);
		sleepInSeconds(1);
	}
	
	public void inputIntoCreditLimitTextbox(String value) {
		waitForElementVisible(driver, ContractPageUI.CREDIT_LIMIT_TEXTBOX);
		sendKeysToElement(driver, ContractPageUI.CREDIT_LIMIT_TEXTBOX, value);
	}
	
	public void inputIntoDueCycleTextbox(String value) {
		scrollToElement(driver, ContractPageUI.DUE_CYCLCE_TEXTBOX);
		sleepInSeconds(3);
		sendKeysToElement(driver, ContractPageUI.DUE_CYCLCE_TEXTBOX, value);
		sleepInSeconds(1);
	}
	
	public void inputIntoDayPastDueTextbox(String value) {
		waitForElementVisible(driver, ContractPageUI.DAY_PAST_DUE_TEXTBOX);
		sendKeysToElement(driver, ContractPageUI.DAY_PAST_DUE_TEXTBOX, value);
		sleepInSeconds(1);
	}
	
	public void inputIntoCreditLimitVehicleTextbox(String value) {
		sendKeysToElement(driver, ContractPageUI.CREDIT_LIMIT_VEHICLE_TEXTBOX, value);
		sleepInSeconds(1);
	}

	public void selectFromDate(String today) {
		
	}

	public void selectToDate(String date) {
		waitForElementClickable(driver, ContractPageUI.ENDDATE_DATETIMEPICKER);
		clickToElement(driver, ContractPageUI.ENDDATE_DATETIMEPICKER);
		sleepInSeconds(1);
		selectDateFromDatetimePicker(driver, ContractPageUI.ENDDATE_DATETIMEPICKER,
				ContractPageUI.ALL_ENDDATE_DATETIMEPICKER, ContractPageUI.MONTH_TEXT, ContractPageUI.YEAR_TEXT,
				ContractPageUI.PRE_HREF, ContractPageUI.NEXT_HREF, date);
	}

	public void selectVehicleTreeview(String parent, String[] children) {
		waitForElementClickable(driver, ContractPageUI.PARENT_TREEVIEW, parent);
		selectVehicleFromTreeview(driver, ContractPageUI.ARROW_TREEVIEW, ContractPageUI.PARENT_TREEVIEW, ContractPageUI.CHILDREN_TREEVIEW, ContractPageUI.A_CHILD_CHECKBOX, parent, children);
		
	}
	
}
