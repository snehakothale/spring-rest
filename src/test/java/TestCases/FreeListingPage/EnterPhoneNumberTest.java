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

public class EnterPhoneNumberTest extends FreeListingPage{
	
	ExtentReports report = ExtendReport.getReportInstance("EnterPhoneNumberReport");

	@Test(groups="Regression Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyEnteredPhoneNumber(String companyName,String cityName,String firstName,String lastName,String phoneNum) throws InterruptedException, IOException {
		
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
		
		logger.log(Status.INFO, "Entering the Last Name");
		enterLastname(lastName);
		
		logger.log(Status.INFO, "Entering the Phone Number");
		enterPhonenumber(phoneNum);
		
		capturescreenshot("Entered data in FreeListing page");
		
		try {
			System.out.println("Phone Number is entered");
			logger.log(Status.PASS, "Phone Number entered in FreeListing page");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Phone Number is not entered");
		}
		driver.close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}

}
