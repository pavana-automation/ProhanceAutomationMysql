package net.testcases_worktimemodule.AOS;

import java.util.ArrayList;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.RandomStringGeneration;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.AOSPage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.UserDomainPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class AOSAddNew extends BaseTest{
	


	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: In This test case we are downloading the excel and validating few data ")
	public void addNewFunction(String browser) throws InterruptedException
	{
		//listeners.testStepDescription("Step 1: Login into the prohance application");
		//driver = initializeDriverMysql();
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
		AOSPage aos = new AOSPage(BaseTest.driver);
		RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
		
		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);

		sidenavPage.clickSideNavigationBtn();
		
		//listeners.testStepDescription("Step 2: click on Activities");
		sidenavPage.clickActivitiesBtn();
		
		//listeners.testStepDescription("Step 3: click on AOS");
		Thread.sleep(2000);
		sidenavPage.clickAOSBtn();
		driver.switchTo().frame("contentFrame");
		
		//listeners.testStepDescription("Step 4: click on add new AOS");
		aos.clickAddNewBtn();
		String result1 = randomStringGenerator.randomStringGenerator();
		
		//listeners.testStepDescription("Step 5: Fill all the details and the expected result is :"+result1);
		aos.sendApplicationNameTxt(result1);
		aos.selectActivityTypeDrpDwn();
		
		//listeners.testStepDescription("Step 6: click on Save Button");
		aos.clickAddNewSaveBtn();
		aos.clickSignatureOkBtn();
		
		//listeners.testStepDescription("Step 7: Moves to the next Signature page and fill title");
		aos.sendWindowTitle("www");
		aos.clickAddTitleBtn();
		
		//listeners.testStepDescription("Step 8: Click on Add and save the added title and save it");
		//test.info("Click on Add and save the added title and save it");
		aos.clickSaveSignatureBtn();
		
		//listeners.testStepDescription("Step 9: Check whether the newly added record in present in the list");
		//test.info("Check whether the newly added record in present in the list");
		Thread.sleep(2000);
		ArrayList<String> ActualList = userdomain.getElementsInRowToList();
		Assert.assertTrue(ActualList.contains(result1));
		
		//listeners.testStepDescription("Step 10: AOS added new one successfully");
	}
}
