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

public class EnterAreaTest extends HomePage {
	ExtentReports report = ExtendReport.getReportInstance("EnterAreaTestReport");

	@Test(groups="Regression Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyEnterArea(String cityName, String enteredArea) throws InterruptedException, IOException {

		ExtentTest logger = report.createTest("Setting area in Enter Area field");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
		
		logger.log(Status.INFO, "Setting Pune in City location field");
		selectCity(cityName);
		
		logger.log(Status.INFO, "Entering Pune City in Enter Area field");
		enterArea(enteredArea);
		
		try {
			System.out.println("Shivaji Nagar area is selected in Enter Area field");
			logger.log(Status.PASS, "Set the location as Shivaji Nagar");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The Area is not selected");
		}
		driver.close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}

}
