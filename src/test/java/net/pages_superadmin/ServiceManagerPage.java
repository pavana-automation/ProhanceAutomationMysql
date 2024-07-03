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


public class ServiceManagerPage {
	
	WebDriver driver;

	
	@FindBy(xpath = "//input[@type=\"search\"]")
	WebElement search;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[1]")
	List<WebElement> searchList ;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[1]")
	List<WebElement> serviceNameBeforeSoring;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[1]")
	List<WebElement> serviceName;
	
	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]")
	List<WebElement> serviceStatus;

	@FindBy(xpath = "//table[@class =\"dataTable no-footer\"]/thead/tr/th[1]")
	WebElement serviceNameSort;
	
	@FindBy(name = "CommonDataTableId_length")
	WebElement rescordTodisplay;
	
	public ServiceManagerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

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
			teamsList.add(this.searchList.get(i).getText().replaceAll("\\s+", "").toLowerCase());
		}
		System.out.println(teamsList);
		for(int i = 0; i <teamsList.size();i++ )
		{
		 if(teamsList.get(i).contains("workflow"))
		  {
			validate = true;
			
		  }
		}
		Assert.assertTrue(validate);
	}

	@Step("Click on Service name to sort")
	public void clickServiceNameSorting()
	{
		//System.out.println("enter"+this.serviceNameSort);
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.serviceNameSort);
	}
	
	@Step("List after soring")
	public List<String> serviceNameSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.serviceName;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.serviceName.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Select on records to display")
	public void selectRecordToDisplay(String rescordTodisplay) {
		Select clickAllocatedToOrg = new Select(this.rescordTodisplay);
		clickAllocatedToOrg.selectByVisibleText(rescordTodisplay);
	}
	
	@Step("List before Sorting")
	public List<String> serviceNamebeforeSorting() throws InterruptedException
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		List<String> sortingList = new ArrayList();
		col = this.serviceName;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.serviceName.get(i).getText().replaceAll("\\s+", ""));
			 //System.out.println( teamsList.add(this.clientsList.get(i).getText()));
		}

		System.out.println("after sort");
		Collections.sort(teamsList);
		for(String str: teamsList) 
			sortingList.add(str);
		System.out.println("after sort" + sortingList);
		return sortingList;
	}
}
