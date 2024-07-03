
package net.testcases_worktimemodule.validate_user_roles_administrationmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
public class UserRolesBulkUpdate extends BaseTest{
	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: Here we are verifying the bulk update done in user role ")
	public void userRolesBulkUpdate(String browser) throws InterruptedException
	{
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
		userRole.clickAddNewBtn();
		userRole.selectManagerRadioBtn();
		String result = randomStringGenerator.randomStringGenerator();
		userRole.inputRoleNameTxtBox("AutomationTesting"+result);
		userRole.inputRoleDescrptionTxtBOx("Description1 to be written in description TExtBox for automation testing");
		userRole.clickOnSaveBtn();
		//userRole.clickOnSaveBtn();
		String txt = driver.findElement(By.id("dialogsuccessspan")).getText();
		System.out.println("success msg is :" +txt);
		String expected = "AutomationTesting"+result;
		String Final ="User Role: "+expected+" added successfully";
		Assert.assertTrue(txt.contains(Final));
		driver.findElement(By.xpath("//label[contains(text(),'BACK')]")).click();
		Thread.sleep(2000);
		userRole.clickSearchTxtBox(result);
		Thread.sleep(2000);
		userRole.clickSelectedUserChkBox();
		Thread.sleep(2000);
		//driver.switchTo().frame("contentFrame");
		String hirarchyExisted = userRole.getTextHierarchy();
		System.out.print(hirarchyExisted);
		
		userRole.setHierarchyLevelChange();
		Thread.sleep(2000);
		userRole.clickBilkUpdateBtn();
		userRole.clickSelectedUserChkBox();
		userRole.clickSearchTxtBox(result);
		String hirarchyupdated = userRole.getTextHierarchy();
		Assert.assertNotEquals(hirarchyExisted, hirarchyupdated);
		
	}
}