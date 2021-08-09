package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class ReadPropertiesFile {
	public Properties prop;

	@BeforeTest
	public Properties propread() {
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\configureJustdial.properties");
				prop.load(file);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		return prop;
	}

}
