package net.pages_worktimemodule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import net.Commons.RandomStringGeneration;
import net.testcases_worktimemodule.utilities.ReadXLSdata;

public class AOSPage {
	
	WebDriver driver;
	ReadXLSdata xls = new ReadXLSdata(driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	String result = randomStringGenerator.randomStringGenerator();
	
	@FindBy(xpath="//label[contains(text(),'ADD NEW')]")
	public WebElement addnewBtn;
	
	@FindBy(xpath="//i[@title='Modify']")
	WebElement modifyBtn;
	
	@FindBy(xpath="//i[@title='Delete']")
	WebElement deleteBtn;
	
	@FindBy(id="applicationName")
	WebElement nameTxt;
	
	@FindBy(id="defaultTypecategory")
	WebElement activityTypeDrpDwn;
	
	@FindBy(id="SUBMIT")
	WebElement saveBtn;
	
	@FindBy(id="clear")
	WebElement clearBtn;
	
	@FindBy(id="windowTitle")
	WebElement windowTitleTxt;
	
	@FindBy(id="SUBMIT")
	WebElement signatureSaveBtn;
	
	@FindBy(id="add")
	WebElement signatureAddBtn;
	
	@FindBy(xpath="//*[@id='alertModal']/div/div/div[3]/button")
	WebElement signatureOkBtn;
	
	@FindBy(xpath="//label[contains(text(),'MORE ACTION')]")
	WebElement moreActionBtn;
	
	@FindBy(xpath="//a[contains(text(),'UNKNOWN APPLICATIONS')]")
	WebElement unknownApplicationBtn;
	
	@FindBy(xpath="//div[@id='s2id_appList']")
	WebElement configureUnkownApplicationDrpdwn;
	
	@FindBy(xpath="//table/thead/tr/th[contains(text(),'Q')]")
	WebElement qButton;
	
	@FindBy(xpath="//table[@id ='CommonDataTableId']/tbody/tr/td[8]")
	WebElement chkBox;
	
	@FindBy(xpath="//input[@title='Add Selected Applications']")
	WebElement addBtn;
	
	@FindBy(xpath="//input[@value='SUBMIT']")
	WebElement submitBtn;
	
	@FindBy(xpath="//span[contains(text(),'Click here')]")
	WebElement clickHereBtn;
	
	@FindBy(id="applicationXLUpload")
	WebElement chooseFileInBulkUploadinput;
	
	@FindBy(xpath="//input[@value='UPLOAD']")
	WebElement bulkUploadBtn;
	
	@FindBy(xpath="//label[contains(text(),'BACK')]")
	WebElement backBtnAosPage;
	
	@FindBy(xpath="//label[contains(text(),\"Search\")]")
	WebElement searchBtn;
	

	
	 public AOSPage(WebDriver driver)
	 {
		 this.driver=driver;
	     PageFactory.initElements(driver,this);
	 }
	 
	 @Step("Click Add New Button")
	 public void clickAddNewBtn()
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(addnewBtn));
		 this.addnewBtn.click();
	 }
	 
	 @Step("Click Send Application Name Text")
	 public void sendApplicationNameTxt(String name)
	 {
		 this.nameTxt.clear();
		 this.nameTxt.sendKeys(name);
	 }
	 
	 @Step("SELECT Activity Type Drp DOWN")
	 public void selectActivityTypeDrpDwn()
	 {
		 Select drpdwn = new Select(activityTypeDrpDwn);
		 drpdwn.selectByVisibleText("Business");
	 }
	 
	 @Step("Click Add NEW SAVE Btn")
	 public void clickAddNewSaveBtn()
	 {
		 this.saveBtn.click();
	 }
	 
	 @Step("Click Signature Ok Button")
	 public void clickSignatureOkBtn()
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='alertModal']/div/div/div[3]/button")));
		 this.signatureOkBtn.click();
	 }
	 
	 @Step("Send Window Title")
	 public void sendWindowTitle(String title)
	 {
		 this.windowTitleTxt.sendKeys(title);
	 }
	 
	 @Step("Click Add Title Button")
	 public void clickAddTitleBtn()
	 {
		 this.signatureAddBtn.click();
	 }
	 
	 @Step("Click Save Signature Button")
	 public void clickSaveSignatureBtn()
	 {
		 this.signatureSaveBtn.click();
	 }
	 
	 @Step("Click Modify BUTTON")
	 public void clickModifyBtn()
	 {
		 this.modifyBtn.click();
	 }
	 
	 @Step("Click More action Button")
	 public void clickMoreActionBtn() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.elementToBeClickable(moreActionBtn));
		 this.moreActionBtn.click();
	 }
	 
	 @Step("Click Unknown Application")
	 public void clickUnknownApplicationBtn() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.elementToBeClickable(unknownApplicationBtn));
		 this.unknownApplicationBtn.click();
	 }
	 
	 @Step("Select Configure Unknown Application")
	 public void selectConfigureUnknownApplicationDrpDwn() throws InterruptedException {
		 this.configureUnkownApplicationDrpdwn.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("appList"))));
		 Select drpUnknownApp = new Select(driver.findElement(By.id("appList")));
		 drpUnknownApp.selectByValue("5038");
	 }
	 
	 @Step("Click Q Btn")
	 public void clickQBtn() throws InterruptedException
	 {
		 this.qButton.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(qButton));
		 this.qButton.click();
	 }
	 
	 @Step("Select Check Box")
	 public void selectChkBox()
	 {
		 this.chkBox.click();;
	 }
	 
	 @Step("Click Add Button")
	 public void clickAddBtn()
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(addBtn));
		 this.addBtn.click();
	 }
	 
	 @Step("Click Submit Button")
	 public void clickSubmitBtn()
	 {
		 this.submitBtn.click();
	 }
	 
	 @Step("Click On Click Here Button")
	 public void clickOnClickHereBtn()
	 {
		 this.clickHereBtn.click();
	 }
	 
	/* public void addActivityTagExcelBulckUpload() throws InterruptedException, IOException
	 {
		 List<String> addBulkUploadData = new ArrayList<String>();
		 Thread.sleep(1000);
		 addBulkUploadData.add("ADD");
		 addBulkUploadData.add(result);
		 addBulkUploadData.add("Test Done");
		 addBulkUploadData.add("Business");
		 
		 String path = xls.getRecentFilePath();
		 FileInputStream file = new FileInputStream(path);
		 
		 //Workbook workbook = new XSSFWorkbook(file);
		 
		 //Worksheet wsLargestCities = workbook.getWorksheets().get(0);
		 
		 //wsLargestCities.getCells().importArrayList();
		 
		 try (Workbook workbook = new XSSFWorkbook(file))
		 {
			 Sheet sheet = workbook.getSheetAt(0);
				sheet.getLastRowNum();
				for (int i = 2; i <= 2; i++)
				{
					Row row = sheet.getRow(i);
					int k = 0;
					
					for (int j = 1; j < cellcount; j++)
					{
						if (j == 2)
						{
							continue;
						}
						Cell cell = row.createCell(j);
						cell.setCellValue(addBulkUploadData.get(k));
						k++;
					}
				}
				
				FileOutputStream fos = new FileOutputStream(path);
				workbook.write(fos);
				fos.close();
		 }
		 
	 }*/
	 
	 @Step("Add Activity TAG Excel Bulk Upload")
	 public String addActivityTagExcelBulckUpload() throws IOException, InterruptedException
		{
		 List<String> addBulkUploadData = new ArrayList<String>();
			Thread.sleep(1000);
			addBulkUploadData.add("ADD");
			addBulkUploadData.add(result);
			addBulkUploadData.add("Test Done");
			addBulkUploadData.add("Business");
			//addBulckUploadData.add("Yes");

			String path = xls.getRecentFilePath();
			FileInputStream file = new FileInputStream(path);

			try (Workbook workbook = new XSSFWorkbook(file))
			{
				Sheet sheet = workbook.getSheetAt(0);
				sheet.getLastRowNum();
				for (int i = 2; i <= 2; i++)
				{
					Row row = sheet.getRow(i);
					int cellcount = sheet.getRow(i).getLastCellNum() -1;
					int k = 0;
					for (int j = 1; j < cellcount; j++)
					{
						if (j == 2)
						{
							continue;
						}
						Cell cell = row.createCell(j);
						cell.setCellValue(addBulkUploadData.get(k));
						k++;
					}
				}
				FileOutputStream fos = new FileOutputStream(path);
				workbook.write(fos);
				fos.close();
			}
			return result;
		}
	 
	 @Step("Add Activity Tag Bulk Upload AOS signature")
	 public void addActivityTagExcelBulckUploadAOSSignature() throws IOException, InterruptedException
		{
		 
		 List<String> addBulkUploadData = new ArrayList<String>();
			Thread.sleep(1000);
			addBulkUploadData.add("ADD");
			addBulkUploadData.add(result);
			addBulkUploadData.add("Starts With");
			addBulkUploadData.add("www");
			addBulkUploadData.add("Starts With");
			addBulkUploadData.add("www");
			//addBulckUploadData.add("Yes");

			String path = xls.getRecentFilePath();
			FileInputStream file = new FileInputStream(path);

			try (Workbook workbook = new XSSFWorkbook(file))
			{
				Sheet sheet = workbook.getSheetAt(1);
				sheet.getLastRowNum();
				for (int i = 2; i <= 2; i++)
				{
					Row row = sheet.getRow(i);
					int cellcount = sheet.getRow(i).getLastCellNum() - 1;
					int k = 0;
					for (int j = 1; j < cellcount; j++)
					{
						if (j == 2)
						{
							continue;
						}
						Cell cell = row.createCell(j);
						cell.setCellValue(addBulkUploadData.get(k));
						k++;
					}
				}
				FileOutputStream fos = new FileOutputStream(path);
				workbook.write(fos);
				fos.close();
			}
		}
	 
	 @Step("Add Activity TAG excel upload WORK Profile")
	 public void addActivityTagExcelBulckUploadWorkProfile() throws IOException, InterruptedException
		{
		 
		 List<String> addBulckUploadData = new ArrayList<String>();
			Thread.sleep(1000);
			addBulckUploadData.add("ADD");
			addBulckUploadData.add(result);
			addBulckUploadData.add("Business");
			addBulckUploadData.add("5");
			//addBulckUploadData.add("Yes");

			String path = xls.getRecentFilePath();
			FileInputStream file = new FileInputStream(path);

			try (Workbook workbook = new XSSFWorkbook(file))
			{
				Sheet sheet = workbook.getSheetAt(2);
				sheet.getLastRowNum();
				for (int i = 2; i <= 2; i++)
				{
					Row row = sheet.getRow(i);
					int cellcount = sheet.getRow(i).getLastCellNum() - 1;
					int k = 0;
					for (int j = 1; j < cellcount; j++)
					{
						if (j == 2)
						{
							continue;
						}
						Cell cell = row.createCell(j);
						cell.setCellValue(addBulckUploadData.get(k));
						k++;
					}
				}
				FileOutputStream fos = new FileOutputStream(path);
				workbook.write(fos);
				fos.close();
			}
		}
	 
	 @Step("Add Activity Tag Excel Bulk Upload Work PROFILE modify")
	 public String addActivityTagExcelBulkUploadWorkProfileModify() throws IOException, InterruptedException
		{
		 
		 List<String> addBulkUploadData = new ArrayList<String>();
			Thread.sleep(1000);
			String random = "test";
			String modify = random+result;
			addBulkUploadData.add("MOD");
			addBulkUploadData.add(modify);
			addBulkUploadData.add("Test Done");
			addBulkUploadData.add("Business");
			//addBulckUploadData.add("Yes");

			String path = xls.getRecentFilePath();
			FileInputStream file = new FileInputStream(path);

			try (Workbook workbook = new XSSFWorkbook(file))
			{
				Sheet sheet = workbook.getSheetAt(0);
				sheet.getLastRowNum();
				for (int i = 2; i <= 2; i++)
				{
					Row row = sheet.getRow(i);
					int cellcount = sheet.getRow(i).getLastCellNum() - 1;
					int k = 0;
					for (int j = 1; j < cellcount; j++)
					{
						if (j == 2)
						{
							continue;
						}
						Cell cell = row.createCell(j);
						cell.setCellValue(addBulkUploadData.get(k));
						k++;
					}
				}
				FileOutputStream fos = new FileOutputStream(path);
				workbook.write(fos);
				fos.close();
			}
			return modify;
			
		}
	 
	 @Step("ADD Activity Tag Excel Upload Work Profile Delete")
	 public void addActivityTagExcelBulkUploadWorkProfileDelete() throws IOException, InterruptedException
		{
		 
		 List<String> addBulkUploadData = new ArrayList<String>();
			Thread.sleep(1000);
			//String random = "test";
			//String modify = random+result;
			addBulkUploadData.add("DEL");
			addBulkUploadData.add("");
			addBulkUploadData.add("Test Done");
			addBulkUploadData.add("Business");
			//addBulckUploadData.add("Yes");

			String path = xls.getRecentFilePath();
			FileInputStream file = new FileInputStream(path);

			try (Workbook workbook = new XSSFWorkbook(file))
			{
				Sheet sheet = workbook.getSheetAt(0);
				sheet.getLastRowNum();
				for (int i = 2; i <= 2; i++)
				{
					Row row = sheet.getRow(i);
					int cellcount = sheet.getRow(i).getLastCellNum() - 1;
					int k = 0;
					for (int j = 1; j < cellcount; j++)
					{
						if (j == 2)
						{
							continue;
						}
						Cell cell = row.createCell(j);
						cell.setCellValue(addBulkUploadData.get(k));
						k++;
					}
				}
				FileOutputStream fos = new FileOutputStream(path);
				workbook.write(fos);
				fos.close();
			}
			
		}

	 @Step("Click Choose File In Bulk Upload")
	 public void clickChooseFileInBulkUpload()
		{
			//commons.waitForElementNotVisible(Duration.ofSeconds(30), driver, loadingIcon);
			this.chooseFileInBulkUploadinput.sendKeys(xls.getRecentFilePath());
			// his.bulkUploadBtn.click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", bulkUploadBtn);
			
		}
	 
	 @Step("Click Back Button AOS PAGE")
	 public void clickBackBtnAosPage()
	 {
		 this.backBtnAosPage.click();
	 }
	 
	/* public String returnResult()
	 {
		return result;
		 
	 }*/
	 
	 @Step("Click Search Button")
	 public void clickSearchBtn(String name)
	 {
		 this.searchBtn.sendKeys(name);
	 }
}
