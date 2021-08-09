package TestCases.GymPage;


import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Pages.GymPage;
import Utilities.ExtendReport;

public class GymPageTest extends GymPage {
	ExtentReports report = ExtendReport.getReportInstance("GymPageTestReport");

	@Test(groups="Smoke Test") 
	public void verifyGymPage()
			throws InterruptedException, IOException {
		
		ExtentTest logger = report.createTest("Navigating to Gym Page");
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
   
		logger.log(Status.INFO, "Delete all Cookies");
		driver.manage().deleteAllCookies();
		
		logger.log(Status.INFO, "Navigate to Fitness Page");
		fitness();
		
		logger.log(Status.INFO, "Navigate to Gym Page");
		gym();
		
		String actualUrl = driver.getCurrentUrl();
		String expected="https://www.justdial.com/Mumbai/210/11381/Gym_b2c";
		try {
			Assert.assertEquals(actualUrl, expected);
			System.out.println("Gym Page is open");
			logger.log(Status.PASS, " Gym Page is open");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Gym Page is not open");
		}
		driver.close();
}
	@AfterTest
	public void endReport() {
		report.flush();
	}
}
