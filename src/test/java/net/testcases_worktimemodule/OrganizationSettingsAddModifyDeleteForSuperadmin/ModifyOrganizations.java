package net.testcases_worktimemodule.OrganizationSettingsAddModifyDeleteForSuperadmin;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.OrganizationsOutsidePage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkTemplatePage;
import net.pages_worktimemodule.loginPage;
@Listeners({ TestAllureListener.class })
public class ModifyOrganizations extends BaseTest
{

	public HashMap<String, String> preparingMapForOrgDetails()
	{

		HashMap<String, String> orgDetailsMap = new HashMap<String, String>();
		orgDetailsMap.put("oraganizationName", "Photon Jhon Modify");
		orgDetailsMap.put("oraganizationCode", "PHTON");
		orgDetailsMap.put("agentBasedUserCount", "40");
		orgDetailsMap.put("agentlessUserCount", "15");
		orgDetailsMap.put("modules", "Work Time,Work Output,Workflow Management,Asset Optimization,Advanced Analytics");
		orgDetailsMap.put("orgAdminUserName", "Jackson denver");
		orgDetailsMap.put("orgAdminPassword", "Jackson denver");
		return orgDetailsMap;
	}

	@Test
	//(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Modify the Organizations.")
	@Description("Modify the Organizations.")
	@Parameters("browser")
	public void modifyTheOrganization(String browser) throws InterruptedException
	{
		launchapp(browser);
		
		loginPage					loginPage					= new loginPage(BaseTest.driver);

		OrganizationsOutsidePage	OrganizationsOutsidePage	= new OrganizationsOutsidePage(BaseTest.driver);

		SideNavigationMenuPage		SideNavigationMenuPage		= new SideNavigationMenuPage(BaseTest.driver);

		WorkTemplatePage			workTemplate				= new WorkTemplatePage(BaseTest.driver);

		SoftAssert					softAssert					= new SoftAssert();

		AddNewOrganizations			addNewOrganizations			= new AddNewOrganizations();

		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		HashMap<String, String> orgDetailsMap = preparingMapForOrgDetails();
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		OrganizationsOutsidePage.sideMenuForOutsideOrganization("General", "Organizations");
		workTemplate.iframeSwitch();

		OrganizationsOutsidePage.enterSearchTxtBx("Photon Jhon");
		HashMap<String, String> addedDetailsMap = addNewOrganizations.preparingMapForOrgDetails();
		
		Thread.sleep(2000);
		softAssert.assertTrue(OrganizationsOutsidePage.modifyOrganizations(orgDetailsMap, "Photon Jhon", addedDetailsMap), "Org Modification is not Proper");
		OrganizationsOutsidePage.clickSaveBtn();
		OrganizationsOutsidePage.enterSearchTxtBx(orgDetailsMap.get("oraganizationName"));
		
		List<String> afterModifiedOrgDetailsList = OrganizationsOutsidePage.getOrganizationDataFromTable();
		String sequenceToCheck = "WT WO AO WF AA";
		String agentBasedUserCountStr = orgDetailsMap.get("agentBasedUserCount");
		String agentlessUserCountStr = orgDetailsMap.get("agentlessUserCount");

		int totalUsersCount = 0;

		try
		{
			int agentBasedUserCount = Integer.parseInt(agentBasedUserCountStr != null ? agentBasedUserCountStr : "0");
			int agentlessUserCount = Integer.parseInt(agentlessUserCountStr != null ? agentlessUserCountStr : "0");
			totalUsersCount = agentBasedUserCount + agentlessUserCount;
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
      
		softAssert.assertTrue(afterModifiedOrgDetailsList.contains(orgDetailsMap.get("oraganizationName")), "OrgName Not Modified");
		softAssert.assertTrue(afterModifiedOrgDetailsList.contains(orgDetailsMap.get("oraganizationCode")), "OrgCode Not Modified");
		softAssert.assertTrue(afterModifiedOrgDetailsList.contains(sequenceToCheck), "Module Name are Not same in table");
		softAssert.assertTrue(afterModifiedOrgDetailsList.contains(String.valueOf(totalUsersCount)), "UserCount not Match");
		Thread.sleep(7000);
		OrganizationsOutsidePage.modifyNavigateToInsideOrg();

		List<String> moduleNames = OrganizationsOutsidePage.getModulesName();
		String ExcptedNames = "WORK TIME, WORK OUTPUT, ASSET OPTIMIZATION, WORKFLOW, ADVANCED ANALYTICS";

		moduleNames.forEach(applicationModuleNames -> {
			if (applicationModuleNames != null && applicationModuleNames != " ")
			{
				softAssert.assertTrue(ExcptedNames.contains(applicationModuleNames), "Selected Modules are not Reflected in inSide the Org");
			}
		});

		softAssert.assertAll();
	}

}
