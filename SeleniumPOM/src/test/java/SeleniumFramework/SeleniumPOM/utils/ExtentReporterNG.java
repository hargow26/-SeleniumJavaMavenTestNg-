package SeleniumFramework.SeleniumPOM.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * includes the code to generate the Extent report for the ran test cases
 * @author Harish Gowda S
 *
 */
public class ExtentReporterNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation test result");
		reporter.config().setReportName("Test result");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("software tester", "Harish");
		return extent;
		
	}

}
