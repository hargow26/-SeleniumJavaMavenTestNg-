package SeleniumFramework.SeleniumPOM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * All the webElements found in the navigation bar present in the ebook.com website
 * @author Harish Gowda S
 *
 */
public class NavigationBarComopnent {

	private WebDriver driver;

	public NavigationBarComopnent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Browse')]")
	WebElement browse;

	public BrowsePage getBrowsePage() {
		browse.click();
		return new BrowsePage(driver);
	}
	
	@FindBy(xpath = "//a[@id='login']")
	WebElement loginBtn;
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	/**
	 * takes the username and password and logs into the application using the webElements present in the MyLogin page
	 * @param username
	 * @param password
	 * @return
	 * @throws InterruptedException
	 */
	public MyAccountPage login(String username, String password) throws InterruptedException {
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.getUsername().sendKeys(username);

		Thread.sleep(2000);

		loginPage.getContinueBtn();
		
		loginPage.getContinueBtn().click();

		loginPage.getPassword().sendKeys(password);

		loginPage.getSignIn().click();
		
		return new MyAccountPage(driver);
	}

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Gift Cert')]")
	WebElement giftCertificate;

	public WebElement getGiftCertificate() {
		return giftCertificate;
	}

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'DRM-Free Books')]")
	WebElement drmFreeBooks;

	public WebElement getDrmFreeBooks() {
		return drmFreeBooks;
	}

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Feedback')]")
	WebElement feedback;

	public WebElement getFeedback() {
		return feedback;
	}

	@CacheLookup
	@FindBy(xpath = "//a[@href='https://about.ebooks.com/']")
	WebElement aboutUs;

	public WebElement getAboutUs() {
		return aboutUs;
	}

	@FindBy(xpath = "//div[@class='pull-right']//a[contains(text(),'Create')]")
	WebElement createNewUser;

	public WebElement getCreateNewUser() {
		return createNewUser;
	}

	@FindBy(xpath = "//span[@id='account-menu-dropdown']")
	WebElement profile;

	public WebElement getProfile() {
		return profile;
	}
	
	@CacheLookup
	@FindBy(xpath = "//ul[@class='dropdown-menu']//a[@id='logout']")
	WebElement logout;

	public WebElement getLogout() {
		return logout;
	}

}
