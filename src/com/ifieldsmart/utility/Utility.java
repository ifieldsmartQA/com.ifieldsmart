package com.ifieldsmart.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Utility {
	public WebDriver driver;
	
	public String exphomeurl = "https://ifbim.ifieldsmart.com/#/";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
	//.
//  --------------------------------------------------------------------------------------------------------------------------------
//	
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports report;
	public static ExtentTest logger;
//
//  --------------------------------------------------------------------------------------------------------------------------------
//	

//
//  ---------------------------------------------------------------------------------------------------------------------------------
//		


	public String testDataFile = "C:\\Users\\admin\\Desktop\\Omkrushana\\com.ifieldsmart\\testfile.xlsx";

	public String extentFilePath = "C:\\Users\\admin\\Desktop\\Omkrushana\\com.ifieldsmart\\src\\ExtentReport";
	public String screenshotFilePath = "C:\\Users\\admin\\Desktop\\Omkrushana\\com.ifieldsmart\\src\\Screenshot";

//	ArrayList<String> usernames = dataread(testDataFile, "Sheet3", 0);
//	ArrayList<String> passwords = dataread(testDataFile, "Sheet3", 1);

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
					"C:\\Users\\admin\\Desktop\\Omkrushana\\Selenium\\Selenium\\Installation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\admin\\Desktop\\Omkrushana\\Selenium\\Selenium\\Installation\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
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

//	public void ifieldsmartlogin() {
//		elementfinder(objloginrepo.username).sendKeys(usernames.get(1));
//		elementfinder(objloginrepo.password).sendKeys(passwords.get(1));
//		elementfinder(objloginrepo.loginBtn).click();
//	}
//	
	
	public static String getCurrentDay() {
		// Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Int: " + todayInt + "\n");
		// Integer to String Conversion
		String todayStr = Integer.toString(todayInt);
		System.out.println("Today Str: " + todayStr + "\n");
		return todayStr;
	}

	// Get The Current Day plus days. You can change this method based on your
	// needs.
	public static String getCurrentDayPlus(int days) {
		LocalDate currentDate = LocalDate.now();
		int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
		return Integer.toString(dayOfWeekPlus);
	}
    
	// Click to given day
	public static void clickGivenDay(List<WebElement> elementList, String day) {
		// DatePicker is a table. Thus we can navigate to each cell
		// and if a cell matches with the current date then we will click it.
		/** Functional JAVA version of this method. */
		elementList.stream().filter(element -> element.getText().contains(day)).findFirst()
				.ifPresent(WebElement::click);
		/** Non-functional JAVA version of this method. */
		// for (
		// WebElement cell : elementList) {
		// String cellText = cell.getText();
		// if (cellText.contains(day)) {
		// cell.click();
		// break;
		// }
		// }
	}

}
