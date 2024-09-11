package Shadow_Dom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CloseShadowRoot_Example {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/shadow/closed?sublist=1");
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//form/div[1]")).getShadowRoot().findElement(By.cssSelector("input[placeholder='Enter your username']")).sendKeys("java");

		driver.findElement(By.xpath("//img[@alt='signin']")).click();
		Actions a = new Actions(driver);
		a.sendKeys(Keys.TAB).sendKeys("java").perform();
		Thread.sleep(3000);
		a.sendKeys(Keys.TAB).sendKeys("Testing").perform();
	}

}
