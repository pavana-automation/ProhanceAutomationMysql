package net.testcases_superadmin;

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
@Listeners({ TestAllureListener.class })
public class ClientsAllocatedRequiredField extends BaseTest{
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Client required field validation")
	public void clientsAllocatedRequiredField(String browser) throws Exception {
		
		
		launchapp(browser); 
		loginPage             loginPage           = new loginPage(BaseTest.driver);
		SideNavigationMenuBar nav 				  = new SideNavigationMenuBar(BaseTest.driver);
		ClientPage            clients 			  = new ClientPage(BaseTest.driver);
		 
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
	
		nav.clickSideNavigationArrowBtn();
		
		nav.clickClients();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);

		clients.selectClient("Show unallocated Clients");
		clients.clickSelectClient();
		//clients.selectAllocatedToOrg("PH Sales");
		
		clients.clickGOBtn();
		Thread.sleep(1000);
		
		clients.clickMissingOrgFieldMsg();
	}
}