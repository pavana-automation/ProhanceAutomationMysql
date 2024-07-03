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
public class UserRolesModifyManagerEditCustomReports extends BaseTest{

	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: USerRole verifying whether Activity Rating")
	public void userRolesModifyManagerEditCustomReports(String browser) throws InterruptedException
	{
	
		
		launchapp(browser);
		
		//WebDriver driver;
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
		AOSPage aos = new AOSPage(BaseTest.driver);
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
		
		
		userRole.selectCustomReports();
		
		driver.findElement(By.xpath("//input[contains(@VALUE,'GO')]")).click();
		
		//userRole.enableEditActivityRatingChkBox();
		
		if(driver.findElement(By.xpath("//input[@id='allowToCustomizeCustomReport']")).isSelected())
		{
				driver.findElement(By.xpath("//*[@id='tab_table']/tbody/tr[1]/td/span[2]")).click();
		}
		else {
			driver.findElement(By.xpath("//input[@id='allowToCustomizeCustomReport']")).click();
			driver.findElement(By.xpath("//*[@id='tab_table']/tbody/tr[1]/td/span[2]")).click();
			}
		
		driver.findElement(By.xpath("//*[@id=\"tab_table\"]/tbody/tr[2]/td/span[2]")).click();
		
		userRole.selectCustomReports();
		
		driver.findElement(By.xpath("//input[contains(@VALUE,'GO')]")).click();
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='allowToCustomizeCustomReport']")).isSelected());
	}

}
