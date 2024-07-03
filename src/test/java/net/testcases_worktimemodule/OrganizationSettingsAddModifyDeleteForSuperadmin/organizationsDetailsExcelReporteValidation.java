package net.testcases_worktimemodule.OrganizationSettingsAddModifyDeleteForSuperadmin;

import java.io.IOException;
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
public class organizationsDetailsExcelReporteValidation extends BaseTest
{



	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Modify the Organizations.")
	@Description("Modify the Organizations.")
	@Parameters("browser")

	public void organizationsDetailsExcelValidation(String browser) throws InterruptedException, IOException
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
		
		List<String> organizationDetailsListWeb = OrganizationsOutsidePage.getOrganizationDataFromTable();
		OrganizationsOutsidePage.clickExcelOraganizationTable();
		
		List<String> organizationDetailsListExcel = OrganizationsOutsidePage.getOrganizationDetailsInExcel();

		organizationDetailsListExcel.forEach(orgExcelDetail -> {
			softAssert.assertTrue(organizationDetailsListWeb.contains(orgExcelDetail), "Excel Data are not Matching");
		});
	}

}
