package shabda.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.reactivex.rxjava3.functions.Action;
import shabda.TestComponents.BaseTest;
import shabda.pageObjects.AssignProjectsPage;
import shabda.pageObjects.AudioChunkPage;
import shabda.pageObjects.LoginPage;


public class Annotation extends BaseTest {


	AssignProjectsPage AssignProject;
	AudioChunkPage AudioPage;
	
	@Test
	public void CreateUtterance() throws InterruptedException {
		loginPage.loginApplication("shabdannotator@gmail.com", "test@123");
		AssignProject = new AssignProjectsPage(driver);
		AssignProject.getSelectedProjectName("Debt-Collection-Hindi");
		AudioPage = new AudioChunkPage(driver);
		AudioPage.getProjectSelected();
//		AudioPage.getOpenSession();
//		AudioPage.selectOneSession();
		AudioPage.UttranceAIAgent();
		AudioPage.UttranceCustumerAgent();
		AudioPage.AddTag();
	}
	
}

