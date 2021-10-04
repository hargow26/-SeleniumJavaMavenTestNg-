package SeleniumFramework.SeleniumPOM.PageObjects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Includes all the webElements present in the Results page of the ebooks.com website
 * @author Harish Gowda S
 *
 */
public class ResultsPage {
	
	private WebDriver driver;

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='wishlist-add']")
	List<WebElement> wishList;
	
	public List<WebElement> getWishList() {
		return wishList;
	}
	
	@FindBy(xpath="//h2[@class='title']//strong")
	List<WebElement> eachRowDisplayed;
	
	public List<WebElement> getEachRowDisplayed() {
		return eachRowDisplayed;
	}
	
	@FindBy(xpath="//div[@class='btn btn-secondary' and text()='Add']")
	WebElement addBtn;
	
	public WebElement getAddbtn() {
		return addBtn;
	}
	
	@FindBy(xpath="//div[@class='btn btn-default' and text()='Close']")
	WebElement closeBtn;
	
	public WebElement getCloseBtn() {
		return addBtn;
	}
	

	public Multimap<String, String> getDisplayedRows() {

		Map<String, String> titleAuthorMap1 = new HashMap<String, String>();

		Multimap<String, String> titleAuthorMap = ArrayListMultimap.create();

		for (int i = 0; i < eachRowDisplayed.size(); i++) {

			// https://stackoverflow.com/questions/8577636/select-parent-element-of-known-element-in-selenium
//			WebElement parent = row.findElement(By.xpath("./.."));

			WebElement parent1 = (WebElement) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].parentNode;",
					(WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;",
							(WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;",
									eachRowDisplayed.get(i))));

			String author = parent1.findElement(By.xpath("//div[@class='author']//a")).getText();
			
			String title = eachRowDisplayed.get(i).getText();
			
			titleAuthorMap.put(title, author);
		}
		
		titleAuthorMap.forEach((k, v) -> System.out.println(k + "	" + v));

		Iterator<java.util.Map.Entry<String, String>> it = titleAuthorMap.entries().iterator();
		while (it.hasNext()) {
			java.util.Map.Entry<String, String> a = it.next();
			System.out.println(a.getKey() + "		" + a.getValue());
		}

		return titleAuthorMap;

	}

}
