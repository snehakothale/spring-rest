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

public class FreeListingPageTest extends FreeListingPage{
	
	ExtentReports report = ExtendReport.getReportInstance("FreeListingPageTestReport");

	@Test(groups="Smoke Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyFreeListingWebPage(String ExpectedTitle) throws InterruptedException, IOException {
		
		
		ExtentTest logger = report.createTest("Opening the FreeListing page");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
		
		logger.log(Status.INFO, "Opening the FreeListing page");
		goToFreelistingPage();
		
     	String ActualTitle = driver.getTitle();
     	
		try {
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			System.out.println("The FreeListing webpage opened in the browser");
			logger.log(Status.PASS, "FreeListing WebPage is open");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The FreeListing webpage not opened in the browser");
		}
		driver.close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}
}
