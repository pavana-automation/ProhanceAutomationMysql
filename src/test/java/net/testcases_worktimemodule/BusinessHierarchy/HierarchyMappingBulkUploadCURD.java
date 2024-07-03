package net.testcases_worktimemodule.BusinessHierarchy;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.BusinessHierarchy;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;

@Listeners({ TestAllureListener.class })

public class HierarchyMappingBulkUploadCURD extends BaseTest{
	

	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "HierarchyMapping BulkUpload CURD")
	@Description("Hierarchy Mapping BulkUpload CURD")
	@Parameters("browser")
	public void hierarchyMappingBulkUploadCURD(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser);
		loginPage loginPage = new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		BusinessHierarchy hierarchy = new BusinessHierarchy(BaseTest.driver);
		ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		nav.clickSideNavigationBtn();
		hierarchy.scrollSideNavigationBar();
		hierarchy.clickBusinessHierarchy();
		Thread.sleep(1000);
		hierarchy.clickHierarchyMapping();
		driver.switchTo().frame("contentFrame");
		hierarchy.clickBulkupload();
		Thread.sleep(1000);
		hierarchy.clickTemplateWithData();
		hierarchy.clickClickHereBtn();
		excel.getHierarchyMappingAddModifyAndDelete();
		hierarchy.clickChooseFileBtn(excel.getRecentFilePath());
	}

}
