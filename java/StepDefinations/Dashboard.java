package StepDefinations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.*;
import shabda.TestComponents.BaseTest;
import shabda.pageObjects.LoginPage;

public class Dashboard extends BaseTest{
	BaseTest dr;
	@Given("I landed on shabda login Page with Admin Credentials")
	public void i_landed_on_shabda_login_page_with_admin_credentials() throws IOException, InterruptedException {
		BaseTest dr=new BaseTest();
		dr.launchApplication();
		dr.loginPage.loginApplication("internal.testing@saarthi.ai","saarthi@testing");
		
	}

	@Given("I landed on Dashboard page")
	public void i_landed_on_dashboard_page() {
		System.out.println("Logged In as Admin");
	}

	@When("I Check role of user")
	public String i_check_role_of_user() {
		WebElement role = driver.findElement(By.xpath("//div[contains(@class,'userRoleTitle')]"));
		dr.loginPage.waitForWebElementToAppear(role);
		String loggedInAs = role.getText();
		System.out.println(loggedInAs);
		return loggedInAs;
		
	}

	@Then("I Expect role as {string}")
	public void i_expect_role_as(String string) {
		
		Assert.assertEquals(i_check_role_of_user(), string);
	}



}
