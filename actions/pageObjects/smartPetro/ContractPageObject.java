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

	public void selectDateFromCalendar(String expDate) {
		waitForElementClickable(driver, ContractPageUI.POLICYDATE_DATETIMEPICKER);
		clickToElement(driver, ContractPageUI.POLICYDATE_DATETIMEPICKER);
		sleepInSeconds(1);
		selectDateFromDatetimePicker(driver, ContractPageUI.POLICYDATE_DATETIMEPICKER,
				ContractPageUI.ALL_DATE_DATETIMEPICKER, ContractPageUI.MONTH_TEXT, ContractPageUI.YEAR_TEXT,
				ContractPageUI.PRE_HREF, ContractPageUI.NEXT_HREF, expDate);
		// WebDriver driver, String datetimepickerXpath, String allDaysXpath, String
		// monthXpath, String buttonNextXpath, String expDate
	}

}
