package ultis;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakePicture {
	
	public static void captureSceenShot(WebDriver driver, String name)  {
		
		try {
			// get date time to put into name
			Calendar c =  Calendar.getInstance();
			
			// cast type from webdriver to takesscreenshot
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			
			// take temporary screenshot as file
			File f = screenshot.getScreenshotAs(OutputType.FILE);
			
			// create path for screen shot, but no picture yet
			String filePath = "./screenshots//" + name + " "+ c.getTime().toString().replace(":", "_").replace(" ", "_") + ".png";
			File fs = new File(filePath);
			
			// copy taken screen shot to path file
			FileUtils.copyFile(f, fs);
		}
		catch(Exception e) {
			System.out.println("Unable to take screen shot!");
			e.printStackTrace();
		}
		
	}
	
	
}
