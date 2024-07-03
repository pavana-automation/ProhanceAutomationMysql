package net.pages_worktimemodule;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class UsersPage {
	WebDriver driver;

	@FindBy(xpath = "//li/a[contains(text(),\"Users\")]")
	WebElement UsersBtn;

	@FindBy(xpath = "//ul[@id =\"level2_109\"]/li[contains(text(),\"Users\")]")
	WebElement Users;

	@FindBy(xpath = "//label[contains(text(),\"ADD NEW\")]")
	WebElement AddNewBtn;

	@FindBy(id = "userRoleStr")
	WebElement role;

	@FindBy(id = "probeLoginId")
	WebElement loginId;

	@FindBy(id = "webLoginId")
	WebElement loginIdCon;

	@FindBy(id = "webAuthType_NATIVE")
	WebElement consoleAuth;

	@FindBy(xpath = "//input[@id =\"webPassword\"]")
	WebElement password;

	@FindBy(xpath = "//input[@id =\"webConfirmPassword\"]")
	WebElement confirmpassword;

	@FindBy(xpath = "//input[@id =\"firstName\"]")
	WebElement firstName;

	@FindBy(id = "timeZoneId")
	WebElement timezone;

	@FindBy(xpath = "//button[contains(text(),\"SAVE\")]")
	WebElement savebtn;

	@FindBy(xpath = "//table[@id =\"tab_table\"]/tbody/tr[2]/td/span[2]")
	WebElement teamMapping;

	@FindBy(xpath = "(//input[@type='button'])[3]")
	WebElement addTeamsBtn;

	@FindBy(xpath = "(//input[@name='userGroupSelectCheckbox'])[1]")
	WebElement selectSuperGrp;

	@FindBy(xpath = "//button[contains(text(),'ADD')]")
	WebElement addBtn;

	@FindBy(xpath = "//li/label[contains(text(),\"BACK\")]")
	WebElement backBtn;

	@FindBy(id = "inactivateUser_Y")
	WebElement inactive;

	@FindBy(id = "userTypeId")
	WebElement userType;

	@FindBy(xpath = "//a[contains(text(),\"Aishwarya1\")]")
	WebElement modifyBtn;

	@FindBy(linkText = "×")
	WebElement closeAggregationPopUp;

	@FindBy(xpath = "//td[contains(text(),\"Team Member\")]/../td[1]/a[2]/i")
	WebElement deleteBtn;

	@FindBy(xpath = "//button[contains(text(),'YES')]")
	WebElement yesBtn;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement okBtn;

	@FindBy(xpath = "//span/span[contains(text(),\"Click here\")]")
	WebElement clickHereBtn;

	@FindBy(xpath = "//a[contains(text(),\"aishwarya-dependency\")]/../../td[1]/a[2]/i")
	WebElement monitorimgBtn;
	
	@FindBy(xpath = "//td[contains(text(),\"Aishwarya12@JAMOCHAlOCAL [NATIVE]\")]/../td[1]/a[1]/i")
	WebElement modify;
	
	@FindBy(xpath = "//td[contains(text(),\"Aishwarya12@JAMOCHAlOCAL [NATIVE]\")]/../td[1]/a[2]/i")
	WebElement delete;
	
	@FindBy(xpath = "//a[contains(text(),\"aishwarya-dependency\")]/../../td[1]/a[2]/i")
	WebElement monitorimgBtn1;

	@FindBy(xpath = "//table[@id='CommonDataTableId']/tbody/tr/td[7][not(img)]/../td[1]/a[2]/i")
	WebElement monitorBtn;

	@FindBy(xpath = "//label[contains(text(),\"MORE ACTION\")]")
	WebElement moreActionBtn;

	@FindBy(xpath = "//li/a[contains(text(),\"USER ATTRIBUTES\")]")
	WebElement userAttributes;

	@FindBy(xpath = "//li/a[contains(text(),\"BULK UPLOAD\")]")
	WebElement bulkUpload;

	@FindBy(xpath = "//li/a[contains(text(),\"USER ATTRIBUTES\")]")
	WebElement userAttribute;

	@FindBy(xpath = "//li/a[contains(text(),\"LICENSE REPORT\")]")
	WebElement licencereport;

	@FindBy(xpath = "//li/a[contains(text(),\"SHOW LOGGED IN USERS\")]")
	WebElement loggedUsers;

	@FindBy(xpath = "//span[contains(text(),\" Click here\")]")
	WebElement clickHere;

	@FindBy(id = "userType")
	WebElement template;

	@FindBy(xpath = "//table[@id='userUploadTable']/tbody/tr[1]/td/div/span[2]/span/span/input[@id ='userXLUpload']")
	WebElement chooseFileBtn;

	@FindBy(id = "userUploadButton")
	WebElement upload;

	@FindBy(id = "userCondition")
	WebElement condition;

	@FindBy(xpath = "//li/a[contains(text(),\"DEFINE TENURE RANGE\")]")
	WebElement defineTenure;

	@FindBy(id = "userStatusCondition")
	WebElement userStatus;

	@FindBy(id = "reportUnit")
	WebElement tenureMes;

	@FindBy(xpath = "//div[@id=\"edit\"]/table/tbody/tr[1]/td[2]/div/span/input[@id=\"fromRange\"]")
	WebElement rangeFrom;

	@FindBy(xpath = "//div[@id=\"edit\"]/table/tbody/tr[1]/td[4]/div/input")
	WebElement rangeTo;

	@FindBy(xpath = "//div[@id=\"edit\"]/table/tbody/tr[1]/td[5]/input")
	WebElement tenureAddBtn;

	@FindBy(xpath = "//tr[@id =\"row_1\"]/td/i")
	WebElement deletetenure;

	@FindBy(xpath = "//div[@id =\"editTenureDialog\"]/div/div/div[3]/div/span[2]/input")
	WebElement tenureSavebtn;

	@FindBy(xpath = "//img[@src='/prohance/images/dialog-close.png']")
	WebElement deleteicon;

	@FindBy(id = "associateUserReportLevel")
	WebElement selectTeams;

	@FindBy(xpath = "//table[@id ='CommonDataTableId']/tbody/tr[1]/td[4]/span")
	WebElement successMsg;

	@FindBy(xpath = "//div[@class =\"row message-area\"]/div[4]/span")
	WebElement failMsg;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr[10]/td[7]/span/i")
	WebElement inactiveAttribute;

	@FindBy(xpath = "//li[@id =\"workTimeLi\"]/a[contains(text(),\"WORK TIME\")]")
	WebElement workTime;

	@FindBy(xpath = "//li[@id =\"menuitem_96\"]/a[contains(text(),\"ATTENDANCE\")]")
	WebElement attendance;

	@FindBy(xpath = "//img[@id =\"dropDownFilterAttendence\"]")
	WebElement filter;

	@FindBy(xpath = "//img[@src=\"images/popup_icon.gif\"]")
	WebElement userImg;

	@FindBy(xpath = "//img[@src=\"/prohance/images/email.png\"]")
	WebElement email;

	@FindBy(xpath = "//div[@class=\"slimScrollDiv\"]/div/table/tbody/tr")
	List<WebElement> getUserArrtribute;

	@FindBy(xpath = "//label[contains(text(),\"User Type\")]")
	WebElement endOfUserAtt;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr[10]/td[3]/div")
	WebElement getRole;

	@FindBy(xpath = "//table[@id=\"licenseVoList\"]/tbody/tr/td[1]")
	List<WebElement> licenceList;

	@FindBy(xpath = "//img[@src=\"/prohance/images/excel.png\"]")
	WebElement licenceExcelImg;

	@FindBy(xpath = "//img[@src=\"/prohance/images/pdf.png\"]")
	WebElement licenceEPdfImg;

	@FindBy(xpath = "//div[@id =\"navBarFilterLinks\"]/label[2]")
	WebElement dashboardVies;

	@FindBy(xpath = "//div[@id=\"dashboardContainer1\"]/div/div/div/div/span")
	WebElement clientFilter;

	@FindBy(id = "reportType1")
	WebElement reportBy;

	@FindBy(xpath = "//td[@id=\"filterFormbuttons_container_1\"]/span[2]")
	WebElement Fetch;

	@FindBy(xpath = "//div[@id=\"dashboardContainer1\"]/div/div[2]/div/div/table/tbody/tr[1]/td[2]/span")
	WebElement count;

	@FindBy(xpath = "//table[@class =\"table table-widget newsortable1 tableFilter\"]/tbody/tr[1]/td[2]/span")
	WebElement clientMode;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> byHearbeat;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> byActivity;

	@FindBy(xpath = "//img[@src=\"/prohance/images/excel.png\"]")
	WebElement byHeartbeatexcel;
	
	@FindBy(xpath = "//img[@src=\"/prohance/images/pdf.png\"]")
	WebElement byHeartbeatPdf;

	@FindBy(xpath = "//label[contains(text(),\"REPORT COLUMNS\")]")
	WebElement reportColumn;

	@FindBy(xpath = "//ul[@id=\"sortable2\"]/li[1]")
	WebElement clientdrag;

	@FindBy(xpath = "//ul[@id=\"sortable1\"]")
	WebElement clientdrop;

	@FindBy(xpath = "//div[@class=\"col-lg-12 col-md-12\"]/span[2]/input[@value=\"FETCH\"]")
	WebElement reportColumnFetch;

	@FindBy(xpath = "//ul[@id =\"sortable2\"]/li")
	List<WebElement> reportCloumnList;

	@FindBy(xpath = "//ul[@id=\"sortable1\"]/li[1]")
	WebElement clientdragFromAvailabelCol;

	@FindBy(xpath = "//ul[@id=\"sortable2\"]")
	WebElement clientdropFromAvailabelCol;

	@FindBy(xpath = "//div[@class=\"dataTables_scroll\"]/div/div/table/thead/tr/th")
	List<WebElement> reportCloumnLists;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr/td[3]")
	List<WebElement> usersLists;
	
	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr/td[3]")
	List<WebElement> usersList;

	@FindBy(xpath = "//img[@src='/prohance/images/excel.png']")
	WebElement userExcel;

	@FindBy(xpath = "//img[@src='/prohance/images/pdf.png']")
	WebElement userPdf;

	@FindBy(xpath = "//select[@name=\"CommonDataTableId_length\"]")
	WebElement displayrecords;

	@FindBy(xpath = "//select[@id =\"userViewBy\"]")
	WebElement reportViewBy;

	@FindBy(xpath = "//span[@id=\"htmlAttachSpan\"]/input")
	WebElement htmlView;
	
	@FindBy(xpath = "//span[@id=\"excelAttachSpan\"]/input")
	WebElement excelView;
	
	@FindBy(xpath = "//span[@id=\"pdfAttatchSpan\"]/input")
	WebElement pdflView;

	@FindBy(xpath = "//tr[@id=\"row_1\"]/td[2]/textarea")
	WebElement recipients;

	@FindBy(xpath = "//div[@id=\"schedulerDialogFooter\"]/span[2]")
	WebElement submit;

	@FindBy(xpath = "//table[@class =\"table table-widget newsortable1 tableFilter\"]/tbody/tr/td[2]/span")
	WebElement trayMomory;

	@FindBy(xpath = "//table[@class=\"table table-widget newsortable1 tableFilter\"]/tbody/tr[2]/td[2]/span")
	WebElement serviceMomory;

	@FindBy(xpath = "//table[@class =\"table table-widget newsortable1 tableFilter\"]/tbody/tr[1]/td[2]/span")
	WebElement byProxy;

	@FindBy(xpath = "//table[@class =\"table table-widget newsortable1 tableFilter\"]/tbody/tr[1]/td[2]/span")
	WebElement operatingSystem;

	@FindBy(xpath = "//table[@class=\"table table-widget newsortable1 tableFilter\"]/tbody/tr[1]/td[2]/span")
	WebElement dotnet;

	@FindBy(xpath = "//table[@class =\"table table-widget newsortable1 tableFilter\"]/tbody/tr[1]/td[2]/span")
	WebElement clientVersion;

	@FindBy(xpath = "//table[@class =\"configtable table-bordered-rl\"]/tbody/tr[2]/td[3]")
	WebElement dependentDataAvailable;

	@FindBy(xpath = "//table[@class =\"configtable table-bordered dependencytable\"]/tbody/tr[2]/td[1]")
	WebElement jobdetails;

	@FindBy(xpath = "//div[@class=\"messagefailure\"]/div/span")
	WebElement reportsFailMsg;

	@FindBy(xpath = "//div[@class=\"messagefailure\"]/div/button/span")
	WebElement reportsFailMsgClose;

	@FindBy(xpath = "//div[@class =\"messagefailure\"]/div/span")
	WebElement recipientsFailMsg;

	@FindBy(xpath = "//div[@id =\"schedulerDialogFooter\"]/span[1]")
	WebElement mailClose;

	@FindBy(xpath = "//span[@id =\"dialogsuccessspan\"]/span/a")
	WebElement addClose;

	@FindBy(xpath = "//div[@class =\"modal fade undraggable ui-draggable in\"]/div/div/div[2]/div[2]")
	WebElement alertMsg;
	
	@FindBy(xpath = "//span[contains(text(),\"Email sent successfully\")]")
	WebElement mailSuccessMsg;
	
	@FindBy(id ="i0116")
	WebElement outlookUserName;
	//input[@id ="i0116"]
	
	@FindBy(id ="idSIButton9")
	WebElement nextBtn;
	
	@FindBy(id ="i0118")
	WebElement outlookPassword;
	
	@FindBy(id ="idSIButton9")
	WebElement signIn;
	
	@FindBy(id ="idSIButton9")
	WebElement staySignIn;
	
	@FindBy(id ="ms-searchux-input-0")
	WebElement search;
	
	@FindBy(xpath ="//span[contains(text(),\"Outlook\")]")
	WebElement outlook;
	
	@FindBy(xpath ="//button[@name=\"Download\"]//span[contains(text(),'Download')]")
	WebElement mailDownload;
	
	@FindBy(xpath ="//div[@id=\"rec-item-1\"]/div/div/div[2]/div[2]")
	WebElement exexcel;
	
	@FindBy(xpath ="//div[@id=\"m_excelWebRenderer_ewaCtl_sheetContentDiv_Flow_0\"]/div/div[2]/div/canvas")
	List<WebElement> exexcelList;
	
	@FindBy(xpath ="//div[@class =\"ppeSg VZHTX\"]/iframe")
	WebElement switchFrame;
	
	@FindBy(xpath ="//div[@class =\"zKDWD YbB6r IKvQi epBmH EhiOs _KLsp\"]/div[2]/div[2]/div[4]/div/div")
	WebElement sendedMail;
	
	@FindBy(xpath ="//div[@id =\"edgeworthbase\"]/div/div/div/a/div/div/div[2]")
	WebElement recentDownload;
	
	@FindBy(id ="probeType")
	WebElement client;
	
	@FindBy(id ="heartbeatType")
	WebElement heartBeatType;
	
	@FindBy(id ="fetchId")
	WebElement fetchBtn;
	
	@FindBy(xpath ="//div[@id =\"container\"]/div[contains(text(),'No records to display')]")
	WebElement loggedUserwithNodata;
	
	
	@FindBy(xpath ="//input[@value='REFRESH']")
	WebElement refreshBtn;
	
	@FindBy(xpath ="//table[@id=\"CommonDataTableId\"]/tbody/tr/td[1]")
	List<WebElement> bulkUploadDeleteUploadedMsg;
	
	@FindBy(xpath = "//div[@id =\"CommonDataTableId_filter\"]/label/input")
	WebElement userSearch;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[3]")
	List<WebElement> searchList ;
	
	@FindBy(xpath = "//div[@id =\"CommonDataTableId_filter\"]/label/input")
	WebElement userAttributeSearch;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[3]")
	List<WebElement> userAttributesearchList ;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[4]")
	WebElement activeUsersWithMissingField;
	
	public UsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
    
	@Step("Scroll side navigation menu bar")
	public void scrollSideNavigationBar() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a[contains(text(),'Business Hierarchy')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
	}
	
	@Step("Click on Users")
	public void clickUsersBtn() {
		this.UsersBtn.click();
	}
	
	@Step("Click on Users")
	public void clickUsers() {
		this.Users.click();
	}
	
	@Step("Click on ADD new btn")
	public void clickADDNEWbtn() {
		this.AddNewBtn.click();
	}
	
	@Step("Select role")
	public void selectRole(String role) {
		Select clickRole = new Select(this.role);
		clickRole.selectByVisibleText(role);
	}
	
	@Step("Click on Login Id and enter the new login id")
	public void enterLoginIdTxtBox(String loginid) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(this.loginId)).sendKeys(loginid);
	}
    
	@Step("Click on console authentication checkbox")
	public void clickConsoleAuthChkBox() {
		this.consoleAuth.click();
	}
	
	@Step("Click on Login Id and enter the new login id")
	public void enterLoginIdConXTxtBox(String loginid) {
		System.out.println(loginid);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(this.loginIdCon)).sendKeys(loginid);
	}
	
	@Step("Enter the password")
	public void enterPasswordTxtBox(String loginid) {
		System.out.println(loginid);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(this.password)).sendKeys(loginid);
	}
	
	@Step("Enter the confirm password")
	public void enterConfirmPassTxtBox(String loginid) {
		System.out.println(loginid);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(this.confirmpassword)).sendKeys(loginid);
	}
	
	@Step("Enter first name")
	public void enterFirstNameTxtBox(String name) {
		this.firstName.sendKeys(name);
	}
	
	@Step("Select the time zone")
	public void selectTimeZone(String timezone) {
		Select clickTimeZone = new Select(this.timezone);
		clickTimeZone.selectByVisibleText(timezone);
	}
	
	@Step("Click on Save btn")
	public void clickSaveBtn() {
		this.savebtn.click();
	}
    
	@Step("Click on team mapping")
	public void clickteamMapping() {
		this.teamMapping.click();
	}
	
	@Step("Click on Addnew btn in team mapping")
	public void clickADDTEAMSBtn() {
		this.addTeamsBtn.click();
	}
	
	@Step("Select the team which you want to map")
	public void checkCheckBoxJavaScipt(WebElement locator) {
		JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;
		if (!locator.isSelected()) {
			jsexecutour.executeScript("arguments[0].click();", locator);
		}

	}
	
	@Step("Select group")
	public void clickSelectSuperGrp() throws InterruptedException {
		// Thread.sleep(2000);
		// this.selectSuperGrp.click();
		checkCheckBoxJavaScipt(selectSuperGrp);

	}
	
	@Step("Click on Super group ADD btn")
	public void clickSuperGrpAddBtn() throws InterruptedException {
		// Thread.sleep(2000);
		this.addBtn.click();
	}
	
	@Step("Move the parent window to child window")
	public void moveToAddPage() {

		Set<String> handles = this.driver.getWindowHandles();
		Iterator it = handles.iterator();
		String parentwindow = (String) it.next();
		String childwindow = (String) it.next();
		driver.switchTo().window(childwindow);

	}
	
	@Step("Move from child to parent window")
	public void moveToparentWindow() {

		System.out.println("parent window");
		Set<String> ids = this.driver.getWindowHandles();
		Iterator<String> i = ids.iterator();
		String parentID = i.next();
		while (i.hasNext()) {
			String childID = i.next();
			this.driver.switchTo().window(childID);
		}

		this.driver.switchTo().window(parentID);

	}
	
	@Step("Click back btn")
	public void clickBackBtn() {
		this.backBtn.click();
	}
	
	@Step("Click inactive users check box")
	public void clickInactiveChkBoc() {
		this.inactive.click();
	}
	
	@Step("Select user type")
	public void selectUserType(String userType) {
		Select clickUserType = new Select(this.userType);
		clickUserType.selectByVisibleText(userType);
	}
	
	@Step("Click on Modify btn")
	public void clickModifyBtn() {
		this.monitorimgBtn.click();
	}

