package com.ifieldsmart.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.ifieldsmart.utility.Utility;

public class ProjectsPage extends Utility {

	public By projectCard1 = By.xpath(
			"//*[@id=\"ifBIMprojects\"]/div[1]/div/div/div[2]/div/div/div/div[1]/div/p");
	public By cardTeamUserBtn = By.xpath("//button[@id=\"userassign\"]");
	public By cardEditBtn = By.xpath("//button[@id=\"editproj\"]");

	public By projectsTab = By.xpath("//a[@id=\"ifBIMprojects-tab\"]");
	public By syncfromTab = By.xpath("//a[@id=\"syncfrom-tab\"]");
	public By searchMyProjects = By.xpath("//input[@type=\"search\"]");
	public By searchMyProjectsBtn = By.xpath("//*[@id=\"button-addon2\"]");
	public By myProjectsMainHeader = By.xpath("//a[@class=\"nav-link\"]");
	public By loggdinUsername = By.xpath("//span[text() = \"Omkrushana\"]");

	public ProjectsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void projectsTabClick() {
		driver.findElement(projectsTab).click();
		logger.log(Status.INFO, "Projects Tab Opened");
	}

	public void projectsCard1Click() {
		driver.findElement(projectCard1).click();
		logger.log(Status.INFO, "Clicked on card");
	}
	
	public void tearDown() {
		String actualTitle = driver.getTitle();

		if (actualTitle.contains("")) {
			markstatus("pass", "Login successful for user " + actualTitle);
		} else {
			markstatus("fail", "Login failed for user " + actualTitle);
		}
		
	}

}
