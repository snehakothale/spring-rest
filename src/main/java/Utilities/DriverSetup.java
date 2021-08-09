package Utilities;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup extends ReadPropertiesFile {

	public static WebDriver driver;

	public static WebDriver invokeBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver", "C:\\Program
			// Files\\Google\\Chrome\\Application\\chrome.exe");
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
			HashMap<String, Object> profile = new HashMap<String, Object>();
			HashMap<String, Object> prefs = new HashMap<String, Object>();

			contentSettings.put("notifications", 2);
			contentSettings.put("geolocation", 2);
			profile.put("managed_default_content_settings", contentSettings);
			prefs.put("profile", profile);
			options.setExperimentalOption("prefs", prefs);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			System.out.println("error");
		}
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		return driver;
	}
}
