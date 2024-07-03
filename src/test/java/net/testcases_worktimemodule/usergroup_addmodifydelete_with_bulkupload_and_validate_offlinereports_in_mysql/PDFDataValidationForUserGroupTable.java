	package net.testcases_worktimemodule.usergroup_addmodifydelete_with_bulkupload_and_validate_offlinereports_in_mysql;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
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
public class PDFDataValidationForUserGroupTable extends BaseTest
{
	public String			userGroupNameModify		= "Production Modified Teams";

	WebDriver				driver;

	@Test( retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Data validation for the Usergroup table in PDF.")
	@Description("Data validation for the Usergroup table in PDF")
	@Parameters("browser")
	public void pdfValidationUserGroupInMysql(String browser) throws InterruptedException, IOException
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
		
		List<String> webUserGroupDataList = UserGroupMysqlPage.getWebUserGroupTableDataWithoutSpace();
		
		UserGroupMysqlPage.clickPDFIcon();
		String pdfFileContent = UserGroupMysqlPage.getPDFUserGroupTableData();
		
		pdfFileContent = pdfFileContent.toString().replace(" ", "").replaceAll("\\r\\n|\\r|\\n", "").replace(".", "");
		UserGroupMysqlPage.validateUserGroupPDFDataWithWebData(webUserGroupDataList, pdfFileContent);
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}

}
