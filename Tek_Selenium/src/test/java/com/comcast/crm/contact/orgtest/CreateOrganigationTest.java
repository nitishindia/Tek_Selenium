package com.comcast.crm.contact.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganigationTest {

	public static void main(String[] args) throws IOException {
		ExcelUtility EU = new ExcelUtility();
		FileUtility FU = new FileUtility();
		WebDriverUtility wd = new WebDriverUtility();
		JavaUtility JU = new JavaUtility();
	
		// property file
//		FileInputStream fis = new FileInputStream(
//				"C:\\Users\\dell\\eclipse-workspace\\TekPyramid_Qspider\\src\\test\\resources\\CommonData_Vtiger.proreties");
//
//		Properties p = new Properties();
//
//		p.load(fis);
		
		String BROWSER = FU.getDataFromPropertiesFile("browser");
		String URL = FU.getDataFromPropertiesFile("url");
		String USERNAME = FU.getDataFromPropertiesFile("username");
		String PASSWORD = FU.getDataFromPropertiesFile("password");
		
		
		// Random number
//		Random r = new Random();
//		int randomint = r.nextInt(1000);
		
		
		// excel file
//		FileInputStream fis1 = new FileInputStream("C:\\Users\\dell\\Desktop\\TestDataAA4.xlsx");
//
//		Workbook w = WorkbookFactory.create(fis1);
//
//		String Company = w.getSheet("org").getRow(1).getCell(2).toString()+ randomint;
		
		String Company = EU.getDataFromExcel("org", 1, 2) + JU.getRandomNumber();

//		System.out.println(BROWSER);
//		System.out.println(Company);

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		// Launch Browser
		driver.manage().window().maximize();
		wd.waitForPageToLoad(driver);
		
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		// Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Click on organization
		driver.findElement(By.linkText("Organizations")).click();

		// click on organization look image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		// fill mandatory field
		driver.findElement(By.name("accountname")).sendKeys(Company);

		// save & verify
		driver.findElement(By.name("button")).click();
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (name.contains(Company)) {
			System.out.println(name + "organization created successfully");
		} else {
			System.out.println(name + "fail to create organization");
		}

		// logout
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(admin).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// Close the browser
		driver.quit();
	}

}
