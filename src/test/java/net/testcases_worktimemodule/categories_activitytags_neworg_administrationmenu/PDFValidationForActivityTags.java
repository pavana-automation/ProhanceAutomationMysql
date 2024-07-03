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
import net.pages_worktimemodule.ClassficationPage;
import net.pages_worktimemodule.OrganizationsOutsidePage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class PDFValidationForActivityTags extends BaseTest
{

	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: Here we are verifying whether we are able to modify ")
	public void PDFvalidationForActivityTags(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);
		
		loginPage				loginPage				= new loginPage(BaseTest.driver);

		SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);


		CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);

		CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);

		ActivityTagsPage		ActivityTagsPage		= new ActivityTagsPage(BaseTest.driver);
		
		OrganizationsOutsidePage OrganizationsOutsidePage = new OrganizationsOutsidePage(BaseTest.driver);

		loginPage.clickLogin(GenderalVariables.newOrgAdminUserName, GenderalVariables.newOrgAdminPassword);

		
		  SideNavigationMenuPage.clickSideNavigationBtn();
		  
//		  
//		  SideNavigationMenuPage.clickactivitiesBtn();
//		  
//		  
//		  CategoryPage.clickcategoriesBtn();
		  
		  OrganizationsOutsidePage.sideMenuForOutsideOrganization("Activities","Categories");	
		  
		  CategoryPage.selectFrame();
		  
		  
		  ActivityTagsPage.clickActivityTagTab();
		  ActivityTagsPage.getWebActivityTagTableData();
		  
		  
		  ActivityTagsPage.clickPDFActivityTagTable();
		  
		  
		  ActivityTagsPage.getPDFActivityTagTableData();
		  
		  ActivityTagsPage.validatePDFDataWithWeb();
		  
		  CommonMethodsPage.closeAllWindows(BaseTest.driver);
		 
	}

}
