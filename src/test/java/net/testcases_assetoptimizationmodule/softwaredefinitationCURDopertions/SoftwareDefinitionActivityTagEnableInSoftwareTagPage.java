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
@Listeners({ TestAllureListener.class })


public class SoftwareDefinitionActivityTagEnableInSoftwareTagPage extends BaseTest{
	
	List<String> hostNameList = null;
	List<String> hostNameExcelList = null;
	boolean result = false;
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "softwareDefinition ActivityTag Enable In SoftwareTag Page")
	@Description("softwareDefinition ActivityTag Enable In SoftwareTag Page")
	@Parameters("browser")
	public void softwareDefinitionActivityTagEnableInSoftwareTagPage(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
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
		Thread.sleep(1000);
		softwareDef.clikSoftwareTagsBtn();
		softwareDef.clickSoftwareTabBtn();
		boolean check1 =  softwareDef.clickActivityTab();
		Thread.sleep(1000);
		softwareDef.clickCancelButton();
		Thread.sleep(1000);
		softwareDef.clickAddNewBtn();
		boolean check2 = softwareDef.clickActivityTagOption();
		if(check1 == check2 )
		{
			 result = true;
		}
		Assert.assertTrue(result);
		
	}

}
