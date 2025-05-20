package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides the implementation to IListener interface in testNG
 * @author ANUSHAH S
 */
public class ListenerImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// capture Method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("# " + methodName + " Test Script execution Started #");
		
		// Intimate the Extent report for Test Execution
				test = report.createTest(methodName);


	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// capture Method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("# " + methodName + " Test Script PASS #");
		
		// Log the status as PASS in Extent Report
		test.log(Status.PASS, methodName + " Test Script PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// capture Method name
				String methodName = result.getMethod().getMethodName();
				System.out.println("# " + methodName + " Test Script FAIL #");

				// capture Exception
				System.out.println(result.getThrowable());
				
				// Log the status as FAIL in Extent Report
				test.log(Status.FAIL, methodName+ "Test Script FAIL");

				// Log the exception captured to Extent Report
				test.log(Status.WARNING, result.getThrowable());
				
				//capture screenshot
				JavaUtility j = new JavaUtility();
				SeleniumUtility s= new SeleniumUtility();
				
				String screenShotName =methodName+ "-"+ j.getSystemDate();
				
				try {
					s.captureScreenShot(BaseClass.sdriver, screenShotName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// capture Method name
				String methodName = result.getMethod().getMethodName();
				System.out.println("# " + methodName + " Test Script SKIP #");

				// capture Exception
				System.out.println(result.getThrowable());
				
				// Log the status as SKIP in Extent Report
				test.log(Status.SKIP, methodName + " Test Script SKIP");

				// Log the exception captured to Extent Report
				test.log(Status.WARNING, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("# Suite execution Started #");
		
		//Basic configuration for extent reports
		
		ExtentSparkReporter esr= new ExtentSparkReporter(".\\ExtentReports\\Report - "+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swag labs Execution report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Automation Execution report");
		
		//Report Generation
		report= new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base browser", "Google Chrome");
		report.setSystemInfo("Base platform", "windows");
		report.setSystemInfo("Base envrn", "Testing");
		report.setSystemInfo("Reporter name", "Anushah");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("# Suite execution Finished #");
		
		// Generate Extent Report
				report.flush();
	}
	
	

}
