package net.pages_worktimemodule;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Step;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;



public class CategoryPage extends BaseTest
{
	public String		activityAOSName1;

	public String		activityAOSName2;

	public String		categoryNameToAdd	= "Test Demo Category";

	public String		categoryNameModify	= "Test Demo Category Modify";

	WebDriver			driver;

	CommonMethodsPage	commons				= new CommonMethodsPage(BaseTest.driver);

	SoftAssert			softAssert			= new SoftAssert();

	@FindBy(xpath = "//li[text()='Categories']")
	WebElement			categoriesBtn;

	@FindBy(xpath = "//span[text()='Category']/ancestor::li")
	WebElement			categoryTab;

	@FindBy(xpath = "//label[text()='ADD NEW']")
	WebElement			addNewBtn;

	@FindBy(xpath = "//input[@name=\"applicationCategoryName\"]")
	WebElement			inputCategoryNameTxtBx;

	@FindBy(xpath = "//textarea[@id=\"applicationCategoryDescription\"]")
	WebElement			inputCategoryDescriptionTxtBx;

	@FindBy(xpath = "//label[text()=\"Activities On System\"]//parent::div/input")
	WebElement			inputActivitiesOnSystemChkBk;

	@FindBy(xpath = "//label[text()=\"Activities Away From System\"]//parent::div/input[last()-1]")
	WebElement			inputActivitiesAwayFromSystemChkBk;

	@FindBy(xpath = "//tr[@id=\"applnDetailsTable\"]//input[@value=\"ADD\"]")
	WebElement			activityAOSAddbtn;

	@FindBy(xpath = "//div[@class=\"tabDetailDataDiv body-padded\"]//input[@value=\"SAVE\"]")
	WebElement			categorysavebtn;

	@FindBy(xpath = "//iframe[@id=\"contentFrame\"]")
	WebElement			iframe;

	@FindBy(xpath = "//span[text()='Activities On System']")
	WebElement			activitiesOnSystemTab;

	@FindBy(xpath = "//span[text()='Activities Away From System']")
	WebElement			activitiesAwayFromSystemTab;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[1]//input")
	WebElement			activitiesAOSChkBk1;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[2]//input")
	WebElement			activitiesAOSChkBk2;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[1]/td[2]")
	WebElement			getNameOfAOSactivitiesToAdd1;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[2]/td[2]")
	WebElement			getNameOfAOSactivitiesToAdd2;

	@FindBy(xpath = "//button[@name=\"add\"]")
	WebElement			addSelectedAOSactivitiesbtn;

	@FindBy(xpath = "//table[@id=\"customAosDatatable\"]/tbody/tr[1]/td")
	WebElement			getNameOfAOSactivitiesAfterAdd1;

	@FindBy(xpath = "//table[@id=\"customAosDatatable\"]/tbody/tr[2]/td")
	WebElement			getNameOfAOSactivitiesAfterAdd2;

	@FindBy(xpath = "//tr[@id=\"idleTimeTable\"]//table//tr[1]/td[2]//input")
	WebElement			activityAAFSAddBtn;

	@FindBy(xpath = "//form[@id=\"ConfigureApplicationCategoryForm\"]//input[@value=\"SAVE\"]")
	WebElement			saveCategoryBtn;

	@FindBy(xpath = "//span[@id='successmsgdiv']")
	WebElement			successMsgAlart;

