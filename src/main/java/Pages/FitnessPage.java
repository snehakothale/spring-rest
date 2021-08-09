package Pages;


import java.io.IOException;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class FitnessPage extends FreeListingPage  {

	@FindBy(xpath = "//*[@class='lgnjdhdr']")
	public WebElement JdSymbol;

	@FindBy(xpath = "//*[@class='hotkeys-list ']")
	public static List<WebElement> categoryList;

	@FindBy(xpath = " //*[@id='hotkeys_text_24']")
	public WebElement fitnessOption;


	@FindBy(xpath = "//*[@class='mm-listview mm-lstex']")
	public static List<WebElement> fitnessCategories;
	
	
	@FindBy(xpath = "//*[@title='Gym']")
	public static WebElement gymOption;

	
	    //Lunch the browser and open justdial homepage
		public void openBaseUrl(String baseUrlKey) throws InterruptedException, IOException {
			invokeBrowser("chrome");
			//driver.get(prop.getProperty(baseUrlKey));
			driver.get("https://www.justdial.com/");
			capturescreenshot("FitnessPage");
		}
	    //To check the Jd Symbol is clickable or not
	    public boolean clickJdSymbol() throws InterruptedException, IOException {
		    Actions action=new Actions(driver);
			action.moveToElement(JdSymbol).build().perform();
			boolean value=JdSymbol.isEnabled();
			JdSymbol.click();
			capturescreenshot("JdSymbol");
			return value;
		}
	    //To Check categoryList is Displayed or not
		public boolean categoryLists() throws InterruptedException, IOException {
			boolean value=categoryList.isEmpty();
			capturescreenshot("categoryList");
			return value;
		}
	    //To Check the fitness option is available or not
		public boolean fitnessOptions() throws InterruptedException, IOException {
			boolean value=fitnessOption.isDisplayed();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scroll(0,2000)");
			Actions action=new Actions(driver);
			action.moveToElement(fitnessOption).build().perform();
			capturescreenshot("fitnessOption");
			return value;
		}
        //To Check functionality of fitness option
		public boolean fitnessfunctionality() throws InterruptedException, IOException {
			boolean value=fitnessOption.isEnabled();
			fitnessOption.click();
			capturescreenshot("fitnessFunctionality");
			return value;
		}
        //To Check fitness categoryList is avialable or not
		public boolean fitnessCategory() throws InterruptedException, IOException {
			boolean value=fitnessCategories.isEmpty();
			capturescreenshot("fitnessCategory");
			return value;
		}
        //To check gym option is available or not
		public boolean gymOptions() throws InterruptedException, IOException {
			boolean value=gymOption.isDisplayed();
			Actions action=new Actions(driver);
			action.moveToElement(gymOption).build().perform();
			capturescreenshot("gymOption");
			return value;
		}

}
