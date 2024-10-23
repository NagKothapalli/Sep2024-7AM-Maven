package com.Sep2024_7AM_Maven;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
	public void launchApplication()
	{
		System.out.println("Launch Application");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.apsrtconline.in/");
		driver.findElement(By.xpath("//input[@name='source']")).sendKeys("HYDERABAD");
		
	}
	
}
