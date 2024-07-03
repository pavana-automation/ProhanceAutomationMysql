package net.testcases_worktimemodule.User_adminmenu;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
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
@Listeners({ TestAllureListener.class })
public class UsersAttributesForActiveUsers extends BaseTest {
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:User active attribute validation")
	public void usersAttributesForInactiveUsers(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage  =   new   loginPage(BaseTest.driver);
		SideNavigationMenuPage  nav 	   =   new   SideNavigationMenuPage(BaseTest.driver);
		UsersPage               users      =   new   UsersPage(BaseTest.driver);
	

		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		
		
		nav.clickSideNavigationBtn();
		users.scrollSideNavigationBar();
		
		users.clickUsersBtn();
	
		Thread.sleep(1000);
		users.clickUsers();
		driver.switchTo().frame("contentFrame");
		
		users.clickMOREACTIONBtn();
		Thread.sleep(1000);
		users.clickUsersAttribute();
		
		users.clickInactiveAttribute();
		
		users.getRole();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		users.clickWorkTime();
		
		users.clickAttendance();
		
		users.clickFilter();
		
		users.clickUserimg();
		
		users.GetUserArrtribute();
		
		boolean inactive = users.GetUserArrtribute().contains("Roles");
		Assert.assertTrue(inactive);
	}

}
