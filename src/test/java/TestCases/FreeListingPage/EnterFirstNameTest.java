package TestCases.FreeListingPage;


import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Pages.FreeListingPage;
import Utilities.DataProviderSource;
import Utilities.ExtendReport;

public class EnterFirstNameTest extends FreeListingPage{
	
	ExtentReports report = ExtendReport.getReportInstance("");

	@Test(groups="Regression Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyEnteredFirstName(String companyName,String cityName,String firstName) throws InterruptedException, IOException {
		
		ExtentTest logger = report.createTest("Entering Company name");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
		
		logger.log(Status.INFO, "Opening the FreeListing page");
		FreeListing_btn.click();
		
		logger.log(Status.INFO, "Entering the Company name");	
		enterCompanyname(companyName);
		CompanyCity.clear();
		
		logger.log(Status.INFO, "Entering the Company city");
		selectCityname(cityName);
		
		logger.log(Status.INFO, "Entering the First Name");
		enterFirstname(firstName);
		
		try {
			System.out.println("First name  entered");
			logger.log(Status.PASS, "First Name  entered in FreeListing page");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("First name not entered");
		}
		driver.close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}


}
