package net.testcases_worktimemodule.User_adminmenu;

import java.io.IOException;
import java.util.List;

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
public class UsersReportColumn extends BaseTest {

	@Parameters("browser")
	@Test
	@Description("Test Description:Users Report column validation")
	public void usersReportColumn(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage  			=   new   loginPage(BaseTest.driver);
		SideNavigationMenuPage  nav 	   			=   new   SideNavigationMenuPage(BaseTest.driver);
		UsersPage               users      			=   new   UsersPage(BaseTest.driver);
		
		List<String>            reportList1      	= 	null;
		List<String>            reportList2  	= 	null; 
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		nav.clickSideNavigationBtn();
		users.scrollSideNavigationBar();
		 
		
		users.clickUsersBtn();
		
		Thread.sleep(1000);
		users.clickUsers();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		users.clickReportColumn();
		Thread.sleep(1000);
		 
		users.clickClientDrag();
		Thread.sleep(1000);
		 
		users.clickClientDragAndDrop();
		
		reportList1 = users.getReportColumnLists();
		 
		users.clickReportColumnFetchBtn();
		 
		reportList2 = users.getReportColumnList();
		 
		for (int i = 0; i < reportList2.size(); i++) {
			String data = reportList2.get(i); 
			System.out.println("the value is :" +data);
			Assert.assertTrue(reportList1.contains(data));
			
		}

	}
}
