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
public class GlobalLanguageSortingValidation extends BaseTest{
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:Time zone sorting")
	public void globalLanguageSortingValidation(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage             loginPage           = new    loginPage(BaseTest.driver);
		SideNavigationMenuBar nav                 = new    SideNavigationMenuBar(BaseTest.driver);
		GlobalLanguagePage    lanuage             = new    GlobalLanguagePage(BaseTest.driver);
		ReadXLSdata           excel               = new    ReadXLSdata(BaseTest.driver);
		List<String>          afterSorting        = null;
		List<String>          beforeSorting       = null;
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		nav.clickSideNavigationArrowBtn();

		nav.clickGlobalLanguage();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		lanuage.selectRecordToDisplay("1,000");
		//name sorting
		beforeSorting = lanuage.afterNameSorting();
		Thread.sleep(1000);
		lanuage.clickNameSorting();
		afterSorting = lanuage.nameSorting();
		
		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);
			
			boolean check =afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
		//aliase name sorting
		
		beforeSorting = lanuage.afterAliaseNameSorting();
		Thread.sleep(1000);
		lanuage.clickAliaseNameSorting();
		afterSorting = lanuage.aliseNameSorting();
		
		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);
			
			boolean check =afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
	}


}
