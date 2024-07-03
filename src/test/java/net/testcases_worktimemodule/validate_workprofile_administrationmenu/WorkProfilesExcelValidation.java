package net.testcases_worktimemodule.validate_workprofile_administrationmenu;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkProfilesPage;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;

@Listeners({ TestAllureListener.class })
public class WorkProfilesExcelValidation  extends BaseTest{


	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: clone on work Profiles ")
	public void cloneOnWorkProfiles (String browser) throws InterruptedException, EncryptedDocumentException, IOException
	{
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		WorkProfilesPage workProfile = new WorkProfilesPage(BaseTest.driver);
		ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
		Set<String> workProfileExcelList = null;
		Set<String> workProfileList = null;
		boolean workprofileCompare=false;
		
				
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		
		nav.clickSideNavigationBtn();
		workProfile.scrollSideNavigationBar();
	
		nav.clickActivityTab();
	
		nav.clickWorkProfilestab();
		driver.switchTo().frame("contentFrame");

		Thread.sleep(2000);
		workProfile.clickAllWorkProfileExcel();
		Thread.sleep(5000);

		workProfileExcelList = excel.getAllWorkProfilesConfig();
	//	Thread.sleep(5000);

		workProfileList = workProfile.getWorkProfileList();
	//	Thread.sleep(5000);
	
		for(String ele:workProfileList)
		{
			   String list = workProfileExcelList.contains(ele) ? "Yes" : "No";
			   if(list.equals("Yes"))
			   {
				   workprofileCompare = true;
			   }
		}
		Assert.assertTrue(workprofileCompare);
	}

}
