package net.testcases_superadmin;

import java.util.ArrayList;
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
public class ClientExcelExport extends BaseTest{
	
	
	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Client excel export validation")
	public void clientExcelExport(String browser) throws Exception {
		launchapp(browser); 
		loginPage             loginPage           = new    loginPage(BaseTest.driver);
		SideNavigationMenuBar nav                 = new    SideNavigationMenuBar(BaseTest.driver);
		ClientPage            clients             = new    ClientPage(BaseTest.driver);
		ReadXLSdata           excel               = new    ReadXLSdata(BaseTest.driver);
		List<String>          clientNameList      = new    ArrayList<String>();
		List<String>          clienNameExcelList  = new    ArrayList<String>(); 
		System.out.println(GenderalVariables .superadminUserName);

		loginPage.clickLogin( GenderalVariables .superadminUserName,  GenderalVariables .superadminPassword);
		Thread.sleep(1000);
		nav.clickSideNavigationArrowBtn();
		
		nav.clickClients();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		
		clientNameList = clients.getClintsList();
		
		clients.clickExcelImg();
		
		clienNameExcelList = excel.getClientsExcelList();
		
		for (int i = 0; i < clientNameList.size(); i++) {
			String data = clientNameList.get(i);
			
			boolean check =clienNameExcelList.contains(data);
			System.out.println(check);
			//Assert.assertTrue(check); 
		}
		
	}
	}
