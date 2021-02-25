package pageUI.smartPetro;

public class DocumentTemplatePageUI {
	public static final String ADD_ROW_BUTTON = "//a/i[@class='ti-plus']";
	public static final String NAME_TEXTBOX = "//input[@id='Name']";
	public static final String DOCUMENT_NO_TEXTBOX = "//input[@id='DocumentNo']";
	public static final String FROM_VALUE_TEXTBOX = "//input[@id='FromValue']";
	public static final String TO_VALUE_TEXTBOX = "//input[@id='ToValue']";
	//public static final String COMPANY_DROPDOWNLIST = "//p-dropdown[@id='CompanyInDocumentTemplate']/div";
	public static final String ALL_CHILDREN_UNIT_DROPDOWNLIST = "//th[contains(text(),'Đơn vị')]/ancestor::table/tbody/tr/td/sub-form-control/div/p-dropdown[@id='CompanyInDocumentTemplate']/div/div/div/ul/li/div/div";
	
	public static final String DISTRIBUTION_TABLE = "//tbody[@class='ui-table-tbody']";
	public static final String FROMVALUE_TEXT = "//th[contains(text(),'Đến số')]/ancestor::table/tbody/tr/td/sub-form-control/div/input[@id='ToValue']";
	public static final String TOVALUE_TEXT = "//th[contains(text(),'Từ số')]/ancestor::table/tbody/tr/td/sub-form-control/div/input[@id='FromValue']";
	public static final String UNIT_DROPDOWNLIST = "//th[contains(text(),'Đơn vị')]/ancestor::table/tbody/tr/td/sub-form-control/div/p-dropdown[@id='CompanyInDocumentTemplate']";
	
}
