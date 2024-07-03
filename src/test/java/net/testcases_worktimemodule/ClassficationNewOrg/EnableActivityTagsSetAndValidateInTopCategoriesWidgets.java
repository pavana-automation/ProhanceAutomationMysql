package net.testcases_worktimemodule.ClassficationNewOrg;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.ClassficationPage;
import net.pages_worktimemodule.OrganizationsOutsidePage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkTimeActivityDashboardPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class EnableActivityTagsSetAndValidateInTopCategoriesWidgets extends BaseTest
{

	public Map<String, String> perpareMapFilterValues()
	{
		Map<String, String> filterMap = new HashMap<>();
		filterMap.put("chartType", "2D Bar");
		filterMap.put("widgetWidth", "1x");
		filterMap.put("displayIn", "Hours");
		filterMap.put("userType", "All Users");
		filterMap.put("Teams", "All Groups");
		filterMap.put("reportBy", "Activity Tags");

		return filterMap;
	}

	@Test
	//(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Enable ActivityTags Set AnValidate In TopCategories Widgets")
	@Description("Enable ActivityTags Set AnValidate In TopCategories Widgets")
	@Parameters("browser")
	public void enableActivityTagsSetAndValidateInTopCategoriesWidgets(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);

		loginPage loginPage = new loginPage(BaseTest.driver);

		SideNavigationMenuPage SideNavigationMenuPage = new SideNavigationMenuPage(BaseTest.driver);

		ClassficationPage ClassficationPage = new ClassficationPage(BaseTest.driver);

		OrganizationsOutsidePage organizationsOutsidePage = new OrganizationsOutsidePage(BaseTest.driver);

		WorkTimeActivityDashboardPage wrokTimeActivityDashboardPage = new WorkTimeActivityDashboardPage(BaseTest.driver);

		SoftAssert softAssert = new SoftAssert();

		loginPage.clickLogin(GenderalVariables.newOrgAdminUserName, GenderalVariables.newOrgAdminPassword);
		wrokTimeActivityDashboardPage.navigetToModules("WORK TIME", "ACTIVITY DASHBOARD");
		wrokTimeActivityDashboardPage.selectWidget("Top Categories");
		wrokTimeActivityDashboardPage.clickWidgetFilterBtn();
		wrokTimeActivityDashboardPage.selectingFiltersInTopCategoriesWidget(perpareMapFilterValues());
		List<String> beforeRemoveList = wrokTimeActivityDashboardPage.getClassficationValues();
		wrokTimeActivityDashboardPage.clickCancelBtn();
		wrokTimeActivityDashboardPage.clickLogoImg();
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickactivitiesBtn();

		ClassficationPage.clickClassificationBtn();

		
		ClassficationPage.selectFrame();
		ClassficationPage.unselectActivityTags();
		ClassficationPage.unselectFrame();
		wrokTimeActivityDashboardPage.navigetToModules("WORK TIME", "ACTIVITY DASHBOARD");
		wrokTimeActivityDashboardPage.selectWidget("Top Categories");
		wrokTimeActivityDashboardPage.clickWidgetFilterBtn();
		wrokTimeActivityDashboardPage.selectingFiltersInTopCategoriesWidget(perpareMapFilterValues());
		List<String> AfterRemoveList = wrokTimeActivityDashboardPage.getClassficationValues();
		wrokTimeActivityDashboardPage.clickCancelBtn();
		wrokTimeActivityDashboardPage.clickLogoImg();
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickactivitiesBtn();

		ClassficationPage.clickClassificationBtn();

	
		ClassficationPage.selectFrame();
		ClassficationPage.selectActivityTags();
		ClassficationPage.unselectFrame();
		wrokTimeActivityDashboardPage.navigetToModules("WORK TIME", "ACTIVITY DASHBOARD");
		wrokTimeActivityDashboardPage.selectWidget("Top Categories");
		wrokTimeActivityDashboardPage.clickWidgetFilterBtn();
		wrokTimeActivityDashboardPage.selectingFiltersInTopCategoriesWidget(perpareMapFilterValues());
		List<String> AfterAddedList = wrokTimeActivityDashboardPage.getClassficationValues();
		wrokTimeActivityDashboardPage.clickCancelBtn();
		wrokTimeActivityDashboardPage.clickLogoImg();
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickactivitiesBtn();

		ClassficationPage.clickClassificationBtn();

		
		ClassficationPage.selectFrame();
		ClassficationPage.unselectActivityTags();
		ClassficationPage.unselectFrame();
		softAssert.assertNotEquals(beforeRemoveList, AfterRemoveList, "Removed Activity tags are not reflected in widget");
		softAssert.assertNotEquals(AfterRemoveList, AfterAddedList, "Added Activity tags are not reflected in widget");
		softAssert.assertAll();

	}
}
