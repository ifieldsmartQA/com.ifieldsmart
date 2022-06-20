package com.ifieldsmart.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.ifieldsmart.utility.Utility;

public class RfiListPage extends Utility {
	public By mainBody = By.xpath("//*[@id=\"mainbody\"]");
	public By createRFI_Btn = By.xpath("//*[@id=\"mainbody\"]/ng-view/div[1]/div/div[1]");
	public By downloadRFI_Btn = By
			.xpath("//*[@id=\"mainbody\"]/ng-view/div[3]/div/div/div[2]/div/ul/li/div/button[2]/i");
	public By projectCard1 = By.xpath(
			"/html/body/ng-view/div[3]/div[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div/div/div[1]/div/p");
    public By plusSignBtn = By.xpath("//*[@ng-click=\"RedirectToRFI();\"]");
	public RfiListPage(WebDriver driver) {
		this.driver = driver;

	}

	public void switchtoMainBody() {
		driver.findElement(createRFI_Btn).click();
		logger.log(Status.INFO, "Clicked on createRFI");
	}

	public void rfiInFolderList() {
		driver.findElement(projectCard1).click();
		logger.log(Status.INFO, "Clicked on card");
	}
	
	public void addNewRFI() {
		driver.findElement(plusSignBtn).click();
	}

}

//div[contains(text(), 'date:')]/ancestor::div[contains(@class, 'form row')]/following-sibling::input[@id=formData-rest_of_the_id_value]