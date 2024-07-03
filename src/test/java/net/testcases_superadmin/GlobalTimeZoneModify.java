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
import net.pages_superadmin.GlobalTimeZonePage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
@Listeners({ TestAllureListener.class })
public class GlobalTimeZoneModify extends BaseTest{

		@Parameters("browser")
		@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
		@Description("Test Description: Global Language PDF export validation")
		public void globaltimeZoneModify(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage          =   new 	loginPage(BaseTest.driver);
		SideNavigationMenuBar   nav                =   new 	SideNavigationMenuBar(BaseTest.driver);
		GlobalTimeZonePage      time               =   new GlobalTimeZonePage(BaseTest.driver);
		
			loginPage.clickLogin(GenderalVariables.superadminUserName,GenderalVariables.superadminPassword);
			
			nav.clickSideNavigationArrowBtn();
		
			nav.clickGlobalTimeZone();
			driver.switchTo().frame("contentFrame");
			
			time.clickModifyIcon();
			
			time.clickAliaseName("(GMT -12:01) Dateline Standard Time");
			Thread.sleep(1000);
			
			time.clickSaveBtn();
			
			time.clickAddMsg();
		}

}
