package pageUI.smartPetro;

public class DataTablePageUI {
	public static final String DYNAMIC_HEADER_COLUMN_TEXT = "//span[text()='%s']/following-sibling::input";
	//public static final String DYNAMIC_ROW_TEXT = "//td[@class='ng-star-inserted']/span[text()='Tên loại chứng từ']/following-sibling::span[contains(string(),'%s')]";
	public static final String DYNAMIC_ROW_TEXT = "//span[text()='%s']/following-sibling::span[contains(string(),'%s')]";
	public static final String FIRST_ROW_TEXT = "//div[@class='ui-datatable-scrollable-body']/div/table/tbody/tr/td/span/following-sibling::span";
	//span[text()='Mã SP']/ancestor::table/parent::div/parent::div/following-sibling::div/div/table/tbody/tr/td/span
}
