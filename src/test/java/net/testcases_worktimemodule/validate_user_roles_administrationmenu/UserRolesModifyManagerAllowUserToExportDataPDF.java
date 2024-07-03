package net.testcases_worktimemodule.validate_user_roles_administrationmenu;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
public class UserRolesModifyManagerAllowUserToExportDataPDF extends BaseTest{
	
	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: Here we are verifying the permission to allow User to export data pdf ")
	//@Test
	public void userRolesModifyManagerAllowUserToExportDataPDF(String browser) throws InterruptedException
	{
		//driver = initializeDriverMysql();
		launchapp(browser);
		
		//WebDriver driver;
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
		
		//userRole.checkallowEmailExportChkBoxIsEnabled();
		
		if(driver.findElement(By.id("allowPdfExport")).isSelected())
		{
			System.out.println("checkbox is already selected");
		}
		else
		{
			driver.findElement(By.id("allowPdfExport")).click();
		}
		
		userRole.clickOnSaveBtn();
		
		driver=initializeDriverMysql();

		loginPage.clickLogin(GenderalVariables.JTSaleManagerUserName, GenderalVariables.JTSaleManagerPassword);
		
		/*driver.findElement(By.xpath("//td[text()='Custom']")).click();
		WebElement year = driver.findElement(By.id("selectedMonthYear"));
		
		Select comboBox = new Select(year);
		 comboBox.selectByValue("2023");
		 
		WebElement month =  driver.findElement(By.id("selectedMonth"));
		
		Select comboBox1 = new Select(year);
		 comboBox1.selectByValue("05/01/2023:05/31/2023");*/
		
		
		userRole.clickOnDrillDownBtn();
		
		Set<String> handles=driver.getWindowHandles();
		Iterator it=handles.iterator();
		String parentwindow=(String) it.next();
		System.out.print("parent id"+parentwindow);
		String childwindow=(String) it.next();
		System.out.print("child id"+childwindow);
		driver.switchTo().window(childwindow);
		driver.manage().window().maximize();
		
		Thread.sleep(8000);
		userRole.exportPDFBtnToBeDisabled();
		//driver.findElement(By.xpath("//img[@title='Export to Excel']")).click();
		System.out.println("file got downloaded");
		
		driver.close();
		
	}
	

}
