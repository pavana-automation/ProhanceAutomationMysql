package net.pages_superadmin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class GlobalTimeZonePage {

	WebDriver driver;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td[1]/span[1]/i")
	WebElement modifyBtn;

	@FindBy(xpath = "//li[contains(text(),'Global Time Zones')]")
	WebElement globalTimeZones;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td[3]/span[2]/span/input[2]")
	WebElement aliaseName;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td[1]/span[2]/i[1]")
	WebElement saveBtn;

	@FindBy(xpath = "//span[@id=\"alert-msg-success\"]/span/span")
	WebElement modifyMessgae;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[6]/span/i/span[contains(text(),\"Active\")]")
	List<WebElement> activeCount;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[6]/span/i/span[contains(text(),\"Active\")]")
	WebElement active;

	@FindBy(xpath = "//div[contains(text(),\"Time Zone status for Dateline Standard Time cannot be changed as it is associated to  User(s)\")]")
	WebElement activeMessage;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[6]/span/i/span[contains(text(),\"Inactive\")]")
	List<WebElement> inactiveCount;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[6]/span/i/span[contains(text(),\"Inactive\")]")
	WebElement inactive;
	
	@FindBy(xpath = "//span[@id =\"messagesuccessspan\"]/span[contains(text(),\"Time Zone status for Hawaiian Standard Time modified successfully\")]")
	WebElement inactiveMessage;
	
	@FindBy(xpath = "//td[contains(text(),\"Hawaiian Standard Time\")]/../td[6]/span/i")
	WebElement activeToinctive;
	
	@FindBy(xpath = "//img[@src=\"/prohance/images/excel.png\"]")
	WebElement excelImg;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> timeZoneList;

	@FindBy(xpath = "//img[@src=\"/prohance/images/pdf.png\"]")
	WebElement pdfImg;
	
	@FindBy(xpath = "//div[@id =\"CommonDataTableId_filter\"]/label/input")
	WebElement search;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[4]")
	List<WebElement> searchList ;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> nameSortList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[2]")
	WebElement nameSort;
	
	@FindBy(name = "CommonDataTableId_length")
	WebElement rescordTodisplay;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[3]")
	List<WebElement> aliaseNameSortList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[3]")
	WebElement aliaseNameSort;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[4]")
	List<WebElement> referenceIdSortingList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[4]")
	WebElement referenceIdSort;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[5]")
	List<WebElement> offSetSortingList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[5]")
	WebElement offSetSort;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[6]/span/i/span")
	List<WebElement> statusSortList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[6]")
	WebElement statusSort;
	
	public GlobalTimeZonePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@Step("Click on Global Time Zone modify message")
	public void clickModifyIcon() {
		this.modifyBtn.click();
	}

	@Step("Click on timezone alise name and change the name")
	public void clickAliaseName(String time) {
		this.aliaseName.clear();
		this.aliaseName.sendKeys(time);

	}
    
	@Step("Click on Save btn")
	public void clickSaveBtn() {
		this.saveBtn.click();
	}
	
	@Step("Verify the timezone success message")
	public boolean clickAddMsg() {
		String ms = this.modifyMessgae.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		System.out.println(msg);
		String compareMsg = "TimeZone:(GMT-12:01)DatelineStandardTimeModifiedsuccessfully";
		boolean check = msg.equals(compareMsg);
		System.out.println(check);
		return check;
	}
	
	@Step("Get the active timezone count")
	public int getActiveTimeZoneCount() {
		int count = this.activeCount.size();
		System.out.println(count);
		return count;
	}
	
	@Step("Click on active time zone")
	public void clickOnActivetimeZone() {
		// this.active.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.active);
	}
	
	@Step("Verify the active timezone success message")
	public boolean clickActivedMsg() {
		String ms = this.activeMessage.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		System.out.println(msg);
		String compareMsg = "TimeZonestatusforDatelineStandardTimecannotbechangedasitisassociatedtoUser(s)";
		boolean check = msg.equals(compareMsg);
		System.out.println(check);
		return check;
	}
	
	@Step("Get inactive timezone count")
	public int getInactiveTimeZoneCount() {
		int count = this.inactiveCount.size();
		System.out.println(count);
		return count;
	}
	
	@Step("Click on Inactive timezone")
	public void clickOnInactivetimeZone() {
		// this.active.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.inactive);
	}
	
	@Step("Verify the inactive timezone success message")
	public boolean clickInactivedMsg() {
		String ms = this.inactiveMessage.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		System.out.println(msg);
		String compareMsg = "TimeZonestatusforHawaiianStandardTimemodifiedsuccessfully";
		boolean check = msg.equals(compareMsg);
		System.out.println(check);
		return check;
	}
	
	@Step("Change inactive to active timezone")
	public void clickActiveToInactive()
	{
		//this.activeToinctive.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.activeToinctive);
	}
	
	@Step("Click on Excel image download")
	public void cliclExcel() {
		this.excelImg.click();
	}
	
	@Step("List if time zone")
	public List<String> getTimeZoneLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.timeZoneList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.timeZoneList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on PDF image to download")
	public void clickPdfImg() {
		this.pdfImg.click();
	}
	
	@Step("Click on search")
	public void clickSearch(String service)
	{
		this.search.sendKeys(service);
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
		 if(teamsList.get(i).contains("Pacific/Niue"))
		  {
			validate = true;
			
		  }
		}
		Assert.assertTrue(validate);
	}
	
	@Step("List after soring")
	public List<String> nameSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.nameSortList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.nameSortList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on Service name to sort")
	public void clickNameSorting()
	{
		//System.out.println("enter"+this.serviceNameSort);
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.nameSort);
	}
	
	@Step("Select on records to display")
	public void selectRecordToDisplay(String rescordTodisplay) {
		Select clickAllocatedToOrg = new Select(this.rescordTodisplay);
		clickAllocatedToOrg.selectByVisibleText(rescordTodisplay);
	}

	@Step("List after soring")
	public List<String> afterNameSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList = new ArrayList();
		col = this.nameSortList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.nameSortList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}
		Collections.sort(teamsList);
		System.out.println("after sort"+ teamsList);
		for(String str: teamsList) 
			sortingList.add(str);
		System.out.println( sortingList);
		return sortingList;
	}
	
	@Step("Click on Aliase name to sort")
	public void clickAliaseNameSorting()
	{
		//System.out.println("enter"+this.serviceNameSort);
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.aliaseNameSort);
	}
	

	@Step("List after soring")
	public List<String> afterAliaseNameSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList = new ArrayList();
		col = this.aliaseNameSortList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.aliaseNameSortList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}
		Collections.sort(teamsList);
		System.out.println("after sort"+ teamsList);
		for(String str: teamsList) 
			sortingList.add(str);
		System.out.println( sortingList);
		return sortingList;
	}
	
	@Step("List after soring")
	public List<String> aliaseNameSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.aliaseNameSortList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.aliaseNameSortList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on Reference id to sort")
	public void clickReferenceIdSorting()
	{
		//System.out.println("enter"+this.serviceNameSort);
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.referenceIdSort);
	}
	

	@Step("List after soring")
	public List<String> afterReferenceIdSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList = new ArrayList();
		col = this.referenceIdSortingList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.referenceIdSortingList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}
		Collections.sort(teamsList);
		System.out.println("after sort"+ teamsList);
		for(String str: teamsList) 
			sortingList.add(str);
		System.out.println( sortingList);
		return sortingList;
	}
	
	@Step("List after soring")
	public List<String> referenceIdSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.referenceIdSortingList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.referenceIdSortingList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on Offset to sort")
	public void clickOffsetSorting()
	{
		//System.out.println("enter"+this.serviceNameSort);
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.offSetSort);
	}
	

	@Step("List after soring")
	public List<String> afterOffsetSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList = new ArrayList();
		col = this.offSetSortingList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.offSetSortingList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}
		Collections.sort(teamsList);
		System.out.println("after sort"+ teamsList);
		for(String str: teamsList) 
			sortingList.add(str);
		System.out.println( sortingList);
		return sortingList;
	}
	
	@Step("List after soring")
	public List<String> offsetSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.offSetSortingList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.offSetSortingList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on Offset to sort")
	public void clickStatusSorting()
	{
		//System.out.println("enter"+this.serviceNameSort);
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.statusSort);
	}
	

	
	@Step("List after soring")
	public List<String> afterStatusSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList =new ArrayList();
		col = this.statusSortList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.statusSortList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}
		Collections.sort(teamsList);
		System.out.println("after sort"+ teamsList);
		for(String str: teamsList) 
			sortingList.add(str);
		System.out.println( sortingList);
		return sortingList;
	}
	
	
	@Step("List after soring")
	public List<String> statusSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList =null;
		col = this.statusSortList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.statusSortList.get(i).getText().replaceAll("\\s+", ""));
			 System.out.println( teamsList.add(this.statusSortList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}

}
