package com.selenium.test;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumutility.SeleniumUtilities;

public class AddflightTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/login");
		driver.findElement(By.xpath("/html/body/app-root/app-login/body/div/div[2]/div/div/div/div/form/div[1]/input"))
				.sendKeys("Pavan");
		driver.findElement(By.id("password")).sendKeys("Pavan123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/body/div/div[2]/div/div/div/div/form/div[3]/input")).click();
		SeleniumUtilities.captureScreenShot(driver, "Login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"flightadd\"]")).click();
		driver.findElement(By.id("flightNumber")).sendKeys("12");
		driver.findElement(By.id("flightModel")).sendKeys("d2300");
		driver.findElement(By.id("carrierName")).sendKeys("SpiceJet");
		driver.findElement(By.id("seatCapacity")).sendKeys("299");
		driver.findElement(By.xpath("/html/body/app-root/app-addflight/div/div[2]/div[1]/div/div/form/button")).click();
		SeleniumUtilities.captureScreenShot(driver,"AddFlightSele");
		
		driver.findElement(By.xpath("/html/body/app-root/app-addflight/div/div[2]/div[2]/input")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-adminoperations/div/div[2]/div/button[3]")).click();
		SeleniumUtilities.captureScreenShot(driver, "ViewFlights");
		driver.findElement(By.xpath("/html/body/app-root/app-allflights/div[2]/table/tbody/tr[1]/td[6]/button")).click();
		driver.findElement(By.id("flightModel")).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.BACK_SPACE).perform();
		action.sendKeys(Keys.BACK_SPACE).perform();
		action.sendKeys(Keys.BACK_SPACE).perform();
		action.sendKeys("Test");
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys(Keys.BACK_SPACE).perform();
		action.sendKeys(Keys.BACK_SPACE).perform();
		action.sendKeys("20").perform();
		driver.findElement(By.xpath("/html/body/app-root/app-updateflight/div/div[2]/div[1]/div/div/form/div[5]/input")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-updateflight/div/div[2]/div[2]/input")).click();
		SeleniumUtilities.captureScreenShot(driver, "Update");
		driver.findElement(By.xpath("/html/body/app-root/nav/button")).click();
		SeleniumUtilities.captureScreenShot(driver, "logout");
		
		
		
		driver.quit();
		
	}

}
