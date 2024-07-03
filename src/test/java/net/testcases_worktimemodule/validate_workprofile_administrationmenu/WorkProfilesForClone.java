package net.testcases_worktimemodule.validate_workprofile_administrationmenu;

import org.apache.commons.lang3.RandomStringUtils;
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
public class WorkProfilesForClone extends BaseTest{

	
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
		
		workProfile.clickCloneBtn();
		
		String name = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		System.out.println(name);
		workProfile.FillNameTxtBox(name);
		
		workProfile.clickSaveBtn();
		
		workProfile.clickCloseAggregationPopUp();
	}

}
