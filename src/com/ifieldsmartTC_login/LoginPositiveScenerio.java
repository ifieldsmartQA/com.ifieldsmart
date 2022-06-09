package com.ifieldsmartTC_login;

import java.util.ArrayList;

import org.testng.annotations.Test;


import com.ifieldsmart.utility.Utility;

public class LoginPositiveScenerio extends Utility {
	

	ArrayList<String> usernames = dataread("D:\\Omkrushana\\testfile1.xlsx", "Sheet3", 0);
	ArrayList<String> passwords = dataread("D:\\Omkrushana\\testfile1.xlsx", "Sheet3", 1);
	String exphomeurl = "https://apps.ifieldsmart.com/#/";

	@Test(priority = 1)
	public void initbrowser() {
		driverSetting();
	}

	@Test(priority = 2)
	public void login() throws InterruptedException {
		starttestcse("Login Positive Scenario1");

		elementfinder(objloginrepo.username).sendKeys(userName);
		elementfinder(objloginrepo.password).sendKeys(pwd);
		elementfinder(objloginrepo.loginBtn).click();
		Thread.sleep(2000);

		driver.close();
		markstatus("pass", "User1 login sucessful");
		String actualurl = driver.getCurrentUrl();

		if (actualurl.contains("https://apps.ifieldsmart.com/Indexdocs")) {
			markstatus("pass", "Login successful for user " + userName);
		} else {
			markstatus("fail", "Login failed for user " + userName);
		}

	}

	@Test(priority = 3)
	public void initbrowser2() {
		driverSetting();
	}

	@Test(priority = 4)
	public void login1() throws InterruptedException {
		starttestcse("Login Positive Scenario2");
		String userName = "Sumeetgm89@gmail.com";
		String pwd = "password@123";

		elementfinder(objloginrepo.username).sendKeys(userName);
		elementfinder(objloginrepo.password).sendKeys(pwd);
		elementfinder(objloginrepo.loginBtn).click();
		Thread.sleep(2000);
		driver.close();
		markstatus("pass", "User2 login sucessful");
		String actualurl = driver.getCurrentUrl();

		if (actualurl.contains("https://apps.ifieldsmart.com/Indexdocs")) {
			markstatus("pass", "Login successful for user " + userName);
		} else {
			markstatus("fail", "Login failed for user " + userName);
		}

	}

//	@Test(priority = 2)
//	public void login() throws InterruptedException {
//		starttestcse("Login positive scenario");
//
//		for (int i = 0; i < usernames.size(); i++) {
//			elementfinder(objloginrepo.username).sendKeys(usernames.get(i));
//			elementfinder(objloginrepo.password).sendKeys(passwords.get(i));
//			elementfinder(objloginrepo.viewPasswordBtn).click();
//			elementfinder(objloginrepo.loginBtn).click();
//			Thread.sleep(2000);
//			driver.close();
//
////			String actualurl = driver.getCurrentUrl();
////
////			if (actualurl.equals(exphomeurl)) {
////				markstatus("pass", "Login successful for user " + usernames.get(i));
////			} else {
////				markstatus("fail", "Login failed for user " + usernames.get(i));
////			}
////			elementfinder(objhomerepo.menu).click();
////			elementfinder(objhomerepo.loginBtn).click();
//		}}

}
