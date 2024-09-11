package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {    // Rule-1 Create separate java class
	  
	WebDriver driver;
	public LoginPage(WebDriver driver){			// Rule-3 object Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
//	Rule-2 Object Creation
	
	@FindBy (name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passswordEdt;
	
	@FindBy (id = "submitButton")
	private WebElement loginBtn;
	
	// Rule-3 object Initialization     OR  by using constructor.
		// we doing in test script
	
	
	
	
	public WebElement getUserNameEdt() {		// Rule-4 object Encapsulation
		return userNameEdt;						// Rule-5 object Utilization
	}

	public WebElement getPassswordEdt() {
		return passswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule-5 provide Action		// Business method-> this method is specific to application
	public void loginToapp(String username , String password) {
		driver.manage().window().maximize();
		userNameEdt.sendKeys(username);
		passswordEdt.sendKeys(password);
		loginBtn.click();
	}
		
		

}
