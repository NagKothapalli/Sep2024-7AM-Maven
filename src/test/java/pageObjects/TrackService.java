package pageObjects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import webdriverUtilities.Base;

public class TrackService 
{
	Base base;
	
	public TrackService( Base base) // 1234
	{
		this.base = base;
	}
	
	//*****************WebElements / XPATHs**************************
	
		String trackServiceTLN = "//a[@title='Track Service']";
		
		//******************************************
	public void navigateToTrackServicePage()
	{
		System.out.println("RC : Navigate to Track Service Page");
		base.driverUtilities.clickElement(trackServiceTLN);
		Reporter.log("Step : Navigate to Track Service Page");
		String path = base.driverUtilities.takeErrorScreenShot("TrackService");
		Reporter.log(path);
	}
	
	public void trackBusService()
	{
		System.out.println("RC : Track the Bus Service");
		Reporter.log("Step : Track the Bus Service");
	}

}
