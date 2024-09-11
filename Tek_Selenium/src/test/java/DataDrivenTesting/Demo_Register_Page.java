package DataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_Register_Page {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//File f = new File("‪‪./TestData/Demo_RegisterPage.xlsx");
		FileInputStream fis = new FileInputStream("C:\\Users\\dell\\Desktop\\Demo_RegisterPage1.xlsx");
		
		Workbook w = WorkbookFactory.create(fis);
		
		String FirstName = w.getSheet("Sheet1").getRow(1).getCell(0).toString();
		String LastName = w.getSheet("Sheet1").getRow(1).getCell(1).toString();
		String Email = w.getSheet("Sheet1").getRow(1).getCell(2).toString();
		String Password = w.getSheet("Sheet1").getRow(1).getCell(3).toString();
		String ConfirmPassword = w.getSheet("Sheet1").getRow(1).getCell(4).toString();
		String Gender = w.getSheet("Sheet1").getRow(1).getCell(5).toString();
		
//		System.out.println(FirstName);
//		System.out.println(Email);
//		Random r = new Random();
//		int num=r.nextInt(1000);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Register")).click();
		
		
		driver.findElement(By.xpath("//label[text()='"+Gender+"']")).click();
		
		
		
		driver.findElement(By.id("FirstName")).sendKeys(FirstName);
		driver.findElement(By.id("LastName")).sendKeys(LastName);
		driver.findElement(By.id("Email")).sendKeys(Email);
		driver.findElement(By.id("Password")).sendKeys(Password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(ConfirmPassword);
		driver.findElement(By.name("register-button")).click();
		
	}

}
