package net.testcases_worktimemodule.User_adminmenu;

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
public class UsersEmailExportClose extends BaseTest {

	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:Users Email export close validation ")
	public void usersEmailExportClose(String browser) throws Exception {
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
		 Thread.sleep(1000);
		users.clickEmailImg();
		Thread.sleep(2000);
		users.clickMailClose();
	}

}
