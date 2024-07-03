
package net.testcases_worktimemodule.validate_userdomain_administrationmenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class UserDomainExcelValidation extends BaseTest{
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: User Domain Excel Validation")
	public void excelValidation(String browser) throws InterruptedException, IOException {
		
		launchapp(browser);
		
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuPage sidenavPage = new SideNavigationMenuPage(BaseTest.driver);
		UserDomainPage userdomain = new UserDomainPage(BaseTest.driver);
		ReadXLSdata ReadXLSdata = new ReadXLSdata(BaseTest.driver);
		loginPage.clickLogin(GenderalVariables.JTSaleAdminUserName, GenderalVariables.JTSaleAdminPassword);
		
		sidenavPage.clickSideNavigationBtn();
		
		sidenavPage.clickUserDomainBtn();
		driver.switchTo().frame("contentFrame");
		
		ArrayList<String> expectedList = userdomain.getElementsInRowToList();
		//Thread.sleep(2000);
		
		userdomain.clickExportToExcelBtn();
		
		
		List<String> actualExcelValue = ReadXLSdata.getData();
	    for(int i=0;i<expectedList.size();i++)
	    {
	    	String data = expectedList.get(i);
	    	Assert.assertTrue(actualExcelValue.contains(data));
	    }
	    
	}

}

