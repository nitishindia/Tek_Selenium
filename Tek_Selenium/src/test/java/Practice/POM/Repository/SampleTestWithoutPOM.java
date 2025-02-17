package Practice.POM.Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestWithoutPOM {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		WebElement ele1 = driver.findElement(By.name("user_name"));
		WebElement ele2 = driver.findElement(By.name("user_password"));
		WebElement ele3 = driver.findElement(By.id("submitButton"));
		
//		ele1.sendKeys("admin");
//		ele2.sendKeys("password");
//		ele3.click();				// it will work fine
			
		
		
		ele1.sendKeys("admin");
		ele2.sendKeys("password");
		
		driver.navigate().refresh();   // org.openqa.selenium.StaleElementReferenceException
		
		ele1.sendKeys("admin");
		ele2.sendKeys("password");
		ele3.click();
			

	}

}
