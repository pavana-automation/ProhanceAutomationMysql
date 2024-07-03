package net.pages_worktimemodule;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.qameta.allure.Step;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;

public class UserRolePage {
	
WebDriver driver;
	
	@FindBy(xpath="//label[contains(text(),'ADD NEW')]")
	WebElement addnewBtn;
	
	@FindBy(id="roleTypeStyleId_Manager")
	WebElement managerRadioBtn;
	
	@FindBy(id="roleTypeStyleId_Member")
	WebElement memberRadioBtn;
	
	@FindBy(id="roleName")
	WebElement roleNameTxtBox;
	
	@FindBy(id="roleDescription")
	WebElement roleDescriptionTxtBox;
	
	@FindBy(id="save")
	WebElement saveBtn;
	
	@FindBy(xpath="//i[@title='Delete']")
	WebElement deleteBtn;
	
	@FindBy(xpath="//input[@name='selectedUserRole']")
	WebElement selectedUserChkBox;
	
	@FindBy(xpath="//label[contains(text(),'Search')]")
	WebElement searchTxtBox;
	
	@FindBy(xpath="//select[@class='combobox']")
	WebElement hierarchyLevel;
	
	@FindBy(xpath="//label[contains(text(),'BULK UPDATE')]")
	WebElement bulkUpdateBtn;
	

	@FindBy(xpath="//i[@title='Modify']")
	WebElement modifyBtn;
	
	@FindBy(xpath="//table[@id='CommonDataTableId']/tbody/tr/td[5]")
	WebElement roleTypeData;
	
	@FindBy(id="workTime")
	WebElement workTimeChkBox;
	
	@FindBy(id="workTimeLi")
	WebElement workTimeModuleBtn;
	
	@FindBy(id="selfRdBtnId")
	WebElement selfRadioBtn;
	
	@FindBy(id="bothPermissionTd")
	WebElement memberDirectlyToMe;
	
	@FindBy(id= "directIndirectPermissionTd")
	WebElement memberIndirectlyToMe;
	
	@FindBy(id="allowEmailExport")
	WebElement allowEmailExportChkBox;
	
	@FindBy(id="allowOnDemand")
	WebElement allowOnDemandChkBox;
	
	@FindBy(id="allowRecipientList")
	WebElement allowRecipientListChkBox;
	
	@FindBy(id= "drilldown-container_2")
	WebElement drillDownBtn;
	
	@FindBy(xpath="//span[contains(text(),'Role Permissions')]")
	WebElement rolePermissionBtn;
	
	@FindBy(xpath="//span[contains(text(),'Client Settings')]")
	WebElement clientSettingsBtn;
	
	@FindBy(id="moduleId")
	WebElement moduleIdDrpDwn;
	
	@FindBy(id="chk_level_R_305")
	WebElement editRatingChkBox;
	
	@FindBy(xpath="//span[contains(text(),'User Group Widgets')]")
	WebElement userGroupWidgetsBtn;
	

	 public UserRolePage(WebDriver driver)
	 {
		 this.driver=driver;
	     PageFactory.initElements(driver,this);
	 }
	 
	 @Step("click on Add-New Btn")
	 public void clickAddNewBtn()
	 {
		 this.addnewBtn.click();
	 }
	 
	 @Step("Select Manager Radio Button")
	 public void selectManagerRadioBtn()
	 {
		 this.managerRadioBtn.click();
	 }
	 
	 @Step("Select Member Radio Btn")
	 public void selectMemberRadioBtn()
	 {
		 this.memberRadioBtn.click();
	 }
	 
	 @Step("Give the RoleNameTxtBox")
	 public void inputRoleNameTxtBox(String Name)
	 {
		 this.roleNameTxtBox.sendKeys(Name);
	 }
	 
	 @Step("Input of Role Description TxtBox")
	 public void inputRoleDescrptionTxtBOx(String description)
	 {
		 this.roleDescriptionTxtBox.sendKeys(description);
	 }
	 
	 @Step("Click on save btn")
	 public void clickOnSaveBtn()
	 {
		 this.saveBtn.click();
	 }
	 
	 @Step("Click on Delete Btn")
	 public void clickOnDeleteBtn()
	 {
		 this.deleteBtn.click();
	 }
	 
