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
import net.pages_superadmin.ServiceManagerPage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;

@Listeners({ TestAllureListener.class })
public class ServiceManagerSorting extends BaseTest{
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Service manager sorting")
	public void serviceManagerSorting(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage             loginPage           = new    loginPage(BaseTest.driver);
		SideNavigationMenuBar nav                 = new    SideNavigationMenuBar(BaseTest.driver);
		ServiceManagerPage    service             = new    ServiceManagerPage(BaseTest.driver);
		ReadXLSdata           excel               = new    ReadXLSdata(BaseTest.driver);
		List<String>          afterSorting        = null;
		List<String>          beforeSorting       = null;
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		nav.clickSideNavigationArrowBtn();
		nav.clickSupport();
		nav.clickServiceManager();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		service.selectRecordToDisplay("1,000");
		beforeSorting = service.serviceNamebeforeSorting();
		Thread.sleep(1000);
		service.clickServiceNameSorting();
		afterSorting = service.serviceNameSorting();
		
		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);
			
			boolean check =afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
	}

}
