package TestCases.CarWashingServices;


import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Pages.CarWashServicesPage;
import Utilities.DataProviderSource;
import Utilities.ExtendReport;

public class FunctinalityOfRatingbtnTest extends CarWashServicesPage{
	ExtentReports report = ExtendReport.getReportInstance("SelectRatingsButton");

	
	@Test(groups="Smoke Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyRatingbtnDisplay( String cityName, String area, String service) throws InterruptedException, IOException {

	
		ExtentTest logger = report.createTest("Check the working of Ratings button");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver , this);
		
		logger.log(Status.INFO, "Delete all Cookies");
		driver.manage().deleteAllCookies();
		
		logger.log(Status.INFO, "Setting Pune City in location field");
		logger.log(Status.INFO, "Entering Pune City in Enter Area field");
		logger.log(Status.INFO, "Setting Car Washing Services in SearchTextBox field");
		
		goToCarWashServicesPage(cityName, area, service);
		
		boolean value=checkRating_btn();
		
		try {
			Assert.assertTrue(value);
			logger.log(Status.PASS, "Rating button is Selected");
			System.out.println("Ratings button is get selected");
		}catch(Exception e) {
			e.printStackTrace();
			logger.log(Status.PASS, "Rating button is Dissable");

			System.out.println("Ratings button is Not Enable");
		}
		selectRating_btn();
		driver.close();
	}
	@AfterTest
	public void endReport() {
		report.flush();
	}
}
