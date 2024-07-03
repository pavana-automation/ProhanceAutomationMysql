package net.testcases_worktimemodule.AOS;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.AOSPage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.UserDomainPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class AOSBulkUpload extends BaseTest {

	@Parameters("browser")
	// @Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: In This test case we are downloading the excel and validating few data ")
	@Test
	public void aosBulkUpload(String browser) throws InterruptedException, IOException {

		launchapp(browser);

		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
		// RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
		AOSPage aos = new AOSPage(BaseTest.driver);

		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);

		// listeners.testStepDescription("Step 2: Click on Side Navigation Page");
		sidenavPage.clickSideNavigationBtn();

		// listeners.testStepDescription("Step 3: Click on Activities");
		sidenavPage.clickActivitiesBtn();

		// listeners.testStepDescription("Step 4: Click on AOS");
		sidenavPage.clickAOSBtn();

		driver.switchTo().frame("contentFrame");

		Thread.sleep(1000);
		// listeners.testStepDescription("Step 5: Click on More Action");
		aos.clickMoreActionBtn();

		System.out.println("third checkpoint");
		// listeners.testStepDescription("Step 6: Click on Bulk Upload");

		driver.findElement(By.xpath("//a[contains(text(),'BULK UPLOAD')]")).click();

		driver.findElement(By.xpath("//label[contains(text(),'With Prefilled Data')]")).click();

		testStepDescription("Step 6: Click on Click Here to download BlankTemplate");
		aos.clickOnClickHereBtn();

		String result = aos.addActivityTagExcelBulckUpload();

		System.out.println("the result is :" + result);

		
		/*
		 * aos.addActivityTagExcelBulckUploadAOSSignature();
		 * 
		 * aos.addActivityTagExcelBulckUploadWorkProfile();
		 * 
		 * aos.clickChooseFileInBulkUpload();
		 * 
		 * aos.clickBackBtnAosPage(); Thread.sleep(2000); aos.clickSearchBtn(result);
		 * Thread.sleep(5000); String actual = driver.findElement(By.xpath(
		 * "//table[@id=\"CommonDataTableId\"]/tbody/tr/td[2]")).getText(); //
		 * Assert.assertEquals(result,actual);
		 */
		 
	}
}
