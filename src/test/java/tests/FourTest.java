package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.base;

public class FourTest extends base {
	
	public WebDriver driver;
	
	@Test
	public void Fourtest() throws IOException
	{
		System.out.println("inside four test");
		
	  driver=	intializedriver();
	  
	  driver.get("http://tutorialsninja.com/demo/");
		
	  Assert.assertTrue(false);
		
	}
	
	@AfterMethod
	public void closure()
	{
		driver.close();
	}

}
