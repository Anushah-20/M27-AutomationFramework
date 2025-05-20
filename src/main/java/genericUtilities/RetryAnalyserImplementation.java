package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnalyser  Interface of testNG
 * @author ANUSHAH S
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{
	
	int count =0;
	int retrycount= 3;//manual analysis

	@Override
	public boolean retry(ITestResult result) {
		
		while(count<retrycount)
		{
			count ++;
			return true;//retry
		}
		return false;//stop entry
	}
	
	

}
