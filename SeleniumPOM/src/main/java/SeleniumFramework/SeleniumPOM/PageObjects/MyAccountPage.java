package SeleniumFramework.SeleniumPOM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	private WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='link-overlay' and contains(@href,'wishlist')]")
	WebElement wishList;

	public MyWishListPage WishList() {
		wishList.click();
		MyWishListPage myWish=new MyWishListPage(driver);
		return myWish;
	}
	
}
