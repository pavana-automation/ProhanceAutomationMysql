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
import net.pages_superadmin.SessionUtilitiesPage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;

@Listeners({ TestAllureListener.class })
public class SessionUtilitiesWithMissingRecordsToSelect extends BaseTest{
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Service manager sorting")
	public void sessionUtilitiesWithMissingRecordsToSelect(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage             loginPage           = new    loginPage(BaseTest.driver);
		SideNavigationMenuBar nav                 = new    SideNavigationMenuBar(BaseTest.driver);
		SessionUtilitiesPage  session             = new    SessionUtilitiesPage(BaseTest.driver);
		ReadXLSdata           excel               = new    ReadXLSdata(BaseTest.driver);
		List<String>          afterSorting        = null;
		List<String>          beforeSorting       = null;
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		nav.clickSideNavigationArrowBtn();
		nav.clickSupport();
		nav.clickSessionUtilities();
		driver.switchTo().frame("contentFrame");
		session.selectOrganization("PH Sales");
		session.selectUser("Aayesha T [J0174$]");
		session.selectTimeZone("Server Time");
		session.clickDatePicker();
		session.clickOnYear();
		session.clickOnFrontBtn();
		session.selectMonth();
		session.selectDay();
		session.ClickFetchBtn();
		session.selectAction("Reset Activity");
		Thread.sleep(1000);
		session.clickOnGoBtn();
		Thread.sleep(1000);
		session.clickSuccessMsg();
		
	}

}
