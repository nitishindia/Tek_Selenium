package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_AddProductInCard {

	public static void main(String[] args) throws IOException {


		FileInputStream fis = new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\TekPyramid_Qspider\\src\\test\\resources\\Demo_LoginData");

		Properties p = new Properties();
		
		p.load(fis);
		String UserName = p.getProperty("Email");
		String Pass = p.getProperty("Password");
		
		//System.out.println(UserName);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(UserName);
		driver.findElement(By.id("Password")).sendKeys(Pass);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.partialLinkText("Books")).click();
		driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]")).click();
		
	}

}
