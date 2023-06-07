package shabda.tests;

import java.awt.print.Printable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import shabda.TestComponents.BaseTest;
import shabda.pageObjects.AssignProjectsPage;
import shabda.pageObjects.AudioChunkPage;

public class Admin extends BaseTest {

	@Test(priority = 0)
	public void LoggedInAs() throws InterruptedException {
		loginPage.loginApplication("internal.testing@saarthi.ai", "saarthi@testing");
		WebElement role = driver.findElement(By.xpath("//div[contains(@class,'userRoleTitle')]"));
		loginPage.waitForWebElementToAppear(role);
		String loggedInAs = role.getText();
		System.out.println(loggedInAs);
		Assert.assertEquals(loggedInAs, "Admin");

	}

	@Test()
	public void PravidAddClientPage() throws InterruptedException {
		loginPage.loginApplication("internal.testing@saarthi.ai", "saarthi@testing");
		driver.findElement(By.xpath("//button[text()='Add New Client']")).click();
		driver.findElement(By.xpath("//div[text()='Is Client an existing user of Pravid platform']")).isDisplayed();
		driver.findElement(By.xpath("//div[text()='Yes']")).click();
		String clientPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(clientPageUrl, "https://qa.shabda.ai/adminView/clientsetup?isPravid=true");
	}

	// public void

}
