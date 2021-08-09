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

public class SelectCityTest extends HomePage {

	ExtentReports report = ExtendReport.getReportInstance("SelectCityTestReport");

	@Test(groups="Regression Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyEnterCity(String cityName, String ExpectedText) throws InterruptedException, IOException {
		
		ExtentTest logger = report.createTest("Setting city location in city field");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
		
		logger.log(Status.INFO, "Setting Pune City in location field");
		selectCity(cityName);
		
		driver.navigate().refresh();
		
		String ActualText = cityTextBox.getAttribute("placeholder");
		
		try {
			Assert.assertEquals(ExpectedText, ActualText);
			System.out.println(cityName + " city is selcted.");
			logger.log(Status.PASS, "Set Pune as city location in City field");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("City is not enterd");
		}
		driver.close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}
}
