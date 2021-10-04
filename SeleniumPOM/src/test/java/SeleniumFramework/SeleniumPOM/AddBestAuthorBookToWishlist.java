package SeleniumFramework.SeleniumPOM;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SeleniumFramework.SeleniumPOM.PageObjects.BrowsePage;
import SeleniumFramework.SeleniumPOM.PageObjects.MyAccountPage;
import SeleniumFramework.SeleniumPOM.PageObjects.NavigationBarComopnent;
import SeleniumFramework.SeleniumPOM.PageObjects.ResultsPage;
import SeleniumFramework.SeleniumPOM.PageObjects.SearchBarComponent;
import SeleniumFramework.SeleniumPOM.utils.TestUtils;

public class AddBestAuthorBookToWishlist extends TestBase {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {
		this.driver = initialization();
		log.info("Driver is initialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigating to home page");
	}

	@Test
	public void addBestAuthorBookToWishlist() {
		try {

			NavigationBarComopnent navComp = new NavigationBarComopnent(driver);

			WebDriverWait eWait = explicitWait(TestUtils.longWait);

			eWait.until(ExpectedConditions.elementToBeClickable(navComp.getLoginBtn()));

			navComp.getLoginBtn().click();

			MyAccountPage myAccount = navComp.login("harishgowdas2607@gmail.com", "PracticeDaily10");

			BrowsePage browsePage = navComp.getBrowsePage();

			browsePage.getBestAuthor().click();
			
			ResultsPage resultPage=new ResultsPage(driver);
			
			List<WebElement> wishList=resultPage.getWishList();
			
			for(WebElement wish:wishList) {
				wish.click();
				resultPage.getAddbtn().click();
				resultPage.getCloseBtn().click();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
