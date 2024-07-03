package net.pages_workflowmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

import io.qameta.allure.Step;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;

public class CustomAttributeBulkUploadPages
{
	WebDriver			driver;

	@FindBy(xpath = "//a[contains(text(),\"WORKFLOW\")]")
	WebElement			workflow;

	@FindBy(xpath = "//a[contains(text(),\"Administration\")]")
	WebElement			administration;

	@FindBy(xpath = "//li[contains(text(),\"Custom Attributes\")]")
	WebElement			customAttribute;

	@FindBy(xpath = "//label[contains(text(),\"BULK UPLOAD\")]")
	WebElement			bulkUpload;

	@FindBy(id = "showProcess_EP")
	WebElement			tempWithData;

	@FindBy(xpath = "//tr[@id =\"downloadTR\"]/td/span[contains(text(),\"Click here\")]")
	WebElement			clickHere;

	@FindBy(xpath = "//input[@id=\"showProcess_NP\"]")
	WebElement			ClickBlankTemplate;

	@FindBy(xpath = "//table[@id='uploadTable']/tbody/tr[1]/td[2]/div/span/span/span/input[@id=\"file_id\"]")
	WebElement			chooseFileBtn;

	@FindBy(name = "upload")
	WebElement			upload;

	@FindBy(xpath = "//div[@id=\"message-area\"]/div/span")
	WebElement			successMsg;

	@FindBy(xpath = "//div[@id=\"message-area\"]/div/span")
	WebElement			failMsg;

	@FindBy(xpath = "//input[@id=\"attributeName\"]")
	WebElement			customAttributeNameTxt;

	@FindBy(xpath = "//input[@value=\"SAVE\"]")
	WebElement			saveBtn;

	@FindBy(xpath = "//label[contains(text(),'BACK')]")
	WebElement			backBtn;

	@FindBy(id = "processListId")
	WebElement			filterByProcess;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]/span")
	List<WebElement>	getProcessList;

	CommonMethodsPage	CommonMethodsPage	= new CommonMethodsPage(BaseTest.driver);

	public CustomAttributeBulkUploadPages(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@Step("Click WorkFlowBtn ")
	public void clickWorkFlowBtn()
	{
		this.workflow.click();
	}

	@Step("switchTabs")
	public void switchTabs()
	{

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));

	}

	@Step("Scroll SideNavigationBar")
	public void scrollSideNavigationBar()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//a[contains(text(),'Administration')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
	}

	@Step("Click AdministrationBtn")
	public void clickAdministrationBtn()
	{
		CommonMethodsPage.waitUntilTime(administration);
		this.administration.click();
	}

	@Step("Click CustomAttribute")
	public void clickCustomAttribute()
	{
		this.customAttribute.click();
	}

	@Step("Click BulkUpload")
	public void clickBulkUpload()
	{
		CommonMethodsPage.waitUntilTime(bulkUpload);
		this.bulkUpload.click();
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", bulkUpload);
	}

	@Step("Click backBtn")
	public void clickBackBtn()
	{
		CommonMethodsPage.waitUntilTime(backBtn);
		this.backBtn.click();
	}

	@Step("Click TempWithData")
	public void clickTempWithData()
	{
		this.tempWithData.click();
	}

	@Step("Click BlankTemplate")
	public void clickBlankTemplate()
	{
		this.ClickBlankTemplate.click();
	}

	@Step("ClickHere HyperLink")
	public void clickClickHereBtn()
	{
		this.clickHere.click();
	}

	@Step("Modify Custom Attributes")
	public void modifyCustomAttributes(String customAttributesName)
	{

		By customAttributesNameModify = By.xpath("//span[contains(text(),\"" + customAttributesName + "\")]//ancestor::tr//span[@title=\"Modify\"]");
		driver.findElement(customAttributesNameModify).click();

	}

	@Step("Modify the Custom Attribute")
	public void CustomAttributesNameModify(String name)
	{
		this.customAttributeNameTxt.clear();
		this.customAttributeNameTxt.sendKeys(name);

	}

	@Step("Click SaveBtn")
	public void saveBtn()
	{
		this.saveBtn.click();
	}

	@Step("ClickHere ChooseFileBtn")
	public String clickChooseFileBtn(String url) throws InterruptedException
	{
		WebElement choose = this.chooseFileBtn;
		choose.sendKeys(url);
		this.upload.click();
		return url;

	}

	@Step("Click SuccessMsg")
	public boolean clickSuccessMsg()
	{
		String ms = this.successMsg.getText();
		String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
		String compareMsg = "Uploadwassuccessful";
		boolean check = msg.equals(compareMsg);
		return check;
	}

	@Step("Get FailMsg")
	public boolean getFailMsg()
	{
		String ms = this.failMsg.getText();
		String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
		String compareMsg = "Uploadcompletedwitherror(s)";
		boolean check = msg.equals(compareMsg);
		return check;

	}

	// @Step("Select FilterBy Process")
	// public void selectFilterByProcess(String user)
	// {
	// Select clickAssUser = new Select(this.filterByProcess);
	// clickAssUser.selectByVisibleText(user);
	// }

	@Step("Select FilterBy Process")
	public void selectFilterByProcess(String user)
	{
		    filterByProcess.click();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'"+user+"')]")));
	        option.click();
	}

	@Step("Get UserArrtribute")
	public List<String> GetUserArrtribute()
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList<String>();
		col = this.getProcessList;
		int len = col.size();
		for (int i = 0; i < len; i++)
		{
			teamsList.add(this.getProcessList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println(
			// teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		return teamsList;
	}

	@Step("Get IndexModified custom Attributes ExcelBulckUpload")
	public int getIndexModifiedCustomAttributesNameExcelBulckUpload(String ExceptedData) throws IOException
	{
		int i;
		FileInputStream file = new FileInputStream(CommonMethodsPage.getRecentFilePath());
		try (Workbook workbook = new XSSFWorkbook(file))
		{
			Sheet sheet = workbook.getSheet("Sheet1");
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			for (i = 3; i <= rowCount; i++)
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

}
