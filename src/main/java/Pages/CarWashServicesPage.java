package Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CarWashServicesPage extends HomePage{
	@FindBy(xpath = "//*[@id='distdrop_rat']/span")
	WebElement rating_btn;

	@FindBy(xpath = "//*[@id='distdrop_rat']")
	WebElement rating_btnSearch;

	@FindBy(xpath="//*[@id=\"best_deal_div\"]/section/span")
	WebElement popUp;

	@FindBy(xpath="//ul[@class='rsl col-md-12 padding0']/li")
	public static List<WebElement> carWashServices;
 
	@FindBy(xpath="//*[@id='srchpagination']")
	public static WebElement down;
	
	@FindBy(xpath="/html/body/div[2]/header/section/div/div[1]/div[1]/a/span")
	public static WebElement home;
	
	
	public boolean checkRating_btn() throws InterruptedException, IOException{
		capturescreenshot("Check for Ratings button");
        return rating_btn.isDisplayed();
	}

	public boolean selectRating_btn() throws InterruptedException, IOException {
		driver.manage().deleteAllCookies();
        Thread.sleep(5000);
        popUp.click();
		boolean value=rating_btn.isEnabled();
		rating_btnSearch.click();
		capturescreenshot("To see if Services sort as Ratings");
		Thread.sleep(5000);
		popUp.click();
		return value;
	}

	public void scrollDown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}


	public List<WebElement> SortListByVotesAndRating() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(3000);
		List<WebElement> listByVotes = new ArrayList<>();
        int size=carWashServices.size();
		for(int i=1;i<=size;i++) {
            String vote=driver.findElement(By.xpath("//li["+i+"]/section[1]/div[1]/section[1]/div[1]/p[1]/a[1]/span[3]")).getText();
			String numOfVotes=vote.replaceAll("[^0-9]","");		 
			int vot = Integer.parseInt(numOfVotes);
            String ratingString=driver.findElement(By.xpath("//li["+i+"]/section[1]/div[1]/section[1]/div[1]/p[1]/a[1]/span[1]")).getText();
			Float rating=Float.parseFloat(ratingString); 
			if(vot>20 && rating>4.0) {
				listByVotes.add(carWashServices.get(i-1) );
				}
			}
		return listByVotes;
	}

	public static String extractPhoneNumber(List<WebElement> listByVotes,int i) {
		String m="";
		try{
			for(int j=1;j<=16;j++) {
                String symbalS=listByVotes.get(i).findElement(By.xpath(".//section[1]/div[1]/section[1]/div[1]/p[2]/span[1]/a[1]/span["+j+"]")).getAttribute("class");
				String symbal=symbalS.substring(14);
				switch (symbal) {
				case "dc": 
					m+="+";
					break;
				case "fe": 
					m+="(";
					break;

				case "hg": 
					m+=")";
					break;

				case "ba": 
					m+="-";
					break;

				case "acb": 
					m+="0";
					break;

				case "yz": 
					m+="1";
					break;

				case "wx": 
					m+="2";
					break;

				case "vu": 
					m+="3";
					break;

				case "ts": 
					m+="4";
					break;

				case "rq": 
					m+="5";
					break;

				case "po": 
					m+="6";
					break;

				case "nm": 
					m+="7";
					break;

				case "lk": 
					m+="8";
					break;

				case "ji": 
					m+="9";
					break;
				default:
					}
				}
			}catch(Exception e) {
			m=" ";
		}
		return m;
	}

	public TreeSet<String> TopServices(List<WebElement> listByVotes) {
		int size2=listByVotes.size();
		TreeSet<String> ratingSet = new TreeSet<String>();
        for(int i=0;i<size2;i++) {
			String name=listByVotes.get(i).findElement(By.xpath(".//section[1]/div[1]/section[1]/div[1]/h2[1]/span[1]/a[1]/span[1]")).getText();
            String a=listByVotes.get(i).findElement(By.xpath(".//section[1]/div[1]/section[1]/div[1]/p[1]/a[1]/span[1]")).getText();
            String m=CarWashServicesPage.extractPhoneNumber(listByVotes, i);
            ratingSet.add(a+"\n"+name+"\n"+m);
            }
        return ratingSet;
        }

	public String[] topFiveServices(TreeSet<String> ratingSet) {
		Set<String> descRating=ratingSet.descendingSet();
		String arr[]=new String[5];
		int l=0;
		for(String x:descRating) {
			arr[l]=x;
			System.out.println(arr[l].substring(3));
			l++;
			if(l==5) break;
			System.out.println("");
		}
		return arr;
	}
	
	public void goToHomePage() throws InterruptedException, IOException {
		home.click();
		capturescreenshot("To see User Navigate to home Page");
	}	

}
