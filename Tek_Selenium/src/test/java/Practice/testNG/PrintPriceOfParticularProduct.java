package Practice.testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintPriceOfParticularProduct {
	
	
	@Test
	public void getProductInfo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		//search for product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone",Keys.ENTER);
		
		//capture product info
		String x = "//span[text()='Apple iPhone 15 (128 GB) - Black']/../../../../div[3]/div[1]/div[1]/div[1]/div/div/a/span/span[2]/span[2]"; 
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		
		
	}

}
