package pageUI.smartPetro;

public class ContractPageUI {
	public static final String POLICYDATE_DATETIMEPICKER = "//p-calendar[@formcontrolname='PolicyDate']/span/button/span[contains(@class,'ui-button-icon-left')]";
	
	public static final String ALL_DATE_DATETIMEPICKER = "//p-calendar[@formcontrolname='PolicyDate']/span/div/table/tbody/tr/td/a";
	
	public static final String MONTH_TEXT = "//div[@class='ui-datepicker-title']/span[contains(@class,'ui-datepicker-month')]";
	
	public static final String YEAR_TEXT = "//div[@class='ui-datepicker-title']/span[contains(@class,'ui-datepicker-year')]";
	
	public static final String PRE_HREF = "//p-calendar[@formcontrolname='PolicyDate']/span/div/div/a[contains(@class,'ui-datepicker-prev')]";
	
	//public static final String NEXT_HREF = "//p-calendar[@formcontrolname='PolicyDate']/span/div/div/a[contains(@class,'ui-datepicker-next')]";
	
	public static final String NEXT_HREF = "//p-calendar/span/div/div/a[contains(@class,'ui-datepicker-next')]";
	
	public static final String POLICY_CODE_TEXTBOX = "//input[@formcontrolname='PolicyCode']";
	
	public static final String ENDDATE_DATETIMEPICKER = "//p-calendar[@formcontrolname='EndDate']/span/button/span[contains(@class,'ui-button-icon-left')]";
	
	public static final String ALL_ENDDATE_DATETIMEPICKER = "//p-calendar[@formcontrolname='EndDate']/span/div/table/tbody/tr/td/a";
	
	public static final String PARENT_TREEVIEW = "//tbody/div/td/span[text()='%s']";
	
	public static final String CHILDREN_TREEVIEW = "//tbody/div/td/span[text()='%s']/parent::td/parent::div/following-sibling::div/td/table/tbody"; 
	
	public static final String A_CHILD_CHECKBOX = "//tbody/div/td/span[text()='%s']/parent::td/parent::div/following-sibling::div/td/table/tbody/div/td/span[text()='%s']";
	
	public static final String ARROW_TREEVIEW = "//tbody/div/td/span[text()='%s']/parent::td/a";
	
	public static final String CREDIT_LIMIT_TEXTBOX = "//input[@formcontrolname='CreditLimit']";
	
	public static final String DUE_CYCLCE_TEXTBOX = "//p[text()='Tháng']/parent::div/input";
	
	public static final String DAY_PAST_DUE_TEXTBOX = "//input[@formcontrolname='DayPastDue']";
	
	public static final String CREDIT_LIMIT_VEHICLE_TEXTBOX = "//input[@formcontrolname='CreditLimitVehicle']";
	
	
}
