package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtendReport extends ScreenShots {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;

	public static ExtentReports getReportInstance(String testReportName) {
		if (report == null) {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir")+"\\Output\\"+testReportName+".html");
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
			htmlReporter.config().setDocumentTitle("Automation Results");
			htmlReporter.config().setReportName("Test Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd yyyy HH:mm:ss");
		}
		return report;
	}
	
	

}
