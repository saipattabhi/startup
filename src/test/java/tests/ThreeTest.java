package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.base;

public class ThreeTest extends base {
  
	public WebDriver driver;
	
	@Test
	public void threetest() throws IOException
	{
		 System.out.println("inside three test");
		 
			
		  driver=	intializedriver();
		  
		  driver.get("http://tutorialsninja.com/demo/");
	}
	
	@AfterMethod
	public void closure()
	{
		driver.close();
	}
	

}
