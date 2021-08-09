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

public class InvalidCompanyNameTest extends FreeListingPage{
	
	ExtentReports report = ExtendReport.getReportInstance("InvalidCompanyNameTest");

	@Test(groups="Regression Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyPopUpMessageForCompanyName(String companyName,String cityName,String firstName,String lastName,String phoneNum,String landlineNum) throws InterruptedException, IOException {
		
		ExtentTest logger = report.createTest("Get error message for invalid firstname");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
		
		logger.log(Status.INFO, "Navigate to FreeListing page");
		goToFreelistingPage();
	
		logger.log(Status.INFO, "Entering the Company name");	
		enterCompanyname(companyName);
		
		logger.log(Status.INFO, "Selecting Title");
		selectTitle();
	
		logger.log(Status.INFO, "Entering the First Name");
		enterFirstname(firstName);
	
		logger.log(Status.INFO, "Entering the Last Name");
		enterLastname(lastName);
	
		logger.log(Status.INFO, "Entering the Phone Number");
		enterPhonenumber(phoneNum);
		
		logger.log(Status.INFO, "Entering the LandLine Number");
		enterLandlinenumber(landlineNum);
		
		logger.log(Status.INFO, "click on submit button");
		submitForm();
	
	
		String actualmessage = companyNameError.getText();
		String expectedmessage = "Company name is blank";
		try {
			Assert.assertEquals(actualmessage, expectedmessage);
			System.out.println("System gives pop up message 'Company name is blank'");
			logger.log(Status.PASS, "System gives error message");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("System does not give error message");
		}
		driver.close();
}
	@AfterTest
	public void endReport() {
		report.flush();
	}


}
