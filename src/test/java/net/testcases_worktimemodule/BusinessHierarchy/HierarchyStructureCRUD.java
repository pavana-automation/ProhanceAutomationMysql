package net.testcases_worktimemodule.BusinessHierarchy;

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
@Listeners({ TestAllureListener.class })
public class HierarchyStructureCRUD extends BaseTest{
	
		
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Hierarchy Structure CRUD")
	@Description("Hierarchy Structure CRUD")
	@Parameters("browser")
	public void hierarchyStructureCRUD(String browser) throws InterruptedException {
		
		launchapp(browser);
		loginPage loginPage = new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		BusinessHierarchy hierarchy = new BusinessHierarchy(BaseTest.driver);
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		nav.clickSideNavigationBtn();
		hierarchy.scrollSideNavigationBar();
		hierarchy.clickBusinessHierarchy();
		Thread.sleep(1000);
		hierarchy.clickHierarchyStructure();
		driver.switchTo().frame("contentFrame");
		hierarchy.clickAddNewBtn();
		hierarchy.clickTitle("automation_1");
		hierarchy.clickDescription("auomation_1 description");
		hierarchy.clickActive();
		hierarchy.clickSaveBtn();
		boolean checkAdd = hierarchy.clickAddMsg();
		Assert.assertTrue(checkAdd);
		hierarchy.clickModify();
		hierarchy.clickInactive();
		hierarchy.clickSaveBtn();
		boolean checkMod = hierarchy.clickModifyMsg();
		Assert.assertTrue(checkMod);
		hierarchy.clickDelete();
		Thread.sleep(1000);
		hierarchy.clickYesBtn();
		boolean checkDel  = hierarchy.clickDeleteMsg();
		Assert.assertTrue(checkDel);
	}

}
