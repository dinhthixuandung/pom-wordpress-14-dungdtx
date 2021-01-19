package pageUI.smartPetro;

public class OtherGoodsPageUI {
	public static final String MENU_LINK = "//a[@class='ng-star-inserted']/p[contains(text(),'HỆ THỐNG')]"; 
	public static final String SUBMENU_LINK = "//a[@class='ng-star-inserted']/p[contains(text(),'D.MỤC HÀNG HÓA')]" ;
	public static final String CHILDMENU_LINK = "//span[contains(text(),'Hàng hóa khác')]" ;
	public static final String ADD_BUTTON = "//i[@class='ti-plus']"; 
	public static final String DEL_BUTTON = "//i[@class='ti-minus']"; 
	public static final String EDIT_BUTTON = "//i[@class='ti-pencil']"; 
	public static final String REFRESH_BUTTON = "//i[@class='ti-reload']";
	
	public static final String CODE_TEXTBOX = "//input[@id='Code']";
	public static final String NAME_TEXTBOX = "//input[@id='Name']";
	public static final String UNIT_SEARCH_DROPDOWNLIST = "//p-dropdown[@id='UnitCode']/div/div/div/input";
	public static final String UNIT_DROPDOWNLIST = "//p-dropdown[@id='UnitCode']/div";
	public static final String ALL_UNIT_DROPDOWNLIST = "//p-dropdown[@id='UnitCode']/div/div/div/ul/li/div//div";

	public static final String PRICE_TEXTBOX = "//input[@id='Price']";
	public static final String DISTRIBUTE_MULTISELECTLIST = "//p-multiselect[@id='ProductInCompanies']/div";
	public static final String ALL_DISTRIBUTE_MULTISELECTLIST = "//p-multiselect[@id='ProductInCompanies']/div/div/div/ul/li/label";
	
	public static final String STATUS_CHECKBOX = "//p-checkbox[@class='ng-valid ng-star-inserted ng-dirty ng-touched']";
	public static final String DESCRIPTION_AREA = "//input[@id='Description']";
	
	public static final String SAVE_BUTTON = "//button[text()='Lưu']";
	public static final String CLOSE_BUTTON = "//button[text()=' Đóng']";
	public static final String ACCEPT_BUTTON = "//button[text()='Chấp nhận']";
	public static final String OK_BUTTON = "//button[text()='OK']";
	public static final String ERROR_MESSAGE_TEXT = "//div[@class='col-sm-4']/small";
	public static final String ALERT_BUTTON = "//div[@class='swal2-modal swal2-show']";
	public static final String ALERT_TEXT = "//h2[@class='swal2-title']";
}
