package com.ifieldsmart.testCases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ifieldsmart.repository.CreateNewRfiPage;
import com.ifieldsmart.repository.FolderPage;
import com.ifieldsmart.repository.LoginPage;
import com.ifieldsmart.repository.ProjectsPage;
import com.ifieldsmart.repository.RfiListPage;
import com.ifieldsmart.utility.Utility;

public class CreateNewRfi_TC001 extends Utility {
	public String userName = "omkrushana@vcsbim.com";
	public String pwd = "if#2022";

	@Test(priority = 1)
	public void initbrowser() {
		driverSetting();
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "iFBIM - iFieldsmart";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
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

		// Assert.assertEquals(ExpectedTitle, ActualTitle);

		// driver.close();
	}

	@Test(priority = 3)
	public void projectCard1() {
		starttestcse("User click card1");

//		public HomePage objhomerepo = new HomePage();
		ProjectsPage objProjectsPage = new ProjectsPage(driver);
		objProjectsPage.projectsTabClick();
		objProjectsPage.projectsCard1Click();
	}

	@Test(priority = 4)
	public void rfiFolderClick() {
		starttestcse("User click on createRFI ");
		FolderPage objFolderPage = new FolderPage(driver);
		// objFolderPage.switchToMainBody();
		objFolderPage.rfiInFolderList();

	}

	@Test(priority = 5)
	public void rfiListCreate() {
		starttestcse("User click on createRFI ");

		RfiListPage objRfiListPage = new RfiListPage(driver);
		objRfiListPage.addNewRFI();

	}

	@Test(priority = 6)
	public void createNewRfiForm() throws InterruptedException {

		String subject = "Automation Test";
		String RfiManager = "Onkar Ghule(NULL)";// select
		String ReceivedForm = "Chetan Mogal(BIM Engineering U.S. LLC.)";// select
		String drawing = "SE522 ROOF FRAMING DETAILS";
		String Spec_Section = "000110    Table of Contents";
		String Cost_impact = "Yes";// select
		String Visibility = "Public";// select
		String Ball_in_court = "iFieldSmart Technology(iFieldSmart Technologies)";//
		String AssignTo = "Mahesh I(NULL)";
		String questionField = "It is automated Program";
		String FileNameField = "File Name Entered";
		String UrlField = "http://www.africau.edu/images/default/sample.pdf";

		starttestcse("Create New RFI form details are filled");

		CreateNewRfiPage objCreateNewRfiPage = new CreateNewRfiPage(driver);

		objCreateNewRfiPage.rfiIDPlaceholderCheck();
		
		objCreateNewRfiPage.subjectPlacholderInsert(subject);
		objCreateNewRfiPage.Select_rfiManager(RfiManager);
		objCreateNewRfiPage.createdByPlaceholderCheck();
		objCreateNewRfiPage.receivedFromSelect(ReceivedForm);
		objCreateNewRfiPage.drawingPlaceholderInsert(drawing);
		objCreateNewRfiPage.specSectionInsert(Spec_Section);
		objCreateNewRfiPage.costImpactSelect(Cost_impact);
		objCreateNewRfiPage.visibilitySelect(Visibility);
		objCreateNewRfiPage.dateInitiatedPlaceholderCheck();
		driver.findElement(By.xpath("//*[@id=\"calendar1\"]")).click();
		driver.findElement(By.xpath(
				"//*[@id=\"createRFIdiv\"]/div[2]/div/div[2]/div/form/div/div[11]/div/datepicker/div/div[4]/a[26]"))
				.click();
//		String NowDay = getCurrentDay();
//		getCurrentDayPlus(5);
//
//		List<WebElement> elementlist = driver.findElements(By
//				.xpath("//*[@id=\"createRFIdiv\"]/div[2]/div/div[2]/div/form/div/div[11]/div/datepicker/div/div[4]/a"));
//		clickGivenDay(elementlist, NowDay);

//		objCreateNewRfiPage.dueDatePlaceholderInsert(dtf.format(localDate));
		objCreateNewRfiPage.ballInCourtSelect(Ball_in_court);
		objCreateNewRfiPage.assignToPlaceholderInput(AssignTo);
		objCreateNewRfiPage.questionPlaceholderInput(questionField);
		objCreateNewRfiPage.fileNamePlaceholderInput(FileNameField);
		objCreateNewRfiPage.urlPlaceholderInput(UrlField);
		objCreateNewRfiPage.addUrl_BtnClick();
		
		objCreateNewRfiPage.distrubutionListChecllist();
		objCreateNewRfiPage.submitBtnRfiClick();
		

	}

}
