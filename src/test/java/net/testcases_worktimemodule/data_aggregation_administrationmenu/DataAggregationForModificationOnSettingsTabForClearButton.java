package net.testcases_worktimemodule.data_aggregation_administrationmenu;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.DataAggregationPage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class DataAggregationForModificationOnSettingsTabForClearButton extends BaseTest {

	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: User Domain add new function")
	public void modificationOnSettingsTabForClearButton(String browser) throws InterruptedException, StaleElementReferenceException {
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage nav = new SideNavigationMenuPage(BaseTest.driver);
		DataAggregationPage aggregation = new DataAggregationPage(BaseTest.driver);
		
	
		loginPage.clickLogin(GenderalVariables.adminUserName, GenderalVariables.adminPassword);

		nav.clickSideNavigationBtn();

		nav.clickDataAggregationBtn();
		driver.switchTo().frame("contentFrame");

		aggregation.clickSettingsBtn();

		aggregation.clickClearBtn();
		
	}

}
