package com.ifieldsmart.testCases.SubmittalFormTC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ifieldsmart.repository.CreateNewSubmittalPage;
import com.ifieldsmart.repository.FolderPage;
import com.ifieldsmart.repository.LoginPage;
import com.ifieldsmart.repository.ProjectsPage;

import com.ifieldsmart.repository.SubmittalListPage;
import com.ifieldsmart.utility.Utility;

public class TC_001_SubmittalFormPositiveScenerio extends Utility {
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
	}

	@Test(priority = 3)
	public void projectCard1() throws InterruptedException {
		starttestcse("User click card1");

		ProjectsPage objProjectsPage = new ProjectsPage(driver);
		objProjectsPage.projectsTabClick();
		logger.log(Status.INFO, "Projects Tab Opened");
		objProjectsPage.projectsCard1Click();
		logger.log(Status.INFO, "Clicked on card");
		Thread.sleep(2000);

	}

	@Test(priority = 4)
	public void SubmittalListCreate() {
		starttestcse("User click on Submittal ");

		FolderPage objFolderPage = new FolderPage(driver);
		// objFolderPage.switchToMainBody();
		objFolderPage.SubmittalInFolderList();

		String actualurl = driver.getCurrentUrl();

		if (actualurl.contains("SubmittalsList")) {
			markstatus("pass", "SubmittalsList list Opened");
		} else {
			markstatus("fail", "Fail to open SubmittalsList list ");
		}

	}

	@Test(priority = 5)
	public void SubmittalFormOpen() throws InterruptedException {
		starttestcse("User click on createSubmittal ");

		SubmittalListPage objSubmittalListPage = new SubmittalListPage(driver);
		objSubmittalListPage.addSubmittalBtnClick();

		String actualurl = driver.getCurrentUrl();

		if (actualurl.contains("CreateSubmittals")) {
			markstatus("pass", "CreateSubmittals Form Opened");
		} else {
			markstatus("fail", "Fail to open CreateSubmittals Form ");
		}
		Thread.sleep(1000);

	}

	@Test(priority = 6)
	public void SubmittalFormFill() throws InterruptedException  {
		String Title = "Submital  Form Test";
		String Spec_Section = "013319    Field Test Reporting";// select
		String StatusInput = "Submitted";// select
		String Submitted_By = "Jane Smith(OM)";
		String Assign_To = "Sumeet Maru(iFieldSmart)";
		String Received_From = "NULL NULL(NULL)";// select
		
		String Received_Month_Year = "December 2025";
		int Recived_dateSelected = 20;
		
		String Due_Month_Year = "December 2025";
		int Due_dateSelected = 20;
		
		String Cost_Code = "something";
		String Submittal_Type = "something";
		String Location = "Loaction Added";
		String UrlFileName = "Url file name added";
		String UrlPath = "Url Path Added";
		
		
		/*
		 * Elements for date picker in Received date calendar 
		 */
		WebElement xpathForMothYear = driver.findElement(By.xpath("//*[@id=\"createsubmittaldiv\"]/div[2]/div/div[2]/div/form/div/div[10]/div/datepicker/div/div[1]/div[2]"));
		//Calendar forward or backward changes required according to validation
		WebElement CalanderMonthForward = driver.findElement(By.xpath("//*[@id=\"createsubmittaldiv\"]/div[2]/div/div[2]/div/form/div/div[10]/div/datepicker/div/div[1]/div[3]/a"));
		String datesElement = "//*[@id=\"createsubmittaldiv\"]/div[2]/div/div[2]/div/form/div/div[10]/div/datepicker/div/div/a";// the xpath should show list of elements
		
		/*
		 * Elements for date picker in Due date calendar 
		 */
		
		WebElement xpathForMothYearDUEDATE = driver.findElement(By.xpath("//*[@id=\"createsubmittaldiv\"]/div[2]/div/div[2]/div/form/div/div[11]/div/datepicker/div/div[1]/div[2]"));
		//Calendar forward or backward changes required according to validation
		WebElement CalanderMonthForwardDUEDATE = driver.findElement(By.xpath("//*[@id=\"createsubmittaldiv\"]/div[2]/div/div[2]/div/form/div/div[11]/div/datepicker/div/div[1]/div[3]/a"));
		String datesElementDUEDATE = "//*[@id=\"createsubmittaldiv\"]/div[2]/div/div[2]/div/form/div/div[11]/div/datepicker/div/div/a"; // the xpath should show list of elements
		
		
		starttestcse("Create New Submittal form details Test");

		CreateNewSubmittalPage objCreateNewSubmittalPage = new CreateNewSubmittalPage(driver);

		objCreateNewSubmittalPage.TitlePlaceholder(Title);
		objCreateNewSubmittalPage.Spec_sectionPlacholder(Spec_Section);
		objCreateNewSubmittalPage.Submittal_PackageCheck();
		objCreateNewSubmittalPage.RevisionPlaceholderCheck();
		objCreateNewSubmittalPage.StatusSelect(StatusInput);
		objCreateNewSubmittalPage.Submitted_BySelect(Submitted_By);
		objCreateNewSubmittalPage.AssignToInput(Assign_To);
		objCreateNewSubmittalPage.Received_FromPlaceholder(Received_From);
		objCreateNewSubmittalPage.IssueDateSelect();
 		objCreateNewSubmittalPage.RecivedDateSelect(xpathForMothYear, CalanderMonthForward, Received_Month_Year, datesElement, Recived_dateSelected);
 		objCreateNewSubmittalPage.Due_DateSelect(xpathForMothYearDUEDATE, CalanderMonthForwardDUEDATE, Due_Month_Year,datesElementDUEDATE, Due_dateSelected);
		objCreateNewSubmittalPage.Cost_CodePlaceholder(Cost_Code);
		objCreateNewSubmittalPage.Submittel_TypePlaceholder(Submittal_Type);
		objCreateNewSubmittalPage.LocationPlaceholder(Location);
		objCreateNewSubmittalPage.fileNamePlaceholderInput(UrlFileName);
		objCreateNewSubmittalPage.urlPlaceholderInput(UrlPath);
		objCreateNewSubmittalPage.addUrl_BtnClick();
		objCreateNewSubmittalPage.distrubutionListChecllist();
		objCreateNewSubmittalPage.submitBtnSubmittalClick();

	}

}
