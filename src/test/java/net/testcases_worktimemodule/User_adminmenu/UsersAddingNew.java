package net.testcases_worktimemodule.User_adminmenu;

import org.apache.commons.lang3.RandomStringUtils;
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
public class UsersAddingNew extends BaseTest {
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Users CRUD validation")
	public void addNewUsers(String browser) throws InterruptedException {
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
		users.clickADDNEWbtn();
	
		users.selectRole("Team Member");
		
		String loginId = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		System.out.println("Aishwarya@JAMOCHAlOCAL");
		users.enterLoginIdTxtBox("Aishwarya12@JAMOCHAlOCAL");
		
		users.clickConsoleAuthChkBox();
		
		users.enterLoginIdConXTxtBox("Aishwarya12@JAMOCHAlOCAL");
		
		users.enterPasswordTxtBox(loginId);
		
		users.enterConfirmPassTxtBox(loginId);
		
		String name = RandomStringUtils.randomAlphabetic(5);
		users.enterFirstNameTxtBox("AAAAAishwarya_auto_test");
	
		//users.selectTimeZone("(GMT +05:30) India Standard Time");
		
		 users.clickSaveBtn();
		Thread.sleep(2000);
		
		 users.clickAddClose();
		
		users.clickBackBtn();
		users.moveToparentWindow();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		
		Thread.sleep(7000);
		users.clickModifyIcon();
		
		//users.selectUserType("Agentless");
		
		users.clickInactiveChkBoc();
		
		users.clickSaveBtn();
		
		users.clickAddClose();
		
		users.clickBackBtn();
		users.moveToparentWindow();
		driver.switchTo().frame("contentFrame");
	
		Thread.sleep(1000);
		users.clickDeleteIcon();
		Thread.sleep(1000);
		
		users.clickYESBtn();

	}

}
