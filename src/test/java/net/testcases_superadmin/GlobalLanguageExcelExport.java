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
import net.pages_superadmin.GlobalLanguagePage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;
@Listeners({ TestAllureListener.class })
public class GlobalLanguageExcelExport extends BaseTest{

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Global Language Excel export validation")
	public void globalLanguageExcelExport(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage          =   new 	loginPage(BaseTest.driver);
		SideNavigationMenuBar   nav                =   new 	SideNavigationMenuBar(BaseTest.driver);
		GlobalLanguagePage      lang               =   new GlobalLanguagePage(BaseTest.driver);
		ReadXLSdata             excel              =   new 	ReadXLSdata(BaseTest.driver);
		GenderalVariables       gv         		   =   new 	GenderalVariables();
		List<String>            lanuageList         =   null;
		List<String>            lanuageExcelList    =   null;
		
		loginPage.clickLogin(gv.superadminUserName,gv.superadminPassword);
		
		nav.clickSideNavigationArrowBtn();
		
		nav.clickGlobalLanguage();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		
		lanuageList =lang.getLanguageLists();
		lang.cliclExcel();
		lanuageExcelList = excel.getLanguageExcelList();
		for (int i = 0; i < lanuageList.size(); i++) {
			String data = lanuageList.get(i);
			
			boolean check =lanuageExcelList.contains(data);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
	}
}