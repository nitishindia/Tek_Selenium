package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver){			// Rule-3 object Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	
	

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	// Business method-> this method is specific to application
	
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	
	
	public void createOrg(String orgName , String industry) {
		
		orgNameEdt.sendKeys(orgName);
		Select s = new Select(industryDropDown);
		s.selectByVisibleText(industry);
		saveBtn.click();
	}
	

}
