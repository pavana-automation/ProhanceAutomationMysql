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
public class UsersBulkUploadForInactiveUsers extends BaseTest {
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:Users bulk upload for inacyive users validation")
	public void bulkUploadforInactiveUsers(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
	
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
		Thread.sleep(1000);
		users.clickMOREACTIONBtn();
		Thread.sleep(1000);
		users.clickBulkUploadBtn();
		Thread.sleep(1000);
		users.selectTemplateDropDown("Inactive Users");
		users.selectUserConditione("OR");
		users.selectUserStatus("Blocked Users");
		users.clickHereBtn();
		excel.getInactiveUsersAdd();
		Thread.sleep(3000); 
		users.clickChooseFileForInactiveBtn(excel.getRecentFilePath());
		 Thread.sleep(9000); 
		boolean check = users.getMsg();
		//Assert.assertTrue(check);
		
		users.selectTemplateDropDown("Inactive Users");
		users.selectUserConditione("OR");
		users.selectUserStatus("Blocked Users");
		users.clickHereBtn();
		excel.getInactiveUsersModify();
		Thread.sleep(3000); 
		users.clickChooseFileForInactiveBtn(excel.getRecentFilePath());
		 Thread.sleep(9000); 
		boolean checkMod = users.getMsg();
		//Assert.assertTrue(check);
		
		
		  users.selectTemplateDropDown("Inactive Users");
		  users.selectUserConditione("OR"); users.selectUserStatus("Blocked Users");
		  users.clickHereBtn(); excel.getInactiveUsersDel(); Thread.sleep(3000);
		  users.clickChooseFileForInactiveBtn(excel.getRecentFilePath());
		  Thread.sleep(9000); boolean checkDel = users.getMsg();
		 
		//Assert.assertTrue(check);

	}
	

}
