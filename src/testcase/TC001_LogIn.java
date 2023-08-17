package testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;
import data_driven.GetData;
import initDriver.InitialDriver;
import ultis.FindProperties;
import ultis.TakePicture;

public class TC001_LogIn extends InitialDriver {
	
	@Test(dataProvider = "example_data", dataProviderClass = GetData.class)
	public void SuccessfullLogin(String name, String pass) throws IOException {
		
		// enter user name and password, click login, then verify login successful
		login.enterUserName(name);
		login.enterPassword(pass);
		login.clickLoginButton();
		
		assertTrue(driver.findElement(By.xpath(FindProperties.locateProperty("welcome_message_xpath"))).getText().contains(name),
				"Wrong user name or password!");
		assertNotEquals(driver.getTitle(), "Guru99 Bank Home Page", "Wrong username or password!");
		
		try {
			
			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), "User or Password is not valid","Wrong message when enter wrong username or password.");
			alert.accept();
							
		}
		catch(NoAlertPresentException e) {
			
			assertTrue(driver.findElement(By.xpath(FindProperties.locateProperty("welcome_message_xpath"))).getText().contains(name)
					,"Welcome message is not right!");
			
			TakePicture.captureSceenShot(driver, name);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
/*	@Test()
	public void SuccessfullLogin() throws IOException, InterruptedException {
		
		// enter user name and password, click login, then verify login successful
		login.enterUserName("45335435gdfgfdgdfg");
		login.enterPassword("gytEdAd");
		login.clickLoginButton();
		//Thread.sleep(3000);
		try {
			
			Alert alert = driver.switchTo().alert();
			assertEquals(alert.getText(), "User or Password is not valid","Wrong message when enter wrong username or password.");
			alert.accept();
		
		}
		catch(Exception e) {
			
			assertTrue(driver.findElement(By.xpath(FindProperties.locateProperty("welcome_message_xpath"))).getText().contains("mngr506560")
					,"Welcome message is now right!");
			
			
		}
		
		//assertNotEquals(driver.getTitle(), "Guru99 Bank Home Page", "Wrong username or password!");
	
	} */
	
	
	
	
	
	
	
	
	
}
