package net.testcases_worktimemodule.OrganizationSetting;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
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
public class OrganizationUserGroupLabel extends BaseTest
{

	//@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Test
	@Description("Verify whether week day Start is set and saved")
	@Parameters("browser")
	public void organizationUserGroupLabel(String browser) throws InterruptedException
	{
		launchapp(browser);
		loginPage							loginPage							= new loginPage(BaseTest.driver);
		OrganizationSettingAdminPage 		orgPage								= new OrganizationSettingAdminPage(BaseTest.driver);
		SoftAssert				softAssert				= new SoftAssert();

		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		String exp = driver.findElement(By.id("userGroupsLabel")).getText();
		System.out.println("the exp is :" +exp);
		//orgPage.clickOnWorkLoadCategory();
		driver.findElement(By.id("userGroupsLabel")).clear();
		driver.findElement(By.id("userGroupsLabel")).sendKeys("test1");
		orgPage.clickOnSaveBtn();
		Thread.sleep(5000);
			
		
		 String act =driver.findElement(By.id("userGroupsLabel")).getText();
		 System.out.println("the act is :" +act); 
		 Assert.assertNotEquals("Productive Hours", act);
		 driver.findElement(By.id("userGroupsLabel")).sendKeys("Teams");
		 orgPage.clickOnSaveBtn(); 
		 //Thread.sleep(5000);
		 
	}

}
