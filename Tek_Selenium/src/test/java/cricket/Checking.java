package cricket;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Map<Object,Object> map=new HashMap();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.icc-cricket.com/rankings/team-rankings/mens/t20i");
		driver.manage().window().maximize();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).click();
	//  //div[@class="si-table-data si-team"]/..//div[@class='si-table-data si-pts']
	//	driver.findElement(By.xpath("//div[@class=\"si-table-data si-team\"]/..//div[@class='si-table-data si-pts']")).click();
		List<WebElement> allDetails = driver.findElements(By.xpath("//div[@class=\"si-table-data si-team\"]"));
		List<WebElement> point = driver.findElements(By.xpath("//div[@class='si-table-data si-pts']"));
		List<WebElement> po = driver.findElements(By.xpath("//div[@class=\"si-table-data si-rating\"]"));
		
		
//		int i=0;
//		while (true)  {
//			
//			String p=allDetails.get(i++).getText().toString()+ " : "+point.get(i++).getText().toString();
//			System.out.println(p);
//			
//		}
		
		
//		for(Map.Entry<Object,String> result:map.entrySet()) {
//			System.out.println(result.getKey()+ "  :  "+result.getValue());
//		}
		
		for(WebElement A : allDetails ) {
			
		}
		
		map.put(allDetails.toString(), point.toString());
		System.out.println(map);
		
		
			
	}

}
