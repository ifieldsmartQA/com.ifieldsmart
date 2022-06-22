package com.ifieldsmart.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebAPI {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Omkrushana\\Selenium\\Selenium\\Installation\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://vcsbim.com/webmail");
		driver.manage().window().maximize();

		driver.findElement(By.id("user")).sendKeys("omkrushana@vcsbim.com");
		driver.findElement(By.id("pass")).sendKeys("if#2022");
		driver.findElement(By.id("login_submit")).click();
		Duration oneHours = Duration.ofHours(1);
		WebDriverWait wait = new WebDriverWait(driver, oneHours);
		WebElement firstEmail = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("iFieldsmart Login OTP")));// *[@title=\"Unread
																											// \"][1]
		firstEmail.click();
		driver.switchTo().defaultContent();
		WebElement otpEl = driver.switchTo().frame(driver.findElement(By.id("messagecontframe"))).findElement(By.xpath("//*[contains(@style,\"24px/19px\")]"));
//		WebElement otpEl = driver.findElement(By.xpath("//*[contains(@style,\"24px/19px\")]"));

		String otpRecived = otpEl.getText();
		driver.close();
		System.out.println(otpRecived);
	}
}
