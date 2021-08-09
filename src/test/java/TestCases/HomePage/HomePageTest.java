package TestCases.HomePage;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Pages.HomePage;
import Utilities.DataProviderSource;
import Utilities.ExtendReport;

public class HomePageTest extends HomePage {

	public static ExtentReports report = ExtendReport.getReportInstance("HomePageTestReport");

	@Test(groups = "Smoke Test", dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyForCorrectWebPage(String ExpectedUrl) throws InterruptedException, IOException {

		ExtentTest logger = report.createTest("Opening the correct Url");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		String ActualUrl = driver.getCurrentUrl();
		try {
			Assert.assertEquals(ExpectedUrl, ActualUrl);
			System.out.println("The correct webpage is open in the browser");
			logger.log(Status.PASS, "Correct WebPage is open");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "correct webpage is not open");
			System.out.println("The correct webpage is not open in the browser");
		}
		 driver.close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}

}