package net.pages_worktimemodule;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Step;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;


public class ActivityTagsPage extends BaseTest
{

	public String		activityTagNameAdd							= "Test Demo Activity";

	public String		activityTagNameModify						= "Test Demo Activity Modified";

	public String		parentDropdownValueForActivityTag			= "Free Time";

	public String		activityTagNameAddInBulkUpload				= "Test dome";

	public String		activityTagNameModifyingValuesInBulkUpload	= "Test dome modified";

	String				pdfConten;

	List<String>		excelActivityTagTableDataList				= new ArrayList<String>();

	List<String>		webActivityTagTableDataList					= new ArrayList<String>();

	List<String>		withPrefilledExcelDataList					= new ArrayList<String>();

	List<String>		webDataListForPrefilled						= new ArrayList<String>();

	List<String>		addBulckUploadData							= new ArrayList<String>();

	WebDriver			driver;

	CommonMethodsPage	commons										= new CommonMethodsPage(BaseTest.driver);

	SoftAssert			softAssert									= new SoftAssert();

	@FindBy(xpath = "//span[text()='Activity Tags']/ancestor::li")
	WebElement			activityTagsTab;

	@FindBy(xpath = "//select[@id=\"classId\"]")
	WebElement			classificationDropdown;

	@FindBy(xpath = "//input[@id=\"activityCategoryName\"]")
	WebElement			activityTagsNameTxtBx;

	@FindBy(xpath = "//textarea[@id=\"activityCategoryDescription\"]")
	WebElement			activityTagsDescriptionTxtBx;

	@FindBy(xpath = "//input[@id=\"activitiesOnSystem\"]")
	WebElement			applicableForASO;

	@FindBy(xpath = "//input[@id=\"activitiesAwayFromSystem\"]")
	WebElement			applicableForAAFS;

	@FindBy(xpath = "//div[@id=\"s2id_parentTagId\"]/a")
	WebElement			parentActivityDropdown;

	@FindBy(xpath = "//div[@id=\"select2-drop\"]//input[@id=\"s2id_autogen1_search\"]")
	WebElement			parentActivityDropdowninputTxtBx;

	@FindBy(xpath = "//div[@class=\"select2-result-label\"]/span")
	WebElement			parentActivityDropdownValue;

	@FindBy(xpath = "//form[@id=\"ConfigureActivityCategoryForm\"]//table[2]//input[2]")
	WebElement			activityTagsSaveBtn;

	@FindBy(xpath = "//span[@id='successmsgdiv']")
	WebElement			successMsgAlart;

	@FindBy(xpath = "//div[@id=\"CommonDataTableId_filter\"]/label/input")
	WebElement			searchActivityTagTable;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tbody/tr[1]/td[3]")
	WebElement			nameActivityTagTable;

	By					deleteIconActivityTag						= By.xpath("//div[text()=\'" + activityTagNameModify + "\']//ancestor::tr//td/a[2]");

	By					modifyIconActivityTag						= By.xpath("//div[text()=\'" + activityTagNameAdd + "\']//ancestor::tr//td/a[1]");

	By					beforeModifyIconActivityTag					= By.xpath("//div[text()=\'" + activityTagNameAdd + "\']//ancestor::tr//td/a[2]");
	
	@FindBy(xpath = "//div[@id=\"CommonDataTableId_wrapper\"]//img[@src=\"/prohance/images/excel.png\"]")
	WebElement			excelActivityTagTable;

	@FindBy(xpath = "//div[@id=\"CommonDataTableId_wrapper\"]//img[@src=\"/prohance/images/pdf.png\"]")
	WebElement			pdfActivityTagTable;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody")
	WebElement			activityTagTable;

	@FindBy(xpath = "//label[contains(text(),'BULK UPLOAD')]")
	WebElement			bulckUploadBtn;

	@FindBy(xpath = "//label[contains(text(),'With Prefilled Data')]//parent::span//input")
	WebElement			bulckUploadWithPrefilledDataRB;

	@FindBy(xpath = "//span[contains(text(),\"Click here\")]")
	WebElement			bulckUploadClickHereLinkToGetExcel;

	@FindBy(xpath = "//label[contains(text(),'Blank Template')]//parent::span/input")
	WebElement			bulckUploadBlankTemplateRB;

	@FindBy(xpath = "//span[@class=\"btn btn-file resetError\"]/input")
	WebElement			chooseFileInBulkUploadinput;

	@FindBy(xpath = "//input[@id=\"userUploadButton\"]")
	WebElement			bulkUploadBtn;

	@FindBy(xpath = "//span[@Class=\"alert alert-success config-alert\"]")
	WebElement			bulkUploadalterMessage;

