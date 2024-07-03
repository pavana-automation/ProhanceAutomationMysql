package net.testcases_worktimemodule.User_adminmenu;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
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
public class UsersPDFValidation extends BaseTest {
	
	@Parameters("browser")
	@Test
	@Description("Test Description:Users PDF export validation")
	public void usersExcelValidation(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage  			=   new   loginPage(BaseTest.driver);
		SideNavigationMenuPage  nav 	   			=   new   SideNavigationMenuPage(BaseTest.driver);
		UsersPage               users      			=   new   UsersPage(BaseTest.driver);
		ReadXLSdata             excel      			=   new   ReadXLSdata(BaseTest.driver);
		List<String>            reportList1      	= 	null;
		List<String>            getexcelHostName  	= 	null; 
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		nav.clickSideNavigationBtn();
		users.scrollSideNavigationBar();

		users.clickUsersBtn();
		
		Thread.sleep(1000);
		users.clickUsers();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(6000);
		users.clickDisplayrecords("1,000");
		 reportList1 = users.getUsersLists();
		 Thread.sleep(1000);
		 users.clickUserPdf();
		 Thread.sleep(1000);
		String actualPdfList=  excel.getListPDFData();
		 for(int i=0;i<reportList1.size();i++)
		    {
		    	String data = reportList1.get(i);
		    	System.out.println("the value is :" +data);
		    	boolean check = actualPdfList.contains(data);
		    	System.out.println(check);
		    	Assert.assertTrue(check);
		    }
		 
	}

}
