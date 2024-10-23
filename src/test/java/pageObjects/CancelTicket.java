package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import webdriverUtilities.Base;
import webdriverUtilities.DriverUtilities;

public class CancelTicket
{
	Base base;
	public CancelTicket(Base base) // 1234
	{
		this.base = base;
	}
	
	//************************************************
	String cancelTLNxpath = "//a[@title='Cancel Ticket']";
	
	//**************************************************
	public void navigateToCancelPage()
	{
		System.out.println("RC : Navigate to Cancel Ticket Page");
		Reporter.log("Step : Navigate to Cancel Ticket Page");
		base.driverUtilities.clickElement(cancelTLNxpath);
		String path = base.driverUtilities.takeErrorScreenShot("CancelTicket");
		Reporter.log(path);
	}
	
	public void cancelBusTicket()
	{
		System.out.println("RC : Cancel Bus Ticket");
		Reporter.log("Step : Cancel Bus Ticket");
	}

}
