package testScenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import pageObjects.CancelTicket;
import pageObjects.Home;
import pageObjects.Login;
import pageObjects.TicketStatus;
import pageObjects.TrackService;
import webdriverUtilities.Base;

public class TestCases //extends Login
{
	//ChromeDriver driver = new ChromeDriver(); // 1234
	Login login ; //1234
	Home home ; //1234
	CancelTicket cancelTicket ; //1234
	TrackService trackService ; //1234
	TicketStatus ticketStatus ; //1234
	
	public TestCases(Base base)
	{		
		login = new Login(base); //1234
		home = new Home(base); //1234
		cancelTicket = new CancelTicket(base); //1234
		trackService = new TrackService(base); //1234
		ticketStatus = new TicketStatus(base); //1234
	}
	
	@Before
	public void preTestExecutions()
	{
		login.launchApplication();

	}
	@After
	public void postTestExecutions()
	{
		login.logoutFromApplication();
	}
	@Test
	public void bookTicketAndPrint()
	{
		System.out.println("Test Case : Book Bus Ticket and Print ");
		Reporter.log("--------------------------------------------------------Test Case : Book Bus Ticket and Print ");
		//launch , login , bookticket , print , logout , close
		//login.launchApplication();
		login.loginToApplication();
		home.navigateToHome();
		home.bookTicket();
		home.printTicket();
		//login.logoutFromApplication();
		login.closeApplication();
	}
	
	@Test
	public void bookTicketAndCancel()
	{
		System.out.println("Test Case : Book Bus Ticket and Cancel ");
		Reporter.log("--------------------------------------------------------Test Case : Book Bus Ticket and Cancel ");
		//login.launchApplication();
		login.loginToApplication();
		home.navigateToHome();
		home.bookTicket();
		cancelTicket.navigateToCancelPage();
		cancelTicket.cancelBusTicket();
		//login.logoutFromApplication();
		login.closeApplication();
	}
	
	@Test
	public void bookTicketAndTrackService()
	{
		System.out.println("Test Case : Book Bus Ticket and Track Service ");
		Reporter.log("--------------------------------------------------------Test Case : Book Bus Ticket and Track Service ");
		//login.launchApplication();
		login.loginToApplication();
		home.navigateToHome();
		home.bookTicket();
		trackService.navigateToTrackServicePage();
		trackService.trackBusService();
		//login.logoutFromApplication();
		login.closeApplication();
	}
	@Test
	public void bookTicketAndCheckStatus()
	{
		System.out.println("Test Case : Book Bus Ticket and Check Status ");
		Reporter.log("--------------------------------------------------------Test Case : Book Bus Ticket and Check Status ");
		//login.launchApplication();
		login.loginToApplication();
		home.navigateToHome();
		home.bookTicket();
		ticketStatus.navigateToTicketStatusPage();
		ticketStatus.checkTicketStatus();
		//login.logoutFromApplication();
		login.closeApplication();

	}
	@Test
	public void bookTicketCheckStatusAndPrint()
	{
		System.out.println("Test Case : Book Bus Ticket Check Status and Print ");
		Reporter.log("--------------------------------------------------------Test Case : Book Bus Ticket Check Status and Print ");
		//login.launchApplication();
		login.loginToApplication();
		home.navigateToHome();
		home.bookTicket();
		home.printTicket();
		ticketStatus.navigateToTicketStatusPage();
		ticketStatus.checkTicketStatus();
		//login.logoutFromApplication();
		login.closeApplication();
	}

}
