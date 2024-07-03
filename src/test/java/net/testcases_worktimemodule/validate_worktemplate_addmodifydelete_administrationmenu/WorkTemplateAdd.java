package net.testcases_worktimemodule.validate_worktemplate_addmodifydelete_administrationmenu;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkTemplatePage;
import net.pages_worktimemodule.loginPage;
@Listeners({ TestAllureListener.class })
public class WorkTemplateAdd extends BaseTest
{


	
	@Test( retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Add the WorkTemplate and validate if it has been successfully added.")
	@Description("Add the WorkTemplate and validate if it has been successfully added.")
	@Parameters("browser")
	public void workTemplateAdd(String browser) throws InterruptedException
	{
		launchapp(browser);
		loginPage				loginPage			= new loginPage(BaseTest.driver);
		
		WorkTemplatePage		workTemplate		= new WorkTemplatePage(BaseTest.driver);
		
		SideNavigationMenuPage	sideNavigationBar	= new SideNavigationMenuPage(BaseTest.driver);
		
		CommonMethodsPage CommonMethodsPage = new CommonMethodsPage(BaseTest.driver);
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();

		sideNavigationBar.clickWorkTemplateBtn();
		workTemplate.iframeSwitch();
		
		Thread.sleep(2000);
		List<String> specificColumnDataList = workTemplate.getSpecificColumnDataInTable(1);
		boolean workTemplateStatus = specificColumnDataList.stream().anyMatch(listData ->listData.equals("TemplateTestAutomation"));
		if(workTemplateStatus) {
			workTemplate.modifyWorkTemplate("TemplateTestAutomation");
			workTemplate.addNameAndDescriptionModify(CommonMethodsPage.generateRandomString(6), "tc");
			workTemplate.saveBtn();
			workTemplate.clickBackBtnLabel();
			
		}
		workTemplate.clickAddNewBtn();
		workTemplate.addNameAndDescription("TemplateTestAutomation", "TemplateDesc");
		workTemplate.saveBtn(); 
		
		workTemplate.navigateToWorkTimeTargets();
		workTemplate.checkWorkTimeTargetForMondayToFriday();
		workTemplate.saveBtnWorkTemplate();
		
		workTemplate.successMessageValidate("Work Time Targets modified successfully");
		
		workTemplate.clickHolidayLabel();
		Thread.sleep(2000);
		workTemplate.holidayNameInput("Diwali");
		workTemplate.selectDatePickerInHoliday();
		workTemplate.selectDateInDatePicker(2023, "Mar", "15");
		workTemplate.saveHoliday();
		
		workTemplate.successMessageValidate("Holidays Diwali added successfully");
		
		workTemplate.navigateToTeamMappingLabel();
		
		workTemplate.addButtonTeamMapping();
		String childWindow = workTemplate.childWindow();
		workTemplate.checkFirstTeamInWorkTemplate();
		//String selectedTeam = workTemplate.getSelectedTeamName();
		workTemplate.addTeamWorkTemaplate();
		workTemplate.mainWindow(childWindow);
		workTemplate.iframeSwitch();
		Thread.sleep(2000);
		workTemplate.clickWorkLoadCategoriesLabel();
		workTemplate.clickExitBtn();
		
		workTemplate.validateAddedTeamplateInTable("TemplateTestAutomation");
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}

}
