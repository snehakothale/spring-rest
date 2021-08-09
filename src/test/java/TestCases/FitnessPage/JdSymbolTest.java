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

	public class JdSymbolTest extends FitnessPage {
		
			ExtentReports report = ExtendReport.getReportInstance("JdSymbol");

			@Test(groups="Smoke Test")
			public void Jdsymbol() throws InterruptedException, IOException {

				
				ExtentTest logger = report.createTest("Check CategoryList");
				logger.log(Status.INFO, "Lunch browser and open url");
				openBaseUrl("baseUrl");
				
				PageFactory.initElements(driver, this);
				
				logger.log(Status.INFO, "click Jd symbol ");
				goToFreelistingPage();
				
				boolean value=clickJdSymbol();
				
				try {
					Assert.assertTrue(value);
					System.out.println("Jd symbol is clicked");
					logger.log(Status.PASS, "Jd symbol is clicked");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Jd symbol is not clicked");
				}
				driver.close();
			}

			@AfterTest
			public void endReport() {
				report.flush();
			}

		}


