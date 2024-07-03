package net.testcases_worktimemodule.OrganizationSettingsAddModifyDeleteForSuperadmin;

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
public class DeleteOrganizations extends BaseTest
{


	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Deleyte the Organizations.")
	@Description("Deleyte the Organizations.")
	@Parameters("browser")
	public void deleteTheOrganization(String browser) throws InterruptedException
	{
		launchapp(browser);
		loginPage					loginPage					= new loginPage(BaseTest.driver);
		OrganizationsOutsidePage	OrganizationsOutsidePage	= new OrganizationsOutsidePage(BaseTest.driver);
		SideNavigationMenuPage		SideNavigationMenuPage		= new SideNavigationMenuPage(BaseTest.driver);
		WorkTemplatePage			workTemplate				= new WorkTemplatePage(BaseTest.driver);
		SoftAssert					softAssert					= new SoftAssert();

		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		OrganizationsOutsidePage.sideMenuForOutsideOrganization("General", "Organizations");
		workTemplate.iframeSwitch();
		OrganizationsOutsidePage.enterSearchTxtBx("Photon Jhon Modify");
		OrganizationsOutsidePage.clickDeleteIcon("Photon Jhon Modify");
		String msg  = OrganizationsOutsidePage.validateDeleted();	
		softAssert.assertEquals(msg, "Organization: Photon Jhon Modify deleted successfully","Message is not proper");
		List<String> afterModifiedOrgDetailsList = OrganizationsOutsidePage.getOrganizationDataFromTable();
		softAssert.assertFalse(afterModifiedOrgDetailsList.contains("Photon Jhon Modify"), "OrgName Not Deleted");
		softAssert.assertAll();
		
	}

}
