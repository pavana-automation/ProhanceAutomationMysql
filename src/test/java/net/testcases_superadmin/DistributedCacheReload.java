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
import net.pages_superadmin.DistributedCachePage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;


@Listeners({ TestAllureListener.class })
public class DistributedCacheReload extends BaseTest{

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Distribution cache Reload ")
	public void distributedCacheReload(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser);
		
		loginPage             loginPage           = new    loginPage(BaseTest.driver);
		SideNavigationMenuBar nav                 = new    SideNavigationMenuBar(BaseTest.driver);
		DistributedCachePage  cache               = new    DistributedCachePage(BaseTest.driver);


		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);

		nav.clickSideNavigationArrowBtn();
		nav.clickSupport();
		nav.clickDistributedCache();
		driver.switchTo().frame("contentFrame");
		cache.clickADSSettingcache();
		cache.clickReload();
		cache.clickYesbtn();
		cache.clickReloadMsg();
	}
}
