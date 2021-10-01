package SeleniumFramework.SeleniumPOM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SeleniumFramework.SeleniumPOM.PageObjects.MyAccountPage;
import SeleniumFramework.SeleniumPOM.PageObjects.MyWishListPage;
import SeleniumFramework.SeleniumPOM.PageObjects.NavigationBarComopnent;
import SeleniumFramework.SeleniumPOM.utils.TestUtils;

public class TestCase_002 extends TestBase {

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
	public void creatWishList() {
		try {

			NavigationBarComopnent navComp = new NavigationBarComopnent(driver);

			WebDriverWait eWait = explicitWait(TestUtils.longWait);
			
			eWait.until(ExpectedConditions.elementToBeClickable(navComp.getLoginBtn()))	;
			
			navComp.getLoginBtn().click();
			
			MyAccountPage myAccount=navComp.login("harishgowdas2607@gmail.com","PracticeDaily10");
			
			MyWishListPage myWish=myAccount.WishList();
			
			myWish.getCreateNew().click();
			
			myWish.getNameOfList().sendKeys("WishList1");
			
			myWish.getSaveBtn().click();

			navComp.getProfile().click();

			navComp.getLogout().click();
		}

		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
