package com.ifieldsmart.repository;

import org.openqa.selenium.By;

public class LoginPage {
	public By username = By.xpath("//input[@id=\"email\"]");
	public By password = By.xpath("//input[@id=\"password\"]");
	public By viewPasswordBtn = By.xpath("//div[@id=\"sizing-addon1\"]");
	public By loginBtn = By.xpath("//button[@id=\"loginbtn\"]");
	public By navbarDropdownBtn = By.id("navbarDropdown");	
	public By logoutBtn = By.xpath("//a[@onclick=\"logout()\"]");	

}