	 @Step("Click on selected User CheckBox")
	 public void clickSelectedUserChkBox()
	 {
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", this.selectedUserChkBox);
	 }
	 
	 @Step("Click on Seach Txt Box")
	 public void clickSearchTxtBox(String name)
	 {
		 this.searchTxtBox.sendKeys(name);
	 }
	 
	 @Step("Get the Hierarchy Text")
	 public String getTextHierarchy()
	 { 
		 Select comboBox = new Select(this.hierarchyLevel);
		 System.out.println(comboBox);
		 String selectedComboValue = comboBox.getFirstSelectedOption().getText();
		 System.out.println("the value is :"+selectedComboValue);
		 return selectedComboValue;
		 
	 }
	 
	 @Step("Set the Hierarchy Text")
	 public void setHierarchyLevelChange()
	 {
		 this.hierarchyLevel.sendKeys("Members who directly or indirectly report into me");
	 }
	 
	 @Step("Click on Bulk Update Button")
	 public void clickBilkUpdateBtn()
	 {
		 this.bulkUpdateBtn.click();
	 }
	 
	 @Step("Click On Role Permission ")
	 public void clickRolePermissionBtn()
	 {
		 this.rolePermissionBtn.click();
	 }
	 
	 @Step("Click On Modify Button")
	 public void clickModifyBtn()
	 {
		 this.modifyBtn.click();
	 }
	 
	 @Step("Get the RoleType Data")
	 public String getRoleTypeData()
	 {
		 return this.roleTypeData.getText();
	 }
	 
	 @Step("Click on Select Module")
	 public void selectModule() throws InterruptedException
	 {
		 if(this.workTimeChkBox.isSelected())
		 {
			 this.workTimeChkBox.click();
			 System.out.println("i am pavana");
			 driver.findElement(By.id("module_1")).click();
			 driver.findElement(By.id("module_100")).click();
			 driver.findElement(By.id("module_96")).click();
		 }
		 else
		 {
		
			 this.workTimeChkBox.click();
			 this.workTimeChkBox.click();
			 Thread.sleep(1000);
			 driver.findElement(By.id("module_1")).click();
			 driver.findElement(By.id("module_100")).click();
			 driver.findElement(By.id("module_96")).click();
			
		 }
	 }
	 
	 @Step("Select WorkTime Module")
	 public void selectWorkTimeModule()
	 {
		 this.workTimeModuleBtn.click();
	 }
	 
	 @Step("To Check 'Me Only' Radio Btn is selected or not")
	 public boolean checkMeOnlyRdBtnIsSelected()
	 {
		 return this.selfRadioBtn.isSelected();
	 }
	 
	 @Step("Click Members Directly To Me")
	 public void selectMembersDirectlyToMeIsSelected()
	 {
		 this.memberDirectlyToMe.click();
	 }
	 
	 @Step("Check if Members Directly To Me Is selected")
	 public boolean checkMembersDirectlyToMeIsSelected()
	 {
		 return this.memberDirectlyToMe.isSelected();
	 }
	 
	 @Step("Check Allow Email Export ChkBox is selected")
	 public void checkallowEmailExportChkBoxIsEnabled()
	 {
		 if( this.allowEmailExportChkBox.isSelected())
		 {
			 System.out.println("Email option is already checked");
		 }
		 else
		 {
			 this.allowEmailExportChkBox.click();
		 }
	 }
	 
	 @Step("Select On DrillDown Button")
	 public void clickOnDrillDownBtn()
	 {
		 this.drillDownBtn.click();
	 }
	 
	 @Step("Check on Demand Mail is Enabled")
	 public void checkOnDemandMailIsEnabled()
	 {
		 if(driver.findElement(By.id("allowOnDemand")).isSelected())
		 {
			 System.out.println("On Demand Email option is already checked");
		 }
		 else
		 {
			 driver.findElement(By.id("allowOnDemand")).click();
		 }
	 }
	 
	 @Step("Disable OnDemand mail is Disabled")
	 public void disableOnDemandMailRadioBtn()
	 {
		 if(driver.findElement(By.id("allowOnDemand")).isSelected())
		 {
			 driver.findElement(By.id("allowOnDemand")).click();
			 
		 }
		 else
		 {
			 System.out.println("On Demand Email option is diabled");
		 }
	 }
	 
