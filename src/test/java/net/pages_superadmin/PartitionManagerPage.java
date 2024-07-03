package net.pages_superadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class PartitionManagerPage {
	WebDriver driver;
	
	
	@FindBy(xpath = "//input[@name =\"clear\"]")
	WebElement clearBtn;
	
	@FindBy(id = "hourId")
	WebElement databasePartitionHour;
	
	@FindBy(id = "day_id")
	WebElement databasePartitionDate;
	
	@FindBy(id = "minuteId")
	WebElement databasePartitionMinute;
	
	@FindBy(id = "count_id")
	WebElement failurePartitionDay;
	
	@FindBy(id = "interval_id")
	WebElement interval;
	
	@FindBy(id = "sNotification")
	WebElement yesNotification;
	
	@FindBy(id = "fNotification")
	WebElement failNotification;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "rawDataMonth")
	WebElement rawDataMonth;
	
	@FindBy(id = "aggrDataMonth")
	WebElement aggrDataMonth;
	
	@FindBy(xpath = "//td[@class=\"tab-buttons\"]/input[2]")
	WebElement saveBtn;
	
	@FindBy(xpath = "//span[@id =\"dialogsuccessspan\"]/span/span")
	WebElement msg;
	
	@FindBy(id = "alert-model-body")
	WebElement emailMissed;
	
	public PartitionManagerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@Step("Click on clear btn")
	public void clickClearBtn()
	{
		this.clearBtn.click();
	}
	
	@Step("Select date")
	public void selectDate(String date) {
		Select clickDate = new Select(this.databasePartitionDate);
		clickDate.selectByVisibleText(date);
	}
	
	@Step("Select hour")
	public void selectHour(String hour) {
		Select clickHour = new Select(this.databasePartitionHour);
		clickHour.selectByVisibleText(hour);
	}
	
	@Step("Select minutes")
	public void selectMinute(String minute) {
		Select clickMinute = new Select(this.databasePartitionMinute);
		clickMinute.selectByVisibleText(minute);
	}
	
	@Step("Select partition day ")
	public void selectFailurePartitionDay(String day) {
		Select clickMinute = new Select(this.failurePartitionDay);
		clickMinute.selectByVisibleText(day);
	}
	
	@Step("Select interval")
	public void selectInterval(String interval) {
		Select clickInterval = new Select(this.interval);
		clickInterval.selectByVisibleText(interval);
	}
	
	@Step("Click on Yes notification")
	public void clickYesNotification() throws InterruptedException
	{
		this.yesNotification.click();
		Thread.sleep(2000);
		this.yesNotification.click();
	}
	
	@Step("Click on Fail Notification")
	public void clickFailNotification() throws InterruptedException
	{
		this.failNotification.click();
		Thread.sleep(2000);
		this.failNotification.click();
	}
	
	@Step("Enter the email")
	public void email(String email)
	
	{
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	@Step("Select raw data month")
	public void selectRawDataMonth(String rawDataMonth) {
		this.rawDataMonth.clear();
		this.rawDataMonth.sendKeys(rawDataMonth);
		
	}
	
	@Step("Enter the aggregation data month")
	public void selectAggrDataMonth(String aggrDataMonth) {
		this.aggrDataMonth.clear();
		this.aggrDataMonth.sendKeys(aggrDataMonth);
		
	}
	
	@Step("Click on Save btn")
	public void clickSaveBtn()
	{
		this.saveBtn.click();
	}
	
	@Step("Verify the partition mananger success message")
	public boolean clickSuccessMsg() {
		String ms = this.msg.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "PartitionManagerhasbeenupdatedsuccessfully.";
		boolean check = msg.equals(compareMsg);
		return check;
	}
	
	@Step("Verify the email required filed ")
	public boolean clickEmailMissed() {
		String ms = this.emailMissed.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "Emailrecipient'isrequiredinformation.";
		boolean check = msg.equals(compareMsg);
		return check;
	}
	@Step("Verify invalid denail message")
	public boolean clickManyEmailMissed() {
		String ms = this.emailMissed.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "InvalidEmailId.";
		boolean check = msg.equals(compareMsg);
		return check;
	}
}
