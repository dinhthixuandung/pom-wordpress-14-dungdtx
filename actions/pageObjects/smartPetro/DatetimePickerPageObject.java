package pageObjects.smartPetro;

import commons.AbstractPage;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatetimePickerPageObject extends AbstractPage{

	WebDriver driver;
	WebElement dateWidget;
	List<WebElement> rows;
	List<WebElement> columns;
	List<String> list = Arrays.asList("January", "February", "March", "April",
			"May", "June", "July", "August", "September", "October",
			"November", "December");

	int expMonth;
	int expYear;
	String expDate = null;
	
	// Calendar Month and Year.
	String calMonth = null;
	String calYear = null;
	boolean dateNotFound;
	
	
	public DatetimePickerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
}
