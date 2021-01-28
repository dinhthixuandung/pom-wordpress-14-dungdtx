package pageUI.smartPetro;

public class ToolbarAndMenuPageUI {
	//TOOLBAR
	public static final String ADD_BUTTON = "//i[@class='ti-plus']"; 
	public static final String DEL_BUTTON = "//i[@class='ti-minus']"; 
	public static final String EDIT_BUTTON = "//i[@class='ti-pencil']"; 
	public static final String REFRESH_BUTTON = "//i[@class='ti-reload']";
	
	//MENU
	public static final String MENU_LINK = "//div[contains(@class,'sidebar-wrapper')]/ul/li/a/p[contains(text(),'%s')]"; 
	public static final String SUBMENU_LINK = "//a[@class='ng-star-inserted']/p[contains(text(),'%s')]" ;
	//public static final String SUBMENU_LINK = "//div[contains(@class,'sidebar-wrapper')]/ul/li/a/p[contains(text(),'BÁN HÀNG')]/parent::a/following-sibling::div/ul/li/a/span[contains(text(),'Chính sách công nợ')]";
	//public static final String SUBMENU_LINK = "//span[contains(text(),'%s')]";
	
	public static final String CHILDMENU_LINK = "//span[contains(text(),'%s')]" ;
	
	//DETAIL BUTTON
	public static final String SAVE_BUTTON = "//button[text()='Lưu']";
	public static final String CLOSE_BUTTON = "//button[text()=' Đóng']";
	public static final String ACCEPT_BUTTON = "//button[text()='Chấp nhận']";
	public static final String OK_BUTTON = "//button[text()='OK']";
	
	//ALERT
	public static final String ERR_MESSAGE = "//label[contains(text(),'%s')]/parent::div/following-sibling::div/small";
	public static final String ALERT_BUTTON = "//div[@class='swal2-modal swal2-show']";
	public static final String ALERT_TEXT = "//h2[@class='swal2-title']";
}
