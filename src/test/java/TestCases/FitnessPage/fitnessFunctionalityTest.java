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

	public class fitnessFunctionalityTest extends FitnessPage {
		
			ExtentReports report = ExtendReport.getReportInstance("FitnessFunctionality");

			@Test(groups="Smoke Test")
			public void verifyFitnessFunctionality() throws InterruptedException, IOException {

				
				ExtentTest logger = report.createTest("Check Fitness Functionality");
				logger.log(Status.INFO, "Lunch browser and open url");
				openBaseUrl("baseUrl");
				
				PageFactory.initElements(driver, this);
				
				logger.log(Status.INFO, "Display categoryList");
				categoryLists();
				
				PageFactory.initElements(driver, this);
				
				logger.log(Status.INFO, "display fitness option");
				fitnessOptions();
				
				PageFactory.initElements(driver, this);
				
				logger.log(Status.INFO, "check fitness option functionality");
				
				boolean value=fitnessfunctionality();
				
				try {
					Assert.assertTrue(value);
					System.out.println("Fitness option is clickable");
					logger.log(Status.PASS, "Fitness option is clickable");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Fitness option is not clickable");
				}
				driver.close();
			}

			@AfterTest
			public void endReport() {
				report.flush();
			}

		}

	