package net.testcases_worktimemodule.AOS;

import java.util.ArrayList;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.RandomStringGeneration;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.AOSPage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.UserDomainPage;
import net.pages_worktimemodule.loginPage;


@Listeners({ TestAllureListener.class })
public class AOSModifyFunction extends BaseTest{
	
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: In This test case we are downloading the excel and validating few data ")
	public void a0sModifyFunction(String browser) throws InterruptedException
	{
		
		//driver = initializeDriverMysql();
		launchapp(browser);
		
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
		AOSPage aos = new AOSPage(BaseTest.driver);
		RandomStringGeneration randomStringGenerator = new RandomStringGeneration();

		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);

		sidenavPage.clickSideNavigationBtn();
		
		sidenavPage.clickActivitiesBtn();
		
		sidenavPage.clickAOSBtn();
		
		driver.switchTo().frame("contentFrame");

		Thread.sleep(2000);
		
		aos.clickModifyBtn();
	
		String result1 = randomStringGenerator.randomStringGenerator();
		aos.sendApplicationNameTxt(result1);
		aos.clickAddNewSaveBtn();
		
		Thread.sleep(2000);
		
		ArrayList<String> ActualList = userdomain.getElementsInRowToList();
		Thread.sleep(2000);
		Assert.assertTrue(ActualList.contains(result1));
		
	}
}