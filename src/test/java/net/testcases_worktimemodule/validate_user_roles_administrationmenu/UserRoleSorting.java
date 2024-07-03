package net.testcases_worktimemodule.validate_user_roles_administrationmenu;

import org.testng.Assert;
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
public class UserRoleSorting extends BaseTest{
	
	@Test
	@Parameters("browser")
	@Description("Test Description: Here we are verifying whether we are able to do sorting ")
	public void userRoleSorting(String browser) throws InterruptedException
	{
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
		RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
		
		
		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		Thread.sleep(2000);
		
		sidenavPage.clickSideNavigationBtn();
		
	
		sidenavPage.ClickOnUserRoleBtn();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(2000);
		
		
		String expectedList = userdomain.getElementsInRowToList().toString();
		
		
		userdomain.clickUserRoleNameBtn();
		//Thread.sleep(1000);
		String actualList = userdomain.getElementsInRowToList().toString();
		
		
		
		Assert.assertEquals(expectedList, actualList);	
		
		
		
		driver.close();
	}
		
}

