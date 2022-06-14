package com.ifieldsmart.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.ifieldsmart.utility.Utility;

public class CreateNewRfiPage extends Utility {
	public By rfiIDPlaceholder = By.xpath("//input[@ng-model=\"RFIID\"]");
	public By subjectPlacholder = By.xpath("//input[@ng-model=\"userselected.SUBJECT\"]");
	public By rfi_ManagerSelect = By.xpath("//select[@ng-model=\"userselected.RFI_MANAGER\"]");
	public By createdByPlaceholder = By.xpath("//input[@ng-model=\"CREATEDBY\"]");
	public By receivedFromSelect = By.xpath("//select[@ng-model=\"Project\"]");
	public By drawingPlaceholder = By.xpath("//input[@placeholder=\"Enter Drawing Name\"]");
	public By specSection = By.xpath("//input[@placeholder=\"Enter Spec Section\"]");
	public By costImpactSelect = By.xpath("//select[@ng-model=\"userselected.COST_IMPACT\"]");
	public By visibilitySelect = By.xpath("//select[@ng-model=\"userselected.VISIBILITY\"]");
	public By dateInitiatedPlaceholder = By.xpath("//input[@ng-model=\"TodayDate\"]");
	public By dueDatePlaceholder = By.xpath("//input[@ng-model=\"userselected.DUE_DATE\"]");
	public By ballInCourtSelect = By.xpath("//select[@ng-model=\"userselected.BALL_IN_COURT\"]");
	public By assignToPlaceholder = By.xpath("//input[@placeholder=\"Enter User/Company Name\"]");
	public By questionPlaceholder = By.xpath("//textarea[@ng-model=\"userselected.QUESTION\"]");
	public By chooseFile_btn = By.xpath("//*[@id=\"file\"]");
	public By fileNamePlaceholder = By.xpath("//input[@ng-model=\"SelectedURLHyperlink\"]");
	public By urlPlaceholder = By.xpath("//input[@ng-model=\"SelectedURL\"]");
	public By addUrl_Btn = By.xpath("//input[@ng-model=\"SelectedURLHyperlink\"]");
	public By distrubutionListChecllist = By.xpath("//input[@ng-model=\"CheckedList\"]");
	public By cancelBtnRfi = By.xpath("//button[@id=\"buttoncancel\"]");
	public By resetBtnRfi = By.xpath("//button[@id=\"buttonrset\"]");
	public By submitBtnRfi = By.xpath("//button[@id=\"buttonsub\"]");

	public CreateNewRfiPage(WebDriver driver) {
		this.driver = driver;

	}

	public void rfiIDPlaceholderCheck() {

		if (driver.findElement(rfiIDPlaceholder).isEnabled()) {
			logger.log(Status.WARNING, "Checked Rfi id field is Enabled");
		} else {
			logger.log(Status.INFO, "Checked Rfi id field is Disable");
		}
	}

	public void subjectPlacholderInsert(String subject) {

		driver.findElement(subjectPlacholder).sendKeys(subject);
		logger.log(Status.INFO, "Subject name Entered");
	}

	public void Select_rfiManager(String RfiManager) {
		Select rfiManager = new Select(driver.findElement(rfi_ManagerSelect));
		rfiManager.selectByVisibleText(RfiManager);
	}

	public void createdByPlaceholderCheck() {
		if (driver.findElement(createdByPlaceholder).isEnabled()) {
			logger.log(Status.WARNING, "Checked Rfi id field is Enabled");
		} else {
			logger.log(Status.INFO, "Checked Rfi id field is Disable");
		}
	}

	public void receivedFromSelect(String ReceivedForm) {
		driver.findElement(receivedFromSelect).sendKeys(ReceivedForm);
		logger.log(Status.INFO, "ReceivedForm Entered");
	}

	public void drawingPlaceholderInsert(String drawing) {
		driver.findElement(drawingPlaceholder).sendKeys(drawing);
		logger.log(Status.INFO, "drawing Entered");
	}

	public void specSectionInsert(String Spec_Section) {
		driver.findElement(specSection).sendKeys(Spec_Section);
		driver.findElement(subjectPlacholder).sendKeys(Keys.TAB);
		logger.log(Status.INFO, "specSection Entered");
	}

	public void costImpactSelect(String Cost_impact) {
		driver.findElement(costImpactSelect).sendKeys(Cost_impact);
		logger.log(Status.INFO, "Cost_impact Entered");
	}

	public void visibilitySelect(String Visibility) {
		driver.findElement(visibilitySelect).sendKeys(Visibility);
		logger.log(Status.INFO, "Visibility Entered");
	}

	public void dateInitiatedPlaceholderCheck() {
		if (driver.findElement(dateInitiatedPlaceholder).isEnabled()) {
			logger.log(Status.WARNING, "Checked Rfi id field is Enabled");
		} else {
			logger.log(Status.INFO, "Checked Rfi id field is Disable");
		}
	}

	public void dueDatePlaceholderInsert(String Due_date) {
		driver.findElement(dueDatePlaceholder).sendKeys(Due_date);// mm/dd/yyyy
		logger.log(Status.INFO, "Due_date Entered");
	}

	public void ballInCourtSelect(String Ball_in_court) {
		driver.findElement(ballInCourtSelect).sendKeys(Ball_in_court);
		logger.log(Status.INFO, "Ball_in_court Entered");
	}

	public void assignToPlaceholderInput(String AssignTo) {
		driver.findElement(assignToPlaceholder).sendKeys(AssignTo);
		logger.log(Status.INFO, "AssignTo Entered");
	}

	public void questionPlaceholderInput(String questionField) {
		driver.findElement(questionPlaceholder).sendKeys(questionField);
		logger.log(Status.INFO, "questionField Entered");
	}

	public void fileNamePlaceholderInput(String FileNameField) {
		driver.findElement(fileNamePlaceholder).sendKeys(FileNameField);
		logger.log(Status.INFO, "Subject name Entered");
	}

	public void urlPlaceholderInput(String UrlField) {
		driver.findElement(urlPlaceholder).sendKeys(UrlField);
		logger.log(Status.INFO, "UrlField Entered");
	}

	public void addUrl_BtnClick() {
		driver.findElement(addUrl_Btn).click();
		logger.log(Status.INFO, "AddUrl Btn clicked");
	}

	public void submitBtnRfiClick() {
		driver.findElement(submitBtnRfi).click();
		logger.log(Status.INFO, "RFI form submitted");
	}
	
	public void tearDown() {
		String actualurl = driver.getCurrentUrl();

		if (actualurl.contains("RFILIST")) {
			markstatus("pass", "New RFI form submitted ");
		} else {
			markstatus("fail", "Fail to submit new RFI ");
		}
	}

}
