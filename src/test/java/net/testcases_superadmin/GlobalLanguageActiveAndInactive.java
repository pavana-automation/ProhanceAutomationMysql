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
import net.pages_superadmin.GlobalLanguagePage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;
@Listeners({ TestAllureListener.class })
public class GlobalLanguageActiveAndInactive  extends BaseTest{
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Global Language active and inactive validation")
	public void globalTimeZoneActive(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage          =   new 	loginPage(BaseTest.driver);
		SideNavigationMenuBar   nav                =   new 	SideNavigationMenuBar(BaseTest.driver);
		GlobalLanguagePage      lang               =   new GlobalLanguagePage(BaseTest.driver);
		ReadXLSdata             excel              =   new 	ReadXLSdata(BaseTest.driver);
		GenderalVariables       gv         		   =   new 	GenderalVariables();

        
	
		loginPage.clickLogin(gv.superadminUserName,gv.superadminPassword);
	
		nav.clickSideNavigationArrowBtn();
		
		nav.clickGlobalLanguage();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
	
		if(lang.getActiveLanguageCount() > 0)
		{
		
			System.out.println("Check");
			lang.clickOnActiveLanguage();
		
			lang.clickActivedMsg();
		}
		else
		{
			
			System.out.println("No Active Time Zone");
		}
		/*
		 * listeners.
		 * testStepDescription("Step 7: Check any inactive time zone is there or not");
		 * if(time.getInactiveTimeZoneCount() > 0) { //listeners.
		 * testStepDescription("Step 8: If active time zone is present click on that");
		 * time.clickOnInactivetimeZone();
		 * //listeners.testStepDescription("Step 9: Verify the inactive message popup");
		 * time.clickInactivedMsg(); Thread.sleep(2000); time.clickActiveToInactive(); }
		 * else { //listeners.testStepDescription("Step 9: No Inactive Time Zone");
		 * System.out.println("No Inactive Time Zone"); }
		 */
	}
}

