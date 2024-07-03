package net.testcases_superadmin;

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
import net.pages_superadmin.GlobalSettingsPage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;
@Listeners({ TestAllureListener.class })
public class GlobalSettingsEmailServerSave extends BaseTest{
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Global Settings Email server save validation")
	public void globalSettingsEmailServerSave(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage         =   new   loginPage(BaseTest.driver);
		SideNavigationMenuBar   nav               =   new   SideNavigationMenuBar(BaseTest.driver);
		GlobalSettingsPage      setting           =   new   GlobalSettingsPage(BaseTest.driver);
		ReadXLSdata             excel             =   new   ReadXLSdata(BaseTest.driver);
		GenderalVariables       gv         		  =   new 	GenderalVariables(); 
		List<String>            hostNameList      =   null;
		List<String>            hostNameExcelList =   null;
		
		
		loginPage.clickLogin(gv.superadminUserName,gv.superadminPassword);
		
		nav.clickSideNavigationArrowBtn();
		
		nav.clickGlobalSettings();
		driver.switchTo().frame("contentFrame");
		
		setting.clickEmailServerBtn();
		
		setting.selectProtocol("SMTP");
		
		setting.clickServerHost("smtp.office365.com");
		
		setting.clickServerPort("587");
		
		setting.selectEncryptionType("TLS 1.2");
		
		setting.clickEnableAuthenticationChkBox();
		
		setting.clickUserName("mahesh.d@prohance.net");
		
		setting.clickPassword("mahesh.d");
		
		setting.clickFromAddress("mahesh.d@prohance.net");
		
		setting.clickSaveBtn();
		
		setting. getMsg();
	}
}