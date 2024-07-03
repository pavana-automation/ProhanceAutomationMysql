package net.pages_asset_optimizationmodule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class WorkStationGroupsPages {

	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),\"ASSET OPTIMIZATION\")]")
	WebElement assertOptimization;
	
	@FindBy(xpath = "//ul/li[contains(text(),'Workstation Groups')]")
	WebElement workStationGroups;
	
	@FindBy(xpath = "//a/span[contains(text(),'Administration')]")
	WebElement administration;
	
	@FindBy(xpath = "//label[contains(text(),\"ADD NEW\")]")
	WebElement addNew;
	
	@FindBy(id = "WSGroupId")
	WebElement name;
	
	@FindBy(id = "descriptionId")
	WebElement description;
	
	@FindBy(xpath = "//tr[@id =\"enableGeoLocationRowId\"]/td[2]/div/label")
	WebElement location;
	
	@FindBy(xpath = "//td[@class =\"wizard-tab-buttons\"]/input[2]")
	WebElement saveBtn;
	
	@FindBy(id = "scanIntervalId")
	WebElement scanTime;
	
	@FindBy(id = "isActiveId")
	WebElement active;
	
	@FindBy(xpath = "//label[contains(text(),\"BACK\")]")
	WebElement back;
	
	@FindBy(xpath = "//div[contains(text(),\"automation_1\")]/../../td[1]/span[1]")
	WebElement modifyBtn;
	
	@FindBy(xpath = "//div[contains(text(),\"automation_1\")]/../../td[1]/span[2]")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//button[contains(text(),'YES')]")
	WebElement yesBtn;
	
	@FindBy(xpath = "//span[contains(text(),\"Associate Clients\")]")
	WebElement associateClients;
	
	
	@FindBy(id = "addApps")
	WebElement addClient;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td/div/label")
	WebElement selectClient;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement addMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement modifyMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement deleteMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/a")
	WebElement closeXIconBtn;
	
	@FindBy(xpath = "//body[@class=\"modal-open\"]/div[4]/div/div/div[2]/div[2]")
	WebElement popupMsg;
	
	@FindBy(xpath = "//td[@class =\"wizard-tab-buttons\"]/input[1]")
	WebElement clear;
	
	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[1]/td/span[1]")
	WebElement Clearmodify;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]/div")
	List<WebElement> workStationList;
	
	@FindBy(xpath = "//img[@src='/phworkstation/images/excel.png']")
	WebElement workStationExcel;

	@FindBy(xpath = "//img[@src='/phworkstation/images/pdf.png']")
	WebElement workStationPdf;
	
	@FindBy(xpath = "//img[@src='/phworkstation/images/excel.png']")
	WebElement softeareDefinitionExcel;
	
	@FindBy(xpath = "//img[@src='/phworkstation/images/pdf.png']")
	WebElement softeareDefinitionPdf;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]/div")
	List<WebElement> softwareDefinitionList;
	
	
	public WorkStationGroupsPages(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@Step("SwitchTabs ")
	public void switchTabs() {

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));
		System.out.println("Page title of new tab: " + driver.getTitle());

	}
	
	@Step("Scroll SideNavigation Bar ")
	public void scrollSideNavigationBar() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a/span[contains(text(),'Administration')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
	}
	@Step("Click Administration")
	public void clickAdministration()
	{
		this.administration.click();
	}
	@Step("Click AssertOptimization")
	public void clickAssertOptimization() {
		this.assertOptimization.click();
	}
	@Step("Click WorkStationGroups")
	public void clickWorkStationGroups()
	{
		this.workStationGroups.click();
	}
	@Step("Click AddNew")
	public void clickAddNew()
	{
		this.addNew.click();
	}
	
	@Step("Click Name")
	public void clickName(String name)
	{
		this.name.sendKeys(name);
	}
	
	@Step("Click Description")
	public void clickDescription(String desc)
	{
		this.description.sendKeys(desc);
	}
	
	@Step("Click Location")
	public void clickLocation()
	{
		//this.location.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.location);
	}
	@Step("Click SAVEBtn")
	public void clickSAVEBtn()
	{
		this.saveBtn.click();
	}
	@Step("Click ScanTime")
	public void clickScanTime(String time)
	{
		this.scanTime.clear();
		this.scanTime.sendKeys(time);
	}
	
	@Step("Click Active")
	public void clickActive()
	{
		//this.active.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.active);
	}
	@Step("Click BackBtn")
	public void clickBackBtn()
	{
		this.back.click();
	}
	@Step("Click ModifyBtn")
	public void clickModifyBtn()
	{
		this.modifyBtn.click();
	}
	
	@Step("Click DeleteBtn")
	public void clickDeleteBtn()
	{
		this.deleteBtn.click();
	}
	@Step("Click YESBtn")
	public void clickYESBtn() {
		this.yesBtn.click();
	}
	@Step("Click AssociateClients")
	public void clickAssociateClients()
	{
		this.associateClients.click();
	}
	@Step("Click AddClientBtn")
	public void clickAddClientBtn()
	{
		this.addClient.click();
	}
	@Step("Click AddClientBtn")
	public void checkCheckBoxJavaScipt(WebElement locator) {
		JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;
		if (!locator.isSelected()) {
			jsexecutour.executeScript("arguments[0].click();", locator);
		}

	}
	@Step("Click SelectSuper Client")
	public void clickSelectSuperClient() throws InterruptedException {
		Thread.sleep(6000);
		checkCheckBoxJavaScipt(selectClient);

	}
	@Step("Move To AddPage")
	public void moveToAddPage() {

		Set<String> handles = this.driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		@SuppressWarnings("unused")
		String parentwindow = (String) it.next();
		String childwindow = (String) it.next();
		driver.switchTo().window(childwindow);

	}
	
	@Step("Move To parent Window")
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
	@Step("ClickAddMsg")
	public boolean clickAddMsg()
	 {
		 String ms = this.addMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			System.out.println(msg);
			String compareMsg = "WorkstationGroup:automation_1addedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	@Step("Click ModifyMsg")
	public boolean clickModifyMsg()
	 {
		 String ms = this.modifyMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			String compareMsg = "WorkstationGroup:automation_1modifiedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	@Step("Click DeleteMsg")
	public boolean clickDeleteMsg()
	 {
		 String ms = this.deleteMsg.getText();
		 System.out.println(ms);
			String msg = ms.replaceAll("\\s+", "");
			String compareMsg = "WorkstationGroup:automation_1deletedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	
	@Step("Click Close Icon")
	public void clickCloseXIconBtn()
	{
		this.closeXIconBtn.click();
	}
	
	@Step("Click Required Msg")
	public boolean clickRequiredMsg() throws InterruptedException
	 {
		System.out.println("check");
		Thread.sleep(2000);
		 String ms = this.popupMsg.getText();
		 System.out.println(this.popupMsg.getText());
			String msg = ms.replaceAll("\\s+", "");
			System.out.println(msg);
			String compareMsg = "Nameisrequiredinformation";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	@Step("Clearmodify")
	public void Clearmodify()
	{
		this.Clearmodify.click();
	}
	
	@Step("Clicks CLEARBtn")
	public void clicksCLEARBtn()
	{
		this.clear.click();
	}
	@Step("Clicks ScanRequired Msg click Scan Required Msg")
	public boolean clickScanRequiredMsg() throws InterruptedException
	 {
		System.out.println("check");
		Thread.sleep(2000);
		 String ms = this.popupMsg.getText();
		 System.out.println(this.popupMsg.getText());
			String msg = ms.replaceAll("\\s+", "");
			System.out.println(msg);
			String compareMsg = "ScanIntervalisrequiredinformation";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	@Step("Get WorkStation Data into List")
	public List<String> getWorkStationList() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList<String>();
		col = this.workStationList;
		int len = col.size();
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.workStationList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		return teamsList;
	}
	@Step("Click WorkStation Excel")
	public void clickWorkStationExcel()
	{
		this.workStationExcel.click();
	}
	@Step("Click WorkStation PDF")
	public void clickWorkStationPdf()
	{
		this.workStationPdf.click();
	}
	
	@Step("Click WorkStation PDF")
	public void clickWSoftwareDefinitionPdf()
	{
		this.softeareDefinitionPdf.click();
	}
	
	@Step("Click WSoftwareDefinition Excel")
	public void clickWSoftwareDefinitionExcel()
	{
		this.softeareDefinitionExcel.click();
	}
	
	@Step("Get SoftwareDefinition into List")
	public List<String> getSoftwareDefinitionList() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList<String>();
		col = this.workStationList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.workStationList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		System.out.println(teamsList);
		return teamsList;
	}
}
