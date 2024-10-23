package pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import generalUtilities.GeneralUtility;
import webdriverUtilities.Base;
import webdriverUtilities.DriverUtilities;

public class Home
{
    Base base; // instance variable - in blue
	// super is another keyword , which will refer the parent / super class instance variables
   // WebDriver driver; // null
	public Home(Base base) // local variable - in brown // 1234
	{
		this.base = base; // pls load the local variable base in to the instance variable base
		//driver = base.driver; // 1234		
	}
	
	//******************************************
	String fromCityxpath = "//*[@size='22' and @name='source']";
	String toCityxpath = "//input[contains(@id ,'toPlaceN')]";
	String openCalxpath = "//input[@id='txtJourneyDate']";
	String jdatexpath = "//a[text()='20']"; // Date hardcoded
	String searchBtnxpath = "//input[@id='searchBtn']";
	String timeTableTLNxpath = "//a[@title='TimeTable / Track']";
	String allServicesXpath = "//a[text()='All services Time Table & Tracking']";
	String homeTLNxpath = "//a[@title='Home']";
	
	//********************************************

	public void navigateToHome()
	{		
		System.out.println("RC : Navigate to Home Page");
		//base.driver.findElement(By.xpath("//a[@title='Home']")).click();
		base.driverUtilities.clickElement(homeTLNxpath);
		//driverUtilities.clickElement(homeTLNxpath);
		String path = base.driverUtilities.takeErrorScreenShot("HomePage");		
		Reporter.log("User Navigated to Home page , : "+path);			
	}
	
	public void bookTicket()
	{
		System.out.println("RC : Book Bus Ticket");
		Reporter.log("Step : Book Bus Ticket");
		base.driverUtilities.enterText(fromCityxpath,base.data.readData("FromCity"));	// Hard coded test data 	
		base.driverUtilities.clickEnter();
		base.driverUtilities.enterText(toCityxpath,base.data.readData("ToCity")); // Hard coded test data
		base.driverUtilities.clickEnter();
		base.driverUtilities.clickElement(openCalxpath);
		//driverUtilities.clickElement(jdatexpath);
		String jdate = base.data.readData("JDate");
		jdatexpath = "//a[text()='"+jdate+"']";   
		base.driverUtilities.clickElement(jdatexpath);
		base.driverUtilities.clickElement(searchBtnxpath);
		String path = base.driverUtilities.takeErrorScreenShot("BookTicket");
		Reporter.log(path);
		base.driverUtilities.fixedWait(4);		
	}
	
	String fname = "Ram";
	String mname = "Rahim1";
	String lname = "David";
	String name = "Ram" + mname + "David" ;  // Ram Rahim4 David
	
	public void printTicket()
	{
		System.out.println("RC : Print the Ticket");
	}

}
