package Assignment.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	public void openApp(){
	//System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			
			//driver = new FirefoxDriver();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.manage().window().maximize();
			
			driver.get("https://tripadvisor.in/");
	}
}
