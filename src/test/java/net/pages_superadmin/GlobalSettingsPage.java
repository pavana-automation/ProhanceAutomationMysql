package net.pages_superadmin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class GlobalSettingsPage {
	WebDriver driver;
	
	
	@FindBy(xpath = "//span[contains(text(),\"Email Server\")]")
	WebElement EmailServerBtn;
	
	@FindBy(id = "protocol")
	WebElement protocol;
	
	@FindBy(id = "smtpServerHost")
	WebElement serverHost;
	
	@FindBy(xpath = "//td[contains(text(),\"SMTP Server Port\")]/../td[2]/div/input")
	WebElement serverPort;
	
	@FindBy(id = "encType")
	WebElement encType;
	
	@FindBy(id = "enableAuthentication_1")
	WebElement authenticationChkBox;
	
	@FindBy(xpath = "//tr[@id=\"smtpUserNameTr\"]/td[2]/div/input")
	WebElement userName;
	
	@FindBy(xpath = "//tr[@id=\"smtpPasswordTr\"]/td[2]/div/input")
	WebElement password;
	
	@FindBy(id = "fromAddress")
	WebElement fromAddress;
	
	@FindBy(xpath = "//input[@value=\"TEST E-MAIL SETTINGS\"]")
	WebElement testEmail;
	
	@FindBy(id = "submitButton")
	WebElement saveButton;
	
	@FindBy(xpath = "//span[contains(text(),\"Global Settings has been updated successfully\")]")
	WebElement successMsg;
	
	@FindBy(xpath = "//div[@id =\"tr_buttons\"]/input")
	WebElement clearBtn;
	
	@FindBy(xpath = "//span[contains(text(),\"Client\")]")
	WebElement clientBtn;
	
	@FindBy(xpath = "//td[contains(text(),\"Enable Compression\")]/../td[2]/div/input")
	WebElement compressionChkbox;
	
	@FindBy(id = "enableEncryption")
	WebElement encryption;
	
	@FindBy(name = "serverTokenExpireFrequency")
	WebElement serverToken;
	
	@FindBy(name = "samlAuthSessionExpireFrequency")
	WebElement SAMLAuthentication;
	
	@FindBy(id = "maintainClientLogsXDays")
	WebElement clientLogDays;
	
	@FindBy(id = "submitButton")
	WebElement clientSaveBtn;
	
	@FindBy(xpath = "//span[contains(text(),\"Global Settings has been updated successfully\")]")
	WebElement clientSuccessMsg;
	
	@FindBy(xpath = "//div[@id =\"tr_buttons\"]/input")
	WebElement clientClearBtn;
	
	@FindBy(id = "sessionTimeoutValId")
	WebElement sessiontime;
	
	@FindBy(xpath = "//span[contains(text(),\"Core Services\")]")
	WebElement coreServices;
	
	@FindBy(id = "dpPoolSize")
	WebElement threadsToProcessClientData;
	
	@FindBy(id = "hbUpdaterPoolSize")
	WebElement threadsToProcessClientHeartbeat;
	
	@FindBy(id = "hbEngineFrequency")
	WebElement hbEngineFrequency;
	
	@FindBy(id = "emailPoolSize")
	WebElement NoOfThreadsemailNotification;
	
	@FindBy(id = "goalEvaluationPoolSize")
	WebElement NoOfThreadsGoalEvaluation;
	
	@FindBy(id = "shiftHourPoolSize")
	WebElement NoOfShiftHourPoolSize;
	
	@FindBy(id = "probeRawDataRecoveryPeriod")
	WebElement probeRawDataRecoveryPeriod;
	
	@FindBy(id = "probeAuditDataRecoveryPeriod")
	WebElement probeAuditDataRecoveryPeriod;
	
	@FindBy(id = "shiftHourDataPeriod")
	WebElement shiftHourDataPeriod;
	
	@FindBy(id = "scheduleType")
	WebElement runDeletionservice;
	
	@FindBy(id = "dataDeletionHours")
	WebElement dataDeletionHours;
	
	@FindBy(id = "dataDeletionMinutes")
	WebElement dataDeletionMinutes;
	
	@FindBy(id = "aggregationFreqId")
	WebElement aggregationTime;
	
	@FindBy(id = "shiftHourFreqId")
	WebElement shiftHours;
	
	@FindBy(id = "enableUserDataEncryptionN")
	WebElement encryptionAllUser;
	
	@FindBy(id = "submitButton")
	WebElement coreServiceSave;
	
	@FindBy(xpath = "//span[contains(text(),\"Application URLs\")]")
	WebElement applicationUrl;
	
	@FindBy(id = "webConsoleURL")
	WebElement webConsoleURL;
	
	@FindBy(id = "authUrl")
	WebElement authUrl;
	
	@FindBy(id = "authLocalUrl")
	WebElement authLocalUrl;
	
	@FindBy(id = "workOutputUrl")
	WebElement workOutputUrl;
	
	@FindBy(id = "workOutputLocalUrl")
	WebElement workOutputLocalUrl;
	
	@FindBy(id = "assetOptimizationUrl")
	WebElement assetOptimizationUrl;
	
	@FindBy(id = "assetOptimizationLocalUrl")
	WebElement assetOptimizationLocalUrl;
	
	@FindBy(id = "workFlowUrl")
	WebElement workFlowUrl;
	
	@FindBy(id = "workFlowLocalUrl")
	WebElement workFlowLocalUrl;
	
	@FindBy(id = "workFlowClientUrl")
	WebElement workFlowClientUrl;
	
	@FindBy(id = "workflowAttachmentRepositoryPath")
	WebElement workflowAttachmentRepositoryPath;
	
	@FindBy(id = "analyticsUrl")
	WebElement analyticsUrl;
	
	@FindBy(id = "analyticsLocalUrl")
	WebElement analyticsLocalUrl;
	
	@FindBy(id = "dataSourceName")
	WebElement dataSourceName;
	
	@FindBy(id = "usageAnalyticsUrl")
	WebElement usageAnalyticsUrl;
	
	@FindBy(id = "usageAnalyticsLocalUrl")
	WebElement usageAnalyticsLocalUrl;
	
	@FindBy(id = "dataProcessorUrl")
	WebElement dataProcessorUrl;
	
	@FindBy(xpath = "//div[contains(text(),\"SMTP User Name is required information\")]")
	WebElement usernameRequired;
	
	@FindBy(xpath = "//div[contains(text(),\"SMTP Password is required information\")]")
	WebElement passwordRequired;
	
	@FindBy(xpath = "//div[contains(text(),\"From Address is required information\")]")
	WebElement fromAddressRequired;
	
	@FindBy(xpath = "//div[contains(text(),\"Number of threads to process Email Notification is required information\")]")
	WebElement clientDataField;
	
	@FindBy(xpath ="//button[contains(text(),\"OK\")]")
	WebElement ok;
	
	@FindBy(xpath = "//div[contains(text(),\"Number of threads to process Goal Evaluation is not in the range of 5 to 10\")]")
	WebElement goalEvalRange;
	
	@FindBy(xpath = "//div[contains(text(),\"Client Raw (Recovery) Data cannot be greater than 30 days\")]")
	WebElement clientDateRange;
	
	@FindBy(xpath = "//div[contains(text(),\"Client specific audit cannot be greater than 30 days\")]")
	WebElement clientSpecificDateRange;
	
	
	public GlobalSettingsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@Step("Click on Email server btn")
	public void clickEmailServerBtn()
	{
		this.EmailServerBtn.click();
	}
	
	@Step("Select the protocol")
	public void selectProtocol(String protocol)
	{
			Select clickProtocol = new Select(this.protocol);
			clickProtocol.selectByVisibleText(protocol);
		
	}
	
	@Step("Click on Server host and change the host")
	public void clickServerHost(String host)
	{
		this.serverHost.clear();
		this.serverHost.sendKeys(host);
	}
	
	@Step("Click on Server port and change the port ")
	public void clickServerPort(String port)
	{
		this.serverPort.clear();
		this.serverPort.sendKeys(port);
	}
	
	@Step("Select encryption type")
	public void selectEncryptionType(String encType)
	{
			Select clickType = new Select(this.encType);
			clickType.selectByVisibleText(encType);
	}
	
	@Step("Click on Encryption authentication check box")
	public void clickEnableAuthenticationChkBox() throws InterruptedException
	{
		//this.authenticationChkBox.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.authenticationChkBox);
		Thread.sleep(1000);
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", this.authenticationChkBox);
	}
	
	@Step("Click on Username and enter the username ")
	public void clickUserName(String userName)
	{
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	@Step("CLick on password and enter the password")
	public void clickPassword(String password)
	{
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	@Step("Click on from address and enter the address")
	public void clickFromAddress(String address) {
		this.fromAddress.clear();
		this.fromAddress.sendKeys(address);
	}
	
	@Step("Click on Test Email")
	public void clickTestEmail()
	{
		this.testEmail.click();
	}
	
	@Step("Click on Save btn")
	public void clickSaveBtn()
	{
		this.saveButton.click();
	}
	
	@Step("Verify the success message")
	public boolean getMsg() {
		String ms = this.successMsg.getText();
		System.out.println(ms);
		String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
		String compareMsg = "GlobalSettingshasbeenupdatedsuccessfully";
		boolean check = msg.equals(compareMsg);
		return check;

	}
	
	@Step("Click on Clear btn ")
	public void clickClearBtn()
	{
		this.clearBtn.click();
	}
	
	@Step("Click on Client btn")
	public void clickClientBtn()
	{
		this.clientBtn.click();
	}
	
	
	@Step("Click on Enable Compression check box ")
	public void clickEnableCompressionChkbox() throws InterruptedException
	{
		//this.compressionChkbox.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.compressionChkbox);
		Thread.sleep(1000);
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", this.compressionChkbox);
	}
	
	@Step("Click Enable encrytioncheck box  ")
	public void clickEnaleEncryptionChkbox() throws InterruptedException
	{
		//this.encryption.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.encryption);
		Thread.sleep(1000);
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", this.encryption);
	}
	
	@Step("Select server token ")
	public void selectServerToken(String serverToken)
	{
		Select clickServerToken = new Select(this.serverToken);
		clickServerToken.selectByVisibleText(serverToken);
	}
	
	@Step("SSelect SAML authentication")
	public void selectSAMLAuthentication(String SAMLAuthentication)
	{
		Select clickSAMLAuthentication = new Select(this.SAMLAuthentication);
		clickSAMLAuthentication.selectByVisibleText(SAMLAuthentication);
	}
	
	@Step("Select Client Log days")
	public void selectClientLogDays(String clientLogDays)
	{
		Select clickClientLogDays = new Select(this.clientLogDays);
		clickClientLogDays.selectByVisibleText(clientLogDays);
	}
	
	@Step("click Client Save btn")
	public void clickClientSaveBtn()
	{
		this.clientSaveBtn.click();
	}
	
	@Step("Verify the client success message")
	public boolean clickClientSuccessMsg()
	{
		String ms = this.successMsg.getText();
		System.out.println(ms);
		String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
		String compareMsg = "GlobalSettingshasbeenupdatedsuccessfully";
		boolean check = msg.equals(compareMsg);
		return check;
	}
	
	@Step("Click on Client clear btn")
	public void clickClientClearBtn()
	{
		this.clientClearBtn.click();
	}
	
	@Step("Seelect session time")
	public void selectSessionTime(String sessiontime)
	{
			Select clickSessionTime= new Select(this.sessiontime);
			clickSessionTime.selectByVisibleText(sessiontime);
	}
	
	@Step("Click on Core Services ")
	public void clickCoreServices()
	{
		this.coreServices.click();
	}
	
	@Step("Change threads to processs the clint data")
	public void clickThreadsToProcessClientData(String thread)
	{
		this.threadsToProcessClientData.clear();
		this.threadsToProcessClientData.sendKeys(thread);;
	}
	
	@Step("Change threads to process clicnt hearbeat")
	public void clickThreadsToProcessClientHaertbeat(String thread)
	{
		this.threadsToProcessClientHeartbeat.clear();
		this.threadsToProcessClientHeartbeat.sendKeys(thread);;
	}
	
	@Step("Change hbEngne Frequency")
	public void clickhbEngineFrequency(String hbEngineFrequency)
	{
		this.hbEngineFrequency.clear();
		this.hbEngineFrequency.sendKeys(hbEngineFrequency);;
	}
	
	@Step("Change number of threads for email notification")
	public void clickNoOfThreadsemailNotification(String NoOfThreadsemailNotification)
	{
		this.NoOfThreadsemailNotification.clear();
		this.NoOfThreadsemailNotification.sendKeys(NoOfThreadsemailNotification);;
	}
	
	@Step("Chnage No.of threads for Goal evalution")
	public void clickNoOfThreadsGoalEvaluation(String NoOfThreadsGoalEvaluation)
	{
		this.NoOfThreadsGoalEvaluation.clear();
		this.NoOfThreadsGoalEvaluation.sendKeys(NoOfThreadsGoalEvaluation);;
	}
	
	@Step("Change No.of threads for Shift hour pool size")
	public void clickNoOfShiftHourPoolSize(String NoOfShiftHourPoolSize)
	{
		this.NoOfShiftHourPoolSize.clear();
		this.NoOfShiftHourPoolSize.sendKeys(NoOfShiftHourPoolSize);;
	}
	
	@Step("Change probe Raw data recovery period")
	public void clickprobeRawDataRecoveryPeriod(String probeRawDataRecoveryPeriod)
	{
		this.probeRawDataRecoveryPeriod.clear();
		this.probeRawDataRecoveryPeriod.sendKeys(probeRawDataRecoveryPeriod);;
	}
	
	@Step("Change probe Audit data recovery period")
	public void clickprobeAuditDataRecoveryPeriod(String probeAuditDataRecoveryPeriod)
	{
		this.probeAuditDataRecoveryPeriod.clear();
		this.probeAuditDataRecoveryPeriod.sendKeys(probeAuditDataRecoveryPeriod);;
	}
	
	@Step("Change shift hour data period")
	public void clickshiftHourDataPeriod(String shiftHourDataPeriod)
	{
		this.shiftHourDataPeriod.clear();
		this.shiftHourDataPeriod.sendKeys(shiftHourDataPeriod);;
	}
	
	@Step("Select run deletion service")
	public void selectRunDeletionservice(String runDeletionservice)
	{
			Select clickRunDeletionservice= new Select(this.runDeletionservice);
			clickRunDeletionservice.selectByVisibleText(runDeletionservice);
	}
	
	@Step("Select data deletion hours")
	public void selectDataDeletionHours(String dataDeletionHours)
	{
			Select clickDataDeletionHours= new Select(this.dataDeletionHours);
			clickDataDeletionHours.selectByVisibleText(dataDeletionHours);
	}
	
	@Step("Select data deletion minutes")
	public void selectdataDeletionMinutes(String dataDeletionMinutes)
	{
			Select clickDataDeletionMinutes= new Select(this.dataDeletionMinutes);
			clickDataDeletionMinutes.selectByVisibleText(dataDeletionMinutes);
	}
	
	@Step("Select aggregation time")
	public void selectAggregationTime(String aggregationTime)
	{
			Select clickAggregationTime= new Select(this.aggregationTime);
			clickAggregationTime.selectByVisibleText(aggregationTime);
	}
	
	@Step("Select shift hour")
	public void selectShiftHours(String shiftHours)
	{
			Select clickShiftHours= new Select(this.shiftHours);
			clickShiftHours.selectByVisibleText(shiftHours);
	}
	
	@Step("Click on encryption for all user")
	public void clickEncryptionAllUser()
	{
		this.encryptionAllUser.click();
	}
	
	@Step("Click on COre Service Save btn")
	public void clickCoreServiceSave()
	{
		this.coreServiceSave.click();
	}
	
	@Step("Click Application url")
	public void clickApplicationUrl()
	{
		this.applicationUrl.click();
	}
	
	@Step("Change the Webcone url")
	public void clickWebConsoleURL(String webConsoleURL)
	{
		this.webConsoleURL.clear();
		this.webConsoleURL.sendKeys(webConsoleURL);;
	}
	
	@Step("Change the auth url")
	public void clickAuthUrl(String authUrl)
	{
		this.authUrl.clear();
		this.authUrl.sendKeys(authUrl);;
	}
	
	@Step("Change the auth local url")
	public void clickAuthLocalUrl(String authLocalUrl)
	{
		this.authLocalUrl.clear();
		this.authLocalUrl.sendKeys(authLocalUrl);;
	}
	
	@Step("Change the workoutput url")
	public void clickWorkOutputUrl(String workOutputUrl)
	{
		this.workOutputUrl.clear();
		this.workOutputUrl.sendKeys(workOutputUrl);;
	}
		
	@Step("Change the workoutput local url")
	public void clickWorkOutputLocalUrl(String workOutputLocalUrl)
	{
		this.workOutputLocalUrl.clear();
		this.workOutputLocalUrl.sendKeys(workOutputLocalUrl);;
	}
	
	@Step("Change the assert optimization url")
	public void clickAssetOptimizationUrl(String assetOptimizationUrl)
	{
		this.assetOptimizationUrl.clear();
		this.assetOptimizationUrl.sendKeys(assetOptimizationUrl);;
	}
	
	@Step("Chnage the Assert optimization local url")
	public void clickAssetOptimizationLocalUrl(String assetOptimizationLocalUrl)
	{
		this.assetOptimizationLocalUrl.clear();
		this.assetOptimizationLocalUrl.sendKeys(assetOptimizationLocalUrl);;
	}
	
	@Step("Change workflow url")
	public void clickWorkFlowUrl(String workFlowUrl)
	{
		this.workFlowUrl.clear();
		this.workFlowUrl.sendKeys(workFlowUrl);;
	}
	
	@Step("Change workflow local url")
	public void clickWorkFlowLocalUrl(String workFlowLocalUrl)
	{
		this.workFlowLocalUrl.clear();
		this.workFlowLocalUrl.sendKeys(workFlowLocalUrl);;
	}
	
	@Step("Change workflow client url")
	public void clickworkFlowClientUrl(String workFlowClientUrl)
	{
		this.workFlowClientUrl.clear();
		this.workFlowClientUrl.sendKeys(workFlowClientUrl);;
	}
	
	@Step("Change workflow attchment repository path")
	public void clickWorkflowAttachmentRepositoryPath(String workflowAttachmentRepositoryPath)
	{
		this.workflowAttachmentRepositoryPath.clear();
		this.workflowAttachmentRepositoryPath.sendKeys(workflowAttachmentRepositoryPath);;
	}
	@Step("Change analytic url")
	public void clickAnalyticsUrl(String analyticsUrl)
	{
		this.analyticsUrl.clear();
		this.analyticsUrl.sendKeys(analyticsUrl);;
	}
	
	@Step("Chnage analytic local url")
	public void clickAnalyticsLocalUrl(String analyticsLocalUrl)
	{
		this.analyticsLocalUrl.clear();
		this.analyticsLocalUrl.sendKeys(analyticsLocalUrl);;
	}
	
	@Step("Chnage data source name")
	public void clickDataSourceName(String dataSourceName)
	{
		this.dataSourceName.clear();
		this.dataSourceName.sendKeys(dataSourceName);;
	}
	
	@Step("Change usage analytic url")
	public void clickUsageAnalyticsUrl(String usageAnalyticsUrl)
	{
		this.usageAnalyticsUrl.clear();
		this.usageAnalyticsUrl.sendKeys(usageAnalyticsUrl);;
	}
	
	@Step("Change usage analytics local url")
	public void clickUsageAnalyticsLocalUrl(String usageAnalyticsLocalUrl)
	{
		this.usageAnalyticsLocalUrl.clear();
		this.usageAnalyticsLocalUrl.sendKeys(usageAnalyticsLocalUrl);;
	}
	
	@Step("Change data process url")
	public void clickDataProcessorUrl(String dataProcessorUrl)
	{
		this.dataProcessorUrl.clear();
		this.dataProcessorUrl.sendKeys(dataProcessorUrl);;
	}
	
	@Step("Verify username required filed")
	public boolean clickUsernameRequired()
	{
		String ms = this.usernameRequired.getText();
		System.out.println(this.usernameRequired.getText());
		String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
		String compareMsg = "SMTPUserNameisrequiredinformation";
		boolean check = msg.equals(compareMsg);
		return check;

	}
	
	@Step("Verify password required filed ")
	public boolean clickPasswordRequired()
	{
		String ms = this.passwordRequired.getText();
		System.out.println(this.passwordRequired.getText());
		String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
		String compareMsg = "SMTPPasswordisrequiredinformation";
		boolean check = msg.equals(compareMsg);
		return check;

	}
	
	@Step("Verify from address required field")
	public boolean clickFromAddressRequired()
	{
		String ms = this.fromAddressRequired.getText();
		System.out.println(this.fromAddressRequired.getText());
		String msg = ms.substring(1, ms.length()).replaceAll("\\s+", "");
		String compareMsg = "FromAddressisrequiredinformation";
		boolean check = msg.equals(compareMsg);
		return check;

	}
	
	@Step("Verify client data field")
	public boolean clickClientDataField()
	{
		String ms = this.clientDataField.getText();
		System.out.println(this.clientDataField.getText());
		String msg = ms.substring(0, ms.length()).replaceAll("\\s+", "");
		String compareMsg = "NumberofthreadstoprocessEmailNotificationisrequiredinformation";
		boolean check = msg.equals(compareMsg);
		return check;

	}
	
	@Step("Click on OK btn")
	public void clickOKbtn()
	{
		this.ok.click();
	}
	
	@Step("Verify goal evaluation message")
	public boolean clickGoalEvalRange()
	{
		String ms = this.goalEvalRange.getText();
		System.out.println(this.goalEvalRange.getText());
		String msg = ms.substring(0, ms.length()).replaceAll("\\s+", "");
		String compareMsg = "NumberofthreadstoprocessGoalEvaluationisnotintherangeof5to10";
		boolean check = msg.equals(compareMsg);
		System.out.println(check);
		return check;

	}
	
	@Step("Verify Client date range")
	public boolean clickClientDateRange()
	{
		String ms = this.clientDateRange.getText();
		System.out.println(this.clientDateRange.getText());
		String msg = ms.substring(0, ms.length()).replaceAll("\\s+", "");
		String compareMsg = "ClientRaw(Recovery)Datacannotbegreaterthan30days";
		boolean check = msg.equals(compareMsg);
		System.out.println(check);
		return check;

	}
	
	@Step("Verify client specification date range")
	public boolean clickClientSpecificDateRange()
	{
		String ms = this.clientSpecificDateRange.getText();
		System.out.println(this.clientSpecificDateRange.getText());
		String msg = ms.substring(0, ms.length()).replaceAll("\\s+", "");
		String compareMsg = "Clientspecificauditcannotbegreaterthan30days";
		boolean check = msg.equals(compareMsg);
		System.out.println(check);
		return check;

	}
	
	@Step("Enable encryption check box")
	public void clickEnableEncryptionChkbox() throws InterruptedException
	{
		//this.encryption.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.encryption);
		Thread.sleep(1000);
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", this.encryption);
	}
}
