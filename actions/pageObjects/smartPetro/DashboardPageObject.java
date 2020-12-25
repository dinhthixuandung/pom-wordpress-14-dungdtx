package pageObjects.smartPetro;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.smartPetro.DashboardPageUI;
import pageUI.smartPetro.DocumentTypePageUI;

public class DashboardPageObject extends AbstractPage{
	WebDriver driver;
	
	public DashboardPageObject(WebDriver mapDriver) {
		driver = mapDriver;
	}

	public boolean isDisplayedHeader() {
		waitForElementVisible(driver, DashboardPageUI.HEADER_MANAGEMENT_TEXT);
		return isElementDisplayed(driver, DashboardPageUI.HEADER_MANAGEMENT_TEXT);
	}

	public void clickToMenu() {
		waitForElementVisible(driver, DocumentTypePageUI.DOCUMENTTYPE_MENU);
		clickToElement(driver, DocumentTypePageUI.DOCUMENTTYPE_MENU);
	}

	public void clickToSubMenu() {
		waitForElementVisible(driver, DocumentTypePageUI.DOCUMENTTYPE_SUBMENU);
		clickToElement(driver, DocumentTypePageUI.DOCUMENTTYPE_SUBMENU);
	}

	public void clickToChildMenu() {
		waitForElementVisible(driver, DocumentTypePageUI.DOCUMENTTYPE_CHILDMENU);
		clickToElement(driver, DocumentTypePageUI.DOCUMENTTYPE_CHILDMENU);
	}
	
}
