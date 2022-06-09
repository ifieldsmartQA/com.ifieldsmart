package com.ifieldsmartTC_login;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ifieldsmart.utility.Utility;

public class createNewRfi_TC001 extends Utility {

	@Test(priority = 1)
//	Browser start
	public void initbrowser() {
		driverSetting();
	}

	@Test(priority = 2)
//	User login fields given in utility
	public void login() throws InterruptedException {
		starttestcse("Login user" + userName);

		elementfinder(objloginrepo.username).sendKeys(userName);
		logger.log(Status.INFO, "Username inserted");
		elementfinder(objloginrepo.password).sendKeys(pwd);
		logger.log(Status.INFO, "password inserted");
		elementfinder(objloginrepo.loginBtn).click();
		logger.log(Status.INFO, "login button clicked");

//		markstatus("pass", "User1 login sucessful");
		Thread.sleep(4000);
		// String exphomeurl = "https://apps.ifieldsmart.com/Indexdocs";

		String actualurl = driver.getCurrentUrl();

		if (actualurl.contains("projectlist")) {
			markstatus("pass", "Login successful for user " + userName);
		} else {
			markstatus("fail", "Login failed for user " + userName);
		}

	}

	@Test(priority = 3)
	public void projectCard1() {
		starttestcse("User click card1");

		elementfinder(objProjectsPage.projectsTab).click();
		logger.log(Status.INFO, "Projects Tab Opened");
		elementfinder(objProjectsPage.projectCard1).click();
		logger.log(Status.INFO, "Clicked on card");

		String actualurl = driver.getCurrentUrl();

		if (actualurl.contains("folders")) {
			markstatus("pass", "Login successful for user " + userName);
		} else {
			markstatus("fail", "Login failed for user " + userName);
		}
		starttestcse("Open RFI List");

		elementfinder(objFolderPage.mainBody).findElement(objFolderPage.rfiInFolderList).click();
		logger.log(Status.INFO, "RFI folder opened");

	}

	@Test(priority = 4)
	public void rfiListCreate() {
		starttestcse("User click on createRFI \"+\"");

		elementfinder(objRfiListPage.createRFI_Btn).click();
		logger.log(Status.INFO, "Clicked on createRFI");
		elementfinder(objProjectsPage.projectCard1).click();
		logger.log(Status.INFO, "Clicked on card");

		String actualurl = driver.getCurrentUrl();

		if (actualurl.contains("RFILIST")) {
			markstatus("pass", "Login successful for user " + userName);
		} else {
			markstatus("fail", "Login failed for user " + userName);
		}

	}

	@Test(priority = 5)
	public void createNewRfiForm() {
		String subject = "Automation Test";
		String RfiManager = "Onkar Ghule(NULL)";// select
		String ReceivedForm = "Chetan Mogal(BIM Engineering U.S. LLC.)";// select
		String drawing = "TestDrawing";
		String Spec_Section = "TestSpec_section";
		String Cost_impact = "Yes";// select
		String Visibility = "Public";// select
		String Due_date = "01/06/2022";// mm/dd/yy
		String Ball_in_court = "iFieldSmart Technology(iFieldSmart Technologies)";//
		String AssignTo = "AutomatedTest";
		String questionField = "It is automated Program";
		String FileNameField = "File Name Entered";
		String UrlField = "www.demourl.com";
		
		starttestcse("Create New RFI form details are filled");
		if (elementfinder(objCreateNewRfiPage.rfiIDPlaceholder).isEnabled()) {
			logger.log(Status.WARNING, "Clicked Rfi id field is Enabled");
		} else {
			logger.log(Status.INFO, "Clicked Rfi id field is Disable");
		}
		elementfinder(objCreateNewRfiPage.subjectPlacholder).sendKeys("Automation Test");
		logger.log(Status.INFO, "Subject name Entered");

	}

}
