package com.ifieldsmart.repository;

import org.openqa.selenium.By;

public class ProjectsPage {
	public By projectCard1 = By.xpath("//*[@id=\"ifBIMprojects\"]/div[1]/div/div/div[2]");
	public By cardTeamUserBtn = By.xpath("//button[@id=\"userassign\"]");
	public By cardEditBtn = By.xpath("//button[@id=\"editproj\"]");

	
	public By projectsTab = By.xpath("//a[@id=\"ifBIMprojects-tab\"]");
	public By syncfromTab = By.xpath("//a[@id=\"syncfrom-tab\"]");
	public By searchMyProjects = By.xpath("//input[@type=\"search\"]");
	public By searchMyProjectsBtn = By.xpath("//*[@id=\"button-addon2\"]");
	public By myProjectsMainHeader = By.xpath("//a[@class=\"nav-link\"]");
	
}
