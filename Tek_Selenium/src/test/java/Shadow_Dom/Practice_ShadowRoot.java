package Shadow_Dom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice_ShadowRoot {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		// Open ShadowRoot
		
//		driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
//		WebElement Usernamehost = driver.findElement(By.xpath("//form/div"));
//		SearchContext username = Usernamehost.getShadowRoot();
//		username.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("Nitish");
//		
//		WebElement passwordHost = driver.findElement(By.xpath("//form/div[2]"));
//		SearchContext password = passwordHost.getShadowRoot();
//		password.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("java");
//		
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//		driver.quit();
		
		
		// Close ShadowRoot
		
		driver.get("https://demoapps.qspiders.com/ui/shadow/closed?sublist=1");
		driver.findElement(By.xpath("//h1[text()='Login']")).click();
		Actions a = new Actions(driver);
		a.sendKeys(Keys.TAB).sendKeys("java").perform();
		a.sendKeys(Keys.TAB).sendKeys("programing").perform();
	
		
		
	}

}
