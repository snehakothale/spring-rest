package TestCases.HomePage;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Pages.HomePage;
import Utilities.DataProviderSource;
import Utilities.ExtendReport;

public class SearchBoxTest extends HomePage {

	ExtentReports report = ExtendReport.getReportInstance("SearchBoxTestReport");

	@Test(groups="Regression Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifySearchTextBoxDisplay(String ExpectedText) throws InterruptedException, IOException {

		ExtentTest logger = report.createTest("SearchTextBox Display Test");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
		
		String ActualText = searchTextBox.getAttribute("placeholder");
		try {
			Assert.assertEquals(ExpectedText, ActualText);
			System.out.println("SearchTextBox is displayed");
			logger.log(Status.PASS, "SearchTextBox is displayed");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The SearchTextBox is not displayed");
		}
		driver.close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}
}
