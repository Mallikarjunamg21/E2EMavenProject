package shabda.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.reactivex.rxjava3.functions.Action;
import shabda.TestComponents.BaseTest;
import shabda.abstractComponents.AbstractComponents;
import shabda.pageObjects.AssignProjectsPage;
import shabda.pageObjects.AudioChunkPage;
import shabda.pageObjects.LoginPage;

public class AssignedProject extends BaseTest {

	AssignProjectsPage AssignProject;
	AudioChunkPage AudioPage;

	@Test
	public void assignedProjectTitle() throws IOException, InterruptedException {
		loginPage.loginApplication("shabdannotator@gmail.com", "test@123");
		AssignProject = new AssignProjectsPage(driver);
		String actualUrl = AssignProject.getCurrentUrl();
		String expectedUrl = "https://qa.shabda.ai/view/projects";
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test
	public void validateProjectName() {
		loginPage.loginApplication("shabdannotator@gmail.com", "test@123");
		AssignProject = new AssignProjectsPage(driver);
		String expectedProjectText = AssignProject.getSelectedProjectName("Debt-Collection-Hindi");
		AudioPage = new AudioChunkPage(driver);
		String actualProjectName = AudioPage.getProjectSelected();
		Assert.assertEquals(actualProjectName, expectedProjectText);
	}

	@Test
	public void validateProjectTotalCount() throws InterruptedException {
		loginPage.loginApplication("shabdannotator@gmail.com", "test@123");
		AssignProject = new AssignProjectsPage(driver);
		String expectedProjectText = AssignProject.getSelectedProjectName("Debt-Collection-Hindi");
		AudioPage = new AudioChunkPage(driver);
		AudioPage.getProjectSelected();
		String countsOfSessions= String.valueOf(AudioPage.getSessionIdCount());
		AbstractComponents forhome = new AbstractComponents(driver);
		forhome.home();
		String projectConversations =AssignProject.getProjectAssignedCount("Debt-Collection-Hindi");
		Assert.assertEquals(projectConversations, countsOfSessions);
	}
	
	@Test
	public void validateProjectCompletedCount() throws InterruptedException {
		loginPage.loginApplication("shabdannotator@gmail.com", "test@123");
		AssignProject = new AssignProjectsPage(driver);
		String expectedProjectText = AssignProject.getSelectedProjectName("Debt-Collection-Hindi");
		AudioPage = new AudioChunkPage(driver);
		AudioPage.getProjectSelected();
		List<String> countsOfSessions= AudioPage.getCompeltedSessionIdCount();
		System.out.println(countsOfSessions);
		AbstractComponents forhome = new AbstractComponents(driver);
		forhome.home();
		String projectConversations =AssignProject.getProjectCompletedCount("Debt-Collection-Hindi");
		//Assert.assertEquals(projectConversations, countsOfSessions);
	}
	
	
	
	

	
}