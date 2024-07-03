
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
public class UserDomainModify extends BaseTest
{

	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("User Domain verification In modify function")
	public void modifyFunction(String browser) throws InterruptedException
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
		Thread.sleep(2000);
		

		String name = driver.findElement(By.xpath("//td[@class=\"sorting_1\"]")).getText();
		System.out.println("first data is :"+name);
		
		userdomain.clickModifyBtn();
		String result = randomStringGenerator.randomStringGenerator();
		System.out.println("modified data is"+result);
		userdomain.inputDomainName(result);
		userdomain.clickSaveBtn();

		ArrayList<String> expectedList = userdomain.getElementsInRowToList();
		Assert.assertTrue(expectedList.contains(result));
		
	}

}

