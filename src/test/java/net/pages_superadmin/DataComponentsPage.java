package net.pages_superadmin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class DataComponentsPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//img[@src=\"/prohance/images/attachment.png\"]")
	WebElement fileImg;
	
	@FindBy(xpath = "//img[@src=\"/prohance/images/plus.png\"]")
	WebElement plusImg;
	
	@FindBy(xpath = "//img[@src=\"/prohance/images/minus.png\"]")
	WebElement minusImg;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[1]")
	List<WebElement> nameList;
	
	@FindBy(xpath = "//table[@class =\"table PHDataTable configdatatable dataTable no-footer\"]/thead/tr/th[1]")
	WebElement nameSort;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[1]")
	List<WebElement> nameSortedList;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[4]")
	List<WebElement> componentTypeList;
	
	@FindBy(xpath = "//table[@class =\"table PHDataTable configdatatable dataTable no-footer\"]/thead/tr/th[4]")
	WebElement componentTypeSort;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[4]")
	List<WebElement> componentTypeSortedList;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[5]")
	List<WebElement> lastHeartBeatList;
	
	@FindBy(xpath = "//table[@class =\"table PHDataTable configdatatable dataTable no-footer\"]/thead/tr/th[5]")
	WebElement lastHeartBeatSort;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[5]")
	List<WebElement> lastHeartBeatSortedList;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> hostNameList;
	
	@FindBy(xpath = "//table[@class =\"table PHDataTable configdatatable dataTable no-footer\"]/thead/tr/th[2]")
	WebElement hostNameSorted;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> hostNamesoretdList;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> portList;
	
	@FindBy(xpath = "//table[@class =\"table PHDataTable configdatatable dataTable no-footer\"]/thead/tr/th[2]")
	WebElement portSorted;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> portsoretdList;
	
	@FindBy(xpath = "//div[@id =\"CommonDataTableId_wrapper\"]/div/button/span[contains(text(),\"REFRESH\")]")
	WebElement refreshBtn;
	
	
	
	public DataComponentsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@Step("Click on Fill image")
	public void clickFileImg()
	{
		this.fileImg.click();
	}
	
	@Step("Click on plus image")
	public void clickPlusImg()
	{
		this.plusImg.click();
	}
	
	@Step("Click on minus image")
	public void clickMinusImg()
	{
		this.minusImg.click();
	}
	
	@Step("Get the name list")
	public List<String> getNameLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.nameList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.nameList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on name to sort")
	public void clickNameSort()
	{
		this.nameSort.click();
	}
	
	@Step("Get the name sorted list")
	public List<String> getNameSortedLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.nameSortedList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.nameSortedList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}

	@Step("Get the component list")
	public List<String> getComponentTypeLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.componentTypeList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.componentTypeList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on component type to sort")
	public void clickComponentTypeSort()
	{
		this.componentTypeSort.click();
		this.componentTypeSort.click();
	}
	
	@Step("Get the component type sorted list")
	public List<String> getComponentTypeSortedLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.componentTypeSortedList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.componentTypeSortedList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Get the lats heartbeat list")
	public List<String> getlastHeartBeatLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.lastHeartBeatList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.lastHeartBeatList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on last heartbeat to sort")
	public void clickLastHeartBeatSort()
	{
		this.lastHeartBeatSort.click();
		this.lastHeartBeatSort.click();
		
	}
	
	@Step("Get the last heartbeat sorted list")
	public List<String> getlastHeartBeatSortedLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.lastHeartBeatSortedList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.lastHeartBeatSortedList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Get host anme list")
	public List<String> gethostNameLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.hostNameList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.hostNameList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on host name to sort")
	public void clickHostNameSorted()
	{
		this.hostNameSorted.click();
		this.hostNameSorted.click();
	}
	
	@Step("Get the host name sorted list")
	public List<String> getHostNameSortedLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.hostNamesoretdList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.hostNamesoretdList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Get the port list")
	public List<String> getPortList() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.portList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.portList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on port to sort")
	public void clickPortSorted()
	{
		this.portSorted.click();
		this.portSorted.click();
	}
	
	@Step("Get the port sorted list")
	public List<String> getPortSortedLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.portsoretdList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.portsoretdList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on refresh btn")
	public void clickRefreshBtn()
	{
		this.refreshBtn.click();
		this.refreshBtn.getAccessibleName();
		System.out.println(this.refreshBtn.getAccessibleName());
	}
	
}
