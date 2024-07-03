package net.testcases_worktimemodule.User_adminmenu;

import java.io.IOException;
import java.util.Set;

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
public class UsersLicenseReport extends BaseTest {
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:Users Licence report excel validation")
	public void usersLicenseReport(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage        =   new   loginPage(BaseTest.driver);
		SideNavigationMenuPage  nav 	         =   new   SideNavigationMenuPage(BaseTest.driver);
		UsersPage               users            =   new   UsersPage(BaseTest.driver);
		ReadXLSdata             excel            =   new   ReadXLSdata(BaseTest.driver);
		Set<String>             getLicence       =   null;
		Set<String>             getexcelLicence  =   null; 
		
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		nav.clickSideNavigationBtn();
		users.scrollSideNavigationBar();
		
		users.clickUsersBtn();
		
		Thread.sleep(1000);
		users.clickUsers();
		driver.switchTo().frame("contentFrame");
		
		users.clickMOREACTIONBtn();
		
		users.clickLicencereport();
		
		getLicence = users.getLicenceList();
		
		users.clicklicenceExcelImg();
		
		getexcelLicence = excel.getUserLicenceList();
		
		boolean licenceEql = getLicence.equals(getexcelLicence);
		Assert.assertTrue(licenceEql);
	}

}
