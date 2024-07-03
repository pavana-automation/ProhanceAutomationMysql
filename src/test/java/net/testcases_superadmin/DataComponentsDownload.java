package net.testcases_superadmin;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.TestAllureListener;
import net.pages_superadmin.DataComponentsPage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;
@Listeners({ TestAllureListener.class })
public class DataComponentsDownload extends BaseTest{
	
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: data components download validation ")
	public void dataComponentsDownload(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage              loginPage            =   new loginPage(BaseTest.driver);
		SideNavigationMenuBar  nav                  =   new SideNavigationMenuBar(BaseTest.driver);
		DataComponentsPage     data                 =   new DataComponentsPage(BaseTest.driver);
	
		loginPage.clickLogin("superadmin", "superadmin@1");
		
		nav.clickSideNavigationArrowBtn();
		Thread.sleep(2000);
		nav.clickDataComponents();
		driver.switchTo().frame("contentFrame");
		data.clickFileImg();
	}
}