package net.pages_worktimemodule;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Step;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;

public class UserGroupMysqlPage extends BaseTest
{
	WebDriver			driver;

	public String		userGroupName			= "Production Team";

	public String		workTemplateValue		= "Implementation Team";

	public String		workProfileValue		= "Implementation Work Profile";

	public String		funtions				= "ProHance Sales";

	public String		userGroupNameModify		= "Production Modified Team";

	public String		workTemplateValueModify	= "Customer Success Work Template";

	public String		workProfileValueModify	= "Customer Success Work Profile";

	public String		bulkUploadModify		= "Demo test Team Modify";

	public String		funtionsModify			= "Digital Sales";

	List<String>		addBulckUploadData		= new ArrayList<String>();

	CommonMethodsPage	commons					= new CommonMethodsPage(BaseTest.driver);

	SoftAssert			softAssert				= new SoftAssert();

	@FindBy(xpath = "//li[contains(text(),'Teams')]")
	WebElement			teamsTab;

	@FindBy(xpath = "//form[@id=\"ConfigureUserGroupForm\"]//label[contains(text(),'ADD NEW')]")
	WebElement			addNewBtn;

	@FindBy(xpath = "//input[@id=\"userGroupName\"]")
	WebElement			userGroupNameTxtBx;

	@FindBy(xpath = "//textarea[@id=\"userGroupDescription\"]")
	WebElement			userGroupNameDescriptionTxtA;

	@FindBy(xpath = "//select[@id=\"workTemplateId\"]")
	WebElement			workTemplateDropDown;

	@FindBy(xpath = "//select[@id=\"workProfileId\"]")
	WebElement			workProfileDropDown;

	@FindBy(xpath = "//select[@id=\"superGroupId\"]")
	WebElement			functionsDropDown;

	@FindBy(xpath = "//button[@onclick=\"fnSaveUserGroupDetails(this.form)\"]")
	WebElement			detailsSaveBtn;

	@FindBy(xpath = "//span[contains(text(),'Associate Users')]")
	WebElement			associateUsersTab;

	@FindBy(xpath = "//button[contains(text(),\"ADD USERS\")]")
	WebElement			addUsersBtn;

	@FindBy(xpath = "//span[contains(text(),'Active')]//ancestor::tr//td//input")
	WebElement			usersChkBx;

	@FindBy(xpath = "//button[contains(text(),'ADD')]")
	WebElement			addBtnOfUser;

	@FindBy(xpath = "//span[contains(text(),'Associate Work Shifts')]")
	WebElement			associateWorkShiftTab;

	@FindBy(xpath = "//span[contains(text(),'Associate Work Types')]")
	WebElement			associateWorkTypesTab;

	@FindBy(xpath = "//button[@onclick=\"fnAddTemplates(this.form)\"]")
	WebElement			addWorkTypeBtn;

	@FindBy(xpath = "//span[contains(text(),'Active')]//ancestor::tr//td//input")
	WebElement			workTypeChkBx;

	@FindBy(xpath = "//input[@type=\"search\"]")
	WebElement			searchboxInUserGroupTable;

	@FindBy(xpath = "//button[contains(text(),'CLEAR')]")
	WebElement			clearBtn;

	@FindBy(xpath = "//span[@id=\"successmsgdiv\"]")
	WebElement			successAlrt;

	@FindBy(xpath = "//button[contains(text(),\"EXIT\")]")
	WebElement			exitBtn;

	@FindBy(xpath = "//div[@id=\"CommonDataTableId_wrapper\"]//table//tbody")
	WebElement			dataOfUserGroupDataTable;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tbody//tr//td//a")
	WebElement			editIcon;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tbody//tr//td//a[2]")
	WebElement			deleteIcon;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tr//th//input")
	WebElement			removeUsersChkBx;

	@FindBy(xpath = "//button[contains(text(),'REMOVE USERS')]")
	WebElement			removeUserBtn;

	@FindBy(xpath = "//button[contains(text(),'REMOVE WORK TYPES')]")
	WebElement			removeWorkTypesBtn;

	@FindBy(xpath = "//div[@id=\"confirmModal\"]//div/button[2]")
	WebElement			confirmationYesBtn;

	@FindBy(xpath = "//span[contains(text(),'Click here')]")
	WebElement			clickHereRemoveDataDependency;

