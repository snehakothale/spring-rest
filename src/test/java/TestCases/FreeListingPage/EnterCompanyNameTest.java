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

public class EnterCompanyNameTest extends FreeListingPage{
	
	ExtentReports report = ExtendReport.getReportInstance("CompanyNameTestReport");
	@Test(groups="Regression Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyEnteredCompanyName(String companyName,String expected) throws InterruptedException, IOException {
		
		ExtentTest logger = report.createTest("Entering Company name in FreeListing page");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
		
		logger.log(Status.INFO, "Opening the FreeListing page");
		FreeListing_btn.click();
		
		logger.log(Status.INFO, "Entering the Company name");	
		enterCompanyname(companyName);
		
		String actual=CompanyName.getAttribute("value");
		
		try {
			Assert.assertTrue(actual.equals(expected));
			System.out.println("Comany name is entered");
			logger.log(Status.PASS, "Company Name is entered in FreeListing page");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Comany name is entered");
		}
		driver.close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}

}
