package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_CheckOutPage {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Excel file
		
		FileInputStream fis = new FileInputStream("C:\\Users\\dell\\Desktop\\Demo_RegisterPage1.xlsx");
		
		Workbook w = WorkbookFactory.create(fis);
		
		String Company = w.getSheet("Sheet3").getRow(1).getCell(0).toString();
		String Country = w.getSheet("Sheet3").getRow(1).getCell(1).toString();
		String City = w.getSheet("Sheet3").getRow(1).getCell(2).toString();
		String Add1 = w.getSheet("Sheet3").getRow(1).getCell(3).toString();
		String Add2 = w.getSheet("Sheet3").getRow(1).getCell(4).toString();
		String Zip = w.getSheet("Sheet3").getRow(1).getCell(5).toString();
		String PhoneNo = w.getSheet("Sheet3").getRow(1).getCell(6).toString();
		String Fax = w.getSheet("Sheet3").getRow(1).getCell(7).toString();
		
		
		
		// property file
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\TekPyramid_Qspider\\src\\test\\resources\\Demo_LoginData");
		Properties p = new Properties();
		p.load(fis1);
		String UserName = p.getProperty("Email");
		String Pass = p.getProperty("Password");
		System.out.println(Company);
		
		
		// added product
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(UserName);
		driver.findElement(By.id("Password")).sendKeys(Pass);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.partialLinkText("Books")).click();
		driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]")).click();
		
		//shopping cart
		
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
		
		// checkout page
		
//		driver.findElement(By.id("BillingNewAddress_Company")).sendKeys(Company);
//		driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys(Country);
//		driver.findElement(By.id("BillingNewAddress_City")).sendKeys(City);
//		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(Add1);
//		driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys(Add2);
//		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys(Zip);
//		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(PhoneNo);
//		driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys(Fax);
		driver.findElement(By.xpath("//input[@title='Continue']")).click();
		
		// Billing Address
		
		driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
		
		
		//shipping address
		
		driver.findElement(By.id("PickUpInStore")).click();
		driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
		
		
		// payment method
		
		driver.findElement(By.id("paymentmethod_0")).click();
		driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
		
		//payment information
		
		driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
		
		//Confirm order
		driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
	
		
	}

}
