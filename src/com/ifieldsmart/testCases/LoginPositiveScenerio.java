package com.ifieldsmart.testCases;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ifieldsmart.repository.LoginPage;
import com.ifieldsmart.repository.OtpPage;
import com.ifieldsmart.utility.Utility;

public class LoginPositiveScenerio extends Utility {

	ArrayList<String> usernames1 = dataread("D:\\Omkrushana\\testfile1.xlsx", "Sheet3", 0);
	ArrayList<String> passwords1 = dataread("D:\\Omkrushana\\testfile1.xlsx", "Sheet3", 1);
	String exphomeurl = "https://apps.ifieldsmart.com/#/";
	public String userName = "omkrushana@vcsbim.com";
	public String pwd = "if#2022";

	@Test(priority = 1)
	public void initbrowser() {
		driverSetting();
	}

	@Test(priority = 2)
	public void login() throws InterruptedException {
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

		// driver.close();
		String actualURL = driver.getCurrentUrl();

	if (actualURL.contains("sentotp")) {

			OtpPage objOtpPage = new OtpPage(driver);
			objOtpPage.webmailOtp();

//			objOtpPage.otpUsername();
			objOtpPage.otpOtp(objOtpPage.webmailOtp());
			objOtpPage.otpConfirm();
		}

	}

}
