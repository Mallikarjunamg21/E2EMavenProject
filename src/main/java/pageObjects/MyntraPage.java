package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class MyntraPage extends AbstractComponents {

	public MyntraPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(xpath = "//*[@data-testid='username']")
	WebElement EmailTextfield;


	public void goTo() {
		driver.get("https://www.myntra.com");
	}

	
}
