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
public class UserRolesModifyManagerExportDataPermissionNotAllowUserToDemandOnMail extends BaseTest{
	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: Here we are verifying whether we are not able to send mail ")
	public void userRolesModifyManagerExportDataPermissionNotAllowUserToDemandOnMail(String browser) throws InterruptedException
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
		
		userRole.checkallowEmailExportChkBoxIsEnabled();
		
		userRole.checkOnDemandMailIsEnabled();
		
		userRole.clickOnSaveBtn();
		
		driver=initializeDriverMysql();

		loginPage.clickLogin(GenderalVariables.JTSaleManagerUserName, GenderalVariables.JTSaleManagerPassword);
		Set<String> url = driver.getWindowHandles();
		System.out.println("the  url is :"+url);
		
		
		userRole.clickOnDrillDownBtn();
		
		Set<String> handles=driver.getWindowHandles();
		Iterator it=handles.iterator();
		String parentwindow=(String) it.next();
		System.out.print("parent id"+parentwindow);
		String childwindow=(String) it.next();
		System.out.print("child id"+childwindow);
		driver.switchTo().window(childwindow);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("emailSpan")).click();
		
		Assert.assertFalse(driver.findElement(By.id("ondemand")).isSelected());
		
		driver.close();


	}

}
