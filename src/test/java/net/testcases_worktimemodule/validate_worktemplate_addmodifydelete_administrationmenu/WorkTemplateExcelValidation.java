package net.testcases_worktimemodule.validate_worktemplate_addmodifydelete_administrationmenu;

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
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkTemplatePage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class WorkTemplateExcelValidation extends BaseTest {



	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Data validation for the WorkTemplate table in Excel.")
	@Description("Data validation for the WorkTemplate table in Excel.")
	@Parameters("browser")
	public void workTemplateExcelValidation(String browser) throws InterruptedException, IOException

	{

		launchapp(browser);
		loginPage loginPage = new loginPage(BaseTest.driver);
		
		WorkTemplatePage workTemplateMainPage = new WorkTemplatePage(BaseTest.driver);
		
		
		SideNavigationMenuPage sideNavigationBar = new SideNavigationMenuPage(BaseTest.driver);
		
		SoftAssert softAssert = new SoftAssert();
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();

		sideNavigationBar.clickWorkTemplateBtn();
		workTemplateMainPage.iframeSwitch();

		List<String> webData = workTemplateMainPage.getWorkTemplateWebData();

		workTemplateMainPage.clickexcelWorkTemplateTable();
		List<String> excelData = workTemplateMainPage.getExcelActivityTagTableData();

		webData.forEach(data -> {

			softAssert.assertTrue(excelData.contains(data), "Web data and Excel Data are not match");
		});

		softAssert.assertAll();
		//CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}
}
