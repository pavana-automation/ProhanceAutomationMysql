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
public class PatitionManagerWithManyEmails extends BaseTest{
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:partition manager with many email validation")
	public void patitionManagerWithManyEmails(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage             loginPage           = new    loginPage(BaseTest.driver);
		SideNavigationMenuBar nav                 = new    SideNavigationMenuBar(BaseTest.driver);
		PartitionManagerPage  manager             = new    PartitionManagerPage(BaseTest.driver);
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		nav.clickSideNavigationArrowBtn();
		
		nav.clickPartitionManager();
		driver.switchTo().frame("contentFrame");
		manager.email("venu.g@prohance.netvenu.g@prohance.net");
		manager.clickSaveBtn();
	}
}