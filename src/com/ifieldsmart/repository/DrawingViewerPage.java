package com.ifieldsmart.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.ifieldsmart.utility.Utility;

public class DrawingViewerPage extends Utility{
	public By zoomIN_Annotation = By.xpath("//a[@title=\"Zoom in\"]");
	public By zoomOut_Annotation = By.xpath("//a[@title=\"Zoom out\"]");
	

}
