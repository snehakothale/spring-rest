package TestCases.CarWashingServices;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.TreeSet;
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

public class TopFiveServicesTest extends CarWashServicesPage{
	ExtentReports report = ExtendReport.getReportInstance("TopFiveServices");

	@Test(groups="Regression Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyRatingbtnDisplay( String cityName, String area, String service) throws InterruptedException, IOException {

		System.setOut(new PrintStream(
				new FileOutputStream(System.getProperty("user.dir")+"\\Output\\Top Car Wash Services List.txt")));
		
		ExtentTest logger = report.createTest("Top rating Five CarWashing Services");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver , this);
		
		logger.log(Status.INFO, "Delete all Cookies");
		driver.manage().deleteAllCookies();
		
		logger.log(Status.INFO, "Setting Pune City in location field");
		
		logger.log(Status.INFO, "Entering Shivaji Nagar in Enter Area field");
		
		logger.log(Status.INFO, "Setting Car Washing Services in SearchTextBox field");
		goToCarWashServicesPage(cityName, area, service);
		
		checkRating_btn();

		selectRating_btn();
		
		scrollDown();
        
		List<WebElement> list=SortListByVotesAndRating();
				
		TreeSet<String> ratingSet =  TopServices(list);
		
		String arr[]=topFiveServices(ratingSet);
		try {
			Assert.assertEquals(arr.length, 5);
			System.out.println("Top five Services Are Saved in Array");
			logger.log(Status.PASS, "Top five Services Are Saved in Array");
		}catch(Exception e) {
			logger.log(Status.FAIL, "Array is Empty");
			System.out.println("Array is Empty");
		}
		driver.close();

	}
	@AfterTest
	public void endReport() {
		report.flush();
	}
}


