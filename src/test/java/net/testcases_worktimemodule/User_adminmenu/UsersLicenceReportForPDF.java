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
public class UsersLicenceReportForPDF extends BaseTest{
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:Users Licence report PDF export validation")
	public void usersLicenceReportForPDF(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage  				=   new   loginPage(BaseTest.driver);
		SideNavigationMenuPage  nav 	  			 	=   new   SideNavigationMenuPage(BaseTest.driver);
		UsersPage               users     			 	=   new   UsersPage(BaseTest.driver);
		ReadXLSdata             excel      				=   new   ReadXLSdata(BaseTest.driver);
		List<String>            getLicence      	=   null;
		List<String>            clienNameExcelList  	=  null; 
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		nav.clickSideNavigationBtn();
		users.scrollSideNavigationBar();
		
		users.clickUsersBtn();
		
		Thread.sleep(1000);
		users.clickUsers();
		driver.switchTo().frame("contentFrame");
		 
		users.clickMOREACTIONBtn();
		users.clickLicencereport();
		getLicence = users.getLicenceListForPDF();
		users.clickLicencePdfImg();
		String pdfList = excel.getLicenceListPDFData();
		for(int i=0;i<getLicence.size();i++)
	    {
	    	String data = getLicence.get(i);
	    	System.out.println("the value is :" +getLicence.get(i));
	    	Assert.assertTrue(pdfList.contains(data));
	    }
	}

}
