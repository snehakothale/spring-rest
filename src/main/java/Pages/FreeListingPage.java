package Pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utilities.ExtendReport;

public class FreeListingPage extends ExtendReport { 
	
		@FindBy(xpath="//*[@id=\'h_flist\']")
		public WebElement FreeListing_btn ;
		
		@FindBy(id="fcom")
		public WebElement CompanyName ;
		
		@FindBy(xpath="//*[@id=\"fcoe\"]")
		public WebElement companyNameError;
		 
		@FindBy(id="flcity")
		public WebElement CompanyCity ;
		
		@FindBy(xpath="//span[@class=\"slct\"]")  
		public WebElement Title_dropdown ;
				
		@FindBy(xpath="//*[@id=\"salopt\"]/li[1]/a")  
		public WebElement selectTitle ;
		
		@FindBy(xpath="//*[@id=\"ttlbl\"]")
		public static WebElement title;
		
		@FindBy(xpath="//*[@id=\"salopt\"]/li[1]/a")
		public static WebElement selectTitle1;

		  
		@FindBy(xpath="//*[@id=\'fname\']")
		public WebElement firstName ;
		
		@FindBy(id="fnameErr")
		public WebElement firstNameError;
		
		@FindBy(xpath="//*[@id=\'lname\']")
		public WebElement lastName ;
		
		@FindBy(id="lnameErr")
		public WebElement lastNameError;
		  
		@FindBy(xpath="//*[@id=\'fmb0\']")
		public WebElement phoneNumber ;
		
		@FindBy(id="am1")
		public WebElement addMobNo;
		
		@FindBy(xpath="//span[@class=\"almsg flmierr\"]")
		public WebElement mobNoError;
		
		@FindBy(xpath="//*[@id=\'fmb0\']")
		public WebElement LandlineNumber ;
		
		@FindBy(id="ap0")
		public WebElement addLLNo;
		  
		@FindBy(xpath="//*[@id=\'add_div0\']/div[3]/button")
		public WebElement submit_btn ;
		
		
        //Lunch the browser and open justdial homepage
		public void openBaseUrl(String baseUrlKey) throws InterruptedException, IOException {
			invokeBrowser("chrome");
			driver.get("https://www.justdial.com/");
			//driver.get(prop.getProperty(baseUrlKey));
		}
		
		//open the FreeListing webpage
		public void goToFreelistingPage() throws InterruptedException, IOException {
			FreeListing_btn.click();
			Thread.sleep(3000);	
			capturescreenshot("FreeListingPage");
			}
		
		//Enter company name in enter Company name field
		public void enterCompanyname(String companyname) throws InterruptedException, IOException {
			CompanyName.clear();
			CompanyName.sendKeys(companyname);
		}
		
		//Select Pune in city field
		public void selectCityname(String cityName) throws InterruptedException, IOException {
			CompanyCity.clear();
			CompanyCity.sendKeys(cityName);
			Thread.sleep(3000);		
			}
		
		//Select Title in Title dropdown
		public void selectTitle() throws InterruptedException, IOException {
			Title_dropdown.click();
			selectTitle.click();
		}
		
		public WebElement title() {
			return title;
		}
		
		public WebElement selectTitle1() {
			return selectTitle1;
		}
	
		//Enter First name in enter Firstname field
		public void enterFirstname(String firstname) throws InterruptedException, IOException {
			firstName.click();
			firstName.clear();
			firstName.sendKeys(firstname);
			capturescreenshot("Entered First Name");
			Thread.sleep(3000);	
			}
		
		//Enter Last name in enter Lastname field
		public void enterLastname(String lastname) throws InterruptedException, IOException {
			lastName.click();
			lastName.sendKeys(lastname);
			Thread.sleep(3000);	
		}
		
		//enter the phone number
		public void enterPhonenumber(String phonum) throws InterruptedException, IOException {
			phoneNumber.click();
			phoneNumber.sendKeys(phonum);
			Thread.sleep(2000);	
		}
		
		//enter the landline number
		public void enterLandlinenumber(String landlineNum) throws InterruptedException, IOException {
			LandlineNumber.click();
			LandlineNumber.sendKeys(landlineNum);
			Thread.sleep(3000);	
		}
		
		public void submitForm() throws InterruptedException, IOException {
			submit_btn.click();
			capturescreenshot("Error Massage");
		}
}
