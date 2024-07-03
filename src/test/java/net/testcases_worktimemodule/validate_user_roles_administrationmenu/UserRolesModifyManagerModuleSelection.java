package net.testcases_worktimemodule.validate_user_roles_administrationmenu;

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
public class UserRolesModifyManagerModuleSelection extends BaseTest{
	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: Here we are verifying whether we are able select module ")
	public void userRolesModifyManagerModuleSelection(String browser) throws InterruptedException
	{
		//driver = initializeDriverMysql();
		launchapp(browser);
		
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
		
		userRole.selectModule();
		
		Thread.sleep(1000);
		
		userRole.clickOnSaveBtn();
		driver.findElement(By.xpath("//label[contains(text(),'BACK')]")).click();
		
		
		
		driver=initializeDriverMysql();

		loginPage.clickLogin(GenderalVariables.JTSaleManagerUserName, GenderalVariables.JTSaleManagerPassword);
		
		userRole.selectWorkTimeModule();
		
		int size = driver.findElements(By.xpath("//ul[@id=\"workTimeFontSize\"]/table/tbody/tr/td")).size();
		
		Assert.assertEquals(3, size);
		
		driver.close();	
	}
}
