package seleniumutility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SeleniumUtilities  {
	
	WebDriver driver;
	public static void captureScreenShot(WebDriver driver2,String screenShotName) {
		try {
			TakesScreenshot ts=(TakesScreenshot)driver2;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,new File("src/test/resources/ScreenShots/"+screenShotName+".png"));
			//System.out.println("ScreenShot Taken");
			
		}catch(Exception e) {
			//System.out.println("Exception during taking screenshot ");
			
		}
		
	}
}


