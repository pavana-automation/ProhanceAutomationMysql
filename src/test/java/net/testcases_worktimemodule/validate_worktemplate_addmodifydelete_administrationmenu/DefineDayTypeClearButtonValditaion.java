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
public class DefineDayTypeClearButtonValditaion extends BaseTest
{



	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "DefineDayType Clear Button Valditaion.")
	@Description("DefineDayType Clear Button Valditaion.")
	@Parameters("browser")
	public void validateClearButton(String browser) throws InterruptedException

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
		workTemplate.clickDefineDayTypesDayTypeDropDown("WD");
		workTemplate.aliasNameTxtBx("Automation");
		workTemplate.clickDayTypeClearBtn();

		workTemplate.validateClearBtn("WD", "");
		workTemplate.dayTypeCloseBtn();
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}

}
