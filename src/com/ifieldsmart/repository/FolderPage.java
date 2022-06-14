package com.ifieldsmart.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.ifieldsmart.utility.Utility;

public class FolderPage extends Utility {

	public By mainBody = By.xpath("//*[@id=\"mainbody\"]/ng-view/div[1]/div/div[1]");
	//public By rfiInFolderList = By.xpath("//*[@id=\"foldersli\"][2]");
	public By rfiInFolderList = By.xpath("//*[@id=\"foldersli\"][11]");
	// By.linkText("RFI");
	// public By scheduleDemoBtnHome =
	// By.xpath("//html//body//header//div//div//div[3]//a[1]");

	public FolderPage(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToMainBody() {
		driver.findElement(mainBody).click();
		;
	}

	public void rfiInFolderList() {
		//List<WebElement> listOfElements = driver.findElements(rfiInFolderList);

		//listOfElements.get(1).click();
		driver.findElement(rfiInFolderList).click();
		logger.log(Status.INFO, "Clicked on RFI_Btn_in list");
	}

}
