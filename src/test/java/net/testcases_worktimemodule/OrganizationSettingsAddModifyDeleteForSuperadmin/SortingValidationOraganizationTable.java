package net.testcases_worktimemodule.OrganizationSettingsAddModifyDeleteForSuperadmin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
import net.pages_worktimemodule.OrganizationsOutsidePage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.WorkTemplatePage;
import net.pages_worktimemodule.loginPage;
@Listeners({ TestAllureListener.class })
public class SortingValidationOraganizationTable extends BaseTest
{

	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class, description = "Organizations Details Sorting Validation.")
	@Description("Organizations Details Sorting Validation.")
	@Parameters("browser")
	public void organizationsDetailsSortingValidation(String browser) throws InterruptedException, IOException
	{
		launchapp(browser);
		
		loginPage					loginPage					= new loginPage(BaseTest.driver);

		OrganizationsOutsidePage	OrganizationsOutsidePage	= new OrganizationsOutsidePage(BaseTest.driver);

		SideNavigationMenuPage		SideNavigationMenuPage		= new SideNavigationMenuPage(BaseTest.driver);

		CommonMethodsPage			CommonMethodsPage			= new CommonMethodsPage(BaseTest.driver);

		WorkTemplatePage			workTemplate				= new WorkTemplatePage(BaseTest.driver);

		SoftAssert					softAssert					= new SoftAssert();

		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();

		OrganizationsOutsidePage.sideMenuForOutsideOrganization("General", "Organizations");
		workTemplate.iframeSwitch();
		List<WebElement> tableColumnList = BaseTest.driver.findElements(By.xpath("//table[@class=\"dataTable no-footer\"]/thead/tr[1]/th"));
      
		for (int i = 1; i < tableColumnList.size() - 2; i++)
		{
			if (i != 1)
			{
				OrganizationsOutsidePage.clickForSorting(String.valueOf(i));
			}
			List<String> webSortedList = OrganizationsOutsidePage.getSortedOrgWebData(i);
			List<String> expectedList = new ArrayList<>(webSortedList);

			if (i == 3 || i == 4)
			{
				Collections.sort(expectedList, Comparator.comparingInt(Integer::parseInt));
			}
			else if (i == 5 || i == 6)
			{
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
				List<LocalDate> dates = expectedList.stream().map(expectedData -> LocalDate.parse(expectedData, formatter)).collect(Collectors.toList());
				dates.sort(LocalDate::compareTo);
				expectedList = dates.stream().map(data -> String.valueOf(data.format(formatter))).collect(Collectors.toList());
			}
			else
			{

				Collections.sort(expectedList, String.CASE_INSENSITIVE_ORDER);
			}

			softAssert.assertEquals(webSortedList, expectedList);

			workTemplate.clickForSorting(String.valueOf(i));
			List<String> webSortedListReverse = OrganizationsOutsidePage.getSortedOrgWebData(i);
			List<String> expcetedListReverse = new ArrayList<String>();
			expcetedListReverse.addAll(webSortedListReverse);
			if (i == 3 || i == 4)
			{
				Collections.sort(webSortedListReverse, Comparator.comparingInt(s -> Integer.parseInt((String) s)).reversed());

			}
			else if (i == 5 || i == 6)
			{
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
				List<LocalDate> dates = expcetedListReverse.stream().map(expectedData -> LocalDate.parse(expectedData, formatter)).collect(Collectors.toList());
				dates.sort(Comparator.reverseOrder());
				expcetedListReverse = dates.stream().map(data -> String.valueOf(data.format(formatter))).collect(Collectors.toList());
			}
			else
			{
				Collections.sort(webSortedListReverse, Collections.reverseOrder(Comparator.comparing(String::toLowerCase)));
			}

			softAssert.assertEquals(webSortedListReverse, expcetedListReverse);

		}
		softAssert.assertAll();
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}
}
