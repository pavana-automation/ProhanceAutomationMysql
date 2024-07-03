package net.testcases_worktimemodule.validate_worktemplate_addmodifydelete_administrationmenu;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkTemplateDefineDayTypesPage;
import net.pages_worktimemodule.WorkTemplatePage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class WorkTemplateDefineDayTypesAdd extends BaseTest {



	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Add the WorkTemplate and validate if it has been successfully added.")
	@Description("Add the WorkTemplate and validate if it has been successfully added.")
	@Parameters("browser")
	public void defineDayTypeAdd(String browser) throws InterruptedException

	{
		launchapp(browser);
		loginPage loginPage = new loginPage(BaseTest.driver);
		
		WorkTemplatePage workTemplateMainPage = new WorkTemplatePage(BaseTest.driver);
		
		WorkTemplateDefineDayTypesPage workTemplate = new WorkTemplateDefineDayTypesPage(BaseTest.driver);
		
		SideNavigationMenuPage sideNavigationBar = new SideNavigationMenuPage(BaseTest.driver);
		CommonMethodsPage CommonMethodsPage = new CommonMethodsPage(BaseTest.driver);

		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();

		sideNavigationBar.clickWorkTemplateBtn();
		workTemplateMainPage.iframeSwitch();

		workTemplate.clickDefineDayTypesBtn();

		workTemplate.clickDefineDayTypesDayTypeDropDown("WD");
		workTemplate.aliasNameTxtBx("Automation");
		workTemplate.clickAddDayTypes();

		workTemplate.successMessageValidation("Day Type: ' Automation ' added successfully");

		workTemplate.verifyAddedAliasInTable("Automation");
		workTemplate.dayTypeCloseBtn();
		CommonMethodsPage.closeAllWindows(driver);

	}

}
