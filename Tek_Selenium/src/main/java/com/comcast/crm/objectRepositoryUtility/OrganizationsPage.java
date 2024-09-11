package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	WebDriver driver;
	public OrganizationsPage(WebDriver driver){			// Rule-3 object Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewOrgBtn;
	
	@FindBy (name = "search_text")
	private WebElement searchText;
	
	@FindBy (name = "search_field")
	private WebElement searchDropDown;
	
	
	@FindBy (name = "submit")
	private WebElement searchBtn;
	
	
	
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchDropDown() {
		return searchDropDown;
	}

	public WebElement getSearchText() {
		return searchText;
	}
	

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	

}
