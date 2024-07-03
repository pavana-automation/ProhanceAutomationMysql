package net.testcases_worktimemodule.usergroup_addmodifydelete_with_bulkupload_and_validate_offlinereports_in_mysql;

import java.io.IOException;
import java.util.List;

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
import net.pages_worktimemodule.UserGroupMysqlPage;
import net.pages_worktimemodule.loginPage;


@Listeners({ TestAllureListener.class })
public class AddUserGroupInMysql extends BaseTest
{
	public String			userGroupName			= "Production Team";

	@Test
	//(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Add the UserGroup and validate if it has been successfully added.")
	@Description("Add the UserGroup and validate if it has been successfully added..")
	@Parameters("browser")
	public void addUserGroupInMysql(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);		
		loginPage				loginPage				= new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);
		
		UserGroupMysqlPage		UserGroupMysqlPage		= new UserGroupMysqlPage(BaseTest.driver);
		
		CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);
		
		CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		SideNavigationMenuPage.clickUsersBtn();
		UserGroupMysqlPage.clickTeamsTab();
		CategoryPage.selectFrame();
		
		UserGroupMysqlPage.clickAddNewBtn();
		
		UserGroupMysqlPage.addDetailsForUserGroup();
		UserGroupMysqlPage.clickDetailsSaveBtn();
		
		UserGroupMysqlPage.validateSucessMsg();
		
		UserGroupMysqlPage.clickAssociateUsersTab();
		
		UserGroupMysqlPage.clickAddUsersBtn();
		String mainWindow = CommonMethodsPage.navigateNextWindow();
		UserGroupMysqlPage.selectUsers();
		UserGroupMysqlPage.clickAddBtnOfUser();
		CategoryPage.navigateMainWindow(mainWindow);
		CategoryPage.selectFrame();
		
		UserGroupMysqlPage.validateSucessMsgUserAssociation();
		
		UserGroupMysqlPage.clickAssociateWorkTypesTab();
		UserGroupMysqlPage.clickAddWorkTypeBtn();
		mainWindow = CommonMethodsPage.navigateNextWindow();
		UserGroupMysqlPage.selectWorkTypeChkBx();
		
		UserGroupMysqlPage.clickAddBtnOfUser();
		CategoryPage.navigateMainWindow(mainWindow);
		CategoryPage.selectFrame();
		
		UserGroupMysqlPage.validateSucessMsgWrokType();
		UserGroupMysqlPage.exitBtn();
		UserGroupMysqlPage.searchboxInUserGroupTableinput(userGroupName);
		List<String> webUserGroupDataList = UserGroupMysqlPage.getWebUserGroupTableData();
		
		UserGroupMysqlPage.validateUserGroupAdd(webUserGroupDataList);
		
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
		
	}
}
