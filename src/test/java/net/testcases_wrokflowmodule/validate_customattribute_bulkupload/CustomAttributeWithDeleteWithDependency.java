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
public class CustomAttributeWithDeleteWithDependency extends BaseTest{
	

	List<String> hostNameList = null;
	List<String> hostNameExcelList = null;
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Custom Attribute Delete WithDependency")
	@Description("Custom Attribute Delete WithDependency")
	@Parameters("browser")
	public void customAttributeWithModifyFieldType(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
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
		custom.clickBulkUpload();
		custom.clickTempWithData();
		custom.clickClickHereBtn();
		excel.getCustomAttributeWithDeleteWithDependency();
		custom.clickChooseFileBtn(excel.getRecentFilePath());
		boolean check = custom.getFailMsg();
		Assert.assertTrue(check);
		commonMethodsPage.deleteFileByPath(commonMethodsPage.getRecentFilePath());
	}


}
