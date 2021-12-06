package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	
	public static  ExtentReports  getExtentReport()
	{
		
	   String reportpath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		
	ExtentSparkReporter reporter=new ExtentSparkReporter(reportpath);
	
	reporter.config().setReportName("Test Automation of Tutorial Ninja Application");
	reporter.config().setDocumentTitle("Automation results");
	
	ExtentReports report=new ExtentReports();
	
	report.attachReporter(reporter);
	  report.setSystemInfo("Tested By", "sai pattabhi");
	  report.setSystemInfo("Operating System", "Windows 10");
	  
	  
	  return report;
	  
		
		
		
	}

}
