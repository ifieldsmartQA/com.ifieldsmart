package com.ifieldsmart.repository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ifieldsmart.utility.Utility;



public class OtpPage extends Utility {
	WebDriver driver;
	public String userName = "omkrushana@vcsbim.com";
	public String pwd = "if#2022";

	public By otpUsername = By.id("emailid");

	public By otpOtp = By.id("otp");

	public By otpConfirm = By.id("confirm");

	public OtpPage(WebDriver driver) {
		this.driver = driver;

	}

//	public void otpUsername() {
//		driver.findElement(otpUsername).sendKeys(userName);
//		
//	}

	public void otpOtp(String otpRecived) {
		driver.findElement(otpOtp).sendKeys(otpRecived);

	}

	public void otpConfirm() {
		driver.findElement(otpConfirm).click();
	}
	
	public void TabChange() throws AWTException {
		Robot rb = new Robot();

		// Press control keyboard key
		rb.keyPress(KeyEvent.VK_CONTROL);

		// Press T keyboard key
		rb.keyPress(KeyEvent.VK_T);

		rb.keyRelease(3);
	}
	
	public String webmailOtp() throws AWTException {
//		String currentHandle= driver.getWindowHandle();
		
		
		
//	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//	    driver.switchTo().window(tabs2.get(1));
	    
//driver.switchTo().
		//driver.get("https://vcsbim.com/webmail");
		driver.manage().window().maximize();

		driver.findElement(By.id("user")).clear();
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
		WebElement otpEl = driver.switchTo().frame(driver.findElement(By.id("messagecontframe")))
				.findElement(By.xpath("//*[contains(@style,\"24px/19px\")]"));
//		WebElement otpEl = driver.findElement(By.xpath("//*[contains(@style,\"24px/19px\")]"));

		String otpRecived = otpEl.getText();

		return otpRecived;

	}

}
