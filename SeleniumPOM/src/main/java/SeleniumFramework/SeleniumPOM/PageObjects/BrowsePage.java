package SeleniumFramework.SeleniumPOM.PageObjects;

import java.util.*;

import javax.swing.RowFilter.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.SeleniumPOM.TestBase;

public class BrowsePage extends TestBase{
	
	private WebDriver driver;

	public BrowsePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='term']")
	WebElement searchBar;
	
	public WebElement getSearchBar() {
		return searchBar;
	}
	
	@FindBy(xpath="//button[@id='search-submit']")
	WebElement goBtn;
	
	public WebElement getGoBtn() {
		return goBtn;
	}
	
	@FindBy(xpath="//h2[@class='title']")
	List<WebElement> eachRowDisplayed;
	
	public List<WebElement> getEachRowDisplayed() {
		return eachRowDisplayed;
	}
	
	public Map<String,String> getDisplayedRows(){
		
		Map<String,String> titleAuthorMap=new HashMap<String,String>();
		System.out.println(eachRowDisplayed.size());
		
		for(WebElement row:eachRowDisplayed) {
			//https://stackoverflow.com/questions/8577636/select-parent-element-of-known-element-in-selenium
//			WebElement parent = row.findElement(By.xpath("./.."));
			
			WebElement parent1 = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].parentNode;", row);
			
			String author=parent1.findElement(By.xpath("//div//a")).getText();
			System.err.println(author);
			String title=row.findElement(By.xpath("//strong")).getText();
			titleAuthorMap.put(title, author);
		}
		System.out.println(titleAuthorMap.size());
		titleAuthorMap.forEach((k,v)->System.out.println(k+"	"+v));
		
		Iterator<java.util.Map.Entry<String, String>> it=titleAuthorMap.entrySet().iterator();
		while(it.hasNext()) {
			java.util.Map.Entry<String, String> a = it.next();
			System.out.println(a.getKey()+"		"+a.getValue());
		}
		
		return titleAuthorMap;
		
	}
	

}
