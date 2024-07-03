package net.pages_worktimemodule;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class BusinessHierarchy {
	WebDriver driver;
	@FindBy(xpath = "//li/a[contains(text(),\"Business Hierarchy\")]")
	WebElement businessHierarchy;

	@FindBy(xpath = "//li[contains(text(),\"Hierarchy Structure\")]")
	WebElement hierarchyStructure;
	
	@FindBy(xpath = "//li[contains(text(),\"Hierarchy Mapping\")]")
	WebElement hierarchyMapping;
	
	@FindBy(xpath = "//label[contains(text(),\"ADD NEW\")]")
	WebElement addNewBtn;
	
	@FindBy(id = "title")
	WebElement title;
	
	@FindBy(id = "description")
	WebElement description;
	
	@FindBy(id = "activeStatus_true")
	WebElement active;
	
	@FindBy(id = "activeStatus_false")
	WebElement inactive;
	
	@FindBy(xpath = "//div[@class =\"tab-buttons\"]/input[2]")
	WebElement save;
	
	@FindBy(xpath = "//div[@class =\"tab-buttons\"]/input[1]")
	WebElement clear;
	
	@FindBy(xpath = "//td/div[contains(text(),\"automation_1\")]/../../td[1]/a[1]/i")
	WebElement modify;
	
	@FindBy(xpath = "//td/div[contains(text(),\"automation_1\")]/../../td[1]/a[2]/i")
	WebElement delete;
	
	@FindBy(xpath = "//button[contains(text(),'YES')]")
	WebElement yesBtn;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement addMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement modifyMsg;
	
	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement deleteMsg;
	
	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[1]/td[1]/a[1]/i")
	WebElement modifyForClear;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[6]/a/i/span[contains(text(),\"Active\")]/../../../../td[2]/div")
	List<WebElement> activeList;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]/div")
	List<WebElement> hierarchyList;
	
	@FindBy(xpath = "//img[@src='/prohance/images/excel.png']")
	WebElement excel;
	
	@FindBy(xpath = "//img[@src='/prohance/images/pdf.png']")
	WebElement pdf;
	
	@FindBy(xpath = "//body[@class=\"modal-open\"]/div[4]/div/div/div[2]/div[2]")
	WebElement popupMsg;
	
	@FindBy(xpath = "//a[contains(text(),\"ADVANCED ANALYTICS\")]")
	WebElement analytics;
	
	@FindBy(xpath="//div[@id =\"arrow-top\"]/i")
	WebElement advancedAnaylticsSideNavigationArrow;
	
	@FindBy(xpath="//a/span[contains(text(),\"Work Trends\")]")
	WebElement workTrends;
	
	@FindBy(xpath="//li[contains(text(),\"Business Hierarchy\")]")
	WebElement advancePageHierarchy;
	
	@FindBy(xpath="//select[@id =\"ohTypeId\"]/option")
	List<WebElement> hierarchyStructureList;
	
	@FindBy(xpath="//label[contains(text(),\"BULK UPLOAD\")]")
	WebElement bulkUpload;
	
	@FindBy(id="existingHierarchyTemplet")
	WebElement templateWithData;
	
	@FindBy(xpath="//tr[@id =\"downloadTemplate\"]/td/span[contains(text(),\"Click here\")]")
	WebElement clickHere;
	
	@FindBy(xpath="//table[@id='uploadTable']/tbody/tr[2]/td[2]/div/span/span/span/input[@id=\"ohUserMappingXmlFile\"]")
	WebElement chooseFileBtn;
	
	@FindBy(xpath = "//table[@id=\"uploadTable\"]/tbody/tr[2]/td[2]/div/span/span[2]/input")
	WebElement upload;
	
	public BusinessHierarchy(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@Step("Scroll Side Navigation Bar")
	public void scrollSideNavigationBar() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a[contains(text(),'Business Hierarchy')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
	}
	@Step("Click Business Hierarchy")
	public void clickBusinessHierarchy()
	{
		this.businessHierarchy.click();
	}
	
	@Step("Click Hierarchy Structure")
	public void clickHierarchyStructure()
	{
		this.hierarchyStructure.click();
	}
	
	@Step("Click AddNew Btn")
	public void clickAddNewBtn()
	{
		this.addNewBtn.click();
	}
	
	@Step("Click Title")
	public void clickTitle(String title)
	{
		this.title.sendKeys(title);
	}
	
	@Step("Click Description")
	public void clickDescription(String description)
	{
		this.description.sendKeys(description);
	}
	
	@Step("Click Active")
	public void clickActive()
	{
		this.active.click();
	}
	
	@Step("Click SaveBtn")
	public void clickSaveBtn()
	{
		this.save.click();
	}
	
	@Step("Click Modify")
	public void clickModify()
	{
		this.modify.click();
	}
	
	@Step("Click Inactive")
	public void clickInactive()
	{
		this.inactive.click();
	}
	
	@Step("Click YesBtn")
	public void clickYesBtn()
	{
		this.yesBtn.click();
	}
	
	@Step("Click Delete")
	public void clickDelete()
	{
		this.delete.click();
	}
	
	
	@Step("Click AddMsg")
	public boolean clickAddMsg()
	 {
		 String ms = this.addMsg.getText();
			String msg = ms.replaceAll("\\s+", "");
			String compareMsg = "HierarchyStructure:automation_1addedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	@Step("Click ModifyMsg")
	public boolean clickModifyMsg()
	 {
		 String ms = this.modifyMsg.getText();
			String msg = ms.replaceAll("\\s+", "");
			String compareMsg = "HierarchyStructure:automation_1modifiedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	@Step("Click DeleteMsg")
	public boolean clickDeleteMsg()
	 {
		 String ms = this.deleteMsg.getText();
			String msg = ms.replaceAll("\\s+", "");
			String compareMsg = "HierarchyStructure:automation_1deletedsuccessfully";
			boolean check = msg.equals(compareMsg);
			return check;
	 }
	@Step("Click Modify For Clear")
	public void clickModifyForClear()
	{
		this.modifyForClear.click();
	}
	@Step("Click Clear")
	public void clickClear()
	{
		this.clear.click();
	}
	
	@Step("Get Hierarchy List")
	public List<String> getHierarchyList() {
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList<String>();
		col = this.hierarchyList;
		int len = col.size();
		for (int i = 0; i < len; i++) {
			teamsList.add(this.hierarchyList.get(i).getText().replaceAll("\\s+", ""));
		}
		return teamsList;
	}
	
	@Step("Get Hierarchy List")
	public void clickExcelExport()
	{
		this.excel.click();
	}
	
	@Step("Get PdfExport")
	public void clickPdfExport()
	{
		this.pdf.click();
	}
	
	@Step("Click Title RequiredMsg")
	public boolean clickTitleRequiredMsg() throws InterruptedException {
		Thread.sleep(2000);
		String ms = this.popupMsg.getText();
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "Titleisrequiredinformation";
		boolean check = msg.equals(compareMsg);
		return check;
	}
	
	@Step("Get Hierarchy Active List")
	public List<String> getHierarchyActiveList() {
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList<String>();
		col = this.activeList;
		int len = col.size();
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.activeList.get(i).getText().replaceAll("\\s+", ""));
		}
		return teamsList;
	}
	@Step("Click analytics")
	public void clickanalytics()
	{
		//this.analytics.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.analytics);
	}
	@Step("SwitchTabs")
	public void switchTabs() {

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));

	}
	

	@Step("scroll SideNavigationBar In Advanced Analytics")
	public void scrollSideNavigationBarInAdvancedAnalytics() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a/span[contains(text(),'Administration')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
	}
	
	@Step("Click Advanced Anayltics Side NavigationArrow")
	public void clickAdvancedAnaylticsSideNavigationArrow()
	{
		this.advancedAnaylticsSideNavigationArrow.click();

	}
	
	@Step("Click Work Trends")
	public void clickWorkTrends()
	{
		this.workTrends.click();
	}
	
	@Step("Click Advance Page Hierarchy")
	public void clickAdvancePageHierarchy()
	{
		this.advancePageHierarchy.click();
	}
	
	@Step("Click Advance Page Hierarchy")
	public List<String> getAdvanceHierarchyList() {
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList<String>();
		col = this.hierarchyStructureList;
		int len = col.size();
		for (int i = 0; i < len; i++) {
			teamsList.add(this.hierarchyStructureList.get(i).getText().replaceAll("\\s+", ""));
		}
		return teamsList;
	}
	@Step("Click Hierarchy Mapping")
	public void clickHierarchyMapping()
	{
		this.hierarchyMapping.click();
	}
	
	@Step("Click Bulkupload")
	public void clickBulkupload()
	{
		this.bulkUpload.click();
	}
	
	@Step("Click Template With Data")
	public void clickTemplateWithData()
	{
		this.templateWithData.click();
	}
	
	@Step("Click ClickHereBtn")
	public void clickClickHereBtn()
	{
		this.clickHere.click();
	}
	@Step("click ChooseFileBtn")
	public String clickChooseFileBtn(String url) throws InterruptedException {
		WebElement  choose = this.chooseFileBtn;
		choose.sendKeys(url);
		this.upload.click();
		return url; 

	}
}
