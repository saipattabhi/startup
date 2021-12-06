package revoke;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datatable {
	
	@Test
	public void datatable()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//table[@id='countries']//td[text()='Kabul']//preceding-sibling::td//input")).click();
		
		
		    List<WebElement> elements = driver.findElements(By.xpath("//table[@id='countries']//tr//td[4]"));
		    
		    
		    for(WebElement list:elements)
		    {
		    String names = list.getText();
		    
		    System.out.println("currency values "+ names);
		    	
		    	
		    }
		    
		
		
		
	}
	
	
	
	
	

}
