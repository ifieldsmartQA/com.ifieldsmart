package com.ifieldsmart.repository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ifieldsmart.utility.Utility;

public class LoginPage extends Utility {

	WebDriver driver;


	// Constructor that will be automatically called as soon as the object of the
	// class is created

	public By username = By.xpath("//input[@id=\"email\"]");
	public By password = By.xpath("//input[@id=\"password\"]");
	public By viewPasswordBtn = By.xpath("//div[@id=\"sizing-addon1\"]");
	public By loginBtn = By.xpath("//button[@id=\"loginbtn\"]");
	public By navbarDropdownBtn = By.id("navbarDropdown");
	public By logoutBtn = By.xpath("//a[@onclick=\"logout()\"]");
	public By heading = By.xpath("//*[@id=\"logindiv\"]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}// Method to capture the page heading

	public String getHeading() {
		String head = driver.findElement(heading).getText();
		return head;
	}

	public void enterUsername(String userName) {
		
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(userName);

	}

	public void enterPassword(String pwd) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);

	}

	public void loginBtnClick() {
		driver.findElement(loginBtn).click();

	}

	public  String otpAction() {
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
		return otpRecived;

	}

	public void tearDown() throws InterruptedException {
		// markstatus("pass", "User1 login sucessful");
		Thread.sleep(4000);
		// String exphomeurl = "https://apps.ifieldsmart.com/Indexdocs";
		String actualURL = driver.getCurrentUrl();
		
		if (actualURL.contains("projectlist")) {
			markstatus("pass", "Login successful for user ");
		} else {
			markstatus("fail", "Login failed for user ");
		}

	}
}
