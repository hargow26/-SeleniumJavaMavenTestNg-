package SeleniumFramework.SeleniumPOM.PageObjects;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is an object reository storing all the webElements present in the
 * browser page of the webApp
 * 
 * @author Harish Gowda S
 *
 */

public class BrowsePage {

	private WebDriver driver;

	public BrowsePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ("//div[@class='author-tile']/a"))
	WebElement bestAuthor;

	public WebElement getBestAuthor() {
		return bestAuthor;
	}

}
