package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.bankGuru.HomePageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;

	public HomePageObject(WebDriver mapDriver) {
		driver = mapDriver;
	}

	public boolean isWelcomMessageDisplayed() {
		waitForElementVisible(driver, HomePageUI.WELCOME_MASSAGE_TEXT);
		return isElementDisplayed(driver, HomePageUI.WELCOME_MASSAGE_TEXT);
	}
}
 