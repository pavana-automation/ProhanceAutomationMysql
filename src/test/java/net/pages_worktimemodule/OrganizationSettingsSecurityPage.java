package net.pages_worktimemodule;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;

public class OrganizationSettingsSecurityPage
{
	WebDriver			driver;

	CommonMethodsPage	commonMethodsPage	= new CommonMethodsPage(BaseTest.driver);

	

	@FindBy(xpath = "//input[@id=\"passwordHaveAlphabets\"]")
	WebElement			passwordHaveAlphabetsChkBx;

	@FindBy(xpath = "//input[@id=\"passwordHaveNumerics\"]")
	WebElement			passwordHaveNumericsChkBx;

	@FindBy(xpath = "//input[@id=\"passwordHaveSpecialCharacters\"]")
	WebElement			passwordHaveSpecialCharactersChkBx;

	@FindBy(xpath = "//input[@id=\"passwordSameAsUserName\"]")
	WebElement			passwordSameAsUserNameChkBx;

	@FindBy(xpath = "//input[@id=\"passwordSameAsOldPassword\"]")
	WebElement			passwordSameAsOldPassword;

	@FindBy(xpath = "//div[@id=\"tr_buttons\"]//input[@value=\"SAVE\"]")
	WebElement			saveBtn;

	public OrganizationSettingsSecurityPage(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@Step("Reduce PasswordStrength")
	public void reducePasswordStrength()
	{
		commonMethodsPage.waitUntilTime(passwordHaveNumericsChkBx);
		commonMethodsPage.unselectjavaScriptCheckBox(passwordHaveNumericsChkBx);
		commonMethodsPage.selectjavaScriptCheckBox(passwordHaveSpecialCharactersChkBx);
		commonMethodsPage.unselectjavaScriptCheckBox(passwordSameAsUserNameChkBx);
		commonMethodsPage.unselectjavaScriptCheckBox(passwordSameAsOldPassword);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		this.saveBtn.click();

	}
	@Step("Admin Menu Tab Navigation")
	public void organizationSettingsTabNavigation(String tabName)
	{
		WebElement tabSpan = driver.findElement(By.xpath("//span[contains(text(),\'" + tabName + "\')]//ancestor::li"));
		System.out.println(tabSpan.toString());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", tabSpan);
	}
}
