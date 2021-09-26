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

}
