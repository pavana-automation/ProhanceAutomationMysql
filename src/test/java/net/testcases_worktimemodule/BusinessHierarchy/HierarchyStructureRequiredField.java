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
public class HierarchyStructureRequiredField extends BaseTest {

	

	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Hierarchy Structure Excel Export")
	@Description("Hierarchy Structure Excel Export")
	@Parameters("browser")
	public void hierarchyStructureRequiredField(String browser) throws InterruptedException {
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
		hierarchy.clickTitle("");
		hierarchy.clickDescription("auomation_1 description");
		hierarchy.clickSaveBtn();
		boolean check  =hierarchy.clickTitleRequiredMsg();
		System.out.println(check);
		Assert.assertTrue(check);
	}
}
