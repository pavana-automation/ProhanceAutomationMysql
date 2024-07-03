package net.testcases_worktimemodule.OrganizationSetting;

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
public class OrganizationUnkonwnAOSandAFFS extends BaseTest
{

	//@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Test
	@Description("Verify whether Unknown AOS and AFFS ")
	@Parameters("browser")
	public void organizationUnkonwnAOSandAFFS(String browser) throws InterruptedException
	{
		launchapp(browser);
		loginPage							loginPage							= new loginPage(BaseTest.driver);
		OrganizationSettingAdminPage 		orgPage								= new OrganizationSettingAdminPage(BaseTest.driver);
		SoftAssert				softAssert				= new SoftAssert();


		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		
		driver.switchTo().frame("contentFrame");

		//SideNavigationMenuPage.clickSideNavigationBtn();
		orgPage.clickOnunConfiguredAOS();
		orgPage.clickOnunConfiguredAFFS();
		orgPage.clickOnSaveBtn();
		
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		
		orgPage.clickWorkTime();
		orgPage.clickActivityDashBoard();
		orgPage.verify1();
		
		
		
		String unkAOS = driver.findElement(By.xpath("//table[@id='topAppsDetailsList']/tbody/tr/td[2]")).getText();
		System.out.println("print 1 : " +unkAOS);
		String unAFFS = driver.findElement(By.xpath("//table[@id='topAppsDetailsList']/tbody/tr[2]/td[2]")).getText();
		System.out.println("print 2 : " +unAFFS);
		
		softAssert.assertTrue(unkAOS == "Unknown AOS");
		
		softAssert.assertTrue(unAFFS == "Unknown AAFS");
		
		

	}

}
