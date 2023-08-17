package pages;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ultis.FindProperties;

public class LoginPageActions {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	// constructor
	public LoginPageActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// wait until see user name field then enter information
	public void enterUserName(String name) throws IOException {
		
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath(FindProperties.locateProperty("username_xpath"))))).sendKeys(name);
		
	}
	
	// wait until see password field then enter information
	public void enterPassword(String pass) throws IOException {
		
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath(FindProperties.locateProperty("password_xpath"))))).sendKeys(pass);;
		
	}
	
	// wait until see login button then click
	public void clickLoginButton() throws IOException {
		try {
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath(FindProperties.locateProperty("login_button_xpath"))))).click();
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
			Assert.fail("Login button not found!");
		}
		
	}
	
	
	
	
}
