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
		waitForElementVisible(driver, DocumentTypePageUI.MENU_LINK);
		clickToElement(driver, DocumentTypePageUI.MENU_LINK);
	}

	public void clickToSubMenu() {
		waitForElementVisible(driver, DocumentTypePageUI.SUBMENU_LINK);
		clickToElement(driver, DocumentTypePageUI.SUBMENU_LINK);
	}

	public void clickToChildMenu() {
		waitForElementVisible(driver, DocumentTypePageUI.CHILDMENU_LINK);
		clickToElement(driver, DocumentTypePageUI.CHILDMENU_LINK);
	}
	
}
