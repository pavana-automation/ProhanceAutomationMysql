package net.testcases_worktimemodule.ClassficationNewOrg;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.ActivityTagsPage;
import net.pages_worktimemodule.CategoryPage;
import net.pages_worktimemodule.ClassficationPage;
import net.pages_worktimemodule.OrganizationsOutsidePage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.loginPage;


@Listeners({ TestAllureListener.class })
public class EnabelActivityTagsAndSetParentValidationInCategories extends BaseTest
{


	@Test
	//(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Add Activity Tag In Cafication And SetParent Validation")
	@Description("Add Activity Tag In Cafication And SetParent Validation")
	@Parameters("browser")
	public void addActivityTagInCaficationAndSetParentValidation(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);	
		
		loginPage					loginPage					= new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage		SideNavigationMenuPage		= new SideNavigationMenuPage(BaseTest.driver);
		
		ClassficationPage			ClassficationPage			= new ClassficationPage(BaseTest.driver);
				
		CategoryPage				CategoryPage				= new CategoryPage(BaseTest.driver);
		
		ActivityTagsPage			ActivityTagsPage			= new ActivityTagsPage(BaseTest.driver);
		
		OrganizationsOutsidePage	organizationsOutsidePage	= new OrganizationsOutsidePage(BaseTest.driver);
		
		
		SoftAssert					softAssert					= new SoftAssert();

		loginPage.clickLogin(GenderalVariables.newOrgAdminUserName, GenderalVariables.newOrgAdminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();

		SideNavigationMenuPage.clickactivitiesBtn();

		ClassficationPage.clickClassificationBtn();

		ClassficationPage.selectFrame();

		ClassficationPage.setTheParentClassification();
		ClassficationPage.unselectFrame();
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		organizationsOutsidePage.sideMenuForOutsideOrganization("Activities", "Categories");
		ClassficationPage.selectFrame();

		ActivityTagsPage.clickActivityTagTab();

		CategoryPage.clickaddNewBtn();
		
		softAssert.assertTrue(ClassficationPage.validateClassficationParentInActivityTag("Job Category","Class C"), "Parent Activity is not Displaying");
		
		ClassficationPage.unselectFrame();
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		organizationsOutsidePage.sideMenuForOutsideOrganization("Activities", "Classification");
		ClassficationPage.selectFrame();
		
		ClassficationPage.setAnotherCatagoryAsParent();
		
		ClassficationPage.unselectFrame();
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		organizationsOutsidePage.sideMenuForOutsideOrganization("Activities", "Categories");
		ClassficationPage.selectFrame();

		ActivityTagsPage.clickActivityTagTab();

		CategoryPage.clickaddNewBtn();
		softAssert.assertTrue(ClassficationPage.validateClassficationParentInActivityTag("Job Category","Class D"), "Parent Activity is Displaying when we remove Parent Relation");
		
		ClassficationPage.unselectFrame();
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		organizationsOutsidePage.sideMenuForOutsideOrganization("Activities", "Classification");
		ClassficationPage.selectFrame();
		
		ClassficationPage.disabelParentRelationInClassfication();
		
		ClassficationPage.unselectFrame();
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		organizationsOutsidePage.sideMenuForOutsideOrganization("Activities", "Categories");
		ClassficationPage.selectFrame();

		ActivityTagsPage.clickActivityTagTab();

		CategoryPage.clickaddNewBtn();
		softAssert.assertFalse(ClassficationPage.validateClassficationParentInActivityTag("","Class C"), "Parent Activity is Displaying when we remove Parent Relation");
		softAssert.assertAll();
	}
}
