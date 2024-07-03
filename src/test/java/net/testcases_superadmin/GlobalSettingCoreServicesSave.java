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
public class GlobalSettingCoreServicesSave extends BaseTest{
	@Parameters("browser")
	@Test
	@Description("Test Description: Global Settings Application URL clear validation")
	public void globalSettingCoreServicesSave(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage         =   new   loginPage(BaseTest.driver);
		SideNavigationMenuBar   nav               =   new   SideNavigationMenuBar(BaseTest.driver);
		GlobalSettingsPage      setting           =   new   GlobalSettingsPage(BaseTest.driver);
		ReadXLSdata             excel             =   new   ReadXLSdata(BaseTest.driver);
		GenderalVariables       gv         		  =   new 	GenderalVariables(); 
		List<String>            hostNameList      =   null;
		List<String>            hostNameExcelList =   null;
		
		
		loginPage.clickLogin(gv.superadminUserName, gv.superadminPassword);
		
		nav.clickSideNavigationArrowBtn();
		
		nav.clickGlobalSettings();
		driver.switchTo().frame("contentFrame");
		
		setting.clickCoreServices();
		
		setting.selectSessionTime("1 hour");
		
		setting.clickThreadsToProcessClientData("100");
		
		setting.clickThreadsToProcessClientHaertbeat("100");
		
		setting.clickhbEngineFrequency("2");
		
		setting.clickNoOfThreadsemailNotification("1");
		
		setting.clickNoOfThreadsGoalEvaluation("5");
		
		setting.clickNoOfShiftHourPoolSize("10");
		
		setting.clickprobeRawDataRecoveryPeriod("10");
		
		setting.clickprobeAuditDataRecoveryPeriod("30");
		
		setting.clickshiftHourDataPeriod("5");
		//Thread.sleep(1000);
		
		setting.selectRunDeletionservice("Daily");
		
		setting.selectDataDeletionHours("02");
		
		setting.selectdataDeletionMinutes("01");
		//Thread.sleep(4000);
		
		//setting.selectAggregationTime("15 minutes");
		//setting.selectShiftHours("15 minutes");
		
		//Thread.sleep(1000);
		//setting.clickEncryptionAllUser();
		
		//setting.clickCoreServiceSave();
		
		//setting.clickClientSuccessMsg();
		
	}
}