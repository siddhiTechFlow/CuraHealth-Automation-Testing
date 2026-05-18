package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSD {

	WebDriver driver;

	@Given("user is on application page")
	public void user_is_on_application_page() {

		driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@When("user enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String user, String pass) {

		 driver.findElement(By.id("btn-make-appointment")).click();
	     driver.findElement(By.id("txt-username")).sendKeys(user);
	     driver.findElement(By.id("txt-password")).sendKeys(pass);
		
	}
	
	@When("user enters invalid username {string} and password {string}")
	public void user_enters_invalid_username_and_password(String user, String pass) {

		driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.id("txt-username")).sendKeys(user);
        driver.findElement(By.id("txt-password")).sendKeys(pass);
		
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {

		 driver.findElement(By.id("btn-login")).click();
		
	}
	
	@When("user clicks on book appointment")
	public void user_clicks_on_book_appointment() {

		driver.findElement(By.id("btn-make-appointment")).click();

		
	}


	@Then("user should be logged in successfully")
	public void user_should_be_logged_in_successfully() {

		Assert.assertEquals(driver.getTitle(), "CURA Healthcare Service");
        System.out.println("Smoke Test Passed - Login Successful");
        driver.quit();
		
	}


	@Then("user should see error message")
	public void user_should_see_error_message() {

		boolean isLoginBtnVisible = driver.findElement(By.id("btn-login")).isDisplayed();
        Assert.assertTrue(isLoginBtnVisible);
        System.out.println("Regression Test Passed - Invalid login handled");
        driver.quit();
		
	}


	@Then("appointment page should be displayed")
	public void appointment_page_should_be_displayed() {

		System.out.println("Sanity Test Passed - Appointment page opened");
        driver.quit();

		
	}

}
