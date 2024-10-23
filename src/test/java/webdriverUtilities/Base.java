package webdriverUtilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import generalUtilities.GeneralUtility;

public class Base
{
	
	public String env; // null
	public String testingType;
	public String browser;
	//Read all config data before the execution
	public GeneralUtility config ;
	public GeneralUtility data ;
	public WebDriver driver ;// null // kone
	public DriverUtilities driverUtilities;
	
	//Interface : WebDriver   , Interface contains only abstract functions .
	
	//Abstract function : A function without body / implementation 
	
	//WebDriver interface contains all the abstract functions which we can do at browser level like - get , findElement , findElements , gettitle , getcurrenturl .....
	
	//WebDriver interface is implemented by the classes indirectly - ChromeDriver , FirefoxDriver , EdgeDriver 
	
	//RemoteWebDriver class implemented WebDriver interface  
	
	//ChromeDriver , FirefoxDriver , EdgeDriver   all these three classes extends RemoteWebDriver class
	
	public Base()
	{
		config = new GeneralUtility("D:\\WorkSpace\\Java\\Sep2024-7AM-Maven\\MyData\\Config.properties"); //fixed path
		env = config.readData("Environment");  // Dev / QA / Stage / Prod
		testingType = config.readData("TestingType");
		browser = config.readData("Browser"); // chrome / firefox / edge 
		driver = getDriver(browser);
		driver.manage().window().maximize();
		data = new GeneralUtility("D:\\WorkSpace\\Java\\Sep2024-7AM-Maven\\MyData\\"+env+".properties");
		driverUtilities = new DriverUtilities(driver);
	}
	
	//WebDriver driver = new ChromeDriver();	
	//ChromeDriver driver = new ChromeDriver();
	
	public WebDriver getDriver(String browser)
	{
		if(config.readData("ExecutionType").equalsIgnoreCase("Local")) {
			driver = getLocalDriver();
		}
		else if(config.readData("ExecutionType").equalsIgnoreCase("Remote"))	{
			driver = getRemoteDriver();
		}
		else
		{
			driver = getLocalDriver();
		}
		
		return driver; // kone and icecream
	}
	
	public WebDriver getLocalDriver()
	{
		if(browser.equalsIgnoreCase("Chrome")) {			
			driver = new ChromeDriver();			
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("User passed wrong browser ");
			driver = new ChromeDriver();
		}
		return driver;
	}
	URL url;
	String s_url = "https://ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	String s_userName = "oauth-nagfeb2021-48d01";
	String s_accessKey = "d5877221-8f48-4b18-9de2-ab3bc6e6e904";
	String s_build = "selenium-build-HQ448";
	String s_name = "NagAutomation";
	public WebDriver getRemoteDriver()
	{		
		try {
			url = new URL(s_url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", s_userName);
		sauceOptions.put("accessKey", s_accessKey);
		sauceOptions.put("build", s_build);
		sauceOptions.put("name", s_name);
		
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("latest");
			browserOptions.setCapability("sauce:options", sauceOptions);
			driver = new RemoteWebDriver(url, browserOptions);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions browserOptions = new FirefoxOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("latest");
			browserOptions.setCapability("sauce:options", sauceOptions);
			driver = new RemoteWebDriver(url, browserOptions);			
		}
		else if(browser.equalsIgnoreCase("edge")) {
			EdgeOptions browserOptions = new EdgeOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("latest");
			browserOptions.setCapability("sauce:options", sauceOptions);
			driver = new RemoteWebDriver(url, browserOptions);			
		}
		else {
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("latest");
			browserOptions.setCapability("sauce:options", sauceOptions);
			driver = new RemoteWebDriver(url, browserOptions);
		}		
		return driver;
	}


}
