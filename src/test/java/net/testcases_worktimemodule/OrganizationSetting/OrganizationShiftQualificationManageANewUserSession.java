package net.testcases_worktimemodule.OrganizationSetting;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.OrganizationSettingAdminPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class OrganizationShiftQualificationManageANewUserSession extends BaseTest {

	// @Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Test
	@Description("Verify whether week day Start is set and saved")
	@Parameters("browser")
	public void organizationShiftQualificationManageANewUserSession(String browser) throws InterruptedException {
		launchapp(browser);
		loginPage loginPage = new loginPage(BaseTest.driver);
		OrganizationSettingAdminPage orgPage = new OrganizationSettingAdminPage(BaseTest.driver);

		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		driver.switchTo().frame("contentFrame");
		// orgPage.clickOnWorkLoadCategory();

		driver.findElement(By.id("thirdTab")).click();

		driver.findElement(By.id("shiftLogoutInterval")).clear();
		
		WebElement locator = driver.findElement(By.id("shiftLogoutInterval"));
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].value = arguments[1];", locator, "90");

		
		 //driver.findElement(By.id("shiftLogoutInterval")).sendKeys("90");
		
		//document.getElementById("shiftLogoutInterval").value = '90';
		  
		 orgPage.clickOnSaveBtn();
		 
		 Thread.sleep(2000);

		 String exp = driver.findElement(By.id("shiftLogoutInterval")).getAttribute("value");
		 
		 System.out.println("the exp is :" +exp);
			 
		 Thread.sleep(2000);
		 driver.findElement(By.id("shiftLogoutInterval")).clear();
		 
		 WebElement locator1 = driver.findElement(By.id("shiftLogoutInterval"));
			  
		 JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
		 jsExecutor1.executeScript("arguments[0].value = arguments[1];", locator1, "180");
			 
		 orgPage.clickOnSaveBtn();
			  
		 Thread.sleep(2000);
			  
			  
		 String act = driver.findElement(By.id("shiftLogoutInterval")).getAttribute("value");
			  
		 Assert.assertNotEquals(act, exp);
	}

}