	@FindBy(xpath = "//input[@value=\"deleteUserMappingByUserGroupId\"]")
	WebElement			dependentChxBxToRemoveDataDepandency;

	@FindBy(xpath = "//input[@value=\"DELETE DEPENDENT DATA\"]")
	WebElement			deleteDataDepandencyBtn;

	@FindBy(xpath = "//label[contains(text(),\"BULK UPLOAD\")]")
	WebElement			bulkUploadBtn;

	@FindBy(xpath = "//label[contains(text(),\"Blank Template\")]//ancestor::span/input")
	WebElement			blankTemplateChkBx;

	@FindBy(xpath = "//label[contains(text(),\"With Prefilled Data\")]//ancestor::span/input")
	WebElement			withPrefilledDataChkBx;

	@FindBy(xpath = "//span[contains(text(),\"Click here\")]")
	WebElement			clickHereToDownloadBulkUploadExcel;

	@FindBy(xpath = "//input[@id=\"userUploadButton\"]")
	WebElement			uploadBtn;

	@FindBy(xpath = "//input[@id=\"userGroupXLUpload\"]")
	WebElement			uploaFileInputTxtBx;

	@FindBy(xpath = "//span[@id=\"messageSpan\"]")
	WebElement			alertMsgForUploadFile;

	@FindBy(xpath = "//label[text()=\"BACK\"]")
	WebElement			backBtnInBulkUpload;

	@FindBy(xpath = "//img[@src=\"/prohance/images/excel.png\"]")
	WebElement			excelIcon;

	@FindBy(xpath = "//img[@src=\"/prohance/images/pdf.png\"]")
	WebElement			pdfIcon;

	// @FindBy(xpath = "//button[contains(text(),'ADD')]")
	// WebElement workTypeChkBx;
	public UserGroupMysqlPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step("Click on Teams Tab in Admin Menu")
	public void clickTeamsTab()
	{
		commons.waitUntilTime(teamsTab);
		this.teamsTab.click();
	}

	@Step("Click AddNew Btn to Add Teams")
	public void clickAddNewBtn()
	{
		this.addNewBtn.click();
	}

	@Step("Click ClearBtn")
	public void clickClearBtn()
	{
		this.clearBtn.click();
	}

	@Step("Click Details SaveBtn")
	public void clickDetailsSaveBtn()
	{
		this.detailsSaveBtn.click();
	}

	@Step("Click AssociateUsers Tab")
	public void clickAssociateUsersTab()
	{
		this.associateUsersTab.click();
	}

	@Step("Click AssociateWorkTypes Tab")
	public void clickAssociateWorkTypesTab()
	{
		this.associateWorkTypesTab.click();
	}

	@Step("Click AddUsers Btn in Teams Tab")
	public void clickAddUsersBtn()
	{
		this.addUsersBtn.click();
	}

	@Step("Add Details For UserGroup")
	public void addDetailsForUserGroup()
	{
		commons.waitUntilTime(userGroupNameTxtBx);
		this.userGroupNameTxtBx.sendKeys(userGroupName);
		this.userGroupNameDescriptionTxtA.sendKeys(userGroupName);
		Select objSelect = new Select(this.workTemplateDropDown);
		objSelect.selectByVisibleText(workTemplateValue);

		objSelect = new Select(this.workProfileDropDown);
		objSelect.selectByVisibleText(workProfileValue);

		objSelect = new Select(this.functionsDropDown);
		objSelect.selectByVisibleText(funtions);

	}

	@Step("validate SucessMsg")
	public void validateSucessMsg()
	{
		Assert.assertTrue(successAlrt.isDisplayed(), "Success Message is not shown");
		Assert.assertEquals(successAlrt.getText(), "Teams: " + userGroupName + " added successfully");
	}

	@Step("Select the Users")
	public void selectUsers()
	{
		commons.selectjavaScriptCheckBox(usersChkBx);
		commons.scrollElementToView(addBtnOfUser);
	}

	@Step("Click AddBtn Of User")
	public void clickAddBtnOfUser()
	{
		this.addBtnOfUser.click();
	}

	@Step("Validate SucessMsg User Association")
	public void validateSucessMsgUserAssociation()
	{
		Assert.assertTrue(successAlrt.isDisplayed(), "Success Message is not shown");
		Assert.assertEquals(successAlrt.getText(), "Teams: " + userGroupName + " saved successfully");
	}

