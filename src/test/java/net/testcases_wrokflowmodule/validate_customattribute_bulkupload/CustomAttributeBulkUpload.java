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
import net.pages_worktimemodule.WorkTemplatePage;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;

@Listeners({ TestAllureListener.class })
public class CustomAttributeBulkUpload extends BaseTest
{

	List<String>	hostNameList		= null;

	List<String>	hostNameExcelList	= null;

	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Custom Attribute BulkUpload.")
	@Description("Custom Attribute BulkUpload.")
	@Parameters("browser")
	public void customAttributeBulkUpload(String browser) throws InterruptedException, EncryptedDocumentException, IOException
	{
		launchapp(browser);

		loginPage loginPage = new loginPage(BaseTest.driver);

		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		CustomAttributeBulkUploadPages custom = new CustomAttributeBulkUploadPages(BaseTest.driver);
		ReadXLSdata excel = new ReadXLSdata(BaseTest.driver);
		WorkTemplatePage workTemplate = new WorkTemplatePage(BaseTest.driver);

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
		List<String> specificColumnDataList = workTemplate.getSpecificColumnDataInTable(1);
		boolean workTemplateStatus = specificColumnDataList.stream().anyMatch(listData -> listData.equals("aaaaaaautomation221"));
		if (workTemplateStatus)
		{
			custom.modifyCustomAttributes("aaaaaaautomation221");
			custom.CustomAttributesNameModify(commonMethodsPage.generateRandomString(7));
			custom.saveBtn();

		}
		custom.clickBulkUpload();
		custom.clickBlankTemplate();
		custom.clickClickHereBtn();
		excel.getCustomAttributeAdd();
		custom.clickChooseFileBtn(excel.getRecentFilePath());
		boolean check = custom.clickSuccessMsg();
		Assert.assertTrue(check);
		commonMethodsPage.deleteFileByPath(commonMethodsPage.getRecentFilePath());
		// BulckUpload Modify
		custom.clickBackBtn();
		custom.clickBulkUpload();
		custom.clickTempWithData();
		custom.clickClickHereBtn();
		excel.getCustomAttributeModify();
		custom.clickChooseFileBtn(excel.getRecentFilePath());
		boolean checkModify = custom.clickSuccessMsg();
		Assert.assertTrue(checkModify);
		commonMethodsPage.deleteFileByPath(commonMethodsPage.getRecentFilePath());
		// BulckUpload Delete
		custom.clickBackBtn();
		custom.clickBulkUpload();
		custom.clickTempWithData();
		custom.clickClickHereBtn();
		excel.getCustomAttributeDelete();
		custom.clickChooseFileBtn(excel.getRecentFilePath());
		boolean checkDelete = custom.clickSuccessMsg();
		Assert.assertTrue(checkDelete);
		commonMethodsPage.deleteFileByPath(commonMethodsPage.getRecentFilePath());
		
	}

}
