package com.ifieldsmart.repository;

import org.openqa.selenium.By;

public class RfiListPage {
	public By mainBody = By.xpath("//*[@id=\"mainbody\"]");
	public By createRFI_Btn = By.xpath("//*[@id=\"mainbody\"]/ng-view/div[3]/div/div/div[2]/div/ul/li/div/button[4]/i");
	public By downloadRFI_Btn = By.xpath("//*[@id=\"mainbody\"]/ng-view/div[3]/div/div/div[2]/div/ul/li/div/button[2]/i");

}
