
package net.testcases_worktimemodule.validate_user_roles_administrationmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class UserRolesAddNewMemberDelete extends BaseTest {
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: In This test case we are verifying the user role member delete functionality ")
	public void userRolesAddNewMemberDelete(String browser) throws InterruptedException {

		launchapp(browser);
		
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
		UserRolePage userRole = new UserRolePage(BaseTest.driver);
		String txt1;

		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
        Thread.sleep(2000);
		sidenavPage.clickSideNavigationBtn();
		sidenavPage.ClickOnUserRoleBtn();
		driver.switchTo().frame("contentFrame");
		  userRole.clickAddNewBtn();
		  
		  userRole.selectMemberRadioBtn();
		  String result = randomStringGenerator.randomStringGenerator();
		  userRole.inputRoleNameTxtBox("AutomationTesting"+result);
		  userRole.inputRoleDescrptionTxtBOx("Description1 to be written in description TExtBox for automation testing" );
		  
		  userRole.clickOnSaveBtn();
		  
		  String txt = driver.findElement(By.id("dialogsuccessspan")).getText();
		  
		  System.out.println("success msg is :" +txt);
		  
		  String expected = "AutomationTesting"+result; 
		  String Final = "User Role: "+expected+" added successfully";
		  
		  Assert.assertTrue(txt.contains(Final));
		  
		  driver.findElement(By.xpath("//label[contains(text(),'BACK')]")).click();
		  
		  Thread.sleep(4000);
		  
		  int tablecount = driver.findElements(By.xpath("//table[@id=\"CommonDataTableId\"]/tbody/tr")).size(); 
		  System.out.println("table count is :" +tablecount);
		  
		  Thread.sleep(3000);
		  
			for(int i=1;i<=tablecount;i++)
			{
				String actual = driver.findElement(By.xpath("//table[@id='CommonDataTableId']/tbody/tr["+i+"]/td[3]")).getText();
				System.out.println("the actual is :" +actual);
				System.out.println("The expected is :" +expected);
				boolean check = actual.equals(expected);
				System.out.println(check);
				if(check == false)
				{
					i++;
					System.out.println("helloworld");
				}
				else 
				{			
				System.out.println("hello");
				WebElement delete = driver.findElement(By.xpath("//table[@id='CommonDataTableId']/tbody/tr["+i+"]/td[2]/a[2]"));
				delete.click();
				driver.findElement(By.xpath("//button[contains(text(),'YES')]")).click();
				Thread.sleep(1000);
				txt1 = driver.findElement(By.id("dialogsuccessspan")).getText();
				System.out.println("the text is" +txt1);
				Thread.sleep(2000);
				System.out.println("hello");
				String Final1 = expected+" deleted successfully";
				System.out.println("the epected output is:" +Final1);
				Thread.sleep(2000);
				Assert.assertFalse(txt1.contains(Final1));
				break;
		  }
		  }
		 
	}

}
