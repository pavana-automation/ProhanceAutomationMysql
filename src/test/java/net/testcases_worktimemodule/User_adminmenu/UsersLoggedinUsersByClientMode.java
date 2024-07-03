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
public class UsersLoggedinUsersByClientMode extends BaseTest
{
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:Users Show Logged in users by Clientmode")
	public void usersLoggedinUsersByClientMode(String browser) throws InterruptedException, EncryptedDocumentException, IOException 
	{
		launchapp(browser); 
		loginPage               loginPage  			=   new   loginPage(BaseTest.driver);
		SideNavigationMenuPage  nav 	   			=   new   SideNavigationMenuPage(BaseTest.driver);
		UsersPage               users      			=   new   UsersPage(BaseTest.driver);
		ReadXLSdata             excel      			=   new   ReadXLSdata(BaseTest.driver);
		List<String>            getHostName      	= 	null;
		List<String>            getexcelHostName  	= 	null; 
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		nav.clickSideNavigationBtn();
		users.scrollSideNavigationBar();
		
		users.clickUsersBtn();
		 
		Thread.sleep(1000);
		users.clickUsers();
		driver.switchTo().frame("contentFrame");
		
		Thread.sleep(2000);
		users.clickMOREACTIONBtn();
		Thread.sleep(1000);
		
		users.clickLoggedUsers();
		
		users.clickDashboardVies();
		
		users.clickClient("Not-Having");
		
		users.clickHeart("30 days");
		
		users.clickLoggedFetchBtn();
		Thread.sleep(1000);
		
		users.clickClientFilter();
		
		users.selectSlientByActivity("By Client Mode");
		
		users.clickFetchBtn();
//		if(users.getNodataMsg() == true)
//		{
//		
//			System.out.println("Users not connectd from last 30 days");
//		}
//		else
//	{
//		
		users.clickClientMode();
		
		getHostName = users.getByHearbeat();
		
		users.clickByHeartbeatexcel();
		
		getexcelHostName = excel.getByHearBeatEcxel();
		
		boolean check =getHostName.equals(getexcelHostName);
		//System.out.println(check);
		Assert.assertTrue(check);
		
		users.clickbyHeartbeatPdf();
		
		String actualPdfList=  excel.getHostNameListPDFData();
		
		 for(int i=0;i<getHostName.size();i++)
		    {
		    	String data = getHostName.get(i);
		    	System.out.println("the value is :" +data);
		    	boolean checkPdf = actualPdfList.contains(data);
		    	Assert.assertTrue(checkPdf);
		    }
		}
	//}
	
}
