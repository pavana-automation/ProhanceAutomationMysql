package net.testcases_worktimemodule.validate_worktemplate_addmodifydelete_administrationmenu;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.GenderalVariables;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkTemplateDefineDayTypesPage;
import net.pages_worktimemodule.WorkTemplatePage;
import net.pages_worktimemodule.loginPage;

public class WorkTemplateDefineDayTypesModify extends BaseTest
{



	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Modify the WorkTemplate DefineDayType and validate if it has been successfully Modified.")
	@Description("Modify the WorkTemplate DefineDayType and validate if it has been successfully Modified.")
	@Parameters("browser")
	public void defineDayTypeModify(String browser) throws InterruptedException

	{

		launchapp(browser);
		loginPage						loginPage				= new loginPage(BaseTest.driver);
		
		WorkTemplatePage				workTemplateMainPage	= new WorkTemplatePage(BaseTest.driver);
		
		WorkTemplateDefineDayTypesPage	workTemplate			= new WorkTemplateDefineDayTypesPage(BaseTest.driver);
		
		SideNavigationMenuPage			sideNavigationBar		= new SideNavigationMenuPage(BaseTest.driver);
		
		CommonMethodsPage				CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();

		sideNavigationBar.clickWorkTemplateBtn();
		workTemplateMainPage.iframeSwitch();

		workTemplate.clickDefineDayTypesBtn();
		workTemplate.clickDayTypeModifyIcon();

		workTemplate.aliasNameTxtBx("Automation modified");
		workTemplate.clickDayTypeModifySaveBtn();

		workTemplate.successMessageValidation("Day Type: ' Automation modified ' modified successfully");

		workTemplate.verifyAddedAliasInTable("Automation modified");
		workTemplate.dayTypeCloseBtn();
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}

}
