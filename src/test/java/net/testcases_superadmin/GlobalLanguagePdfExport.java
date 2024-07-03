package net.testcases_superadmin;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
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
public class GlobalLanguagePdfExport extends BaseTest{

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Global Language PDF export validation")
	public void globalLanguagePdfExport(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage          =   new 	loginPage(BaseTest.driver);
		SideNavigationMenuBar   nav                =   new 	SideNavigationMenuBar(BaseTest.driver);
		GlobalLanguagePage      lang               =   new GlobalLanguagePage(BaseTest.driver);
		ReadXLSdata             excel              =   new 	ReadXLSdata(BaseTest.driver);
		GenderalVariables       gv         		   =   new 	GenderalVariables();
		List<String>            languageList       =   null;
		List<String>            customExcelList    =   null;
		
		loginPage.clickLogin(gv.superadminUserName,gv.superadminPassword);
		
		nav.clickSideNavigationArrowBtn();
		
		nav.clickGlobalLanguage();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		
		languageList= lang.getLanguageLists();
		
		lang.clickPdfImg();
		
		String actualPdfList = excel.getLanguagePDF();
		
		for(int i=0;i<languageList.size();i++)
	    {
	    	String data = languageList.get(i);
	    	System.out.println("the value is :" +data);
	    	boolean check = actualPdfList.contains(data);
	    	System.out.println(check);
	    	Assert.assertTrue(check);
	    }
	}
}

