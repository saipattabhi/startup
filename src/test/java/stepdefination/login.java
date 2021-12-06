package stepdefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Landingpage;
import pageobjects.Loginpage;
import pageobjects.MyAccountpage;
import resources.base;

public class login extends base {
	Landingpage landingpage;
	Loginpage loginpage;
	WebDriver driver;
	MyAccountpage accountpage;

	@Given("^open any browser$")
	public void open_any_browser() throws IOException {

		driver = intializedriver();
		

	}

	@And("^navigate to login page$")
	public void navigate_to_login_page() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		landingpage = new Landingpage(driver);
		landingpage.myAccountDropdown().click();
		landingpage.loginButton().click();
		Thread.sleep(3000);

	}

	@When("^User enter username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void User_enter_username_as_something_and_password_as_something_into_the_fields(String email,
			String password) {
		loginpage = new Loginpage(driver);
		loginpage.emailfield().sendKeys(email);
		loginpage.passwordfield().sendKeys(password);
	}

	@And("^User click on login button$")
	public void User_click_on_login_button() {
		loginpage.loginfield().click();

	}

	  @Then("^User sucessfully see login status$")
	public void User_sucessfully_see_login_status() {
		accountpage = new MyAccountpage(driver);
		Assert.assertTrue(accountpage.myAccountfield().isDisplayed());
	}

	@After
	public void closure() {
		driver.close();
	}

}
