package net.pages_superadmin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class CustomAdapter {
	
	WebDriver driver;
	
	@FindBy(id = "addNewBtn")
	WebElement addNew;
	
	@FindBy(id = "customDates")
	WebElement customDate;
	
	@FindBy(xpath = "//span/input[@value=\"SUBMIT\"]")
	WebElement submitBtn;
	
	@FindBy(xpath = "//div[contains(text(),\"Invalid Time format: 22-Apr-2024\")]")
	WebElement dateVerify;
	
	@FindBy(xpath = "//div[contains(text(),\"Enter valid date and time, Custom date/time can not be empty.\")]")
	WebElement dateVerifyMSSQL;
	
	@FindBy(xpath = "//div[contains(text(),\"Invalid Custom Date format: 21Apr2024;22Apr2024\")]")
	WebElement multipleDateVerify;
	
	@FindBy(xpath = "//div[contains(text(),\"Enter valid date and time, Custom date/time can not be empty.\")]")
	WebElement multipleDateVerifyMSSQL;
	
	@FindBy(xpath = "//div[contains(text(),\"Invalid Custom Date format: 12Apr2024_22Apr2024\")]")
	WebElement dateRangeVerify;
	
	@FindBy(xpath = "//div[contains(text(),\"Enter valid date and time, Custom date/time can not be empty.\")]")
	WebElement dateRangeVerifyMSSQL;
	
	@FindBy(xpath = "//span/input[@value=\"CANCEL\"]")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//div[contains(text(),\"Enter valid date and time, Custom date/time can not be empty.\")]")
	WebElement requiredField;
	
	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr/td[1]")
	List<WebElement> customList;
	
	@FindBy(xpath = "//img[@src=\"/prohance/images/excel.png\"]")
	WebElement excelImg;
	
	@FindBy(xpath = "//img[@src=\"/prohance/images/pdf.png\"]")
	WebElement pdfImg;
	
	public CustomAdapter(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@Step("Click on Add new btn")
	public void clickAddNewBtn()
	{
		this.addNew.click();
	}
	
	@Step("Enter the date")
	public void clickCustomDate(String date)
	{
		this.customDate.sendKeys(date);
	}
    
	@Step("Clcik on Submit btn")
	public void clickSubmitBtn()
	{
		this.submitBtn.click();
	}
	
	@Step("Verify the date valid popup message")
	public boolean getMsg() 
	{
			String ms = this.dateVerify.getText();
			System.out.println(ms);
			String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
			String compareMsg = "InvalidTimeformat:22-Apr-2024";
			boolean check = msg.equals(compareMsg);
			return check;

	}
	
	@Step("Verify the date valid popup messages")
	public boolean getMsgmssql() 
	{
			String ms = this.dateVerifyMSSQL.getText();
			System.out.println(ms);
			String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
			String compareMsg = "Enter valid date and time, Custom date/time can not be empty.";
			boolean check = msg.equals(compareMsg);
			return check;

	}
	
	@Step("Verify the multiple date imvalid message")
	public boolean getMultipleDateMsg() 
	{
			String ms = this.multipleDateVerify.getText();
			System.out.println(ms);
			String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
			String compareMsg = "Invalid Custom Date format: 21Apr2024;22Apr2024";
			boolean check = msg.equals(compareMsg);
			return check;

	}
	
	@Step("Verify the multiple date imvalid message")
	public boolean getMultipleDateMsgMssql() 
	{
			String ms = this.multipleDateVerifyMSSQL.getText();
			System.out.println(ms);
			String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
			String compareMsg = "Enter valid date and time, Custom date/time can not be empty.";
			boolean check = msg.equals(compareMsg);
			return check;

	}
	
	@Step("Verify the date invalid range")
	public boolean getDateRangeMsg() 
	{
			String ms = this.dateRangeVerify.getText();
			System.out.println(ms);
			String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
			String compareMsg = "Invalid Custom Date format: 12Apr2024_22Apr2024";
			boolean check = msg.equals(compareMsg);
			return check;

	}
	
	@Step("Verify the date invalid range")
	public boolean getDateRangeMsgmssql() 
	{
			String ms = this.dateRangeVerifyMSSQL.getText();
			System.out.println(ms);
			String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
			String compareMsg = "Enter valid date and time, Custom date/time can not be empty.";
			boolean check = msg.equals(compareMsg);
			return check;

	}
	
	@Step("Click on clear btn")
	public void clickClearbtn()
	{
		this.cancelBtn.click();
	}
	
	@Step("Verify the date required field message")
	public boolean getRequiredField() 
	{
			String ms = this.requiredField.getText();
			System.out.println(ms);
			String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
			String compareMsg = "Enter valid date and time, Custom date/time can not be empty.";
			boolean check = msg.equals(compareMsg);
			return check;

	}
	
	@Step("Verify the date required field message")
	public List<String> getCustomLists() throws InterruptedException {

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList();
		col = this.customList;
		int len = col.size();
		System.out.println(len);
		Thread.sleep(1000);
		for (int i = 0; i < len; i++) {
			teamsList.add(this.customList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println( teamsList.add(this.getUserArrtribute.get(i).getText()));
		}

		System.out.println(teamsList);
		return teamsList;
	}
	
	@Step("Click on excel image")
	public void clickExcel()
	{
		this.excelImg.click();
	}
    
	@Step("Click on PDF image")
	public void clickPdf()
	{
		this.pdfImg.click();
	}
	
}
