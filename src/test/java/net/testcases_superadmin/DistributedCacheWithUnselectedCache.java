package net.testcases_superadmin;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.pages_superadmin.DistributedCachePage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;

public class DistributedCacheWithUnselectedCache extends BaseTest{
	
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Distribution cache selecting all and clearing all")
	public void distributedCacheWithUnselectedCache(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser);
		loginPage             loginPage           = new    loginPage(BaseTest.driver);
		SideNavigationMenuBar nav                 = new    SideNavigationMenuBar(BaseTest.driver);
		DistributedCachePage  cache               = new    DistributedCachePage(BaseTest.driver);
		
		
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		
		nav.clickSideNavigationArrowBtn();
		nav.clickSupport();
		nav.clickDistributedCache();
		driver.switchTo().frame("contentFrame");
		//cache.clickADSSettingcache();
		cache.clickReload();
		Thread.sleep(1000);
		cache.clickReloadUnselectedMsg();
	}
}
