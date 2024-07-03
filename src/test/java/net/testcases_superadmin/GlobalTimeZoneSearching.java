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
import net.pages_superadmin.GlobalTimeZonePage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class GlobalTimeZoneSearching extends BaseTest{
	@Parameters("browser")
	@Test
	@Description("Test Description: Client excel export validation")
	public void globalTimeZoneSearching(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage             loginPage           = new    loginPage(BaseTest.driver);
		SideNavigationMenuBar nav                 = new    SideNavigationMenuBar(BaseTest.driver);
		GlobalTimeZonePage      timeZone          = new    GlobalTimeZonePage  (BaseTest.driver);
		
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		nav.clickSideNavigationArrowBtn();
		
		nav.clickGlobalTimeZone();
		driver.switchTo().frame("contentFrame");
		timeZone.clickSearch("Pacific/Niue");
		timeZone.getSearchList();
		
	}

}
