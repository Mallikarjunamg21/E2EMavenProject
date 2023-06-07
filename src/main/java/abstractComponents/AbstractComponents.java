package abstractComponents;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AbstractComponents {
	
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}


	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	public void waitForPresentOfWebElement(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
		wait.until(ExpectedConditions.presenceOfElementLocated(findBy));

	}
	
	public void waitForWebElementToLoad(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
		wait.until(ExpectedConditions.visibilityOfAllElements(findBy));

	}
	

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}

    public String getCurrentUrl() throws InterruptedException
    {
    	String currentUrl =driver.getCurrentUrl();
    	return currentUrl;
    }
    
    public void wait_Element_to_interact(WebElement findBy)
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    	wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }
    
    public Actions actions()
    {
    	Actions action = new Actions(driver);
    	return action;
    	
    }    
    
    public int SelectOptions(WebElement drop) {
    	Select dropdown = new Select(drop);
		ArrayList<String> lis = new ArrayList<String>();
		List<WebElement> Options = dropdown.getOptions();
		for (WebElement opt : Options) {
			String features = opt.getText();
			lis.add(features);
		}
		Collections.sort(lis);
		for (String s : lis) {
			System.out.println(s);
		}
		int count=lis.size();
		return count;
    }
    
    public void getOption(WebElement drop, String a) {
    	Select dropdown = new Select(drop);
    	dropdown.selectByVisibleText(a);
    }
}
