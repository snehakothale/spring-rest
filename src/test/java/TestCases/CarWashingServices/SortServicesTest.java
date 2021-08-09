package TestCases.CarWashingServices;


import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
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

public class SortServicesTest  extends CarWashServicesPage{
	ExtentReports report = ExtendReport.getReportInstance("SorTServices");

	@Test(groups="Regression Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyRatingbtnDisplay( String cityName, String area, String service) throws InterruptedException, IOException {

		ExtentTest logger = report.createTest("Sorting of CarWAsh Services ");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver , this);
		
		logger.log(Status.INFO, "Delete all Cookies");
		driver.manage().deleteAllCookies();
		
		logger.log(Status.INFO, "Setting Pune City in location field");
		
		logger.log(Status.INFO, "Entering Pune City in Enter Area field");
		
		logger.log(Status.INFO, "Setting Car Washing Services in SearchTextBox field");
		goToCarWashServicesPage(cityName, area, service);
		
		checkRating_btn();
		
		logger.log(Status.INFO, "Click the Rating button");
        selectRating_btn();
        
        logger.log(Status.INFO, "Scroll Down the page");
		scrollDown();
		
        List<WebElement> list=SortListByVotesAndRating();
		try {
			Assert.assertFalse(list.isEmpty());
			System.out.println("WebElements of Selected Services are Saved in List");
			logger.log(Status.PASS, "WebElements of Selected Services are Saved in List");
		}catch(Exception e) {
			logger.log(Status.FAIL, "List is Empty");
			System.out.println("List is Empty");
		}
		driver.close();

	}
	@AfterTest
	public void endReport() {
		report.flush();
	}
}
