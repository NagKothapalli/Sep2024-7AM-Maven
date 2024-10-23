package webdriverUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtilities
{
	//ChromeDriver driver = new ChromeDriver(); // 6789
	WebDriver driver; //null
	WebDriverWait wait;
	Actions actions;
	public DriverUtilities(WebDriver  mydriver)
	{
		driver = mydriver; //1234
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		actions = new Actions(driver);
	}
	public void clickEnter()
	{
		Actions  actions = new Actions(driver); //1234
		actions.pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).build().perform();
	}	
	
	public void clickElement(String myxpath) //abcd
	{
		WebElement element = driver.findElement(By.xpath(myxpath));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public void clickElement(WebElement element) //abcd
	{
		//WebElement element = driver.findElement(By.xpath(myxpath));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}	
	
	//By by = By.xpath("abcd");
	public void clickElement(By by) //abcd
	{
		
		//WebElement element = driver.findElement(By.xpath(myxpath));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}
	
	public void enterText(String myxpath,String mytext)
	{
		WebElement element = driver.findElement(By.xpath(myxpath));
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(mytext);
	}
	
	public void doubleClickElement(String myxpath) //abcd
	{
		WebElement element = driver.findElement(By.xpath(myxpath));
		//wait.until(ExpectedConditions.elementToBeClickable(element));
		actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(element))).doubleClick().build().perform();
	}
	public void rightClickElement(String myxpath) //abcd
	{
		WebElement element = driver.findElement(By.xpath(myxpath));
		actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(element))).contextClick().build().perform();
	}
	
	public void fixedWait(int time)
	{
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String screenshotfilepath;
	public String takeErrorScreenShot(String fname)
	{		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			System.out.println("Local Path :" + new File(".").getCanonicalPath());  // to get the root directory
			screenshotfilepath = new File(".").getCanonicalPath()+"\\ScreenShots\\"+fname+new Random().nextInt(9999)+".png";
			FileUtils.copyFile(scrFile, new File(screenshotfilepath));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}     
        scrFile = null;
        return screenshotfilepath;
	}
	
	
	
	

}
