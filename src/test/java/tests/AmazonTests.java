package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

import TestComponents.BaseTest;
import pageObjects.amazonPage;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AmazonTests extends BaseTest {

	amazonPage a;
	@Test(priority = 1)
	public void validate_pageTitle() {

		String Actual_Title = driver.getTitle();
		String Expected_Title = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		AssertJUnit.assertEquals(Actual_Title, Expected_Title);
	}

	@Test(invocationCount = 10)
	public void validate_SearchDropdownOptions() {
		amazonPage a= new amazonPage(driver);
		a.SelectOptions(a.searchDropdown());	
	}
	
	@Test(dataProvider="item")
	public void validate_SelectitemfromDropdown(String data) throws InterruptedException {
		Thread.sleep(3000);
		amazonPage a= new amazonPage(driver);
		String value = data;
		a.getOption(a.searchDropdown(), value);
		String Actual= a.searchDropdownPlaceHolder();
		String Expected = value;
		AssertJUnit.assertEquals(Actual, Expected);
	}
	
	@DataProvider (name = "item")
    public Object[][] dpMethod(){
	 return new Object[][] {{"Electronics"}, {"Books"}};
    }
	
	@Test(retryAnalyzer = RetryAnalyzerCount.class,description = "Checking the URL, when language is Changed")
	public void validate_Languages() throws InterruptedException {
		amazonPage a= new amazonPage(driver);
		WebElement Language = driver.findElement(By.xpath("//a[@aria-label='Choose a language for shopping.' and @id='icp-nav-flyout']"));
		a.actions().moveToElement(Language).build().perform();
		a.waitForWebElementToAppear(Language);
		WebElement Lang = driver.findElement(By.xpath("//div[@id='nav-flyout-icp']//span[@dir='ltr' and text()='ಕನ್ನಡ']"));
		Lang.click();
		Thread.sleep(5000);
		String kannadaUrl = "https://www.amazon.in/?language=kn_IN";
		String Actual_Url=driver.getCurrentUrl();
		AssertJUnit.assertEquals(Actual_Url, kannadaUrl);
	}
	
	
}
