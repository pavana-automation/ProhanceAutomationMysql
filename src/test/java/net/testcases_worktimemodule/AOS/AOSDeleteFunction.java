package net.testcases_worktimemodule.AOS;

import java.util.ArrayList;

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
public class AOSDeleteFunction extends BaseTest {
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: In This test case we are downloading the excel and validating few data ")
	public void aosDeleteFunction(String browser) throws InterruptedException
	
	{
	

	//driver = initializeDriverMysql();
	launchapp(browser);
	
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
	AOSPage aos = new AOSPage(BaseTest.driver);
	
	loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
	

	sidenavPage.clickSideNavigationBtn();
	

	sidenavPage.clickActivitiesBtn();
	
	Thread.sleep(2000);
	sidenavPage.clickAOSBtn();
	driver.switchTo().frame("contentFrame");
	Thread.sleep(2000);
	

	String name = driver.findElement(By.xpath("//td[@class='sorting_1']")).getText();
	

	userdomain.clickDeleteBtn();
	

	try 
	{
	String actualMsg = driver.findElement(By.id("dialogfailurespan")).getText();
	String expectedMsg = "Activity On System: "+name+" cannot be deleted due to data dependency. Click here to view dependency";
	Assert.assertTrue(actualMsg.contains("Activity"));
	ArrayList<String> expectedList = userdomain.getElementsInRowToList();
	Assert.assertTrue(expectedList.contains(name));
	}
	catch(org.openqa.selenium.NoSuchElementException e) {
		driver.findElement(By.xpath("//input[@value='No']")).click();
		ArrayList<String> expectedList = userdomain.getElementsInRowToList();
		Assert.assertTrue(expectedList.contains(name));
	}
	
	
	}

}

