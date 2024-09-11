package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.objectRepositoryUtility.HomePage;

import vtiger.ObjectRepository.ContactsPage;

public class CreateContactTest_ByTestNG extends BaseClass {

	@Test
	public void createContact() throws IOException {

		String lastname = eLib.getDataFromExcel("contact", 1, 2)+ jLib.getRandomNumber();
		
		// navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContlink().click();
		
		// click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactsLogo().click();
		
		// create all the deatils & create new contacts
		driver.findElement(By.name("lastname")).sendKeys(lastname);

		// Save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (name.contains(lastname)) {
			System.out.println(name + "Contact created successfully");
		} else {
			System.out.println(name + "Fail to create contact");
		}

		


	}

}
