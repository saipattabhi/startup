package Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.base;
import utilities.ExtentReport;

public class listener extends base implements ITestListener {
	
	 ExtentReports xtentreport = ExtentReport.getExtentReport();
	 ExtentTest extenttest;
	 ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	
	public   WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		
	   String testname = result.getName();
		
	  extenttest = xtentreport.createTest(testname+"Test Execution started");
	  
	  extentTestThread.set(extenttest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testname = result.getName();
		
	      //extenttest.log(Status.PASS,testname+"test got passed");
		extentTestThread.get().log(Status.PASS,testname+"test got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//extenttest.fail(result.getThrowable());
		
		extentTestThread.get().fail(result.getThrowable());
		String testname = result.getName();
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			String screenshotpath = takeScreenshot(testname, driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotpath, testname);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
			}

	@Override
	public void onFinish(ITestContext context) {
		
		xtentreport.flush();
		
		
	}
	
	
	

}
