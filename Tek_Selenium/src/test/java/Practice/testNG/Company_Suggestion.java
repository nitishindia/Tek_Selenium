package Practice.testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Company_Suggestion {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://identity.worldatwork.org/auth/Register");
		
		Actions a = new Actions(driver);
		a.scrollToElement(driver.findElement(By.id("passwordRegister"))).perform();
		driver.findElement(By.id("Company")).sendKeys("world");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='option'][1]")).click();
	}

}
