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
public class UserRolesModifyManagerEditUserWidget extends BaseTest{

	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: USerRole verifying whether Activity Rating")
	public void userRolesModifyManagerEditUserWidget(String browser) throws InterruptedException
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
		
		userRole.clickUserRolePrmissionBtn();
		
		userRole.selectModuleIdDrpDwn();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[contains(@VALUE,'GO')]")).click();
		
		driver.findElement(By.xpath("//span[text()='User Widgets']")).click();
		
		//userRole.clickOnSaveBtn();
		
		if(driver.findElement(By.id("chk_level_R_12")).isSelected())
		{
			driver.findElement(By.id("chk_level_R_21")).isSelected();
			driver.findElement(By.id("chk_level_R_27")).isSelected();
			driver.findElement(By.id("chk_level_R_28")).isSelected();
			userRole.clickOnSaveBtn();
		}
		else
		{
			driver.findElement(By.id("chk_level_R_12")).click();
			driver.findElement(By.id("chk_level_R_21")).isSelected();
			driver.findElement(By.id("chk_level_R_27")).isSelected();
			driver.findElement(By.id("chk_level_R_28")).isSelected();
			userRole.clickOnSaveBtn();
			
		}

	}

}
