package net.pages_worktimemodule;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;

public class OrganizationSettingAdminPage
{
	WebDriver			driver;	
	CommonMethodsPage	commonMethodsPage	= new CommonMethodsPage(BaseTest.driver);

	@FindBy(id = "unconfiguredApplicationLabel")
	WebElement unConfiguredAOS;
	
	@FindBy(id= "unconfiguredAafsReference")
	WebElement unconfiguredAAFS;
	
	@FindBy(id= "weekStartDay")
	WebElement weekStartDay;
	
	@FindBy(id = "defaultWorkLoadCategory")
	WebElement defaultWorkLoadCategory;
	
	@FindBy(id = "defaultProductiveHoursLabel")
	WebElement defaultProductiveHoursLabel;
	
	@FindBy(id = "userGroupsLabel")
	WebElement userGroupsLabel;
	
	@FindBy(id = "superGroupsLabel")
	WebElement superGroupLabel;
	
	@FindBy(id = "allGroupsLabel")
	WebElement allGroupsLabel;
	
	@FindBy(id = "manager1Label")
	WebElement managerLabel1;
	
	@FindBy(id = "manager2Label")
	WebElement managerLabel2;
	
	@FindBy(id = "referenceIdLabel")
	WebElement referenceIdLabel;
	
	@FindBy(id = "notRatedLabel")
	WebElement notRatedLabel;
	
	@FindBy(id = "defaultworkshift")
	WebElement defaultworkshift;
	
	@FindBy(id = "userDropdownReference")
	WebElement  userDropdownReference;
	
	@FindBy(id = "hideRecipientY")
	WebElement hideRecipientYes;
	
	@FindBy(id = "hideRecipientN")
	WebElement hideRecipientNo;
	
	@FindBy(id = "showBlockedUsers1")
	WebElement showBlockedUsers1;
	
	@FindBy(id = "workshiftRadio")
	WebElement workshiftRadio;
	
	@FindBy(id = "worktemplateRadio")
	WebElement worktemplateRadio;
	
	@FindBy(id = "plRadio")
	WebElement plRadio;
	
	@FindBy(id = "abRadio")
	WebElement abRadio;
	
	@FindBy(id = "enableLeaveMgmtNotification1")
	WebElement enableLeaveMgmtNotification1;
	
	@FindBy(xpath = "//select[@name='reportSummary']")
	WebElement reportSummaryRecord;
	
	@FindBy(xpath = "//select[@name='configSummary']")
	WebElement reportofConfigSummary;
	
	@FindBy(id = "xlsRadio")
	WebElement xlsRadioBtn;
	
	@FindBy(id = "xlsxRadio")
	WebElement xlsxRadioBtn;
	
	@FindBy(id = "webDurationFormat")
	WebElement webDurationFormat;
	
	@FindBy(id = "exportDurationFormat")
	WebElement exportDurationFormat;
	
	@FindBy(id = "notificationReference")
	WebElement notificationReference;
	
	@FindBy(id = "enableAccessControlPermission1")
	WebElement enableAccessControlPermission1;
	
	@FindBy(id = "ragCodeConfigurationRestriction1")
	WebElement ragCodeConfigurationRestriction1;
	
	@FindBy(id = "orgLogoImageId")
	WebElement orgLogoImage;
	
	@FindBy(id = "clientLogoImageId")
	WebElement clientLogoImageId;
	
	@FindBy( id = "enableNoHBNotification1")
	WebElement enableNoHBNotification1;
	
	@FindBy(xpath = "//div[@id=\"tr_buttons\"]/input[2]")
	WebElement saveBtn;
	
	@FindBy(id = "pageSizeID")
	WebElement unknwn;
	
	
	
	
	
	public OrganizationSettingAdminPage(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@Step("Click On unConfigured AOS")
	public void clickOnunConfiguredAOS()
	{
		this.unConfiguredAOS.clear();
		this.unConfiguredAOS.sendKeys("Unknown AOS");
	}
	
	@Step("Click On unConfigured AFFS")
	public void clickOnunConfiguredAFFS()
	{
		this.unconfiguredAAFS.clear();
		this.unconfiguredAAFS.sendKeys("Unknown AAFS");
	}
	
	@Step("Click on Save Btn")
	public void clickOnSaveBtn()
	{
//		JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;
//		jsexecutour.executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		//commonMethodsPage.scrollElementToView(saveBtn);
		this.saveBtn.click();
	}
	
	@Step("click on WorkTime")
	public void clickWorkTime() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='WORK TIME']")).click();
		
	}
	
	@Step("click on ActivityDashboard")
	public void clickActivityDashBoard()
	{
		driver.findElement(By.xpath("//a[text()='ACTIVITY DASHBOARD']")).click();
	}
	
	
	@Step("Verify1")
	public void verify1() throws InterruptedException
	{
		driver.findElement(By.id("drilldown-container_2")).click();
		Thread.sleep(5000);
		
		Set<String> handles=driver.getWindowHandles();
		Iterator it=handles.iterator();
		String parentwindow=(String) it.next();
		System.out.print("parent id"+parentwindow);
		String childwindow=(String) it.next();
		System.out.print("child id"+childwindow);
		driver.switchTo().window(childwindow);
		driver.manage().window().maximize();
		
		//driver.switchTo().frame("innerForm");
		commonMethodsPage.scrollElementToView(unknwn);
		driver.findElement(By.xpath("//span[contains(text(),'UNKNOWN')]")).click();
	}
	
	@Step("Select Week Start Day")
	public void selectWeekStartDay()
	{
		 Select drpdwn = new Select(weekStartDay);
		 drpdwn.selectByVisibleText("Thursday");
		 
	}
	
	@Step("SelectWeekStart Day back to Monday as default settings")
	public void selectWeekStartDaytoMonday()
	{
		 Select drpdwn = new Select(weekStartDay);
		 drpdwn.selectByVisibleText("Monday");
		 
	}
	
	@Step("Select on WorkLoad Category")
	public void clickOnWorkLoadCategory()
	{
		this.defaultWorkLoadCategory.clear();
		this.defaultWorkLoadCategory.sendKeys("Undefined1");
	}
	
	@Step("Click on WorkLoadAnalysis")
	public void clickWorkLoadAnalysis()
	{
		driver.findElement(By.xpath("//a[text()='WORKLOAD ANALYSIS']")).click();
	}
	
	@Step("Select on WorkLoad Category back to default")
	public void clickOnWorkLoadCategorydefault()
	{
		this.defaultWorkLoadCategory.clear();
		this.defaultWorkLoadCategory.sendKeys("Undefined");
	}
	
}
