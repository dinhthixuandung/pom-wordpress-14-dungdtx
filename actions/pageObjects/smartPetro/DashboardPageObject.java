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

	public void clickToMenu(String menu) {
		waitForElementVisible(driver, DocumentTypePageUI.MENU_LINK, menu);
		clickToElement(driver, DocumentTypePageUI.MENU_LINK, menu);
	}

	public void clickToSubMenu(String subMenu) {
		waitForElementVisible(driver, DocumentTypePageUI.SUBMENU_LINK, subMenu);
		clickToElement(driver, DocumentTypePageUI.SUBMENU_LINK,subMenu);
	}

	public void clickToChildMenu(String childMenu) {
		waitForElementVisible(driver, DocumentTypePageUI.CHILDMENU_LINK, childMenu);
		clickToElement(driver, DocumentTypePageUI.CHILDMENU_LINK, childMenu);
	}
	
}
