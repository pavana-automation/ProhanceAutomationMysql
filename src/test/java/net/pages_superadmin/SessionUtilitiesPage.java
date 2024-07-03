package net.pages_superadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class SessionUtilitiesPage {
	
	WebDriver driver;
	
	
	@FindBy(id= "orgId")
	WebElement selectOrganization;
	
	@FindBy(id= "displayOption")
	WebElement selectTimeZone;
	
	@FindBy(id= "userId")
	WebElement selectUser;
	
	@FindBy(id= "fromDateId")
	WebElement datePicker;
	
	@FindBy(xpath= "//table[@class =\" table-condensed\"]/thead/tr/th[2]")
	WebElement clickOnYear;
	
	@FindBy(xpath= "//table[@class =\"table-condensed\"]/thead/tr/th[1]/i")
	WebElement clickOnFrontBtn;
	
	@FindBy(xpath= "//table[@class =\"table-condensed\"]/tbody/tr/td/span[2]")
	WebElement selectMonth;
	
	@FindBy(xpath= "//table[@class =\" table-condensed\"]/tbody/tr[2]/td[3]")
	WebElement selectDay;
	
	@FindBy(id= "fetchButton")
	WebElement fetchBtn;
	
	@FindBy(id= "actionValue")
	WebElement selectAction;
	
	@FindBy(xpath= "//form[@name=\"UtilityForm\"]/div/div[2]/span[3]/input")
	WebElement goBtn;
	
	@FindBy(xpath= "//div[contains(text(),\"Action cannot be performed as no record is selected.\")]")
	WebElement warningMsg;
	
	
	@FindBy(xpath= "//form[@name=\"UtilityForm\"]/div/div[2]/span[2]")
	WebElement downloadBtn;
	
	public SessionUtilitiesPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@Step("Select on organization")
	public void selectOrganization(String organization) {
		Select clickAllocatedToOrg = new Select(this.selectOrganization);
		clickAllocatedToOrg.selectByVisibleText(organization);
	}
	
	@Step("Select on Users ")
	public void selectUser(String user) {
		Select clickAllocatedToOrg = new Select(this.selectUser);
		clickAllocatedToOrg.selectByVisibleText(user);
	}
	
	@Step("Select on Time zone")
	public void selectTimeZone(String timeZone) {
		Select clickAllocatedToOrg = new Select(this.selectTimeZone);
		clickAllocatedToOrg.selectByVisibleText(timeZone);
	}
	
	@Step("Click on date picker")
	public void clickDatePicker()
	{
		this.datePicker.click();
	}
	
	@Step("Click on Year")
	public void clickOnYear()
	{
		this.clickOnYear.click();
	}
	
	@Step("Click on front button")
	public void clickOnFrontBtn()
	{
		this.clickOnFrontBtn.click();
	}
	
	@Step("Click on Month")
	public void selectMonth()
	{
		this.selectMonth.click();
	}
	
	@Step("Click on Day")
	public void selectDay()
	{
		this.selectDay.click();
	}
	
	@Step("Click on Day")
	public void ClickFetchBtn()
	{
		this.fetchBtn.click();
	}
	
	@Step("Select on action")
	public void selectAction(String action) {
		Select clickAllocatedToOrg = new Select(this.selectAction);
		clickAllocatedToOrg.selectByVisibleText(action);
	}
	
	@Step("Click on Go button")
	public void clickOnGoBtn()
	{
		this.goBtn.click();
	}
	
	@Step("Verify the partition mananger success message")
	public boolean clickSuccessMsg() {
		String ms = this.warningMsg.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "Actioncannotbeperformedasnorecordisselected.";
		boolean check = msg.equals(compareMsg);
		return check;
	}
	
	@Step("Click on Go button")
	public void clickOnDownloadBtn()
	{
		this.downloadBtn.click();
	}
}
