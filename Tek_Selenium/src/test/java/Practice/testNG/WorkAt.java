package Practice.testNG;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WorkAt {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://identity.worldatwork.org/Auth/Login");
		driver.findElement(By.id("username")).sendKeys("Nitish");
		driver.findElement(By.id("password")).sendKeys("Nitish@111");
		
	
		Actions actions = new Actions(driver);
		actions.scrollToElement(driver.findElement(By.xpath("//button[text()='Submit']"))).perform();
		Thread.sleep(2000);
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,500)");
		
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	//	driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
