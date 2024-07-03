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
import net.pages_superadmin.PartitionManagerPage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
@Listeners({ TestAllureListener.class })
public class PartitionManangerSave extends BaseTest{
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:partition manager save validation")
	public void partitionManangerSave(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage             loginPage           = new    loginPage(BaseTest.driver);
		SideNavigationMenuBar nav                 = new    SideNavigationMenuBar(BaseTest.driver);
		PartitionManagerPage  manager             = new    PartitionManagerPage(BaseTest.driver);
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		
		nav.clickSideNavigationArrowBtn();
		
		nav.clickPartitionManager();
		driver.switchTo().frame("contentFrame");
		manager.selectDate("20");
		manager.selectHour("01");
		manager.selectMinute("00");
		manager.selectFailurePartitionDay("02");
		manager.selectInterval("10");
		manager.clickYesNotification();
		manager.clickFailNotification();
		manager.email("venu.g@prohance.net");
		manager.selectRawDataMonth("12");
		manager.selectAggrDataMonth("24");
		manager.clickSaveBtn();
		manager.clickSuccessMsg();
	}
}