package net.testcases_worktimemodule.validate_user_roles_administrationmenu;

import java.util.Iterator;
import java.util.Set;

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
import net.pages_worktimemodule.UserRolePage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class UserRolesModifyManagerEditClientSetting extends BaseTest{

	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: USerRole verifying whether Activity Rating")
	public void userRolesModifyManagerEditClientSetting(String browser) throws InterruptedException
	{

		launchapp(browser);
		
		//WebDriver driver;
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		UserRolePage userRole = new UserRolePage(BaseTest.driver);

		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		Thread.sleep(2000);

		sidenavPage.clickSideNavigationBtn();
		sidenavPage.ClickOnUserRoleBtn();
		
		driver.switchTo().frame("contentFrame");
		
		userRole.clickSearchTxtBox("pavManagerTesting");

		userRole.clickModifyBtn();
		
		userRole.clickClientSettings();
		
		if(driver.findElement(By.id("donotdisturbEnable")).isSelected())
		{
			System.out.println("The DoNotDisturb CHKBOX is selected");
		}
		else
		{
			driver.findElement(By.id("donotdisturbEnable")).click();
		}
		
		if(driver.findElement(By.id("enablePersonalTime")).isSelected())
		{
			System.out.println("The Enable personal Time CHKBOX is selected");
		}
		else
		{
			driver.findElement(By.id("enablePersonalTime")).click();
		}
		
		if(driver.findElement(By.id("enableManualSuspend")).isSelected())
		{
			System.out.println("The Enable Manual suspend Time CHKBOX is selected");
		}
		else
		{
			driver.findElement(By.id("enableManualSuspend")).click();
		}
		
		if(driver.findElement(By.id("enableIdleTimeMandatory")).isSelected())
		{
			System.out.println(" Enable Idle Time suspend Time CHKBOX is selected");
		}
		else
		{
			driver.findElement(By.id("enableIdleTimeMandatory")).click();
		}
	}

}
