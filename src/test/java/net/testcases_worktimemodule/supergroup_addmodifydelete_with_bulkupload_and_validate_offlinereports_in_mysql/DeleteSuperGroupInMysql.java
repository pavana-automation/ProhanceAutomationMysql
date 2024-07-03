package net.testcases_worktimemodule.supergroup_addmodifydelete_with_bulkupload_and_validate_offlinereports_in_mysql;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
public class DeleteSuperGroupInMysql extends BaseTest
{

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Delete the SuperGroup and validate whether it has been successfully Deleted.")
	@Description("Delete the SuperGroup and validate whether it has been successfully Deleted.")
	public void deleteSuperGroupInMysql(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);
		
		String superGroupNameModify = "Imformation Technologies";

		loginPage loginPage = new loginPage(BaseTest.driver);

		SideNavigationMenuPage SideNavigationMenuPage = new SideNavigationMenuPage(BaseTest.driver);

		SuperGroupMysqlPage SuperGroupMysqlPage = new SuperGroupMysqlPage(BaseTest.driver);

		CategoryPage CategoryPage = new CategoryPage(BaseTest.driver);

		CommonMethodsPage CommonMethodsPage = new CommonMethodsPage(BaseTest.driver);

		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);

		SideNavigationMenuPage.clickSideNavigationBtn();

		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);

		SuperGroupMysqlPage.clickFuntionsTab();
		CategoryPage.selectFrame();
		SuperGroupMysqlPage.searchSuperGroupTxtBx(superGroupNameModify);

		SuperGroupMysqlPage.clickDeleteIconInSuperGroupTable();
		SuperGroupMysqlPage.clcikConfirmToDeleteYesBtn();

		SuperGroupMysqlPage.validateDeletedMessageSuperGroupName(superGroupNameModify);
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}
}
