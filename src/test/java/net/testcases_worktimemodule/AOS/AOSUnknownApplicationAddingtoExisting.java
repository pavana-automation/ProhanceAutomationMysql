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
public class AOSUnknownApplicationAddingtoExisting extends BaseTest{
	

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: In This test case we are downloading the excel and validating few data ")
	public void aosUnknownApplicationAddingtoExisting(String browser) throws InterruptedException
	
	{
	

	launchapp(browser);
	
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();

	AOSPage aos = new AOSPage(BaseTest.driver);
	
	loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
	

	sidenavPage.clickSideNavigationBtn();
	

	sidenavPage.clickActivitiesBtn();
	
	
	sidenavPage.clickAOSBtn();
	driver.switchTo().frame("contentFrame");
	

	aos.clickMoreActionBtn();
	

	aos.clickUnknownApplicationBtn();
	

	int tableCount = driver.findElements(By.xpath("//table[@id =\"CommonDataTableId\"]/tbody/tr")).size();
	int qulafiedCount = driver.findElements(By.xpath("//table[@id =\"CommonDataTableId\"]/tbody/tr/td[1]/span/i")).size();
	if(tableCount == qulafiedCount)
	{
		System.out.println("Step 8: There is no application to qulafy");
	}
	else
	{
	aos.clickQBtn();
	String expected =driver.findElement(By.xpath("//table[@id ='CommonDataTableId']/tbody/tr/td[2]")).getText();
	aos.selectChkBox();


	aos.clickAddBtn();
	

	aos.selectConfigureUnknownApplicationDrpDwn();
	

	aos.clickSubmitBtn();
	aos.clickAddNewSaveBtn();
	

	aos.clickMoreActionBtn();
	aos.clickUnknownApplicationBtn();
	Thread.sleep(2000);
	aos.clickQBtn();
	String actual =driver.findElement(By.xpath("//table[@id ='CommonDataTableId']/tbody/tr/td[2]")).getText();
	Assert.assertNotEquals(expected, actual);
	
	}
	}

}
