package Assignment.Assignment;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Assignment1Pom {
	
	@FindBy(xpath="//span[@class='brand-global-nav-action-search-Search__label--3PRUD']")
	private WebElement search1;
	@FindBy(xpath="//input[@id='mainSearch']")
	private WebElement mainSearch;
	@FindBy(xpath="//ul[@class='resultContainer local']//li")
	private List<WebElement> list;
	@FindBy(xpath="//span[@class='hotels-hotel-review-atf-info-parts-Rating__reviewCount--1sk1X'] ")
	private WebElement review;
	@FindBy(xpath="//a[@class='ui_button primary']")
	private WebElement writeReview;
	@FindBy(xpath="//span[@id='bubble_rating']")
	private WebElement rating;
	@FindBy(xpath="//input[@id='ReviewTitle']")
	private WebElement reviewTitle;
	@FindBy(xpath="//textarea[@id='ReviewText']")
	private WebElement reviewComment;
	@FindBy(xpath="//div[contains(text(),'Hotel Ratings')]")
	private WebElement hotelReview;
	@FindBy(xpath="//span[@id='qid12_bubbles']")
	private WebElement service;
	@FindBy(xpath="//span[@id='qid13_bubbles']")
	private WebElement value;
	@FindBy(xpath="//span[@id='qid14_bubbles']")
	private WebElement cleanliness;
	
	public Assignment1Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void searchButton()
	{
		search1.click();
		mainSearch.click();
		mainSearch.sendKeys("Club Mahindra");
	}
	public void selectFirstItem()
	{
		WebElement firstItem=list.get(0);
		firstItem.click();
	}
	public void reviews(WebDriver driver)
	{
		review.click();
		writeReview.click();
		Set<String> pages= driver.getWindowHandles();
		int size = pages.size();
		System.out.println(size);
		for(String page:pages){
			driver.switchTo().window(page);
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(rating).click().build().perform();
	}
	public void commentsList()
	{
		reviewTitle.sendKeys("Experience review");
		reviewComment.sendKeys("Great place to hangout with familt and friends. Service is good, worth visiting");
	}
	
}
