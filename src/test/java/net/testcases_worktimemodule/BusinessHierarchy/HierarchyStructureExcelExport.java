package net.testcases_worktimemodule.BusinessHierarchy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
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
public class HierarchyStructureExcelExport extends BaseTest{
	
	List<String> hierarchList = new ArrayList<String>();
	List<String> hierarchExcelList = new ArrayList<String>();

	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Hierarchy Structure Excel Export")
	@Description("Hierarchy Structure Excel Export")
	@Parameters("browser")
	public void hierarchyStructureExcelExport(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
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
		hierarchy.clickHierarchyStructure();
		driver.switchTo().frame("contentFrame");
		hierarchList = hierarchy.getHierarchyList();
		hierarchy.clickExcelExport();
		hierarchExcelList = excel.getHierarchyExcel();
		boolean check = hierarchList.equals(hierarchExcelList);
		Assert.assertTrue(check);
	}

}
