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
public class SoftwareDefinitionForSoftwareTagsPdf extends BaseTest{
	
	List<String> softwareTagsList = null;
	List<String> softwareTagsExcelList = null;
	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Software Definition For SoftwareTags Pdf")
	@Description("Software Definition For SoftwareTags Pdf")
	@Parameters("browser")
	public void softwareDefinitationForSoftwareTagsCURD(String browser) throws InterruptedException, EncryptedDocumentException, IOException {

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
		BaseTest.driver.switchTo().frame("contentFrame");
		softwareDef.clikSoftwareTagsBtn();
		softwareTagsList = softwareDef.getSoftwareTagsList();
		softwareDef.clickSoftwareTagsPdf();
		String actualPdfList = excel.getSoftwareTagsPDF(); 
		for (int i = 0; i < softwareTagsList.size(); i++) {
			String data = softwareTagsList.get(i);
			boolean checkPdf = actualPdfList.contains(data);
			Assert.assertTrue(checkPdf);
		}
	}

}
