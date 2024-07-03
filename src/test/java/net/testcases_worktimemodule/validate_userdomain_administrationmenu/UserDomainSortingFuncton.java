package net.testcases_worktimemodule.validate_userdomain_administrationmenu;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.RandomStringGeneration;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.UserDomainPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class UserDomainSortingFuncton extends BaseTest{
	
	
	
	@Parameters("browser")
	@Test(retryAnalyzer =net.Commons.RetryAnalyzer.class)
	@Description("User Domain sorting function")
	public void sortingFunction(String browser) throws InterruptedException
	{
		//listeners.testStepDescription("Step 1: Login into the prohance application");
		//driver = initializeDriverMysql();
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
		RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
		
		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		//listeners.testStepDescription("Step 2: Click SideNavigation Page");
		sidenavPage.clickSideNavigationBtn();
		
		//listeners.testStepDescription("Step 3: Click on UserDomain");
		sidenavPage.clickUserDomainBtn();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(2000);
		
		//listeners.testStepDescription("Step 4: Store the WebElements of Name and apply sort function and save as Expected List");
		String expectedList = userdomain.getElementsInRowToList().toString();
		
		//listeners.testStepDescription("Step 5: Click on Sorting Button and save the list as actual List");
		userdomain.clickDomainAliasHeaderBtn();
		Thread.sleep(1000);
		String actualList = userdomain.getElementsInRowToList().toString();
		
		//listeners.testStepDescription("Step 6: Compare Expected with Actual List");
		
		Assert.assertEquals(expectedList, actualList);
		//listeners.testStepDescription("Step 7: Sorting is working as expected");
	}
		
}

