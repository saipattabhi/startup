package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelDataConfig.exceldata;
import pageobjects.Landingpage;
import pageobjects.Loginpage;
import pageobjects.MyAccountpage;
import resources.base;

public class LoginTest extends base {

	 public WebDriver driver;
	 Logger log;

	@Test(dataProvider = "getLoginData")

	public void login(String username, String password, String expectedstatus) throws IOException {
		
		Landingpage landingpage = new Landingpage(driver);

		landingpage.myAccountDropdown().click();
		log.debug("my account dropdown clicked");

		landingpage.loginButton().click();
		log.debug("login button clicked");

		Loginpage loginpage = new Loginpage(driver);
		loginpage.emailfield().sendKeys(username);
		log.debug("emailadress got entered");
		loginpage.passwordfield().sendKeys(password);
		log.debug("passwordfield got entered");
		loginpage.loginfield().click();

		MyAccountpage accountpage = new MyAccountpage(driver);
		String actualresult = null;
		try {

			if (accountpage.myAccountfield().isDisplayed())
				
			{
				actualresult = "successfull";
			}
		} catch (Exception e) {
			actualresult = "failure";
		}
		Assert.assertEquals(actualresult, expectedstatus);

	}

	@AfterMethod
	public void closure() {
		driver.close();
	}
	@BeforeMethod
  public void openapplication() throws IOException
  
  {
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = intializedriver();
		
	      
		driver.get(prop.getProperty("url"));
	
		
	 
		
 
  }
	@DataProvider
	public Object[][] getLoginData() throws FileNotFoundException {

		exceldata config = new exceldata("C:\\Users\\saipa\\eclipse-workspace\\TestProject\\Exceldata\\Data.xlsx ");
		int rows = config.getRowCount(0);

		Object[][] data = new Object[rows][3];

		for (int i = 0; i < rows; i++) {
			data[i][0] = config.getexcelData(0, i, 0);
			data[i][1] = config.getexcelData(0, i, 1);
			data[i][2] = config.getexcelData(0, i, 2);
		}

		return data;
	}

}
