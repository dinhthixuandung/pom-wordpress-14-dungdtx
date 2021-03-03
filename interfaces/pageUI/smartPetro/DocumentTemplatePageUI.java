package pageUI.smartPetro;

public class DocumentTemplatePageUI {
	public static final String ADD_ROW_BUTTON = "//a/i[@class='ti-plus']";
	public static final String NAME_TEXTBOX = "//input[@id='Name']";
	public static final String DOCUMENT_NO_TEXTBOX = "//input[@id='DocumentNo']";
	public static final String FROM_VALUE_TEXTBOX = "//input[@id='FromValue']";
	public static final String TO_VALUE_TEXTBOX = "//input[@id='ToValue']";
	
	public static final String DISTRIBUTION_TABLE = "//tbody[@class='ui-table-tbody']";
	public static final String FROM_VALUE_TABLE = "//th[contains(text(),'Đến số')]/ancestor::table/tbody/tr/td/sub-form-control/div/input[@id='ToValue']";
	public static final String TO_VALUE_TABLE = "//th[contains(text(),'Từ số')]/ancestor::table/tbody/tr/td/sub-form-control/div/input[@id='FromValue']";
	public static final String DYNAMIC_DROPDOWNLIST_BY_ROW_AND_COLUMN_INDEX = "//tr[%s]/td[%s]//p-dropdown/div";
	public static final String DYNAMIC_ALL_CHILDREN_DROPDOWNLIST_BY_ROW_AND_COLUMN_INDEX = "//tr[%s]/td[%s]//p-dropdown/div/div/div/ul/li/div//div";
	public static final String DYNAMIC_COLUMN_POSITION_INDEX = "//th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "//tr[%s]/td[%s]//input";
}
