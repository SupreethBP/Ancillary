package Assignment.Assignment;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://tripadvisor.in/");
		
		WebElement search1 = driver.findElement(By.xpath("//span[@class='brand-global-nav-action-search-Search__label--3PRUD']"));
		search1.click();
		WebElement mainSearch = driver.findElement(By.xpath("//input[@id='mainSearch']"));
		Thread.sleep(5000);
		mainSearch.click();
		mainSearch.sendKeys("Club Mahindra");
		Thread.sleep(5000);
//		WebElement first = driver.findElement(By.xpath("//span[contains(text(),'Madikeri, India')]"));
//		Thread.sleep(10000);
//		first.click();
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='resultContainer local']//li"));
		Thread.sleep(5000);
		
		WebElement firstItem=list.get(0);
		firstItem.click();
		driver.findElement(By.xpath("//span[@class='hotels-hotel-review-atf-info-parts-Rating__reviewCount--1sk1X'] ")).click();
		driver.findElement(By.xpath("//a[@class='ui_button primary']")).click();
		
		Actions actions = new Actions(driver);
		
	Thread.sleep(5000);
	
	Set<String> pages= driver.getWindowHandles();
	int size = pages.size();
	System.out.println(size);
	for(String page:pages){
		driver.switchTo().window(page);
	}
	
	WebElement review = driver.findElement(By.xpath("//span[@id='bubble_rating']"));
	Thread.sleep(5000);
    actions.moveToElement(review).click().build().perform();
	    
   driver.findElement(By.xpath("//input[@id='ReviewTitle']")).sendKeys("Experience");
   driver.findElement(By.xpath("//textarea[@id='ReviewText']")).sendKeys("Great place to hangout with family and friends. Service is good, worth visiting");
   
   WebElement hotelReview = driver.findElement(By.xpath("//div[contains(text(),'Hotel Ratings')]"));
   int loc=hotelReview.getLocation().getY();
   System.out.println(loc);
   JavascriptExecutor js = (JavascriptExecutor)driver;
   Thread.sleep(5000);
   js.executeScript("scroll(0,1469)");
   
   WebElement service = driver.findElement(By.xpath("//span[@id='qid12_bubbles']"));
   actions.moveToElement(service).click().build().perform();
   WebElement submit = driver.findElement(By.xpath("//input[@id='noFraud']"));
   submit.click();
   driver.quit();
	}

}
