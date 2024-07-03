package net.testcases_worktimemodule.validate_user_roles_administrationmenu;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.UserDomainPage;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;


@Listeners({ TestAllureListener.class })
public class UserRolePDFValidation extends BaseTest{
	
	
	
	
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Parameters("browser")
	@Description("Test Description: In This test case we are downloading the excel and validating few data ")
	public void userRolePDFValidation(String browser) throws IOException, InterruptedException { 
	
	launchapp(browser);
	
	loginPage loginPage = new loginPage(BaseTest.driver);
	SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
	UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
	ReadXLSdata ReadXLSdata = new ReadXLSdata(BaseTest.driver);
	
	loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
	Thread.sleep(2000);
	
	sidenavPage.clickSideNavigationBtn();
	sidenavPage.ClickOnUserRoleBtn();
	driver.switchTo().frame("contentFrame");

	ArrayList<String> expectedList = userdomain.getElementsInRowToList1();
	

	userdomain.clickExportToPdfBtn();

	String actualExcelValue = ReadXLSdata.getPDFData();
    
    for(int i=0;i<expectedList.size();i++)
    {
    	String data = expectedList.get(i);
    	System.out.println("the value is :" +data);
    	Assert.assertTrue(actualExcelValue.contains(data));
    }
    
	}
	

}