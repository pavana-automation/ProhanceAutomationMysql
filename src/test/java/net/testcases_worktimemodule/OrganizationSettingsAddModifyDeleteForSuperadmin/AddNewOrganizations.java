package net.testcases_worktimemodule.OrganizationSettingsAddModifyDeleteForSuperadmin;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.OrganizationsOutsidePage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkTemplatePage;
import net.pages_worktimemodule.loginPage;
@Listeners({ TestAllureListener.class })
public class AddNewOrganizations extends BaseTest
{


	
	public HashMap<String, String> preparingMapForOrgDetails()
	{
		CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);
		 String orgAdmin = CommonMethodsPage.generateRandomString(16);
		HashMap<String, String> orgDetailsMap = new HashMap<String, String>();
		orgDetailsMap.put("oraganizationName", "Photon Jhon");
		orgDetailsMap.put("oraganizationCode", "PHTON");
		orgDetailsMap.put("agentBasedUserCount", "30");
		orgDetailsMap.put("agentlessUserCount", "30");
		orgDetailsMap.put("modules", "Work Time,Work Output,Workflow Management,Asset Optimization");
		orgDetailsMap.put("orgAdminUserName", orgAdmin);
		orgDetailsMap.put("orgAdminPassword", orgAdmin);
		return orgDetailsMap;
	}

	@Test
	//(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Add New Organizations.")
	@Description("Add New Organizations.")
	@Parameters("browser")
	public void addNewOrganizations(String browser) throws InterruptedException
	{
		launchapp(browser);
		loginPage							loginPage							= new loginPage(BaseTest.driver);

		OrganizationsOutsidePage			OrganizationsOutsidePage			= new OrganizationsOutsidePage(BaseTest.driver);

		SideNavigationMenuPage				SideNavigationMenuPage				= new SideNavigationMenuPage(BaseTest.driver);

		WorkTemplatePage					workTemplate						= new WorkTemplatePage(BaseTest.driver);

		SoftAssert							softAssert							= new SoftAssert();



		softAssert.assertTrue(loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword), "Login Faild");
		HashMap<String, String> orgDetailsMap = preparingMapForOrgDetails();
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		OrganizationsOutsidePage.sideMenuForOutsideOrganization("General", "Organizations");
		workTemplate.iframeSwitch();

		OrganizationsOutsidePage.addOrganizations(orgDetailsMap);
		OrganizationsOutsidePage.clickSaveBtn();
		Thread.sleep(3000);
		String actualText = OrganizationsOutsidePage.validateSuccessMessage();
		softAssert.assertEquals(actualText, "Organization: " + orgDetailsMap.get("oraganizationName") + " added successfully", "Success Message is not Same");

		List<String> afterAddOrgList = OrganizationsOutsidePage.getWebOrganizationsData();
		String sequenceToCheck = "WT WO AO WF";
		softAssert.assertTrue(afterAddOrgList.contains(orgDetailsMap.get("oraganizationName")), "Organization Not Added");
		softAssert.assertTrue(afterAddOrgList.contains(orgDetailsMap.get("oraganizationCode")), "Org Code is wrong");
		softAssert.assertTrue(afterAddOrgList.contains(sequenceToCheck), "Module is showing wrong");
		Thread.sleep(50000);
		OrganizationsOutsidePage.navigateToInsideOrg(orgDetailsMap.get("oraganizationName"));

		
		List<String> moduleNames = OrganizationsOutsidePage.getModulesName();
		String ExcptedNames = "WORK TIME, WORK OUTPUT, ASSET OPTIMIZATION, WORKFLOW";

		moduleNames.forEach(applicationModuleNames -> {
			if (applicationModuleNames != null && applicationModuleNames != " ")
			{
				softAssert.assertTrue(ExcptedNames.contains(applicationModuleNames));
			}
		});
		
		softAssert.assertAll();
	}

}
