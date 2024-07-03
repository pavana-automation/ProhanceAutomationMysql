package net.pages_superadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class SideNavigationMenuBar {

	WebDriver driver;
	@FindBy(id = "arrow-top")
	WebElement sideNavigationBtn;
	
	@FindBy(xpath= "//a[contains(text(),'General')]")
	WebElement generalBtn;
	
	@FindBy(xpath = "//li[contains(text(),'Global Time Zones')]")
	WebElement globalTimeZones;
	
	@FindBy(xpath = "//li[contains(text(),'Global Languages')]")
	WebElement globalLanguage;
	
	@FindBy(xpath = "//li[contains(text(),'Clients')]")
	WebElement clients;
	
	@FindBy(xpath = "//li[contains(text(),'Global Settings')]")
	WebElement globalSettings;
	
	@FindBy(xpath = "//li[contains(text(),'Custom Adapter')]")
	WebElement customAdapter;
	
	@FindBy(xpath = "//li[contains(text(),'Data Components ')]")
	WebElement dataComponents ;
	
	@FindBy(xpath = "//li[contains(text(),'Partition Manager')]")
	WebElement partitionManager ;
	
	@FindBy(xpath = "//li/a[contains(text(),\"Support\")]")
	WebElement support ;
	
	@FindBy(xpath = "//li[contains(text(),\"Distributed Cache\")]")
	WebElement distributedCache ;
	
	@FindBy(xpath = "//li[contains(text(),\"Service Manager\")]")
	WebElement serviceManager ;
	
	@FindBy(xpath = "//li[contains(text(),\"Integrations\")]")
	WebElement integrations ;
	
	@FindBy(xpath = "//li[contains(text(),\"Session Utilities\")]")
	WebElement sessionUtilities ;
	
	@FindBy(xpath="//div[@class='slimScrollBar']")
	public
	WebElement locator;
	
	public SideNavigationMenuBar(WebDriver driver) {
		  
		  this.driver=driver; PageFactory.initElements(driver,this);
		  
		  }
	
	@Step("Click on Side Navigation arrow btn")
	public void clickSideNavigationArrowBtn()
	{
		this.sideNavigationBtn.click();
	}
	
	@Step("Click on general tab btn")
	public void clickGeneralBtn()
	{
		this.generalBtn.click();
	}
	
	@Step("Click on Global TIme ZOne")
	public void clickGlobalTimeZone()
	{
		this.globalTimeZones.click();
	}
	
	@Step("Click on Global Language")
	public void clickGlobalLanguage()
	{
		this.globalLanguage.click();
	}
	
	@Step("Click on clients")
	public void clickClients()
	{
		this.clients.click();
	}
	
	@Step("Click on Global Settings")
	public void clickGlobalSettings()
	{
		this.globalSettings.click();
	}
	
	@Step("Click on Custom Adapter ")
	public void clickCustomAdapter()
	{
		this.customAdapter.click();
	}
	
	@Step("Click on Data Components")
	public void clickDataComponents()
	{
		this.dataComponents.click();
	}
	
	@Step("Click on Partition Manager")
	public void clickPartitionManager()
	{
		this.partitionManager.click();
	}
	
	@Step("Click on support")
	public void clickSupport()
	{
		this.support.click();
	}
	
	@Step("Click on Distribution cache")
	public void clickDistributedCache()
	{
		this.distributedCache.click();
	}
	
	@Step("Click on service manager")
	public void clickServiceManager()
	{
		this.serviceManager.click();
	}
	
	@Step("Click on integrations")
	public void clickIntegrations()
	{
		this.integrations.click();
	}
	
	@Step("Click on Session Utilies")
	public void clickSessionUtilities()
	{
		this.sessionUtilities.click();
	}
}