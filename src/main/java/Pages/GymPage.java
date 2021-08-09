package Pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import Utilities.ExtendReport;

public class GymPage extends ExtendReport {
	@FindBy(xpath = "//*[@id=\"hotkeys_text_24\"]")
	public WebElement fitness;
	
	@FindBy(xpath = "//*[@title='Gym']")
	public static WebElement gym;
	
	@FindBy(xpath = "//*[@class=\"mm-listview\"]")
	public static WebElement gymCategory;
	
	@FindBy(how = How.CLASS_NAME, using = "mm-listview")
	public static List<WebElement> multipleelements_FindBy;
	
	@FindBy(xpath = "//*[@title=\"All Options\"]")
	public WebElement allOptions;

	@FindBy(xpath = "//*[@title=\"24 Hours Gyms\"]")
	public WebElement alltimeGym;
	
	@FindBy(xpath = "//*[@title=\"Calisthenic Gyms\"]")
	public WebElement calisthenicGym;
	
	@FindBy(xpath = "//*[@id=\"mnintrnlbnr\"]/ul/li[5]/a")
	public WebElement childrenGym;
	
	@FindBy(xpath = "//*[@title=\"Crossfit Gyms\"]")
	public WebElement crossfitGym;
	
	@FindBy(xpath = "//*[@title=\"Luxury Gyms\"]")
	public WebElement luxuryGym;
	
	@FindBy(xpath = "//*[@title=\"Men Gyms\"]")
	public WebElement menGyms;
	
	@FindBy(xpath = "//*[@title=\"Open Air Gyms\"]")
	public WebElement openAirGyms;
	
	@FindBy(xpath = "//*[@title=\"Unisex Gyms\"]")
	public WebElement unisexGyms;
	
	@FindBy(xpath = "//*[@title=\"Women Gyms\"]")
	public WebElement womenGyms;
	
	
//Lunch the browser and open justdial homepage
	public void openBaseUrl(String baseUrlKey) throws InterruptedException, IOException {
		
		invokeBrowser("chrome");
		driver.get("https://www.justdial.com/");
		//driver.get(prop.getProperty(baseUrlKey));
		capturescreenshot("HomePage");
	}

	//Click on fitness button
	public void fitness() throws InterruptedException, IOException {
		fitness.click();
	}

	//Click on fitness button
	public void gym() throws InterruptedException, IOException {
		gym.click();
	}
	
	//Check gym category List is available or not
	public void gymCategory() throws InterruptedException, IOException {
		gymCategory.isDisplayed();
		capturescreenshot("gymCategory");
	}
	
	public WebElement retriveSubMenu1()  {		
		return allOptions;		
	}
	
	public WebElement retriveSubMenu2()  {		
		return alltimeGym;		
	}
	public WebElement retriveSubMenu3() throws InterruptedException, IOException {
	
		return calisthenicGym;				
	}
	
	public WebElement retriveSubMenu4() throws InterruptedException, IOException {
		return childrenGym;	
	}
	
public WebElement retriveSubMenu5() throws InterruptedException, IOException {
	return crossfitGym;		
	}

public WebElement retriveSubMenu6() throws InterruptedException, IOException {
	return luxuryGym;
	}

public WebElement retriveSubMenu7() throws InterruptedException, IOException {
	return menGyms;
}

public WebElement retriveSubMenu8() throws InterruptedException, IOException {
	return openAirGyms;	
}

public WebElement retriveSubMenu9() throws InterruptedException, IOException {
		return unisexGyms;	
}

public WebElement retriveSubMenu10() throws InterruptedException, IOException {
	return womenGyms;	
}
	
public static void ElementListUsage()
{
	
	Iterator<WebElement> itr = multipleelements_FindBy.iterator();
    int i=1;	
	String value="";	
	while(itr.hasNext())
	{
		WebElement element= itr.next();//individual element
		value=element.getText();//individual value of each element
		System.out.println("Gym Sub-menu: "+value);			
	}	
}
}







