
package net.testcases_worktimemodule.supergroup_addmodifydelete_with_bulkupload_and_validate_offlinereports_in_mysql;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.FileUtils;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.ActivityTagsPage;
import net.pages_worktimemodule.CategoryPage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.SuperGroupMysqlPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class SuperGroupBulkUploadDeleteMysql extends BaseTest
{

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Delete the SuperGroup and validate whether it has been successfully Deleted through BulkUpload.")
	@Description("Delete the SuperGroup and validate whether it has been successfully Deleted through BulkUpload.")
	public void superGroupBulkUploadDelete(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);
		String superGroupNameModify = "Imformation Technologies";

		loginPage loginPage = new loginPage(BaseTest.driver);

		SideNavigationMenuPage SideNavigationMenuPage = new SideNavigationMenuPage(BaseTest.driver);

		SuperGroupMysqlPage SuperGroupMysqlPage = new SuperGroupMysqlPage(BaseTest.driver);

		CategoryPage CategoryPage = new CategoryPage(BaseTest.driver);

		CommonMethodsPage CommonMethodsPage = new CommonMethodsPage(BaseTest.driver);

		ActivityTagsPage ActivityTagsPage = new ActivityTagsPage(BaseTest.driver);

		SoftAssert softAssert = new SoftAssert();

		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();

		SideNavigationMenuPage.clickUsersBtn();
		Thread.sleep(2000);
		SuperGroupMysqlPage.clickFuntionsTab();
		CategoryPage.selectFrame();

		SuperGroupMysqlPage.clickBulkUploadBtn();

		SuperGroupMysqlPage.selectWithPrefilledDataChkBx();
		SuperGroupMysqlPage.clickHereDownloadTemplate();
		Thread.sleep(7000);
		String downloadDirectory = System.getProperty("user.home") + "/Downloads";
		File downloadedFile = FileUtils.waitForNewFileInDirectory(downloadDirectory, 30, 500);

        if (downloadedFile == null) {
            throw new IOException("The file was not downloaded within the expected time.");
        }
		SuperGroupMysqlPage.deleteSuperGroupExcelBulckUpload(superGroupNameModify);
		SuperGroupMysqlPage.clickChooseFileInBulkUpload();

		ActivityTagsPage.validateBulkUploadAddMessage();
		Thread.sleep(4000);
		SuperGroupMysqlPage.clickBackBtnInBulkUpload();
		// CategoryPage.unselectFrame();
		// SideNavigationMenuPage.clickSideNavigationBtn();
		//
		// SideNavigationMenuPage.clickUsersBtn();
		// Thread.sleep(2000);
		// SuperGroupMysqlPage.clickFuntionsTab();
		// CategoryPage.selectFrame();

		List<String> webSuperGroupNameDataList = SuperGroupMysqlPage.getWebSuperGroupData();

		softAssert.assertFalse(webSuperGroupNameDataList.contains(superGroupNameModify));
		softAssert.assertFalse(webSuperGroupNameDataList.contains(superGroupNameModify));
		webSuperGroupNameDataList.clear();
		CommonMethodsPage.deleteFileByPath(CommonMethodsPage.getRecentFilePath());
		softAssert.assertAll();

		//CommonMethodsPage.closeAllWindows(driver);

	}

}
