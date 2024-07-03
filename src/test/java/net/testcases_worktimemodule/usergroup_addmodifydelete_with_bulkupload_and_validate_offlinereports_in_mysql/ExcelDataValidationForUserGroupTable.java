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
public class ExcelDataValidationForUserGroupTable extends BaseTest
{
	public String			userGroupNameModify		= "Production Modified Teams";

	WebDriver				driver;



	@Test( retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Data validation for the Usergroup table in Excel.")
	@Description("Data validation for the Usergroup table in Excel.")
	@Parameters("browser")
	public void excelValidateUserGroupInMysql(String browser) throws InterruptedException, IOException
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
		
		
		List<String> webUserGroupDataList = UserGroupMysqlPage.getWebUserGroupTableData();
		
		UserGroupMysqlPage.clickExcelIcon();
		List<String> excelUserGroupNameDataList = UserGroupMysqlPage.getExcelDataForUserGroupTable();
		
		UserGroupMysqlPage.validateExcelDataWithWebUserGroup(webUserGroupDataList, excelUserGroupNameDataList);
		//CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}

}
