package com.ifieldsmartTC_login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
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
		 String actualurl = driver.getCurrentUrl();

		if (actualurl.contains("projectlist")) {
			markstatus("pass", "Login successful for user " + userName);
		} else {
			markstatus("fail", "Login failed for user " + userName);
		}

	}

	@Test(priority = 3)
	public void projectCard1() throws InterruptedException {
		starttestcse("User click card1");
		Thread.sleep(4000);
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
		starttestcse("User click on createRFI ");

		elementfinder(objRfiListPage.createRFI_Btn).click();
		logger.log(Status.INFO, "Clicked on createRFI");
//		elementfinder(objProjectsPage.projectCard1).click();
//		logger.log(Status.INFO, "Clicked on card");
		markstatus("pass", "Login successful for user " );
		String actualurl = driver.getCurrentUrl();
		markstatus("pass", "Login successful for user " + actualurl);
//		if (actualurl.contains("CreateRFI")) {
//			markstatus("pass", "Login successful for user " + userName);
//		} else {
//			markstatus("fail", "Login failed for user " + userName);
//		}

	}

	@Test(priority = 5)
	public void createNewRfiForm() throws InterruptedException {
		String subject = "Automation Test";
		String RfiManager = "Onkar Ghule(NULL)";// select
		String ReceivedForm = "Chetan Mogal(BIM Engineering U.S. LLC.)";// select
		String drawing = "TestDrawing";
		String Spec_Section = "012119";
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
			logger.log(Status.WARNING, "Checked Rfi id field is Enabled");
		} else {
			logger.log(Status.INFO, "Checked Rfi id field is Disable");
		}

		elementfinder(objCreateNewRfiPage.subjectPlacholder).sendKeys(subject);
		logger.log(Status.INFO, "Subject name Entered");

		Select rfiManager = new Select(elementfinder(objCreateNewRfiPage.rfi_ManagerSelect));
		rfiManager.selectByVisibleText(RfiManager);

//		elementfinder(objCreateNewRfiPage.rfi_ManagerSelect).sendKeys(RfiManager);
//		logger.log(Status.INFO, "RFI Manager selected");

		if (elementfinder(objCreateNewRfiPage.createdByPlaceholder).isEnabled()) {
			logger.log(Status.WARNING, "Checked Rfi id field is Enabled");
		} else {
			logger.log(Status.INFO, "Checked Rfi id field is Disable");
		}

		elementfinder(objCreateNewRfiPage.receivedFromSelect).sendKeys(ReceivedForm);
		logger.log(Status.INFO, "ReceivedForm Entered");

		elementfinder(objCreateNewRfiPage.drawingPlaceholder).sendKeys(drawing);
		logger.log(Status.INFO, "drawing Entered");

		elementfinder(objCreateNewRfiPage.specSection).sendKeys(Spec_Section);
		elementfinder(objCreateNewRfiPage.subjectPlacholder).sendKeys(Keys.TAB);
		logger.log(Status.INFO, "specSection Entered");

		elementfinder(objCreateNewRfiPage.costImpactSelect).sendKeys(Cost_impact);
		logger.log(Status.INFO, "Cost_impact Entered");

		elementfinder(objCreateNewRfiPage.visibilitySelect).sendKeys(Visibility);
		logger.log(Status.INFO, "Visibility Entered");

		if (elementfinder(objCreateNewRfiPage.dateInitiatedPlaceholder).isEnabled()) {
			logger.log(Status.WARNING, "Checked Rfi id field is Enabled");
		} else {
			logger.log(Status.INFO, "Checked Rfi id field is Disable");
		}

		elementfinder(objCreateNewRfiPage.dueDatePlaceholder).sendKeys(Due_date);// mm/dd/yyyy
		logger.log(Status.INFO, "Due_date Entered");

		elementfinder(objCreateNewRfiPage.ballInCourtSelect).sendKeys(Ball_in_court);
		logger.log(Status.INFO, "Ball_in_court Entered");

		elementfinder(objCreateNewRfiPage.assignToPlaceholder).sendKeys(AssignTo);
		logger.log(Status.INFO, "AssignTo Entered");

		elementfinder(objCreateNewRfiPage.questionPlaceholder).sendKeys(questionField);
		logger.log(Status.INFO, "questionField Entered");

		elementfinder(objCreateNewRfiPage.fileNamePlaceholder).sendKeys(FileNameField);
		logger.log(Status.INFO, "Subject name Entered");

		elementfinder(objCreateNewRfiPage.urlPlaceholder).sendKeys(UrlField);
		logger.log(Status.INFO, "UrlField Entered");

		elementfinder(objCreateNewRfiPage.addUrl_Btn).click();
		logger.log(Status.INFO, "AddUrl Btn clicked");

		elementfinder(objCreateNewRfiPage.submitBtnRfi).click();
		logger.log(Status.INFO, "RFI form submitted");

		driver.close();

	}
}
