package automationpractice.com;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automationpractice {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@AfterClass
	public void down() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test(priority = 1)
	public void positiveLogin() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(ConfigReader.getMyValue("URL"));
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login(ConfigReader.getMyValue("User"), ConfigReader.getMyValue("Password"));
		
		assertTrue(!driver.getTitle().contains("Login"));
	}

}
