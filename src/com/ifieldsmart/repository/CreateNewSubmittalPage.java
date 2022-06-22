package com.ifieldsmart.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.ifieldsmart.utility.Utility;

import tools.Datepicker;

public class CreateNewSubmittalPage extends Utility {
	public By TitlePlaceholder = By.xpath("//input[@ng-model=\"userselected.TITLE\"]");
	public By Spec_sectionPlacholder = By.xpath("//input[@ng-model=\"searchStr\"][1]");
	public By Submittal_Package = By.xpath("//input[@placeholder=\"Enter Spec Section\"]");
	public By Revision = By.xpath("//input[@ng-model=\"Revision\"]");
	public By StatusSelect = By.xpath("//select[@ng-model=\"userselected.STATUS\"]");
	public By Submitted_BySelect = By.xpath("//select[@ng-model=\"userselected.SUBMITTEDBY\"]");
	public By AssignToInput = By.xpath("//input[@id=\"RCL_value\"]");
	public By Received_FromPlaceholder = By.xpath("//select[@ng-model=\"userselected.RECEIVED_FROM\"]");
	public By IssueDateSelect = By.xpath("//input[@ng-model=\"TodayDate\"]");
	public By RecivedDateSelect = By.xpath("//input[@ng-model=\"userselected.RECEIVED_DATE\"]");
	public By Due_DateSelect = By.xpath("//input[@ng-model=\"userselected.DUE_DATE\"]");
	public By Cost_CodePlaceholder = By.xpath("//input[@ng-model=\"userselected.COST_CODE\"]");
	public By Submittel_TypePlaceholder = By.xpath("//input[@ng-model=\"userselected.SUBMITTAL_TYPE\"]");
	public By LocationPlaceholder = By.xpath("//input[@ng-model=\"userselected.LOCATION\"]");
	public By AttachmnetBtn = By.id("file");
	public By fileNamePlaceholder = By.xpath("//input[@ng-model=\"SelectedURLHyperlink\"]");
	public By urlPlaceholder = By.xpath("//input[@ng-model=\"SelectedURL\"]");
	public By addUrl_Btn = By.xpath("//button[@ng-click=\"SubmittalUrlList(SelectedURLHyperlink,SelectedURL)\"]");
	public By distrubutionListChecllist = By.xpath("//input[@ng-model=\"CheckedList\"]");// input[@ng-model=\"CheckedList\"]
	public By cancelBtnSubmittal = By.id("buttoncancel");
	public By resetBtnSubmittal = By.id("buttonrset");
	public By submitBtnSubmittal = By.id("buttonsub");

	public CreateNewSubmittalPage(WebDriver driver) {
		this.driver = driver;

	}

	public void TitlePlaceholder(String Title) {
		driver.findElement(TitlePlaceholder).clear();
		driver.findElement(TitlePlaceholder).sendKeys(Title);
		logger.log(Status.INFO, "Title Entered");
	}

	public void Spec_sectionPlacholder(String SpecSection) {
		driver.findElement(Spec_sectionPlacholder).clear();
		driver.findElement(Spec_sectionPlacholder).sendKeys(SpecSection);
		// driver.findElement(Spec_sectionPlacholder).sendKeys(Keys.TAB);
	}

	public void Submittal_PackageCheck() {
		// Assert.assertEquals(false,
		// driver.findElement(Submittal_Package).isEnabled());

		if (driver.findElement(Submittal_Package).isEnabled()) {
			logger.log(Status.WARNING, "Checked Submittal_Package field is Enabled");
		} else {
			logger.log(Status.INFO, "Checked Submittal_Package field is Disable");
		}
	}

	public void RevisionPlaceholderCheck() {
		// Assert.assertEquals(false, driver.findElement(Revision).isEnabled());
		if (driver.findElement(Revision).isEnabled()) {
			logger.log(Status.WARNING, "Checked Revision field is Enabled");
		} else {
			logger.log(Status.INFO, "Checked Revision field is Disable");
		}
	}

	public void StatusSelect(String StatusInput) {
		Select StatusSelect1 = new Select(driver.findElement(StatusSelect));
		StatusSelect1.selectByVisibleText(StatusInput);
		// driver.findElement(Submitted_BySelect).sendKeys(Keys.ESCAPE);
		logger.log(Status.INFO, "specSection Entered");
	}

