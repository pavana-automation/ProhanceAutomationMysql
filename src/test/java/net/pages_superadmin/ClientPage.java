package net.pages_superadmin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class ClientPage {
	WebDriver driver;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[1]")
	List<WebElement> clientsList;
	
	@FindBy(xpath = "//img[@src=\"/prohance/images/excel.png\"]")
	WebElement excelImg;
	
	@FindBy(xpath = "//img[@src=\"/prohance/images/pdf.png\"]")
	WebElement pdfImg;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[3]/span")
	WebElement totalClients;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th")
	List<WebElement> reportColumnList;
	
	@FindBy(xpath = "//div[@id=\"navLinks\"]/label[2]")
	WebElement reportColumn;
	
	@FindBy(xpath = "//ul[@id=\"sortable2\"]/li")
	List<WebElement> reportColumnList1;
	
	@FindBy(id = "displayOption")
	WebElement unknownUsers;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[1]/div/span/div/div/input")
	WebElement selectClient;
	
	@FindBy(id = "allocateOrganization")
	WebElement allocatedToOrg;
	
	@FindBy(xpath = "//div[@id =\"unallocatedUsersLink\"]/span/input[@value =\"GO\"]")
	WebElement GoBtn;
	
	@FindBy(xpath = "//div[contains(text(),\"Please select an organization to allocate clients.\")]")
	WebElement fillOrgField;
	
	@FindBy(xpath = "//div[contains(text(),\"Please select the clients to allocate/unallocate.\")]")
	WebElement fillClientsField;
	
	@FindBy(xpath = "//span[@id =\"clientLogsLinkId\"]/a")
	WebElement clientLogBtn;
	
	@FindBy(xpath = "//b[contains(text(),\"JAMOCHA-L059_8541\")]")
	WebElement logs;
	
	@FindBy(xpath = "//div[@id =\"CommonDataTableId_filter\"]/label/input")
	WebElement search;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[1]")
	List<WebElement> searchList ;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[1]")
	List<WebElement> organizationSortList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[1]")
	WebElement organizationSort;
	
	@FindBy(name = "CommonDataTableId_length")
	WebElement rescordTodisplay;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> codeSortedList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[2]")
	WebElement codeSort;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[3]")
	List<WebElement> totaloClientsList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[3]")
	WebElement totalClientsSort;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[4]")
	List<WebElement> clientsAliveList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[4]")
	WebElement clientsAliveSort;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[5]")
	List<WebElement> clientsActiveList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[5]")
	WebElement clientsActiveSort;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[6]")
	List<WebElement> usersConnectedList;
	
	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[6]")
	WebElement usersConnectedSort;
	
	public ClientPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@Step("GEt Client List ")
	public List<String> getClintsList() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.clientsList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.clientsList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on excel image to download")
	public void clickExcelImg()
	{
		this.excelImg.click();
	}
	
	@Step("Click on PDF image to download")
	public void clickPDFImg()
	{
		this.pdfImg.click();
	}
	
	@Step("Click on Total clients")
	public void clickTotalClients()
	{
		this.totalClients.click();
	}
	
	@Step("Get report column list")
	public List<String> getReportColumnList() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.reportColumnList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 1; i < len-4; i++) {
			teamsList.add(this.reportColumnList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on report coulmn ")
	public void clickReportCloumn()
	{
		this.reportColumn.click();
	}
	
	@Step("Get report column list")
	public List<String> getReportColumnList1() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.reportColumnList1;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.reportColumnList1.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Select unknown users")
	public void selectClient(String unknownUsers) {
		Select clickUnknownUsers = new Select(this.unknownUsers);
		clickUnknownUsers.selectByVisibleText(unknownUsers);
	}
	
	@Step("Click on Select clients")
	public void clickSelectClient()
	{
		//this.selectClient.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.selectClient);
	}
	
	@Step("Select on sllocated org")
	public void selectAllocatedToOrg(String allocatedToOrg) {
		Select clickAllocatedToOrg = new Select(this.allocatedToOrg);
		clickAllocatedToOrg.selectByVisibleText(allocatedToOrg);
	}
	
	@Step("Click on Go btn")
	public void clickGOBtn()
	{
		this.GoBtn.click();
	}
	
	@Step("Verify Fill org field")
	public boolean clickMissingOrgFieldMsg() {
		String ms = this.fillOrgField.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "Pleaseselectanorganizationtoallocateclients.";
		boolean check = msg.equals(compareMsg);
		return check;
	}

	@Step("Verify  Fill client field")
	public boolean clickMissingClientFieldMsg() {
		String ms = this.fillClientsField.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "Pleaseselecttheclientstoallocate/unallocate.";
		boolean check = msg.equals(compareMsg);
		return check;
	}
	
	@Step("Click Client Log")
	public void clickClientsLogsBtn()
	{
		this.clientLogBtn.click();
	}
	
	@Step("Move the page")
	public void moveToAddPage() {

		String Tab1 = driver.getWindowHandle(); 
		System.out.println(Tab1);
		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles()); 
		if (!availableWindows.isEmpty()) { 
			driver.switchTo().window(availableWindows.get(0)); 
		}
		
	}
	
	@Step("Click on Logs")
	public void clicklogs()
	{
		//this.logs.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.logs);
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
		 if(teamsList.get(i).contains("Automation"))
		  {
			validate = true;
			
		  }
		}
		Assert.assertTrue(validate);
	}
	
	@Step("List after name soring")
	public List<String> organizationSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.organizationSortList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.organizationSortList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on Service name to sort")
	public void clickOrganizationSorting()
	{
		
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.organizationSort);
		  JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		  executor1.executeScript("arguments[0].click();", this.organizationSort);
	}
	
	@Step("Select on records to display")
	public void selectRecordToDisplay(String rescordTodisplay) {
		Select clickAllocatedToOrg = new Select(this.rescordTodisplay);
		clickAllocatedToOrg.selectByVisibleText(rescordTodisplay);
	}
	
	@Step("List after soring")
	public List<String> afterOrganizationSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList = new ArrayList();
		col = this.organizationSortList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.organizationSortList.get(i).getText().replaceAll("\\s+", ""));
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
	public List<String> codeoSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.codeSortedList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.codeSortedList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on aliase name to sort")
	public void clickCodeSorting()
	{
		
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.codeSort);
		  JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		  executor1.executeScript("arguments[0].click();", this.codeSort);
	}
	
	@Step("List after soring")
	public List<String> afterCodeSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList = new ArrayList();
		col = this.codeSortedList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.codeSortedList.get(i).getText().replaceAll("\\s+", ""));
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
	public List<String> totalClientsSort() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.totaloClientsList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.totaloClientsList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on aliase name to sort")
	public void clickTotalClientsSorting()
	{
		
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.totalClientsSort);
		
	}
	
	@Step("List after soring")
	public List<String> afterTotalClientsSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList = new ArrayList();
		col = this.totaloClientsList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.totaloClientsList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}
		Collections.sort(teamsList);
		System.out.println("after sort"+ teamsList);
		for(String str: teamsList) 
			sortingList.add(str);
		System.out.println(sortingList);
		return sortingList;
	}
	

	@Step("List after clients alive name soring")
	public List<String> clientsAliveSort() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.clientsAliveList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.clientsAliveList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	@Step("Click on aliase name to sort")
	public void clickClientsAliveSorting()
	{
		
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.clientsAliveSort);
		
	}
	
	@Step("List after soring")
	public List<String> afterClientsAliveSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList = new ArrayList();
		col = this.clientsAliveList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.clientsAliveList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}
		Collections.sort(teamsList);
		System.out.println("after sort"+ teamsList);
		for(String str: teamsList) 
			sortingList.add(str);
		System.out.println(sortingList);
		return sortingList;
	}
	@Step("List of clients active")
	public List<String> clientsActiveSort() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.clientsActiveList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.clientsActiveList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on aliase name to sort")
	public void clickClientsActiveSorting()
	{
		
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.clientsActiveSort);
		
	}
	
	@Step("List after soring")
	public List<String> afterClientsActiveSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList = new ArrayList();
		col = this.clientsActiveList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.clientsActiveList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}
		Collections.sort(teamsList);
		System.out.println("after sort"+ teamsList);
		for(String str: teamsList) 
			sortingList.add(str);
		System.out.println(sortingList);
		return sortingList;
	}
	
	@Step("List of users connected")
	public List<String> usersConnectedSort() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.usersConnectedList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.usersConnectedList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on aliase name to sort")
	public void clickUsersConnectedSorting()
	{
		
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.usersConnectedSort);
		
	}
	
	@Step("List after soring")
	public List<String> afterUsersConnectedSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList = new ArrayList();
		col = this.usersConnectedList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.usersConnectedList.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}
		Collections.sort(teamsList);
		System.out.println("after sort"+ teamsList);
		for(String str: teamsList) 
			sortingList.add(str);
		System.out.println(sortingList);
		return sortingList;
	}
}
