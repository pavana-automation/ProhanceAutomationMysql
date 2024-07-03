package net.testcases_worktimemodule.usergroup_addmodifydelete_with_bulkupload_and_validate_offlinereports_in_mysql;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.CategoryPage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.UserGroupMysqlPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class UserGroupBulkUploadAddMysql extends BaseTest
{
	public String			userGroupNameModify		= "Production Modified Teams";

	WebDriver				driver;


	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Add the UserGroup and validate whether it has been successfully added through BulkUpload.")
	@Description("Add the UserGroup and validate whether it has been successfully added through BulkUpload.")
	@Parameters("browser")
	public void addUserGroupInMysql(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);		
		loginPage				loginPage				= new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);
		
		UserGroupMysqlPage		UserGroupMysqlPage		= new UserGroupMysqlPage(BaseTest.driver);
		
		CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickUsersBtn();
		
		UserGroupMysqlPage.clickTeamsTab();
		CategoryPage.selectFrame();
		
		UserGroupMysqlPage.clickBulkUploadBtn();
		
		UserGroupMysqlPage.clickBlankTemplateChkBx();
		UserGroupMysqlPage.clickHereToDownloadBulkUploadExcel();
		Thread.sleep(7000);
		List<String> addBulckUploadData = UserGroupMysqlPage.addUserGroupNamesExcelBulckUpload();
		UserGroupMysqlPage.clickChooseFileInBulkUpload();
		
		UserGroupMysqlPage.validateSuccessMsgForUploadFile();
		UserGroupMysqlPage.clickBackBtnInBulkUpload();
		UserGroupMysqlPage.searchboxInUserGroupTableinput("Demo test Team");
		List<String> webUserGroupDataList = UserGroupMysqlPage.getWebUserGroupTableData();
		
		UserGroupMysqlPage.validateAddUserGroupWithWebData(webUserGroupDataList, addBulckUploadData);
		//CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}

}
