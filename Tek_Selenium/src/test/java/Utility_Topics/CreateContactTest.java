package Utility_Topics;

import java.io.FileInputStream;
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

public class CreateContactTest {

	public static void main(String[] args) throws IOException {

		// property file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\dell\\eclipse-workspace\\TekPyramid_Qspider\\src\\test\\resources\\CommonData_Vtiger.proreties");

		Properties p = new Properties();

		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");

		Random r = new Random();
		int randomint = r.nextInt(1000);

		// excel file
		FileInputStream fis1 = new FileInputStream("C:\\Users\\dell\\Desktop\\TestDataAA4.xlsx");

		Workbook w = WorkbookFactory.create(fis1);

		String lastname = w.getSheet("contact").getRow(1).getCell(2).toString() + randomint;


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

		// To launch Browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		// To login to Application

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// To Click on Contacts link
		driver.findElement(By.linkText("Contacts")).click();

		// To click on create contact look up image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		// To fill mandatory details
		driver.findElement(By.name("lastname")).sendKeys(lastname);

		// Save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (name.contains(lastname)) {
			System.out.println(name + "Contact created successfully");
		} 
		else {
			System.out.println(name + "Fail to create contact");
		}

		// To logout
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(admin).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// close browser
		driver.quit();

	}

}
