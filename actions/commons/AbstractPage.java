package commons;

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

public class AbstractPage {

	private Select select;
	private Actions action;
	private long longTime=30;
	private WebElement element;
	private List<WebElement> elements;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
		
	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
	}
	
	public String getPageTitle (WebDriver driver) {
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
		for(String runWindow:allWindows) {
			if(!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allwindows = driver.getWindowHandles();
		for(String runWindow: allwindows) {
			driver.switchTo().window(runWindow);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.equals(title)) {
				break;
			}
		}
	}	
	
	public boolean areAllWindowCloseWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String runWindow: allWindows) {
			if(!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if(driver.getWindowHandles().size()==1) {
			return true;
		}
		return false;
	}
	
	public By byXPath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement findElementByXPath(WebDriver driver, String locator) {
		return driver.findElement(byXPath(locator));
	}
	
	public List<WebElement> findElementsByXPath(WebDriver driver, String locator) {
		return driver.findElements(byXPath(locator));
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		findElementByXPath(driver, locator).click();
	}
	
	public void senKeysToElement(WebDriver driver, String locator, String value) {
		element = findElementByXPath(driver, locator);
		element.clear();
		element.sendKeys(value);
	}
	
	public String getElementText(WebDriver driver, String locator) {
		return findElementByXPath(driver, locator).getText().trim();
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
			Thread.sleep(secondNumber*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parenXPath, String allItemXPath, String expectedValueItem) {
		element = findElementByXPath(driver, parenXPath);
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
		sleepInSeconds(1);
		
		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXPath(allItemXPath)));
		
		elements = findElementsByXPath(driver, allItemXPath);
		
		for(WebElement childElement:elements) {
			if(childElement.getText().equals(expectedValueItem)) {
				if(childElement.isDisplayed()) {
					childElement.click();
				}else {
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
					sleepInSeconds(1);
					jsExecutor.executeScript("arguments[0].click();", childElement);
				}
				sleepInSeconds(1);
				break;
			}
		}
		
		
		
		
	}
	
	public int countElementNumber(WebDriver driver, String locator) {
		elements = findElementsByXPath(driver, locator);
		return elements.size();
	}
	
	public void checkToCheckbox(WebDriver driver, String locator) {
		element = findElementByXPath(driver, locator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver, String locator) {
		element = findElementByXPath(driver, locator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return findElementByXPath(driver, locator).isDisplayed();
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
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}
	
	public boolean verifyTextInInnerText(WebDriver driver, String expectedText) {
		jsExecutor = (JavascriptExecutor) driver;
		String actualText = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + expectedText + "')[0]");
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
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element,"style", 
				"border:5px solid red; border-style:dashed");
		sleepInSeconds(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element,"style",originalStyle);
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
		jsExecutor.executeScript("arguments[0].setAttribute('value','"+value+"')",findElementByXPath(driver, locator));
	}
	
	public void removeAttributeInDom(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('value','"+attributeRemove+"');",findElementByXPath(driver, locator));
	}
	
	public boolean isImageLoaded(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].compalete && typeof arguments[0]" 
															+ ".naturalWidth !='undefined' && arguments[0]"
															+ ".naturalWidth > 0", findElementByXPath(driver, locator));
		
		if(status) {
			return true;
		}	
		return false;		
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXPath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXPath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXPath(locator)));
	}
	
}
