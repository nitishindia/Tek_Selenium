package com.comcast.crm.contact.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationsPage;

public class Delete_OrgTest {

	public static void main(String[] args) throws IOException {

		ExcelUtility EU = new ExcelUtility();
		FileUtility FU = new FileUtility();
		WebDriverUtility wd = new WebDriverUtility();
		JavaUtility JU = new JavaUtility();

		// property file

		String BROWSER = FU.getDataFromPropertiesFile("browser");
		String URL = FU.getDataFromPropertiesFile("url");
		String USERNAME = FU.getDataFromPropertiesFile("username");
		String PASSWORD = FU.getDataFromPropertiesFile("password");

		// excel file
		String Company = EU.getDataFromExcel("org", 1, 2) + JU.getRandomNumber();

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		// Launch Browser
		driver.manage().window().maximize();
		wd.waitForPageToLoad(driver);
		driver.get(URL);

		// Login to Application
		LoginPage lp = new LoginPage(driver);
//			 lp.getUserNameEdt().sendKeys("admin");
//			 lp.getPassswordEdt().sendKeys("password");
//			 lp.getLoginBtn().click();
		lp.loginToapp("admin", "password");

		// Click on organization
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		// click on organization look image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// fill mandatory field
		CreateNewOrganizationPage cn = new CreateNewOrganizationPage(driver);
		cn.createOrg(Company);

		// save & verify
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actualOrgName = oip.getHeaderMsg().getText();
		if (actualOrgName.contains(Company)) {
			System.out.println(Company + "name is verified == PASS");
		} else {
			System.out.println(Company + "name is not verified == Fail");
		}

		// go back to Organization page
		hp.getOrglink().click();
		
		// search for organization
		
		wd.select(op.getSearchDropDown(), "Organization Name");
		op.getSearchText().sendKeys(Company);
		op.getSearchBtn().click();
		
		// in dynamic webtable select & delete org
		driver.findElement(By.xpath("//a[text()='facebook_1451']/../../td[8]/a[text()='del']")).click();

		// logout

//			HomePage hp1 = new HomePage(driver);
//			WebElement admin = hp1.getAdmistrator();
//			 Actions a = new Actions(driver);
//			 a.moveToElement(admin).perform();
//			 hp1.getSignout().click();

		// OR -> we can use Business method-> this method is specific to application

//			 hp.logout();

		// Close the browser
//		driver.quit();

	}

}
