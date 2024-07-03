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
public class OrganizationDurationFormatInActivityReport extends BaseTest
{

	//@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Test
	@Description("Verify whether week day Start is set and saved")
	@Parameters("browser")
	public void organizationDurationFormatInActivityReport(String browser) throws InterruptedException
	{
		launchapp(browser);
		loginPage							loginPage							= new loginPage(BaseTest.driver);
		OrganizationSettingAdminPage 		orgPage								= new OrganizationSettingAdminPage(BaseTest.driver);



		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		driver.switchTo().frame("contentFrame");
		//orgPage.clickOnWorkLoadCategory();
		
		//Select option1 = new Select(driver.findElement(By.id("webDurationFormat")));
		//option1.selectByValue("HH");
		
		WebElement locator =  driver.findElement(By.id("webDurationFormat"));
		JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;
		jsexecutour.executeScript("arguments[0].click();", locator, "HH");
		
	
		orgPage.clickOnSaveBtn();
		
		Thread.sleep(5000);
		
	
		WebElement locator1 =  driver.findElement(By.id("webDurationFormat"));
		JavascriptExecutor jsexecutour1 = (JavascriptExecutor) driver;
		jsexecutour1.executeScript("arguments[0].click();", locator1, "HH_MM");
		
		orgPage.clickOnSaveBtn();

	}

}
