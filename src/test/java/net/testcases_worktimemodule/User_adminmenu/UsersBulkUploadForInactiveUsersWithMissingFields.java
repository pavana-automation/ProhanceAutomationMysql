package net.testcases_worktimemodule.User_adminmenu;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.UsersPage;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;


public class UsersBulkUploadForInactiveUsersWithMissingFields extends BaseTest {
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Users CRUD validation")
	public void usersBulkUploadForInactiveUsersWithMissingFields(String browser)
			throws InterruptedException, EncryptedDocumentException, IOException {
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
		
		users.selectTemplateDropDown("Inactive Users");
		
		users.selectUserConditione("OR");
		
		users.selectUserStatus("Blocked Users");
		
		users.clickHereBtn();
		
		excel.getInactiveUsersWithMissingFields();
		
		users.clickChooseFileBtn(excel.getRecentFilePath());

		//boolean checkForFail = users.getFailMsg();
		
	}
	

}
