package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-email")
	private WebElement emailfield;

	@FindBy(id = "input-password")
	private WebElement passwordfield;
	@FindBy(css = "input[value='Login']")
	private WebElement loginfield;

	public WebElement emailfield() {
		return emailfield;
	}

	public WebElement passwordfield() {
		return passwordfield;
	}

	public WebElement loginfield() {
		return loginfield;
	}

}
