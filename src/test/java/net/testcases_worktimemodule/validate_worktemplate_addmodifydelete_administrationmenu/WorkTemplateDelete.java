package net.testcases_worktimemodule.validate_worktemplate_addmodifydelete_administrationmenu;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.GenderalVariables;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkTemplatePage;
import net.pages_worktimemodule.loginPage;


public class WorkTemplateDelete extends BaseTest
{



	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Delete the WorkTemplate DefineDayType and validate if it has been successfully Deleted.")
	@Description("Delete the WorkTemplate DefineDayType and validate if it has been successfully Deleted.")
	@Parameters("browser")
	public void workTemplateDelete(String browser) throws Exception
	{
		launchapp(browser);
		loginPage				loginPage			= new loginPage(BaseTest.driver);
		
		WorkTemplatePage		workTemplate		= new WorkTemplatePage(BaseTest.driver);
		
		
		SideNavigationMenuPage	sideNavigationBar	= new SideNavigationMenuPage(BaseTest.driver);
		
		CommonMethodsPage		CommonMethodsPage	= new CommonMethodsPage(BaseTest.driver);

		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();

		sideNavigationBar.clickWorkTemplateBtn();
		workTemplate.iframeSwitch();

		workTemplate.clickAddNewBtn();
		workTemplate.addNameAndDescription("DeleteTemp", "deleteDesc");
		workTemplate.saveBtn();
		workTemplate.clickWorkLoadCategoriesLabel();
		workTemplate.clickExitBtn();
		workTemplate.validateAddedTeamplateInTable("DeleteTemp");
		workTemplate.deleteWorkTemplate("DeleteTemp");
		 Thread.sleep(7000);
		workTemplate.validateTemplateDeleted(workTemplate.validateDeletedTeamplateNotInTable("DeleteTemp"));
		CommonMethodsPage.closeAllWindows(driver);
	}

}
