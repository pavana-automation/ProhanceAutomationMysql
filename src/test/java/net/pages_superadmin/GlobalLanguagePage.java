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

public class GlobalLanguagePage {
	
WebDriver driver;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td[1]/span[1]/i")
	WebElement modifyBtn;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td[3]/span[2]/span/input[2]")
	WebElement aliaseName;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td[1]/span[@id=\"save_1\"]/i[1]")
	WebElement saveBtn;
	
	@FindBy(xpath = "//span[@id=\"alert-msg-success\"]/span/span")
	WebElement modifyMessgae;
	
	@FindBy(xpath = "//img[@src=\"/prohance/images/excel.png\"]")
	WebElement excelImg;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> lanuageList;

	@FindBy(xpath = "//img[@src=\"/prohance/images/pdf.png\"]")
	WebElement pdfImg;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[4]/span/i/span[contains(text(),\"Active\")]")
	List<WebElement> activeCount;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[4]/span/i/span[contains(text(),\"Active\")]")
	WebElement active;

	@FindBy(xpath = "//div[contains(text(),\"Default language cannot be inactivated\")]")
	WebElement activeMessage;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[6]/span/i/span[contains(text(),\"Inactive\")]")
	List<WebElement> inactiveCount;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[6]/span/i/span[contains(text(),\"Inactive\")]")
	WebElement inactive;
	
	@FindBy(xpath = "//span[@id =\"messagesuccessspan\"]/span[contains(text(),\"Time Zone status for Hawaiian Standard Time modified successfully\")]")
	WebElement inactiveMessage;
	
	@FindBy(xpath = "//td[contains(text(),\"Hawaiian Standard Time\")]/../td[6]/span/i")
	WebElement activeToinctive;
	
	@FindBy(xpath = "//div[@id =\"CommonDataTableId_filter\"]/label/input")
	WebElement search;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> searchList ;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> nameSortList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[2]")
	WebElement nameSort;
	
	@FindBy(name = "CommonDataTableId_length")
	WebElement rescordTodisplay;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[3]")
	List<WebElement> aliasenNameSortList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[3]")
	WebElement aliaseNameSort;
	

	public GlobalLanguagePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@Step("Click on Global langauge modify btn")
	public void clickModifyIcon() {
		this.modifyBtn.click();
	}
    
	@Step("Click on Language aliase name and modify the name")
	public void clickAliaseName(String time) {
		this.aliaseName.clear();
		this.aliaseName.sendKeys(time);

	}

	@Step("Click on Save Btn")
	public void clickSaveBtn() {
		this.saveBtn.click();
	}
	
	@Step("Verify the modification success message")
	public boolean clickAddMsg() {
		String ms = this.modifyMessgae.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		System.out.println(msg);
		String compareMsg = "GlobalLanguage:English1Modifiedsuccessfully";
		boolean check = msg.equals(compareMsg);
		System.out.println(check);
		return check;
	}
	
	@Step("Click on Excel image to download")
	public void cliclExcel() {
		this.excelImg.click();
	}
	
	@Step("List of Global Language")
	public List<String> getLanguageLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.lanuageList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.lanuageList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on PDF image to download")
	public void clickPdfImg() {
		this.pdfImg.click();
	}
	
	@Step("Get the active langauge count")
	public int getActiveLanguageCount() {
		int count = this.activeCount.size();
		System.out.println(count);
		return count;
	}
	
	@Step("Click on Active Language")
	public void clickOnActiveLanguage() {
		// this.active.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.active);
	}
    
	@Step("Verify the Language activate message")
	public boolean clickActivedMsg() {
		String ms = this.activeMessage.getText();
		System.out.println("ms"+ms);
		String msg = ms.replaceAll("\\s+", "");
		System.out.println("ms"+msg);
		String compareMsg = "Defaultlanguagecannotbeinactivated";
		boolean check = msg.equals(compareMsg);
		System.out.println(check);
		return check;
	}
	
	@Step("Get inactive laguage count")
	public int getInactiveTimeZoneCount() {
		int count = this.inactiveCount.size();
		System.out.println(count);
		return count;
	}
	
	@Step("Click on Inactibve language")
	public void clickOnInactivetimeZone() {
		// this.active.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.inactive);
	}
	
	@Step("Verify the Inactive message")
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
	
	@Step("Change active to inactive language")
	public void clickActiveToInactive()
	{
		//this.activeToinctive.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.activeToinctive);
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
		 if(teamsList.get(i).contains("French"))
		  {
			validate = true;
			
		  }
		}
		Assert.assertTrue(validate);
	}
	
	@Step("List after name soring")
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
		
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.nameSort);
		  JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		  executor1.executeScript("arguments[0].click();", this.nameSort);
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
	
	@Step("List after aliase name soring")
	public List<String> aliseNameSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.aliasenNameSortList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.aliasenNameSortList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on aliase name to sort")
	public void clickAliaseNameSorting()
	{
		
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.aliaseNameSort);
		  JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		  executor1.executeScript("arguments[0].click();", this.aliaseNameSort);
	}
	
	@Step("List  alise name soring ")
	public List<String> afterAliaseNameSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList = new ArrayList();
		col = this.aliasenNameSortList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.aliasenNameSortList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}
		Collections.sort(teamsList);
		System.out.println("after sort"+ teamsList);
		for(String str: teamsList) 
			sortingList.add(str);
		System.out.println( sortingList);
		return sortingList;
	}
	
}
