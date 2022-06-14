package com.ifieldsmart.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ifieldsmart.utility.Utility;

public class LoginPage extends Utility {

	WebDriver driver;
	public String userName = "omkrushana@vcsbim.com";
	public String pwd = "if#2022";

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

	public void enterUsername(String Username) {
		driver.findElement(username).sendKeys(userName);

	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);

	}

	public void loginBtnClick() {
		driver.findElement(loginBtn).click();

	}

	public  void otpAction() {
		driver.navigate().to("https://vcsbim.com:2096/cpsess5932861654/3rdparty/roundcube/?_task=mail&_mbox=INBOX");
		
			driver.findElement(By.id("user")).sendKeys("omkrushana@vcsbim.com");
			driver.findElement(By.id("pass")).sendKeys("if#2022");
			driver.findElement(By.id("login_submit")).click();

		

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
