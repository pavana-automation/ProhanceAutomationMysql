package net.testcases_worktimemodule.validate_workprofile_administrationmenu;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
public class WorkProfileValidateWithTeams  extends BaseTest{



	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: clone on work Profiles ")
	public void cloneOnWorkProfiles (String browser) throws InterruptedException
	{
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		WorkProfilesPage workProfile = new WorkProfilesPage(BaseTest.driver);
		Set<String> workProfileListFromTeams = null;
		Set<String> workProfileList = null;

		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);

		nav.clickSideNavigationBtn();
		workProfile.scrollSideNavigationBar();

		workProfile.clickUsersBtn();

		Thread.sleep(1000);
		workProfile.clickTeamsBtn();
		driver.switchTo().frame("contentFrame");
		//Thread.sleep(1000);
		//listeners.testStepDescription("Step 5: Click on Modify button");
		workProfile.clickOnTeamsModifyBtn();
		//listeners.testStepDescription("Step 6: Get Work Profiles list from teams");
		workProfileListFromTeams = workProfile.getWorkProfilesName();

		workProfile.clickBackBtn();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		workProfile.clickBottomArrom();
		Thread.sleep(1000);

		nav.clickActivityTab();

		nav.clickWorkProfilestab();
		driver.switchTo().frame("contentFrame");

		workProfileList = workProfile.getWorkProfileList();

		boolean result = workProfileListFromTeams.containsAll(workProfileList);
		Assert.assertTrue(result);
	}
}
