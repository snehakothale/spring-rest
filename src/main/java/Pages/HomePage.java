package Pages;


import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utilities.ExtendReport;


public class HomePage extends ExtendReport {

	@FindBy(xpath = "//*[@id='city']")
	public WebElement cityTextBox;

	@FindBy(xpath = "//a[@id='Pune']")
	public static WebElement selectedCity;

	@FindBy(xpath = "//*[@id='srchbx']")
	public WebElement searchTextBox;

	@FindBy(xpath = "//*[@id='insrch']")
	WebElement enterArea;

	@FindBy(xpath = "//li[@id='Pune City']")
	public static WebElement selectedarea;

	@FindBy(xpath = "//ul[@id='auto']/li[1]")
	public static WebElement firstsugg;

	@FindBy(xpath = "//span[@class='green-box']")
	public static List<WebElement> ratingsGreenBox;
	
	public String carWashPageUrl;

	
//Lunch the browser and open justdial homepage
	public void openBaseUrl(String baseUrlKey) throws InterruptedException, IOException {
		invokeBrowser("chrome");
		//driver.get(prop.getProperty(baseUrlKey));
		driver.get("https://www.justdial.com/");
		capturescreenshot("HomePage");
		}

//Select Pune city location in city field
	public void selectCity(String city) throws InterruptedException, IOException {
		cityTextBox.click();
		cityTextBox.sendKeys(city);
		Thread.sleep(3000);
		selectedCity.click();
		capturescreenshot("City");
		driver.navigate().refresh();
		String ActualText = cityTextBox.getAttribute("placeholder");
		}
	
//Select Shivaji Nagar in enter area field
	public void enterArea(String area) throws InterruptedException, IOException {
		searchTextBox.click();
		enterArea.click();
		enterArea.sendKeys(area);
		selectedarea.click();
		capturescreenshot("Area");
	}
//Select car wash services in searchtextbox
	public void selectService(String searchText) throws InterruptedException, IOException {
		searchTextBox.click();
		searchTextBox.sendKeys(searchText);
		firstsugg.click();
		capturescreenshot("Service");
	}
	
//Navigate to the car wash service page for referred city and selected area
	public void goToCarWashServicesPage(String city, String area, String searchText) throws InterruptedException, IOException {
		cityTextBox.click();
		cityTextBox.sendKeys(city);
		Thread.sleep(3000);
		selectedCity.click();
		searchTextBox.click();
		enterArea.click();
		enterArea.sendKeys(area);
		selectedarea.click();
		searchTextBox.click();
		searchTextBox.sendKeys(searchText);
		firstsugg.click();
		capturescreenshot("Car Service Page");
	    carWashPageUrl= driver.getCurrentUrl();
	}

}