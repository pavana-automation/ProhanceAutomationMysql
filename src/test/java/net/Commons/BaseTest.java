
package net.Commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import net.pages_worktimemodule.SideNavigationMenuPage;
import net.pages_worktimemodule.UserDomainPage;
import net.pages_worktimemodule.loginPage;
import org.testng.annotations.Test;

public class BaseTest {

	public static WebDriver driver;

	public loginPage loginPage;

	public SideNavigationMenuPage sidenavPage;

	public UserDomainPage userdomain;

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver initializeDriverMssql() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.10.10.128:6969/prohance/");
		return driver;
	}

	public WebDriver initializeDriverMysql(){
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
		// driver = new ChromeDriver();
		// options.addArguments("download.default_directory=/path/to/download/directory");
		// options.addArguments("download.prompt_for_download=false");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.10.10.126:6262/prohance");
		return driver;
	}
	
	@Step("login to application")
	public void launchapp(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("calling driver" + driver);
			System.out.println("chrome is opened");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://10.10.10.126:6262/prohance");
			tdriver.set(driver);
			
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("calling driver" + driver);
			System.out.println("calling edge to launch");
			// System.setProperty("webdriver.edge.driver",
			// "D:\\edgedriver_win64\\msedgedriver.exe");
			// WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://10.10.10.126:6262/prohance");
			tdriver.set(driver);
			System.out.println();

		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	@AfterMethod

	public void tearDown(ITestResult result) {

		driver.quit();
		/*
		 * if (driver != null) { driver.quit(); } // Check if test failed and capture
		 * screenshot if it did if (result.getStatus() == ITestResult.FAILURE) {
		 * TakesScreenshot ts = (TakesScreenshot) driver; byte[] screenshot =
		 * ts.getScreenshotAs(OutputType.BYTES);
		 * Allure.addAttachment("Screenshot on failure", new
		 * ByteArrayInputStream(screenshot)); }
		 */
	}

	/*
	 * public String getScreenshotPath(String TestCaseName, WebDriver driver) throws
	 * IOException { TakesScreenshot ts=(TakesScreenshot)driver;
	 * System.out.println("It entered this part of code"); File
	 * source=ts.getScreenshotAs(OutputType.FILE); String destpath =
	 * System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png"; File file =
	 * new File(destpath); FileUtils.copyFile(source, file); return destpath;
	 * 
	 * }
	 */

	/*
	 * public List<HashMap<String,String>> getJsonDataToMap(String filepath) throws
	 * IOException { //reading json to string String jsonContent =
	 * FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
	 * 
	 * //String to Hashmap ObjectMapper mapper = new ObjectMapper();
	 * List<HashMap<String, String>> data=mapper.readValue(jsonContent, new
	 * TypeReference<List<HashMap<String, String>>>() { }); return data;
	 * 
	 * }
	 */

	public void onTestStart(ITestResult result, String Message) {
		// TODO Auto-generated method stub

	}

	public void testStepDescription(String Message) {
		// TODO Auto-generated method stub

	}

}
