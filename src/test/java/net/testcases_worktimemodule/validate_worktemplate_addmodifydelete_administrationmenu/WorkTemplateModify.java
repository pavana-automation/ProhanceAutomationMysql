package net.testcases_worktimemodule.validate_worktemplate_addmodifydelete_administrationmenu;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkTemplatePage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class WorkTemplateModify extends BaseTest
{



	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Modify the WorkTemplate DefineDayType and validate if it has been successfully Modified.")
	@Description("Modify the WorkTemplate DefineDayType and validate if it has been successfully Modified.")
	@Parameters("browser")
	public void workTemplateModify(String browser) throws InterruptedException
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
		List<String> specificColumnDataList = workTemplate.getSpecificColumnDataInTable(1);
		boolean workTemplateStatus = specificColumnDataList.stream().anyMatch(listData ->listData.equals("ChangeName"));
		if(workTemplateStatus) {
			workTemplate.modifyWorkTemplate("ChangeName");
			workTemplate.addNameAndDescriptionModify(CommonMethodsPage.generateRandomString(6), "ChangeDesc");
			workTemplate.saveBtn();
			workTemplate.clickBackBtnLabel();
			
		}
		workTemplate.modifyWorkTemplate("TemplateTestAutomation");
		workTemplate.addNameAndDescriptionModify("ChangeName", "ChangeDesc");
		workTemplate.saveBtn();
		workTemplate.navigateToWorkTimeTargets();
		workTemplate.uncheckWorkTimeTargetForMondayToThursday();
		Thread.sleep(2000);
		workTemplate.saveBtnWorkTemplate();

		workTemplate.successMessageValidate("Work Time Targets modified successfully");
		workTemplate.clickWorkLoadCategoriesLabel();
		workTemplate.clickExitBtn();

		workTemplate.validateAddedTeamplateInTable("ChangeName");
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}

}
