package com.ifieldsmart.testCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ifieldsmart.repository.LoginPage;
import com.ifieldsmart.repository.ProjectsPage;
import com.ifieldsmart.utility.Utility;

public class loginUser1ProjectListTC001 extends Utility {
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
		
		
		//driver.close();
	}

	@Test(priority = 3)
	public void projectCard1() throws InterruptedException {
		starttestcse("User click card1");

//		public HomePage objhomerepo = new HomePage();
		ProjectsPage objProjectsPage = new ProjectsPage(driver);
		objProjectsPage.projectsTabClick();
		logger.log(Status.INFO, "Projects Tab Opened");
		objProjectsPage.projectsCard1Click();
		logger.log(Status.INFO, "Clicked on card");
		Thread.sleep(2000);

	}

}