//	public void clickDeleteBtn(String name) {
//		System.out.println(name);
//		driver.findElement(By.xpath("//a[contains(text(),\" + name + \")]/../../td[1]/a[2]")).click();
//		System.out.println("//a[contains(text(),\" + name + \")]/../../td[1]/a[2]");
//		System.out.println("//a[contains(text(),\"Aishwarya1\")]");
//		
//	}
	
	@Step("Click on close aggregation popup")
	public void clickCloseAggregationPopUp() {
		this.closeAggregationPopUp.click();
	}
	
	@Step("Click on delete icon")
	public void clickDeleteBtn() {
		this.deleteBtn.click();
	}
	
	@Step("Click on YES btn")
	public void clickYESBtn() {
		this.yesBtn.click();
	}
	
	@Step("Click on CLICK HERE btn")
	public void clickClickHereBtn() {
		this.clickHereBtn.click();

	}
	
	@Step("Enter the password")
	public void clickMonitorImgBtn() {
		this.monitorimgBtn.click();
	}
	
	@Step("Click on mointor btn")
	public void clickMonitorBtn() {
		this.monitorBtn.click();

	}
	
	@Step("Click on delete icon")
	public void clickDeleteIcon()
	{
		this.delete.click();
	}
	
	@Step("Click on MOREACTION ")
	public void clickMOREACTIONBtn() {
		//this.moreActionBtn.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.moreActionBtn);
	}
	
	@Step("Click on Bulk Upload")
	public void clickBulkUploadBtn() {
		this.bulkUpload.click();
	}

	@Step("Select template from the dropdown")
	public void selectTemplateDropDown(String temp) {
		Select clicktemp = new Select(this.template);
		clicktemp.selectByVisibleText(temp);
	}
	
	@Step("Click on CLICK HERE btn")
	public void clickHereBtn() {

		this.clickHere.click();
	}
	@Step("Click on Choose file btn")
	public String clickChooseFileBtn(String url) {
		System.out.println("enter");
		System.out.println(url);
		WebElement choose = this.chooseFileBtn;
		choose.sendKeys(url);
		this.upload.click();
		return url;

	}
	
	@Step("Click on Choose file btn")
	public void clickChooseFileForInactiveBtn(String url) {
		System.out.println("enter");
		System.out.println(url);
		WebElement choose = this.chooseFileBtn;
		choose.sendKeys(url);
		this.upload.click();
		// return url;

	}
	
	@Step("Click on Upload btn")
	public void clickUpload() {
		this.upload.click();
	}
	
	@Step("Select user condition")
	public void selectUserConditione(String userCondition) {
		Select clickUserCondition = new Select(this.condition);
		clickUserCondition.selectByVisibleText(userCondition);
	}
    
	@Step("Select user status")
	public void selectUserStatus(String userStatus) {
		Select clickUserStatusCondition = new Select(this.userStatus);
		clickUserStatusCondition.selectByVisibleText(userStatus);
	}
	
	@Step("Click on Define tenure range")
	public void clickDefineTenureBtn() {
		this.defineTenure.click();
	}
	
	@Step("Select tenure")
	public void selectTenure(String tenure) {
		Select clickTenure = new Select(this.tenureMes);
		clickTenure.selectByVisibleText(tenure);
	}
	
	@Step("Fill the tenure range")
	public int fillRangeFrom() {
		String fromValue = this.rangeFrom.getAttribute("value");
		int range = Integer.valueOf(fromValue);
		// System.out.println("get from data");
		// System.out.println(this.rangeFrom.getAttribute("value"));
		// this.rangeFrom.sendKeys(from);
		return range;
	}
	
	@Step("Fill the tenure range")
	public void fillRangeTo(int to) {
		this.rangeTo.clear();
		String ran = String.valueOf(to);
		this.rangeTo.sendKeys(ran);
	}
	
	@Step("Click on tenure ADD btn")
	public void clickTenureAddBtn() {
		this.tenureAddBtn.click();
	}
	
	@Step("Click on tenure datele btn")
	public void clickTenureDelete() {
		this.deletetenure.click();
	}
	
	@Step("Click on Tenure Save btn")
	public void clickTenureSaveBtn() {
		this.tenureSavebtn.click();
	}
	
	@Step("Select associate users")
	public void selectAssociateUser(String user) {
		Select clickAssUser = new Select(this.selectTeams);
		clickAssUser.selectByVisibleText(user);
	}
	
	@Step("Click on tenure delete icon")
	public void ClickDeleteIcon() {
		this.deleteicon.click();
	}
	
	@Step("Tenure success message")
	public boolean getMsg() {
		String ms = this.successMsg.getText();
		System.out.println(ms);
		String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
		System.out.println(ms);
		String compareMsg = "SUCCEEDED";
		boolean check = ms.equals(compareMsg);
		return check;

	}

	@Step("Tenure Fail message")
	public boolean getFailMsg() {
		String ms = this.failMsg.getText();
		String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
		String compareMsg = "Uploadcompletedwitherror(s)";
		boolean check = msg.equals(compareMsg);
		return check;

	}
	
	@Step("Click on user attribute")
	public void clickUsersAttribute() {
		this.userAttribute.click();
	}
	
	@Step("Click on inactive attribute users")
	public void clickInactiveAttribute() {
		this.inactiveAttribute.click();

	}
	
	@Step("Click on work time")
	public void clickWorkTime() {
		this.workTime.click();
	}
	
	@Step("Click on Attendance")
	public void clickAttendance() {
		this.attendance.click();
	}
	
	@Step("Click on filter option in attendance")
	public void clickFilter() {
		this.filter.click();
	}
	
	@Step("Click on user image")
	public void clickUserimg() {
		this.userImg.click();
	}
	
	@Step("Get the user attribute list")
	public List<String> GetUserArrtribute() {
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.getUserArrtribute;
		int len = col.size();
		System.out.println(len);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < len; i++) {
			WebElement ele = this.endOfUserAtt;

			teamsList.add(this.getUserArrtribute.get(i).getText());
			js.executeScript("arguments[0].scrollIntoView();", ele);
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Get the role")
	public Object getRole() throws InterruptedException {
		// Thread.sleep(3000);
		String attribute = this.getRole.getText();
		System.out.println(this.getRole.getText());
		return attribute;
	}
	
	@Step("Click on LicenceReport")
	public void clickLicencereport() {
		this.licencereport.click();
	}
	
	@Step("Get the licence reoprt list")
	public Set<String> getLicenceList() {
		List<WebElement> col = null;
		Set<String> teamsList = new TreeSet();
		col = this.licenceList;
		int len = col.size();
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.licenceList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Get the licence reoprt list")
	public List<String> getLicenceListForPDF() {
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.licenceList;
		int len = col.size();
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.licenceList.get(i).getText());
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on Licence Excel export image")
	public void clicklicenceExcelImg() {
		this.licenceExcelImg.click();
	}
	
	@Step("Click on Licence PDF export image")
	public void clickLicencePdfImg() {
		this.licenceEPdfImg.click();
	}
	
	@Step("Click on Logged users")
	public void clickLoggedUsers() {
		this.loggedUsers.click();
	}
	
	@Step("Click on DASHBOARD view")
	public void clickDashboardVies() {
		this.dashboardVies.click();
	}
	
	@Step("Click on Client filter")
	public void clickClientFilter() {
		this.clientFilter.click();
	}
	
	@Step("Select client by activity")
	public void selectSlientByActivity(String user) {
		Select clickAssUser = new Select(this.reportBy);
		clickAssUser.selectByVisibleText(user);
	}
	
	@Step("Click on FETCH btn")
	public void clickFetchBtn() {
		this.Fetch.click();
	}
	
	@Step("Click on count")
	public void clickCount() {
		// this.count.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.count);
	}
	
	@Step("Get hearbeat list")
	public List<String> getByHearbeat() {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.byHearbeat;
		int len = col.size();
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.byHearbeat.get(i).getText());
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on hearbeat excel export image")
	public void clickByHeartbeatexcel() {
		this.byHeartbeatexcel.click();
	}
	
	@Step("Click on tenure delete btn")
	public void clicktenureDeleteBtn() {
		driver.switchTo().alert().accept();
	}
	
	@Step("Click on report coulmn")
	public void clickReportColumn() {
		this.reportColumn.click();
	}
	
	@Step("Click on  client Drag")
	public void clickClientDrag() {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(clientdrag).moveToElement(clientdrop).release(clientdrop).build();
		dragAndDrop.perform();
	}
	
	@Step("Click on Client Drag and Drop")
	public void clickClientDragAndDrop() {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(clientdragFromAvailabelCol).moveToElement(clientdropFromAvailabelCol)
				.release(clientdropFromAvailabelCol).build();
		dragAndDrop.perform();
	}
	
	@Step("Click on Report Column Fetch btn")
	public void clickReportColumnFetchBtn() {
		this.reportColumnFetch.click();
	}
	
	@Step("Get the report cloumn list")
	public List<String> getReportColumnList() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.reportCloumnList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len-1; i++) {
			teamsList.add(this.reportCloumnList.get(i).getText());
			 System.out.println( teamsList.add(this.reportCloumnList.get(i).getText()));
		}
		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Get the report cloumn list")
	public List<String> getReportColumnLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.reportCloumnLists;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 1; i < len - 1; i++) {
			teamsList.add(this.reportCloumnLists.get(i).getText());
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Get the users list")
	public List<String> getUsersLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.usersList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.usersList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		// teamsList.add(5,"Aishwarya");;
		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Get users list for excel export")
	public List<String> getUsersListsForExcel() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.usersLists;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.usersLists.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		teamsList.add(1, "Aishu");
		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on users Excel imaget")
	public void clickUserExcel() {
		this.userExcel.click();
	}
	
	@Step("Click on display records and select the count ")
	public void clickDisplayrecords(String count) {
		Select clickAssUser = new Select(this.displayrecords);
		clickAssUser.selectByVisibleText(count);
	}
	
	@Step("Click on user PDF export")
	public void clickUserPdf() {
		this.userPdf.click();
	}
	
	@Step("Click on Client mode")
	public void clickClientMode() {
		this.clientMode.click();

	}
	
	@Step("Click on Emil image")
	public void clickEmailImg() {
		this.email.click();
	}
	
	@Step("Select report view by ")
	public void clickReportViewBy(String report) {
		// this.reportViewBy.click();
		Select clickAssUser = new Select(this.reportViewBy);
		clickAssUser.selectByVisibleText(report);
	}
	
	@Step("Click on HTML view in Email")
	public void clickHtmlRadioBtn() {
		this.htmlView.click();
	}
	
	@Step("Click on fill recipients")
	public void fillrecipients(String mailId) {
		this.recipients.sendKeys(mailId);
	}
	
	@Step("Click on Submit btn")
	public void clickSubmitBtn() {
		this.submit.click();
	}
	
	@Step("Click on Tray memory")
	public void clickTrayMomory() {
		this.trayMomory.click();
	}
	
	@Step("Click on service memory")
	public void clickServiceMomory() {
		this.serviceMomory.click();
	}
	
	@Step("Click on By Proxy")
	public void clickByProxy() {
		this.byProxy.click();
	}
	
	@Step("Click on operating system")
	public void clickOperatingSystem() {
		this.operatingSystem.click();
	}
	
	@Step("Click on Dotnet")
	public void clickDotnet() {
		this.dotnet.click();
	}
	
	@Step("Click on modify btn")
	public void clickModifyIcon()
	{
		this.modify.click();
	}
	
	@Step("Click on client version")
	public void clickClientVersion() {
		this.clientVersion.click();
	}
	
	@Step("Click on dependent data available")
	public void clickDependentDataAvailable() throws InterruptedException {
		boolean result = false;
		String dependentData = this.dependentDataAvailable.getText();
		Thread.sleep(1000);
		String job = this.jobdetails.getText();
		boolean dependent = dependentData.equals("Yes");
		boolean jobdetail = job.equals("JAMINT13432");
		if ((dependent == true) && (jobdetail == true)) {
			result = true;
		}
		Assert.assertTrue(result);
	}
	
	@Step("Get report fail message")
	public void getReportsFailMsg() {
		System.out.println("msg");
		String msg = this.recipientsFailMsg.getText();
		System.out.println(msg);
		boolean res = msg.equals("Report View By is required information");
		System.out.println(res);
		Assert.assertTrue(res);
	}
	
	@Step("Get report fail message")
	public void getReportsFailMsg1() {
		System.out.println("msg");
		String msg = this.reportsFailMsg.getText();
		System.out.println(msg);
		boolean res = msg.equals("Recipients is invalid information");
		System.out.println(res);
		Assert.assertTrue(res);
	}
	
	@Step("Click on report fail message close btn")
	public void clickRecipientsFailMsgCloseBtn() {
		this.reportsFailMsgClose.click();
	}
	
	@Step("Get recipients fail message")
	public void getRecipientsFailMsg() {
		System.out.println("msg");
		String msg = this.recipientsFailMsg.getText();
		System.out.println(msg);
		boolean res = msg.equals("Recipients is required information");
		System.out.println(res);
		Assert.assertTrue(res);
	}
	
	@Step("Click on mail close btn")
	public void clickMailClose() {
		this.mailClose.click();
	}
	
	@Step("Click on add close btn")
	public void clickAddClose() {
		this.addClose.click();
	}
	
	@Step("Click on alert message")
	public void clickAlertMsg() {
		String msg = this.alertMsg.getText();
		boolean res = msg.equals("Range To field is required information");
		System.out.println(res);
		Assert.assertTrue(res);
	}
	
	@Step("Get mail success message")
	public void getMailSuccessMsg()
	{
		String msg = this.mailSuccessMsg.getText();
		System.out.println(msg);
		boolean res = msg.equals("Email sent successfully");
		System.out.println(res);
	}
	
	@Step("Enter outlook useranme")
	public void sendoutlookUserName(String username)
	{
		this.outlookUserName.sendKeys(username);
	}
	
	@Step("Click on Next btn")
	public void clickNextBtn()
	{
		this.nextBtn.click();
	}
	
	@Step("Enter the outlook password")
	public void sendoutlookPassword(String password)
	{
		this.outlookPassword.sendKeys(password);
	}
	
	@Step("Click on SIGNIN btn")
	public void clickSignInBtn()
	{
		this.signIn.click();
	}
	
	@Step("Click on stay signin btn")
	public void clickStaySignInBtn()
	{
		this.staySignIn.click();
	}
	
	@Step("Click on search btn")
	public void clickSearchBtn()
	{
		this.search.click();
	}
	
	@Step("Click on outlook btn")
	public void clickOutlook()
	{
		this.outlook.click();
	}
	
	@Step("Click on excel view ")
	public void clickExcelView()
	{
		this.excelView.click();
	}
	
	@Step("Click on outlook excel ")
	public void clickExexcel()
	{
		this.exexcel.click();
	}
	
	@Step("Click on by hearbeat PDF export")
	public void clickbyHeartbeatPdf()
	{
		this.byHeartbeatPdf.click();
	}
	
	@Step("Click on mail download ")
	public void clickMailDownload()
	{
		this.mailDownload.click();
	}
	
	@Step("Click on switch tab")
	public void clickToSwitchtab()
	{
		String currentHandle= driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		for(String actual: handles) {
			if(!actual.equalsIgnoreCase(currentHandle)) {
			//Switch to the opened tab
			driver.switchTo().window(actual); 
			//opening the URL saved.
			//driver.get(urlToClick);
			}
			}
	}
	
	@Step("Get excel list")
	public void getexexcelList() throws InterruptedException
	{
		System.out.println("check");
		//String msg = this.exexcelList();
		//System.out.println(msg);
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.exexcelList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.exexcelList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		System.out.println(teamsList);
		//return teamsList;
		
	}
	@Step("Switch frame")
	public void switchFrame()
	{
		driver.switchTo().frame("//div[@class ='ppeSg VZHTX']/iframe");
	}
	
	@Step("Click on PDF view in email")
	public void clickPdflView()
	{
		this.pdflView.click();
	}
	
	@Step("Click on monitore image")
	public void clickModifyBtn1()
	{
		this.monitorimgBtn1.click();
	}
	
	@Step("Click on sended mail")
	public void clickOnSendedMail()
	{
		this.sendedMail.click();
	}
	
	@Step("Click on recent download btn")
	public void clickOnRecentDownload()
	{
		//this.recentDownload.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(this.recentDownload)).click();
	}
	
	@Step("Click on client")
	public void clickClient(String client) {
		// this.reportViewBy.click();
		Select clickclient = new Select(this.client);
		clickclient.selectByVisibleText(client);
	}
	
	@Step("Clint on heart beat type")
	public void clickHeart(String hearBeat) {
		// this.reportViewBy.click();
		Select clickhearBeat = new Select(this.heartBeatType);
		clickhearBeat.selectByVisibleText(hearBeat);
	}
	
	@Step("Click on FETCH btn")
	public void clickLoggedFetchBtn()
	{
		this.fetchBtn.click();
	}
	
	
	@Step("No record to display message")
	public boolean getNodataMsg()
	{
		boolean res = false;
		String msg = this.loggedUserwithNodata.getText().replaceAll("\\s+", "");
		System.out.println(msg);
		if(msg.equals("Norecordstodisplay")) {
			res = true;
		}
		else
		{
			res= false;
		}
		return res;
	}
	
	@Step("Click on Refresh btn")
	public void clickRefreshBtn()
	{
		this.refreshBtn.click();
	}
	
	@Step("Click on delete after bulk upload")
	public void bulkUploadDeleteUploadedMsg() throws InterruptedException
	{
		System.out.println("check");
		//String msg = this.exexcelList();
		//System.out.println(msg);
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.bulkUploadDeleteUploadedMsg;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			Thread.sleep(1000);
			this.bulkUploadDeleteUploadedMsg.get(i).click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
		}
		System.out.println(teamsList);
		//return teamsList;
		
	}
	
	@Step("Click on search")
	public void clickSearch(String service)
	{
		this.userSearch.sendKeys(service);
	}
	
	@Step("Get list after searching")
	public void getSearchList() throws InterruptedException
	{
		List<WebElement> col = null;
		boolean validate = false;
		List<String> teamsList = new ArrayList();
		col = this.searchList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.searchList.get(i).getText().replaceAll("\\s+", ""));
		}
		System.out.println(teamsList);
		for(int i = 0; i <teamsList.size();i++ )
		{
		 if(teamsList.get(i).contains("aBFMe"))
		  {
			validate = true;
			
		  }
		}
		Assert.assertTrue(validate);
	}
	
	@Step("Click on search")
	public void clickUserAttributeSearch(String service)
	{
		this.userAttributeSearch.sendKeys(service);
	}
	
	@Step("Get list after searching")
	public void getUserAttributeSearchList() throws InterruptedException
	{
		List<WebElement> col = null;
		boolean validate = false;
		List<String> teamsList = new ArrayList();
		col = this.userAttributesearchList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.userAttributesearchList.get(i).getText().replaceAll("\\s+", ""));
		}
		System.out.println(teamsList);
		for(int i = 0; i <teamsList.size();i++ )
		{
		 if(teamsList.get(i).contains("Location"))
		  {
			validate = true;
			
		  }
		}
		Assert.assertTrue(validate);
	}
	
	@Step("Required filed missing validation")
	public boolean getMissedFieldMsg() {
		String ms = this.activeUsersWithMissingField.getText();
		System.out.println(ms);
		String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
		System.out.println(ms);
		String compareMsg = "FAILED";
		boolean check = ms.equals(compareMsg);
		return check;

	}
}