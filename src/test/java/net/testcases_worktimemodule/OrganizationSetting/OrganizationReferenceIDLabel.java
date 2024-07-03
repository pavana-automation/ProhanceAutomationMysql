package net.testcases_worktimemodule.OrganizationSetting;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
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
public class OrganizationReferenceIDLabel extends BaseTest
{

	//@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Test
	@Description("Verify whether week day Start is set and saved")
	@Parameters("browser")
	public void organizationReferenceIDLabel(String browser) throws InterruptedException
	{
		launchapp(browser);
		loginPage							loginPage							= new loginPage(BaseTest.driver);
		OrganizationSettingAdminPage 		orgPage								= new OrganizationSettingAdminPage(BaseTest.driver);
		SoftAssert				softAssert				= new SoftAssert();


		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		driver.switchTo().frame("contentFrame");
		//orgPage.clickOnWorkLoadCategory();
		driver.findElement(By.id("referenceIdLabel")).clear();
		driver.findElement(By.id("referenceIdLabel")).sendKeys("Employee ID-test");
		orgPage.clickOnSaveBtn();
		
		Thread.sleep(5000);
		
		String expected = driver.findElement(By.id("referenceIdLabel")).getText();
		
		System.out.println("the expected is :" +expected);
		
		driver.findElement(By.id("referenceIdLabel")).clear();
		driver.findElement(By.id("referenceIdLabel")).sendKeys("Employee ID");
		orgPage.clickOnSaveBtn();
		
		//String actual = driver.findElement(By.id("superGroupsLabel")).getAttribute("innerText");
		
		//System.out.println("the actual is :" +actual);
		
		//Assert.assertNotEquals(actual , expected);
		
		//if(driver.findElement(By.xpath("//input[@id=\"superGroupsLabel\"]")))
		
		

	}

}
