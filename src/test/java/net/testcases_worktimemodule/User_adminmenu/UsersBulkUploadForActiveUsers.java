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
public class UsersBulkUploadForActiveUsers extends BaseTest {
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:Users bulk upload for active users")
	public void userBulkUploadForActiveUsers(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
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
		Thread.sleep(3000);
		users.clickMOREACTIONBtn();
		Thread.sleep(3000);
		users.clickBulkUploadBtn();
		Thread.sleep(3000);
		users.selectTemplateDropDown("Active Users");
		users.selectUserConditione("OR");
		users.selectUserStatus("Blocked Users");
		users.clickHereBtn();
		excel.getActiveUsersAdd();
		 Thread.sleep(3000);
		users.clickChooseFileBtn(excel.getRecentFilePath());
		Thread.sleep(9000); 
		boolean check = users.getMsg();
		//Assert.assertTrue(check);
		
		users.selectTemplateDropDown("Active Users");
		users.selectUserConditione("OR");
		users.selectUserStatus("Blocked Users");
		users.clickHereBtn();
		excel.getActiveUsersModify();
		Thread.sleep(1000);
		users.clickChooseFileBtn(excel.getRecentFilePath());
		Thread.sleep(9000); 
		boolean checkMod = users.getMsg();
		
		
		  users.selectTemplateDropDown("Active Users");
		  users.selectUserConditione("OR"); 
		  users.selectUserStatus("Blocked Users");
		  users.clickHereBtn(); 
		  excel.getActiveUsersDelete(); 
		  Thread.sleep(3000);
		  users.clickChooseFileBtn(excel.getRecentFilePath()); 
		  Thread.sleep(9000); 
		  boolean checkDel =users.getMsg();
		 

		
	}

}
