package net.pages_worktimemodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Step;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;

public class WorkTimeAuditTrailPage
{
	WebDriver			driver;

	CommonMethodsPage	commonMethodsPage	= new CommonMethodsPage(BaseTest.driver);

	SoftAssert			softAssert			= new SoftAssert();

	@FindBy(xpath = "//select[@id=\"orgId\"]")
	WebElement			organizationDropDown;

	@FindBy(xpath = "//div[@id=\"selectedAction\"]")
	WebElement			actionDropDown;

	@FindBy(xpath = "//input[@id=\"selectAllActionNameId\"]")
	WebElement			selectAllChxBx;

	@FindBy(xpath = "//input[@value=\"FETCH\"]")
	WebElement			fetchBtn;

	@FindBy(xpath = "//table[@class=\"dataTable no-footer\"]//tbody")
	WebElement			auditTarilDataTable;

	public WorkTimeAuditTrailPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@Step("Get Organization DropDown Values in Audit Trail Page")
	public List<String> getOrgDropDownValues()
	{
		List<String> dropDownValuesList = new ArrayList<String>();
		Select select = new Select(organizationDropDown);
		List<WebElement> dropDownElementsList = select.getOptions();
		dropDownElementsList.forEach(optionElements -> {
			dropDownValuesList.add(optionElements.getText());
		});
		return dropDownValuesList;
	}

	@Step("Select Action in DropDown")
	public void clickActionDropDown()
	{
		commonMethodsPage.waitUntilTime(actionDropDown);
		this.actionDropDown.click();
	}

	@Step("Click FetchBtn")
	public void clickFetchBtn()
	{
		commonMethodsPage.waitUntilTime(fetchBtn);
		this.fetchBtn.click();
	}
	@Step("Check Select AllChkBx")
	public void checkSelectAllChkBx()
	{
		commonMethodsPage.selectCheckBox(selectAllChxBx);
	}
	@Step("Check unSelect AllChkBx")
	public void unCheckSelectAllChkBx()
	{
		commonMethodsPage.unselectCheckBox(selectAllChxBx);
	}

	@Step("select ActionChkBx ")
	public void selectActionChkBx(String actionType)
	{
		WebElement actionChxBx = driver.findElement(By.xpath("//input[@value=\"" + actionType + "\"]"));
		commonMethodsPage.selectCheckBox(actionChxBx);
	}

	@Step("select Organization in OrgDropDown")
	public void selectOrganizationInOrgDropDown(String OrgName)
	{
		Select select = new Select(organizationDropDown);
		select.selectByVisibleText(OrgName);
	}

	@Step("Get Values Audit Taril DataTable")
	public List<String> getValuesAuditTarilDataTable()
	{
		commonMethodsPage.waitUntilTime(auditTarilDataTable);
		List<String> auditTabelDataList = new ArrayList<String>();
		List<WebElement> rowList = this.auditTarilDataTable.findElements(By.tagName("tr"));
		for (WebElement row : rowList)
		{
			List<WebElement> columnList = row.findElements(By.tagName("td"));
			for (WebElement column : columnList)
			{
				if (column != null)
				{
					String cell = column.getText();
					if (cell != " " && !cell.isEmpty())
					{
						auditTabelDataList.add(cell);
					}
				}
			}
		}
		return auditTabelDataList;
	}
	@Step("Get Organization Details in Excel")
	public List<String> getOrganizationDetailsInExcel() throws IOException, InterruptedException
	{

		// Thread.sleep(2000);
		List<String> organizationDetailsExcelList = new ArrayList<String>();
		FileInputStream file = new FileInputStream(commonMethodsPage.getRecentFilePath());
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("ProHance");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 6; i <= rowCount; i++)
		{
			int cellcount = sheet.getRow(i).getLastCellNum();
			for (int j = 1; j < cellcount; j++)
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

}
