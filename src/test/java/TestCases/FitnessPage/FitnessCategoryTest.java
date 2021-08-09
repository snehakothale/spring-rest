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

	public class FitnessCategoryTest extends FitnessPage {
		
			ExtentReports report = ExtendReport.getReportInstance("FitnessCategory");

			@Test(groups="Regression Test")
			public void verifyFitnessCategory() throws InterruptedException, IOException {

				
				ExtentTest logger = report.createTest("Check FitnessCategory list avilable or not");
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
				fitnessfunctionality();
				
				PageFactory.initElements(driver, this);
				
				logger.log(Status.INFO, "check fitness category is available or not");
				
				boolean value=fitnessCategory();
				try {
					Assert.assertFalse(value);
					System.out.println("fitness category is available");
					logger.log(Status.PASS, "fitness category is available");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("fitness category is not available");
				}
				driver.close();
			}

			@AfterTest
			public void endReport() {
				report.flush();
			}

		}

	

