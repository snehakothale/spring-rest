package Utilities;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class DataProviderSource {

	@DataProvider(name = "Test Data")
	public static Object[][] getTestData(Method context) {
		String testName = context.getName();
		if ("verifyForCorrectWebPage".equals(testName))
			return new Object[][] { { "https://www.justdial.com/" } };
		else if ("verifySearchTextBoxDisplay".equals(testName))
			return new Object[][] { { "Search for anything, anywhere in India" } };
		else if ("verifyEnterCity".equals(testName))
			return new Object[][] { { "Pune", "Pune" } };
		else if ("verifyNavigateToCarWashServicePage".equals(testName))
			return new Object[][] { { "https://www.justdial.com/Pune/Car-Washing-Services-in-Pune-City/nct-10079017",
					"Pune", "Pune City", "Car Washing Services" } };
		else if ("verifyEnterArea".equals(testName))
			return new Object[][] { { "Pune", "Pune City" } };
		else if ("verifySelectedService".equals(testName))
			return new Object[][] { { "Car Washing Services" } };
		else if ("verifyRatingbtnDisplay".equals(testName))
			return new Object[][] { { "Pune", "Pune City", "Car Washing Services" } };
		else if ("VerifyUserCanGoToHomepage".equals(testName))
			return new Object[][] { { "Pune", "Pune City", "Car Washing Services", "https://www.justdial.com/" } };

		else if ("verifyFreeListingWebPage".equals(testName))
			return new Object[][] { { "Free Listing - Just Dial - List In Your Business For Free" } };
		else if ("verifyEnteredCompanyName".equals(testName))
			return new Object[][] { { "AB Machine", "AB Machine" } };
		else if ("verifyEnteredCompanyCity".equals(testName))
			return new Object[][] { { "AB Machine", "Pune", "Pune" } };
		else if ("verifySelectedTitle".equals(testName))
			return new Object[][] { { "AB Machine", "Pune", "Mr" } };
		else if ("verifyEnteredFirstName".equals(testName))
			return new Object[][] { { "AB Machine", "Pune", "Ram" } };
		else if ("verifyEnteredLastName".equals(testName))
			return new Object[][] { { "AB Machine", "Pune", "Ram", "Charan" } };
		else if ("verifyEnteredPhoneNumber".equals(testName))
			return new Object[][] { { "AB Machine", "Pune", "Ram", "Charan", "5985456366" } };
		else if ("verifyEnteredLandLineNumber".equals(testName))
			return new Object[][] { { "AB Machine", "Pune", "Ram", "Charan", "5985456366", "245658" } };

		else if ("verifyErrorOfInvalidPhoneNum".equals(testName))
			return new Object[][] {
					{ "AB Machine", "Pune", "Ram", "Charan", "5985456366", "Mobile can start with 6,7,8 or 9 only" } };
		else if ("verifyErrorOfInvalidName".equals(testName))
			return new Object[][] {
					{ "AB", "Pune", "9985456366", "Company Name should be 3 or more than 3 characters" } };
		else if ("verifyErrorOfNineDigitPhoneNum".equals(testName))
			return new Object[][] { { "AB Machine", "Pune", "Shamal", "Gupta", "985456366",
					"Mobile number should contain atleast 10 digits" } };
		else if ("verifyPopUpMessageForCompanyName".equals(testName))
			return new Object[][] { { " ", "Pune", "Shamal", "Gupta", "9876543210", "556633" } };
		else if ("verifyPopUpMessageForFirstname".equals(testName))
			return new Object[][] { { "AB Machine", "Pune", "123", "Gupta", "9876543210", "556633" } };
		else if ("verifyPopUpMessageForLastname".equals(testName))
			return new Object[][] { { "AB Machine ", "Pune", "Shamal", "123", "9876543210", "556633" } };
		else if ("verifyPopUpMessageForMobileNumber".equals(testName))
			return new Object[][] { { "AB Machine ", "Pune", "Shamal", "Gupta", "1234567890", "556633" } };

		return null;
	}

	@DataProvider(name = "Test Data1")
	public static Object[][] getTestData(ITestContext context) {
		String testName = context.getName();
		if ("Test Case1".equals(testName))
			return new Object[][] { { "https://www.justdial.com/" } };
		else if ("Test Case2".equals(testName))
			return new Object[][] { { "Search for anything, anywhere in India" } };
		else if ("Test Case3".equals(testName))
			return new Object[][] { { "Pune", "Pune" } };
		else if ("Test Case6".equals(testName))
			return new Object[][] {
					{ "https://www.justdial.com/Pune/Car-Washing-Services-in-Shivaji-Nagar/nct-10079017", "Pune",
							"Pune City", "Car Washing Services" } };
		else if ("Test Case4".equals(testName))
			return new Object[][] { { "Pune", "Pune City" } };
		else if ("Test Case5".equals(testName))
			return new Object[][] { { "Car Washing Services" } };
		return null;
	}
}