	@Step("Click Add WorkTypeBtn")
	public void clickAddWorkTypeBtn()
	{
		this.addWorkTypeBtn.click();
	}

	@Step("Select WorkType ChkBx")
	public void selectWorkTypeChkBx()
	{
		commons.selectjavaScriptCheckBox(workTypeChkBx);
		commons.scrollElementToView(addBtnOfUser);
	}

	@Step("Validate SucessMsg WrokType")
	public void validateSucessMsgWrokType()
	{
		Assert.assertTrue(successAlrt.isDisplayed(), "Success Message is not shown");
		Assert.assertEquals(successAlrt.getText(), "Work Type Mapping saved successfully");
	}

	@Step("Exit For Tab")
	public void exitBtn()
	{
		this.exitBtn.click();

	}

	@Step("Searchbox In UserGroup Table input")
	public void searchboxInUserGroupTableinput(String searchKey)
	{
		this.searchboxInUserGroupTable.sendKeys(searchKey);
	}

	@Step("Get WebUserGroup TableData")
	public List<String> getWebUserGroupTableData()
	{
		List<String> webUserGroupDataList = new ArrayList<String>();
		List<WebElement> rowsInTable = this.dataOfUserGroupDataTable.findElements(By.tagName("tr"));
		int rowsCount = rowsInTable.size();
		for (int i = 0; i < rowsCount; i++)
		{
			List<WebElement> columnsInTable = rowsInTable.get(i).findElements(By.tagName("td"));
			int columnsCount = columnsInTable.size();
			for (int j = 0; j < columnsCount; j++)
			{
				String cell = columnsInTable.get(j).getText();
				if (cell != null && cell != "" && !cell.isEmpty())
				{
					webUserGroupDataList.add(cell);

				}
				else
				{
					continue;
				}
			}

			columnsInTable.clear();
		}

		rowsInTable.clear();
		return webUserGroupDataList;

	}

	@Step("Get getWebUserGroup TableData Without Space")
	public List<String> getWebUserGroupTableDataWithoutSpace()
	{
		List<String> webUserGroupDataList = new ArrayList<String>();
		List<WebElement> rowsInTable = this.dataOfUserGroupDataTable.findElements(By.tagName("tr"));
		int rowsCount = rowsInTable.size();
		for (int i = 0; i < rowsCount; i++)
		{
			List<WebElement> columnsInTable = rowsInTable.get(i).findElements(By.tagName("td"));
			int columnsCount = columnsInTable.size();
			for (int j = 0; j < columnsCount; j++)
			{
				String cell = columnsInTable.get(j).getText();
				if (cell != null && cell != "" && !cell.isEmpty())
				{
					// if(cell.trim().substring(cell.length()) == "."){
					// cell = cell.replace(".", "");
					// }
					cell = cell.replace(".", "").replace(" ", "");
					webUserGroupDataList.add(cell);

				}
				else
				{
					continue;
				}
			}

			columnsInTable.clear();
		}

		rowsInTable.clear();
		return webUserGroupDataList;

	}

	@Step("Validate UserGroup Add or Not")
	public void validateUserGroupAdd(List<String> webUserGroupDataList)
	{

		softAssert.assertTrue(webUserGroupDataList.contains(userGroupName), "Usergroups are not Added in UserGroup Table Table");
		softAssert.assertAll();

	}

	@Step("Click EditIcon")
	public void clickEditIcon()
	{
		searchboxInUserGroupTableinput(userGroupName);
		this.editIcon.click();

	}

	@Step("Modify Details For UserGroup")
	public void modifyDetailsForUserGroup()
	{
		this.userGroupNameTxtBx.clear();
		this.userGroupNameTxtBx.sendKeys(userGroupNameModify);
		this.userGroupNameDescriptionTxtA.clear();
		this.userGroupNameDescriptionTxtA.sendKeys(userGroupNameModify);
		Select objSelect = new Select(this.workTemplateDropDown);
		objSelect.selectByVisibleText(workTemplateValueModify);

		objSelect = new Select(this.workProfileDropDown);
		objSelect.selectByVisibleText(workProfileValueModify);

		objSelect = new Select(this.functionsDropDown);
		objSelect.selectByVisibleText(funtionsModify);
	}

	@Step("Validate Modified SucessMsg")
	public void validateModifiedSucessMsg()
	{
		Assert.assertTrue(successAlrt.isDisplayed(), "Success Message is not shown");
		Assert.assertEquals(successAlrt.getText(), "Teams: " + userGroupNameModify + " modified successfully");
	}

