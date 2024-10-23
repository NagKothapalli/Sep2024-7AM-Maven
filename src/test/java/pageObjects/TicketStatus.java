package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import webdriverUtilities.Base;

public class TicketStatus
{
	Base base; // null
	
	public TicketStatus(Base base) // 1234
	{
		this.base = base;
	}
	//*****************WebElements / XPATHs**************************
	
	String ticketStatusTLN = "//a[@title='Ticket Status']";
	
	//******************************************
	public void navigateToTicketStatusPage()
	{
		System.out.println("RC : Navigste To Ticket Status Page");
		Reporter.log("Step : Navigste To Ticket Status Page");
		base.driverUtilities.clickElement(ticketStatusTLN);
		String path = base.driverUtilities.takeErrorScreenShot("TicketStatus");
		Reporter.log(path);
	}
	
	
	public void checkTicketStatus()
	{
		System.out.println("RC : Check the Bus Ticket Status");
		Reporter.log("Step : Check the Bus Ticket Status");
	}

}
