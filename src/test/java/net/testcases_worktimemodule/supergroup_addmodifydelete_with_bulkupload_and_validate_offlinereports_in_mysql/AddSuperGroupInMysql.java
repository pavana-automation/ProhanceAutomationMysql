package net.testcases_worktimemodule.supergroup_addmodifydelete_with_bulkupload_and_validate_offlinereports_in_mysql;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.CategoryPage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.SuperGroupMysqlPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })

public class AddSuperGroupInMysql extends BaseTest
{




	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Add the SuperGroup and validate if it has been successfully added.")
	@Description("Add the SuperGroup and validate if it has been successfully added.")
	public void addSuperGroupInMysql(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);
		String			superGroupNameAdd		= "Software Engineer";
		
		String			temaNameMappedValue;
		
		loginPage				loginPage				= new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);
		
		SuperGroupMysqlPage		SuperGroupMysqlPage		= new SuperGroupMysqlPage(BaseTest.driver);
		
		CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);
		
		CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);
		
		SoftAssert				softAssert				= new SoftAssert();

		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);

		SuperGroupMysqlPage.clickFuntionsTab();
		CategoryPage.selectFrame();

		SuperGroupMysqlPage.clickAddNewBtn();
		SuperGroupMysqlPage.inputSuperGroupName(superGroupNameAdd);
		SuperGroupMysqlPage.inputSuperGroupNameDescription(superGroupNameAdd);
		SuperGroupMysqlPage.clickSaveBtn();

		SuperGroupMysqlPage.validateSucessMessageForAddSuperGroupName(superGroupNameAdd);
		SuperGroupMysqlPage.clickTeamsMappingTab();
		SuperGroupMysqlPage.clickAddTeamsBtn();
		String mainWindowTitle = CommonMethodsPage.navigateNextWindow();
		SuperGroupMysqlPage.selectTeamsChkBxToMap();
		temaNameMappedValue = SuperGroupMysqlPage.getTeamsNameMapped();

		SuperGroupMysqlPage.clickAddBtnTeamsMappingPage();
		CategoryPage.navigateMainWindow(mainWindowTitle);
		CategoryPage.selectFrame();

		SuperGroupMysqlPage.validataSucessMsgToMappedTeams(superGroupNameAdd);
		SuperGroupMysqlPage.clickExitBtn();
		SuperGroupMysqlPage.searchSuperGroupTxtBx(superGroupNameAdd);
		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();

		softAssert.assertTrue(webSuperGroupNameDataList.contains(superGroupNameAdd));
		softAssert.assertTrue(webSuperGroupNameDataList.contains(temaNameMappedValue));
		webSuperGroupNameDataList.clear();
		System.gc();

		CommonMethodsPage.closeAllWindows(BaseTest.driver);

	}

}
