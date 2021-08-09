package TestCases.GymPage;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Pages.GymPage;
import Utilities.ExtendReport;

public class GymPageCategoryDisplayTest extends GymPage{

	ExtentReports report = ExtendReport.getReportInstance("FitnessCategory");
	
	@Test(groups="Regression Test")
	public void verifyFitnessCategory() throws InterruptedException, IOException {
		
		System.setOut(new PrintStream(
				new FileOutputStream(System.getProperty("user.dir")+"\\Output\\GymSubMenuOptionList.txt")));
		ExtentTest logger = report.createTest("Check FitnessCategory list avilable or not");
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
			logger.log(Status.INFO, "Delete all Cookies");
			driver.manage().deleteAllCookies();
			
			logger.log(Status.INFO, "Navigate to Fitness Page");
			fitness();
			
			logger.log(Status.INFO, "Navigate to Gym Page");
			gym();
			
			gymCategory();	
			
		try {
			//Assert
			System.out.println("fitness category is available");
			logger.log(Status.PASS, "fitness category is available");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fitness category is not available");
		}
 
        ElementListUsage();
  
		driver.close();
	}
	
	}


