package commons;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.documentTemplate.documentTemplate_01_Add.Distribution;

public class AbstractPage {

	private Select select;
	private Actions action;
	private long longTime = 30;
	private WebElement element;
	private List<WebElement> elements;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	// WebElement dateWidget;
	List<WebElement> rows;
	List<WebElement> columns;
	List<String> listMonth = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December");

	// Calendar Month and Year.
	String calMonth = null;
	String calYear = null;
	boolean dateNotFound;

	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void senkeysAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public String getTextInAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void waitAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait;
		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allwindows = driver.getWindowHandles();
		for (String runWindow : allwindows) {
			driver.switchTo().window(runWindow);
			String currentWindowTitle = driver.getTitle();
			if (currentWindowTitle.equals(title)) {
				break;
			}
		}
	}

	public boolean areAllWindowCloseWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1) {
			return true;
		}
		return false;
	}

	public By byXPath(String locator) {
		return By.xpath(locator);
	}

//	public By byXPath(String locator, String... values) {
//		return By.xpath(locator);
//	}

	public WebElement findElementByXPath(WebDriver driver, String locator) {
		return driver.findElement(byXPath(locator));
	}

	public List<WebElement> findElementsByXPath(WebDriver driver, String locator) {
		return driver.findElements(byXPath(locator));
	}

	public List<WebElement> findElementsByXPath(WebDriver driver, String locator, String... values) {
		return driver.findElements(byXPath(castToObject(locator, values)));
	}

	public String castToObject(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		System.out.println(locator);
		return locator;
	}

	public void clearElement(WebDriver driver, String locator) {
		element = findElementByXPath(driver, locator);
		element.clear();

		element.sendKeys(" ");
		element.sendKeys(Keys.BACK_SPACE);
	}

	public void clickToElement(WebDriver driver, String locator) {
		findElementByXPath(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		findElementByXPath(driver, castToObject(locator, values)).click();
	}

	public void sendKeysToElement(WebDriver driver, String locator, String value) {
		element = findElementByXPath(driver, locator);
		element.clear();
		element.sendKeys(value);
	}

	public void sendKeysToElement(WebDriver driver, String locator, String value, String... values) {
		element = findElementByXPath(driver, castToObject(locator, values));
		element.clear();
		element.sendKeys(value);
	}

	public String getElementText(WebDriver driver, String locator) {
		return findElementByXPath(driver, locator).getText().trim();
	}

	public String getElementText(WebDriver driver, String locator, String... values) {
		return findElementByXPath(driver, castToObject(locator, values)).getText().trim();
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return findElementByXPath(driver, locator).getAttribute(attributeName);
	}

	public void selectValueInDropdown(WebDriver driver, String locator, String value) {
		select = new Select(findElementByXPath(driver, locator));
		select.selectByVisibleText(value);
	}

	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		select = new Select(findElementByXPath(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public void sleepInSeconds(long secondNumber) {
		try {
			Thread.sleep(secondNumber * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parenXPath, String allItemXPath,
			String expectedValueItem) {
		element = findElementByXPath(driver, parenXPath);
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
		sleepInSeconds(1);

		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXPath(allItemXPath)));

		elements = findElementsByXPath(driver, allItemXPath);

		for (WebElement childElement : elements) {
			if (childElement.getText().equals(expectedValueItem)) {
				if (childElement.isDisplayed()) {
					childElement.click();
				} else {
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
					sleepInSeconds(1);
					jsExecutor.executeScript("arguments[0].click();", childElement);
				}
				sleepInSeconds(1);
				break;
			}
		}

	}

	public void selectItemInCustomDropdown(WebDriver driver, String parenXPath, String allItemXPath,
			String expectedValueItem, String... values) {
		element = findElementByXPath(driver, castToObject(parenXPath, values));
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
		sleepInSeconds(1);

		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXPath(castToObject(allItemXPath, values))));

		elements = findElementsByXPath(driver, castToObject(allItemXPath, values));

		for (WebElement childElement : elements) {
			if (childElement.getText().equals(expectedValueItem)) {
				if (childElement.isDisplayed()) {
					childElement.click();
				} else {
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
					sleepInSeconds(1);
					jsExecutor.executeScript("arguments[0].click();", childElement);
				}
				sleepInSeconds(1);
				break;
			}
		}
	}

	public void selectItemsInMultiDropdown(WebDriver driver, String parenXPath, String allItemXPath,
			String[] distributions) {
		element = findElementByXPath(driver, parenXPath);
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
		sleepInSeconds(1);

		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXPath(allItemXPath)));

		elements = findElementsByXPath(driver, allItemXPath);
		for (String dis : distributions) {
			for (WebElement childElement : elements) {
				String a = childElement.getText();
				if (a.equals(dis)) {
					childElement.click();
					break;
				}

			}
		}
	}

	public void searchItemInCustomDropdown(WebDriver driver, String parenXPath, String searchResult, String searchXpath,
			String searchValue) {
		// element = findElementByXPath(driver, parenXPath);
//		jsExecutor = (JavascriptExecutor) driver;
//		jsExecutor.executeScript("arguments[0].click();", element);
//		element = findElementByXPath(driver, searchXpath);
//		jsExecutor.executeScript("arguments[0].setAttribute('value','abc')",element);

		clickToElementJS(driver, parenXPath);
		sendKeysToElement(driver, searchXpath, searchValue);
//		clickToElementJS(driver, searchXpath);
//		sendKeyToElementByJS(driver, searchXpath, searchValue);
		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXPath(searchResult)));

		elements = findElementsByXPath(driver, searchResult);

		// if(elements.size() != 1 ) {
		for (WebElement childElement : elements) {
			if (childElement.getText().equals(searchValue)) {
				if (childElement.isDisplayed()) {
					childElement.click();
				} else {
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
					sleepInSeconds(1);
					jsExecutor.executeScript("arguments[0].click();", childElement);
				}
				sleepInSeconds(1);
				break;
			}
		}
		// }
	}



	public void selectDateFromDatetimePicker(WebDriver driver, String datetimepickerXpath, String allDaysXpath,
			String monthXpath, String yearXpath, String prevXpath, String nextXpath, String expDate) {
		String dateStr[] = expDate.split("/");
		int expDay = Integer.parseInt(dateStr[0]);
		int expMonth = Integer.parseInt(dateStr[1]);
		int expYear = Integer.parseInt(dateStr[2]);

		// clickToElement(driver, datetimepickerXpath);

		// int monthActual = Integer.parseInt(findElementByXPath(driver,
		// monthXpath).getText());
		int yearActual = Integer.parseInt(findElementByXPath(driver, yearXpath).getText());

		while (yearActual < expYear) {
			findElementByXPath(driver, nextXpath).click();
			yearActual = Integer.parseInt(findElementByXPath(driver, yearXpath).getText());
		}

		while (yearActual > expYear) {
			findElementByXPath(driver, prevXpath).click();
			yearActual = Integer.parseInt(findElementByXPath(driver, yearXpath).getText());
		}

		
		int  month = Integer.parseInt(changeMonthToNumber(driver, monthXpath));
		// while (!expMonth.equals(month)) {
		while (expMonth != month) {
			findElementByXPath(driver, nextXpath).click();
			month = Integer.parseInt(changeMonthToNumber(driver, monthXpath));
			//month = Integer.parseInt(findElementByXPath(driver, monthXpath).getText());
		}

		List<WebElement> days = findElementsByXPath(driver, allDaysXpath);
		int count = days.size();

		for (int i = 0; i < count; i++) {
			int day = Integer.parseInt(findElementsByXPath(driver, allDaysXpath).get(i).getText());
			//if (text.equalsIgnoreCase(expDay)) {
			if(expDay == day) {
				findElementsByXPath(driver, allDaysXpath).get(i).click();
				break;
			}
		}
	}

	public String changeMonthToNumber(WebDriver driver, String monthXpath) {
		String month = findElementByXPath(driver, monthXpath).getText();

		switch (month) {
		case "January":
			return "01";
		case "February":
			return "02";
		case "March":
			return "03";
		case "April":
			return "04";
		case "May":
			return "05";
		case "June":
			return "06";
		case "July":
			return "07";
		case "August":
			return "08";
		case "September":
			return "09";
		case "October":
			return "10";
		case "November":
			return "11";
		case "December":
			return "12";
		default:
			return "0";
		}
	}
	
	public void selectItemFromTreeview(WebDriver driver, String arrowXpath, String parentXpath, String childXpath, String vehicleXpath, String parent, String[] children) {
		if (isElementDisplayed(driver, arrowXpath, parent) == true) {
			clickToElement(driver, arrowXpath, parent);
			elements = findElementsByXPath(driver, childXpath, parent);

			if (elements.size() > 0) {
				for (String child : children) {
					for (WebElement element : elements) {
						String stemp = element.getText();
						if (stemp.equals(child)) {
							clickToElement(driver, vehicleXpath, parent, child);
							break;
						}
					}
				}
			}
		}else{
			clickToElement(driver, parentXpath, parent);
		}
	}
	
	public void addRowsIntoSubTable(WebDriver driver, String locator, Distribution[] rows) {
		
		for(int i = 1; i <= rows.length; i++) {
			clickToElement(driver, locator);
		}
	}
		
	public int countElementNumber(WebDriver driver, String locator) {
		elements = findElementsByXPath(driver, locator);
		return elements.size();
	}

	public int countElementNumber(WebDriver driver, String locator, String... values) {
		elements = findElementsByXPath(driver, castToObject(locator, values));
		return elements.size();
	}

	public void checkToCheckbox(WebDriver driver, String locator) {
		element = findElementByXPath(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		element = findElementByXPath(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return findElementByXPath(driver, locator).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return findElementByXPath(driver, castToObject(locator, values)).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return findElementByXPath(driver, locator).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return findElementByXPath(driver, locator).isEnabled();
	}

	public void switchToFrameOrIframe(WebDriver driver, String locator) {
		element = findElementByXPath(driver, locator);
		driver.switchTo().frame(element);
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMoveToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(findElementByXPath(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(findElementByXPath(driver, locator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(findElementByXPath(driver, locator)).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(findElementByXPath(driver, locator), key).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key, String... values) {
		action = new Actions(driver);
		action.sendKeys(findElementByXPath(driver, castToObject(locator, values)), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String expectedText) {
		jsExecutor = (JavascriptExecutor) driver;
		String actualText = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + expectedText + "')[0]");
		return actualText.equals(expectedText);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElementByXPath(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style",
				"border:5px solid red; border-style:dashed");
		sleepInSeconds(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", findElementByXPath(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true)", findElementByXPath(driver, locator));
	}

	public void sendKeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value','" + value + "')",
				findElementByXPath(driver, locator));
	}

	public void removeAttributeInDom(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('value','" + attributeRemove + "');",
				findElementByXPath(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor
				.executeScript(
						"return arguments[0].compalete && typeof arguments[0]"
								+ ".naturalWidth !='undefined' && arguments[0]" + ".naturalWidth > 0",
						findElementByXPath(driver, locator));

		if (status) {
			return true;
		}
		return false;
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXPath(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXPath(castToObject(locator, values))));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXPath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXPath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXPath(castToObject(locator, values))));
	}

}
