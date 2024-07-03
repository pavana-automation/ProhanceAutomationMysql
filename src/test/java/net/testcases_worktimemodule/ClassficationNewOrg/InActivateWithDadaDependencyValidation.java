package net.testcases_worktimemodule.ClassficationNewOrg;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
public class InActivateWithDadaDependencyValidation extends BaseTest
{



	@Test
	//(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "InActivate With DadaDependency Validation")
	@Description("InActivate With DadaDependency Validation")
	@Parameters("browser")
	public void inActivateWithDadaDependencyValidation(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);
		
		loginPage						loginPage						= new loginPage(BaseTest.driver);
		
		SideNavigationMenuPage			SideNavigationMenuPage			= new SideNavigationMenuPage(BaseTest.driver);
		
		ClassficationPage				ClassficationPage				= new ClassficationPage(BaseTest.driver);
		
		CommonMethodsPage				CommonMethodsPage				= new CommonMethodsPage(BaseTest.driver);
		
		CategoryPage					CategoryPage					= new CategoryPage(BaseTest.driver);
		
		ActivityTagsPage				ActivityTagsPage				= new ActivityTagsPage(BaseTest.driver);
		
		OrganizationsOutsidePage		organizationsOutsidePage		= new OrganizationsOutsidePage(BaseTest.driver);
		
		SoftAssert						softAssert						= new SoftAssert();
		
		loginPage.clickLogin(GenderalVariables.newOrgAdminUserName, GenderalVariables.newOrgAdminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();

		SideNavigationMenuPage.clickactivitiesBtn();

		ClassficationPage.clickClassificationBtn();

		ClassficationPage.selectFrame();

		ClassficationPage.setTheParentClassification();

		ClassficationPage.unselectFrame();

		SideNavigationMenuPage.clickSideNavigationBtn();

		CategoryPage.clickcategoriesBtn();

		ClassficationPage.selectFrame();

		ActivityTagsPage.clickActivityTagTab();

		CategoryPage.clickaddNewBtn();

		ActivityTagsPage.addActivityTags();

		ActivityTagsPage.clickactivityTagsSaveBtn();

		ActivityTagsPage.validateAddedSuccessMessageForactivityTag();

		ActivityTagsPage.searchActivityTagTableTxtBx();
 
		ActivityTagsPage.validateActivityTagAdded();
		ClassficationPage.unselectFrame();
		SideNavigationMenuPage.clickSideNavigationBtn();
		organizationsOutsidePage.sideMenuForOutsideOrganization("Activities", "Classification");
		ClassficationPage.selectFrame();
		ClassficationPage.unselectActivityTags();
		String msg = ClassficationPage.validateDataDependencyMsg();

		softAssert.assertEquals(msg, "Classification: Class C cannot be inactivated as it has applications mapped to it");

		ClassficationPage.unselectFrame();
		SideNavigationMenuPage.clickSideNavigationBtn();

		
		SideNavigationMenuPage.clickactivitiesBtn();

		
		CategoryPage.clickcategoriesBtn();

		CategoryPage.selectFrame();

		
		ActivityTagsPage.clickActivityTagTab();

		ActivityTagsPage.searchAfteraddedActivityTagTableTxtBx();

		ActivityTagsPage.clickDeleteActivityTagbeforeModify();

		CategoryPage.clcikConfirmToDeleteYesBtn();
		
		CommonMethodsPage.closeAllWindows(driver);
		softAssert.assertAll();

	}
}
