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
import net.testcases_worktimemodule.utilities.ReadXLSdata;
@Listeners({ TestAllureListener.class })
public class UsersLoggedinUsersByClientVersion extends BaseTest{
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:Users Show Logged in users by Clientversion")
	public void usersLoggedinUsersByClientVersion(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage  			=   new   loginPage(BaseTest.driver);
		SideNavigationMenuPage  nav 	   			=   new   SideNavigationMenuPage(BaseTest.driver);
		UsersPage               users      			=   new   UsersPage(BaseTest.driver);
		ReadXLSdata             excel      			=   new   ReadXLSdata(BaseTest.driver);
		List<String>            hostNameList      	= 	null;
		List<String>            hostNameExcelList  	= 	null; 
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		nav.clickSideNavigationBtn();
		users.scrollSideNavigationBar();
		 
		users.clickUsersBtn();
		
		Thread.sleep(1000);
		users.clickUsers();
		driver.switchTo().frame("contentFrame");
		 
		users.clickMOREACTIONBtn();
		Thread.sleep(1000);
		
		users.clickLoggedUsers();
		
		users.clickDashboardVies();
		
		users.clickClient("Not-Having");
		
		users.clickHeart("30 days");
		
		users.clickLoggedFetchBtn();
		Thread.sleep(1000);
		
		users.clickClientFilter();
		
		users.selectSlientByActivity("By Client Version");
		
		users.clickFetchBtn();
//		if(users.getNodataMsg() == true)
//		{
//			
//		System.out.println("Users not connectd from last 30 days");
//		}
//		else
//		{
//		
		
		users.clickClientVersion();
		
		hostNameList = users.getByHearbeat();
		
		users.clickByHeartbeatexcel();
		
		hostNameExcelList = excel.getByHearBeatEcxel();
		
		boolean check =hostNameList.equals(hostNameExcelList);
		//System.out.println(check);
		Assert.assertTrue(check);
		
		users.clickbyHeartbeatPdf();
		
		String actualPdfList=  excel.getHostNameListPDFData();
		
		 for(int i=0;i<hostNameList.size();i++)
		    {
		    	String data = hostNameList.get(i);
		    	System.out.println("the value is :" +data);
		    	boolean checkPdf = actualPdfList.contains(data);
		    	Assert.assertTrue(checkPdf);
		    }
		}
	//}

}
