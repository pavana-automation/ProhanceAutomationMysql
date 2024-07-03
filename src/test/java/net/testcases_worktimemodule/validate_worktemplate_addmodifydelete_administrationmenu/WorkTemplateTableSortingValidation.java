package net.testcases_worktimemodule.validate_worktemplate_addmodifydelete_administrationmenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class WorkTemplateTableSortingValidation extends BaseTest
{


	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "WorkTemplate Table Sorting Validation.")
	@Description("WorkTemplate Table Sorting Validation.")
	@Parameters("browser")
	public void workTemplateTableSortingValidation(String browser) throws InterruptedException, IOException

	{

		launchapp(browser);
		loginPage						loginPage				= new loginPage(BaseTest.driver);
		
		WorkTemplatePage				workTemplateMainPage	= new WorkTemplatePage(BaseTest.driver);
				
		SideNavigationMenuPage			sideNavigationBar		= new SideNavigationMenuPage(BaseTest.driver);
		
		SoftAssert						softAssert				= new SoftAssert();
		
		WorkTemplatePage				workTemplatePage		= new WorkTemplatePage(BaseTest.driver);
		
		CommonMethodsPage				CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);
		
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		sideNavigationBar.clickSideNavigationBtn();

		sideNavigationBar.clickWorkTemplateBtn();
		workTemplateMainPage.iframeSwitch();

		List<WebElement> tableColumnList = driver.findElements(By.xpath("//div[@class=\"dataTables_scrollHeadInner\"]//table[@class=\"dataTable no-footer\"]/thead/tr[1]/th"));

		for (int i = 1; i <= tableColumnList.size() - 1; i++)
		{
			if (i != 1)
			{

				workTemplatePage.clickForSorting(String.valueOf(i));

			}

			List<String> webSortedList = workTemplatePage.getSortedWorkTemplateWebData(i);
			List<String> expcetedList = new ArrayList<String>();
			expcetedList.addAll(webSortedList);
			Collections.sort(expcetedList, Comparator.comparing(String::toLowerCase));
			System.out.println(webSortedList);
			System.out.println(expcetedList);
			softAssert.assertEquals(webSortedList, expcetedList);

			workTemplatePage.clickForSorting(String.valueOf(i));
			List<String> webSortedListReverse = workTemplatePage.getSortedWorkTemplateWebData(i);
			List<String> expcetedListReverse = new ArrayList<String>();
			expcetedListReverse.addAll(webSortedListReverse);
			Collections.sort(webSortedListReverse, Collections.reverseOrder(Comparator.comparing(String::toLowerCase)));
			softAssert.assertEquals(webSortedListReverse, expcetedListReverse);

		}
		softAssert.assertAll();
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}

}
