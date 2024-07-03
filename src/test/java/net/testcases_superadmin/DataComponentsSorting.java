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
import net.Commons.TestAllureListener;
import net.pages_superadmin.DataComponentsPage;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;
@Listeners({ TestAllureListener.class })
public class DataComponentsSorting extends BaseTest{
	

	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: data components download validation ")
	public void dataComponentsSorting( String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage              loginPage            =   new loginPage(BaseTest.driver);
		SideNavigationMenuBar  nav                  =   new SideNavigationMenuBar(BaseTest.driver);
		DataComponentsPage     data                 =   new DataComponentsPage(BaseTest.driver);

		List<String> nameList = null;
		List<String> nameSortedList = null;
		loginPage.clickLogin("superadmin", "superadmin@1");
		
		nav.clickSideNavigationArrowBtn();
		
		nav.clickDataComponents();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(10000);
		nameList = data.getNameLists();
		data.clickNameSort();
		nameSortedList = data.getNameSortedLists();
		for (int i = 0; i < nameList.size(); i++) {
			String data1 = nameList.get(i);
			
			boolean check =nameSortedList.contains(data1);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
		nameList = data.getComponentTypeLists();
		data.clickComponentTypeSort();
		nameSortedList = data.getComponentTypeSortedLists();
		for (int i = 0; i < nameList.size(); i++) {
			String data2 = nameList.get(i);
			
			boolean check =nameSortedList.contains(data2);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
		nameList = data.getlastHeartBeatLists();
		data.clickLastHeartBeatSort();
		nameSortedList = data.getlastHeartBeatSortedLists();
		for (int i = 0; i < nameList.size(); i++) {
			String data3 = nameList.get(i);
			
			boolean check =nameSortedList.contains(data3);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
		
		nameList = data.getlastHeartBeatLists();
		data.clickLastHeartBeatSort();
		nameSortedList = data.getlastHeartBeatSortedLists();
		for (int i = 0; i < nameList.size(); i++) {
			String data4 = nameList.get(i);
			
			boolean check =nameSortedList.contains(data4);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
		
		nameList = data.gethostNameLists();
		data.clickHostNameSorted();
		nameSortedList = data.getHostNameSortedLists();
		for (int i = 0; i < nameList.size(); i++) {
			String data5 = nameList.get(i);
			
			boolean check =nameSortedList.contains(data5);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
		
		nameList = data.getPortList();
		data.clickPortSorted();
		nameSortedList = data.getPortSortedLists();
		for (int i = 0; i < nameList.size(); i++) {
			String data6 = nameList.get(i);
			
			boolean check =nameSortedList.contains(data6);
			System.out.println(check);
			Assert.assertTrue(check); 
		}
	}
}