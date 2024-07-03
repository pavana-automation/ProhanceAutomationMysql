package net.testcases_worktimemodule.validate_workprofile_administrationmenu;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkProfilesPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class WorkProfilesDeleteWithDependency extends BaseTest {

	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: clone on work Profiles ")
	public void cloneOnWorkProfiles (String browser) throws InterruptedException
	{
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		WorkProfilesPage workProfile = new WorkProfilesPage(BaseTest.driver);
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
	
		nav.clickSideNavigationBtn();
		workProfile.scrollSideNavigationBar();
	
		nav.clickActivityTab();

		nav.clickWorkProfilestab();
		driver.switchTo().frame("contentFrame");
		
		workProfile.clickTeamsSorting();
		
		workProfile.clickDependencyDeleteBtn();
		Thread.sleep(3000);
	
		workProfile.clickYesBtn();
		Thread.sleep(2000);
	
		workProfile.clickClickHereBtn();
		workProfile.moveToparentWindow();
		driver.switchTo().frame("contentFrame");
		
		workProfile.clickCloseAggregationPopUp();
	}
	
}
