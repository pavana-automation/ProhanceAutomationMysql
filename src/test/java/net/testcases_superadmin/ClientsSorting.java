package net.testcases_superadmin;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
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
public class ClientsSorting extends BaseTest {

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description:Clients sorting validation")
	public void clientsSorting(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser);
		loginPage loginPage = new loginPage(BaseTest.driver);
		SideNavigationMenuBar nav = new SideNavigationMenuBar(BaseTest.driver);
		ClientPage clients = new ClientPage(BaseTest.driver);
		List<String> afterSorting = null;
		List<String> beforeSorting = null;

		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		nav.clickSideNavigationArrowBtn();

		nav.clickClients();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		clients.selectRecordToDisplay("1,000");
		beforeSorting = clients.afterOrganizationSorting();
		Thread.sleep(1000);
		clients.clickOrganizationSorting();
		afterSorting = clients.organizationSorting();

		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);

			boolean check = afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check);
		}

		// code sorting

		beforeSorting = clients.afterCodeSorting();
		Thread.sleep(1000);
		clients.clickCodeSorting();
		afterSorting = clients.codeoSorting();

		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);

			boolean check = afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check);
		}

		// Total clients sort
		beforeSorting = clients.afterTotalClientsSorting();
		Thread.sleep(1000);
		clients.clickTotalClientsSorting();
		afterSorting = clients.totalClientsSort();

		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);

			boolean check = afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check);
		}

		// Total clients sort
		beforeSorting = clients.afterClientsAliveSorting();
		Thread.sleep(1000);
		clients.clickClientsAliveSorting();
		afterSorting = clients.clientsAliveSort();

		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);

			boolean check = afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check);
		}
		// clients active
		beforeSorting = clients.afterClientsActiveSorting();
		Thread.sleep(1000);
		clients.clickClientsActiveSorting();
		afterSorting = clients.clientsActiveSort();

		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);

			boolean check = afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check);
		}

		// users connected

		beforeSorting = clients.afterUsersConnectedSorting();
		Thread.sleep(1000);
		clients.clickUsersConnectedSorting();
		afterSorting = clients.usersConnectedSort();
		for (int i = 0; i < beforeSorting.size(); i++) {
			String data = beforeSorting.get(i);

			boolean check = afterSorting.contains(data);
			System.out.println(check);
			Assert.assertTrue(check);
		}

	}

}
