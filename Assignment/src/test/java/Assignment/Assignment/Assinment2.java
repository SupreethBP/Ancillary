package Assignment.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assinment2 {
	
	public static void main(String[] args) throws InterruptedException{
       System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in");
		
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("iphone XR (64GB) - Yellow");
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
		WebElement price = driver.findElement(By.xpath("//div[@class='rush-component']//div[@class='rush-component']//div[@class='s-include-content-margin s-border-bottom']//div[@class='a-section a-spacing-medium']//div[@class='sg-row']//div[@class='sg-col-4-of-12 sg-col-8-of-16 sg-col-16-of-24 sg-col-12-of-20 sg-col-24-of-32 sg-col sg-col-28-of-36 sg-col-20-of-28']//div[@class='sg-col-inner']//div[@class='sg-row']//div[@class='sg-col-4-of-24 sg-col-4-of-12 sg-col-4-of-36 sg-col-4-of-28 sg-col-4-of-16 sg-col sg-col-4-of-20 sg-col-4-of-32']//div[@class='sg-col-inner']//div[@class='a-section a-spacing-none a-spacing-top-small']//div[@class='a-row a-size-base a-color-base']//div[@class='a-row']//a[@class='a-size-base a-link-normal s-no-hover a-text-normal']//span[@class='a-price']//span//span[@class='a-price-whole'][contains(text(),'47,900')]"));
		String amazonPrice = price.getText();
		String num="";
		for(int i=0;i<amazonPrice.length();i++)
		{
			char ch= amazonPrice.charAt(i);
			if(Character.isDigit(ch))
			{
				num = num+ch;
			}
		}
		int aPrice=Integer.parseInt(num);
		System.out.println("Amazon price for iphone XR(64GB)"+"="+aPrice);
		
	
		
		driver.get("https://www.flipkart.com");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).build().perform();
		//driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("iphone XR (64GB) - Yellow");
		driver.findElement(By.xpath("//body/div[@id='container']/div/div[@class='_3ybBIU']/div[@class='_1tz-RS']/div[@class='_3pNZKl']/div[@class='Y5-ZPI']/form[@class='_1WMLwI header-form-search']/div[@class='col-12-12 _2tVp4j']/button[@class='vh79eN']/*[1]")).click();
		WebElement price2 = driver.findElement(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
		String flipkartPrice = price2.getText();
		String num2="";
		for(int i=0;i<flipkartPrice.length();i++)
		{
			char ch= flipkartPrice.charAt(i);
			if(Character.isDigit(ch))
			{
				num2 = num2+ch;
			}
		}
		int fPrice=Integer.parseInt(num2);
		System.out.println("Flipkart price for iphone XR(64GB)"+"="+fPrice);
		
		
		if (aPrice>fPrice)
		{
			System.out.println("Flipkart has got less price for iPhone XR 64GB-Yellow");
		}else{
			System.out.println("Amazon has got less price for iPhone XR 64GB-Yellow");
		}
		
		driver.close();
	}

}
