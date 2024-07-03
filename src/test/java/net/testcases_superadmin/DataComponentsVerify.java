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
public class DataComponentsVerify extends BaseTest{
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: data components download validation ")
	public void dataComponentsVerify(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage              loginPage            =   new loginPage(BaseTest.driver);
		SideNavigationMenuBar  nav                  =   new SideNavigationMenuBar(BaseTest.driver);
		DataComponentsPage     data                 =   new DataComponentsPage(BaseTest.driver);
		ReadXLSdata            excel                =   new ReadXLSdata(BaseTest.driver);

		//listeners.testStepDescription("Step 1: Login to ProHance Application");
		loginPage.clickLogin("superadmin", "superadmin@1");
		//listeners.testStepDescription("Step 2: Click on Superadmin SideNavigation menu bar");
		nav.clickSideNavigationArrowBtn();
		//listeners.testStepDescription("Step 3: Click on Clients");
		nav.clickDataComponents();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(10000);
		data.clickPlusImg();
		Thread.sleep(3000);
		data.clickMinusImg();
}
}