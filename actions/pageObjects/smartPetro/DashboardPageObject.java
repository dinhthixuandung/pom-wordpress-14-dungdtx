package pageObjects.smartPetro;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.smartPetro.DashboardPageUI;
import pageUI.smartPetro.DocumentTypePageUI;
import pageUI.smartPetro.ToolbarAndMenuPageUI;

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
		waitForElementVisible(driver, ToolbarAndMenuPageUI.MENU_LINK, menu);
		clickToElement(driver, ToolbarAndMenuPageUI.MENU_LINK, menu);
	}

	public void clickToSubMenu(String subMenu) {
		waitForElementVisible(driver, ToolbarAndMenuPageUI.SUBMENU_LINK, subMenu);
		clickToElement(driver, ToolbarAndMenuPageUI.SUBMENU_LINK,subMenu);
	}

	public void clickToChildMenu(String childMenu) {
		waitForElementVisible(driver, ToolbarAndMenuPageUI.CHILDMENU_LINK, childMenu);
		clickToElement(driver, ToolbarAndMenuPageUI.CHILDMENU_LINK, childMenu);
		sleepInSeconds(3);
	}
	
}
