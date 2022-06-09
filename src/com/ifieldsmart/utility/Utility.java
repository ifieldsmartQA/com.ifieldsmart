package com.ifieldsmart.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ifieldsmart.repository.CreateNewRfiPage;
import com.ifieldsmart.repository.FolderPage;
import com.ifieldsmart.repository.HomePage;
import com.ifieldsmart.repository.LoginPage;
import com.ifieldsmart.repository.ProjectsPage;
import com.ifieldsmart.repository.RfiListPage;

public class Utility {
	public WebDriver driver;
	String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
	//.
//  --------------------------------------------------------------------------------------------------------------------------------
//	
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports report;
	public static ExtentTest logger;
//.
//  --------------------------------------------------------------------------------------------------------------------------------
//	
	public LoginPage objloginrepo = new LoginPage();
	public HomePage objhomerepo = new HomePage();
	public ProjectsPage objProjectsPage = new ProjectsPage();
	public FolderPage objFolderPage = new FolderPage();
	public RfiListPage objRfiListPage = new RfiListPage();
	public CreateNewRfiPage objCreateNewRfiPage = new CreateNewRfiPage();
//.
//  ---------------------------------------------------------------------------------------------------------------------------------
//		
	public String userName = "omkrushana@ifieldsmart.com";
	public String pwd = "if#2022";

	public String testDataFile = "C:\\Users\\admin\\eclipse-workspace\\com.ifieldsmart\\src\\testfile.xlsx";

	public String extentFilePath = "C:\\Users\\admin\\eclipse-workspace\\com.ifieldsmart\\src\\ExtentReport";
	public String screenshotFilePath = "C:\\Users\\admin\\eclipse-workspace\\com.ifieldsmart\\src\\Screenshot";

	ArrayList<String> usernames = dataread(testDataFile, "Sheet3", 0);
	ArrayList<String> passwords = dataread(testDataFile, "Sheet3", 1);

	String browsername;
	String applicationlink;

	@SuppressWarnings("deprecation")
	public void driverSetting() {
		// reading browser name and link from excel
		try {
			FileInputStream fs = new FileInputStream(testDataFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet("Sheet2");
			XSSFRow row = sheet.getRow(1);

			browsername = row.getCell(0).getStringCellValue();
			applicationlink = row.getCell(1).getStringCellValue();
			workbook.close();
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Opening browser based upon browsername given in a excel

		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Omkrushana\\Selenium\\Selenium\\Installation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			// Code to open firefox browser
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		driver.get(applicationlink);
	}

	public WebElement elementfinder(By objby) {
		WebElement temp = driver.findElement(objby);
		return temp;
	}
	//.
//  ------------------------------------------------BeforeSuite start-----------------------------------------------------------------
//	
	@BeforeSuite
	public void initreport() {
		htmlreporter = new ExtentHtmlReporter(extentFilePath + "\\extentReport__" + timestamp + ".html"); // file name
																											// with
																											// extension
		report = new ExtentReports();
		report.attachReporter(htmlreporter);
	}

	public void starttestcse(String testcasename) {
		logger = report.createTest(testcasename);
	}
//.
//  ------------------------------------------------AfterSuite start-----------------------------------------------------------------
//	
	@AfterSuite
	public void endreport() {
		report.flush();
	}

	public void markstatus(String statusname, String description) // info
	{
		if (statusname.equalsIgnoreCase("pass")) {
			logger.log(Status.PASS, description);
		} else if (statusname.equalsIgnoreCase("fail")) {
			logger.log(Status.FAIL, description);
		} else if (statusname.equalsIgnoreCase("info")) {
			logger.log(Status.INFO, description);
		}
	}

	public void compare(String expected, String actual, String passmessage, String failmessage) {
		if (expected.equals(actual)) {
			markstatus("pass", passmessage);
		} else {
			markstatus("fail", failmessage);
		}
	}

	public ArrayList<String> dataread(String filepath, String sheetname, int cellno) {
		ArrayList<String> obja = new ArrayList<String>(); // creating object of ArrayList class
		try {
			FileInputStream fs = new FileInputStream(filepath); // excel path from your machine
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet objsheet = workbook.getSheet(sheetname);

			int rowcount = objsheet.getLastRowNum();
			for (int a = 1; a <= rowcount; a++) // loop for rows
			{
				XSSFRow row = objsheet.getRow(a);
				String temp = row.getCell(cellno).getStringCellValue(); // picking every value from excel cell
				obja.add(temp); // saving value in arraylist
			}
			workbook.close();
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obja;// returning the ArrayList having all values
	}

	public ArrayList<String> datareadnumericvalues(String filepath, String sheetname, int cellno) {
		ArrayList<String> obja = new ArrayList<String>();
		try {
			FileInputStream fs = new FileInputStream(filepath); // excel path from your machine
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet objsheet = workbook.getSheet(sheetname);
			int rowcount = objsheet.getLastRowNum();

			for (int a = 1; a <= rowcount; a++) // loop for rows
			{
				XSSFRow row = objsheet.getRow(a);
				double temp = row.getCell(cellno).getNumericCellValue(); // picking every value from excel cell
				int intvalue = (int) temp;
				String stringvalue = String.valueOf(intvalue);
				obja.add(stringvalue);
			}
			workbook.close();
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obja;
	}
//.
//  ------------------------------------------------Screenshot-----------------------------------------------------------------
//	
	public void screenshot(String name) {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File target = new File(screenshotFilePath + name + timestamp + ".png"); // file path

		try {
			FileHandler.copy(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void ifieldsmartlogin() {
		elementfinder(objloginrepo.username).sendKeys(usernames.get(1));
		elementfinder(objloginrepo.password).sendKeys(passwords.get(1));
		elementfinder(objloginrepo.loginBtn).click();
	}
	
	
	

}
