package SeleniumFramework.SeleniumPOM.PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class is an object repository used for storing the webelements present
 * in the landing page of ebooks.com we app
 * 
 * @author Harish Gowda S
 */

public class LandingPage {

	private WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='subjects']")
	WebElement subjects;

	public WebElement getLogin() {
		return subjects;
	}

	@FindBy(xpath = "//div[@id='featuredtitles-slider']//a[contains(@class,'title')]")
	List<WebElement> featuredBooksTitle;

	public List<String> getListOfFeaturedBooks() {
		List<String> featuredBooks = featuredBooksTitle.stream().map(s -> s.getText()).collect(Collectors.toList());
		return featuredBooks;
	}

	/**Identifies all the required genre required in the ebooks website
	 * 
	 * @param takes the required genre string name (eg: Bussiness, History, etc)
	 * @return the WebElement which upon clicked navigates to the genre page
	 */
	public WebElement getParticularGenre(String genre) {
		WebElement genreWebEle = subjects.findElement(By.xpath("//div[@class='subjects']//a[text()='" + genre + "']"));
		return genreWebEle;

	}

	/**Gets list of all genre present in the landing page of the ebook.com website
	 * 
	 * @return List of webElements of all the book genre
	 */
	public List<String> getAllGenre() {
		List<WebElement> allGenre = subjects.findElements(By.tagName("a"));
		List<String> listOfSub = allGenre.stream().map(s -> s.getText()).collect(Collectors.toList());
		return listOfSub;
	}

	/**
	 * Gets list off the required list of genre (Popular or Fiction or NonFiction)
	 * @param subjectType
	 * @return
	 */
	public List<String> getSubjects(String subjectType) {
		WebElement popular = subjects.findElement(By.xpath("//h4[text()='" + subjectType + "']/following-sibling::ul"));
		List<WebElement> popularList = popular.findElements(By.tagName("a"));
		List<String> listOfSub = popularList.stream().map(s -> s.getText()).collect(Collectors.toList());
		return listOfSub;
	}

}
