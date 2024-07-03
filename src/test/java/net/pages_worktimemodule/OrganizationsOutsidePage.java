package net.pages_worktimemodule;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Step;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;

public class OrganizationsOutsidePage
{
	WebDriver			driver;

	CommonMethodsPage	commonMethodsPage	= new CommonMethodsPage(BaseTest.driver);
	
	SoftAssert softAssert = new SoftAssert();

	@FindBy(xpath = "//div[@id=\"menu-list-sidebar\"]")
	WebElement			sideMeun;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody")
	WebElement			commonTable;

	@FindBy(xpath = "//label[contains(text(),'ADD NEW')]")
	WebElement			addOrganizationBtn;

	@FindBy(xpath = "//div[@class=\"body-padded config-detail-container\"]//input[@value=\"SAVE\"]")
	WebElement			orgSaveBtn;

	@FindBy(xpath = "//input[@name=\"organizationName\"]")
	WebElement			orgNameTxtBx;

	@FindBy(xpath = "//input[@id=\"orgCode\"]")
	WebElement			orgCodeTxtBx;

	@FindBy(xpath = "//input[@name=\"agentBasedCount\"]")
	WebElement			agentBasedUserCountTxtBx;

	@FindBy(xpath = "//input[@name=\"agentlessCount\"]")
	WebElement			agentlessUserCountTxtBx;

	@FindBy(xpath = "//input[@id=\"fullName\"]")
	WebElement			fullNameTxtBx;

	@FindBy(xpath = "//input[@id=\"adminLoginId\"]")
	WebElement			adminLoginIdTxtBx;

	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement			passwordTxtBx;

	@FindBy(xpath = "//input[@id=\"confirmPassword\"]")
	WebElement			confirmPasswordTxtBx;

	@FindBy(xpath = "//div[@id=\"adminLoadingModal\"]//img[@src=\"images/loader-large.gif\"]")
	By					loaderIcon;

	@FindBy(xpath = "//span[@id=\"successmsgdiv\"]")
	WebElement			successMessage;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody")
	WebElement			organizationTable;

	@FindBy(xpath = "//ul[@id=\"leftMenus\"]//li")
	WebElement			navModulesName;
	
	@FindBy(xpath = "//input[@type=\"search\"]")
	WebElement			searchTxtBx;

	@FindBy(xpath = "(//div[@id=\"confirmModal\"]//button[contains(text(),\"YES\")])[last()]")
	WebElement			confrimationYesBtn;

	@FindBy(xpath = "//span[@id=\"successmsgdiv\"]")
	WebElement			successMsg;

	@FindBy(xpath = "//div[@id=\"CommonDataTableId_wrapper\"]//img[@src=\"/prohance/images/pdf.png\"]")
	WebElement			orgPdfImg;

	@FindBy(xpath = "//div[@id=\"CommonDataTableId_wrapper\"]//img[@src=\"/prohance/images/excel.png\"]")
	WebElement			orgExcelImg;

