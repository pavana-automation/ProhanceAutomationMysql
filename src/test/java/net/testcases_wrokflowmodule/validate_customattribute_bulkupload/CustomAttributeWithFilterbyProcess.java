package net.testcases_wrokflowmodule.validate_customattribute_bulkupload;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_workflowmodule.CustomAttributeBulkUploadPages;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;
@Listeners({ TestAllureListener.class })
public class CustomAttributeWithFilterbyProcess extends BaseTest{
	
	List<String> processList = null;
	List<String> processExcelList = null;

	@Test
	//(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Custom Attribute With DuplicateName")
	@Description("Custom Attribute With DuplicateName")
	@Parameters("browser")
	public void customAttributeWithDuplicateName(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser);
		loginPage loginPage = new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		CustomAttributeBulkUploadPages custom = new CustomAttributeBulkUploadPages(BaseTest.driver);
		ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
		CommonMethodsPage commonMethodsPage = new CommonMethodsPage(BaseTest.driver);
		
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		custom.clickWorkFlowBtn();
		Thread.sleep(1000);
		custom.switchTabs();
		nav.clickWorkFlowSideNavigationArrow();
		custom.scrollSideNavigationBar();
		custom.clickAdministrationBtn();
		Thread.sleep(1000);
		custom.clickCustomAttribute();
		driver.switchTo().frame("contentFrame");
		custom.selectFilterByProcess("Projects and Tasks - V1");
		processList = custom.GetUserArrtribute();
		System.out.println(processList.toString());
		Thread.sleep(4000);
		custom.clickBulkUpload();
		custom.clickTempWithData();
		custom.clickClickHereBtn();
		processExcelList = excel.getFilterByProcess();
		for (int i = 0; i < processList.size(); i++) {
			String data = processList.get(i);
			
			boolean check =processExcelList.contains(data);
			Assert.assertTrue(check);
		}
		commonMethodsPage.deleteFileByPath(commonMethodsPage.getRecentFilePath());
		
}

	

}
