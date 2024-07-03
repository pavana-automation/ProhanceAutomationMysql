package net.testcases_superadmin;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
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
import net.testcases_worktimemodule.utilities.ReadXLSdata;

@Listeners({ TestAllureListener.class })
public class GlobalTimeZoneSorting extends BaseTest{
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:Time zone sorting")
	public void serviceManagerSorting(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage             loginPage           = new    loginPage(BaseTest.driver);
		SideNavigationMenuBar nav                 = new    SideNavigationMenuBar(BaseTest.driver);
		GlobalTimeZonePage    timeZone             = new    GlobalTimeZonePage(BaseTest.driver);
		ReadXLSdata           excel               = new    ReadXLSdata(BaseTest.driver);
		List<String>          afterSorting        = null;
		List<String>          beforeSorting       = null;
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		nav.clickSideNavigationArrowBtn();

		nav.clickGlobalTimeZone();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		timeZone.selectRecordToDisplay("1,000");
		//name sorting
		beforeSorting = timeZone.afterNameSorting();
		Thread.sleep(1000);
		timeZone.clickNameSorting();
		afterSorting = timeZone.nameSorting();
		
		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);
			
			boolean check =afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
		//Aliase name sorting
		beforeSorting = timeZone.afterAliaseNameSorting();
		Thread.sleep(1000);
		timeZone.clickAliaseNameSorting();
		afterSorting = timeZone.aliaseNameSorting();
		
		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);
			
			boolean check =afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
		
		//reference id sorting
		beforeSorting = timeZone.afterReferenceIdSorting();
		Thread.sleep(1000);
		timeZone.clickReferenceIdSorting();
		afterSorting = timeZone.referenceIdSorting();
		
		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);
			
			boolean check =afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
		
		//OffSet sorting
		beforeSorting = timeZone.afterOffsetSorting();
		Thread.sleep(1000);
		timeZone.clickOffsetSorting();
		afterSorting = timeZone.offsetSorting();
		
		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);
			
			boolean check =afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
		
		//Status sorting
		/*
		 * beforeSorting = timeZone.afterStatusSorting(); Thread.sleep(1000);
		 * timeZone.clickStatusSorting(); afterSorting = timeZone.statusSorting();
		 * 
		 * for (int i = 0; i < beforeSorting.size(); i++) { String data =
		 * beforeSorting.get(i);
		 * 
		 * boolean check =afterSorting.contains(data); System.out.println(check);
		 * Assert.assertTrue(check); }
		 */
					
	}

}
