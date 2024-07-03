package net.testcases_superadmin;

import java.io.IOException;
import java.util.List;

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
import net.testcases_worktimemodule.utilities.ReadXLSdata;
@Listeners({ TestAllureListener.class })
public class CustomAdapterCloseBtn extends BaseTest{
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Custom Adapter close btn validation")
	public void customAdapterCloseBtn(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		
		launchapp(browser); 
		loginPage               loginPage          =   new 	loginPage(BaseTest.driver);
		SideNavigationMenuBar   nav                =   new 	SideNavigationMenuBar(BaseTest.driver);
		CustomAdapter           adapter            =   new 	CustomAdapter(BaseTest.driver);
		ReadXLSdata             excel              =   new 	ReadXLSdata(BaseTest.driver);
		GenderalVariables       gv         		   =   new 	GenderalVariables();
		List<String>            customList         =   null;
		List<String>            customExcelList    =   null;  
		
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);

		nav.clickSideNavigationArrowBtn();
		
		nav.clickCustomAdapter();
		driver.switchTo().frame("contentFrame");
		adapter.clickAddNewBtn();
		Thread.sleep(3000);
		
		adapter.clickClearbtn();
	}
}