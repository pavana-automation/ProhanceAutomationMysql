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
import net.pages_asset_optimizationmodule.SoftwareDefinitionPage;
import net.pages_asset_optimizationmodule.WorkStationGroupsPages;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;


@Listeners({ TestAllureListener.class })
public class SoftwareDefinitationExcelExport extends BaseTest{
	
	List<String> softwareDefinitionList = null;
	List<String> softwareDefinitionExcelList = null;

	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "SoftwareD efinitation ExcelExport")
	@Description("SoftwareDefinitation ExcelExport")
	@Parameters("browser")
	public void softwareDefinitation(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		
		launchapp(browser);
		loginPage loginPage = new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		WorkStationGroupsPages workStation = new WorkStationGroupsPages(BaseTest.driver);
		SoftwareDefinitionPage softwareDef = new SoftwareDefinitionPage(BaseTest.driver);
		ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		workStation.clickAssertOptimization();
		Thread.sleep(1000);
		workStation.switchTabs();
		nav.clickWorkFlowSideNavigationArrow();
		workStation.scrollSideNavigationBar();
		workStation.clickAdministration();
		softwareDef.clickSoftwareDefinition();
		driver.switchTo().frame("contentFrame");
		softwareDefinitionList =softwareDef.getSoftwareDefinitionList();
		Thread.sleep(1000);
		softwareDef.clickSoftwareDefinitionExcel();
		softwareDefinitionExcelList = excel.getSoftwareDefinitionExcel();
		boolean check = softwareDefinitionList.equals(softwareDefinitionExcelList);
		System.out.println(check);
		Assert.assertTrue(check);

	}

}
