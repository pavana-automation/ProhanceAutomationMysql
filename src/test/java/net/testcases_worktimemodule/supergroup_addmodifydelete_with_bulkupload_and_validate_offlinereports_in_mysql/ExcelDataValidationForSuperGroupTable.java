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
public class ExcelDataValidationForSuperGroupTable extends BaseTest
{

	List<String> excelSuperGroupNameDataList;

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Data validation for the Usergroup table in Excel.")
	@Description("Data validation for the Usergroup table in Excel")
	public void excelValidationForSuperGroupTableInMysql(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);
		
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

		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();
		SuperGroupMysqlPage.clcikExcelIconInSuperGroupTable();
		Thread.sleep(2000);

		excelSuperGroupNameDataList = SuperGroupMysqlPage.getExcelDataForSuperGroupTable();
		System.out.println(excelSuperGroupNameDataList.toString());

		webSuperGroupNameDataList.forEach(webData -> {
			softAssert.assertTrue(excelSuperGroupNameDataList.contains(webData));
		});
		webSuperGroupNameDataList.clear();
		excelSuperGroupNameDataList.clear();
		CommonMethodsPage.deleteFileByPath(CommonMethodsPage.getRecentFilePath());

		//CommonMethodsPage.closeAllWindows(BaseTest.driver);

	}
}
