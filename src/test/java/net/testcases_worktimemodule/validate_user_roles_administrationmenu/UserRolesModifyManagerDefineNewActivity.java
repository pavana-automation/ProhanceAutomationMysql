package net.testcases_worktimemodule.validate_user_roles_administrationmenu;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
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
import net.pages_worktimemodule.UserRolePage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class UserRolesModifyManagerDefineNewActivity extends BaseTest{
	

	
	@Parameters("browser")
	@Test
	@Description("Test Description: Here we are verifying whether we are able to define new activity ")
	public void userRolesModifyManagerDefineNewActivity(String browser) throws InterruptedException
	{
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
		UserRolePage userRole = new UserRolePage(BaseTest.driver);

		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		
		Thread.sleep(2000);
		sidenavPage.clickSideNavigationBtn();
		sidenavPage.ClickOnUserRoleBtn();
		
		driver.switchTo().frame("contentFrame");
		
		userRole.clickSearchTxtBox("pavManagerTesting");

		userRole.clickModifyBtn();
		
		//userRole.checkallowEmailExportChkBoxIsEnabled();
		
		userRole.clickUserRolePrmissionBtn();
		
		userRole.selectModuleIdDrpDwn();
		
		driver.findElement(By.xpath("//input[contains(@VALUE,'GO')]")).click();
		
		userRole.enableEditActivityRatingChkBox();
		
		userRole.clickOnSaveBtn();
		
		/*
		 * driver=initializeDriverMysql();
		 * 
		 * loginPage.clickLogin(GenderalVariables.JTSaleManagerUserName,
		 * GenderalVariables.JTSaleManagerPassword);
		 * 
		 * driver.findElement(By.id("drilldown-container_4")).click();
		 * 
		 * Set<String> handles=driver.getWindowHandles(); Iterator
		 * it=handles.iterator(); String parentwindow=(String) it.next();
		 * System.out.print("parent id"+parentwindow); String childwindow=(String)
		 * it.next(); System.out.print("child id"+childwindow);
		 * driver.switchTo().window(childwindow); driver.manage().window().maximize();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * boolean expected =
		 * driver.findElement(By.xpath("//b[contains(text(),'EDIT RATING')]")).
		 * isDisplayed();
		 */
		
		/*
		 * Assert.assertEquals(true, expected);
		 * 
		 * driver.findElement(By.xpath("//span[contains(text(),'Unknown AOS')]")).click(
		 * );
		 */
		
		
		//boolean expected1 = driver.findElement(By.xpath("//input[@title='Add Selected Applications']")).isDisplayed();
		
		//Assert.assertEquals(true, expected);
		//driver.close();
	}

}
