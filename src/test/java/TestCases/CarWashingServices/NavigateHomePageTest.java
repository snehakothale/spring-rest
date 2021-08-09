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

public class NavigateHomePageTest extends CarWashServicesPage{
	ExtentReports report = ExtendReport.getReportInstance("BackToHomePage");

	@Test(groups="Smoke Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void VerifyUserCanGoToHomepage( String cityName, String area, String service,String ExpectedUrl) throws InterruptedException, IOException {

		ExtentTest logger = report.createTest("Navigating to HomePage");
		
		logger.log(Status.INFO, "Lunch browser and open Car Washing Service Page");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver , this);
		
		logger.log(Status.INFO, "Delete all Cookies");
		driver.manage().deleteAllCookies();
		
		logger.log(Status.INFO, "Setting Pune in city location field");
		
		logger.log(Status.INFO, "Entering Pune City in Enter Area field");
		
		logger.log(Status.INFO, "Setting Car Washing Services in SearchTextBox field");
		goToCarWashServicesPage(cityName, area, service);
		
		PageFactory.initElements(driver , this);
		
		logger.log(Status.INFO, "Delete all Cookies");
		driver.manage().deleteAllCookies();
		
		//checkRating_btn();
		
		logger.log(Status.INFO, "Click the Rating button");
		driver.manage().deleteAllCookies();
		selectRating_btn();
        
        logger.log(Status.INFO, "Navigate Back to home page");
		goToHomePage();
		
		String ActualUrl = driver.getCurrentUrl();
		
		try {
			Assert.assertEquals(ExpectedUrl, ActualUrl);
			System.out.println("The Homepage is open in the browser");
			logger.log(Status.PASS, "HomePage is open");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.PASS, "Unable to go To HomePage");
			System.out.println("The correct webpage is not open in the browser");
		}
       driver.close();
	}
	@AfterTest
	public void endReport() {
		report.flush();	
	}
}

