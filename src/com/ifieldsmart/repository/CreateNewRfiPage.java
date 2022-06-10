package com.ifieldsmart.repository;

import org.openqa.selenium.By;

public class CreateNewRfiPage {
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

}
