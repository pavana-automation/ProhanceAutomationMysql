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
import net.Commons.RandomStringGeneration;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.AOSPage;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.UserDomainPage;
import net.pages_worktimemodule.loginPage;

@Listeners({ TestAllureListener.class })
public class AOSBulkUploadModify extends BaseTest {

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: In This test case we are downloading the excel and validating few data ")
	public void aosBulkUploadModify(String browser) throws InterruptedException, IOException

	{

		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
		RandomStringGeneration randomStringGenerator = new RandomStringGeneration();
		AOSPage aos = new AOSPage(BaseTest.driver);
		
		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);

		//listeners.testStepDescription("Step 2: Click on Side Navigation Page");
		sidenavPage.clickSideNavigationBtn();

		//listeners.testStepDescription("Step 3: Click on Activities");
		sidenavPage.clickActivitiesBtn();

		//listeners.testStepDescription("Step 4: Click on AOS");
		sidenavPage.clickAOSBtn();
		driver.switchTo().frame("contentFrame");
		
		//Thread.sleep(3000);

		//listeners.testStepDescription("Step 5: Click on More Action");
		aos.clickMoreActionBtn();

		//listeners.testStepDescription("Step 6: Click on Bulk Upload");
		driver.findElement(By.xpath("//a[contains(text(),'BULK UPLOAD')]")).click();

		//listeners.testStepDescription("Step 7: Click Here to download Pree Filled Template");
		driver.findElement(By.xpath("//label[contains(text(),'With Prefilled Data')]")).click();

		//listeners.testStepDescription("Step 8: Click on 'click here' to download the excel");
		aos.clickOnClickHereBtn();

		//listeners.testStepDescription("Step 9: Modify the data in excel ans upload the file");
		Thread.sleep(2000);
		String result1 = aos.addActivityTagExcelBulkUploadWorkProfileModify();
		/*
		 * aos.clickChooseFileInBulkUpload(); aos.clickBackBtnAosPage();
		 * 
		 * //listeners.
		 * testStepDescription("Step 10: Check whether modified data is saved in the application"
		 * ); //Thread.sleep(5000); //ArrayList<String> ActualList1 =
		 * userdomain.getElementsInRowToList();
		 * //System.out.println("the actual list is******"+ActualList1);
		 * //Assert.assertTrue(ActualList1.contains(result1)); Thread.sleep(2000);
		 * 
		 * aos.clickSearchBtn(result1); Thread.sleep(3000); String actual =
		 * driver.findElement(By.xpath(
		 * "//table[@id=\"CommonDataTableId\"]/tbody/tr/td[2]")).getText();
		 * System.out.println("the value of result1 is :"+result1);
		 * System.out.println("the value of actual is :"+actual);
		 * 
		 * Assert.assertEquals(result1,actual);
		 */
	
	}
}