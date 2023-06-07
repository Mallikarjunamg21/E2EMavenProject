package TestComponents;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import abstractComponents.AbstractComponents;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest  {



	public WebDriver driver;

	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException

	{
		// properties class

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
		prop.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			options.addArguments("--remote-allow-origins=*"); 
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));// full screen

		} 
		driver.manage().window().maximize();
		return driver;

	}

	@BeforeClass
	public void launchApplication() throws IOException, InterruptedException {

		driver = initializeDriver();
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
		prop.load(fis);
		String Application = System.getProperty("application") != null ? System.getProperty("application")
				: prop.getProperty("application");

		if (Application.contains("myntra")) {
		driver.get("https://www.myntra.com");
		}
		else if(Application.contains("amazon")) {
			driver.get("https://www.amazon.in");
			
		}		
		
	}
	
	@BeforeMethod
	public int methodName() {
		int a = 1;
		return a++;
	}
	
	
	public String getScreenshot(String string, WebDriver driver) throws IOException {
		try {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//screenshots//" + string + ".png");
		FileUtils.copyFile(source, file);
		}
		catch (IOException e) {
            System.out.println(e.getMessage());
        }
		return System.getProperty("user.dir") + "//screenshots//" + string + ".png";

	}

	@AfterMethod
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

	
}
