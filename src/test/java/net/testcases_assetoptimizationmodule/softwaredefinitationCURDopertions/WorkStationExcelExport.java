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
import net.testcases_worktimemodule.utilities.ReadXLSdata;


@Listeners({ TestAllureListener.class })
public class WorkStationExcelExport extends BaseTest{
	
	List<String> workStartionList = null;
	List<String> workstationExcelList = null;

	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "WorkStation Excel Export")
	@Description("WorkStation Excel Export")
	@Parameters("browser")
	public void workStationGroups(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser);
		loginPage loginPage = new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		WorkStationGroupsPages workStation = new WorkStationGroupsPages(BaseTest.driver);
		ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		workStation.clickAssertOptimization();
		Thread.sleep(1000);
		workStation.switchTabs();
		nav.clickWorkFlowSideNavigationArrow();
		workStation.scrollSideNavigationBar();
		workStation.clickAdministration();
		workStation.clickWorkStationGroups();
		driver.switchTo().frame("contentFrame");
		workStartionList = workStation.getWorkStationList();
		workStation.clickWorkStationExcel();
		workstationExcelList = excel.getWorkStationExcel();
		boolean check = workStartionList.equals(workstationExcelList);
		System.out.println(check);
		Assert.assertTrue(check);

	}

}
