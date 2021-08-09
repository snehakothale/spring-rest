package TestCases.FreeListingInvalidCases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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

public class EnteredNineDigitPhoneNum extends FreeListingPage{
	
	ExtentReports report = ExtendReport.getReportInstance("NineDigitPhoneNum");

	@Test(groups="Smoke Test",dataProvider = "Test Data", dataProviderClass = DataProviderSource.class)
	public void verifyErrorOfNineDigitPhoneNum(String companyName,String cityName,String firstName,String lastName,String phoneNum,String expected) throws InterruptedException, IOException {
		System.setOut(new PrintStream(
				new FileOutputStream(System.getProperty("user.dir")+"\\Output\\Invalid Number Report.txt")));
		
		ExtentTest logger = report.createTest("Entering Company name");
		
		logger.log(Status.INFO, "Lunch browser and open url");
		openBaseUrl("baseUrl");
		
		PageFactory.initElements(driver, this);
		
		logger.log(Status.INFO, "Opening the FreeListing page");
		FreeListing_btn.click();
		
		logger.log(Status.INFO, "Entering the Company Name");
		enterCompanyname(companyName);
		
		logger.log(Status.INFO, "Entering the Company city");
		CompanyCity.clear();
		
		selectCityname(cityName);
		
		logger.log(Status.INFO, "Entering the First Name");
		enterFirstname(firstName);
		
		logger.log(Status.INFO, "Entering the Last Name");
		enterLastname(lastName);
		
		logger.log(Status.INFO, "Entering the Phone Number");
		enterPhonenumber(phoneNum);
		
		logger.log(Status.INFO, "Submitting the FreeListing Form");
		submit_btn.click();
		WebElement err1=driver.findElement(By.xpath("//*[@id=\"fmb0Err\"]"));
		
		String msg=err1.getText();
		
		capturescreenshot("Error massage of 9 Digit PhoneNumber");
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
