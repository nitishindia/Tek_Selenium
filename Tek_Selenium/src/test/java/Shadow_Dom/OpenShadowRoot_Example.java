package Shadow_Dom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenShadowRoot_Example {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		WebElement host = driver.findElement(By.xpath("//form/div"));
		SearchContext shadow = host.getShadowRoot();
		shadow.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("java");
		
		// For password Shadow root, we can write in one line also
//		driver.findElement(By.xpath("//form/div[2]")).getShadowRoot().findElement(By.cssSelector("input[placeholder=\"Enter your password\"]")).sendKeys("java");
		
		WebElement Password_Host = driver.findElement(By.xpath("//form/div[2]"));
		SearchContext Password_shadow = Password_Host.getShadowRoot();
		Password_shadow.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("Testing");
		
	}

}
