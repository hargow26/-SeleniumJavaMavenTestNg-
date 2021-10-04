package SeleniumFramework.SeleniumPOM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**Object repository of webElements found in the login page of the ebook.comwe app
 * 
 * @author Harish Gowda S
 *
 */
public class LoginPage {
	
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='Username1']")
	WebElement username;
	
	@FindBy(xpath = "//div[text()='Continue']")
	WebElement continueBtn;
	
	@FindBy(xpath="//input[@id='Password2']")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Sign In']")
	WebElement signIn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignIn() {
		return signIn;
	}

}