	public OrganizationsOutsidePage(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@Step("SideMenu For Outside Organization")
	public void sideMenuForOutsideOrganization(String mainMenuLabel, String subMenuLabel)
	{
		commonMethodsPage.waitUntilTime(sideMeun);
		WebElement mainMenuLabelElement = driver.findElement(By.xpath("//a[contains(text(),\'" + mainMenuLabel + "\')]"));
		WebElement mainMenuStatusElement = driver.findElement(By.xpath("//a[contains(text(),\'" + mainMenuLabel + "\')]//parent::li"));
		boolean mainMenuStatus = Boolean.valueOf(mainMenuStatusElement.getAttribute("aria-expanded"));
		WebElement subMenuLabelElement = driver.findElement(By.xpath("//li[text()=\'" + subMenuLabel + "\']"));
		

		if (mainMenuStatus)
		{
			commonMethodsPage.waitUntilTime(subMenuLabelElement);
			subMenuLabelElement.click();
		}
		else
		{
			commonMethodsPage.waitUntilTime(mainMenuLabelElement);
			mainMenuLabelElement.click();
			commonMethodsPage.waitUntilTime(subMenuLabelElement);
			subMenuLabelElement.click();
		}

	}
	@Step("Get SpecificColumnData In Table")
	public List<String> getSpecificColumnDataInTable(int column)
	{
		List<String> specificColumnDataList = new ArrayList<String>();
		commonMethodsPage.waitUntilTime(commonTable);
		List<WebElement> rowsInTable = this.commonTable.findElements(By.tagName("tr"));
		int rowsCount = rowsInTable.size();
		for (int i = 0; i < rowsCount; i++)
		{
			List<WebElement> columnsInTable = rowsInTable.get(i).findElements(By.tagName("td"));
			String cell = columnsInTable.get(column).getText();

			if (cell != null && cell != "" && cell != " " && !cell.isEmpty())
			{
				specificColumnDataList.add(cell);

			}
			else
			{
				continue;
			}
			columnsInTable.clear();

		}
		rowsInTable.clear();

		return specificColumnDataList;

	}
	@Step("Add Organizations")
	public void addOrganizations(HashMap<String, String> oraganizationDetails)
	{

		List<String> specificColumnDataList = getSpecificColumnDataInTable(1);
		boolean orgAlreadyExists = specificColumnDataList.stream().anyMatch(organizationNames -> organizationNames.equals(oraganizationDetails.get("oraganizationName")));
		if (orgAlreadyExists)
		{
			Assert.fail("Oraganization is Already Creadted");
		}
		else
		{
			commonMethodsPage.waitUntilTime(addOrganizationBtn);
			this.addOrganizationBtn.click();
			this.orgNameTxtBx.sendKeys(oraganizationDetails.get("oraganizationName"));
			this.orgCodeTxtBx.sendKeys(oraganizationDetails.get("oraganizationCode"));
			this.agentBasedUserCountTxtBx.sendKeys(oraganizationDetails.get("agentBasedUserCount"));
			this.agentlessUserCountTxtBx.sendKeys(oraganizationDetails.get("agentlessUserCount"));
			String modules = oraganizationDetails.get("modules");

			List<String> moduleList = Arrays.stream(modules.split(",")).map(String::trim).collect(Collectors.toList());
			selectModules(moduleList);
			this.fullNameTxtBx.sendKeys(oraganizationDetails.get("orgAdminUserName"));
			this.adminLoginIdTxtBx.sendKeys(oraganizationDetails.get("orgAdminUserName"));
			this.passwordTxtBx.sendKeys(oraganizationDetails.get("orgAdminPassword"));
			this.confirmPasswordTxtBx.sendKeys(oraganizationDetails.get("orgAdminPassword"));

		}

	}
	@Step("select Modules")
	public void selectModules(List<String> moduleList)
	{

		for (Iterator<String> iterator = moduleList.iterator(); iterator.hasNext();)
		{
			String string = (String) iterator.next();
			WebElement moduleNames = driver.findElement(By.xpath("//label[contains(text(),\'" + string + "\')]//parent::span//input"));
			commonMethodsPage.selectCheckBox(moduleNames);

		}
	}
	@Step("clickSaveBtn")
	public void clickSaveBtn()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(15));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
		wait.until(ExpectedConditions.visibilityOf(orgSaveBtn));
		this.orgSaveBtn.click();
	}
	@Step("Validate SuccessMessage")
	public String validateSuccessMessage()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		String actualText = this.successMessage.getText();
		return actualText;
	}
	@Step("Get WebOrganizations Data")
	public List<String> getWebOrganizationsData()
	{
		List<String> webSuperGroupNameDataList = new ArrayList<String>();
		commonMethodsPage.waitUntilTime(organizationTable);

		List<WebElement> rowsInTable = this.organizationTable.findElements(By.tagName("tr"));
		int rowsCount = rowsInTable.size();
		for (int i = 0; i < rowsCount; i++)
		{
			List<WebElement> columnsInTable = rowsInTable.get(i).findElements(By.tagName("td"));
			int columnsCount = columnsInTable.size();
			for (int j = 1; j < columnsCount; j++)
			{
				String cell = columnsInTable.get(j).getText();
				if (cell != null && cell != " " && !cell.isEmpty())
				{

					webSuperGroupNameDataList.add(cell.replaceAll("\\r?\\n", " ").trim());
				}
				else
				{
					continue;
				}
			}

			columnsInTable.clear();
		}
		rowsInTable.clear();
		return webSuperGroupNameDataList;

	}
	@Step("Navigate To InsideOrg")
	public void navigateToInsideOrg(String orgName) throws InterruptedException
	{
		// commonMethodsPage.wait(200);
		/*
		 * System.out.println(orgName); WebElement orgNameSpan =
		 * driver.findElement(By.xpath("//span[contains(text(),\'" + orgName +
		 * "\')]")); System.out.println(orgNameSpan.toString());
		 * JavascriptExecutor executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", orgNameSpan);
		 */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement orgNameSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\'" + orgName + "\')]")));
		System.out.println(orgNameSpan.toString());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", orgNameSpan);

	}
	
	@Step("Navigate To InsideOrg")
	public void modifyNavigateToInsideOrg() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement orgNameSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id=\"CommonDataTableId\"]//tr//td[2]/span")));
		System.out.println(orgNameSpan.toString());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", orgNameSpan);

	}
	@Step("Modify Organizations")
	public void modifyOrganizations(HashMap<String, String> oraganizationDetails)
	{

		List<String> specificColumnDataList = getSpecificColumnDataInTable(1);
		boolean orgAlreadyExists = specificColumnDataList.stream().anyMatch(organizationNames -> organizationNames.equals(oraganizationDetails.get("oraganizationName")));
		if (orgAlreadyExists)
		{
			Assert.fail("Oraganization is Already Exit");
		}
		else
		{
			commonMethodsPage.waitUntilTime(addOrganizationBtn);
			this.addOrganizationBtn.click();
			this.orgNameTxtBx.sendKeys(oraganizationDetails.get("oraganizationName"));
			this.orgCodeTxtBx.sendKeys(oraganizationDetails.get("oraganizationCode"));
			this.agentBasedUserCountTxtBx.sendKeys(oraganizationDetails.get("agentBasedUserCount"));
			this.agentlessUserCountTxtBx.sendKeys(oraganizationDetails.get("agentlessUserCount"));
			String modules = oraganizationDetails.get("modules");

			List<String> moduleList = Arrays.stream(modules.split(",")).map(String::trim).collect(Collectors.toList());
			selectModules(moduleList);
			this.fullNameTxtBx.sendKeys(oraganizationDetails.get("orgAdminUserName"));
			this.adminLoginIdTxtBx.sendKeys(oraganizationDetails.get("orgAdminUserName"));
			this.passwordTxtBx.sendKeys(oraganizationDetails.get("orgAdminPassword"));
			this.confirmPasswordTxtBx.sendKeys(oraganizationDetails.get("orgAdminPassword"));

		}

	}
	@Step("Get ModulesName in inSide Organization")
	public List<String> getModulesName()
	{
		List<String> modulesNameList = new ArrayList<String>();
		List<WebElement> rowsInTable = driver.findElements(By.xpath("//ul[@id=\"leftMenus\"]//li/following-sibling::li"));
		WebElement workTime = driver.findElement(By.xpath("//ul[@id=\"leftMenus\"]//following-sibling::li[1]"));
		modulesNameList.add(workTime.getText());
		System.out.println(rowsInTable.size());
		commonMethodsPage.waitUntilTime(navModulesName);

		int rowsCount = rowsInTable.size();
		for (int i = 0; i < rowsCount; i++)
		{
			System.out.println(rowsInTable.get(i).toString());
			if (rowsInTable.get(i).getText() != "")
			{

				modulesNameList.add(rowsInTable.get(i).getText());
			}
		}
		rowsInTable.clear();
		return modulesNameList;

	}
	@Step("Enter Search TxtBx")
	public void enterSearchTxtBx(String orgNames)
	{
		this.searchTxtBx.sendKeys(orgNames);
	}
	@Step("Enter Search TxtBx")
	public void clearSearchTxtBx()
	{
		this.searchTxtBx.clear();
	}
	@Step("Click Modify Icon")
	public void clickModifyIcon(String orgName)
	{

		WebElement orgEditIcon = driver.findElement(By.xpath("//span[contains(text(),\'" + orgName + "\')]//ancestor::tr/td/span[@title=\"Modify\"]"));
		orgEditIcon.click();
	}
	@Step("Click Delete Icon")
	public void clickDeleteIcon(String orgName)
	{

		WebElement orgDeleteIcon = driver.findElement(By.xpath("//span[contains(text(),\'" + orgName + "\')]//ancestor::tr/td/span[@title=\"Delete\"]"));
		orgDeleteIcon.click();
		commonMethodsPage.waitUntilTime(confrimationYesBtn);
		confrimationYesBtn.click();
	}
	@Step("Validate Deleted")
	public String validateDeleted()
	{
		return this.successMsg.getText();

	}
	@Step("Validate Module CheckBox")
	public boolean validateModuleCheckBox(List<String> moduleList)
	{
		int lastIndex = moduleList.size() - 1;
		if (!moduleList.isEmpty())
		{
			String lastModule = moduleList.get(lastIndex);
			WebElement addedModuleCheckbox = driver.findElement(By.xpath("//label[contains(text(),\'" + lastModule + "\')]//parent::span//input"));
			commonMethodsPage.selectCheckBox(addedModuleCheckbox);
		}
		for (String module : moduleList)
		{
			WebElement moduleNames = driver.findElement(By.xpath("//label[contains(text(),\'" + module + "\')]//parent::span//input"));

			if (!moduleNames.isSelected())
			{
				return false;
			}
		}
		return true;
	}
	@Step("Modify the Organizations")
	public boolean modifyOrganizations(HashMap<String, String> oraganizationDetailsMap, String orgName, HashMap<String, String> addedDetailsMap)
	{
		List<String> specificColumnDataList = getSpecificColumnDataInTable(1);
		boolean orgAlreadyExists = specificColumnDataList.stream().anyMatch(organizationNames -> organizationNames.equals(oraganizationDetailsMap.get("oraganizationName")));
		if (orgAlreadyExists)
		{
			Assert.fail("Oraganization is Already Creadted");

		}
		else
		{
			clickModifyIcon(orgName);

			validateExictingDataOrgModification(addedDetailsMap);
			this.orgNameTxtBx.clear();
			this.orgNameTxtBx.sendKeys(oraganizationDetailsMap.get("oraganizationName"));
			this.orgCodeTxtBx.clear();
			this.orgCodeTxtBx.sendKeys(oraganizationDetailsMap.get("oraganizationCode"));
			this.agentBasedUserCountTxtBx.clear();
			this.agentBasedUserCountTxtBx.sendKeys(oraganizationDetailsMap.get("agentBasedUserCount"));
			this.agentlessUserCountTxtBx.clear();
			this.agentlessUserCountTxtBx.sendKeys(oraganizationDetailsMap.get("agentlessUserCount"));
			String modules = oraganizationDetailsMap.get("modules");

			List<String> moduleList = Arrays.stream(modules.split(",")).map(String::trim).collect(Collectors.toList());
			boolean moduleNamecheckBoxStatus = validateModuleCheckBox(moduleList);

			return moduleNamecheckBoxStatus;

		}
		return false;
	}
	@Step("Get Organization Data From the Table")
	public List<String> getOrganizationDataFromTable()
	{

		List<String> orgDetailsDataList = new ArrayList<String>();
		commonMethodsPage.waitUntilTime(commonTable);
		List<WebElement> rowsInTable = this.commonTable.findElements(By.tagName("tr"));
		int rowsCount = rowsInTable.size();

		for (int i = 0; i < rowsCount; i++)
		{
			List<WebElement> columnsInTable = rowsInTable.get(i).findElements(By.tagName("td"));
			int columnsCount = columnsInTable.size();
			for (int j = 1; j < columnsCount; j++)
			{
				String cell = columnsInTable.get(j).getText();
				if (cell != null && cell != "" && cell != " " && !cell.isEmpty())
				{
					orgDetailsDataList.add(cell.replaceAll("\\r?\\n", " ").trim());

				}
				else
				{
					continue;
				}
			}
			columnsInTable.clear();

		}
		rowsInTable.clear();

		return orgDetailsDataList;
	}

	@Step("Validate Exicting Data OrgModification")
	public void validateExictingDataOrgModification(HashMap<String, String> addedDetailsMap)
	{
		softAssert.assertTrue(this.orgNameTxtBx.getAttribute("value").equals("oraganizationName"), "Org Name is different form Modifying page");
		softAssert.assertTrue(this.orgCodeTxtBx.getAttribute("value").equals("oraganizationCode"), "Org code is different form Modifying page");
		softAssert.assertTrue(this.agentBasedUserCountTxtBx.getAttribute("value").equals("agentBasedUserCount"), "Org AgentBased count is different form Modifying page");
		softAssert.assertTrue(this.agentlessUserCountTxtBx.getAttribute("value").equals("agentlessUserCount"), "Org agentlessCount is different form Modifying page");

	}

	@Step("Click PDF Img")
	public void clickPDFImg()
	{
		this.orgPdfImg.click();
	}
	@Step("Get Organization Details in PDF")
	public String getOrganizationDetailsInPDF() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		driver.get("file:///" + commonMethodsPage.getRecentFilePath());
		URL url = new URL(driver.getCurrentUrl());
		InputStream inputstream = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(inputstream);
		PDDocument document = PDDocument.load(fileParse);
		String pdfConten = new PDFTextStripper().getText(document);
		document.close();
		fileParse.close();
		inputstream.close();

		commonMethodsPage.deleteFileByPath(commonMethodsPage.getRecentFilePath());
		return pdfConten;
	}
	@Step("Click Excel OraganizationTable")
	public void clickExcelOraganizationTable() throws InterruptedException
	{
		this.orgExcelImg.click();
		Thread.sleep(2000);
	}
	@Step("Get Organization Details in Excel")
	public List<String> getOrganizationDetailsInExcel() throws IOException, InterruptedException
	{

		// Thread.sleep(2000);
		List<String> organizationDetailsExcelList = new ArrayList<String>();
		FileInputStream file = new FileInputStream(commonMethodsPage.getRecentFilePath());
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 1; i <= rowCount; i++)
		{
			int cellcount = sheet.getRow(i).getLastCellNum();
			for (int j = 0; j < cellcount; j++)
			{
				Cell cell = sheet.getRow(i).getCell(j);
				if (cell != null)
				{
					if (cell.getCellType().equals(CellType.NUMERIC))
					{
						organizationDetailsExcelList.add(String.valueOf(cell.getNumericCellValue()));

					}
					else if (cell.getCellType().equals(CellType.STRING))
					{

						if (cell.getStringCellValue() != null && cell.getStringCellValue().isEmpty())
						{

							organizationDetailsExcelList.add(cell.getStringCellValue());
						}
					}

				}
				else
				{
					continue;
				}

			}

		}
		workbook.close();
		file.close();

		commonMethodsPage.deleteFileByPath(commonMethodsPage.getRecentFilePath());
		return organizationDetailsExcelList;
	}
	@Step("Click For Sorting")
	public void clickForSorting(String columnNumber)
	{
		WebElement element = driver.findElement(By.xpath("//table[@class=\"dataTable no-footer\"]//th[@aria-controls=\"CommonDataTableId\"][" + columnNumber + "]"));
		element.click();
	}
	@Step("Get Sorted Org WebData")
	public List<String> getSortedOrgWebData(int column)
	{
		List<String> webWorkTemplateSortedList = new ArrayList<String>();
		commonMethodsPage.waitUntilTime(organizationTable);
		List<WebElement> rowsInTable = this.organizationTable.findElements(By.tagName("tr"));
		int rowsCount = rowsInTable.size();
		for (int i = 0; i < rowsCount; i++)
		{
			List<WebElement> columnsInTable = rowsInTable.get(i).findElements(By.tagName("td"));
			String cell = columnsInTable.get(column).getText();

			if (cell != null && cell != "" && cell != " " && !cell.isEmpty())
			{
				webWorkTemplateSortedList.add(cell.replaceAll("\\r?\\n", " ").trim());

			}
			else
			{
				continue;
			}
			columnsInTable.clear();

		}
		rowsInTable.clear();

		return webWorkTemplateSortedList;

	}


}