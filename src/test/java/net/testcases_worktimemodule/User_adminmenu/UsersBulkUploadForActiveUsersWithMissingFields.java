package net.testcases_worktimemodule.User_adminmenu;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.UsersPage;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;
@Listeners({ TestAllureListener.class })
public class UsersBulkUploadForActiveUsersWithMissingFields extends BaseTest {

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:Users bulk upload for active users with missing filed validation")
	public void usersBulkUploadForActiveUsersWithMissingFields(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage  =   new   loginPage(BaseTest.driver);
		SideNavigationMenuPage  nav 	   =   new   SideNavigationMenuPage(BaseTest.driver);
		UsersPage               users      =   new   UsersPage(BaseTest.driver);
		ReadXLSdata             excel      =   new   ReadXLSdata(BaseTest.driver);
		
		
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		
		nav.clickSideNavigationBtn();
		users.scrollSideNavigationBar();
		
		users.clickUsersBtn();
		
		Thread.sleep(1000);
		users.clickUsers();
		driver.switchTo().frame("contentFrame");
		
		users.clickMOREACTIONBtn();
		
		users.clickBulkUploadBtn();
		
		users.selectTemplateDropDown("Active Users");
		
		users.selectUserConditione("OR");
	
		users.selectUserStatus("Blocked Users");
		
		users.clickHereBtn();
		
		excel.getActiveUsersWithMissingFields();
		
		users.clickChooseFileBtn(excel.getRecentFilePath());
		
		 Thread.sleep(3000);
		  users.clickRefreshBtn();
		
		boolean checkForFail = users.getMissedFieldMsg();
		//Assert.assertTrue(checkForFail);
	}

}
