package testSuites;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;

import generalUtilities.GeneralUtility;
import testScenarios.TestCases;
import webdriverUtilities.Base;
//             child                parent
public class TestBatches //extends TestCases
{
	
	//String env;
	// testingType;
	//String browser;
	//Read all config data before the execution
	//GeneralUtility config ;
	//GeneralUtility data ;	
	TestCases testCases;
	Base base;	
	public TestBatches()
	{
		base = new Base();	
		testCases = new TestCases(base);
	}
	
	
	@BeforeMethod
	public void preExecutions()
	{
		testCases.preTestExecutions();

	}
	@AfterMethod
	public void postExecutions()
	{
		testCases.postTestExecutions();
	}
	
	@Test
	public void runUserChoice()
	{
		if(base.testingType.equalsIgnoreCase("SMOKE")) {
			smokeSuite();
		}
		else if(base.testingType.equalsIgnoreCase("REGRESSION")) {
			regressionSuite();
		}
		else {
			System.out.println("Wrong Testing type passed by the user , default suite will be executed");
			smokeSuite();
		}
	}
	@Test
	public void smokeSuite()
	{
		System.out.println("Test Suite : SMOKE");
		testCases.bookTicketAndPrint();
		testCases.bookTicketAndCancel();
		testCases.bookTicketAndCheckStatus();
	}
	
	@Test
	public void regressionSuite()
	{
		System.out.println("Test Suite : REGRESSION");
		testCases.bookTicketAndPrint();
		testCases.bookTicketAndCancel();
		testCases.bookTicketAndCheckStatus();
		testCases.bookTicketAndTrackService();
		testCases.bookTicketCheckStatusAndPrint();
	}

}
