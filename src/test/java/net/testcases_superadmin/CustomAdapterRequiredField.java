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
import net.pages_superadmin.CustomAdapter;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
@Listeners({ TestAllureListener.class })
public class CustomAdapterRequiredField extends BaseTest{
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Custom Adapter date validation")
	public void customAdapterRequiredField(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		
		launchapp(browser); 
		loginPage               loginPage          =   new 	loginPage(BaseTest.driver);
		SideNavigationMenuBar   nav                =   new 	SideNavigationMenuBar(BaseTest.driver);
		CustomAdapter           adapter            =   new 	CustomAdapter(BaseTest.driver);
		
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		
		nav.clickSideNavigationArrowBtn();
		
		nav.clickCustomAdapter();
		driver.switchTo().frame("contentFrame");
		
		adapter.clickAddNewBtn();
		//adapter.clickCustomDate("22-Apr-2024");
		//Thread.sleep(2000);
		
		adapter.clickSubmitBtn();
		
		
		Thread.sleep(2000);
		adapter.getRequiredField();
	}
}