package net.pages_worktimemodule;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class UserDomainPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//label[contains(text(),'ADD NEW')]")
	WebElement addNewBtn;
	
	@FindBy(xpath="//i[@title='Modify']")
	WebElement modifyBtn;
	
	@FindBy(xpath="//i[@title='Delete']")
	WebElement deleteBtn;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchTxtBx;
	
	@FindBy(xpath="//img[@title='Export to Excel']")
	WebElement exportExcelBtn;
	
	@FindBy(xpath="//img[@title='Export to PDF']")
	WebElement exportPdfBtn;
	
	@FindBy(id="domainName")
	WebElement domainNameTxtBx;
	
	@FindBy(id="domainDescription")
	WebElement domainDescriptionTxtBx;
	
	@FindBy(id="hostName")
	WebElement hostNameTxtBx;
	
	@FindBy(id="port")
	WebElement portTxtBx;
	
	@FindBy(id="domain")
	WebElement domainTxtBx;
	
	@FindBy(id="isSSL")
	WebElement isSSLChkBx;
	
	@FindBy(id="enableSync")
	WebElement enableSyncChkBx;
	
	@FindBy(id="userName")
	WebElement userNameTxtBx;
	
	@FindBy(name="password")
	WebElement passwordTxtBx;
	
	@FindBy(id="connString")
	WebElement connStringTxtBx;
	
	@FindBy(xpath="//input[@class='btn btn-save btn-save-padded']")
	WebElement saveBtn;
	
	@FindBy(xpath="//input[@onclick='fnClearForm(this.form)']")
	WebElement clearBtn;
	
	@FindBy(xpath="//input[@value=\"TEST CONNECTION\"]")
	WebElement testConnectionBtn;
	
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement testConnAlertOkBtn;
	
	@FindBy(xpath="//th[contains(text(),'Domain Alias')]")
	WebElement domainAliasHeaderBtn;
	
	@FindBy(xpath="//button[@class='btn btn-save btn-save-padded alert-btn-save']")
	WebElement deleteConfirmationBtn;
	
	@FindBy(xpath="//table[@class='dataTable no-footer']/thead/tr/th[3]")
	WebElement UserRoleName;
	
	 public UserDomainPage(WebDriver driver)
	 {
		 this.driver=driver;
	     PageFactory.initElements(driver,this);
	 }
	 
	 @Step("Click on add new Button")
	 public void clickaddNewBtn()
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(addNewBtn));
		 this.addNewBtn.click();
	 }
	 
	 @Step("Click Modify Button")
	 public void clickModifyBtn()
	 {
		 this.modifyBtn.click();
	 }
	 
	 @Step("Click on Delete Button")
	 public void clickDeleteBtn() throws InterruptedException
	 {
		 this.deleteBtn.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(deleteConfirmationBtn));
		 this.deleteConfirmationBtn.click();
	 }
	 
	 @Step("Click on Search Text Button")
	 public void clickSearchTxtBx()
	 {
		 this.searchTxtBx.click();
	 }
	 
	 @Step("Click on Export To Excel Button")
	 public void clickExportToExcelBtn()
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(exportExcelBtn));
		 this.exportExcelBtn.click();
	 }
	 
	 @Step("Click on Export To PDF Button")
	 public void clickExportToPdfBtn()
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(exportPdfBtn));
		 this.exportPdfBtn.click();
	 }
	 
	 @Step("Click on input Domian Name")
	 public String  inputDomainName(String result)
	 {
		 this.domainNameTxtBx.clear();
		 this.domainNameTxtBx.sendKeys(result);
		return result;
	 }
	 
	 @Step("Click on input Domain Description")
	 public void inputDomainDescriptionTxtBx(String description)
	 {
		 this.domainDescriptionTxtBx.sendKeys(description);
	 }
	 
	 @Step("Input Host Name")
	 public void inputHostName(String hostname)
	 {
		 this.hostNameTxtBx.sendKeys(hostname);
	 }
	 
	 @Step("Input PORT Text Box")
	 public void inputPortTxtBx(String port)
	 {
		 this.portTxtBx.sendKeys(port);
	 }
	 
	 @Step("Input Domain Text Box")
	 public void inputDomainTxtBx(String domain)
	 {
		 this.domainTxtBx.sendKeys(domain);
	 }
	 
	 @Step("Select SSL Chk Box")
	 public void selectSSLChkBx()
	 {
		//this.isSSLChkBx.click();
		//new WebDriverWait(driver(), 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@formcontrolname='reportingDealPermission' and @ng-reflect-name='reportingDealPermission']"))).click();
		//Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("isSSL"))).click();
		
		WebElement ele = driver.findElement(By.id("isSSL"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
	 }
	 
	 @Step("Select Enable Sync Data")
	 public void selectEnableSyncData()
	 {
		//this.enableSyncChkBx.click();
		WebElement ele = driver.findElement(By.id("enableSync"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
		 
	 }
	 
	 @Step("Input User Name")
	 public void inputUserName(String name)
	 {
		 this.userNameTxtBx.sendKeys(name);
	 }
	 
	 @Step("Input Password")
	 public void inputPassword(String password)
	 {
		 this.passwordTxtBx.sendKeys(password);
	 }
	 
	 @Step("Input Conn String")
	 public void inputConnString(String connstring)
	 {
		 this.connStringTxtBx.sendKeys(connstring);
	 }
	 
	 @Step("Click on Save Button")
	 public void clickSaveBtn()
	 {
		 this.saveBtn.click();
	 }
	 
	 @Step("Click on clear Button")
	 public void clickClearBtn()
	 {
		 this.clearBtn.click();
	 }
	 
	 @Step("Click on Test Connection Button")
	 public void clickTestConnectionBtn() throws InterruptedException
	 {
		 this.testConnectionBtn.click();
		 Thread.sleep(50000);
		 this.testConnAlertOkBtn.click();
	 }
	 
	 @Step("GET Element in ROW to List")
	 public ArrayList<String> getElementsInRowToList() throws InterruptedException
	 {
		Thread.sleep(2000); 
		 int rowCount = driver.findElements(By.xpath("//*[@id='CommonDataTableId']/tbody/tr")).size();
			System.out.println("total rows in table "+rowCount);
			
			int j=0;
			ArrayList<String> getElements = new ArrayList<String>(rowCount);
			for(int i=1;i<rowCount+1;i++)
			{
				
				WebElement names =driver.findElement(By.xpath("//table[@id='CommonDataTableId']/tbody/tr["+i+"]/td[2]"));
				if(j<rowCount)
				{
					getElements.add(names.getText());
					j++;
				}
			}
		//Arrays.sort(getElements, Collections.reverseOrder());
		Collections.sort(getElements, Collections.reverseOrder());
		
		
		//return Arrays.toString(getElements);
		return getElements;
		 
	 }
	 
	 @Step("Click on Domain Alias Header Button")
	 public void clickDomainAliasHeaderBtn()
	 {
		 this.domainAliasHeaderBtn.click();
	 }
	 
	 @Step("Click on User Role Name Btn")
	 public void clickUserRoleNameBtn()
	 {
		 this.UserRoleName.click();
	 }
	 
	 @Step("Click on get Element in ROW to list1")
	 public ArrayList<String> getElementsInRowToList1() throws InterruptedException
	 {
		Thread.sleep(2000); 
		 int rowCount = driver.findElements(By.xpath("//*[@id='CommonDataTableId']/tbody/tr")).size();
		 System.out.println("total rows in table "+rowCount);
			
			int j=0;
			ArrayList<String> getElements = new ArrayList<String>(rowCount);
			for(int i=1;i<rowCount+1;i++)
			{
				
				WebElement names =driver.findElement(By.xpath("//table[@id='CommonDataTableId']/tbody/tr["+i+"]/td[3]"));
				if(j<rowCount)
				{
					getElements.add(names.getText());
					j++;
				}
			}
			Collections.sort(getElements, Collections.reverseOrder());
			return getElements;
	 }
	

}
