package net.pages_worktimemodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Step;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;

public class ClassficationPage extends BaseTest
{

	public String		collectionMethodDropdownValue	= "User Specified";

	WebDriver			driver;

	CommonMethodsPage	commons							= new CommonMethodsPage(BaseTest.driver);

	SoftAssert			softAssert						= new SoftAssert();

	@FindBy(xpath = "//li[text()='Classification']")
	WebElement			classificationBtn;

	@FindBy(xpath = "//input[@id=\"class_2\"]")
	WebElement			classBChkBx;

	@FindBy(xpath = "//input[@id=\"class_3\"]")
	WebElement			classCChkBx;

	@FindBy(xpath = "//select[@id=\"collectionId_3\"]")
	WebElement			collectionMethodDropdown;
	
	@FindBy(xpath = "//select[@id=\"collectionId_4\"]")
	WebElement			collectionMethodDropdownForClassD;

	@FindBy(xpath = "//input[@name=\"className_2\"]")
	WebElement			nameOfClassB;

	@FindBy(xpath = "//input[@id=\"checkboxtagging_3\"]")
	WebElement			enableClassCChkBx;
	
	@FindBy(xpath = "//input[@id=\"checkboxtagging_4\"]")
	WebElement			enableParentClassDChkBx;

	@FindBy(xpath = "//select[@id=\"parentClassification_3\"]")
	WebElement			parentDropDownForClassC;
	
	@FindBy(xpath = "//select[@id=\"parentClassification_4\"]")
	WebElement			parentDropDownForClassD;

	@FindBy(xpath = "//td[@class=\"tab-buttons\"]//input[@value=\"SAVE\"]")
	WebElement			saveBtn;

	@FindBy(xpath = "//iframe[@id=\"contentFrame\"]")
	WebElement			iframe;
	
	@FindBy(xpath = "//input[@name=\"className_3\"]")
	WebElement			classCNameTxtBx;
	
	@FindBy(xpath = "//select[@id=\"classId\"]")
	WebElement			classificationDropdown;
	
	@FindBy(xpath = "//label[@id=\"parentClassId\"]")
	WebElement			parentForClass;
	
	@FindBy(xpath = "//input[@id=\"class_4\"]")
	WebElement			classDchxBx;
	
	@FindBy(xpath = "//span[@id=\"failuremsgdiv\"]")
	WebElement			failureMsgDiv;
	
	

	public ClassficationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step("Click ClassificationBtn")
	public void clickClassificationBtn() throws InterruptedException
	{
		Thread.sleep(2000);
		commons.waitUntilTime(classificationBtn);
		this.classificationBtn.click();
	}

	@Step("SelectFrame")
	public void selectFrame()
	{

		driver.switchTo().frame(iframe);
	}

	@Step("Set TheParent Classification")
	public void setTheParentClassification()
	{
		commons.selectjavaScriptCheckBox(classBChkBx);
		commons.selectjavaScriptCheckBox(classCChkBx);
		commons.selectjavaScriptCheckBox(enableClassCChkBx);
		Select objSelect = new Select(this.collectionMethodDropdown);
		objSelect.selectByVisibleText(collectionMethodDropdownValue);
		String parentClassName = this.nameOfClassB.getAttribute("value");
		Select objSelect1 = new Select(this.parentDropDownForClassC);
		objSelect1.selectByVisibleText(parentClassName);
		this.saveBtn.click();
	}

	@Step("unselectFrame")
	public void unselectFrame()
	{

		driver.switchTo().defaultContent();
	}

	@Step("ClassC Name TxtBx")
	public void classCNameTxtBx(String tagName)
	{
		this.classCNameTxtBx.sendKeys(tagName);
	}
	
	@Step("Validate Classfication Parent InActivityTag")
	public boolean validateClassficationParentInActivityTag(String parentName,String Activitytag) throws InterruptedException
	{
		Select objSelect = new Select(this.classificationDropdown);
		objSelect.selectByVisibleText(Activitytag);
		Thread.sleep(2000);
		if (this.parentForClass.isDisplayed())
		{
			String parentCategory = this.parentForClass.getText();
			if(parentCategory.equals(parentName)) {
				return true;
			}
			
		}
		return false;
		
	}
	@Step("Disabel ParentRelation In Classfication")
	public void disabelParentRelationInClassfication() {
		commons.unselectjavaScriptCheckBox(enableParentClassDChkBx);
		this.saveBtn.click();
	}
	
	@Step("Unselect ActivityTags")
	public void unselectActivityTags() {
		commons.unselectjavaScriptCheckBox(classCChkBx);
		commons.unselectjavaScriptCheckBox(classDchxBx);
		this.saveBtn.click();
	}
	
	@Step("SelectActivityTags")
	public void selectActivityTags() {
		commons.selectjavaScriptCheckBox(classCChkBx);
		commons.selectjavaScriptCheckBox(classDchxBx);
		this.saveBtn.click();
	}
	
	@Step("Set Another Catagory As Parent")
	public void setAnotherCatagoryAsParent() {
		
		commons.unselectjavaScriptCheckBox(enableClassCChkBx);
		commons.selectjavaScriptCheckBox(classDchxBx);
		commons.selectjavaScriptCheckBox(enableParentClassDChkBx);
		Select objSelect = new Select(this.collectionMethodDropdownForClassD);
		objSelect.selectByVisibleText(collectionMethodDropdownValue);
		String parentClassName = this.nameOfClassB.getAttribute("value");
		Select objSelect1 = new Select(this.parentDropDownForClassD);
		objSelect1.selectByVisibleText(parentClassName);
		this.saveBtn.click();
	}
	
	@Step("ValidateDataDependencyMsg")
	public String validateDataDependencyMsg() {
		this.failureMsgDiv.isDisplayed();
		return this.failureMsgDiv.getText();
		
	}
}
