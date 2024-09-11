package Practice.testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Registration_WorkAt {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://identity.worldatwork.org/auth/register?returnURL=%2F");
		driver.findElement(By.id("FirstName")).sendKeys("Sample");
		driver.findElement(By.id("LastName")).sendKeys("Demo");
		WebElement CountryDropDown = driver.findElement(By.id("Country"));
		Select s = new Select(CountryDropDown);
		s.selectByVisibleText("India");
		
		driver.findElement(By.id("PersonalEmail")).sendKeys("work.at@gmail.com");
		
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		for(;;) {
//		try{
//		driver.findElement(By.xpath("//label[text()='Currently unemployed / Student']")).click();
//		
//		driver.findElement(By.name("Password")).sendKeys("Work@123");
//		driver.findElement(By.id("ConfirmPassword")).sendKeys("Work@123");
//		break;
//		}
//		catch(Exception e){
//			js.executeScript("window.scrollBy(0,100)");	
//		}
//	}
		
	
		Actions a = new Actions(driver);
		// Scrolling upto first checkbox and filling password
		a.scrollToElement(driver.findElement(By.xpath("//label[text()='Currently unemployed / Student']"))).perform();
		
		driver.findElement(By.xpath("//label[text()='Currently unemployed / Student']")).click();
		driver.findElement(By.name("Password")).sendKeys("Work@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Work@123");
		
		Thread.sleep(2000);
		// Scrolling upto create account button and click on it
		a.scrollToElement(driver.findElement(By.xpath("//button[text()='Create Account']"))).perform();
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
	}
}