	@Step("Remove User In AssoicateUsers")
	public void removeUserInAssoicateUsers()
	{
		commons.selectjavaScriptCheckBox(removeUsersChkBx);

	}

	@Step("Click Remove UsersBtn")
	public void clickRemoveUsersBtn()
	{
		this.removeUserBtn.click();

	}

	@Step("Click Remove WorkTypesBtn")
	public void clickRemoveWorkTypesBtn()
	{
		this.removeWorkTypesBtn.click();

	}

	@Step("Validate SucessMsg Modified UserAssociation")
	public void validateSucessMsgModifiedUserAssociation()
	{
		Assert.assertTrue(successAlrt.isDisplayed(), "Success Message is not shown");
		Assert.assertEquals(successAlrt.getText(), "Teams: " + userGroupNameModify + " saved successfully");
	}

	@Step("Validate SucessMsg WrokType To Removed")
	public void validateSucessMsgWrokTypeToRemove()
	{
		Assert.assertTrue(successAlrt.isDisplayed(), "Success Message is not shown");
		Assert.assertEquals(successAlrt.getText(), "Work Type Mapping has been removed successfully");
	}

	@Step("Validate SucessMsg WrokType To Removed")
	public void validateUserGroupModifyValuePrasentTheTable(List<String> webUserGroupDataList)
	{

		softAssert.assertTrue(webUserGroupDataList.contains(userGroupNameModify), "Usergroups are not Modified in UserGroup Table Table");
		softAssert.assertAll();
	}

	@Step("Click DeleteIcon")
	public void clickDeleteIcon()
	{
		searchboxInUserGroupTableinput(userGroupNameModify);
		this.deleteIcon.click();

	}

	@Step("Click Confirmation YesBtn for deletion")
	public void clickConfirmationYesBtn()
	{
		commons.waitUntilTime(confirmationYesBtn);
		this.confirmationYesBtn.click();

	}

	@Step("ClickHere to Remove DataDependency")
	public void clickHereRemoveDataDependency()
	{
		Assert.assertTrue(clickHereRemoveDataDependency.isDisplayed());

		this.clickHereRemoveDataDependency.click();

	}

	@Step("Select DependentChxBx To Remove DataDepandency")
	public void selectDependentChxBxToRemoveDataDepandency()
	{
		commons.waitUntilTime(deleteDataDepandencyBtn);
		commons.selectjavaScriptCheckBox(dependentChxBxToRemoveDataDepandency);

	}

	@Step("Click delete DataDepandencyBtn")
	public void clickdeleteDataDepandencyBtn()
	{

		this.deleteDataDepandencyBtn.click();

	}

	@Step("Validate UserGroup Delete the ValuePrasent from Table")
	public void validateUserGroupDeleteValuePrasentTheTable(List<String> webUserGroupDataList)
	{
		softAssert.assertFalse(webUserGroupDataList.contains(userGroupNameModify), "Usergroups are not Deleted in UserGroup Table Table");
		softAssert.assertAll();
	}

	@Step("Validate SucessMsg Deleted")
	public void validateSucessMsgDeleted()
	{
		commons.waitUntilTime(successAlrt);
		Assert.assertTrue(successAlrt.isDisplayed(), "Success Message is not shown");
		Assert.assertEquals(successAlrt.getText(), "Teams: " + userGroupNameModify + " deleted successfully");
	}

	@Step("ClickBulk UploadBtn")
	public void clickBulkUploadBtn()
	{
		commons.waitUntilTime(bulkUploadBtn);
		this.bulkUploadBtn.click();
	}

	@Step("Click WithPrefilledData ChkBx")
	public void clickWithPrefilledDataChkBx()
	{

		commons.selectjavaScriptCheckBox(withPrefilledDataChkBx);
	}

	@Step("Click BlankTemplate ChkBx")
	public void clickBlankTemplateChkBx()
	{

		commons.selectjavaScriptCheckBox(blankTemplateChkBx);
	}

	@Step("ClickHere To Download BulkUpload Excel")
	public void clickHereToDownloadBulkUploadExcel()
	{
		commons.waitUntilTime(clickHereToDownloadBulkUploadExcel);
		this.clickHereToDownloadBulkUploadExcel.click();
	}

