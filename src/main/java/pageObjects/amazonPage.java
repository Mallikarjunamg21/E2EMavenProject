package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class amazonPage extends AbstractComponents {

	WebDriver driver;

	public amazonPage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
}

@FindBy(xpath="//select[@title='Search in']")
	WebElement search;

@FindBy(xpath="//span[@id='nav-search-label-id']")
WebElement SearchDropDown_holder_txt;

	public WebElement searchDropdown() {
		return search;
	}
	
	public String searchDropdownPlaceHolder() {
		String value= SearchDropDown_holder_txt.getText();
		return value;
	}
	
	
}
	
