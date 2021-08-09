package TestCases.HomePage;


import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Pages.HomePage;
import Utilities.DataProviderSource;
import Utilities.ExtendReport;

public class SelectServiceTest extends HomePage {
	ExtentReports report = ExtendReport.getReportInstance("SelectServiceTest");

	@Test(groups="Regression Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifySelectedService(String selectService) throws InterruptedException, IOException {
		
		ExtentTest logger = report.createTest("Setting service in SearchTextBox");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
		
		logger.log(Status.INFO, "Setting Car Wash Service in SearchTextBox field");
		selectService(selectService);
		
		try {
			System.out.println("Car Washing Services is selcted.");
			logger.log(Status.PASS, "Set Car Washing Services in SearchTextBox field");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Service is not selected");
		}
		driver.close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}

}
