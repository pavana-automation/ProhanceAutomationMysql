package net.Commons;

import org.testng.ITestResult;

public interface IRetryAnalyzer {
	
	public boolean retry(ITestResult result);

}
