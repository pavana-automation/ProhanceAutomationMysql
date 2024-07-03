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
public class ModifySuperGroupInMysql extends BaseTest
{

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Modify the SuperGroup and validate if it has been successfully Modified.")
	@Description("Modify the SuperGroup and validate if it has been successfully Modified.")
	public void modifySuperGroupInMysql(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);
		
		String superGroupNameAdd = "Software Engineer";

		String superGroupNameModify = "Imformation Technologies";

		loginPage loginPage = new loginPage(BaseTest.driver);

		SideNavigationMenuPage SideNavigationMenuPage = new SideNavigationMenuPage(BaseTest.driver);

		SuperGroupMysqlPage SuperGroupMysqlPage = new SuperGroupMysqlPage(BaseTest.driver);

		CategoryPage CategoryPage = new CategoryPage(BaseTest.driver);

		CommonMethodsPage CommonMethodsPage = new CommonMethodsPage(BaseTest.driver);

		SoftAssert softAssert = new SoftAssert();

		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickUsersBtn();

		Thread.sleep(2000);
		SuperGroupMysqlPage.clickFuntionsTab();
		CategoryPage.selectFrame();
		SuperGroupMysqlPage.searchSuperGroupTxtBx(superGroupNameAdd);

		SuperGroupMysqlPage.clickModifyIconInSuperGroupTable();
		SuperGroupMysqlPage.inputSuperGroupNameModify(superGroupNameModify);
		SuperGroupMysqlPage.clickSaveBtn();

		SuperGroupMysqlPage.validataSucessMsgToModifiedSuperGroupName(superGroupNameModify);

		SuperGroupMysqlPage.clickTeamsMappingTab();
		SuperGroupMysqlPage.selectTeamsChkBxToUnmap();
		SuperGroupMysqlPage.clickRemoveBtn();
		Thread.sleep(5000);
		SuperGroupMysqlPage.clickExitBtn();
		SuperGroupMysqlPage.searchSuperGroupTxtBx(superGroupNameModify);

		List<String> webSupergroupList = SuperGroupMysqlPage.getWebSuperGroupData();
		softAssert.assertTrue(webSupergroupList.contains(superGroupNameModify));
		webSupergroupList.clear();
		System.gc();

		CommonMethodsPage.closeAllWindows(BaseTest.driver);

	}
}
