package net.testcases_superadmin;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_superadmin.ClientPage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;
@Listeners({ TestAllureListener.class })
public class ClientsUnkownClientsToKnown extends BaseTest{
	
	 

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Clients PDF export validation")

	public void clientExcelExport(String browser) throws Exception {
		
		launchapp(browser); 
		loginPage             loginPage           = new    loginPage(BaseTest.driver);
		SideNavigationMenuBar nav                 = new    SideNavigationMenuBar(BaseTest.driver);
		ClientPage            clients             = new    ClientPage(BaseTest.driver);
		ReadXLSdata           excel               = new    ReadXLSdata(BaseTest.driver);
		GenderalVariables     gv                  = new    GenderalVariables();
	
		
		loginPage.clickLogin(gv.superadminUserName, gv.superadminPassword);
	
		nav.clickSideNavigationArrowBtn();
		
		nav.clickClients();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		
		clients.selectClient("Show unallocated Clients");
		
		clients.clickSelectClient();
		
		clients.selectAllocatedToOrg("PH Sales");
	
		clients.clickGOBtn();
	}
}
