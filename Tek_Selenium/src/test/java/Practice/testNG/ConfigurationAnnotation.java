package Practice.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ConfigurationAnnotation {

	
	@BeforeSuite
	public void configBS() {
		System.out.println("===execute BS===");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("===Execute AS===");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("execcute BC");
	} 
	
	@AfterClass
	public void configAC() {
		System.out.println("execcute AC");
	} 
	
	@BeforeMethod
	public void configBM() {
		System.out.println("execcute BM");
	} 
	
	@AfterMethod
	public void configAM() {
		System.out.println("execcute AM");
	} 
	
	@Test
	public void createcontact() {
		System.out.println("execcute createcontact");
	} 
	
	@Test
	public void createcontactWithDAta() {
		System.out.println("execcute createcontactWithDAta");
	} 
	
	
}