	@FindBy(xpath = "//div[@id=\"CommonDataTableId_filter\"]//input")
	WebElement			searchTxtBx;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]//tbody/tr[1]/td[2]")
	WebElement			nameCategoryTable;

	@FindBy(xpath = "//div[@id=\"confirmModal\"]//div/button[2]")
	WebElement			confirmToDeleteYesBtn;
	
	@FindBy(xpath = "//div[@id=\"mainContentDiv\"]//img[@src=\"images/loader-large.gif\"]")
	WebElement			loadingIcon;
	
	By					deleteIconCategory	= By.xpath("//div[text()=\'" + categoryNameModify + "\']//ancestor::tr//td/a[2]");

	By					modifyIconCategory	= By.xpath("//div[text()=\'" + categoryNameToAdd + "\']//ancestor::tr//td/a[1]");


	public CategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step("Click on Category Button")
	public void clickcategoriesBtn()
	{
		commons.waitUntilTime(categoriesBtn);
		this.categoriesBtn.click();
	}

	@Step("Click on Category Tab")
	public void clickCategoryTab()
	{
		commons.waitUntilTime(categoryTab);
		this.categoryTab.click();
	}

	@Step("Click on add new Button")
	public void clickaddNewBtn()
	{
		commons.waitUntilTime(addNewBtn);
		this.addNewBtn.click();
	}

	@Step("Click on add New Category")
	public void addNewCategory()
	{
		this.inputCategoryNameTxtBx.sendKeys(categoryNameToAdd);
		this.inputCategoryDescriptionTxtBx.sendKeys(categoryNameToAdd);
		commons.selectCheckBox(inputActivitiesOnSystemChkBk);
		commons.selectCheckBox(inputActivitiesAwayFromSystemChkBk);

	}

	@Step("Click on Select Frame")
	public void selectFrame()
	{
		driver.switchTo().frame(iframe);
	}
	
	@Step("Click on Unselect Frame")
	public void unselectFrame()
	{
		driver.switchTo().defaultContent();
	}

	@Step("Click on Activities On System Tab")
	public void clickActivitiesOnSystemTab()
	{
		this.activitiesOnSystemTab.click();
	}

	@Step("Click on Activities Away From System Tab")
	public void clickActivitiesAwayFromSystemTab()
	{
		this.activitiesAwayFromSystemTab.click();
	}

	@Step("Click on Activity AOS Add Btn")
	public void clickActivityAOSAddbtn()
	{
		this.activityAOSAddbtn.click();
	}

	@Step("Click on add AOS Activities")
	public void addAOSActivities()
	{
		commons.selectjavaScriptCheckBox(activitiesAOSChkBk1);
		commons.selectjavaScriptCheckBox(activitiesAOSChkBk2);
		activityAOSName1 = getNameOfAOSactivitiesToAdd1.getText();
		activityAOSName2 = getNameOfAOSactivitiesToAdd2.getText();
		commons.scrollElementToView(addSelectedAOSactivitiesbtn);
		addSelectedAOSactivitiesbtn.click();

	}

	@Step("Click on AOS Activities Names")
	public void validateAOSActivityiesNames()
	{
		String activityTypeNameAdded1 = getNameOfAOSactivitiesAfterAdd1.getText();
		String activityTypeNameAdded2 = getNameOfAOSactivitiesAfterAdd2.getText();

		softAssert.assertEquals(activityTypeNameAdded1, activityAOSName1, "ASO Names are not Added in Activity Type");

		softAssert.assertEquals(activityTypeNameAdded2, activityAOSName2, "ASO Names are not Added in Activity Type");
	}

	@Step("Navigate ON Main Window")
	public void navigateMainWindow(String mainWindow)
	{

		driver.switchTo().window(mainWindow);

	}

	@Step("Click on Activitoes AAFS BTN")
	public void clickActivityAAFSAddBtn()
	{
		this.activityAAFSAddBtn.click();
	}

	@Step("Save Category Btn")
	public void saveCategoryBtn()
	{
		this.saveCategoryBtn.click();
	}

	@Step("Validate Added Success Message")
	public void validateAddedSuccessMessage()
	{

		softAssert.assertTrue(successMsgAlart.isDisplayed(), "Success Message is not showing");
		String successMsg = successMsgAlart.getText();
		softAssert.assertEquals(successMsg, "Category: " + categoryNameToAdd + " added successfully");
	}

	@Step("Input Search Text Box")
	public void inputSearchTxtBx()
	{
		this.searchTxtBx.sendKeys(categoryNameToAdd);
	}

	@Step("Validate Added Category")
	public void validateAddedCategory()
	{
		String addedCategory = this.nameCategoryTable.getText();
		softAssert.assertTrue(addedCategory.contains(categoryNameToAdd), "Categoryies are not Added into Category Table");

	}

	@Step("Click Modify On CATEGORY")
	public void clickModifyIconCategory()
	{
		driver.findElement(modifyIconCategory).click();
	}

	@Step("Click on Delete Icon Category")
	public void clcikDeleteIconCategory()
	{
		driver.findElement(deleteIconCategory).click();
	}

	@Step("Click Confirm tO Delete Yes BTN")
	public void clcikConfirmToDeleteYesBtn()
	{
		commons.waitUntilTime(confirmToDeleteYesBtn);
		this.confirmToDeleteYesBtn.click();

	}

	@Step("Validate Deleted Message Category")
	public void validateDeletedMessageCategory()
	{
		 //commons.waitForElementNotVisible(Duration.ofMinutes(45), driver,loadingIcon);
		//commons.waitForElement(Duration.ofMinutes(45), driver, loadingIcon);
		softAssert.assertTrue(successMsgAlart.isDisplayed(), "Detele Message is not showing or category not Deleted");
		String successMsg = successMsgAlart.getText();
		softAssert.assertEquals(successMsg, "Category: " + categoryNameModify + " deleted successfully");
	}

	@Step("Modify on Category")
	public void modifyTheCategory()
	{
		this.inputCategoryNameTxtBx.clear();
		this.inputCategoryNameTxtBx.sendKeys(categoryNameModify);
		commons.unselectjavaScriptCheckBox(activitiesAwayFromSystemTab);
	}

	@Step("Validate Modified Message")
	public void validateModifiedMessage()
	{
		softAssert.assertTrue(successMsgAlart.isDisplayed(), "Modified Message is not showing or Category not Modified");
		String successMsg = successMsgAlart.getText();
		softAssert.assertEquals(successMsg, "Category: " + categoryNameModify + " Modified successfully");

	}

	@Step("Search After Modified Text Box")
	public void serachAftermodifiedTxtBx()
	{

		this.searchTxtBx.sendKeys(categoryNameModify);
	}

	@Step("Validate To Modified Category")
	public void validateModifiedCategory()
	{
		String modifiedCategory = this.nameCategoryTable.getText();
		softAssert.assertTrue(modifiedCategory.contains(categoryNameModify), "Categoryies are not Modified in Category Table");

	}

}