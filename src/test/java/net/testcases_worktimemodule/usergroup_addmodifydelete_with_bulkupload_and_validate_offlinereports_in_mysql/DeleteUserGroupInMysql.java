package net.testcases_worktimemodule.usergroup_addmodifydelete_with_bulkupload_and_validate_offlinereports_in_mysql;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
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
import net.pages_worktimemodule.UserGroupMysqlPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class DeleteUserGroupInMysql extends BaseTest
{
	WebDriver				driver;



	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Delete the UserGroup and validate if it has been successfully Deleted.")
	@Description("Delete the UserGroup and validate if it has been successfully Deleted.")
	@Parameters("browser")
	public void deleteUserGroupInMysql(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);		
		loginPage				loginPage				= new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);
		
		UserGroupMysqlPage		UserGroupMysqlPage		= new UserGroupMysqlPage(BaseTest.driver);
		
		CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);
		
		CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);
		
		
		SoftAssert				softAssert				= new SoftAssert();
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();

		SideNavigationMenuPage.clickUsersBtn();
		UserGroupMysqlPage.clickTeamsTab();
		CategoryPage.selectFrame();
		
		UserGroupMysqlPage.clickDeleteIcon();
		UserGroupMysqlPage.clickConfirmationYesBtn();
		
		UserGroupMysqlPage.clickHereRemoveDataDependency();
		String mainWindow = CommonMethodsPage.navigateNextWindow();
		
		UserGroupMysqlPage.selectDependentChxBxToRemoveDataDepandency();
		UserGroupMysqlPage.clickdeleteDataDepandencyBtn();
		CategoryPage.navigateMainWindow(mainWindow);
		
		CategoryPage.selectFrame();	
		UserGroupMysqlPage.clickDeleteIcon();		
		UserGroupMysqlPage.clickConfirmationYesBtn();
		
		UserGroupMysqlPage.validateSucessMsgDeleted();		
		List<String> webUserGroupDataList = UserGroupMysqlPage.getWebUserGroupTableData();
		
			UserGroupMysqlPage.validateUserGroupDeleteValuePrasentTheTable(webUserGroupDataList);
		softAssert.assertAll();
		
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}

}
