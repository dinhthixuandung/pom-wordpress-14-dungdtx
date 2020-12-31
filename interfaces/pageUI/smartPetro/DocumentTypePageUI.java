package pageUI.smartPetro;

public class DocumentTypePageUI {
	public static final String DOCUMENTTYPE_MENU = "//a[@class='ng-star-inserted']/p[contains(text(),'HỆ THỐNG')]"; 
	public static final String DOCUMENTTYPE_SUBMENU = "//a[@class='ng-star-inserted']/p[contains(text(),'D.MỤC CHỨNG TỪ')]" ;
	public static final String DOCUMENTTYPE_CHILDMENU = "//span[contains(text(),'Loại chứng từ')]" ;
	public static final String ADD_BUTTON = "//i[@class='ti-plus']"; 
	public static final String DEL_BUTTON = "//i[@class='ti-minus']"; 
	public static final String EDIT_BUTTON = "//i[@class='ti-pencil']"; 
	public static final String REFRESH_BUTTON = "//i[@class='ti-reload']";
	
	public static final String DOCUMENTNAME_TEXTBOX = "//input[@id='Name']";
	public static final String OTHERNAME_TEXTBOX = "//input[@id='OtherName']";
	public static final String DESCRIPTION_TEXTBOX = "//input[@id='Description']";
	
	public static final String SAVE_BUTTON = "//button[text()='Lưu']";
	public static final String CLOSE_BUTTON = "//button[text()=' Đóng']";
	public static final String ACCEPT_BUTTON = "//button[text()='Chấp nhận']";
	public static final String OK_BUTTON = "//button[text()='OK']";
	public static final String ERROR_MESSAGE_TEXT = "//small[@class='col-sm-10 text-danger ng-star-inserted']";
	public static final String ALERT_BUTTON = "//div[@class='swal2-modal swal2-show']";
	public static final String ALERT_TEXT = "//h2[@class='swal2-title']";
}
