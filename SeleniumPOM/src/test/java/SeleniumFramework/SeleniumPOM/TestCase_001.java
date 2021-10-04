package SeleniumFramework.SeleniumPOM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import SeleniumFramework.SeleniumPOM.TestBase;
import SeleniumFramework.SeleniumPOM.PageObjects.LandingPage;
import SeleniumFramework.SeleniumPOM.PageObjects.NavigationBarComopnent;
import SeleniumFramework.SeleniumPOM.utils.TestUtils;
import SeleniumFramework.SeleniumPOM.PageObjects.LoginPage;

/**
 * This test case includes logging into the website, validating the title,
 * validating the logged in user and logging out of the application successfully
 * Used data provider for the username and password data
 * 
 * @author Harish Gowda S
 *
 */
public class TestCase_001 extends TestBase {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {
		this.driver = initialization();
		log.info("Driver is initialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigating to home page");
	}

	@Test(dataProvider = "getData")
	public void login(String username, String password) throws IOException, InterruptedException {

		LandingPage ln = new LandingPage(driver);

		ln.getSubjects(TestUtils.poular);

		SoftAssert softAssert = new SoftAssert();

		String title = driver.getTitle();

		log.info("Validating the title of the page");
		softAssert.assertTrue(title.contains("eBooks.com"));

		NavigationBarComopnent navComp = new NavigationBarComopnent(driver);

		// Explicit wait while using page factory model
		// https://stackoverflow.com/a/54177337/17003989

		WebDriverWait eWait = explicitWait(TestUtils.longWait);

		eWait.until(ExpectedConditions.elementToBeClickable(navComp.getLoginBtn()));

		navComp.getLoginBtn().click();

		log.info("Logging in to the account");

		navComp.login(username, password);

		eWait.until(ExpectedConditions.elementToBeClickable(navComp.getProfile()));

		log.info("Validating successful login");

		Assert.assertEquals(navComp.getProfile().getText(), username, "User  failed to logged in");

		navComp.getProfile().click();

		navComp.getLogout().click();

		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[2][2];

		obj[0][0] = "DummyAccount@gmail.com";
		obj[0][1] = "Test@123";
		obj[1][0] = "2ndDummyAccount@gmail.com";
		obj[1][1] = "Test@123";

		return obj;
	}

}
