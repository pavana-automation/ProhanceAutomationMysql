package net.pages_superadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;


public class IntegrationsPage {
	WebDriver driver ;
	
	@FindBy(id = "enableQRI_no")
	WebElement qRadarIntegration;
	
	@FindBy(id = "selectAll")
	WebElement detectEvents;
	
	@FindBy(id = "appendQRI_no")
	WebElement appendDescription;
	
	@FindBy(xpath = "//div[@id =\"tr_buttons\"]/div/input[2]")
	WebElement SAVE;
	
	@FindBy(xpath = "//div[@id =\"tr_buttons\"]/div/input[1]")
	WebElement clear;
	
	
	
	public IntegrationsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@Step("Click on QRadar integraion")
	public void clickQradarIntegration()
	{
		this.qRadarIntegration.click();
	}
	
	@Step("Click on detectEvents to Select All")
	public void clickDetectEvents()
	{
		this.detectEvents.click();
	}
	
	@Step("Click on appendDescription")
	public void clickAppendDescription()
	{
		this.appendDescription.click();
	}
	@Step("Click on save btn")
	public void clickSave()
	{
		this.SAVE.click();
	}
	
	@Step("Click on save btn")
	public void clickClear()
	{
		this.clear.click();
	}
}
