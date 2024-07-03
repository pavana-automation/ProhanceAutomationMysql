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
public class OrganizationEnableNotificationBubblePopUp extends BaseTest
{

	//@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Test
	@Description("Verify whether week day Start is set and saved")
	@Parameters("browser")
	public void organizationEnableNotificationBubblePopUp(String browser) throws InterruptedException
	{
		launchapp(browser);
		loginPage							loginPage							= new loginPage(BaseTest.driver);
		OrganizationSettingAdminPage 		orgPage								= new OrganizationSettingAdminPage(BaseTest.driver);

		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		driver.switchTo().frame("contentFrame");
		//orgPage.clickOnWorkLoadCategory();
		
		if(driver.findElement(By.xpath("//input[@id='liveStreamingEnableNotifications']")).isSelected())
		{
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//input[@id='liveStreamingEnableNotifications']")).click();
			Select opt1 = new Select(driver.findElement(By.id("liveStreamingNotificationFrequency")));
			opt1.selectByValue("120");
		}
		else
		{
			
			String act = driver.findElement(By.xpath("//select[@id='liveStreamingNotificationFrequency']")).getAttribute("disabled");
			System.out.println("the text is :" +act);
			//Assert.assertEquals(act, "true");
			Thread.sleep(3000);
			WebElement locator = driver.findElement(By.xpath("//input[@name='liveStreamingEnableNotifications']"));
			
			JavascriptExecutor jsexecutour = (JavascriptExecutor) driver;

			//jsexecutour.executeScript("arguments[0].scrollIntoView(true);", locator);
			jsexecutour.executeScript("arguments[0].click();", locator);
			
			Select opt1 = new Select(driver.findElement(By.id("liveStreamingNotificationFrequency")));
			opt1.selectByValue("120");
		}
		
		orgPage.clickOnSaveBtn();
		
		Thread.sleep(2000);
		
		String act = driver.findElement(By.id("liveStreamingNotificationFrequency")).getAttribute("value");
		
		Assert.assertEquals(act, "120");
		

	}

}
