package net.testcases_worktimemodule.validate_userdomain_administrationmenu;

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
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.UserDomainPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class UserDomainDeleteFunction extends BaseTest {
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: User Domain Delete Function")
	public void deleteNewFunction(String browser) throws InterruptedException
	{
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
		RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
		
		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		
		//listeners.testStepDescription("Step 2: Click on sideNavigation Page");
		sidenavPage.clickSideNavigationBtn();
		
		//listeners.testStepDescription("Step 3: Click on UserDomain under Organization");
		sidenavPage.clickUserDomainBtn();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(2000);
		
		//listeners.testStepDescription("Step 4: Select particular record and store the value");
		String name = driver.findElement(By.xpath("//td[@class='sorting_1']")).getText();
		
		//listeners.testStepDescription("Step 5: click on delete");
		userdomain.clickDeleteBtn();
		
		//listeners.testStepDescription("Step 6: Verify, Deleted record should not be available in the list");
		ArrayList<String> expectedList = userdomain.getElementsInRowToList();
		Assert.assertFalse(expectedList.contains(name));
		
		//listeners.testStepDescription("Step 7: Record is deleted Successfully");
	}

}