	@FindBy(xpath = "//label[contains(text(),\"BACK\")]")
	WebElement			bulkUploadBackBtn;

	@FindBy(xpath = "//div[@id=\"mainContentDiv\"]//img[@src=\"images/loader-large.gif\"]")
	By					loadingIcon;
	
	@FindBy(xpath = "//td[@class=\"tabletdodd\"]//img[@src=\"/prohance/images/ajax-loader.gif\"]")
	By					bulkUploadloadingIcon;

	
	public ActivityTagsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@Step("Here we are identifying the Activity TagsPage")
	public void clickActivityTagTab() throws InterruptedException
	{
		Thread.sleep(2000);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("(//img[@src=\"images/loader-large.gif\"])[last()]")));
		 commons.waitUntilTime(activityTagsTab);
		 this.activityTagsTab.click();
	}

	@Step("Here we are identifying the Activity TagsPage")
	public void addActivityTags() throws InterruptedException
	{
		Select objSelect = new Select(this.classificationDropdown);
		objSelect.selectByVisibleText("Class C");
		Thread.sleep(2000);
		this.parentActivityDropdown.click();
		this.parentActivityDropdowninputTxtBx.sendKeys(parentDropdownValueForActivityTag);
		// driver.findElement(parentActivityDropdownValue).click();
		this.parentActivityDropdownValue.click();
		Thread.sleep(2000);
		this.activityTagsNameTxtBx.sendKeys(activityTagNameAdd);
		this.activityTagsDescriptionTxtBx.sendKeys(activityTagNameAdd);
		// commons.selectjavaScriptCheckBox(applicableForASO);
		// commons.selectjavaScriptCheckBox(applicableForAAFS);

	}

	@Step("Here we are identifying the Activity TagsPage")
	public void clickactivityTagsSaveBtn()
	{
		this.activityTagsSaveBtn.click();
	}

	@Step("This method we validate Added Success Message For activity Tag")
	public void validateAddedSuccessMessageForactivityTag()
	{

		Assert.assertTrue(successMsgAlart.isDisplayed(), "Success Message is not showing");
		String successMsg = successMsgAlart.getText();
		Assert.assertEquals(successMsg, "Category: " + activityTagNameAdd + " added successfully");
	}

	@Step("Search Activity Tag Table Box")
	public void searchActivityTagTableTxtBx()
	{
		commons.waitUntilTime(searchActivityTagTable);
		this.searchActivityTagTable.sendKeys(activityTagNameAdd);
	}

	@Step("validate Activity Tag Added or not")
	public void validateActivityTagAdded()
	{
		String activityTagAdded = this.nameActivityTagTable.getText();
		Assert.assertTrue(activityTagAdded.contains(activityTagNameAdd), "Activity Tags are not Added in Activity Tags Table");
	}

	@Step("Click On Modify Activity Tag")
	public void clickModifyActivityTag()
	{
		driver.findElement(modifyIconActivityTag).click();
	}

	@Step("Modify Activity Tags")
	public void modifyActivityTags()
	{
		this.activityTagsNameTxtBx.clear();
		this.activityTagsNameTxtBx.sendKeys(activityTagNameModify);
		this.activityTagsDescriptionTxtBx.clear();
		this.activityTagsDescriptionTxtBx.sendKeys(activityTagNameModify);
		commons.selectjavaScriptCheckBox(applicableForASO);
		commons.unselectjavaScriptCheckBox(applicableForAAFS);

	}

	@Step("After Modified Search Activity Tag Table TextBox")
	public void afterModifiedSearchActivityTagTableTxtBx()
	{
		this.searchActivityTagTable.sendKeys(activityTagNameModify);
	}

	@Step("Validate Modified Message For Activity Tag")
	public void validateModifiedMessageForActivityTag()
	{
		Assert.assertTrue(successMsgAlart.isDisplayed(), "Modified Message is not showing or Activity Tags not Modified");
		String successMsg = successMsgAlart.getText();
		Assert.assertEquals(successMsg, "Category: " + activityTagNameModify + " modified successfully");
	}

	@Step("Validate Activity Tag Modified")
	public void validateActivityTagModified()
	{
		String activityTagModified = this.nameActivityTagTable.getText();
		Assert.assertTrue(activityTagModified.contains(activityTagNameModify), "Activity Tags are not Modified in Activity Tags Table");
	}

	@Step("Click Delete Activity Tag")
	public void clickDeleteActivityTag()
	{
		driver.findElement(deleteIconActivityTag).click();
	}

	@Step("Validate Deleted Message Activity Tag")
	public void validateDeletedMessageActivityTag()
	{
		Assert.assertTrue(successMsgAlart.isDisplayed(), "Detele Message is not showing or category not Deleted");
		String successMsg = successMsgAlart.getText();
		Assert.assertEquals(successMsg, "Category: " + activityTagNameModify + " deleted successfully");
	}

	@Step("Serach After Modified Activity Tag Table Text Box")
	public void searchAfterModifiedActivityTagTableTxtBx()
	{
		commons.waitUntilTime(searchActivityTagTable);
		this.searchActivityTagTable.sendKeys(activityTagNameModify);
	}

	@Step("Click Excel Activity Tag Table")
	public void clickExcelActivityTagTable() throws InterruptedException
	{
		this.excelActivityTagTable.click();
		Thread.sleep(2000);
	}

	@Step("Get WebActivity Tag Table Data")
	public void getWebActivityTagTableData()
	{
		commons.waitUntilTime(activityTagTable);
		List<WebElement> rowsInTable = this.activityTagTable.findElements(By.tagName("tr"));
		int rowsCount = rowsInTable.size();
		for (int i = 0; i < rowsCount; i++)
		{
			List<WebElement> columnsInTable = rowsInTable.get(i).findElements(By.tagName("td"));
			int columnsCount = columnsInTable.size();
			for (int j = 0; j < columnsCount; j++)
			{
				String cell = columnsInTable.get(j).getText();
				if (cell != null && cell != "" && cell != " " && !cell.isEmpty())
				{
					webActivityTagTableDataList.add(cell);

				}
				else
				{
					continue;
				}
			}

			columnsInTable.clear();
		}
		rowsInTable.clear();
	}

	@Step("Get Excel Activity Tag Table Data")
	public void getExcelActivityTagTableData() throws IOException, InterruptedException
	{

		Thread.sleep(2000);
		FileInputStream file = new FileInputStream(commons.getRecentFilePath());
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 1; i <= rowCount; i++)
		{
			int cellcount = sheet.getRow(i).getLastCellNum();
			for (int j = 0; j < cellcount; j++)
			{
				if (sheet.getRow(i).getCell(j).getStringCellValue() != null && sheet.getRow(i).getCell(j).getStringCellValue() != "")
				{

					excelActivityTagTableDataList.add(sheet.getRow(i).getCell(j).getStringCellValue());

				}
				else
				{
					continue;
				}

			}

		}
		workbook.close();
		file.close();

		commons.deleteFileByPath(commons.getRecentFilePath());

	}

	@Step("Validate Excel Data With Web")
	public void validateExcelDataWithWeb()
	{

		webActivityTagTableDataList.forEach(webData -> {
			Assert.assertTrue(excelActivityTagTableDataList.contains(webData));
		});
		webActivityTagTableDataList.clear();
		excelActivityTagTableDataList.clear();
		commons.deleteFileByPath(commons.getRecentFilePath());
	}

	@Step("Click on PDF Activity")
	public void clickPDFActivityTagTable()
	{
		this.pdfActivityTagTable.click();
	}

	@Step("Get Pdf Activity Tag Table Data")
	public void getPDFActivityTagTableData() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		driver.get("file:///" + commons.getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);
		pdfConten = new PDFTextStripper().getText(document);
		document.close();
		fileParse.close();
		inputstream.close();

		commons.deleteFileByPath(commons.getRecentFilePath());

	}

	@Step("Validate PDF Data With Web")
	public void validatePDFDataWithWeb()
	{

		webActivityTagTableDataList.forEach(data -> {
			Assert.assertTrue(pdfConten.contains(data));
		});
		webActivityTagTableDataList.clear();
		commons.deleteFileByPath(commons.getRecentFilePath());
	}

	@Step("Click On Bulk Upload Button")
	public void clickBulckUploadBtn()
	{
		commons.waitUntilTime(bulckUploadBtn);
		this.bulckUploadBtn.click();
	}

	@Step("Click On Bulk Upload With Pre Filled Data")
	public void clickBulckUploadWithPrefilledDataRB()
	{
		commons.waitUntilTime(bulckUploadWithPrefilledDataRB);
		this.bulckUploadWithPrefilledDataRB.click();
	}

	@Step("Click On Bulk Upload Click Here Link To get Excel")
	public void clickBulckUploadClickHereLinkToGetExcel()
	{
		this.bulckUploadClickHereLinkToGetExcel.click();

	}

	@Step("Get With Prefilled Excel Data")
	public void getWithPrefilledExcelData() throws IOException, InterruptedException
	{
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		FileInputStream file = new FileInputStream(commons.getRecentFilePath());
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 0; i <= rowCount; i++)
		{
			int cellcount = sheet.getRow(i).getLastCellNum();

			for (int j = 0; j < cellcount; j++)
			{

				if (sheet.getRow(i).getCell(j) != null)
				{

					if (sheet.getRow(i).getCell(j).getStringCellValue() != null && sheet.getRow(i).getCell(j).getStringCellValue() != "")
					{

						withPrefilledExcelDataList.add(sheet.getRow(i).getCell(j).getStringCellValue());

					}
					else
					{
						continue;
					}
				}
				else
				{
					break;

				}

			}

		}
		workbook.close();
		file.close();
		commons.deleteFileByPath(commons.getRecentFilePath());
		// withPrefilledExcelDataList.forEach(pfExcelData ->
		// System.out.println(pfExcelData));

	}

	@Step("Validate with prefilled eXCEL DATA WITH WEB")
	public void validateWithPrefilledExcelDataWithWeb()
	{

		webDataListForPrefilled.forEach(webData -> {
			Assert.assertTrue(withPrefilledExcelDataList.contains(webData));
		});
		webDataListForPrefilled.clear();
		withPrefilledExcelDataList.clear();
	}

	@Step("Get WebActivity Tag Table Data To compare Prefilled Data")
	public void getWebActivityTagTableDataToComparePrefilledData()
	{
		commons.waitUntilTime(activityTagTable);
		List<WebElement> rowsInTable = this.activityTagTable.findElements(By.tagName("tr"));
		int rowsCount = rowsInTable.size();
		for (int i = 0; i < rowsCount; i++)
		{
			List<WebElement> columnsInTable = rowsInTable.get(i).findElements(By.tagName("td"));
			int columnsCount = columnsInTable.size();
			for (int j = 0; j < columnsCount; j++)
			{
				String cell = columnsInTable.get(j).getText();
				if (cell != null && cell != "" && cell != " " && !cell.isEmpty())
				{
					if (cell.contains("Parent"))
					{
						cell = cell.replace("[", "").split("Parent")[0].trim();
						webDataListForPrefilled.add(cell);
					}
					else
					{
						webDataListForPrefilled.add(cell);
					}

				}
				else
				{
					continue;
				}
			}

		}
	}

	@Step("Click Bulk Upload Blank Template")
	public void clickBulckUploadBlankTemplateRB()
	{

		this.bulckUploadBlankTemplateRB.click();
	}

	@Step("Add Activity Tag Excel Bulk Uplaod")
	public void addActivityTagExcelBulckUpload() throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		addBulckUploadData.add("ADD");
		addBulckUploadData.add("Job Category");
		addBulckUploadData.add("Test dome");
		addBulckUploadData.add("Test dome");
		addBulckUploadData.add("Yes");
		addBulckUploadData.add("Yes");

		String path = commons.getRecentFilePath();
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
					cell.setCellValue(addBulckUploadData.get(k));
					k++;
				}
			}
			FileOutputStream fos = new FileOutputStream(path);
			workbook.write(fos);
			fos.close();
		}
	}

	@Step("Click on choose file in bulk upload")
	public void clickChooseFileInBulkUpload()
	{
		commons.waitForElementNotVisible(Duration.ofSeconds(30), driver, loadingIcon);
		this.chooseFileInBulkUploadinput.sendKeys(commons.getRecentFilePath());
		// his.bulkUploadBtn.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", bulkUploadBtn);
	}

	@Step("Validate in Bulk UPLOAD add message")
	public void validateBulkUploadAddMessage()
	{
		
		commons.waitForElementNotVisible(Duration.ofMinutes(15), driver,bulkUploadloadingIcon );
		Assert.assertTrue(bulkUploadalterMessage.isDisplayed(), "Alter Message is not showing");
		String successMsg = bulkUploadalterMessage.getText();
		successMsg = successMsg.replace("×", "").trim();

		Assert.assertEquals(successMsg, "Upload was successful", "File uploaded Error");
		
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

	}

	@Step("click on bulk upload back button")
	public void clickBulkUploadBackBtn()
	{

		this.bulkUploadBackBtn.click();
	}

	@Step("validate bulk upload add to web data")
	public void validateBulkUploadAddToWebData()
	{
		Assert.assertTrue(webActivityTagTableDataList.contains(addBulckUploadData.get(2)));
		Assert.assertTrue(webActivityTagTableDataList.contains(addBulckUploadData.get(3)));
		webActivityTagTableDataList.clear();
	}

	@Step("get Index Modify Activity tag excel BULK upload")
	public int getIndexmodifyActivityTagExcelBulckUpload(String ExceptedData) throws IOException
	{
		int i;
		FileInputStream file = new FileInputStream(commons.getRecentFilePath());
		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheet("Sheet1");
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (i = 3; i <= rowCount; i++)
			{
				sheet.getRow(i).getLastCellNum();

				if (sheet.getRow(i).getCell(5) != null)
				{
					String columnData = sheet.getRow(i).getCell(5).getStringCellValue();
					if (columnData.equals(ExceptedData))
					{
						break;
					}
					else
					{
						continue;
					}

				}
				else
				{
					continue;
				}
			}
			workbook.close();
		}
		file.close();

		return i;
	}

	@Step("Modify Activity Tag With Excel Bulk Upload")
	public void modifyActivityTagExcelBulckUpload() throws IOException, InterruptedException
	{

		Thread.sleep(1000);
		String path = commons.getRecentFilePath();
		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheetAt(0);

			Row row = sheet.getRow(getIndexmodifyActivityTagExcelBulckUpload(activityTagNameAddInBulkUpload));
			int cellcount = sheet.getRow(getIndexmodifyActivityTagExcelBulckUpload(activityTagNameAddInBulkUpload)).getLastCellNum() - 5;

			Cell celloperation = row.createCell(1);

			celloperation.setCellValue("MOD");

			Cell cell = row.createCell(cellcount);

			cell.setCellValue(activityTagNameModifyingValuesInBulkUpload);
			Cell cell1 = row.createCell(cellcount + 1);

			cell1.setCellValue(activityTagNameModifyingValuesInBulkUpload);

			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
			fileOutputStream.close();

			workbook.close();
		}
		file.close();

	}

	@Step("Validate Bulk Upload Modifief with Web Data")
	public void validateBulkUploadModifiedWithWebData()
	{
		Assert.assertTrue(webActivityTagTableDataList.contains(activityTagNameModifyingValuesInBulkUpload));
		Assert.assertTrue(webActivityTagTableDataList.contains(activityTagNameModifyingValuesInBulkUpload));
		webActivityTagTableDataList.clear();
		commons.deleteFileByPath(commons.getRecentFilePath());
	}

	@Step("Get Index To delete activity tag Excel Bulk Upload")
	public int getIndexToDateleActivityTagExcelBulckUpload() throws IOException
	{
		int i;
		FileInputStream file = new FileInputStream(commons.getRecentFilePath());
		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheet("Sheet1");
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (i = 3; i <= rowCount; i++)
			{
				sheet.getRow(i).getLastCellNum();

				if (sheet.getRow(i).getCell(5) != null)
				{
					String columnData = sheet.getRow(i).getCell(5).getStringCellValue();

					if (columnData != null && columnData != "")
					{
						if (columnData == activityTagNameModifyingValuesInBulkUpload)
						{
							break;
						}

					}
					else
					{
						continue;
					}

				}
				else
				{
					continue;

				}
			}
			workbook.close();
		}
		file.close();
		return i;
	}

	@Step("Delete Activity Tag Excel Bulk Upload")
	public void deleteActivityTagExcelBulckUpload() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		String path = commons.getRecentFilePath();

		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheetAt(0);

			Row row = sheet.getRow(getIndexmodifyActivityTagExcelBulckUpload(activityTagNameModifyingValuesInBulkUpload));

			sheet.getRow(getIndexmodifyActivityTagExcelBulckUpload(activityTagNameModifyingValuesInBulkUpload)).getLastCellNum();

			Cell celloperation = row.createCell(1);

			celloperation.setCellValue("DEL");

			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
			fileOutputStream.close();

			workbook.close();
		}
		file.close();
	}

	@Step("Validate Bulk Upload Dalete with web data")
	public void validateBulkUploadDeletedWithWebData()
	{
		Assert.assertFalse(webActivityTagTableDataList.contains(activityTagNameModifyingValuesInBulkUpload));
		Assert.assertFalse(webActivityTagTableDataList.contains(activityTagNameModifyingValuesInBulkUpload));
		webActivityTagTableDataList.clear();
		commons.deleteFileByPath(commons.getRecentFilePath());
	}
	@Step("Search After Added ACTIVITY Tag table Text box")
	public void searchAfteraddedActivityTagTableTxtBx()
	{
		commons.waitUntilTime(searchActivityTagTable);
		this.searchActivityTagTable.sendKeys(activityTagNameAdd);
	}
	
	@Step("Click Delete Activity Tag Before Modify")
	public void clickDeleteActivityTagbeforeModify()
	{
		driver.findElement(beforeModifyIconActivityTag).click();
	}
}