	public void Submitted_BySelect(String SubmittedBy) {
		driver.findElement(Submitted_BySelect).isSelected();
		Select Submitted_BySelect1 = new Select(driver.findElement(Submitted_BySelect));
		Submitted_BySelect1.selectByVisibleText(SubmittedBy);
		// driver.findElement(AssignToInput).sendKeys(Keys.ENTER);
		// driver.findElement(Submitted_BySelect).sendKeys(Keys.ENTER);
		logger.log(Status.INFO, "Submitted By Entered");
	}

	public void AssignToInput(String AssignTo) {
		driver.findElement(AssignToInput).isSelected();
		driver.findElement(AssignToInput).sendKeys(AssignTo);
		logger.log(Status.INFO, "Assign To Entered");
	}

	public void Received_FromPlaceholder(String Received_From) {
		driver.findElement(Received_FromPlaceholder).isSelected();
		driver.findElement(Received_FromPlaceholder).click();
		driver.findElement(Received_FromPlaceholder).sendKeys(Received_From);
		WebElement textbox = driver.findElement(Received_FromPlaceholder);
		textbox.sendKeys(Keys.ENTER);
		textbox.sendKeys(Keys.TAB);
		logger.log(Status.INFO, "Cost_impact Entered");
	}

	public void IssueDateSelect() {
		Assert.assertEquals(false, driver.findElement(IssueDateSelect).isEnabled());
		if (driver.findElement(IssueDateSelect).isEnabled()) {
			logger.log(Status.WARNING, "Checked Issue Date field is Enabled");
		} else {
			logger.log(Status.INFO, "Checked Issue Date field is Disable");
		}

	}

	public void RecivedDateSelect(WebElement xpathForMothYear, WebElement CalanderMonthForward, String month,
			String datesElement, int  dateSelected) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(RecivedDateSelect).isSelected();
		driver.findElement(RecivedDateSelect).click();
		Datepicker objDatepicker = new Datepicker(driver);
		objDatepicker.datepickerCalander(xpathForMothYear, CalanderMonthForward, month, datesElement, dateSelected);
		logger.log(Status.INFO, "Date recived Entered");

	}

	public void Due_DateSelect(WebElement xpathForMothYearDUEDATE, WebElement CalanderMonthForwardDUEDATE, String month,
			String datesElementDUEDATE, int dateSelected) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Due_DateSelect).click();
		Datepicker objDatepicker = new Datepicker(driver);
		objDatepicker.datepickerCalander(xpathForMothYearDUEDATE, CalanderMonthForwardDUEDATE, month,
				datesElementDUEDATE, dateSelected);
		driver.findElement(Cost_CodePlaceholder).click();
		
		logger.log(Status.INFO, "Date recived Entered");
	}

	public void Cost_CodePlaceholder(String CostCode) {
		driver.findElement(Cost_CodePlaceholder).isSelected();
		driver.findElement(Cost_CodePlaceholder).sendKeys(CostCode);
		logger.log(Status.INFO, "Cost Code Entered");
	}

	public void Submittel_TypePlaceholder(String SubmittalType) {
		driver.findElement(Submittel_TypePlaceholder).isSelected();
		driver.findElement(Submittel_TypePlaceholder).sendKeys(SubmittalType);
		logger.log(Status.INFO, "Submittal Type Entered");
	}

	public void LocationPlaceholder(String location) {
		driver.findElement(LocationPlaceholder).sendKeys(location);
		logger.log(Status.INFO, "location Entered");
	}

	public void AttachmnetBtn() {
		driver.findElement(AttachmnetBtn).click();
		logger.log(Status.INFO, "Attachmnet Clicked");
	}

	public void fileNamePlaceholderInput(String FileNameField) {
		driver.findElement(fileNamePlaceholder).sendKeys(FileNameField);
		logger.log(Status.INFO, "File name Entered");
	}

	public void urlPlaceholderInput(String UrlField) {
		driver.findElement(urlPlaceholder).sendKeys(UrlField);
		logger.log(Status.INFO, "UrlField Entered");
	}

	public void addUrl_BtnClick() {
		driver.findElement(addUrl_Btn).click();
		logger.log(Status.INFO, "AddUrl Btn clicked");
	}

	public void distrubutionListChecllist() {
		driver.findElement(distrubutionListChecllist).click();
		logger.log(Status.INFO, "AddUrl Btn clicked");
	}

	public void submitBtnSubmittalClick() {
		driver.findElement(submitBtnSubmittal).click();
		logger.log(Status.INFO, "RFI form submitted");
	}

	public void tearDown() {
		String actualurl = driver.getCurrentUrl();

		if (actualurl.contains("")) {
			markstatus("pass", "New RFI form submitted ");
		} else {
			markstatus("fail", "Fail to submit new RFI ");
		}
	}
}
