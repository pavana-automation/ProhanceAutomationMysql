package net.testcases_worktimemodule.AuditTrailTabValidationWrokTimeAdministrationMenu;

import java.io.IOException;
import java.util.ArrayList;
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
import net.pages_worktimemodule.WorkTimeAuditTrailPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class ValidateActionLogoutAuditTrail extends BaseTest
{

	
	public List<String> preparenotExeptedList()
	{
		List<String> notExeptedValueList = new ArrayList<String>();
		notExeptedValueList.add("ADD");
		notExeptedValueList.add("DELETE");
		notExeptedValueList.add("LOGIN");
		notExeptedValueList.add("MODIFY");
		notExeptedValueList.add("SERVICE");
		notExeptedValueList.add("VIEW");
		notExeptedValueList.add("STARTUP");
		return notExeptedValueList;
	}

	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Audit Trail actionLogout.")
	@Description("Audit Trail actionLogout.")
	@Parameters("browser")
	public void actionLogout(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);
		
		loginPage					loginPage					= new loginPage(BaseTest.driver);

		OrganizationsOutsidePage	OrganizationsOutsidePage	= new OrganizationsOutsidePage(BaseTest.driver);

		SideNavigationMenuPage		SideNavigationMenuPage		= new SideNavigationMenuPage(BaseTest.driver);

		WorkTemplatePage			workTemplate				= new WorkTemplatePage(BaseTest.driver);

		SoftAssert					softAssert					= new SoftAssert();

		WorkTimeAuditTrailPage		workTimeAuditTrailPage		= new WorkTimeAuditTrailPage(BaseTest.driver);

		
		
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		
		OrganizationsOutsidePage.sideMenuForOutsideOrganization("Support", "Audit Trail");
		workTemplate.iframeSwitch();
		
		workTimeAuditTrailPage.selectOrganizationInOrgDropDown("PH Sales");
		
		workTimeAuditTrailPage.clickActionDropDown();
		workTimeAuditTrailPage.checkSelectAllChkBx();
		workTimeAuditTrailPage.unCheckSelectAllChkBx();
		workTimeAuditTrailPage.selectActionChkBx("LOGOUT");
		workTimeAuditTrailPage.clickFetchBtn();
		
		List<String> aduitWebDataList = workTimeAuditTrailPage.getValuesAuditTarilDataTable();
		List<String> notExeptedValueList = preparenotExeptedList();
		
		notExeptedValueList.forEach(value -> {

			softAssert.assertFalse(aduitWebDataList.contains(value), "Other Action Also Showing table, when Select ADD");
		});
		
		OrganizationsOutsidePage.clickExcelOraganizationTable();
		List<String> excelDataList = workTimeAuditTrailPage.getOrganizationDetailsInExcel();
		excelDataList.forEach(excelValue -> {

			softAssert.assertTrue(aduitWebDataList.contains(excelValue), "Excel Data are not match with Web Data");
		});
		
		OrganizationsOutsidePage.clickPDFImg();
		String PfdData = OrganizationsOutsidePage.getOrganizationDetailsInPDF();
		aduitWebDataList.forEach(pdfValue -> {

			softAssert.assertTrue(PfdData.contains(pdfValue), "PDF Data are not match with Web Data");
		});

	}

}
