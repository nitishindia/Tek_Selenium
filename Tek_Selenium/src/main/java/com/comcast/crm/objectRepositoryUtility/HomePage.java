package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver){			// Rule-3 object Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admistrator;
	
	
	@FindBy(linkText = "Sign Out")
	private WebElement signout;
	
	

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getAdmistrator() {
		return admistrator;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContlink() {
		return contactlink;
	}
	

	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(getAdmistrator()).perform();
		getSignout().click();
		
	}
	
}
