package net.testcases_worktimemodule.validate_worktemplate_addmodifydelete_administrationmenu;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.GenderalVariables;
import net.pages_worktimemodule.SettingsPage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkTemplatePage;
import net.pages_worktimemodule.loginPage;



public class WorkTemplateValidateRecordsToDisplay extends BaseTest
{
	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "WorkTemplate Validate Records To Display.")
	@Description("WorkTemplate Validate Records To Display.")
	@Parameters("browser")
	public void workTemplatePDFValidation(String browser) throws InterruptedException, IOException

	{

		
		
		launchapp(browser);	
		
		CommonMethodsPage				CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);
		
		loginPage						loginPage				= new loginPage(BaseTest.driver);
		
		WorkTemplatePage				workTemplateMainPage	= new WorkTemplatePage(BaseTest.driver);
			
		SettingsPage					settingsPage			= new SettingsPage(BaseTest.driver);
		
		SideNavigationMenuPage			sideNavigationBar		= new SideNavigationMenuPage(BaseTest.driver);
		
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();
		
		sideNavigationBar.clickSettingsBtn();
		workTemplateMainPage.iframeSwitch();
		
		settingsPage.selectRecordsDisplayInSummaryReportDropDownValues("1000");
		settingsPage.selectRecordsDisplayInConfigurationSummaryDropDownValues("1000");
		settingsPage.clickSaveBtn();
		workTemplateMainPage.unselectFrame();
		
		sideNavigationBar.clickSideNavigationBtn();
		sideNavigationBar.clickWorkTemplateBtn();
		workTemplateMainPage.iframeSwitch();
		
		workTemplateMainPage.validaterecordsToDisplayDropdown("1000");
		workTemplateMainPage.validaterecordsToDisplay(1000);
		workTemplateMainPage.unselectFrame();
		sideNavigationBar.clickSideNavigationBtn();
		
		sideNavigationBar.clickSettingsBtn();
		workTemplateMainPage.iframeSwitch();
		
		settingsPage.selectRecordsDisplayInSummaryReportDropDownValues("100");
		settingsPage.selectRecordsDisplayInConfigurationSummaryDropDownValues("100");
		settingsPage.clickSaveBtn();
		workTemplateMainPage.unselectFrame();
		sideNavigationBar.clickSideNavigationBtn();
		
		sideNavigationBar.clickWorkTemplateBtn();
		workTemplateMainPage.iframeSwitch();
		
		workTemplateMainPage.validaterecordsToDisplayDropdown("100");
		workTemplateMainPage.validaterecordsToDisplay(100);
		
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
		
	}
}
