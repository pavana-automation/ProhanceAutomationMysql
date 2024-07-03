package net.pages_asset_optimizationmodule;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;

public class SoftwareDefinitionPage
{

	WebDriver			driver;

	@FindBy(xpath = "//ul/li[contains(text(),'Software Definition')]")
	WebElement			softwareDefinition;

	@FindBy(xpath = "//label[contains(text(),\"ADD NEW\")]")
	WebElement			addNew;

	@FindBy(id = "softwareNameId")
	WebElement			name;

	@FindBy(id = "descriptionId")
	WebElement			des;

	@FindBy(id = "associatedProcessId")
	WebElement			associate;

	@FindBy(id = "class1")
	WebElement			activity;

	@FindBy(id = "ignoresoftwareId")
	WebElement			ignore;

	@FindBy(xpath = "//div[@class =\"tab-buttons\"]/input[2]")
	WebElement			save;

	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement			addMsg;

	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement			modifyMsg;

	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/span")
	WebElement			deleteMsg;

	@FindBy(xpath = "//span[@id=\"dialogsuccessspan\"]/span/a")
	WebElement			closeXIconBtn;

	@FindBy(xpath = "//div[contains(text(),\"automation_1\")]/../../td[1]/span[1]")
	WebElement			modifyBtn;

	@FindBy(xpath = "//div[contains(text(),\"automation_1\")]/../../td[1]/span[2]")
	WebElement			deleteBtn;

	@FindBy(xpath = "//button[contains(text(),'YES')]")
	WebElement			yesBtn;

	@FindBy(xpath = "//label[contains(text(),\"SOFTWARE TAGS\")]")
	WebElement			softwareTags;

	@FindBy(id = "name")
	WebElement			sName;

	@FindBy(id = "description")
	WebElement			sDescription;

	@FindBy(xpath = "//td[@class =\"tab-buttons\"]/input[2]")
	WebElement			sSave;

	@FindBy(xpath = "//td[@class =\"tab-buttons\"]/input[1]")
	WebElement			sClear;

	@FindBy(xpath = "//table[@id=\"CommonDataTableId\"]/tbody/tr[1]/td/span[1]")
	WebElement			sClearmodify;

	@FindBy(xpath = "//body[@class=\"modal-open\"]/div[4]/div/div/div[2]/div[2]")
	WebElement			popupMsg;

	@FindBy(xpath = "//label[contains(text(),\"SOFTWARE TAG CLASSIFICATION\")]")
	WebElement			softwatetab;

	@FindBy(xpath = "//table[@class =\"configtable table-bordered-tb\"]/tbody/tr[2]/td[2]/div/label")
	WebElement			activityTag;

	@FindBy(xpath = "//div[@id=\"SWTagsId\"]/div/div/div/div/div/div[2]/button")
	WebElement			cancelButton;

	@FindBy(xpath = "//select[@id=\"tagId\"]/option")
	WebElement			activityTagOption;

	@FindBy(xpath = "//td[contains(text(),\"Activity Tag\")]")
	WebElement			activitytag;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr[1]/td[1]/span[1]")
	WebElement			modifyForactivity;

	@FindBy(xpath = "//div[@id=\"arrow-bot\"]/i")
	WebElement			bottomArrom;

	@FindBy(xpath = "//select[@id =\"class1\"]/option")
	List<WebElement>	activityList;

	@FindBy(xpath = "//img[@src='/phworkstation/images/excel.png']")
	WebElement			softeareDefinitionExcel;

	@FindBy(xpath = "//img[@src='/phworkstation/images/pdf.png']")
	WebElement			softeareDefinitionPdf;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[2]/div")
	List<WebElement>	softwareDefinitionList;

	@FindBy(xpath = "//img[@src='/phworkstation/images/excel.png']")
	WebElement			softeareTagsExcel;

	@FindBy(xpath = "//img[@src='/phworkstation/images/pdf.png']")
	WebElement			softeareTagsPdf;

	@FindBy(xpath = "//table[@id =\"CommonDataTableId\"]/tbody/tr/td[3]/div")
	List<WebElement>	softeareTagsList;
	
	CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

