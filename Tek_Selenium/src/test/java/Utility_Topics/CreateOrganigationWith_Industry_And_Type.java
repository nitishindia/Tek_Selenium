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
import org.openqa.selenium.support.ui.Select;

public class CreateOrganigationWith_Industry_And_Type {

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

		String Company = w.getSheet("org").getRow(4).getCell(2).toString() + randomint;
		String INDUSTRY = w.getSheet("org").getRow(4).getCell(3).toString();
		String TYPE = w.getSheet("org").getRow(4).getCell(4).toString();

//				System.out.println(BROWSER);
//				System.out.println(Company);

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
		
		WebElement indDropdown = driver.findElement(By.name("industry"));
		Select s = new Select(indDropdown);
		s.selectByVisibleText(INDUSTRY);
		
		
		WebElement TypeDropdown = driver.findElement(By.name("accounttype"));
		Select s1 = new Select(TypeDropdown);
		s1.selectByVisibleText(TYPE);

		// save & verify
		driver.findElement(By.name("button")).click();
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (name.contains(Company)) {
			System.out.println(name + "organization created successfully");
		} else {
			System.out.println(name + "fail to create organization");
		}
		
		
		String indu = driver.findElement(By.id("dtlview_Industry")).getText();
		if(indu.equals(INDUSTRY)) {
			System.out.println(indu + "is industry created");
		}
		else {
			System.out.println(indu + " is not industry created");
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
