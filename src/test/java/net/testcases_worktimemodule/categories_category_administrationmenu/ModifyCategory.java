package net.testcases_worktimemodule.categories_category_administrationmenu;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.CommonMethodsPage;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.CategoryPage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class ModifyCategory extends BaseTest
{

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: In This test case we are downloading the excel and validating few data ")
	public void modifyCategory(String browser) throws InterruptedException
	{
		launchapp(browser);
		
		String					mainWindow;
		loginPage				loginPage				= new loginPage(BaseTest.driver);
		SideNavigationMenuPage	SideNavigationMenuPage	= new SideNavigationMenuPage(BaseTest.driver);
		CategoryPage			CategoryPage			= new CategoryPage(BaseTest.driver);
		CommonMethodsPage		CommonMethodsPage		= new CommonMethodsPage(BaseTest.driver);
		

		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);
		SideNavigationMenuPage.clickSideNavigationBtn();
		SideNavigationMenuPage.clickactivitiesBtn();
		CategoryPage.clickcategoriesBtn();
		CategoryPage.selectFrame();
		CategoryPage.clickCategoryTab();
		CategoryPage.clickModifyIconCategory();
		CategoryPage.modifyTheCategory();
		CategoryPage.saveCategoryBtn();
		CategoryPage.validateModifiedMessage();
		CategoryPage.serachAftermodifiedTxtBx();		
		CategoryPage.validateModifiedCategory();
		CommonMethodsPage.closeAllWindows(BaseTest.driver);
	}

}
