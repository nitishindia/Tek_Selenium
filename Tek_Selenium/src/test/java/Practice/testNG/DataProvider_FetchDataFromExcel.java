package Practice.testNG;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataProvider_FetchDataFromExcel {
	
	
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
	public Object[][] data() throws EncryptedDocumentException, IOException {
		
		ExcelUtility eu = new ExcelUtility();
		int rowcount = eu.getRowcount("Product_DP");
	
		Object[][] obj = new Object[rowcount][2];
		
		for(int i=0; i<rowcount; i++) {
			
			obj[i][0] = eu.getDataFromExcel("Product_DP", i+1, 0);
			obj[i][1] = eu.getDataFromExcel("Product_DP", i+1, 1);
		}
		
		return obj;
	}

}
