package net.testcases_worktimemodule.validate_worktemplate_addmodifydelete_administrationmenu;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkTemplatePage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class WorkTemplatePDFValidation extends BaseTest
{



	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Delete the WorkTemplate DefineDayType and validate if it has been successfully Deleted.")
	@Description("Delete the WorkTemplate DefineDayType and validate if it has been successfully Deleted.")
	@Parameters("browser")
	public void workTemplatePDFValidation(String browser) throws InterruptedException, IOException

	{

		launchapp(browser);		
		loginPage						loginPage				= new loginPage(BaseTest.driver);
		
		WorkTemplatePage				workTemplateMainPage	= new WorkTemplatePage(BaseTest.driver);
		
		
		SideNavigationMenuPage			sideNavigationBar		= new SideNavigationMenuPage(BaseTest.driver);
		
		SoftAssert						softAssert				= new SoftAssert();
		
		
		CommonMethodsPage				CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();
	
		sideNavigationBar.clickWorkTemplateBtn();
		workTemplateMainPage.iframeSwitch();
		
		List<String> webData = workTemplateMainPage.getWorkTemplateWebData();
		
		workTemplateMainPage.clickPDFWorkTemplateTable();
		String pdfContent = workTemplateMainPage.getPDFWorkTemplateTableData().replace(" ", "");
		
		webData.forEach(data -> {
			data = data.replace(" ","");
			Assert.assertTrue(pdfContent.contains(data),"Web data and PDF Data are not match");
			
		});
		
		softAssert.assertAll();
		

		CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}

	
	
}