	 @Step("Click on Export Excel Btn ")
	 public void exportexcelBtnToBeDisabled() throws InterruptedException
	 {
		if(driver.findElement(By.xpath("//img[@title=\"Export to Excel\"]")).isDisplayed())
		{
			
			Thread.sleep(2000);
		
		  driver.findElement(By.xpath("//img[@title=\"Export to Excel\"]")).click();
		}
		else
		{
			try {
				
				driver.findElement(By.xpath("//img[@title=\"Export to Excel\"]")).click();
			}
			catch(NoSuchElementException x)
			{
				System.out.println("Element is disabled as expected");
			}
			
			String actual = driver.findElement(By.xpath("//div[contains(text(),\"You do not have permission to download this content\")]")).getText();
			
			Assert.assertEquals("You do not have permission to download this content", actual);
			// driver.findElement(By.xpath("//div[contains(text(),\"You do not have permission to download this content\")]"));
		}
	 }
	 
	 @Step("Export PDF to be disabled")
	 public void exportPDFBtnToBeDisabled()
	 {
			if(driver.findElement(By.xpath("//img[@title='Export to PDF']")).isDisplayed())
			{
			
			  driver.findElement(By.xpath("//img[@title='Export to PDF']")).click();
			}
			else
			{
				try {
					
					driver.findElement(By.xpath("//img[@title='Export to PDF']")).click();
					String actual = driver.findElement(By.xpath("//div[contains(text(),\"You do not have permission to download this content\")]")).getText();
					Assert.assertEquals("You do not have permission to download this content", actual);
				}
				catch(NoSuchElementException x)
				{
					System.out.println("Element is disabled as expected");
				}
	 }
	 }
	 
	 @Step("Click on UserRole Permission Button")
	 public void clickUserRolePrmissionBtn()
	 {
		 this.rolePermissionBtn.click();
	 }
	 
	 @Step("Click on UserRole Permission Button")
	 public void clickClientSettings()
	 {
		 this.clientSettingsBtn.click();
	 }
	 
	 @Step("Select Module ID Drop Down")
	public void selectModuleIdDrpDwn()
	{
		 Select comboBox = new Select(this.moduleIdDrpDwn);
		 comboBox.selectByValue("1");
	}
	
	 @Step("Enable Edit Activity Rating Check Box")
	public void enableEditActivityRatingChkBox()
	{
		if(this.editRatingChkBox.isSelected())
		{
			System.out.println("Activity rating chkbox is already enabled");
		}
		else
			this.editRatingChkBox.click();
	}
	 
	 
	
	 @Step("Click On User Group Widget")
	public void clickUserGroupWidgets()
	{
		this.userGroupWidgetsBtn.click();
	}	
	 
	 @Step("Select Module ID Drop Down")
	public void selectWORKLOADANALYSIS()
	{
		 Select comboBox = new Select(this.moduleIdDrpDwn);
		 comboBox.selectByValue("100");
	}
	 
	 @Step("Select AttendenceModule ID Drop Down")
	public void selectAttendence()
	{
		 Select comboBox = new Select(this.moduleIdDrpDwn);
		 comboBox.selectByValue("96");
	}
	 
	 @Step("Select TimeSheetModule ID Drop Down")
	public void selectTimeSheet()
	{
		 Select comboBox = new Select(this.moduleIdDrpDwn);
		 comboBox.selectByValue("93");
	}
	 
	 @Step("Select TimeSheetModule ID Drop Down")
		public void selectCurrentActivity()
		{
			 Select comboBox = new Select(this.moduleIdDrpDwn);
			 comboBox.selectByValue("230");
		}
	 
	 @Step("Select TimeSheetModule ID Drop Down")
		public void selectCustomReports()
		{
			 Select comboBox = new Select(this.moduleIdDrpDwn);
			 comboBox.selectByValue("167");
		}
	 
	 @Step("Select WorkOutPut Module ID Drop Down")
		public void selectWorkOutPut()
		{
			 Select comboBox = new Select(this.moduleIdDrpDwn);
			 comboBox.selectByValue("289");
		}
	 
	 @Step("Select AO Module ID Drop Down")
		public void selectAO()
		{
			 Select comboBox = new Select(this.moduleIdDrpDwn);
			 comboBox.selectByValue("188");
		}
}