	public SoftwareDefinitionPage(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@Step("Click SoftwareDefinition in Side menu")
	public void clickSoftwareDefinition()
	{
		// this.softwareDefinition.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.softwareDefinition);
	}

	@Step("Click AddNewBtn")
	public void clickAddNewBtn()
	{
		CommonMethodsPage.waitUntilTime(addNew);
		this.addNew.click();
	}

	@Step("Click Name")
	public void clickName(String name)
	{
		this.name.sendKeys(name);
	}

	@Step("Click Description")
	public void clickDescription(String def)
	{
		this.des.sendKeys(def);
	}

	@Step("Click AssociateProcess")
	public void clickAssociateProcess(String associate)
	{
		this.associate.sendKeys(associate);
	}

	@Step("SelectTag")
	public void selectTag(String activity)
	{
		Select clickRole = new Select(this.activity);
		clickRole.selectByVisibleText(activity);
	}

	@Step("Click Ignore ChkBox")
	public void clickIgnoreChkBox()
	{
		this.ignore.click();
	}

	@Step("Click SAVEBtn")
	public void clickSAVEBtn()
	{
		this.save.click();
	}

	@Step("Click AddMsg")
	public boolean clickAddMsg()
	{
		String ms = this.addMsg.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		System.out.println(msg);
		String compareMsg = "SoftwareDefinition:automation_1addedsuccessfully";
		boolean check = msg.equals(compareMsg);
		return check;
	}

	@Step("Click ModifyMsg")
	public boolean clickModifyMsg()
	{
		String ms = this.modifyMsg.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "SoftwareDefinition:automation_1modifiedsuccessfully";
		boolean check = msg.equals(compareMsg);
		return check;
	}

	@Step("Click DeleteMsg")
	public boolean clickDeleteMsg()
	{
		String ms = this.deleteMsg.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "SoftwareDefinition:automation_1deletedsuccessfully";
		boolean check = msg.equals(compareMsg);
		return check;
	}

	@Step("Click AddMsg")
	public boolean clicksAddMsg()
	{
		String ms = this.addMsg.getText();
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "SoftwareTag:automation_1addedsuccessfully";
		boolean check = msg.equals(compareMsg);
		return check;
	}

	@Step("Click AddMsg")
	public boolean clicksModifyMsg()
	{
		String ms = this.modifyMsg.getText();
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "SoftwareTag:automation_1modifiedsuccessfully";
		boolean check = msg.equals(compareMsg);
		return check;
	}

	@Step("Click DeleteMsg")
	public boolean clicksDeleteMsg()
	{
		String ms = this.deleteMsg.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "SoftwareTag:automation_1deletedsuccessfully";
		boolean check = msg.equals(compareMsg);
		return check;
	}

	@Step("Click CloseXIconBtn")
	public void clickCloseXIconBtn()
	{
		this.closeXIconBtn.click();
	}

	@Step("Click ModifyBtn")
	public void clickModifyBtn()
	{
		this.modifyBtn.click();
	}

	@Step("Click DeleteBtn")
	public void clickDeleteBtn()
	{
		this.deleteBtn.click();
	}
	@Step("Click YESBtn")
	public void clickYESBtn()
	{
		this.yesBtn.click();
	}

	@Step("Click SoftwareTagsBtn")
	public void clikSoftwareTagsBtn()
	{
		CommonMethodsPage.waitUntilTime(softwareTags);
		
	    this.softwareTags.click();
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", this.softwareTags);
	}

	@Step("ClickSName")
	public String clickSName(String name)
	{
		this.sName.sendKeys(name);
		return name;
	}
	@Step("ClickSDescription")
	public void clickSDescription(String des)
	{
		this.sDescription.sendKeys(des);
	}

	@Step("ClickSDescriptionForModify")
	public void clickSDescriptionForModify()
	{
		this.sDescription.clear();
	}
	@Step("Clicks SAVEBtn")
	public void clicksSAVEBtn()
	{
		this.sSave.click();
	}
	@Step("sClearmodify")
	public void sClearmodify()
	{
		CommonMethodsPage.waitUntilTime(sClearmodify);
		this.sClearmodify.click();
	}
	@Step("clicksCLEARBtn")
	public void clicksCLEARBtn()
	{
		this.sClear.click();
	}

	@Step("Click Software RequiredMsg")
	public boolean clickSoftwareRequiredMsg() throws InterruptedException
	{
		Thread.sleep(2000);
		String ms = this.popupMsg.getText();
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "SoftwareTagisrequiredinformation";
		boolean check = msg.equals(compareMsg);
		return check;
	}
	@Step("Click Associate RequiredMsg")
	public boolean clickAssociateRequiredMsg() throws InterruptedException
	{
		Thread.sleep(2000);
		String ms = this.popupMsg.getText();
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "AssociatedProcessesisrequiredinformation";
		boolean check = msg.equals(compareMsg);
		return check;
	}
	@Step("Click SoftwareTabBtn")
	public void clickSoftwareTabBtn()
	{
		CommonMethodsPage.waitUntilTime(softwareTags);
		this.softwatetab.click();
	}

	@Step("Click ActivityTab")
	public boolean clickActivityTab()
	{
		boolean check1 = this.activityTag.isEnabled();
		return check1;

	}

	@Step("Click CancelButton")
	public void clickCancelButton()
	{
		this.cancelButton.click();
	}

	@Step("Click ActivityTagOption")
	public boolean clickActivityTagOption()
	{
		boolean check = this.activityTagOption.isDisplayed();
		return check;
	}

	@Step("Click ActivityTag")
	public boolean clickActivityTag()
	{
		boolean check = this.activitytag.isDisplayed();
		return check;
	}

	@Step("Click Modify For activity")
	public void clickModifyForactivity()
	{
		this.modifyForactivity.click();
	}

	@Step("Click BottomBtn")
	public void clickBottomBtn()
	{
		this.bottomArrom.click();
	}
	@Step("Click get WorkProfilesName")
	public List<String> getWorkProfilesName()
	{
		List<WebElement> col = null;
		List<String> teamsList = new ArrayList<String>();
		col = this.activityList;
		int len = col.size();
		for (int i = 1; i < len; i++)
		{
			teamsList.add(this.activityList.get(i).getText().replaceAll("\\s+", ""));

		}
		return teamsList;
	}
	@Step("Click SoftwareDefinitionPdf")
	public void clickSoftwareDefinitionPdf()
	{
		CommonMethodsPage.waitUntilTime(softeareDefinitionPdf);
		this.softeareDefinitionPdf.click();

	}

	@Step("Click SoftwareDefinitionExcel")
	public void clickSoftwareDefinitionExcel()
	{
		CommonMethodsPage.waitUntilTime(softeareDefinitionExcel);
		this.softeareDefinitionExcel.click();
	}

	@Step("Click SoftwareTagsPdf")
	public void clickSoftwareTagsPdf()
	{
		CommonMethodsPage.waitUntilTime(softeareTagsPdf);
		this.softeareTagsPdf.click();
	}

	@Step("Click SoftwaretagsExcel")
	public void clickSoftwaretagsExcel()
	{
		
		CommonMethodsPage.waitUntilTime(softeareTagsExcel);
		this.softeareTagsExcel.click();
	}

	@Step("Get SoftwareDefinition List")
	public List<String> getSoftwareDefinitionList() throws InterruptedException
	{

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList<String>();
		col = this.softwareDefinitionList;
		int len = col.size();
		Thread.sleep(1000);
		for (int i = 0; i < len; i++)
		{
			teamsList.add(this.softwareDefinitionList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println(
			// teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		return teamsList;
	}
	@Step("Get getSoftwareTags List")
	public List<String> getSoftwareTagsList() throws InterruptedException
	{

		List<WebElement> col = null;
		List<String> teamsList = new ArrayList<String>();
		col = this.softeareTagsList;
		int len = col.size();
		Thread.sleep(1000);
		for (int i = 0; i < len; i++)
		{
			teamsList.add(this.softeareTagsList.get(i).getText().replaceAll("\\s+", ""));
			// System.out.println(
			// teamsList.add(this.getUserArrtribute.get(i).getText()));
		}
		return teamsList;
	}

}
