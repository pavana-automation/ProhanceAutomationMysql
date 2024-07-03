package net.pages_superadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class DistributedCachePage {

	WebDriver driver;
	
	
	@FindBy(id = "ADS_SETTING_CACHE")
	WebElement ADSsettingCache;
	
	@FindBy(xpath = "//input[@value=\"RELOAD\"]")
	WebElement reload;
	
	@FindBy(xpath ="//button[contains(text(),'YES')]")
	WebElement yesBtn;
	
	@FindBy(xpath ="//span[@id =\"successmsgdiv\"]")
	WebElement reloadMsg;
	
	@FindBy(xpath ="//div[contains(text(),\"Select atleast one cache to reload\")]")
	WebElement reloadUnselectedMsg;
	
	@FindBy(xpath ="//input[@value =\"SELECT ALL\"]")
	WebElement selectAll;
	
	@FindBy(xpath ="//input[@value =\"CLEAR ALL\"]")
	WebElement clearAll;
	

	public DistributedCachePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@Step("Click on AOSetting cache")
	public void clickADSSettingcache()
	{
		this.ADSsettingCache.click();
	}
	
	@Step("Click on reload btn")
	public void clickReload()
	{
		this.reload.click();
	}
	
	@Step("Click on YES btn")
	public void clickYesbtn()
	{
		this.yesBtn.click();
	}
	
	@Step("Verify reolad message")
	public boolean clickReloadMsg() {
		String ms = this.reloadMsg.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "Reloaded1cache(s)successfully.";
		boolean check = msg.equals(compareMsg);
		return check;
	}
	
	@Step("Verify reload message")
	public boolean clickReloadUnselectedMsg() {
		String ms = this.reloadUnselectedMsg.getText();
		System.out.println(ms);
		String msg = ms.replaceAll("\\s+", "");
		String compareMsg = "Selectatleastonecachetoreload";
		boolean check = msg.equals(compareMsg);
		return check;
	}
	
	@Step("Click on Select all gtn ")
	public void clickSelectAll()
	{
		this.selectAll.click();
	}
	
	@Step("Click on clear all btn")
	public void clickClearAll()
	{
		this.clearAll.click();
	}
}
