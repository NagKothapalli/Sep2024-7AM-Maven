package generalUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GeneralUtility
{	
	public String filePath; // null   
	FileInputStream file;
	Properties myprop;
	
	public GeneralUtility(String path)
	{
		System.out.println("I got the file path :" + path);
		filePath = path;
	}
	
	public String readData(String input) //throws IOException
	{
		try {
			file = new FileInputStream(filePath);
			myprop = new Properties(); // like news reader
			myprop.load(file);
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Message :"+ e);
		}		
		String output = myprop.getProperty(input);
		return output;
	}
	
	public String readData(String input,String filePath) throws IOException
	{
		FileInputStream file = new FileInputStream(filePath); //Like  News paper
		Properties myprop = new Properties(); // like news reader
		myprop.load(file);
		String output = myprop.getProperty(input);
		return output;
	}
	
	public String readData_multictchblocks(String input) //throws IOException
	{
		try {
			file = new FileInputStream(filePath);
			myprop = new Properties(); // like news reader
			myprop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Message :"+ e);
		} //Like  News paper
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String output = myprop.getProperty(input);
		return output;
	}
	
}
