package TestCases.FreeListingPage;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Pages.FreeListingPage;
import Utilities.DataProviderSource;
import Utilities.ExtendReport;

public class EnterCompanyCityTest extends FreeListingPage{
	
	ExtentReports report = ExtendReport.getReportInstance("EnterCompanyCityTestReport");

	@Test(groups="Regression Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyEnteredCompanyCity(String companyName,String cityName,String expected) throws InterruptedException, IOException {
	
		ExtentTest logger = report.createTest("Entering Company name");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
		
		logger.log(Status.INFO, "Opening the FreeListing page");
		FreeListing_btn.click();
		
		logger.log(Status.INFO, "Entering the Company name");
		enterCompanyname(companyName);
		
		logger.log(Status.INFO, "Entering the Company city");
		CompanyCity.clear();
		selectCityname(cityName);
		
		String actual=CompanyCity.getAttribute("value");
		
        try {
			Assert.assertTrue(actual.equals(expected));
			System.out.println("Company city is  selected");
			logger.log(Status.PASS, "Company City entered in FreeListing page");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Comany city is not selected");
		}
		driver.close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}
}
