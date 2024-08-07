package net.testcases_worktimemodule.OrganizationSetting;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.OrganizationSettingAdminPage;
import net.pages_worktimemodule.loginPage;
@Listeners({ TestAllureListener.class })
public class OrganizationAllUserSelection extends BaseTest
{

	//@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Test
	@Description("Verify whether week day Start is set and saved")
	@Parameters("browser")
	public void organizationAllUserSelection(String browser) throws InterruptedException
	{
		launchapp(browser);
		loginPage							loginPage							= new loginPage(BaseTest.driver);
		OrganizationSettingAdminPage 		orgPage								= new OrganizationSettingAdminPage(BaseTest.driver);
		SoftAssert				softAssert				= new SoftAssert();


		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		driver.switchTo().frame("contentFrame");
		//orgPage.clickOnWorkLoadCategory();
		
		//Select objSelect = new Select(driver.findElement(By.id("userDropdownReference")));
		//objSelect.selectByValue("CONSOLE_LOGINID");
		
	WebElement locator =  driver.findElement(By.id("userDropdownReference"));
		
		JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;
		jsexecutour.executeScript("arguments[0].click();", locator, "CONSOLE_LOGINID");
		
		//driver.findElement(By.id("defaultworkshift")).clear();
		//driver.findElement(By.id("defaultworkshift")).sendKeys("Non-Work Shift-test");
		orgPage.clickOnSaveBtn();
		
		Thread.sleep(5000);
		
		//Select objSelect1 = new Select(driver.findElement(By.id("userDropdownReference")));
		//objSelect.selectByValue("REFERENCEID");
		
		WebElement locator1 =  driver.findElement(By.id("userDropdownReference"));
		
		JavascriptExecutor jsexecutour1 = (JavascriptExecutor) driver;
		jsexecutour1.executeScript("arguments[0].click();", locator1 , "REFERENCEID");
	
		orgPage.clickOnSaveBtn();
		
		//String actual = driver.findElement(By.id("superGroupsLabel")).getAttribute("innerText");
		
		//System.out.println("the actual is :" +actual);
		
		//Assert.assertNotEquals(actual , expected);
		
		//if(driver.findElement(By.xpath("//input[@id=\"superGroupsLabel\"]")))
		
		

	}

}
