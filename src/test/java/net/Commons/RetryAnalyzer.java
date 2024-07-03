package net.Commons;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import io.qameta.allure.model.Status;
import io.qameta.allure.testng.AllureTestNg;



public  class RetryAnalyzer extends AllureTestNg implements IRetryAnalyzer {
	
	
	
	int counter = 0;
	int retryLimit = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		
		
		if(counter < retryLimit)
		{
			System.out.println("Retry the failed case"+result.getName() +" with status");
			counter++;
			return true;
		}
		return false;
	}
    
    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        IRetryAnalyzer retryAnalyzer = ((IRetryAnalyzer) testInstance);
        if (retryAnalyzer != null && retryAnalyzer.retry(result)) {
            // Do nothing for now, let the retry take place
        } else {
            // If no more retries, update the status
            updateStatus(result);
        }
    }
    
    private void updateStatus(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // If test failed after all retries, mark as failed
            getLifecycle().updateTestCase(testResult -> testResult.setStatus(Status.FAILED));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            // If test passed after retries, mark as passed
            getLifecycle().updateTestCase(testResult -> testResult.setStatus(Status.PASSED));
        }
    }


}

