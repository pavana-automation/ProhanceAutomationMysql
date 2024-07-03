package net.testcases_worktimemodule.validate_user_roles_administrationmenu;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.UserRolePage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class UserRolesModifyMemberModuleSelection extends BaseTest{
	

	
	
	//@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: Here we are verifying whether we are able to do module selection")
	@Test(priority = 1)
	public void userRolesModifyMemberModuleSelection(String browser) throws InterruptedException
	{
		//driver = initializeDriverMysql();
		
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		UserRolePage userRole = new UserRolePage(BaseTest.driver);

		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		Thread.sleep(2000);

		sidenavPage.clickSideNavigationBtn();
		sidenavPage.ClickOnUserRoleBtn();
		
		driver.switchTo().frame("contentFrame");
		
		userRole.clickSearchTxtBox("pavMemberTesting");

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
		
		

	}
}
