package net.testcases_worktimemodule.AOS;

import org.junit.Assert;
import org.openqa.selenium.By;
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
public class AOSUnknownApplicationAddingtoExistingQualifierText extends BaseTest{
	
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: In This test case we are downloading the excel and validating few data ")
	public void aosUnknownApplicationAddingtoExistingQualifierText(String browser) throws InterruptedException
	
	{
	
	launchapp(browser);
	
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	AOSPage aos = new AOSPage(BaseTest.driver);
	
	loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
	
	//listeners.testStepDescription("Step 2: Click on Side Navigation Page");
	sidenavPage.clickSideNavigationBtn();
	
	//listeners.testStepDescription("Step 3: Click on Activities");
	sidenavPage.clickActivitiesBtn();
	
	//listeners.testStepDescription("Step 4: Click on AOS");
	sidenavPage.clickAOSBtn();
	driver.switchTo().frame("contentFrame");
	
	//listeners.testStepDescription("Step 5: Click on More Action");
	aos.clickMoreActionBtn();
	
	//listeners.testStepDescription("Step 6: Click on Unknown Application");
	aos.clickUnknownApplicationBtn();
	
	
	//listeners.testStepDescription("Step 7: Click on Qbutton and select one of the application to qualify the same");
	int tableCount = driver.findElements(By.xpath("//table[@id =\"CommonDataTableId\"]/tbody/tr")).size();
	int qulafiedCount = driver.findElements(By.xpath("//table[@id =\"CommonDataTableId\"]/tbody/tr/td[1]/span/i")).size();
	if(tableCount == qulafiedCount)
	{
		//listeners.testStepDescription("Step 8: There is no application to qulafy");
		System.out.println("Step 8: There is no application to qulafy");
		
	}
	else
	{
	
	aos.clickQBtn();
	String expected =driver.findElement(By.xpath("//table[@id ='CommonDataTableId']/tbody/tr/td[2]")).getText();
	aos.selectChkBox();

	//listeners.testStepDescription("Step 8: Click on Add button");
	aos.clickAddBtn();
	
	//listeners.testStepDescription("Step 9: Add to an Existing application");
	aos.selectConfigureUnknownApplicationDrpDwn();
	driver.findElement(By.id("selectType_AT")).click();
	
	//listeners.testStepDescription("Step 10: After Configuring the application save it");
	aos.clickSubmitBtn();
	aos.clickAddNewSaveBtn();
	
	//listeners.testStepDescription("Step 11: Checking the application whether it is configured or not");
	aos.clickMoreActionBtn();
	aos.clickUnknownApplicationBtn();
	Thread.sleep(2000);
	aos.clickQBtn();
	String actual =driver.findElement(By.xpath("//table[@id ='CommonDataTableId']/tbody/tr/td[2]")).getText();
	Assert.assertNotEquals(expected, actual);
	
	//listeners.testStepDescription("Step 12: The Application is configured successfully");

	}
	}

}
