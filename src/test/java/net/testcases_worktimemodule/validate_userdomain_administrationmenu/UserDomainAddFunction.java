
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
public class UserDomainAddFunction extends BaseTest{
	
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: User Domain add new function")
	public void addNewFunction(String browser) throws InterruptedException
	{
		
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
		RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
		
		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		sidenavPage.clickSideNavigationBtn();
		
		sidenavPage.clickUserDomainBtn();
		driver.switchTo().frame("contentFrame");
		
		userdomain.clickaddNewBtn();
		String result = randomStringGenerator.randomStringGenerator();
		
		userdomain.inputDomainName(result);
		userdomain.inputDomainDescriptionTxtBx(result);
		userdomain.inputHostName("103.211.81.27");
		userdomain.inputDomainTxtBx("${Login_Id}@test.com");
		userdomain.selectSSLChkBx();
		userdomain.selectEnableSyncData();
		userdomain.inputUserName("pavana_admin");
		userdomain.inputPassword("1");
		userdomain.inputConnString("testing");
		userdomain.clickTestConnectionBtn();
		userdomain.clickSaveBtn();
		

		String name = driver.findElement(By.xpath("//td[@class=\"sorting_1\"]")).getText();
		ArrayList<String> expectedList = userdomain.getElementsInRowToList();
		Assert.assertTrue(expectedList.contains(name));
		//Assert.assertFalse(true);
	
	}
	
}

