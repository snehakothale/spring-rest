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

	public class GymOptionTest extends FitnessPage {
		
			ExtentReports report = ExtendReport.getReportInstance("GymOption");

			@Test(groups="Smoke Test")
			public void verifyGymOption() throws InterruptedException, IOException {

				
				ExtentTest logger = report.createTest("Check Gym Option is available or not");
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
				fitnessCategory();
				
				PageFactory.initElements(driver, this);
				
				logger.log(Status.INFO, "check Gym option is available or not");
				
				boolean value=gymOptions();
				
				try {
					Assert.assertTrue(value);
					System.out.println("Gym option is available");
					logger.log(Status.PASS, "Gym option is available");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Gym option is not available");
				}
				driver.close();
			}

			@AfterTest
			public void endReport() {
				report.flush();
			}

		}

	


