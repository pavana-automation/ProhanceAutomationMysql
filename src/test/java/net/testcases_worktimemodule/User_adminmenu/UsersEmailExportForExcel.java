package net.testcases_worktimemodule.User_adminmenu;

import java.io.IOException;

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
public class UsersEmailExportForExcel extends BaseTest{
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Users Email excel export validation")
	public void usersEmailExcelExport(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage  =   new   loginPage(BaseTest.driver);
		SideNavigationMenuPage  nav 	   =   new   SideNavigationMenuPage(BaseTest.driver);
		UsersPage               users      =   new   UsersPage(BaseTest.driver);
		ReadXLSdata             excel      =   new   ReadXLSdata(BaseTest.driver);
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		nav.clickSideNavigationBtn();
		users.scrollSideNavigationBar();
		 
		users.clickUsersBtn();
		 
		Thread.sleep(1000);
		users.clickUsers();
		driver.switchTo().frame("contentFrame");
		
		users.clickEmailImg();
		
		users.clickReportViewBy("Users not mapped to any Group");
		
		users.clickExcelView();
		
		Thread.sleep(1000);
		users.fillrecipients("aishwarya.k@prohance.net");
		
		users.clickSubmitBtn();
		Thread.sleep(30000);
		
		users.getMailSuccessMsg();
		
		driver.get("https://login.microsoftonline.com/common/oauth2/v2.0/authorize?client_id=4765445b-32c6-49b0-83e6-1d93765276ca&redirect_uri=https%3A%2F%2Fwww.microsoft365.com%2Flandingv2&response_type=code%20id_token&scope=openid%20profile%20https%3A%2F%2Fwww.office.com%2Fv2%2FOfficeHome.All&response_mode=form_post&nonce=638404830422100424.YTgyMDVjZGQtMDJjMC00ODM1LTgwNjgtMTY0NGE5NjYyODA3NGU5N2QzYmUtYzU3Yy00ODk3LThjYmQtOTU3MTQ1NTYyNjg4&ui_locales=en-US&mkt=en-US&client-request-id=4f9014c6-fea2-4520-89c4-352d8f736089&state=1gQxkFf0dU6yquWDe9igz1wvUr7ZhaSFrVD_TQCiPXJXAUAfiXKOoVhAfXrOtQSTabSqkY_8mW98AcykTdAWumIAQyauN4otRWj6ziGhKbvRYnXuYPlk9aEWnWEH5y-ER8bth1e50_I3T2_ua_PV4NhlWYPCZ0_fUs_LUWS4vQhqSueFwCovIrbalTP-MMGjCCMq_IhHR-71CUKWWCusKF3D7p6m9dzkrwLA3O2bJ3OTAsOrkTTM2xUEIxTMu29ip1QfEwri86ISACLhJTNXnQqQQsL1GWIABNfbZizg5HM&x-client-SKU=ID_NET6_0&x-client-ver=6.34.0.0");
		
		users.sendoutlookUserName("aishwarya.k@prohance.net");
		
		users.clickNextBtn();
		
		users.sendoutlookPassword("AishProh@03");
		Thread.sleep(1000);
		
		users.clickSignInBtn();
		Thread.sleep(1000);
		
		users.clickStaySignInBtn();
		Thread.sleep(1000);
		
		users.clickExexcel();
		
		users.clickToSwitchtab();
		/*
		 * Thread.sleep(1000);
		 * listeners.testStepDescription("Step 19: Click on Download button");
		 * users.clickMailDownload();
		 * listeners.testStepDescription("Step 20: Check the Users List"); reportList2 =
		 * excel.getUsersExcelList();
		 */
	}
	

}
