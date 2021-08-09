package TestCases.FreeListingInvalidCases;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Pages.FreeListingPage;
import Utilities.DataProviderSource;
import Utilities.ExtendReport;

public class EnteredInvalidName extends FreeListingPage{
	
	ExtentReports report = ExtendReport.getReportInstance("InvalidName");

	@Test(groups="Regression Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyErrorOfInvalidName(String companyName,String cityName,String phoneNum,String expected) throws InterruptedException, IOException {
		
		ExtentTest logger = report.createTest("Entering Company name");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
		
		logger.log(Status.INFO, "Opening the FreeListing page");
		FreeListing_btn.click();
		
		logger.log(Status.INFO, "Entering the Company name");	
		enterCompanyname(companyName);
		
		CompanyCity.clear();
		
		logger.log(Status.INFO, "Entering the Company city");
		selectCityname(cityName);
		
		logger.log(Status.INFO, "Entering the Phone Number");
		enterPhonenumber(phoneNum);
		
		logger.log(Status.INFO, "Submitting the FreeListing Form");
		submit_btn.click();
		
	    WebElement err=driver.findElement(By.xpath("//*[@id=\"fcoe\"]"));
	    
		String msg=err.getText();
		
		capturescreenshot("Error massage of Invalid CompanyName");
		
		try {
			Assert.assertTrue(msg.equals(expected));
			System.out.println("Error massage is : "+ msg);
			logger.log(Status.PASS, "Error massage is displayed in FreeListing page");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error massage is not displayed");
		}
		driver.close();
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}
}
