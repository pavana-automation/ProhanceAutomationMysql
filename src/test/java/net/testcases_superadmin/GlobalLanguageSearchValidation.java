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
import net.pages_superadmin.GlobalLanguagePage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
@Listeners({ TestAllureListener.class })
public class GlobalLanguageSearchValidation extends BaseTest{
	
	@Parameters("browser")
	@Test
	@Description("Test Description:Global Language search validation")
	public void globalLanguageSearchValidation(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage             loginPage           = new    loginPage(BaseTest.driver);
		SideNavigationMenuBar nav                 = new    SideNavigationMenuBar(BaseTest.driver);
		GlobalLanguagePage    language               = new    GlobalLanguagePage(BaseTest.driver);
		
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		nav.clickSideNavigationArrowBtn();
		
		nav.clickGlobalLanguage();
		driver.switchTo().frame("contentFrame");
		language.clickSearch("French");
		language.getSearchList();
		
	}

}
