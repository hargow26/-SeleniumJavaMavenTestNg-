package SeleniumFramework.SeleniumPOM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListPage {
	
	private WebDriver driver;

	public MyWishListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(text(),'Create')]")
	WebElement createNew;
	
	public WebElement getCreateNew() {
		return createNew;
	}
	
	@FindBy(xpath="//input[@id='name']")
	WebElement nameOfList;
	
	public WebElement getNameOfList() {
		return nameOfList;
	}
	
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
