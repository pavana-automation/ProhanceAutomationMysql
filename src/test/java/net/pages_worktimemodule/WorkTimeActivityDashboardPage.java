package net.pages_worktimemodule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class WorkTimeActivityDashboardPage extends BaseTest
{
	WebDriver			driver;

	CommonMethodsPage	commons		= new CommonMethodsPage(BaseTest.driver);

	SoftAssert			softAssert	= new SoftAssert();

	@FindBy(xpath = "//span[contains(text(),\"Add New Widget\")]")
	WebElement			addNewWidgetsBtn;

	@FindBy(xpath = "//div[contains(text(),\"ADD WIDGET	\")]")
	WebElement			addWidgetBtn;

	@FindBy(xpath = "//div[@class=\"widget-title\"]//span[last()]")
	WebElement			widgetTitelDiv;

	@FindBy(xpath = "//span[@title=\"Remove\"]/parent::div//input[@value=\"Yes\"]")
	WebElement			removeYesBtn;

	@FindBy(xpath = "//span[@title=\"Report Filter\"]")
	WebElement			widgetFilterBtn;

	@FindBy(xpath = "//select[@id=\"reportType\"]")
	WebElement			topCategoriesFilterChartTypeDropDown;
	
	@FindBy(xpath = "//select[@id=\"reportChartType\"]")
	WebElement			categoryUsageTrendFilterChartTypeDropDown;

	@FindBy(xpath = "//select[@id=\"Width\"]")
	WebElement			topCategoriesFilterWigdgetWidthDropDown;

	@FindBy(xpath = "//div[@id=\"s2id_dynaGroupId\"]")
	WebElement			userGroupDropDownToOpen;

	@FindBy(xpath = "//select[@id=\"displayUnit\"]")
	WebElement			topCategoriesFilterDisplayInDropDown;

	@FindBy(xpath = "//select[@id=\"userType\"]")
	WebElement			topCategoriesFilterUserTypeDropDown;

	@FindBy(xpath = "//select[@id=\"classificationListId\"]")
	WebElement			topCategoriesFilterAfterSelectActvityTagClassificationDropdown;

	@FindBy(xpath = "//select[@id=\"numOfBars\"]")
	WebElement			topCategoriesFilterAfterSelectActvityTagTopNCategoriesDropdown;
	
	@FindBy(xpath = "//span[contains(text(),\"CANCEL\")]")
	WebElement			cancelBtn;
	
	@FindBy(xpath = "//img[@src=\"images/prohance-blue-logo.png\"]")
	WebElement			logoImg;

	public WorkTimeActivityDashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step("NavigetToModules")
	public void navigetToModules(String module, String sunModules) throws InterruptedException
	{
		WebElement mainModule = driver.findElement(By.xpath("//ul[@id=\"leftMenus\"]//a[contains(text(),'" + module + "')]"));
		WebElement subModule = driver.findElement(By.xpath("//a[text()=\"" + sunModules + "\"]"));
		if (!module.isEmpty() && !module.isBlank())
		{
			commons.waitUntilTime(mainModule);
			mainModule.click();

			if (!sunModules.isBlank() && !sunModules.isEmpty())
			{
				commons.waitUntilTime(subModule);
				subModule.click();
			}
		}

	}
	
	//Overloading
	@Step("NavigetToModules")
	public void navigetToModules(String module) throws InterruptedException
	{
		WebElement mainModule = driver.findElement(By.xpath("//ul[@id=\"leftMenus\"]//a[contains(text(),'" + module + "')]"));
		if (module.isEmpty() && module.isBlank())
		{
			commons.waitUntilTime(mainModule);
			mainModule.click();
		}

	}
	
	@Step("Select Widget")
	public void selectWidget(String widgetName)
	{

		List<WebElement> widgetCountList = driver.findElements(By.xpath("//span[@title=\"Remove\"]"));
		int widgetsCount = widgetCountList.size();
		if (widgetsCount == 0)
		{
			addWidgetToDashboard(widgetName);
		}
		else if (widgetsCount > 1)
		{
			for (WebElement removeIcon : widgetCountList)
			{
				commons.waitUntilTime(removeIcon);
				removeIcon.click();
				this.removeYesBtn.click();
			}
			addWidgetToDashboard(widgetName);

		}
		else
		{
			String widgetsTitel = widgetTitelDiv.getText();
			String[] widgetsTitelSplitArray = widgetsTitel.split("For");
			if (!widgetsTitelSplitArray[0].trim().equals("widgetName"))
			{

				for (WebElement removeIcon : widgetCountList)
				{
					commons.waitUntilTime(removeIcon);
					removeIcon.click();
					this.removeYesBtn.click();
				}
				addWidgetToDashboard(widgetName);
			}
		}

	}

	@Step("Add Widget To Dashboard")
	public void addWidgetToDashboard(String widgetName)
	{
		commons.waitUntilTime(addNewWidgetsBtn);
		this.addNewWidgetsBtn.click();
		WebElement mainModule = driver.findElement(By.xpath("//span[contains(text(),\"" + widgetName + "\")]"));
		commons.waitUntilTime(mainModule);
		mainModule.click();
		commons.waitUntilTime(mainModule);
		this.addWidgetBtn.click();
	}

	@Step("Click Widget FilterBtn")
	public void clickWidgetFilterBtn()
	{
		commons.waitUntilTime(widgetFilterBtn);
		this.widgetFilterBtn.click();

	}
	
	@Step("Click CancelBtn")
	public void clickCancelBtn()
	{
		commons.waitUntilTime(cancelBtn);
		this.cancelBtn.click();
		
	}
	
	@Step("Click LogoImg")
	public void clickLogoImg()
	{
		commons.waitUntilTime(logoImg);
		this.logoImg.click();
		
	}

	@Step("Selecting Filters In TopCategories Widget")
	public void selectingFiltersInTopCategoriesWidget(Map<String, String> filtersValues)
	{
		Map<WebElement, String> dropdownMap = new HashMap<>();
		dropdownMap.put(topCategoriesFilterChartTypeDropDown, filtersValues.get("chartType"));
		dropdownMap.put(topCategoriesFilterWigdgetWidthDropDown, filtersValues.get("widgetWidth"));
		dropdownMap.put(topCategoriesFilterDisplayInDropDown, filtersValues.get("displayIn"));
		dropdownMap.put(topCategoriesFilterUserTypeDropDown, filtersValues.get("userType"));
		for (Map.Entry<WebElement, String> entry : dropdownMap.entrySet())
		{
			try
			{
				System.out.println(entry.getKey().toString());
				System.out.println(entry.getValue().toString());
				selectDropdownValue(entry.getKey(), entry.getValue());

				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		selectUserGroupDropdown(filtersValues.get("Teams"));
		reportByRadioBtnInTopcategoriesFilter(filtersValues.get("reportBy"));
	}
	
	@Step("Selecting Filters In CategoryUsageTrend Widget")
	public void selectingFiltersInCategoryUsageTrendWidget(Map<String, String> filtersValues)
	{
		Map<WebElement, String> dropdownMap = new HashMap<>();
		dropdownMap.put(categoryUsageTrendFilterChartTypeDropDown, filtersValues.get("chartType"));
		dropdownMap.put(topCategoriesFilterWigdgetWidthDropDown, filtersValues.get("widgetWidth"));
		
		for (Map.Entry<WebElement, String> entry : dropdownMap.entrySet())
		{
			try
			{
				selectDropdownValue(entry.getKey(), entry.getValue());

				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		selectUserGroupDropdown(filtersValues.get("Teams"));
		reportByRadioBtnInTopcategoriesFilter(filtersValues.get("reportBy"));
	}
	
	@Step("Select UserGroup Dropdown")
	public void selectUserGroupDropdown(String selectingTeams)
	{
		this.userGroupDropDownToOpen.click();
		WebElement selectTeam = driver.findElement(By.xpath("//div[contains(text(),\"" + selectingTeams + "\")]"));
		selectTeam.click();

	}

	@Step("ReportBy Radio Btn In Topcategories Filter")
	public void reportByRadioBtnInTopcategoriesFilter(String reportByName)
	{
		WebElement reportByRaBtn = driver.findElement(By.xpath("//label[contains(text(),\"" + reportByName + "\")]//parent::div//input"));
		reportByRaBtn.click();

	}

	@Step("Select DropdownValue")
	public void selectDropdownValue(WebElement locator, String dropDownValues)
	{
		Select select = new Select(locator);
		select.selectByVisibleText(dropDownValues);
	}

	@Step("Get Classfication Values")
	public List<String> getClassficationValues()
	{
		List<String> classficationList = new ArrayList<String>();
		Select select = new Select(topCategoriesFilterAfterSelectActvityTagClassificationDropdown);

		List<WebElement> optionsList = select.getOptions();
		for (WebElement option : optionsList)
		{
			classficationList.add(option.getText());
		}
		return classficationList;
	}
	

}
