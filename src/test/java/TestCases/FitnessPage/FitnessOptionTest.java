package TestCases.FitnessPage;


import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Pages.FitnessPage;
import Utilities.ExtendReport;

	public class FitnessOptionTest extends FitnessPage {
		
			ExtentReports report = ExtendReport.getReportInstance("FitnessOption");

			@Test(groups="Regression Test")
			public void verifyFitnessOption() throws InterruptedException, IOException {

			
				ExtentTest logger = report.createTest("Check Fitness Option");
				logger.log(Status.INFO, "Lunch browser and open url");
				openBaseUrl("baseUrl");
				
				PageFactory.initElements(driver, this);
				
				logger.log(Status.INFO, "Display categoryList");
				categoryLists();
				
				PageFactory.initElements(driver, this);
				
				logger.log(Status.INFO, "display fitness option");
				
				boolean value=fitnessOptions();
				
				try {
					Assert.assertTrue(value);
					System.out.println("Fitness option is available");
					logger.log(Status.PASS, "Fitnesss option is available");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Fitness option is not available");
				}
				driver.close();
			}

			@AfterTest
			public void endReport() {
				report.flush();
			}

		}
