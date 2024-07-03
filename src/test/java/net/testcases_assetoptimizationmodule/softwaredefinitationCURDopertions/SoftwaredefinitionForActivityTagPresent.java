package net.testcases_assetoptimizationmodule.softwaredefinitationCURDopertions;

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
import net.pages_asset_optimizationmodule.SoftwareDefinitionPage;
import net.pages_asset_optimizationmodule.WorkStationGroupsPages;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.loginPage;



@Listeners({ TestAllureListener.class })
public class SoftwaredefinitionForActivityTagPresent extends BaseTest{
	
	List<String> activityNameList = null;
	List<String> hostNameExcelList = null;
	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Softwaredefinition For Activity TagPresent")
	@Description("Softwaredefinition For Activity TagPresent")
	@Parameters("browser")
	public void softwareDefinitationForSoftwareTagsCURD(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser);
		loginPage loginPage = new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		WorkStationGroupsPages workStation = new WorkStationGroupsPages(BaseTest.driver);
		SoftwareDefinitionPage softwareDef = new SoftwareDefinitionPage(BaseTest.driver);

		
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		workStation.clickAssertOptimization();
		Thread.sleep(1000);
		workStation.switchTabs();
		nav.clickWorkFlowSideNavigationArrow();
		workStation.scrollSideNavigationBar();
		workStation.clickAdministration();
		softwareDef.clickSoftwareDefinition();
		driver.switchTo().frame("contentFrame");
		softwareDef.clikSoftwareTagsBtn();
		softwareDef.clickAddNewBtn();
		softwareDef.clickSName("automation_for_activity tag_check");
		softwareDef.clicksSAVEBtn();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		softwareDef.clickBottomBtn();
		softwareDef.clickSoftwareDefinition();
		driver.switchTo().frame("contentFrame");
		softwareDef.clickModifyForactivity();
		activityNameList = softwareDef.getWorkProfilesName();
		boolean check= activityNameList.contains("automation_for_activitytag_check");
		System.out.println(check);

	}

}
