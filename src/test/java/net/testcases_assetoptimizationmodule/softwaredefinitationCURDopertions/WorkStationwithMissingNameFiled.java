package net.testcases_assetoptimizationmodule.softwaredefinitationCURDopertions;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_asset_optimizationmodule.WorkStationGroupsPages;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })

public class WorkStationwithMissingNameFiled extends BaseTest{
	
	List<String> hostNameList = null;
	List<String> hostNameExcelList = null;
	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "WorkStation with Missing Name Filed")
	@Description("WorkStation with Missing Name Filed")
	@Parameters("browser")
	public void workStationwithMissingNameFiled(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser);
		loginPage loginPage = new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		WorkStationGroupsPages workStation = new WorkStationGroupsPages(BaseTest.driver);
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		workStation.clickAssertOptimization();
		Thread.sleep(1000);
		workStation.switchTabs();
		nav.clickWorkFlowSideNavigationArrow();
		workStation.scrollSideNavigationBar();
		workStation.clickAdministration();
		workStation.clickWorkStationGroups();
		driver.switchTo().frame("contentFrame");
		workStation.clickAddNew();
		workStation.clickName("");
		workStation.clickSAVEBtn();

		boolean check  =workStation.clickRequiredMsg();
		System.out.println(check);
		Assert.assertTrue(check);
		
		
	}

}
