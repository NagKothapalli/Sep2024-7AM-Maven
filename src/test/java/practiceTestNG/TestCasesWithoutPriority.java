package practiceTestNG;

import org.testng.annotations.Test;

public class TestCasesWithoutPriority
{
	@Test
	public void atestCase_1()
	{
		System.out.println("This is my TestCase-1");
	}
	@Test
	public void gtestCase_2()
	{
		System.out.println("This is my TestCase-2");
	}
	@Test
	public void btestCase_3()
	{
		System.out.println("This is my TestCase-3");
	}
	@Test
	public void ktestCase_4()
	{
		System.out.println("This is my TestCase-4");
	}
	@Test   //default priority will be 0
	public void ktestCase_5()
	{
		System.out.println("This is my TestCase-5");
	}
	@Test   //default priority will be 0
	public void ktestCase_7()
	{
		System.out.println("This is my TestCase-7");
	}
	@Test   
	public void ktestCase_6()
	{
		System.out.println("This is my TestCase-6");
	}

}
