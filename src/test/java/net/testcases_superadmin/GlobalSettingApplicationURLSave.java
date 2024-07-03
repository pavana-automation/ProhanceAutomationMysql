package net.testcases_superadmin;

import java.io.IOException;

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
public class GlobalSettingApplicationURLSave extends BaseTest{
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Global Settings Application URL Save validation")
	public void globalSettingClientSave(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage         =   new   loginPage(BaseTest.driver);
		SideNavigationMenuBar   nav               =   new   SideNavigationMenuBar(BaseTest.driver);
		GlobalSettingsPage      setting           =   new   GlobalSettingsPage(BaseTest.driver);
		ReadXLSdata             excel             =   new   ReadXLSdata(BaseTest.driver);
		GenderalVariables       gv         		  =   new 	GenderalVariables(); 
		
		
		loginPage.clickLogin( gv .superadminUserName, gv.superadminPassword);
		
		nav.clickSideNavigationArrowBtn();
		
		nav.clickGlobalSettings();
		driver.switchTo().frame("contentFrame");
		
		setting.clickApplicationUrl();
		
		setting.clickWebConsoleURL("http://10.10.10.126:6262/prohance/");
		
		setting.clickAuthUrl("http://10.10.10.126:6262/phxauth/");
		
		setting.clickAuthLocalUrl("http://10.10.10.126:6262/phxauth/");
	
		setting.clickWorkOutputLocalUrl("http://10.10.10.126:6262/phworkoutput/");
		
		setting.clickAssetOptimizationUrl("http://10.10.10.126:6262/phworkstation/");
		
		setting.clickAssetOptimizationLocalUrl("http://10.10.10.126:6262/phworkstation/");
		
		setting.clickWorkFlowUrl("http://10.10.10.126:6262/phworkflow/");
		
		setting.clickWorkFlowLocalUrl("http://10.10.10.126:6262/phworkflow/");
		
		setting.clickworkFlowClientUrl("http://10.10.10.126:6262/phworkflowclient/");
		
		setting.clickWorkflowAttachmentRepositoryPath("C:\\PHManager\\apache-tomcat-9.0.39\\PHWorkflowRepository");
		
		setting.clickAnalyticsUrl("http://10.10.10.126:6262/prohancex/");
		
		setting.clickAnalyticsLocalUrl("http://10.10.10.126:6262/prohancex/");
		
		setting.clickDataSourceName("DATASOURCE_0");
		
		setting.clickUsageAnalyticsUrl("http://10.10.10.126:6262/prohanceusage/");
		
		setting.clickUsageAnalyticsLocalUrl("http://10.10.10.126:6262/prohanceusage/");
		
		setting.clickDataProcessorUrl("http://10.10.10.126:6262/prohancedp/");
		
		setting.clickSaveBtn();
	}

}