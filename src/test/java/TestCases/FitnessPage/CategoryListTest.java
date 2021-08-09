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

	public class CategoryListTest extends FitnessPage {
		
			ExtentReports report = ExtendReport.getReportInstance("CategoryList");

			@Test(groups="Regression Test")
			public void verifyCategoryList() throws InterruptedException, IOException {

			
				ExtentTest logger = report.createTest("Check CategoryList");
				logger.log(Status.INFO, "Lunch browser and open url");
				openBaseUrl("baseUrl");
				
				PageFactory.initElements(driver, this);
				logger.log(Status.INFO, "Display categoryList");
				
				categoryLists();
				
				boolean value=categoryLists();
				try {
					Assert.assertFalse(value);
					System.out.println("CategoryList is displayed");
					logger.log(Status.PASS, "categoryList is displayed");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("categoryList is not displayed");
				}
				driver.close();
			}

			@AfterTest
			public void endReport() {
				report.flush();
			}

		}

