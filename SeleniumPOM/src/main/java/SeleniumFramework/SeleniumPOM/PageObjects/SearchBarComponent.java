package SeleniumFramework.SeleniumPOM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Harish Gowda S
 * This class is store the webelements of search bar component
 *
 */

public class SearchBarComponent {
	
	private WebDriver driver;

	public SearchBarComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="//input[@id='term']")
	WebElement searchBar;
	
	public WebElement getSearchBar() {
		return searchBar;
	}
	
	@CacheLookup
	@FindBy(xpath="//button[@id='search-submit']")
	WebElement goBtn;
	
	public WebElement getGoBtn() {
		return goBtn;
	}
}
