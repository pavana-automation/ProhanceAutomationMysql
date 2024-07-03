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
public class WorkProfileForAddingNew  extends BaseTest {
	

	

	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: Ading new work profiless ")
	public void AddingNewWorkProfiles (String browser) throws InterruptedException
	{
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		WorkProfilesPage workProfile = new WorkProfilesPage(BaseTest.driver);

		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
	
		nav.clickSideNavigationBtn();
		//Thread.sleep(4000);
		workProfile.scrollSideNavigationBar();
	
		nav.clickActivityTab();

		nav.clickWorkProfilestab();
		driver.switchTo().frame("contentFrame");
	
		workProfile.clickAddNewBtn();
	
		String name = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		System.out.println(name);
		workProfile.FillNameTxtBox(name);
		
		String des = RandomStringUtils.randomAlphabetic(10);
		System.out.println(des);
		workProfile.FillDescriptionTxtbox(des);
		//Thread.sleep(1000);

		workProfile.clickAOSBtn();
		
		workProfile.selectApplicationName();
	
		workProfile.clickOnAddApplicationName();
		//Thread.sleep(1000);
		//workProfile.selectRatingForAOS();
		
		workProfile.clickAWFSBtn();
	
		workProfile.selectAWFS();
	
		workProfile.clickAddBtnOnAWFS();
	
		workProfile.selectRatingForAWFS();
	
		workProfile.clickActivityTagsBtn();
		
		workProfile.clickAddOnActivityTagsBtn();
		//Thread.sleep(4000);
		workProfile.moveToAddPage();

		workProfile.clickToAddActivityTag();
		
		workProfile.clickAddActivityTagBtn();
		//Thread.sleep(1000);
		workProfile.moveToparentWindow();
		driver.switchTo().frame("contentFrame");
	
		workProfile.clickSaveBtn();
	
		workProfile.clickCloseAggregationPopUp();
		
	}

}
