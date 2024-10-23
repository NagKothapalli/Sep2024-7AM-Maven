package practiceTestNG;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTestInTestNG
{
	   @Test(priority=1,enabled=true)
	   public void testcase1(){
	      System.out.println("Testcase 1 - ");
	   }
	   @Test(priority=2 , enabled=true)
	   public void testcase2(){
		  System.out.println("Testcase 2 - ");
	      System.out.println("Testcase 2 - skip exception example");
	     // throw new SkipException("Skipping this exception");
	      System.out.println("Executed Successfully");
	   }
	   @Test(priority=3 , enabled=true)
	   public void testcase3(){
		   System.out.println("Testcase 3 - ");
		   //
		   //
		   //
	      boolean DataAvailable=false;
	      System.out.println("Test Case3 - Conditional Skip");
	      if(!DataAvailable)
	      {
	    	  throw new SkipException("Skipping this exception"); 
	      }	    	  
	      System.out.println("Executed Successfully");
	   }
	   @Test(priority=4 , enabled=true)
	   public void testcase4(){
		  System.out.println("Testcase 4 - ");
	     // throw new SkipException("Skipping this exception");
	      System.out.println("Executed Successfully");
	   }

}
