package TestCases.HomePage;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Pages.HomePage;
import Utilities.DataProviderSource;
import Utilities.ExtendReport;

public class CarWashServicePageTest extends HomePage {

	ExtentReports report = ExtendReport.getReportInstance("CarWashServicePageTest");

	@Test(groups="Smoke Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyNavigateToCarWashServicePage(String expectedUrl, String cityName, String area, String service)
			throws InterruptedException, IOException {

		ExtentTest logger = report.createTest("Navigating to Car Washing Service Page");
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
		
		logger.log(Status.INFO, "Delete all Cookies");
		driver.manage().deleteAllCookies();
		
		logger.log(Status.INFO, "Setting Pune City in location field");
		
		logger.log(Status.INFO, "Entering Pune City in Enter Area field");
		
		logger.log(Status.INFO, "Setting Car Washing Services in SearchTextBox field");
		goToCarWashServicesPage(cityName, area, service);
		
		String actualUrl = driver.getCurrentUrl();
		try {
			Assert.assertEquals(actualUrl, expectedUrl);
			System.out.println("Car Washing Service Page is open");
			logger.log(Status.PASS, "Navigate to Car Washing Services Page in desired area");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Car Washing Service Page is open");
		}
		driver.close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}
}
