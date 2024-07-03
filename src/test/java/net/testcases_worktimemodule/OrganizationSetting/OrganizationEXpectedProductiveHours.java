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
public class OrganizationEXpectedProductiveHours extends BaseTest
{

	//@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Test
	@Description("Verify whether week day Start is set and saved")
	@Parameters("browser")
	public void organizationEXpectedProductiveHours(String browser) throws InterruptedException
	{
		launchapp(browser);
		loginPage							loginPage							= new loginPage(BaseTest.driver);
		OrganizationSettingAdminPage 		orgPage								= new OrganizationSettingAdminPage(BaseTest.driver);
		SoftAssert				softAssert				= new SoftAssert();


		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		driver.switchTo().frame("contentFrame");
		//orgPage.clickOnWorkLoadCategory();
		
		//WebElement radio1 = driver.findElement(By.id("workshiftRadio"));
		//radio1.click();
		
		WebElement locator =  driver.findElement(By.id("workshiftRadio"));
		JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;
		jsexecutour.executeScript("arguments[0].click();", locator);
		
		//driver.findElement(By.id("defaultworkshift")).clear();
		//driver.findElement(By.id("defaultworkshift")).sendKeys("Non-Work Shift-test");
		orgPage.clickOnSaveBtn();
		
		Thread.sleep(2000);
		
		//WebElement radio2 = driver.findElement(By.id("worktemplateRadio"));
		//radio1.click();
		
		WebElement locator1 =  driver.findElement(By.id("worktemplateRadio"));
		JavascriptExecutor jsexecutour1 = (JavascriptExecutor) driver;
		jsexecutour1.executeScript("arguments[0].click();", locator1);

		orgPage.clickOnSaveBtn();
		
		
		
		

	}

}