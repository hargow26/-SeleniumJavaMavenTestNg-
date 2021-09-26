package SeleniumFramework.SeleniumPOM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageComponent {

	private WebDriver driver;

	public LandingPageComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='login']")
	WebElement login;

	public WebElement getLogin() {
		return login;
	}

	@FindBy(xpath = "//a[contains(text(),'Browse')]")
	WebElement browse;

	public WebElement getBrowse() {
		return browse;
	}

	@FindBy(xpath = "//a[contains(text(),'Gift Cert')]")
	WebElement giftCertificate;

	public WebElement getGiftCertificate() {
		return giftCertificate;
	}

	@FindBy(xpath = "//a[contains(text(),'DRM-Free Books')]")
	WebElement drmFreeBooks;

	public WebElement getDrmFreeBooks() {
		return drmFreeBooks;
	}

	@FindBy(xpath = "//a[contains(text(),'Feedback')]")
	WebElement feedback;

	public WebElement getFeedback() {
		return feedback;
	}

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
	
	@FindBy(xpath = "//ul[@class='dropdown-menu']//a[@id='logout']")
	WebElement logout;

	public WebElement getLogout() {
		return logout;
	}

}
