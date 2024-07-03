package net.testcases_superadmin;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import net.Commons.BaseTest;
import net.Commons.GenderalVariables;
import net.Commons.TestAllureListener;
import net.pages_superadmin.CustomAdapter;
import net.pages_superadmin.SideNavigationMenuBar;
import net.pages_worktimemodule.loginPage;
import net.testcases_worktimemodule.utilities.ReadXLSdata;
@Listeners({ TestAllureListener.class })
public class CustomAdapterPDFValidation extends BaseTest{

	
	@Parameters("browser")
	@Test(retryAnalyzer = net.Commons.RetryAnalyzer.class)
	@Description("Test Description: Custom Adapter PDF export validation")
	public void customAdapterPDFValidation(String browser) throws InterruptedException, EncryptedDocumentException, IOException {
		launchapp(browser); 
		loginPage               loginPage          =   new 	loginPage(BaseTest.driver);
		SideNavigationMenuBar   nav                =   new 	SideNavigationMenuBar(BaseTest.driver);
		CustomAdapter           adapter            =   new 	CustomAdapter(BaseTest.driver);
		ReadXLSdata             excel              =   new 	ReadXLSdata(BaseTest.driver);
		List<String>            customList         =   null;
		List<String>            customExcelList    =   null;
        
		
		
		loginPage.clickLogin(GenderalVariables.superadminUserName, GenderalVariables.superadminPassword);
		
		nav.clickSideNavigationArrowBtn();
		
		nav.clickCustomAdapter();
		driver.switchTo().frame("contentFrame");
		Thread.sleep(1000);
		
		customList= adapter.getCustomLists();
		
		adapter.clickPdf();
		
		String actualPdfList = excel.getCustomPDF();
		
		for(int i=0;i<customList.size();i++)
	    {
	    	String data = customList.get(i);
	    	System.out.println("the value is :" +data);
	    	boolean check = actualPdfList.contains(data);
	    	System.out.println(check);
	    	Assert.assertTrue(check);
	    }
	}
}