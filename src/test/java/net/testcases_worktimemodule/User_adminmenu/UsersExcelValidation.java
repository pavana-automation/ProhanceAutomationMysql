package net.testcases_worktimemodule.User_adminmenu;

import java.io.IOException;
import java.util.List;

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
public class UsersExcelValidation extends BaseTest {
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Users excel export validation")
	public void usersExcelValidation(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage           =   new   loginPage(BaseTest.driver);
		SideNavigationMenuPage  nav 	            =   new   SideNavigationMenuPage(BaseTest.driver);
		UsersPage               users               =   new   UsersPage(BaseTest.driver);
		ReadXLSdata             excel               =   new   ReadXLSdata(BaseTest.driver);
		List<String>            reportList1         =   null;
		List<String>            reportList2         =   null; 
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		
		nav.clickSideNavigationBtn();
		users.scrollSideNavigationBar();
		
		users.clickUsersBtn();
		
		Thread.sleep(1000);
		users.clickUsers();
		driver.switchTo().frame("contentFrame");
		
		Thread.sleep(3000);
		users.clickDisplayrecords("1,000");
		
		Thread.sleep(1000);
		reportList1 = users.getUsersListsForExcel();
		Thread.sleep(1000);
		users.clickUserExcel();
		
		reportList2 = excel.getUsersExcelList();
		
		for (int i = 0; i < reportList1.size(); i++) {
			String data = reportList1.get(i);
			
			boolean check =reportList2.contains(data);
			System.out.println(check);
		}
	}
	
	
}
