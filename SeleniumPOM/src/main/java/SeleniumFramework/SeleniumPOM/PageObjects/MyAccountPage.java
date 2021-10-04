package SeleniumFramework.SeleniumPOM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Object repository for the all the webElements found in the MyAccount page of
 * the ebook.com website
 * 
 * @author Harish Gowda S
 *
 */
public class MyAccountPage {

	private WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='link-overlay' and contains(@href,'wishlist')]")
	WebElement wishList;

	/**
	 * Clicks on the mywishlist link and creates an object for MyWishList page and
	 * return that object when called the method
	 * 
	 * @return
	 */
	public MyWishListPage WishList() {
		wishList.click();
		MyWishListPage myWish = new MyWishListPage(driver);
		return myWish;
	}

}
