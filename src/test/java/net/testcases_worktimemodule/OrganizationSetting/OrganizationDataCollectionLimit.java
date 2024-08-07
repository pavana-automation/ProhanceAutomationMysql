package net.testcases_worktimemodule.OrganizationSetting;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
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
public class OrganizationDataCollectionLimit extends BaseTest
{

	//@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Test
	@Description("Verify whether week day Start is set and saved")
	@Parameters("browser")
	public void organizationDataCollectionLimit(String browser) throws InterruptedException
	{
		launchapp(browser);
		loginPage							loginPage							= new loginPage(BaseTest.driver);
		OrganizationSettingAdminPage 		orgPage								= new OrganizationSettingAdminPage(BaseTest.driver);

		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		driver.switchTo().frame("contentFrame");
		//orgPage.clickOnWorkLoadCategory();
		
		driver.findElement(By.id("enableUsersForLS")).clear();
		driver.findElement(By.id("enableUsersForLS")).sendKeys("30");
		
		
		
		//driver.findElement(By.id("defaultworkshift")).clear();
		//driver.findElement(By.id("defaultworkshift")).sendKeys("Non-Work Shift-test");
		orgPage.clickOnSaveBtn();
		
		String exp =driver.findElement(By.id("enableUsersForLS")).getAttribute("value");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("enableUsersForLS")).clear();
		driver.findElement(By.id("enableUsersForLS")).sendKeys("50");
		
		orgPage.clickOnSaveBtn();
		
		String act =driver.findElement(By.id("enableUsersForLS")).getAttribute("value");
		
		
		Assert.assertNotEquals(act, exp);

	}

}