	@Step("ClickChooseFile In BulkUpload")
	public void clickChooseFileInBulkUpload()
	{

		this.uploaFileInputTxtBx.sendKeys(commons.getRecentFilePath());
		// this.uploadBtn.click();
		commons.waitUntilTime(uploadBtn);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", uploadBtn);
	}

	@Step("AddUserGroupNames BulckUpload")
	public List<String> addUserGroupNamesExcelBulckUpload() throws IOException, InterruptedException
	{
		Thread.sleep(2000);

		addBulckUploadData.add("ADD");
		addBulckUploadData.add("Demo test Team");
		addBulckUploadData.add("Demo test Team");
		addBulckUploadData.add("Implementation Team");
		addBulckUploadData.add("Engineering Team Work Profile");
		addBulckUploadData.add("ADMIN");

		String path = commons.getRecentFilePath();
		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheetAt(0);
			sheet.getLastRowNum();
			for (int i = 2; i <= 2; i++)
			{
				Row row = sheet.getRow(i);

				// int cellcount = sheet.getRow(i).getLastCellNum() - 1;

				int k = 0;
				for (int j = 1; j <= addBulckUploadData.size() + 1; j++)
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
		return addBulckUploadData;
	}

	@Step("Validate SuccessMsg For UploadFile")
	public void validateSuccessMsgForUploadFile()
	{

		softAssert.assertTrue(alertMsgForUploadFile.isDisplayed(), "Alter Message is not showing");
		String successMsg = alertMsgForUploadFile.getText();
		successMsg = successMsg.replace("×", "").trim();
		softAssert.assertEquals("Upload was successful", successMsg, "BulkUpload File is Not Upload Properly or Message is not showing");

	}

	@Step("Click BackBtn In BulkUpload")
	public void clickBackBtnInBulkUpload()
	{
		this.backBtnInBulkUpload.click();

	}

	@Step("validate UserGroup Added or not in WebData table")
	public void validateAddUserGroupWithWebData(List<String> webUserGroupDataList, List<String> addBulckUploadData)
	{
		int addBulckUploadDatalistSize = addBulckUploadData.size() - 1;
		int StringLength = addBulckUploadData.get(addBulckUploadDatalistSize).length();
		if (StringLength > 60)
		{

			String str = addBulckUploadData.get(addBulckUploadDatalistSize);
			str = str.replace(str.substring(str.length() - 1, str.length()), "");
			str = str.substring(0, str.length()) + "...";

			addBulckUploadData.set(addBulckUploadDatalistSize, str);
		}
		addBulckUploadData.stream().skip(1).forEach(data -> {

			softAssert.assertTrue(webUserGroupDataList.contains(data));
		});

		softAssert.assertAll();
		addBulckUploadData.clear();
		commons.deleteFileByPath(commons.getRecentFilePath());
		softAssert.assertAll();

	}

	@Step("Get Index to Modified UserGroupName in BulckUpload")
	public int getIndexModifiedUserGroupNameExcelBulckUpload(String ExceptedData) throws IOException
	{
		int i;
		FileInputStream file = new FileInputStream(commons.getRecentFilePath());
		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheet("Sheet1");
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (i = 2; i <= rowCount; i++)
			{
				sheet.getRow(i).getLastCellNum();

				if (sheet.getRow(i).getCell(3) != null)
				{
					String columnData = sheet.getRow(i).getCell(3).getStringCellValue();

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

	@Step("Modify UserGroupName in BulckUpload")
	public String modifyUserGroupExcelBulckUpload() throws IOException, InterruptedException
	{
		Thread.sleep(7000);
		
		String path = commons.getRecentFilePath();
		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheetAt(0);

			Row row = sheet.getRow(getIndexModifiedUserGroupNameExcelBulckUpload("Demo test Team"));
			int cellcount = sheet.getRow(getIndexModifiedUserGroupNameExcelBulckUpload("Demo test Team")).getLastCellNum() - 1;

			Cell celloperation = row.createCell(1);

			celloperation.setCellValue("MOD");

			Cell cell = row.createCell(cellcount - 5);

			cell.setCellValue(bulkUploadModify);

			Cell cell1 = row.createCell(cellcount - 4);

			cell1.setCellValue(bulkUploadModify);

			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
			fileOutputStream.close();

			workbook.close();
		}
		file.close();
		return bulkUploadModify;

	}

	@Step("Validate UserGroupName has Modified ro not in WebData")
	public void validateModifyUserGroupWithWebData(List<String> webUserGroupDataList, String bulkUploadModify)
	{

		softAssert.assertTrue(webUserGroupDataList.contains(bulkUploadModify));
		softAssert.assertAll();
		commons.deleteFileByPath(commons.getRecentFilePath());

	}

	@Step("Delete UserGroupName in BulckUpload")
	public void deleteUserGroupExcelBulckUpload() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		String path = commons.getRecentFilePath();
		FileInputStream file = new FileInputStream(path);

		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(getIndexModifiedUserGroupNameExcelBulckUpload(bulkUploadModify));

			// sheet.getRow(getIndexModifiedSuperGroupNameExcelBulckUpload(superGroupNameAdd)).getLastCellNum()
			// - 1;

			Cell celloperation = row.createCell(1);

			celloperation.setCellValue("DEL");

			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
			fileOutputStream.close();

			workbook.close();
		}
		file.close();

	}

	@Step("Validate UserGroupName has Deleted or not in WebData")
	public void validateDeletedUserGroupWithWebData(List<String> webUserGroupDataList)
	{

		softAssert.assertFalse(webUserGroupDataList.contains(bulkUploadModify));
		softAssert.assertAll();
		commons.deleteFileByPath(commons.getRecentFilePath());

	}

	@Step("Click PDFIcon")
	public void clickPDFIcon()
	{

		this.pdfIcon.click();

	}

	@Step("Click ExcelIcon")
	public void clickExcelIcon()
	{
		this.excelIcon.click();
	}

	@Step("Get PDFUserGroup data")
	public String getPDFUserGroupTableData() throws IOException, InterruptedException
	{
		Thread.sleep(2000);

		driver.get("file:///" + commons.getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);
		String pdfFileContent = new PDFTextStripper().getText(document);
		document.close();
		fileParse.close();
		inputstream.close();
		return pdfFileContent;
	}

	@Step("Validate UserGroupName PDFData With WebData")
	public void validateUserGroupPDFDataWithWebData(List<String> webUserGroupDataList, String pdfFileContent) throws IOException, InterruptedException
	{

		webUserGroupDataList.forEach(data -> {
			Assert.assertTrue(pdfFileContent.contains(data), "PDF Values are not match with Web Usergroup Table");
		});
		webUserGroupDataList.clear();
		commons.deleteFileByPath(commons.getRecentFilePath());
		System.gc();
		softAssert.assertAll();
	}

	@Step("Get ExcelData For UserGroupTable")
	public List<String> getExcelDataForUserGroupTable() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		List<String> excelUserGroupNameDataList = new ArrayList<String>();
		FileInputStream file = new FileInputStream(commons.getRecentFilePath());
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 1; i <= rowCount; i++)
		{
			int cellcount = sheet.getRow(i).getLastCellNum();

			// if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
			for (int j = 0; j < cellcount; j++)
			{
				Cell cell = sheet.getRow(i).getCell(j);
				CellType type = cell.getCellType();
				if (type == CellType.STRING)

				{
					if (cell.getStringCellValue() != null && cell.getStringCellValue() != "")
					{
						String value = cell.getStringCellValue();
						if (value.length() > 60)
						{
							int atualLength = value.length() - 60;
							excelUserGroupNameDataList.add(value.substring(0, value.length() - atualLength) + "...");
						}
						else
						{

							excelUserGroupNameDataList.add(cell.getStringCellValue());
						}

					}
					else
					{
						continue;
					}

				}
				else if (type == CellType.NUMERIC)
				{
					excelUserGroupNameDataList.add(String.valueOf((int) cell.getNumericCellValue()));

				}

			}

		}

		workbook.close();
		file.close();
		commons.deleteFileByPath(commons.getRecentFilePath());
		return excelUserGroupNameDataList;
	}

	@Step("Validate ExcelData With WebUserGroup")
	public void validateExcelDataWithWebUserGroup(List<String> webUserGroupDataList, List<String> excelUserGroupNameDataList)
	{

		webUserGroupDataList.forEach(webData -> {

			softAssert.assertTrue(excelUserGroupNameDataList.contains(webData));
		});
		excelUserGroupNameDataList.clear();
		webUserGroupDataList.clear();
		commons.deleteFileByPath(commons.getRecentFilePath());
		softAssert.assertAll();
	}

}
