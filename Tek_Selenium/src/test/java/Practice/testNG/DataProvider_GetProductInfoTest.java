package Practice.testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class DataProvider_GetProductInfoTest {
	
	@Test (dataProvider = "data" )
	public void getProductInfo(String brand, String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		//search for product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brand,Keys.ENTER);
		
		//capture product info
		String x = "//span[text()='"+productName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div/div/a/span/span[2]/span[2]"; 
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);	
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] data() {
		
		Object[][] obj = new Object[3][2];
		obj[0][0] = "iphone";
		obj[0][1] = "Apple iPhone 15 (128 GB) - Black";
		
		obj[1][0] = "Xiomi";
		obj[1][1] = "Redmi 12 5G Moonstone Silver 8GB RAM 256GB ROM";
		
		obj[2][0] = "iphone";
		obj[2][1] = "Apple iPhone 13 (128GB) - Starlight";
		
		return obj;
	}

}
