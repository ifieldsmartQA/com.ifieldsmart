package com.ifieldsmart.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.ifieldsmart.utility.Utility;

public class SubmittalListPage extends Utility {
	public By mainBody = By.xpath("//*[@id=\"mainbody\"]");
	public By createSubmittal_Btn = By.xpath("//button[@ng-click= \"RedirectToSubmittals('0');\"]");
	public By downloadSubmittal_Btn = By.xpath("//i[@title= \"Export to excel\"]");
	public By plusSignBtn = By.xpath("//button[@ng-click= \"RedirectToSubmittals('0');\"]");

	public SubmittalListPage(WebDriver driver) {
		this.driver = driver;

	}

	public void addSubmittalBtnClick() {
		driver.findElement(createSubmittal_Btn).isEnabled();
		driver.findElement(createSubmittal_Btn).click();
		logger.log(Status.INFO, "Clicked on createRFI");
	}

//	public void rfiInFolderList() {
//		driver.findElement(projectCard1).click();
//		logger.log(Status.INFO, "Clicked on card");
//	}

//	public void addNewRFI() {
//		driver.findElement(plusSignBtn).click();
//	}

}
