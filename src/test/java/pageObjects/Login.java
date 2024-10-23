package pageObjects;

import org.testng.Reporter;

import webdriverUtilities.Base;

public class Login
{	  
	Base base;	
	public Login(Base base) // 1234
	{
		this.base = base;
	}
	public void launchApplication()
	{
		System.out.println("RC : Launch Application");
		Reporter.log("Step : Launch Application");
		//driver.get("https://www.apsrtconline.in/");		
		base.driver.get(base.data.readData("URL"));
	}
	
	public void loginToApplication()
	{
		System.out.println("RC : Login To Application");
		Reporter.log("Step : Login to Application");
	}
	
	public void logoutFromApplication()
	{
		System.out.println("RC : Logout From Application");
		Reporter.log("Step : Logout From Application");
	}
	
	public void closeApplication()
	{
		System.out.println("RC : Close Application");
		Reporter.log("Step : Close Application");
	}

}
