package net.testcases_worktimemodule.categories_activitytags_neworg_administrationmenu;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.ActivityTagsPage;
import net.pages_worktimemodule.CategoryPage;
import net.pages_worktimemodule.OrganizationsOutsidePage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class ActivityTagsBulkUploadValidatePrefilldData extends BaseTest
{

	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: Here we are verifying whether we are able to modify ")
	public void activityTagsBulkUploadValidatePrefilldData(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);
		
		loginPage				loginPage				= new loginPage(BaseTest.driver);

		SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);

		CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

		ActivityTagsPage		ActivityTagsPage		= new ActivityTagsPage(BaseTest.driver);
		
		CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);
		OrganizationsOutsidePage OrganizationsOutsidePage = new OrganizationsOutsidePage(BaseTest.driver);
		
		loginPage.clickLogin(GenderalVariables.newOrgAdminUserName, GenderalVariables.newOrgAdminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickactivitiesBtn();
//		
//	
		CategoryPage.clickcategoriesBtn();
		
		//OrganizationsOutsidePage.sideMenuForOutsideOrganization("Activities","Categories");	
		CategoryPage.selectFrame();
		
	
		ActivityTagsPage.clickActivityTagTab();
		ActivityTagsPage.getWebActivityTagTableDataToComparePrefilledData();
		
		
		ActivityTagsPage.clickBulckUploadBtn();
		ActivityTagsPage.clickBulckUploadWithPrefilledDataRB();
		
		
		ActivityTagsPage.clickBulckUploadClickHereLinkToGetExcel();
		ActivityTagsPage.getWithPrefilledExcelData();
		

		ActivityTagsPage.validateWithPrefilledExcelDataWithWeb();
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}
}
