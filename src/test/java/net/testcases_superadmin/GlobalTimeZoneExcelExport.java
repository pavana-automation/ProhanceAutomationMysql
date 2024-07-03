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
public class GlobalTimeZoneExcelExport extends BaseTest{

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Global Language PDF export validation")
	public void globalTimeZoneActive(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage          =   new 	loginPage(BaseTest.driver);
		SideNavigationMenuBar   nav                =   new 	SideNavigationMenuBar(BaseTest.driver);
		GlobalTimeZonePage      time               =   new GlobalTimeZonePage(BaseTest.driver);
		ReadXLSdata             excel              =   new 	ReadXLSdata(BaseTest.driver);
		GenderalVariables       gv         		   =   new 	GenderalVariables();
		List<String>            timeZoneList       =   null;
		List<String>            timeZoneExcelList    =   null;
		
		
		loginPage.clickLogin(gv.superadminUserName,gv.superadminPassword);
		
		nav.clickSideNavigationArrowBtn();
		
		nav.clickGlobalTimeZone();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		
		timeZoneList= time.getTimeZoneLists();
		
		time.cliclExcel();
		
		timeZoneExcelList = excel.getTimeZoneExcelList();
	
		for (int i = 0; i < timeZoneList.size(); i++) {
			String data = timeZoneList.get(i);
			
			boolean check =timeZoneExcelList.contains(data);
			System.out.println(check);
			Assert.assertTrue(check);
		}
	}
}
