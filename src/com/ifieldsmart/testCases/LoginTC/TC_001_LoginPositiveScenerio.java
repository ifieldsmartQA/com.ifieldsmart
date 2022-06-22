package com.ifieldsmart.testCases.LoginTC;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ifieldsmart.repository.LoginPage;
import com.ifieldsmart.utility.Utility;

public class TC_001_LoginPositiveScenerio extends Utility {

//	ArrayList<String> usernames1 = dataread("D:\\Omkrushana\\testfile1.xlsx", "Sheet3", 0);
//	ArrayList<String> passwords1 = dataread("D:\\Omkrushana\\testfile1.xlsx", "Sheet3", 1);
	String exphomeurl = "https://apps.ifieldsmart.com/#/";
	public String userName = "omkrushana@vcsbim.com";
	public String pwd = "if#2022";

	@Test(priority = 1)
	public void initbrowser() {
		driverSetting();

		driver.manage().deleteAllCookies();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "iFBIM - iFieldsmart";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

	@Test(priority = 2)
	public void login() throws InterruptedException, AWTException {
		starttestcse("Login Positive Scenerio Test Case");
		LoginPage loginpage = new LoginPage(driver);

		// Enter username & password
		loginpage.enterUsername(userName);
		logger.log(Status.INFO, "Username inserted");
		loginpage.enterPassword(pwd);
		logger.log(Status.INFO, "Password inserted");
		// Click on Login button
		loginpage.loginBtnClick();
		logger.log(Status.INFO, "login button clicked");
		loginpage.tearDown();
		Thread.sleep(4000);
		Boolean actualelement = driver.findElement(By.xpath("//span[text()='Omkrushana']")).isDisplayed();
		Boolean expected = true;
		Assert.assertEquals(actualelement, expected);
		
		

//	Otp functionality script pending	
//		OtpPage objOtpPage = new OtpPage(driver);
//		if (actualURL.contains("sentotp")) {
//
//			objOtpPage.TabChange();
//			
//
//		}
//		
//		objOtpPage.webmailOtp();
//
////		objOtpPage.otpUsername();
//		objOtpPage.otpOtp(objOtpPage.webmailOtp());
//		objOtpPage.otpConfirm();
		
		driver.close();
	}

}
