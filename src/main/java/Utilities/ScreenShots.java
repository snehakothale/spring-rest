package Utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShots extends DriverSetup {
	public void capturescreenshot(String filename) throws InterruptedException, IOException {

		TakesScreenshot srcObj = (TakesScreenshot) driver;
		Thread.sleep(2000);
		File SrcFile = srcObj.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile,
				new File(System.getProperty("user.dir")+"\\Screenshots\\" + filename + ".png"));
	}

}
